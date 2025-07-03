package web.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.bibliotheque.service.ExemplaireService;

@Controller
@RequestMapping("/exemplaire")
public class ExemplaireController {

    @Autowired
    private ExemplaireService exemplaireService;

    @GetMapping("/list")
    public String listerExemplaires(Model model) {
        model.addAttribute("exemplaires", exemplaireService.getAllExemplaires());
        return "exemplaires";
    }
}
