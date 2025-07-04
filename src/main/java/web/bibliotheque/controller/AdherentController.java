package web.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.bibliotheque.service.AdherentService;
import web.bibliotheque.service.TypePretService;
import web.bibliotheque.model.TypePret;
import java.util.List;

@Controller
@RequestMapping("/adherent")
public class AdherentController {


    @Autowired
    private AdherentService adherentService;

    @Autowired
    private TypePretService typePretService;

    @GetMapping("/emprunter-livre/{idExemplaire}")
    public String showFormuEmprunt(@PathVariable("idExemplaire") Integer idExemplaire, Model model) {
        List<TypePret> typePrets = typePretService.getAllTypePrets();
        model.addAttribute("idExemplaire", idExemplaire);
        model.addAttribute("typePrets", typePrets);
        return "emprunt-form";
    }

    @PostMapping("/emprunter-livre/{idExemplaire}")
    public String effectuerEmprunt(@PathVariable("idExemplaire") Integer idExemplaire,
                                   @RequestParam("dateDebut") String dateDebut,
                                   @RequestParam("typePret") Integer idTypePret,
                                   Model model) {
        // TODO: Ajouter la logique pour enregistrer l'emprunt
        // Rediriger ou afficher un message de succès
        return "redirect:/adherent";
    }
}
