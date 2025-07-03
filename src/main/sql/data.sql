-- ================================
-- 1. 👤 Donnees pour la table Profil
-- ================================
INSERT INTO Profil (nom, quota_pret) VALUES
('etudiant', 3),
('Professeur', 5);

-- ================================
-- 2. 👥 Donnees pour les Adherents
-- ================================
INSERT INTO Adherent (nom, prenom, adresse, statut_compte) VALUES
('Doe', 'John', '123 Rue de Paris', 'actif'),
('Smith', 'Anna', '45 Boulevard Haussmann', 'actif');

-- ================================
-- 3. 👨‍🏫 Donnees pour les Bibliothecaires
-- ================================
-- On suppose qu'on attribue le profil "Professeur" (id = 2) aux bibliothecaires
INSERT INTO Bibliothecaire (nom, prenom) VALUES
('Martin', 'Luc');

-- ================================
-- 4. 🔐 Donnees pour les Utilisateurs (authentification)
-- ================================
-- ⚠️ Assure-toi que les ids inseres precedemment sont les bons.
-- Adherent John Doe → id_adherent = 1
-- Bibliothecaire Luc Martin → id_bibliothecaire = 1
-- Mot de passe ici en clair pour test (en vrai, il doit être hashe)

INSERT INTO Utilisateur (email, mot_de_passe, role, id_adherent, id_bibliothecaire, id_profil)
VALUES
-- Adherent John Doe
('john.doe@mail.com', 'motdepasse123', 'adherent', 1, NULL, 1),

-- Bibliothecaire Luc Martin
('luc.martin@biblio.com', 'adminpass456', 'bibliothecaire', NULL, 1, 2);

-- ================================
-- 5. 📅 Inscription d'un adherent (abonnement actif)
-- ================================
INSERT INTO Inscription (id_adherent, date_debut, date_expiration)
VALUES
(1, CURRENT_DATE, CURRENT_DATE + INTERVAL '1 year');

-- ================================
-- 6. ⏱️ Duree de prêt pour les profils
-- ================================
INSERT INTO duree_pret_profil (id_profil, duree_jours) VALUES
(1, 14),  -- etudiant : 14 jours
(2, 28);  -- Professeur : 28 jours

-- ================================
-- 7. 📌 Statuts d'Exemplaire
-- ================================
INSERT INTO Statut_Exemplaire (nom) VALUES
('disponible'),
('emprunte'),
('reserve');

-- ================================
-- 8. 🛠 etats d'Exemplaire
-- ================================
INSERT INTO Etat_Exemplaire (nom) VALUES
('neuf'),
('bon etat'),
('abîme');

-- ================================
-- 9. 📖 Exemplaires disponibles
-- ================================
INSERT INTO Exemplaire (titre, auteur, id_statut, id_etat) VALUES
('Le Petit Prince', 'Antoine de Saint-Exupery', 1, 1),  -- disponible, neuf
('1984', 'George Orwell', 1, 2),                        -- disponible, bon etat
('L etranger', 'Albert Camus', 1, 1);                  -- disponible, neuf

INSERT INTO TypePret (nom) VALUES ('Emporter'), ('Sur place');
INSERT INTO EtatPret (nom) VALUES ('en attente'), ('valide'), ('refuse'), ('retourne');
