package web.bibliotheque.model;

import jakarta.persistence.*;

@Entity
public class EtatExemplaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom; // Exemple : "Neuf", "Bon état", "Usé"

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}
