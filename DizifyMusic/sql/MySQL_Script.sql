DROP TABLE IF EXISTS `administrateur`;
CREATE TABLE `administrateur`
(
    `adminId` INT(10) NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(50) NOT NULL,
    PRIMARY KEY(`adminId`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `artiste`;
CREATE TABLE `artiste`
(
    `artisteId` INT(10) NOT NULL AUTO_INCREMENT,
    `artisteNom` VARCHAR(50) NOT NULL,
    PRIMARY KEY(`artisteId`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `album`;
CREATE TABLE `album`
(
    `albumId` INT(10) NOT NULL AUTO_INCREMENT,
    `albumNom` VARCHAR(50) NOT NULL,
    `date` DATE NOT NULL,
    `artisteId` INT(10) NOT NULL,
    PRIMARY KEY(`albumId`),
    FOREIGN KEY (`artisteId`) REFERENCES `artiste` (`artisteId`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `titre`;
CREATE TABLE `titre`
(
    `titreId` INT(10) NOT NULL AUTO_INCREMENT,
    `titreNom` VARCHAR(50) NOT NULL,
    `duree` TIME NOT NULL,
    `artisteId` INT(10) NOT NULL,
    `albumId` INT(10) NOT NULL,
    PRIMARY KEY(`titreId`),
    FOREIGN KEY (`artisteId`) REFERENCES `artiste` (`artisteId`),
    FOREIGN KEY (`albumId`) REFERENCES `album` (`albumId`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE `utilisateur`
(
    `utilisateurId` INT(10) NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(50) NOT NULL,
    PRIMARY KEY(`utilisateurId`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `favori`;
CREATE TABLE `favori`
(
    `favoriId` INT(10) NOT NULL AUTO_INCREMENT,
    `utilisateurId` INT(10) NOT NULL,
    PRIMARY KEY(`favoriId`),
    FOREIGN KEY (`utilisateurId`) REFERENCES `utilisateur` (`utilisateurId`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `artisteFavori`;
CREATE TABLE `artisteFavori`
(
    `favoriId` INT(10) NOT NULL,
    `artisteId` INT(10) NOT NULL,
    PRIMARY KEY (`favoriId`, `artisteId`),
    FOREIGN KEY (`favoriId`) REFERENCES `favori` (`favoriId`),
    FOREIGN KEY (`artisteId`) REFERENCES `artiste` (`artisteId`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `albumFavori`;
CREATE TABLE `albumFavori`
(
    `favoriId` INT(10) NOT NULL,
    `albumId` INT(10) NOT NULL,
    PRIMARY KEY (`favoriId`, `albumId`),
    FOREIGN KEY (`favoriId`) REFERENCES `favori` (`favoriId`),
    FOREIGN KEY (`albumId`) REFERENCES `album` (`albumId`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `titreFavori`;
CREATE TABLE `titreFavori`
(
    `favoriId` INT(10) NOT NULL,
    `titreId` INT(10) NOT NULL,
    PRIMARY KEY (`favoriId`, `titreId`),
    FOREIGN KEY (`favoriId`) REFERENCES `favori` (`favoriId`),
    FOREIGN KEY (`titreId`) REFERENCES `titre` (`titreId`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `playlist`;
CREATE TABLE `playlist`
(
    `playlistId` INT(10) NOT NULL AUTO_INCREMENT,
    `playlistNom` VARCHAR(50) NOT NULL,
    `utilisateurId` INT(10) NOT NULL,
    PRIMARY KEY(`playlistId`),
    FOREIGN KEY (`utilisateurId`) REFERENCES `utilisateur` (`utilisateurId`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `titrePlaylist`;
CREATE TABLE `titrePlaylist`
(
    `playlistId` INT(10) NOT NULL,
    `titreId` INT(10) NOT NULL,
    PRIMARY KEY (`playlistId`, `titreId`),
    FOREIGN KEY (`playlistId`) REFERENCES `playlist` (`playlistId`),
    FOREIGN KEY (`titreId`) REFERENCES `titre` (`titreId`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;
