package web.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.bibliotheque.model.Exemplaire;
import web.bibliotheque.repository.ExemplaireRepository;

import java.util.List;

@Service
public class ExemplaireService {

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    public List<Exemplaire> getAllExemplaires() {
        return exemplaireRepository.findAll();
    }

    public Exemplaire findById(Integer idExemplaire) {
        return exemplaireRepository.findById(idExemplaire).get();
    }

    public Exemplaire save(Exemplaire exemplaire) {
        return exemplaireRepository.save(exemplaire);
    }
}
