SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";



--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `IDuser` int(11) NOT NULL AUTO_INCREMENT,
  `Email` text COLLATE utf8_unicode_ci NOT NULL,
  `MotDePasse` text COLLATE utf8_unicode_ci NOT NULL,
  `Nom` text COLLATE utf8_unicode_ci NOT NULL,
  `Prenom` text COLLATE utf8_unicode_ci NOT NULL,
  `Droit` int(11) NOT NULL,
  PRIMARY KEY (`IDuser`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `IDpromo` int(11) NOT NULL AUTO_INCREMENT,
  `Promo` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`IDpromo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `IDgroupe` int(11) NOT NULL AUTO_INCREMENT,
  `Groupe` text COLLATE utf8_unicode_ci NOT NULL,
  `IDpromo` int(11) NOT NULL,
  PRIMARY KEY (`IDgroupe`),
  KEY `IDpromo` (`IDpromo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `IDetudiant` int(11) NOT NULL,
  `Numero` int(11) NOT NULL AUTO_INCREMENT,
  `IDgroupe` int(11) NOT NULL,
  `IDpromo` int(11) NOT NULL,
  KEY `Numero` (`Numero`),
  KEY `IDgroupe` (`IDgroupe`),
  KEY `IDpromo` (`IDpromo`),
  KEY `IDuser` (`IDetudiant`),
  PRIMARY KEY (`IDetudiant`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `IDcours` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`IDcours`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Structure de la table `typecours`
--

DROP TABLE IF EXISTS `typecours`;
CREATE TABLE IF NOT EXISTS `typecours` (
  `IDtypecours` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`IDtypecours`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `IDenseignant` int(11) NOT NULL,
  `IDcours` int(11) NOT NULL,
  KEY `IDcours` (`IDcours`),
  KEY `IDuser` (`IDenseignant`),
  PRIMARY KEY (`IDenseignant`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `IDsite` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`IDsite`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `IDsalle` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` text COLLATE utf8_unicode_ci NOT NULL,
  `Capacite` int(11) NOT NULL,
  `IDsite` int(11) NOT NULL,
  KEY `IDsite` (`IDsite`),
  PRIMARY KEY (`IDsalle`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `IDseance` int(11) NOT NULL AUTO_INCREMENT,
  `Semaine` int(11) NOT NULL,
  `Date` int(11) NOT NULL,
  `HeureDebut` int(11) NOT NULL,
  `HeureFin` int(11) NOT NULL,
  `Etat` int(11) NOT NULL,
  `IDcours` int(11) NOT NULL,
  `IDtypecours` int(11) NOT NULL,
  KEY `IDcours` (`IDcours`),
  KEY `IDtypecours` (`IDtypecours`),
  PRIMARY KEY (`IDseance`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Structure de la table `seancegroupe`
--

DROP TABLE IF EXISTS `seancegroupe`;
CREATE TABLE IF NOT EXISTS `seancegroupe` (
  `IDseancegroupe` int(11) NOT NULL AUTO_INCREMENT,
  `IDseance` int(11) NOT NULL,
  `IDgroupe` int(11) NOT NULL,
  KEY `IDseance` (`IDseance`),
  KEY `IDgroupe` (`IDgroupe`),
  PRIMARY KEY (`IDseancegroupe`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Structure de la table `seanceenseignant`
--

DROP TABLE IF EXISTS `seanceenseignant`;
CREATE TABLE IF NOT EXISTS `seanceenseignant` (
  `IDseance` int(11) NOT NULL,
  `IDenseignant` int(11) NOT NULL,
  KEY `IDseance` (`IDseance`),
  KEY `IDenseignant` (`IDenseignant`),
  PRIMARY KEY (`IDseance`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Structure de la table `seancesalle`
--

DROP TABLE IF EXISTS `seancesalle`;
CREATE TABLE IF NOT EXISTS `seancesalle` (
  `IDseance` int(11) NOT NULL,
  `IDsalle` int(11) NOT NULL,
  KEY `IDseance` (`IDseance`),
  KEY `IDsalle` (`IDsalle`),
  PRIMARY KEY (`IDseance`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;












-- Promo
INSERT INTO `promotion`(`IDpromo`, `Promo`)
	VALUES (1, 'Premier Cycle');
INSERT INTO `promotion`(`IDpromo`, `Promo`)
	VALUES (2, 'Second Cycle');
INSERT INTO `promotion`(`IDpromo`, `Promo`)
	VALUES (3, 'Dernier Cycle');

-- Groupe
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD1', (SELECT IDpromo FROM promotion WHERE IDpromo=1));
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD2', (SELECT IDpromo FROM promotion WHERE IDpromo=1));
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD3', (SELECT IDpromo FROM promotion WHERE IDpromo=1));
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD1', (SELECT IDpromo FROM promotion WHERE IDpromo=2));
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD2', (SELECT IDpromo FROM promotion WHERE IDpromo=2));
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD3', (SELECT IDpromo FROM promotion WHERE IDpromo=2));
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD1', (SELECT IDpromo FROM promotion WHERE IDpromo=3));
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD2', (SELECT IDpromo FROM promotion WHERE IDpromo=3));
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD3', (SELECT IDpromo FROM promotion WHERE IDpromo=3));

-- Cours
INSERT INTO `cours`(`Nom`)
	VALUES ('Physique');
INSERT INTO `cours`(`Nom`)
	VALUES ('Maths');
INSERT INTO `cours`(`Nom`)
	VALUES ('Info');
INSERT INTO `cours`(`Nom`)
	VALUES ('Electronique');
INSERT INTO `cours`(`Nom`)
	VALUES ('Gestion de projet');

-- Type Cours
INSERT INTO `typecours`(`Nom`)
	VALUES ('Cours magistral');
INSERT INTO `typecours`(`Nom`)
	VALUES ('Cours interactif');
INSERT INTO `typecours`(`Nom`)
	VALUES ('TD');
INSERT INTO `typecours`(`Nom`)
	VALUES ('TP');
INSERT INTO `typecours`(`Nom`)
	VALUES ('Avancement projet');
INSERT INTO `typecours`(`Nom`)
	VALUES ('Soutien');
INSERT INTO `typecours`(`Nom`)
	VALUES ('EXAMEN');

-- Site
INSERT INTO `site`(`Nom`)
	VALUES ('Eiffel 1');
INSERT INTO `site`(`Nom`)
	VALUES ('Eiffel 2');
INSERT INTO `site`(`Nom`)
	VALUES ('Eiffel 3');

-- Salle
INSERT INTO `salle`(`Nom`, `Capacite`, `IDsite`)
	VALUES ('101', 1, (SELECT IDsite FROM site WHERE IDsite=1));
INSERT INTO `salle`(`Nom`, `Capacite`, `IDsite`)
	VALUES ('102', 2, (SELECT IDsite FROM site WHERE IDsite=1));
INSERT INTO `salle`(`Nom`, `Capacite`, `IDsite`)
	VALUES ('103', 4, (SELECT IDsite FROM site WHERE IDsite=1));
INSERT INTO `salle`(`Nom`, `Capacite`, `IDsite`)
	VALUES ('201', 2, (SELECT IDsite FROM site WHERE IDsite=2));
INSERT INTO `salle`(`Nom`, `Capacite`, `IDsite`)
	VALUES ('202', 2, (SELECT IDsite FROM site WHERE IDsite=2));
INSERT INTO `salle`(`Nom`, `Capacite`, `IDsite`)
	VALUES ('203', 1, (SELECT IDsite FROM site WHERE IDsite=2));
INSERT INTO `salle`(`Nom`, `Capacite`, `IDsite`)
	VALUES ('301', 3, (SELECT IDsite FROM site WHERE IDsite=3));
INSERT INTO `salle`(`Nom`, `Capacite`, `IDsite`)
	VALUES ('302', 4, (SELECT IDsite FROM site WHERE IDsite=3));
INSERT INTO `salle`(`Nom`, `Capacite`, `IDsite`)
	VALUES ('303', 1, (SELECT IDsite FROM site WHERE IDsite=3));

-- Séance
INSERT INTO `seance`(`Semaine`, `Date`, `HeureDebut`, `HeureFin`, `Etat`, `IDcours`, `IDtypecours`)
	VALUES (22, 20200529, 8, 9, 1, (SELECT IDcours FROM cours WHERE IDcours=1), (SELECT IDtypecours FROM typecours WHERE IDtypecours=2));
INSERT INTO `seance`(`Semaine`, `Date`, `HeureDebut`, `HeureFin`, `Etat`, `IDcours`, `IDtypecours`)
	VALUES (23, 20200602, 8, 9, 1, (SELECT IDcours FROM cours WHERE IDcours=1), (SELECT IDtypecours FROM typecours WHERE IDtypecours=3));
INSERT INTO `seance`(`Semaine`, `Date`, `HeureDebut`, `HeureFin`, `Etat`, `IDcours`, `IDtypecours`)
	VALUES (23, 20200602, 9, 10, 1, (SELECT IDcours FROM cours WHERE IDcours=2), (SELECT IDtypecours FROM typecours WHERE IDtypecours=4));
INSERT INTO `seance`(`Semaine`, `Date`, `HeureDebut`, `HeureFin`, `Etat`, `IDcours`, `IDtypecours`)
	VALUES (23, 20200603, 11, 12, 1, (SELECT IDcours FROM cours WHERE IDcours=2), (SELECT IDtypecours FROM typecours WHERE IDtypecours=5));
INSERT INTO `seance`(`Semaine`, `Date`, `HeureDebut`, `HeureFin`, `Etat`, `IDcours`, `IDtypecours`)
	VALUES (23, 20200601, 15, 17, 1, (SELECT IDcours FROM cours WHERE IDcours=3), (SELECT IDtypecours FROM typecours WHERE IDtypecours=1));
INSERT INTO `seance`(`Semaine`, `Date`, `HeureDebut`, `HeureFin`, `Etat`, `IDcours`, `IDtypecours`)
	VALUES (23, 20200601, 8, 10, 1, (SELECT IDcours FROM cours WHERE IDcours=3), (SELECT IDtypecours FROM typecours WHERE IDtypecours=1));
INSERT INTO `seance`(`Semaine`, `Date`, `HeureDebut`, `HeureFin`, `Etat`, `IDcours`, `IDtypecours`)
	VALUES (24, 20200611, 13, 14, 1, (SELECT IDcours FROM cours WHERE IDcours=4), (SELECT IDtypecours FROM typecours WHERE IDtypecours=6));
INSERT INTO `seance`(`Semaine`, `Date`, `HeureDebut`, `HeureFin`, `Etat`, `IDcours`, `IDtypecours`)
	VALUES (24, 20200611, 10, 11, 1, (SELECT IDcours FROM cours WHERE IDcours=4), (SELECT IDtypecours FROM typecours WHERE IDtypecours=7));
INSERT INTO `seance`(`Semaine`, `Date`, `HeureDebut`, `HeureFin`, `Etat`, `IDcours`, `IDtypecours`)
	VALUES (22, 20200628, 16, 17, 1, (SELECT IDcours FROM cours WHERE IDcours=5), (SELECT IDtypecours FROM typecours WHERE IDtypecours=3));
INSERT INTO `seance`(`Semaine`, `Date`, `HeureDebut`, `HeureFin`, `Etat`, `IDcours`, `IDtypecours`)
	VALUES (23, 20200604, 8, 9, 1, (SELECT IDcours FROM cours WHERE IDcours=5), (SELECT IDtypecours FROM typecours WHERE IDtypecours=4));

-- Admin
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('admin', 'admin', 'Bonisseur de La Bath', 'Hubert', 1);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('adminbis', 'adminbis', 'NomdeFamille', 'Prenom', 1);

-- Référent
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('referent', 'azerty', 'Rogers', 'Steve', 2);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('referentbis', 'azerty', 'Fury', 'Nick', 2);

-- Enseignant
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('julien.lesprofs@edu.com', 'azerty', 'LesProfs', 'Julien', 3);
INSERT INTO `enseignant`(`IDenseignant`, `IDcours`)
	VALUES (5, 2);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('albert.boum@edu.com', 'azerty', 'Boum', 'Albert', 3);
INSERT INTO `enseignant`(`IDenseignant`, `IDcours`)
	VALUES (6, 1);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('eliot.alderson@edu.com', 'azerty', 'Alderson', 'Eliot', 3);
INSERT INTO `enseignant`(`IDenseignant`, `IDcours`)
	VALUES (7, 3);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('thor.ondinson@edu.com', 'azerty', 'Odinson', 'Thor', 3);
INSERT INTO `enseignant`(`IDenseignant`, `IDcours`)
	VALUES (8, 4);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('tony.stark@edu.com', 'azerty', 'Stark', 'Tony', 3);
INSERT INTO `enseignant`(`IDenseignant`, `IDcours`)
	VALUES (9, 5);

-- Etudiant
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('bebel.lavalle@edu.com', 'azerty', 'Lavalle', 'Bébel', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (10, 1, 1);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('julien.sanquin@edu.com', 'azerty', 'Sanquin', 'Julien', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (11, 1, 1);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('caro.janin@edu.com', 'azerty', 'Janin', 'Caroline', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (12, 1, 1);

INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('elleestoujeanne@edu.com', 'azerty', 'Hamilton', 'Jeanne', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (13, 2, 1);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('gaston.pourquier@edu.com', 'azerty', 'Pourquier', 'Gaston', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (14, 2, 1);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('leon.jumancourt@edu.com', 'azerty', 'Jumancourt', 'Leon', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (15, 2, 1);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('bruce.kateka@edu.com', 'azerty', 'Kateka', 'Bruce', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (16, 2, 1);

INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('gaston.lagaffe@edu.com', 'azerty', 'Lagaffe', 'Gaston', 4);
INSERT INTO `etudiant`(`IDetudiant`,  `IDgroupe`, `IDpromo`)
	VALUES (17, 3, 1);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('antoine.delafoy@edu.com', 'azerty', 'Delafoy', 'Antoine', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (18, 3, 1);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('fernand.naudin@edu.com', 'azerty', 'Naudin', 'Fernand', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (19, 3, 1);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('raoul.volfoni@edu.com', 'azerty', 'Volfoni', 'Raoul', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (20, 3, 1);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('antoine.beretto@edu.com', 'azerty', 'Beretto', 'Antoine', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (21, 3, 1);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('leo.michalon@edu.com', 'azerty', 'Michalon', 'Léonard', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (22, 3, 1);


INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('eglantine.michalon@edu.com', 'azerty', 'Michalon', 'Eglantine', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (23, 4, 2);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('francine.marquette@edu.com', 'azerty', 'Marquette', 'Francine', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (24, 4, 2);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('georges.de-la-motte-brebiere@edu.com', 'azerty', 'De La Motte Brébière', 'Georges', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (25, 4, 2);

INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('lionel.mandrake@edu.com', 'azerty', 'Mandrake', 'Lionel', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (26, 5, 2);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('buck.tugidson@edu.com', 'azerty', 'Turgidson', 'Buck', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (27, 5, 2);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('jack.ripper@edu.com', 'azerty', 'Ripper', 'Jack', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (28, 5, 2);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('bat.guano@edu.com', 'azerty', 'Guano', 'Bat', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (29, 5, 2);

INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('alexei.de-sadeski@edu.com', 'azerty', 'de Sadeski', 'Alexei', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (30, 6, 2);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('ace.owens@edu.com', 'azerty', 'Owens', 'Ace', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (31, 6, 2);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('jacques.thebault@edu.com', 'azerty', 'Thébault', 'Jacques', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (32, 6, 2);


INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('gregory.boyington@edu.com', 'azerty', 'Boyington', 'Grégory', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (33, 7, 3);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('thomas.lard@edu.com', 'azerty', 'Lard', 'Thomas', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (34, 7, 3);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('theodore.joseph@edu.com', 'azerty', 'Joseph', 'Théodore', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (35, 7, 3);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('jerry.bragg@edu.com', 'azerty', 'Bragg', 'Jerry', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (36, 7, 3);

INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('robert.anderson@edu.com', 'azerty', 'Anderson', 'Robert', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (37, 8, 3);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('robert.boyle@edu.com', 'azerty', 'Boyle', 'Robert', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (38, 8, 3);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('andrew.micklin@edu.com', 'azerty', 'Micklin', 'Andrew', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (39, 8, 3);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('angelica.huston@edu.com', 'azerty', 'Huston', 'Angelica', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (40, 8, 3);

INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('morticia.addams@edu.com', 'azerty', 'Addams', 'Morticia', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (41, 9, 3);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('fetide.addams@edu.com', 'azerty', 'Addams', 'Fétide', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (42, 9, 3);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('mercredi.addams@edu.com', 'azerty', 'Addams', 'Mercredi', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (43, 9, 3);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('charles.addams@edu.com', 'azerty', 'Addams', 'Charles', 4);
INSERT INTO `etudiant`(`IDetudiant`, `IDgroupe`, `IDpromo`)
	VALUES (44, 9, 3);

-- Séance groupe
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (1, 1);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (2, 1);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (3, 2);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (4, 3);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (4, 2);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (5, 1);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (5, 2);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (5, 3);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (6, 1);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (6, 2);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (6, 3);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (7, 4);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (7, 5);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (7, 5);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (7, 6);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (8, 4);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (8, 5);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (9, 1);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (9, 2);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (9, 3);
INSERT INTO `seancegroupe`(`IDseance`, `IDgroupe`) 
	VALUES (10, 2);

-- Séance enseignant
INSERT INTO `seanceenseignant`(`IDseance`, `IDenseignant`) 
	VALUES (5, 5);
INSERT INTO `seanceenseignant`(`IDseance`, `IDenseignant`) 
	VALUES (6, 5);
INSERT INTO `seanceenseignant`(`IDseance`, `IDenseignant`) 
	VALUES (1, 2);
INSERT INTO `seanceenseignant`(`IDseance`, `IDenseignant`) 
	VALUES (2, 3);
INSERT INTO `seanceenseignant`(`IDseance`, `IDenseignant`) 
	VALUES (3, 2);
INSERT INTO `seanceenseignant`(`IDseance`, `IDenseignant`) 
	VALUES (4, 1);
INSERT INTO `seanceenseignant`(`IDseance`, `IDenseignant`) 
	VALUES (7, 4);
INSERT INTO `seanceenseignant`(`IDseance`, `IDenseignant`) 
	VALUES (8, 4);
INSERT INTO `seanceenseignant`(`IDseance`, `IDenseignant`) 
	VALUES (9, 2);
INSERT INTO `seanceenseignant`(`IDseance`, `IDenseignant`) 
	VALUES (10, 1);


-- Séance salle
INSERT INTO `seancesalle`(`IDseance`, `IDsalle`) 
	VALUES (1,1);
INSERT INTO `seancesalle`(`IDseance`, `IDsalle`) 
	VALUES (2,6);
INSERT INTO `seancesalle`(`IDseance`, `IDsalle`) 
	VALUES (3,6);
INSERT INTO `seancesalle`(`IDseance`, `IDsalle`) 
	VALUES (4,2);
INSERT INTO `seancesalle`(`IDseance`, `IDsalle`) 
	VALUES (5,3);
INSERT INTO `seancesalle`(`IDseance`, `IDsalle`) 
	VALUES (6,3);
INSERT INTO `seancesalle`(`IDseance`, `IDsalle`) 
	VALUES (7,2);
INSERT INTO `seancesalle`(`IDseance`, `IDsalle`) 
	VALUES (8,5);
INSERT INTO `seancesalle`(`IDseance`, `IDsalle`) 
	VALUES (9,8);
INSERT INTO `seancesalle`(`IDseance`, `IDsalle`) 
	VALUES (10,1);