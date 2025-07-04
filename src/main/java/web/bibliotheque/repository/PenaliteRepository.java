package web.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.bibliotheque.model.Penalite;

import web.bibliotheque.model.Adherent;
import java.util.Optional;

public interface PenaliteRepository extends JpaRepository<Penalite, Integer> {
    Optional<Penalite> findTopByAdherentAndRegleeFalseOrderByDateFinDesc(Adherent adherent);
}
