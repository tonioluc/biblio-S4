package web.bibliotheque.model;

import jakarta.persistence.*;

@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_adherent")
    private Adherent adherent;

    @Column(name = "date_debut", nullable = false)
    private java.time.LocalDate dateDebut;

    @Column(name = "date_expiration", nullable = false)
    private java.time.LocalDate dateExpiration;

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Adherent getAdherent() { return adherent; }
    public void setAdherent(Adherent adherent) { this.adherent = adherent; }

    public java.time.LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(java.time.LocalDate dateDebut) { this.dateDebut = dateDebut; }

    public java.time.LocalDate getDateExpiration() { return dateExpiration; }
    public void setDateExpiration(java.time.LocalDate dateExpiration) { this.dateExpiration = dateExpiration; }
}
