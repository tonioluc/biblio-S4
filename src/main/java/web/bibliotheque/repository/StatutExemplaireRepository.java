package web.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.bibliotheque.model.StatutExemplaire;

public interface StatutExemplaireRepository extends JpaRepository<StatutExemplaire, Integer> {
    StatutExemplaire findByNom(String nom);
}
