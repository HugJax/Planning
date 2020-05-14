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
  `Groupe` int(11) NOT NULL,
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
  `Numero` int(11) NOT NULL,
  `IDgroupe` int(11) NOT NULL,
  `IDpromo` int(11) NOT NULL,
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
  `IDseance` int(11) NOT NULL,
  `IDgroupe` int(11) NOT NULL,
  KEY `IDseance` (`IDseance`),
  KEY `IDgroupe` (`IDgroupe`),
  PRIMARY KEY (`IDseance`)
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

DROP TABLE IF EXISTS `seancegroupe`;
CREATE TABLE IF NOT EXISTS `seancegroupe` (
  `IDseance` int(11) NOT NULL,
  `IDsalle` int(11) NOT NULL,
  KEY `IDseance` (`IDseance`),
  KEY `IDsalle` (`IDsalle`),
  PRIMARY KEY (`IDseance`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


--------------------------------------------------------------
--------------------------------------------------------------

-- Promo
INSERT INTO `promotion`(`Promo`)
	VALUES (`Premier Cycle`);
INSERT INTO `promotion`(`Promo`)
	VALUES (`Second Cycle`);
INSERT INTO `promotion`(`Promo`)
	VALUES (`Dernier Cycle`);

-- Groupe
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD1', (SELECT IDgroupe FROM promotion WHERE IDpromo=1));
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD2', (SELECT IDgroupe FROM promotion WHERE IDpromo=1));
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD3', (SELECT IDgroupe FROM promotion WHERE IDpromo=1));
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD1', (SELECT IDgroupe FROM promotion WHERE IDpromo=2));
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD2', (SELECT IDgroupe FROM promotion WHERE IDpromo=2));
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD3', (SELECT IDgroupe FROM promotion WHERE IDpromo=2));
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD1', (SELECT IDgroupe FROM promotion WHERE IDpromo=3));
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD2', (SELECT IDgroupe FROM promotion WHERE IDpromo=3));
INSERT INTO `groupe`(`Groupe`, `IDpromo`)
	VALUES ('TD3', (SELECT IDgroupe FROM promotion WHERE IDpromo=3));

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
	VALUES (1, 20200611, 8, 9, 1, (SELECT IDcours FROM cours WHERE IDcours=1), (SELECT IDtypecours FROM typecours WHERE IDtypecours=1));

-- Admin
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('admin', 'admin', 'Bonisseur de La Bath', 'Hubert', 1);
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ('adminbis', 'adminbis', 'NomdeFamille', 'Prenom', 1);

-- Référent
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();

-- Enseignant
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `enseignant`(`IDenseignant`, `IDcours`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `enseignant`(`IDenseignant`, `IDcours`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `enseignant`(`IDenseignant`, `IDcours`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `enseignant`(`IDenseignant`, `IDcours`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `enseignant`(`IDenseignant`, `IDcours`)
	VALUES ();

-- Etudiant
	--Promo1
		--TD1
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();

		--TD2
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();

		--TD3
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();

	--Promo2
		--TD1
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();

		--TD2
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();

		--TD3
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();

	--Promo3
		--TD1
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();

		--TD2
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();

		--TD3
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();
INSERT INTO `utilisateur`(`Email`, `MotDePasse`, `Nom`, `Prenom`, `Droit`)
	VALUES ();
INSERT INTO `etudiant`(`IDetudiant`, `Numero`, `IDgroupe`, `IDpromo`)
	VALUES ();

-- Séance groupe

-- Séance enseignant

-- Séance salle