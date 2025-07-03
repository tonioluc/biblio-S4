package web.bibliotheque.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import web.bibliotheque.model.Utilisateur;
import web.bibliotheque.service.UtilisateurService;

import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/")
    public String init() {
        return "login";
    }

    @GetMapping("/login")
    public String afficherLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String traiterLogin(@RequestParam String email,
                                @RequestParam String motDePasse,
                                HttpSession session,
                                Model model) {

        Optional<Utilisateur> utilisateurOpt = utilisateurService.verifierConnexion(email, motDePasse);

        if (utilisateurOpt.isPresent()) {
            Utilisateur utilisateur = utilisateurOpt.get();
            session.setAttribute("utilisateurId", utilisateur.getId());
            session.setAttribute("role", utilisateur.getRole());
            return "redirect:/accueil";
        } else {
            model.addAttribute("erreur", "Email ou mot de passe incorrect.");
            return "login";
        }
    }

    @GetMapping("/accueil")
    public String accueil() {
        return "accueil";
    }

    @GetMapping("/deconnexion")
    public String logout(HttpSession session) {
        return "login";
    }
}
