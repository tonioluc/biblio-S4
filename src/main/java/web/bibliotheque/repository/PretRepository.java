package web.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.bibliotheque.model.Pret;
import web.bibliotheque.model.Adherent;
import java.util.List;

@Repository
public interface PretRepository extends JpaRepository<Pret, Integer> {
    int countByAdherentAndEtatNomNot(Adherent adherent, String etatNom);

    List<Pret> findByAdherentAndEtatNomNot(Adherent adherent, String etatNom);

    List<Pret> findByAdherent(Adherent adherent);

}
