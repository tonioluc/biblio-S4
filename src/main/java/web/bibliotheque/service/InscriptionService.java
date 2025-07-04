package web.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.bibliotheque.model.Inscription;
import web.bibliotheque.model.Adherent;
import web.bibliotheque.repository.InscriptionRepository;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class InscriptionService {
    @Autowired
    private InscriptionRepository inscriptionRepository;

    public boolean isAdherentInscrit(Adherent adherent, LocalDate date) {
        return inscriptionRepository.findByAdherentAndDateDebutLessThanEqualAndDateExpirationGreaterThanEqual(adherent, date, date).isPresent();
    }

    public Optional<Inscription> getDerniereInscription(Adherent adherent) {
        return inscriptionRepository.findTopByAdherentOrderByDateExpirationDesc(adherent);
    }

    public boolean estInscrit(Adherent adherent, LocalDate dateDebut) {
        return inscriptionRepository.existsByAdherentAndDateDebutBeforeAndDateExpirationAfter(adherent, dateDebut, dateDebut);
    }
}
