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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_game_odds_365`
--

LOCK TABLES `sport_game_odds_365` WRITE;
/*!40000 ALTER TABLE `sport_game_odds_365` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_game_odds_u1688`
--

LOCK TABLES `sport_game_odds_u1688` WRITE;
/*!40000 ALTER TABLE `sport_game_odds_u1688` DISABLE KEYS */;
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
  `group_name` varchar(30) DEFAULT NULL,
  `group_item_name` varchar(30) DEFAULT NULL,
  `game_lines_pd` varchar(100) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_module_188`
--

LOCK TABLES `sport_module_188` WRITE;
/*!40000 ALTER TABLE `sport_module_188` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_module_365`
--

LOCK TABLES `sport_module_365` WRITE;
/*!40000 ALTER TABLE `sport_module_365` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_module_game_188`
--

LOCK TABLES `sport_module_game_188` WRITE;
/*!40000 ALTER TABLE `sport_module_game_188` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_module_game_365`
--

LOCK TABLES `sport_module_game_365` WRITE;
/*!40000 ALTER TABLE `sport_module_game_365` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_module_game_u1688`
--

LOCK TABLES `sport_module_game_u1688` WRITE;
/*!40000 ALTER TABLE `sport_module_game_u1688` DISABLE KEYS */;
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
  `group_item_name` varchar(30) DEFAULT NULL,
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

-- Dump completed on 2018-06-26 19:34:06
