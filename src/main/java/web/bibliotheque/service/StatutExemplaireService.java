package web.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.bibliotheque.model.StatutExemplaire;
import web.bibliotheque.repository.StatutExemplaireRepository;

@Service
public class StatutExemplaireService {

    @Autowired
    private StatutExemplaireRepository statutExemplaireRepository;

    public StatutExemplaire findByNom(String nom) {
        return statutExemplaireRepository.findByNom(nom);
    }
}
