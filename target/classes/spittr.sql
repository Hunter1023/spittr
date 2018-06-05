DROP TABLE IF EXISTS `spitter`;

CREATE TABLE `spitter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `headIcon` varchar(45) DEFAULT NULL,
  `thumbnail` varchar(45) DEFAULT NULL,
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(48) NOT NULL COMMENT '密码',
  `nickname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `spittle`;

CREATE TABLE `spittle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(280) NOT NULL,
  `time` datetime(6) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

