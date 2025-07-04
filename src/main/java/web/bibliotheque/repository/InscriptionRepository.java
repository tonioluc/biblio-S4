package web.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.bibliotheque.model.Inscription;
import web.bibliotheque.model.Adherent;
import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
    Optional<Inscription> findTopByAdherentOrderByDateExpirationDesc(Adherent adherent);
    Optional<Inscription> findByAdherentAndDateDebutLessThanEqualAndDateExpirationGreaterThanEqual(Adherent adherent, LocalDate dateDebut, LocalDate dateFin);
    boolean existsByAdherentAndDateDebutBeforeAndDateExpirationAfter(Adherent adherent, LocalDate date1, LocalDate date2);
}
