package web.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.bibliotheque.model.Adherent;
import web.bibliotheque.repository.AdherentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AdherentService {
    @Autowired
    private AdherentRepository adherentRepository;

    public List<Adherent> getAllAdherents() {
        return adherentRepository.findAll();
    }

    public Optional<Adherent> getAdherentById(Integer id) {
        return adherentRepository.findById(id);
    }

    public Adherent saveAdherent(Adherent adherent) {
        return adherentRepository.save(adherent);
    }

    public void deleteAdherent(Integer id) {
        adherentRepository.deleteById(id);
    }
}
