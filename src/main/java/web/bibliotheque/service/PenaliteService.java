package web.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.bibliotheque.model.Penalite;
import web.bibliotheque.model.Adherent;
import web.bibliotheque.repository.PenaliteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PenaliteService {
    @Autowired
    private PenaliteRepository penaliteRepository;

    public List<Penalite> getAllPenalites() {
        return penaliteRepository.findAll();
    }

    public Optional<Penalite> getPenaliteById(Integer id) {
        return penaliteRepository.findById(id);
    }

    public Penalite savePenalite(Penalite penalite) {
        return penaliteRepository.save(penalite);
    }

    public void deletePenalite(Integer id) {
        penaliteRepository.deleteById(id);
    }

    public Optional<Penalite> getPenaliteActivePourAdherent(Adherent adherent) {
        return penaliteRepository.findTopByAdherentAndRegleeFalseOrderByDateFinDesc(adherent);
    }
}
