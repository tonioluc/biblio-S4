-- Insertion d'un adherent
INSERT INTO Adherent (nom, prenom, email, adresse) VALUES
('Rakoto', 'Jean', 'rakoto.jean@mail.com', 'Antananarivo');


-- Insertion d’un bibliothecaire
INSERT INTO Bibliothecaire (nom, prenom, email) VALUES
('Rabe', 'Marie', 'marie.rabe@biblio.com');

-- Insertion du compte utilisateur pour le bibliothecaire
INSERT INTO Utilisateur (email, mot_de_passe, role, id_bibliothecaire) VALUES
('marie.rabe@biblio.com', 'adminpass', 'bibliothecaire', 1);

-- Insertion du compte utilisateur lie à cet adherent
INSERT INTO Utilisateur (email, mot_de_passe, role, id_adherent) VALUES
('rakoto.jean@mail.com', 'mdp123', 'adherent', 1);

-- Insérer les statuts possibles
INSERT INTO statut_exemplaire (id, nom) VALUES (1, 'Disponible');
INSERT INTO statut_exemplaire (id, nom) VALUES (2, 'Emprunte');
INSERT INTO statut_exemplaire (id, nom) VALUES (3, 'Reserve');

-- Insérer des exemplaires
INSERT INTO exemplaire (id, titre, auteur, etat, id_statut) VALUES
(1, 'Le Petit Prince', 'Antoine de Saint-Exupery', 'Bon', 1),
(2, 'Letranger', 'Albert Camus', 'Moyen', 2),
(3, '1984', 'George Orwell', 'Neuf', 1),
(4, 'Candide', 'Voltaire', 'Usage', 3);
