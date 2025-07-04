package web.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.bibliotheque.model.EtatPret;

public interface EtatPretRepository extends JpaRepository<EtatPret, Integer> {
    EtatPret findByNom(String nom);
}
