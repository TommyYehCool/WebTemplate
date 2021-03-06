DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL UNIQUE,
  `password` varchar(100) NOT NULL,
  `mobile_no` varchar(10) NOT NULL,
  `line_id` varchar(50) NOT NULL,
  `enabled` char(1) NOT NULL,
  `create_time` date NOT NULL,
  `last_signin_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `user_id` int(10) NOT NULL,
  `role` varchar(10) NOT NULL,
  CONSTRAINT unique_role UNIQUE (`user_id`, `role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `consume`;
CREATE TABLE `consume` (
  `user_id` int(10) NOT NULL,
  `consume_date` date NOT NULL,
  `type` int(1) NOT NULL,
  `prod_name` varchar(20) NOT NULL,
  `amount` decimal(10,0) NOT NULL,
  `lottery_no` varchar(8) NOT NULL,
  `prize` decimal(10,0),
  `got` int(1) NOT NULL,
  `already_sent` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`lottery_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `receipt_reward`;
CREATE TABLE `receipt_reward` (
  `section` char(10) NOT NULL,
  `reward_type` int(1) NOT NULL,
  `number` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `mail_template`;
CREATE TABLE `mail_template` (
  `template_id` int(10) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `header` text NOT NULL,
  `body_header` text NOT NULL,
  `body_tail` text NOT NULL,
  `tail` text NOT NULL,
  PRIMARY KEY (`template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `activities`;
CREATE TABLE `activities` (
  `activity_id` int(10) NOT NULL AUTO_INCREMENT,
  `create_user_id` int(10) NOT NULL,
  `create_date` date NOT NULL,
  `title` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `start_datetime` datetime NOT NULL,
  `latitude` decimal(10,6) NOT NULL,
  `longitude` decimal(10,6) NOT NULL,
  `attendee_num` decimal(5,0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `join_activities`;
CREATE TABLE `join_activities` (
  `user_id` int(10) NOT NULL,
  `activity_id` int(10) NOT NULL,
  PRIMARY KEY (`user_id`, `activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `activity_messages`;
CREATE TABLE `activity_messages` (
  `msg_id` int(10) NOT NULL AUTO_INCREMENT,
  `activity_id` int(10) NOT NULL,
  `create_user_id` int(10) NOT NULL,
  `create_datetime` datetime NOT NULL,
  `msg` varchar(200) NOT NULL,
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `nba_team`;
CREATE TABLE `nba_team` (
  `team_id` int(10) NOT NULL,
  `abbr` varchar(5) NOT NULL,
  `city_ch` varchar(10) NOT NULL,
  `city_en` varchar(20) NOT NULL,
  `code` varchar(20) NOT NULL,
  `conference_ch` varchar(10) NOT NULL,
  `conference_en` varchar(10) NOT NULL,
  `division_ch` varchar(10) NOT NULL, 
  `division_en` varchar(10) NOT NULL,
  `name_ch` varchar(10) NOT NULL,
  `name_en` varchar(20) NOT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `nba_schedule`;
CREATE TABLE `nba_schedule` (
  `game_id` int(10) NOT NULL,
  `game_time_in_millis` bigint NOT NULL,
  `game_time` datetime NOT NULL,
  `home_team_id` int(10) NOT NULL,
  `away_team_id` int(10) NOT NULL,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `nba_game`;
CREATE TABLE `nba_game` (
  `game_id` int(10) NOT NULL,
  `home_team_1st_scores` int(3) NOT NULL DEFAULT 0,
  `home_team_2nd_scores` int(3) NOT NULL DEFAULT 0,
  `home_team_3rd_scores` int(3) NOT NULL DEFAULT 0,
  `home_team_4th_scores` int(3) NOT NULL DEFAULT 0,
  `home_team_scores_sum` int(3) NOT NULL DEFAULT 0,
  `away_team_1st_scores` int(3) NOT NULL DEFAULT 0,
  `away_team_2nd_scores` int(3) NOT NULL DEFAULT 0,
  `away_team_3rd_scores` int(3) NOT NULL DEFAULT 0,
  `away_team_4th_scores` int(3) NOT NULL DEFAULT 0,
  `away_team_scores_sum` int(3) NOT NULL DEFAULT 0,
  `total_scores_sum` int(3) NOT NULL DEFAULT 0,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;