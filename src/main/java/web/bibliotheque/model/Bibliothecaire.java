package web.bibliotheque.model;

import jakarta.persistence.*;

@Entity
public class Bibliothecaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBibliothecaire;

    private String nom;
    private String prenom;

    public Integer getIdBibliothecaire() {
        return idBibliothecaire;
    }

    public void setIdBibliothecaire(Integer idBibliothecaire) {
        this.idBibliothecaire = idBibliothecaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
