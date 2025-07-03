package web.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.bibliotheque.model.Exemplaire;

public interface ExemplaireRepository extends JpaRepository<Exemplaire, Integer> {
}
