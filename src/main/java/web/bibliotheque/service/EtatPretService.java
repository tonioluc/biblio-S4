package web.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.bibliotheque.model.EtatPret;
import web.bibliotheque.repository.EtatPretRepository;

@Service
public class EtatPretService {

    @Autowired
    private EtatPretRepository etatPretRepository;

    public EtatPret findByNom(String nom) {
        return etatPretRepository.findByNom(nom);
    }
}
