DROP TABLE IF EXISTS `administrateur`;
CREATE TABLE `administrateur`
(
    `admin_id` INT(10) NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(50) NOT NULL,
    PRIMARY KEY(`admin_id`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `artiste`;
CREATE TABLE `artiste`
(
    `artiste_id` INT(10) NOT NULL AUTO_INCREMENT,
    `artiste_nom` VARCHAR(50) NOT NULL,
    PRIMARY KEY(`artiste_id`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `album`;
CREATE TABLE `album`
(
    `album_id` INT(10) NOT NULL AUTO_INCREMENT,
    `album_nom` VARCHAR(50) NOT NULL,
    `date` DATE NOT NULL,
    `artiste_id` INT(10) NOT NULL,
    PRIMARY KEY(`album_id`),
    FOREIGN KEY (`artiste_id`) REFERENCES `artiste` (`artiste_id`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `titre`;
CREATE TABLE `titre`
(
    `titre_id` INT(10) NOT NULL AUTO_INCREMENT,
    `titre_nom` VARCHAR(50) NOT NULL,
    `duree` VARCHAR(50) NOT NULL,
    `artiste_id` INT(10) NOT NULL,
    `album_id` INT(10) NOT NULL,
    PRIMARY KEY(`titre_id`),
    FOREIGN KEY (`artiste_id`) REFERENCES `artiste` (`artiste_id`),
    FOREIGN KEY (`album_id`) REFERENCES `album` (`album_id`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE `utilisateur`
(
    `utilisateur_id` INT(10) NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(50) NOT NULL,
    `is_admin` BOOLEAN NOT NULL,
    PRIMARY KEY(`utilisateur_id`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `favori`;
CREATE TABLE `favori`
(
    `favori_id` INT(10) NOT NULL AUTO_INCREMENT,
    `utilisateur_id` INT(10) NOT NULL,
    PRIMARY KEY(`favori_id`),
    FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`utilisateur_id`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `artiste_favori`;
CREATE TABLE `artiste_favori`
(
    `favori_id` INT(10) NOT NULL,
    `artiste_id` INT(10),
    PRIMARY KEY (`favori_id`, `artiste_id`),
    FOREIGN KEY (`favori_id`) REFERENCES `favori` (`favori_id`),
    FOREIGN KEY (`artiste_id`) REFERENCES `artiste` (`artiste_id`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `album_favori`;
CREATE TABLE `album_favori`
(
    `favori_id` INT(10) NOT NULL,
    `album_id` INT(10),
    PRIMARY KEY (`favori_id`, `album_id`),
    FOREIGN KEY (`favori_id`) REFERENCES `favori` (`favori_id`),
    FOREIGN KEY (`album_id`) REFERENCES `album` (`album_id`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `titre_favori`;
CREATE TABLE `titre_favori`
(
    `favori_id` INT(10) NOT NULL,
    `titre_id` INT(10),
    PRIMARY KEY (`favori_id`, `titre_id`),
    FOREIGN KEY (`favori_id`) REFERENCES `favori` (`favori_id`),
    FOREIGN KEY (`titre_id`) REFERENCES `titre` (`titre_id`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `playlist`;
CREATE TABLE `playlist`
(
    `playlist_id` INT(10) NOT NULL AUTO_INCREMENT,
    `playlist_nom` VARCHAR(50) NOT NULL,
    `utilisateur_id` INT(10) NOT NULL,
    PRIMARY KEY(`playlist_id`),
    FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`utilisateur_id`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `titre_playlist`;
CREATE TABLE `titre_playlist`
(
    `playlist_id` INT(10) NOT NULL,
    `titre_id` INT(10) NOT NULL,
    PRIMARY KEY (`playlist_id`, `titre_id`),
    FOREIGN KEY (`playlist_id`) REFERENCES `playlist` (`playlist_id`),
    FOREIGN KEY (`titre_id`) REFERENCES `titre` (`titre_id`)
) ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;
