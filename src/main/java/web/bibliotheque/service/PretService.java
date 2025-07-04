package web.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.bibliotheque.model.Pret;
import web.bibliotheque.model.Adherent;
import web.bibliotheque.repository.PretRepository;
import java.util.List;

@Service
public class PretService {
    @Autowired
    private PretRepository pretRepository;

    public int getNbPretsEnCoursPourAdherent(Adherent adherent) {
        // On considère qu'un prêt est "en cours" si son état n'est pas "retourne"
        return pretRepository.countByAdherentAndEtatNomNot(adherent, "retourne");
    }

    public List<Pret> getPretsEnCoursPourAdherent(Adherent adherent) {
        return pretRepository.findByAdherentAndEtatNomNot(adherent, "retourne");
    }

    public Pret save(Pret pret) {
        return pretRepository.save(pret);
    }

    public List<Pret> getPretsByAdherent(Adherent adherent) {
        return pretRepository.findByAdherent(adherent);
    }
}
