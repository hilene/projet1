-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 19 déc. 2017 à 15:20
-- Version du serveur :  10.1.28-MariaDB
-- Version de PHP :  7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxibanquehiko`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` int(20) NOT NULL,
  `nomClient` varchar(30) NOT NULL,
  `prenomClient` varchar(30) NOT NULL,
  `adresseClient` varchar(60) NOT NULL,
  `codePostalClient` int(5) NOT NULL,
  `villeClient` varchar(30) NOT NULL,
  `telClient` varchar(30) NOT NULL,
  `emailClient` varchar(30) NOT NULL,
  `typeClient` varchar(30) NOT NULL,
  `idConseiller` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idClient`, `nomClient`, `prenomClient`, `adresseClient`, `codePostalClient`, `villeClient`, `telClient`, `emailClient`, `typeClient`, `idConseiller`) VALUES
(1, 'Rajendran', 'Kogulan', '52 rue Gutenberg', 93310, 'Le Pré Saint Gervais', '0141715495', 'kogul@hotmail.fr', 'ENTREPRISE', 1),
(2, 'Lin', 'Hilene', '12 avenue George', 75016, 'Paris', '0000000', 'hilene.lin@gmail.com', 'ENTREPRISE', 1),
(3, 'Luc', 'Girard', '12 rue baudin', 93310, 'Pré saint Gervais', '', 'jen.luc@gmail.com', 'ENTREPRISE', 1),
(4, 'Grimaldi', 'Stanislas', '86 Boulevard Malesherbes', 75008, 'Paris', '0654821612', 'stan.grimaldi@stan.fr', 'ENTREPRISE', 3),
(5, 'Blackwell', 'Paul', '4 Bis Allée Florent Schmitt', 92210, 'Saint Cloud', '0654821614', 'paul.blackwell@gmail.com', 'ENTREPRISE', 3),
(6, 'Funck-Brentano ', 'Mathieu', '118 rue Assas ', 75006, 'Paris', '0685479632', 'mathieu.brentano@funck.fr', 'ENTREPRISE', 3),
(7, 'Roberto', 'Carlos', '115 rue de la Loire', 94120, 'Bondy', '0145789563', 'carlos.robertos@gmail.fr', 'ENTREPRISE', 3);

-- --------------------------------------------------------

--
-- Structure de la table `comptecourant`
--

CREATE TABLE `comptecourant` (
  `idCompte` int(11) NOT NULL,
  `soldeCompte` float NOT NULL,
  `dateOuvertureCompte` varchar(20) NOT NULL,
  `idClient` int(11) NOT NULL,
  `decouvertAutoriser` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `comptecourant`
--

INSERT INTO `comptecourant` (`idCompte`, `soldeCompte`, `dateOuvertureCompte`, `idClient`, `decouvertAutoriser`) VALUES
(6, 300, '10/07/2009', 1, 1000),
(9, 300000, '18/12/2017', 2, 1200),
(13, 35000, '2017-12-19', 3, 1000),
(14, 15000, '12/01/2007', 4, 1000),
(15, 600, '26/07/2012', 5, 500),
(16, 1450, '2017-11-08', 6, 1200),
(20, 2600, '15/08/2010', 7, 1200);

-- --------------------------------------------------------

--
-- Structure de la table `compteepargne`
--

CREATE TABLE `compteepargne` (
  `idCompte` int(11) NOT NULL,
  `soldeCompte` float NOT NULL,
  `dateOuvertureCompte` varchar(20) NOT NULL,
  `idClient` int(11) NOT NULL,
  `tauxRemuneration` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compteepargne`
--

INSERT INTO `compteepargne` (`idCompte`, `soldeCompte`, `dateOuvertureCompte`, `idClient`, `tauxRemuneration`) VALUES
(1, 35000, '10/12/2016', 1, 0.03),
(2, 200000, '2017-12-19', 2, 0.029999999329447746),
(3, 25000, '2017-12-07', 5, 0.029999999329447746),
(4, 350000, '12/11/1996', 4, 0.05);

-- --------------------------------------------------------

--
-- Structure de la table `conseiller`
--

CREATE TABLE `conseiller` (
  `idConseiller` int(11) NOT NULL,
  `nomConseiller` varchar(30) NOT NULL,
  `loginConseiller` varchar(30) NOT NULL,
  `mdpConseiller` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `conseiller`
--

INSERT INTO `conseiller` (`idConseiller`, `nomConseiller`, `loginConseiller`, `mdpConseiller`) VALUES
(1, 'Kogulan', 'Kogu', '1234'),
(2, 'Hilene', 'hilene.lin', '5678'),
(3, 'Yann', 'Yann', 'password');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`);

--
-- Index pour la table `comptecourant`
--
ALTER TABLE `comptecourant`
  ADD PRIMARY KEY (`idCompte`),
  ADD KEY `idClient` (`idClient`);

--
-- Index pour la table `compteepargne`
--
ALTER TABLE `compteepargne`
  ADD PRIMARY KEY (`idCompte`),
  ADD KEY `idClient` (`idClient`);

--
-- Index pour la table `conseiller`
--
ALTER TABLE `conseiller`
  ADD PRIMARY KEY (`idConseiller`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `comptecourant`
--
ALTER TABLE `comptecourant`
  MODIFY `idCompte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `compteepargne`
--
ALTER TABLE `compteepargne`
  MODIFY `idCompte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `conseiller`
--
ALTER TABLE `conseiller`
  MODIFY `idConseiller` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
