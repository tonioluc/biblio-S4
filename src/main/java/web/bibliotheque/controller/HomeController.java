package web.bibliotheque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String afficherLogin(Model model) {
        // model.addAttribute("message", "Projet Spring Boot + JSP fonctionnel !");
        return "login"; // cela correspond à home.jsp
    }
}
