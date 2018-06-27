CREATE DATABASE  IF NOT EXISTS `sport-bet` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sport-bet`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sport-bet
-- ------------------------------------------------------
-- Server version	5.6.31-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `code` varchar(30) NOT NULL,
  `url365` varchar(100) NOT NULL,
  `url188` varchar(100) NOT NULL,
  `urlu1688` varchar(100) NOT NULL,
  `urlpin111` varchar(100) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` VALUES (2,'足球','football','https','https','https','https://www.pin1111.com/en/rtn','2018-06-26 16:43:29');
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport_game_odds_188`
--

DROP TABLE IF EXISTS `sport_game_odds_188`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sport_game_odds_188` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `game_id` int(11) DEFAULT NULL,
  `cid` varchar(16) DEFAULT NULL,
  `eid` varchar(16) DEFAULT NULL,
  `score_type` int(11) NOT NULL,
  `team` varchar(64) DEFAULT NULL,
  `team2` varchar(100) DEFAULT NULL,
  `score` varchar(10) DEFAULT NULL,
  `higher` varchar(10) DEFAULT NULL,
  `lower` varchar(10) DEFAULT NULL,
  `team_na` varchar(10) DEFAULT NULL,
  `team_score` varchar(10) DEFAULT NULL,
  `draw_score` varchar(10) DEFAULT NULL,
  `single_winer_score` varchar(20) DEFAULT NULL,
  `game_time` varchar(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_game_odds_188`
--

LOCK TABLES `sport_game_odds_188` WRITE;
/*!40000 ALTER TABLE `sport_game_odds_188` DISABLE KEYS */;
/*!40000 ALTER TABLE `sport_game_odds_188` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport_game_odds_365`
--

DROP TABLE IF EXISTS `sport_game_odds_365`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sport_game_odds_365` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `game_id` int(11) DEFAULT NULL,
  `cid` varchar(16) DEFAULT NULL,
  `eid` varchar(16) DEFAULT NULL,
  `score_type` int(11) NOT NULL,
  `team` varchar(64) DEFAULT NULL,
  `team2` varchar(100) DEFAULT NULL,
  `score` varchar(10) DEFAULT NULL,
  `higher` varchar(10) DEFAULT NULL,
  `lower` varchar(10) DEFAULT NULL,
  `team_na` varchar(10) DEFAULT NULL,
  `team_score` varchar(10) DEFAULT NULL,
  `draw_score` varchar(10) DEFAULT NULL,
  `single_winer_score` varchar(20) DEFAULT NULL,
  `game_time` varchar(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_game_odds_365`
--

LOCK TABLES `sport_game_odds_365` WRITE;
/*!40000 ALTER TABLE `sport_game_odds_365` DISABLE KEYS */;
INSERT INTO `sport_game_odds_365` VALUES (1,4,NULL,NULL,1,'New Zealand',NULL,NULL,NULL,NULL,'-51.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(2,4,NULL,NULL,1,'Hong Kong',NULL,NULL,NULL,NULL,'+51.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(3,4,NULL,NULL,2,NULL,NULL,'168.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(4,5,NULL,NULL,1,'China',NULL,NULL,NULL,NULL,'-1.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(5,5,NULL,NULL,1,'South Korea',NULL,NULL,NULL,NULL,'+1.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(6,5,NULL,NULL,2,NULL,NULL,'169.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(7,5,NULL,NULL,3,'China',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'5/7',NULL,'2018-06-27 18:02:44'),(8,5,NULL,NULL,3,'South Korea',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1/1',NULL,'2018-06-27 18:02:44'),(9,6,NULL,NULL,1,'Syria',NULL,NULL,NULL,NULL,'-7.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(10,6,NULL,NULL,1,'India',NULL,NULL,NULL,NULL,'+7.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(11,6,NULL,NULL,2,NULL,NULL,'145.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(12,6,NULL,NULL,3,'Syria',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'10/33',NULL,'2018-06-27 18:02:44'),(13,6,NULL,NULL,3,'India',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'12/5',NULL,'2018-06-27 18:02:44'),(14,7,NULL,NULL,1,'Lebanon',NULL,NULL,NULL,NULL,'-4.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(15,7,NULL,NULL,1,'Jordan',NULL,NULL,NULL,NULL,'+4.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(16,7,NULL,NULL,2,NULL,NULL,'166.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(17,7,NULL,NULL,3,'Lebanon',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'10/21',NULL,'2018-06-27 18:02:44'),(18,7,NULL,NULL,3,'Jordan',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'31/20',NULL,'2018-06-27 18:02:44'),(19,8,NULL,NULL,1,'Bulgaria U20',NULL,NULL,NULL,NULL,'-20.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(20,8,NULL,NULL,1,'Kosovo U20',NULL,NULL,NULL,NULL,'+20.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(21,8,NULL,NULL,2,NULL,NULL,'147.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(22,8,NULL,NULL,3,'Bulgaria U20',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1/66',NULL,'2018-06-27 18:02:44'),(23,8,NULL,NULL,3,'Kosovo U20',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'11/1',NULL,'2018-06-27 18:02:44'),(24,9,NULL,NULL,1,'Lithuania U20',NULL,NULL,NULL,NULL,'-4.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(25,9,NULL,NULL,1,'Israel U20',NULL,NULL,NULL,NULL,'+4.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(26,9,NULL,NULL,2,NULL,NULL,'152.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(27,9,NULL,NULL,3,'Lithuania U20',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1/2',NULL,'2018-06-27 18:02:44'),(28,9,NULL,NULL,3,'Israel U20',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'6/4',NULL,'2018-06-27 18:02:44'),(29,10,NULL,NULL,1,'Macedonia U20',NULL,NULL,NULL,NULL,'+14.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(30,10,NULL,NULL,1,'Russia U20',NULL,NULL,NULL,NULL,'-14.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(31,10,NULL,NULL,2,NULL,NULL,'143.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(32,10,NULL,NULL,3,'Macedonia U20',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'31/4',NULL,'2018-06-27 18:02:44'),(33,10,NULL,NULL,3,'Russia U20',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2/45',NULL,'2018-06-27 18:02:44'),(34,11,NULL,NULL,1,'Brunei',NULL,NULL,NULL,NULL,'+70.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(35,11,NULL,NULL,1,'Indonesia',NULL,NULL,NULL,NULL,'-70.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(36,11,NULL,NULL,2,NULL,NULL,'156.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(37,12,NULL,NULL,1,'Anhui Wenyi',NULL,NULL,NULL,NULL,'-14.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(38,12,NULL,NULL,1,'Lhasa Pure Land',NULL,NULL,NULL,NULL,'+14.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(39,12,NULL,NULL,2,NULL,NULL,'218.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(40,12,NULL,NULL,3,'Anhui Wenyi',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1/14',NULL,'2018-06-27 18:02:44'),(41,12,NULL,NULL,3,'Lhasa Pure Land',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'13/2',NULL,'2018-06-27 18:02:44'),(42,13,NULL,NULL,1,'Beijing Oriental Bucks',NULL,NULL,NULL,NULL,'-7.0','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(43,13,NULL,NULL,1,'Jiangsu Guoli',NULL,NULL,NULL,NULL,'+7.0','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(44,13,NULL,NULL,2,NULL,NULL,'196.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(45,13,NULL,NULL,3,'Beijing Oriental Bucks',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1/3',NULL,'2018-06-27 18:02:44'),(46,13,NULL,NULL,3,'Jiangsu Guoli',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'9/4',NULL,'2018-06-27 18:02:44'),(47,14,NULL,NULL,1,'Chongqing Lanling',NULL,NULL,NULL,NULL,'+9.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(48,14,NULL,NULL,1,'Shanxi Xinda',NULL,NULL,NULL,NULL,'-9.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(49,14,NULL,NULL,2,NULL,NULL,'209.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(50,14,NULL,NULL,3,'Chongqing Lanling',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'3/1',NULL,'2018-06-27 18:02:44'),(51,14,NULL,NULL,3,'Shanxi Xinda',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2/9',NULL,'2018-06-27 18:02:44'),(52,15,NULL,NULL,1,'Guangxi Weizhuang',NULL,NULL,NULL,NULL,'-13.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(53,15,NULL,NULL,1,'Henan Shedian',NULL,NULL,NULL,NULL,'+13.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(54,15,NULL,NULL,2,NULL,NULL,'212.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(55,15,NULL,NULL,3,'Guangxi Weizhuang',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1/11',NULL,'2018-06-27 18:02:44'),(56,15,NULL,NULL,3,'Henan Shedian',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'23/4',NULL,'2018-06-27 18:02:44'),(57,16,NULL,NULL,1,'Hebei Xianglan',NULL,NULL,NULL,NULL,'-11.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(58,16,NULL,NULL,1,'Fujian Lightning',NULL,NULL,NULL,NULL,'+11.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(59,16,NULL,NULL,2,NULL,NULL,'214.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(60,16,NULL,NULL,3,'Hebei Xianglan',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1/7',NULL,'2018-06-27 18:02:44'),(61,16,NULL,NULL,3,'Fujian Lightning',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'4/1',NULL,'2018-06-27 18:02:44'),(62,17,NULL,NULL,1,'Hefei Yuanchang',NULL,NULL,NULL,NULL,'+10.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(63,17,NULL,NULL,1,'Guizhou Senhang',NULL,NULL,NULL,NULL,'-10.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(64,17,NULL,NULL,2,NULL,NULL,'222.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(65,17,NULL,NULL,3,'Hefei Yuanchang',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'17/5',NULL,'2018-06-27 18:02:44'),(66,17,NULL,NULL,3,'Guizhou Senhang',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2/11',NULL,'2018-06-27 18:02:44'),(67,18,NULL,NULL,1,'Luoyang Zhonghe',NULL,NULL,NULL,NULL,'+7.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(68,18,NULL,NULL,1,'Hunan Yongsheng',NULL,NULL,NULL,NULL,'-7.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(69,18,NULL,NULL,2,NULL,NULL,'216.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(70,18,NULL,NULL,3,'Luoyang Zhonghe',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'23/10',NULL,'2018-06-27 18:02:44'),(71,18,NULL,NULL,3,'Hunan Yongsheng',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'5/16',NULL,'2018-06-27 18:02:44'),(72,19,NULL,NULL,1,'Malta',NULL,NULL,NULL,NULL,'+7.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(73,19,NULL,NULL,1,'Ireland',NULL,NULL,NULL,NULL,'-7.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(74,19,NULL,NULL,2,NULL,NULL,'151.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(75,19,NULL,NULL,3,'Malta',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'23/10',NULL,'2018-06-27 18:02:44'),(76,19,NULL,NULL,3,'Ireland',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'5/16',NULL,'2018-06-27 18:02:44'),(77,20,NULL,NULL,1,'Norway',NULL,NULL,NULL,NULL,'-33.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(78,20,NULL,NULL,1,'Gibraltar',NULL,NULL,NULL,NULL,'+33.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(79,20,NULL,NULL,2,NULL,NULL,'150.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(80,21,NULL,NULL,1,'Cyprus Women',NULL,NULL,NULL,NULL,'+25.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(81,21,NULL,NULL,1,'Norway Women',NULL,NULL,NULL,NULL,'-25.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(82,21,NULL,NULL,2,NULL,NULL,'121.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(83,21,NULL,NULL,3,'Cyprus Women',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'18/1',NULL,'2018-06-27 18:02:44'),(84,21,NULL,NULL,3,'Norway Women',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1/300',NULL,'2018-06-27 18:02:44'),(85,22,NULL,NULL,1,'Denmark Women',NULL,NULL,NULL,NULL,'-46.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(86,22,NULL,NULL,1,'Gibraltar Women',NULL,NULL,NULL,NULL,'+46.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(87,22,NULL,NULL,2,NULL,NULL,'134.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(88,23,NULL,NULL,1,'Ireland Women',NULL,NULL,NULL,NULL,'-7.0','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(89,23,NULL,NULL,1,'Luxembourg Women',NULL,NULL,NULL,NULL,'+7.0','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(90,23,NULL,NULL,2,NULL,NULL,'131.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(91,23,NULL,NULL,3,'Ireland Women',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1/3',NULL,'2018-06-27 18:02:44'),(92,23,NULL,NULL,3,'Luxembourg Women',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'9/4',NULL,'2018-06-27 18:02:44'),(93,24,NULL,NULL,1,'Moldova Women',NULL,NULL,NULL,NULL,'+22.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(94,24,NULL,NULL,1,'Malta Women',NULL,NULL,NULL,NULL,'-22.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(95,24,NULL,NULL,2,NULL,NULL,'130.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(96,24,NULL,NULL,3,'Moldova Women',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'14/1',NULL,'2018-06-27 18:02:44'),(97,24,NULL,NULL,3,'Malta Women',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1/100',NULL,'2018-06-27 18:02:44'),(98,25,NULL,NULL,1,'Nauticos de Mazatlan',NULL,NULL,NULL,NULL,'-3.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(99,25,NULL,NULL,1,'Pioneros de Los Mochis',NULL,NULL,NULL,NULL,'+3.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(100,25,NULL,NULL,2,NULL,NULL,'170.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(101,25,NULL,NULL,3,'Nauticos de Mazatlan',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'4/7',NULL,'2018-06-27 18:02:44'),(102,25,NULL,NULL,3,'Pioneros de Los Mochis',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'5/4',NULL,'2018-06-27 18:02:44'),(103,26,NULL,NULL,1,'Bastilla',NULL,NULL,NULL,NULL,'+9.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(104,26,NULL,NULL,1,'Inmaculada',NULL,NULL,NULL,NULL,'-9.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(105,26,NULL,NULL,2,NULL,NULL,'143.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(106,26,NULL,NULL,3,'Bastilla',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'3/1',NULL,'2018-06-27 18:02:44'),(107,26,NULL,NULL,3,'Inmaculada',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2/9',NULL,'2018-06-27 18:02:44'),(108,27,NULL,NULL,1,'Ejercito',NULL,NULL,NULL,NULL,'-4.0','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(109,27,NULL,NULL,1,'Real Club',NULL,NULL,NULL,NULL,'+4.0','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(110,27,NULL,NULL,2,NULL,NULL,'131.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(111,27,NULL,NULL,3,'Ejercito',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'5/9',NULL,'2018-06-27 18:02:44'),(112,27,NULL,NULL,3,'Real Club',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'13/10',NULL,'2018-06-27 18:02:44'),(113,28,NULL,NULL,1,'Circolo',NULL,NULL,NULL,NULL,'-17.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(114,28,NULL,NULL,1,'San Marcos',NULL,NULL,NULL,NULL,'+17.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(115,28,NULL,NULL,2,NULL,NULL,'132.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(116,28,NULL,NULL,3,'Circolo',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1/28',NULL,'2018-06-27 18:02:44'),(117,28,NULL,NULL,3,'San Marcos',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'17/2',NULL,'2018-06-27 18:02:44'),(118,29,NULL,NULL,1,'EOFAP',NULL,NULL,NULL,NULL,'+2.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(119,29,NULL,NULL,1,'Regatas de Lima',NULL,NULL,NULL,NULL,'-2.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(120,29,NULL,NULL,2,NULL,NULL,'130.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(121,29,NULL,NULL,3,'EOFAP',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'11/10',NULL,'2018-06-27 18:02:44'),(122,29,NULL,NULL,3,'Regatas de Lima',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'4/6',NULL,'2018-06-27 18:02:44'),(123,30,NULL,NULL,1,'Bataan Risers',NULL,NULL,NULL,NULL,'+5.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(124,30,NULL,NULL,1,'Batangas City Athletics',NULL,NULL,NULL,NULL,'-5.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(125,30,NULL,NULL,2,NULL,NULL,'168.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(126,30,NULL,NULL,3,'Bataan Risers',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'33/20',NULL,'2018-06-27 18:02:44'),(127,30,NULL,NULL,3,'Batangas City Athletics',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'10/23',NULL,'2018-06-27 18:02:44'),(128,31,NULL,NULL,1,'CSB Blazers',NULL,NULL,NULL,NULL,'-2.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(129,31,NULL,NULL,1,'UP Fighting Maroons',NULL,NULL,NULL,NULL,'+2.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(130,31,NULL,NULL,2,NULL,NULL,'151.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(131,31,NULL,NULL,3,'CSB Blazers',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'4/6',NULL,'2018-06-27 18:02:44'),(132,31,NULL,NULL,3,'UP Fighting Maroons',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'11/10',NULL,'2018-06-27 18:02:44'),(133,32,NULL,NULL,1,'SBC Red Lions',NULL,NULL,NULL,NULL,'-3.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(134,32,NULL,NULL,1,'ADU Falcons',NULL,NULL,NULL,NULL,'+3.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(135,32,NULL,NULL,2,NULL,NULL,'150.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(136,32,NULL,NULL,3,'SBC Red Lions',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'4/7',NULL,'2018-06-27 18:02:44'),(137,32,NULL,NULL,3,'ADU Falcons',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'5/4',NULL,'2018-06-27 18:02:44'),(138,33,NULL,NULL,1,'FEU Tamaraws',NULL,NULL,NULL,NULL,'-1.0','20/23',NULL,NULL,NULL,'2018-06-27 18:02:44'),(139,33,NULL,NULL,1,'DLSU Green Archers',NULL,NULL,NULL,NULL,'+1.0','4/5',NULL,NULL,NULL,'2018-06-27 18:02:44'),(140,33,NULL,NULL,2,NULL,NULL,'153.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(141,33,NULL,NULL,3,'FEU Tamaraws',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'5/6',NULL,'2018-06-27 18:02:44'),(142,33,NULL,NULL,3,'DLSU Green Archers',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'5/6',NULL,'2018-06-27 18:02:44'),(143,34,NULL,NULL,1,'Ateneo Blue Eagles',NULL,NULL,NULL,NULL,'-6.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(144,34,NULL,NULL,1,'CSJL Knights',NULL,NULL,NULL,NULL,'+6.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(145,34,NULL,NULL,2,NULL,NULL,'157.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(146,34,NULL,NULL,3,'Ateneo Blue Eagles',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'10/27',NULL,'2018-06-27 18:02:44'),(147,34,NULL,NULL,3,'CSJL Knights',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'39/20',NULL,'2018-06-27 18:02:44'),(148,35,NULL,NULL,1,'KCCA Men',NULL,NULL,NULL,NULL,'+14.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(149,35,NULL,NULL,1,'Pemba Warriors',NULL,NULL,NULL,NULL,'-14.5','5/6',NULL,NULL,NULL,'2018-06-27 18:02:44'),(150,35,NULL,NULL,2,NULL,NULL,'138.5','5/6','5/6',NULL,NULL,NULL,NULL,NULL,'2018-06-27 18:02:44'),(151,35,NULL,NULL,3,'KCCA Men',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'13/2',NULL,'2018-06-27 18:02:44'),(152,35,NULL,NULL,3,'Pemba Warriors',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1/14',NULL,'2018-06-27 18:02:44');
/*!40000 ALTER TABLE `sport_game_odds_365` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport_game_odds_pin111`
--

DROP TABLE IF EXISTS `sport_game_odds_pin111`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sport_game_odds_pin111` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `game_id` int(11) DEFAULT NULL,
  `cid` varchar(16) DEFAULT NULL,
  `eid` varchar(16) DEFAULT NULL,
  `score_type` int(11) NOT NULL,
  `team` varchar(64) DEFAULT NULL,
  `team2` varchar(100) DEFAULT NULL,
  `score` varchar(10) DEFAULT NULL,
  `higher` varchar(10) DEFAULT NULL,
  `lower` varchar(10) DEFAULT NULL,
  `team_na` varchar(10) DEFAULT NULL,
  `team_score` varchar(10) DEFAULT NULL,
  `draw_score` varchar(10) DEFAULT NULL,
  `single_winer_score` varchar(20) DEFAULT NULL,
  `game_time` varchar(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_game_odds_pin111`
--

LOCK TABLES `sport_game_odds_pin111` WRITE;
/*!40000 ALTER TABLE `sport_game_odds_pin111` DISABLE KEYS */;
/*!40000 ALTER TABLE `sport_game_odds_pin111` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport_game_odds_u1688`
--

DROP TABLE IF EXISTS `sport_game_odds_u1688`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sport_game_odds_u1688` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `game_id` int(11) DEFAULT NULL,
  `cid` varchar(16) DEFAULT NULL,
  `eid` varchar(16) DEFAULT NULL,
  `score_type` int(11) NOT NULL,
  `team` varchar(64) DEFAULT NULL,
  `team2` varchar(100) DEFAULT NULL,
  `score` varchar(10) DEFAULT NULL,
  `higher` varchar(10) DEFAULT NULL,
  `lower` varchar(10) DEFAULT NULL,
  `team_na` varchar(10) DEFAULT NULL,
  `team_score` varchar(10) DEFAULT NULL,
  `draw_score` varchar(10) DEFAULT NULL,
  `single_winer_score` varchar(20) DEFAULT NULL,
  `game_time` varchar(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_game_odds_u1688`
--

LOCK TABLES `sport_game_odds_u1688` WRITE;
/*!40000 ALTER TABLE `sport_game_odds_u1688` DISABLE KEYS */;
INSERT INTO `sport_game_odds_u1688` VALUES (1,0,'52243','2426369',1,'Indonesia (n)','Brunei Darussalam',NULL,NULL,NULL,'-68.50','1.60',NULL,NULL,NULL,'2018-06-27 16:51:27'),(2,0,'52243','2426369',1,'Indonesia (n)','Brunei Darussalam',NULL,NULL,NULL,'68.50','2.28',NULL,NULL,NULL,'2018-06-27 16:51:27'),(3,0,'30463','2414393',1,'Anhui Wenyi','Lhasa Sukhavati',NULL,NULL,NULL,'-10.50','1.91',NULL,NULL,NULL,'2018-06-27 16:51:27'),(4,0,'30463','2414393',1,'Anhui Wenyi','Lhasa Sukhavati',NULL,NULL,NULL,'10.50','1.91',NULL,NULL,NULL,'2018-06-27 16:51:27'),(5,0,'51241','2396787',1,'Republic of Ireland','Malta',NULL,NULL,NULL,'-5.50','1.65',NULL,NULL,NULL,'2018-06-27 16:51:27'),(6,0,'51241','2396787',1,'Republic of Ireland','Malta',NULL,NULL,NULL,'5.50','2.20',NULL,NULL,NULL,'2018-06-27 16:51:27');
/*!40000 ALTER TABLE `sport_game_odds_u1688` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport_module_188`
--

DROP TABLE IF EXISTS `sport_module_188`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sport_module_188` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` int(11) NOT NULL,
  `cid` varchar(30) DEFAULT NULL,
  `group_name` varchar(100) DEFAULT NULL,
  `group_item_name` varchar(30) DEFAULT NULL,
  `game_lines_pd` varchar(100) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_module_188`
--

LOCK TABLES `sport_module_188` WRITE;
/*!40000 ALTER TABLE `sport_module_188` DISABLE KEYS */;
INSERT INTO `sport_module_188` VALUES (1,1,'75105','FIBA Asia Cup 2021 SEABA Pre-Qualifier (In THA)',NULL,NULL,'2018-06-27 17:20:35');
/*!40000 ALTER TABLE `sport_module_188` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport_module_365`
--

DROP TABLE IF EXISTS `sport_module_365`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sport_module_365` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` int(11) NOT NULL,
  `cid` varchar(30) DEFAULT NULL,
  `group_name` varchar(30) DEFAULT NULL,
  `group_item_name` varchar(30) DEFAULT NULL,
  `game_lines_pd` varchar(100) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_module_365`
--

LOCK TABLES `sport_module_365` WRITE;
/*!40000 ALTER TABLE `sport_module_365` DISABLE KEYS */;
INSERT INTO `sport_module_365` VALUES (1,1,NULL,'WNBA',NULL,'#AC#B18#C20380036#D48#E1#F36#P^48#Q^1#I','2018-06-27 18:01:52'),(2,1,NULL,'FIBA世界杯资格赛',NULL,'#AC#B18#C20591105#D48#E1#F36#P^48#Q^1#I','2018-06-27 18:01:52'),(3,1,NULL,'国际赛',NULL,'#AC#B18#C20588974#D48#E1#F36#P^48#Q^1#I','2018-06-27 18:01:52'),(4,1,NULL,'篮球赛事',NULL,'#AC#B18#C20494612#D48#E1#F36#P^48#Q^1#I','2018-06-27 18:01:52'),(5,1,NULL,'中国全国男子篮球联赛',NULL,'#AC#B18#C20588724#D48#E1#F36#P^48#Q^1#I','2018-06-27 18:01:52'),(6,1,NULL,'欧洲锦标赛SCD',NULL,'#AC#B18#C20591006#D48#E1#F36#P^48#Q^1#I','2018-06-27 18:01:52'),(7,1,NULL,'欧洲锦标赛SCD 女子',NULL,'#AC#B18#C20591007#D48#E1#F36#P^48#Q^1#I','2018-06-27 18:01:52'),(8,1,NULL,'墨西哥CIBACOPA',NULL,'#AC#B18#C20579165#D48#E1#F36#P^48#Q^1#I','2018-06-27 18:01:52'),(9,1,NULL,'秘鲁Liga de Lima',NULL,'#AC#B18#C20579294#D48#E1#F36#P^48#Q^1#I','2018-06-27 18:01:52'),(10,1,NULL,'Philippines MPBL',NULL,'#AC#B18#C20589303#D48#E1#F36#P^48#Q^1#I','2018-06-27 18:01:52'),(11,1,NULL,'菲律宾超级杯',NULL,'#AC#B18#C20581670#D48#E1#F36#P^48#Q^1#I','2018-06-27 18:01:52'),(12,1,NULL,'乌干达NBL',NULL,'#AC#B18#C20590418#D48#E1#F36#P^48#Q^1#I','2018-06-27 18:01:52');
/*!40000 ALTER TABLE `sport_module_365` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport_module_game_188`
--

DROP TABLE IF EXISTS `sport_module_game_188`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sport_module_game_188` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` int(11) NOT NULL,
  `sport_group_id` int(11) DEFAULT NULL,
  `cid` varchar(16) DEFAULT NULL,
  `eid` varchar(16) DEFAULT NULL,
  `team_name1` varchar(64) DEFAULT NULL,
  `team_name2` varchar(64) DEFAULT NULL,
  `deail_pd` varchar(100) DEFAULT NULL,
  `game_time` varchar(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_module_game_188`
--

LOCK TABLES `sport_module_game_188` WRITE;
/*!40000 ALTER TABLE `sport_module_game_188` DISABLE KEYS */;
INSERT INTO `sport_module_game_188` VALUES (1,1,0,'75105','2640346','Singapore','Thailand',NULL,'27 Jun,16:30','2018-06-27 17:20:35');
/*!40000 ALTER TABLE `sport_module_game_188` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport_module_game_365`
--

DROP TABLE IF EXISTS `sport_module_game_365`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sport_module_game_365` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` int(11) NOT NULL,
  `sport_group_id` int(11) DEFAULT NULL,
  `cid` varchar(16) DEFAULT NULL,
  `eid` varchar(16) DEFAULT NULL,
  `team_name1` varchar(64) DEFAULT NULL,
  `team_name2` varchar(64) DEFAULT NULL,
  `deail_pd` varchar(100) DEFAULT NULL,
  `game_time` varchar(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_module_game_365`
--

LOCK TABLES `sport_module_game_365` WRITE;
/*!40000 ALTER TABLE `sport_module_game_365` DISABLE KEYS */;
INSERT INTO `sport_module_game_365` VALUES (1,1,1,NULL,NULL,'ATL Dream','CHI Sky','#AC#B18#C20380036#D19#E5859459#F19#P^48#Q^1#W^36','20180627170000','2018-06-27 18:02:06'),(2,1,1,NULL,NULL,'IND Fever','CON Sun','#AC#B18#C20380036#D19#E5859460#F19#P^48#Q^1#W^36','20180628000000','2018-06-27 18:02:06'),(3,1,1,NULL,NULL,'DAL Wings','LV Aces','#AC#B18#C20380036#D19#E5859461#F19#P^48#Q^1#W^36','20180628030000','2018-06-27 18:02:06'),(4,1,2,NULL,NULL,'New Zealand','Hong Kong','#AC#B18#C20591105#D19#E5863795#F19#P^48#Q^1#W^36','20180628081000','2018-06-27 18:02:06'),(5,1,2,NULL,NULL,'China','South Korea','#AC#B18#C20591105#D19#E5863796#F19#P^48#Q^1#W^36','20180628123000','2018-06-27 18:02:06'),(6,1,2,NULL,NULL,'Syria','India','#AC#B18#C20591105#D19#E5863797#F19#P^48#Q^1#W^36','20180628150000','2018-06-27 18:02:06'),(7,1,2,NULL,NULL,'Lebanon','Jordan','#AC#B18#C20591105#D19#E5863804#F19#P^48#Q^1#W^36','20180628193000','2018-06-27 18:02:06'),(8,1,3,NULL,NULL,'Bulgaria U20','Kosovo U20','#AC#B18#C20588974#D19#E5874477#F19#P^48#Q^1#W^36','20180627160000','2018-06-27 18:02:06'),(9,1,3,NULL,NULL,'Lithuania U20','Israel U20','#AC#B18#C20588974#D19#E5873616#F19#P^48#Q^1#W^36','20180627160000','2018-06-27 18:02:06'),(10,1,3,NULL,NULL,'Macedonia U20','Russia U20','#AC#B18#C20588974#D19#E5873617#F19#P^48#Q^1#W^36','20180627180000','2018-06-27 18:02:06'),(11,1,4,NULL,NULL,'Brunei','Indonesia','#AC#B18#C20494612#D19#E5873769#F19#P^48#Q^1#W^36','20180627121500','2018-06-27 18:02:06'),(12,1,5,NULL,NULL,'Anhui Wenyi','Lhasa Pure Land','#AC#B18#C20588724#D19#E5864352#F19#P^48#Q^1#W^36','20180627123000','2018-06-27 18:02:06'),(13,1,5,NULL,NULL,'Beijing Oriental Bucks','Jiangsu Guoli','#AC#B18#C20588724#D19#E5864353#F19#P^48#Q^1#W^36','20180627123000','2018-06-27 18:02:06'),(14,1,5,NULL,NULL,'Chongqing Lanling','Shanxi Xinda','#AC#B18#C20588724#D19#E5864354#F19#P^48#Q^1#W^36','20180627123000','2018-06-27 18:02:06'),(15,1,5,NULL,NULL,'Guangxi Weizhuang','Henan Shedian','#AC#B18#C20588724#D19#E5864355#F19#P^48#Q^1#W^36','20180627123000','2018-06-27 18:02:06'),(16,1,5,NULL,NULL,'Hebei Xianglan','Fujian Lightning','#AC#B18#C20588724#D19#E5864356#F19#P^48#Q^1#W^36','20180627123000','2018-06-27 18:02:06'),(17,1,5,NULL,NULL,'Hefei Yuanchang','Guizhou Senhang','#AC#B18#C20588724#D19#E5864357#F19#P^48#Q^1#W^36','20180627123000','2018-06-27 18:02:06'),(18,1,5,NULL,NULL,'Luoyang Zhonghe','Hunan Yongsheng','#AC#B18#C20588724#D19#E5864358#F19#P^48#Q^1#W^36','20180627123000','2018-06-27 18:02:06'),(19,1,6,NULL,NULL,'Malta','Ireland','#AC#B18#C20591006#D19#E5863973#F19#P^48#Q^1#W^36','20180627140000','2018-06-27 18:02:06'),(20,1,6,NULL,NULL,'Norway','Gibraltar','#AC#B18#C20591006#D19#E5863974#F19#P^48#Q^1#W^36','20180627163000','2018-06-27 18:02:06'),(21,1,7,NULL,NULL,'Cyprus Women','Norway Women','#AC#B18#C20591007#D19#E5863976#F19#P^48#Q^1#W^36','20180627134500','2018-06-27 18:02:06'),(22,1,7,NULL,NULL,'Denmark Women','Gibraltar Women','#AC#B18#C20591007#D19#E5863977#F19#P^48#Q^1#W^36','20180627160000','2018-06-27 18:02:06'),(23,1,7,NULL,NULL,'Ireland Women','Luxembourg Women','#AC#B18#C20591007#D19#E5863978#F19#P^48#Q^1#W^36','20180627181500','2018-06-27 18:02:06'),(24,1,7,NULL,NULL,'Moldova Women','Malta Women','#AC#B18#C20591007#D19#E5863979#F19#P^48#Q^1#W^36','20180627203000','2018-06-27 18:02:06'),(25,1,8,NULL,NULL,'Nauticos de Mazatlan','Pioneros de Los Mochis','#AC#B18#C20579165#D19#E5878424#F19#P^48#Q^1#W^36','20180628021500','2018-06-27 18:02:06'),(26,1,9,NULL,NULL,'Bastilla','Inmaculada','#AC#B18#C20579294#D19#E5873597#F19#P^48#Q^1#W^36','20180628014500','2018-06-27 18:02:06'),(27,1,9,NULL,NULL,'Ejercito','Real Club','#AC#B18#C20579294#D19#E5873598#F19#P^48#Q^1#W^36','20180628014500','2018-06-27 18:02:06'),(28,1,9,NULL,NULL,'Circolo','San Marcos','#AC#B18#C20579294#D19#E5873599#F19#P^48#Q^1#W^36','20180628031500','2018-06-27 18:02:06'),(29,1,9,NULL,NULL,'EOFAP','Regatas de Lima','#AC#B18#C20579294#D19#E5873600#F19#P^48#Q^1#W^36','20180628031500','2018-06-27 18:02:06'),(30,1,10,NULL,NULL,'Bataan Risers','Batangas City Athletics','#AC#B18#C20589303#D19#E5864086#F19#P^48#Q^1#W^36','20180627140000','2018-06-27 18:02:06'),(31,1,11,NULL,NULL,'CSB Blazers','UP Fighting Maroons','#AC#B18#C20581670#D19#E5873594#F19#P^48#Q^1#W^36','20180628060000','2018-06-27 18:02:06'),(32,1,11,NULL,NULL,'SBC Red Lions','ADU Falcons','#AC#B18#C20581670#D19#E5873595#F19#P^48#Q^1#W^36','Red Lions','2018-06-27 18:02:06'),(33,1,11,NULL,NULL,'FEU Tamaraws','DLSU Green Archers','#AC#B18#C20581670#D19#E5873596#F19#P^48#Q^1#W^36','20180628093000','2018-06-27 18:02:06'),(34,1,11,NULL,NULL,'Ateneo Blue Eagles','CSJL Knights','#AC#B18#C20581670#D19#E5873158#F19#P^48#Q^1#W^36','20180628120000','2018-06-27 18:02:06'),(35,1,12,NULL,NULL,'KCCA Men','Pemba Warriors','#AC#B18#C20590418#D19#E5864089#F19#P^48#Q^1#W^36','20180627180000','2018-06-27 18:02:06');
/*!40000 ALTER TABLE `sport_module_game_365` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport_module_game_pin111`
--

DROP TABLE IF EXISTS `sport_module_game_pin111`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sport_module_game_pin111` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` int(11) NOT NULL,
  `sport_group_id` int(11) DEFAULT NULL,
  `cid` varchar(16) DEFAULT NULL,
  `eid` varchar(16) DEFAULT NULL,
  `team_name1` varchar(64) DEFAULT NULL,
  `team_name2` varchar(64) DEFAULT NULL,
  `deail_pd` varchar(100) DEFAULT NULL,
  `game_time` varchar(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_module_game_pin111`
--

LOCK TABLES `sport_module_game_pin111` WRITE;
/*!40000 ALTER TABLE `sport_module_game_pin111` DISABLE KEYS */;
/*!40000 ALTER TABLE `sport_module_game_pin111` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport_module_game_u1688`
--

DROP TABLE IF EXISTS `sport_module_game_u1688`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sport_module_game_u1688` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` int(11) NOT NULL,
  `sport_group_id` int(11) DEFAULT NULL,
  `cid` varchar(16) DEFAULT NULL,
  `eid` varchar(16) DEFAULT NULL,
  `team_name1` varchar(64) DEFAULT NULL,
  `team_name2` varchar(64) DEFAULT NULL,
  `deail_pd` varchar(100) DEFAULT NULL,
  `game_time` varchar(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_module_game_u1688`
--

LOCK TABLES `sport_module_game_u1688` WRITE;
/*!40000 ALTER TABLE `sport_module_game_u1688` DISABLE KEYS */;
INSERT INTO `sport_module_game_u1688` VALUES (1,1,0,'52243','2426369','Indonesia (n)','Brunei Darussalam',NULL,'06/27/2018 19:15','2018-06-27 16:51:26'),(2,1,0,'30463','2414393','Anhui Wenyi','Lhasa Sukhavati',NULL,'06/27/2018 19:30','2018-06-27 16:51:26'),(3,1,0,'51241','2396787','Republic of Ireland','Malta',NULL,'06/27/2018 21:00','2018-06-27 16:51:26');
/*!40000 ALTER TABLE `sport_module_game_u1688` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport_module_pin111`
--

DROP TABLE IF EXISTS `sport_module_pin111`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sport_module_pin111` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` int(11) NOT NULL,
  `cid` varchar(30) DEFAULT NULL,
  `group_name` varchar(30) DEFAULT NULL,
  `group_item_name` varchar(100) DEFAULT NULL,
  `game_lines_pd` varchar(100) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_module_pin111`
--

LOCK TABLES `sport_module_pin111` WRITE;
/*!40000 ALTER TABLE `sport_module_pin111` DISABLE KEYS */;
/*!40000 ALTER TABLE `sport_module_pin111` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport_module_u1688`
--

DROP TABLE IF EXISTS `sport_module_u1688`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sport_module_u1688` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` int(11) NOT NULL,
  `cid` varchar(30) DEFAULT NULL,
  `group_name` varchar(30) DEFAULT NULL,
  `group_item_name` varchar(30) DEFAULT NULL,
  `game_lines_pd` varchar(100) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_module_u1688`
--

LOCK TABLES `sport_module_u1688` WRITE;
/*!40000 ALTER TABLE `sport_module_u1688` DISABLE KEYS */;
/*!40000 ALTER TABLE `sport_module_u1688` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-27 18:09:41
