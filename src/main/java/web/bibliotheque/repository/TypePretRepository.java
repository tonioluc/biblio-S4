package web.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.bibliotheque.model.TypePret;

@Repository
public interface TypePretRepository extends JpaRepository<TypePret, Integer> {
}
