package web.bibliotheque.model;

import jakarta.persistence.*;

@Entity
public class Exemplaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titre;
    private String auteur;

    @ManyToOne
    @JoinColumn(name = "id_statut") // FK vers StatutExemplaire
    private StatutExemplaire statut;

    @ManyToOne
    @JoinColumn(name = "id_etat") // FK vers EtatExemplaire
    private EtatExemplaire etat;

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    public StatutExemplaire getStatut() { return statut; }
    public void setStatut(StatutExemplaire statut) { this.statut = statut; }

    public EtatExemplaire getEtat() { return etat; }
    public void setEtat(EtatExemplaire etat) { this.etat = etat; }
}
