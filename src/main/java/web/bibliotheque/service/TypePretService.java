package web.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.bibliotheque.model.TypePret;
import web.bibliotheque.repository.TypePretRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TypePretService {
    @Autowired
    private TypePretRepository typePretRepository;

    public List<TypePret> getAllTypePrets() {
        return typePretRepository.findAll();
    }

    public Optional<TypePret> getTypePretById(Integer id) {
        return typePretRepository.findById(id);
    }

    public TypePret saveTypePret(TypePret typePret) {
        return typePretRepository.save(typePret);
    }

    public void deleteTypePret(Integer id) {
        typePretRepository.deleteById(id);
    }
}
