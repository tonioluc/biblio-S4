\c postgres;
drop database if exists bibliotheque;
create database bibliotheque;
\c bibliotheque;

-- ================================
-- 🔐 Utilisateurs du site web
-- ================================

-- Table des adhérents (profil utilisateur)
-- CREATE TABLE Adherent (
--     id_adherent SERIAL PRIMARY KEY,
--     nom VARCHAR(100) NOT NULL,
--     prenom VARCHAR(100) NOT NULL,
--     email VARCHAR(255) UNIQUE NOT NULL,
--     adresse TEXT,
--     statut_compte VARCHAR(50) DEFAULT 'actif' -- actif / bloqué
-- );

-- -- Table des bibliothécaires (profil admin)
-- CREATE TABLE Bibliothecaire (
--     id_bibliothecaire SERIAL PRIMARY KEY,
--     nom VARCHAR(100) NOT NULL,
--     prenom VARCHAR(100) NOT NULL,
--     email VARCHAR(255) UNIQUE NOT NULL
-- );

-- -- Table des utilisateurs (authentification)
-- CREATE TABLE Utilisateur (
--     id_utilisateur SERIAL PRIMARY KEY,
--     email VARCHAR(255) UNIQUE NOT NULL,
--     mot_de_passe VARCHAR(255) NOT NULL,
--     role VARCHAR(20) NOT NULL CHECK (role IN ('adherent', 'bibliothecaire')),
    
--     -- Liaison avec les profils selon le rôle
--     id_adherent INT UNIQUE,
--     id_bibliothecaire INT UNIQUE,

--     FOREIGN KEY (id_adherent) REFERENCES Adherent(id_adherent) ON DELETE CASCADE,
--     FOREIGN KEY (id_bibliothecaire) REFERENCES Bibliothecaire(id_bibliothecaire) ON DELETE CASCADE
-- );

-- \i 'D:/ANTONIO/S4/web-dynamique/bibliotheque/src/main/sql/script.sql'