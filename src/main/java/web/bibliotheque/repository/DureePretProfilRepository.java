package web.bibliotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.bibliotheque.model.DureePretProfil;
import web.bibliotheque.model.Profil;

@Repository
public interface DureePretProfilRepository extends JpaRepository<DureePretProfil, Integer> {

    DureePretProfil findByProfil(Profil profil);
}
