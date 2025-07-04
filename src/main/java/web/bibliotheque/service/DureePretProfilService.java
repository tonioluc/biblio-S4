package web.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.bibliotheque.model.DureePretProfil;
import web.bibliotheque.model.Profil;
import web.bibliotheque.repository.DureePretProfilRepository;

@Service
public class DureePretProfilService {

    @Autowired
    private DureePretProfilRepository dureePretProfilRepository;

    public int getDureePourProfil(Profil profil) {
        DureePretProfil config = dureePretProfilRepository.findByProfil(profil);
        if (config != null) {
            return config.getDureeJours();
        } else {
            // Valeur par défaut si aucune durée n'est définie pour le profil
            return 10;
        }
    }

    public DureePretProfil findByProfil(Profil profil) {
        return dureePretProfilRepository.findByProfil(profil);
    }
}
