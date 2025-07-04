-- \i D:/ANTONIO/S4/web-dynamique/bibliotheque/src/main/sql/script.sql
\c postgres;
drop database if exists bibliotheque;
create database bibliotheque;
\c bibliotheque;

-- ================================
-- 🔐 Utilisateurs du site web
-- ================================

-- TABLE : PROFIL
CREATE TABLE Profil (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(50) NOT NULL, -- ex: Étudiant, Professeur
    quota_pret INT NOT NULL DEFAULT 3
);

-- Table des adhérents (profil utilisateur)
CREATE TABLE Adherent (
    id_adherent SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    adresse TEXT,
    statut_compte VARCHAR(50) DEFAULT 'actif' -- actif / bloqué
);

-- Table des bibliothécaires (profil admin)
CREATE TABLE Bibliothecaire (
    id_bibliothecaire SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL
);

-- Table des utilisateurs (authentification)
CREATE TABLE Utilisateur (
    id_utilisateur SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    mot_de_passe VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL CHECK (role IN ('adherent', 'bibliothecaire')),
    
    -- Liaison avec les profils selon le rôle
    id_adherent INT UNIQUE,
    id_bibliothecaire INT UNIQUE,
    id_profil INT NOT NULL,
    FOREIGN KEY (id_profil) REFERENCES Profil(id) ON DELETE CASCADE,
    FOREIGN KEY (id_adherent) REFERENCES Adherent(id_adherent) ON DELETE CASCADE,
    FOREIGN KEY (id_bibliothecaire) REFERENCES Bibliothecaire(id_bibliothecaire) ON DELETE CASCADE
);

-- TABLE : INSCRIPTION (abonnement à une bibliothèque)
CREATE TABLE Inscription (
    id SERIAL PRIMARY KEY,
    id_adherent INT NOT NULL,
    date_debut DATE NOT NULL,
    date_expiration DATE NOT NULL,
    FOREIGN KEY (id_adherent) REFERENCES Adherent(id_adherent),
    CHECK (date_expiration > date_debut)
);

-- TABLE : TypePret
CREATE TABLE TypePret (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(20) UNIQUE NOT NULL -- valeurs attendues : 'emporté', 'sur_place'
);

-- TABLE : EtatPret
CREATE TABLE EtatPret (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(20) UNIQUE NOT NULL -- valeurs attendues : 'en_attente', 'valide', 'refuse', 'retourne'
);


-- TABLE : Statut_Exemplaire
CREATE TABLE Statut_Exemplaire (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL
);

-- TABLE : Etat_Exemplaire
CREATE TABLE Etat_Exemplaire (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL
);

-- TABLE : Exemplaire
CREATE TABLE Exemplaire (
    id SERIAL PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    auteur VARCHAR(255),
    id_statut INT,
    id_etat INT,
    FOREIGN KEY (id_statut) REFERENCES Statut_Exemplaire(id),
    FOREIGN KEY (id_etat) REFERENCES Etat_Exemplaire(id)
);

-- TABLE : Pret
CREATE TABLE Pret (
    id SERIAL PRIMARY KEY,
    id_exemplaire INT NOT NULL,
    id_adherent INT NOT NULL,
    date_debut DATE,
    date_retour_prevue DATE,
    date_retour_effective DATE,
    id_type_pret INT NOT NULL,
    id_etat INT NOT NULL,
    FOREIGN KEY (id_exemplaire) REFERENCES Exemplaire(id),
    FOREIGN KEY (id_adherent) REFERENCES Adherent(id_adherent),
    FOREIGN KEY (id_type_pret) REFERENCES TypePret(id),
    FOREIGN KEY (id_etat) REFERENCES EtatPret(id)
);

-- TABLE : PENALITE
CREATE TABLE Penalite (
    id SERIAL PRIMARY KEY,
    id_adherent INT NOT NULL,
    date_debut DATE NOT NULL,
    date_fin DATE NOT NULL,
    reglee BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (id_adherent) REFERENCES Adherent(id_adherent)
);

CREATE TABLE duree_pret_profil (
    id SERIAL PRIMARY KEY,
    id_profil INTEGER NOT NULL,
    duree_jours INTEGER NOT NULL CHECK (duree_jours > 0),

    CONSTRAINT fk_duree_profil FOREIGN KEY (id_profil) REFERENCES profil(id)
);

-- \i 'D:/ANTONIO/S4/web-dynamique/bibliotheque/src/main/sql/script.sql'



-- Emprunt des livres :
-- -Le quota de pret de cet Adherent dépend de son profil (par exemple : s'il étudiant , son quota de pret est 3)
-- -Quota veut dire qu'il peut emprunter 3(selon son profil) livres simultanement
-- -Son quota se diminue quand son prêt est validé par le bibliothecaire (-1)
-- -S'il n'a plus de quota , il ne peut pas faire un prêt
-- -S'il est pénalisé(il est pénalisé quand il ne rend pas le livre à temps(il est pénalisé de 10 jours sans emprunt))
-- -Il ne peut pas emprunter un exemplaire s'il n'est pas abonnée(on a un table inscription par exemple pour stocké la date de de début et date d'expiration de l'abonnement)
