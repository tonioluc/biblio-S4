package web.bibliotheque.model;

import jakarta.persistence.*;

@Entity
@Table(name = "profil")
public class Profil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    private int quota_pret;

    public int getQuota_pret() {
        return quota_pret;
    }
    public void setQuota_pret(int quota_pret) {
        this.quota_pret = quota_pret;
    }
    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}
