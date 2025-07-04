package web.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;
import web.bibliotheque.service.*;
import web.bibliotheque.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/adherent")
public class AdherentController {

    @Autowired
    private ExemplaireService exemplaireService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private TypePretService typePretService;

    @Autowired
    private PretService pretService;

    @GetMapping("/emprunter-livre/{idExemplaire}")
    public String showFormuEmprunt(@PathVariable("idExemplaire") Integer idExemplaire, Model model) {
        // Récupération de l'utilisateur connecté
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest()
                .getSession();
        Integer utilisateurId = (Integer) session.getAttribute("utilisateurId");
        Optional<Utilisateur> utilisateurOpt = utilisateurService.findById(utilisateurId);

        if (utilisateurOpt.isPresent()) {
            Exemplaire exemplaire = exemplaireService.findById(idExemplaire);
            if (exemplaire.getStatut().getNom().equalsIgnoreCase("emprunte")) {
                model.addAttribute("erreur", "Cet exemplaire n'est plus disponible.");
                model.addAttribute("exemplaires", exemplaireService.getAllExemplaires());
                return "exemplaires";
            } else {
                Utilisateur utilisateur = utilisateurOpt.get();
                Profil profilAdherent = utilisateur.getProfil();
                Adherent adherent = utilisateur.getAdherent();
                int nbPretsEnCours = pretService.getNbPretsEnCoursPourAdherent(adherent);
                int quotaPret = profilAdherent.getQuota_pret();
                boolean quotaDisponible = nbPretsEnCours < quotaPret;
                if (!quotaDisponible) {
                    model.addAttribute("erreur",
                            "Votre quota de prêt n'est plus sufffisant pour effectuer un emprunt.");
                    model.addAttribute("exemplaires", exemplaireService.getAllExemplaires());
                    return "exemplaires";
                } else {
                    model.addAttribute("quotaDisponible", quotaDisponible);
                    List<TypePret> typePrets = typePretService.getAllTypePrets();
                    model.addAttribute("exemplaire", exemplaire);
                    model.addAttribute("typePrets", typePrets);
                    return "emprunt-form";
                }
            }
        } else {
            model.addAttribute("erreur", "Aucun utilisateur trouvé.");
            model.addAttribute("exemplaires", exemplaireService.getAllExemplaires());
            return "exemplaires";
        }
    }

    // @PostMapping("/emprunter-livre/{idExemplaire}")
    // public String effectuerEmprunt(@PathVariable("idExemplaire") Integer
    // idExemplaire,
    // @RequestParam("dateDebut") String dateDebut,
    // @RequestParam("typePret") Integer idTypePret,
    // Model model) {
    // // Rediriger ou afficher un message de succès

    // // Si l'adherent est inscrit(à la date par rapoort à la date de début)
    // // S’il n’est pas sous le coup d’une pénalité (date du jour > date_fin de la
    // // dernière pénalité non réglée).
    // //
    // return "redirect:/adherent";
    // }
    @PostMapping("/emprunter-livre/{idExemplaire}")
    public String effectuerEmprunt(@PathVariable("idExemplaire") Integer idExemplaire,
            @RequestParam("dateDebut") String dateDebutStr,
            @RequestParam("typePret") Integer idTypePret,
            Model model) {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getSession();
        Integer utilisateurId = (Integer) session.getAttribute("utilisateurId");

        Optional<Utilisateur> utilisateurOpt = utilisateurService.findById(utilisateurId);
        if (utilisateurOpt.isEmpty()) {
            model.addAttribute("erreur", "Utilisateur non trouvé.");
            return "redirect:/adherent";
        }

        Utilisateur utilisateur = utilisateurOpt.get();
        Adherent adherent = utilisateur.getAdherent();
        LocalDate dateDebut = LocalDate.parse(dateDebutStr);

        // Vérifie si l'utilisateur est inscrit à cette date
        if (!utilisateurService.estInscritA(utilisateur.getId(), dateDebut)) {
            model.addAttribute("erreur", "Vous n'êtes pas inscrit à la bibliothèque à cette date.");
            return "redirect:/adherent";
        }

        // Vérifie s'il est pénalisé
        if (utilisateurService.estPenalise(adherent, dateDebut)) {
            model.addAttribute("erreur", "Vous êtes sous le coup d'une pénalité.");
            return "redirect:/adherent";
        }

        Exemplaire exemplaire = exemplaireService.findById(idExemplaire);

        // Calcul de la date de retour prévue
        LocalDate dateRetourPrevue;
        if (idTypePret == 2) {
            dateRetourPrevue = dateDebut; // sur place
        } else {
            int jours = dureePretProfilService.getDureeParProfil(utilisateur.getProfil());
            dateRetourPrevue = dateDebut.plusDays(jours);
        }

        // Récupération des objets nécessaires
        EtatPret etat = etatPretService.findByNom("en_attente");
        TypePret typePret = typePretService.findById(idTypePret);
        StatutExemplaire statutEmprunte = statutExemplaireService.findByNom("emprunte");

        // Création et sauvegarde du prêt
        Pret pret = new Pret();
        pret.setAdherent(adherent);
        pret.setExemplaire(exemplaire);
        pret.setDateDebut(dateDebut);
        pret.setDateRetourPrevue(dateRetourPrevue);
        pret.setTypePret(typePret);
        pret.setEtat(etat);

        pretService.save(pret);

        // Mise à jour du statut de l'exemplaire
        exemplaire.setStatut(statutEmprunte);
        exemplaireService.save(exemplaire);

        model.addAttribute("message", "Demande de prêt enregistrée avec succès.");
        return "redirect:/adherent";
    }

}
