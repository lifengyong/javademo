CREATE DATABASE  IF NOT EXISTS `javademo`;
USE `javademo`;

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `score` int(11) DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;


LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1001,'lihe',80,'2016-06-06 13:31:50'),(1002,'yang',90,'2016-06-07 13:31:50'),(1003,'zhang',85,'2016-06-08 13:31:50');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;