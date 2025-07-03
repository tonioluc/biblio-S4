package web.bibliotheque.repository;

import web.bibliotheque.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmailAndMotDePasse(String email, String motDePasse);
}
