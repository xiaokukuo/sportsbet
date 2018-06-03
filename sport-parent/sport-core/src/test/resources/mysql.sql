CREATE TABLE `sport_module_365` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` int(11) NOT NULL,
  `group_name` varchar(30) DEFAULT NULL,
  `game_lines_pd` varchar(100) DEFAULT NULL,
  `first_half_pd` varchar(100) DEFAULT NULL,
  `second_half_pd` varchar(100) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `creator` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` int(11) DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE DATABASE `sport-bet` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `code` varchar(30) DEFAULT NULL,
  `url` varchar(100) NOT NULL,
  `type` int(11) NOT NULL,
  `child` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `icon` varchar(30) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `creator` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator` int(11) DEFAULT NULL,
  `version` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;