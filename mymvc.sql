/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50535
Source Host           : localhost:3306
Source Database       : mymvc

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2017-02-16 18:01:51
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `operation` varchar(32) NOT NULL,
  `time` bigint(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', 'admin', 'create table', '1486353647');
INSERT INTO `log` VALUES ('231', 'jack', 'register', '1487152764');
INSERT INTO `log` VALUES ('232', 'tim', 'register', '1487152913');
INSERT INTO `log` VALUES ('233', 'peter', 'register', '1487153011');
INSERT INTO `log` VALUES ('234', 'admin', 'login', '1487207185');
INSERT INTO `log` VALUES ('235', 'admin', 'getUserList', '1487207189');
INSERT INTO `log` VALUES ('236', 'admin', 'login', '1487207297');
INSERT INTO `log` VALUES ('237', 'admin', 'getUserList', '1487207308');
INSERT INTO `log` VALUES ('238', 'admin', 'getUserList', '1487207357');
INSERT INTO `log` VALUES ('239', 'admin', 'login', '1487207422');
INSERT INTO `log` VALUES ('240', 'admin', 'getUserList', '1487207426');
INSERT INTO `log` VALUES ('241', 'admin', 'getUserList', '1487207715');
INSERT INTO `log` VALUES ('242', 'zgj', 'register', '1487208774');
INSERT INTO `log` VALUES ('243', 'zgj', 'login', '1487208793');
INSERT INTO `log` VALUES ('244', 'zgj', 'getUserList', '1487208794');
INSERT INTO `log` VALUES ('245', 'zgj', 'getUserList', '1487209178');
INSERT INTO `log` VALUES ('246', 'zgj', 'login', '1487209184');
INSERT INTO `log` VALUES ('247', 'zgj', 'getSession', '1487209187');
INSERT INTO `log` VALUES ('248', 'zgj', 'getUserList', '1487209655');
INSERT INTO `log` VALUES ('249', 'zgj', 'login', '1487211068');
INSERT INTO `log` VALUES ('250', 'aa', 'register', '1487211117');
INSERT INTO `log` VALUES ('251', 'zgj', 'getUserList', '1487211216');
INSERT INTO `log` VALUES ('252', 'zgj', 'getSession', '1487211265');
INSERT INTO `log` VALUES ('253', 'aa', 'login', '1487211957');
INSERT INTO `log` VALUES ('254', 'aa', 'getLogList', '1487211960');
INSERT INTO `log` VALUES ('255', 'aa', 'login', '1487212195');
INSERT INTO `log` VALUES ('256', 'aa', 'getLogList', '1487212197');
INSERT INTO `log` VALUES ('257', 'aa', 'login', '1487224877');
INSERT INTO `log` VALUES ('258', 'aa', 'getLogList', '1487224885');
INSERT INTO `log` VALUES ('259', 'aa', 'login', '1487226130');
INSERT INTO `log` VALUES ('260', 'aa', 'getLogList', '1487226134');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `create_time` bigint(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123', '1487150090');
INSERT INTO `user` VALUES ('20', 'peter', 'dv', '1487153012');
INSERT INTO `user` VALUES ('21', 'zgj', '123', '1487208776');
INSERT INTO `user` VALUES ('22', 'aa', '123', '1487211117');

-- ----------------------------
-- Table structure for `user_detail`
-- ----------------------------
DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT '',
  `email` varchar(255) DEFAULT '',
  `user_id` bigint(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_detail
-- ----------------------------
INSERT INTO `user_detail` VALUES ('1', '', '', '1');
INSERT INTO `user_detail` VALUES ('10', '', '', '20');
INSERT INTO `user_detail` VALUES ('11', '', '', '21');
INSERT INTO `user_detail` VALUES ('12', '', '', '22');

-- ----------------------------
-- View structure for `v_log`
-- ----------------------------
DROP VIEW IF EXISTS `v_log`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_log` AS select `l`.`id` AS `id`,`l`.`username` AS `username`,`l`.`operation` AS `operation`,date_format(from_unixtime(`l`.`time`),'%Y-%m-%d %H:%i:%S') AS `time` from `log` `l`;

-- ----------------------------
-- View structure for `v_user`
-- ----------------------------
DROP VIEW IF EXISTS `v_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_user` AS select `u`.`id` AS `id`,`u`.`username` AS `username`,`ud`.`name` AS `name`,`ud`.`email` AS `email`,date_format(from_unixtime(`u`.`create_time`),'%Y-%m-%d %H:%i:%S') AS `create_time` from (`user` `u` join `user_detail` `ud`) where (`u`.`id` = `ud`.`user_id`);
