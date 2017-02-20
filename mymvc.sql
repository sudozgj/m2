/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50535
Source Host           : localhost:3306
Source Database       : mymvc

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2017-02-17 18:18:37
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `fileio`
-- ----------------------------
DROP TABLE IF EXISTS `fileio`;
CREATE TABLE `fileio` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `filename` varchar(255) NOT NULL,
  `time` bigint(20) NOT NULL,
  `dir` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fileio
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=336 DEFAULT CHARSET=utf8;

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
INSERT INTO `log` VALUES ('261', 'admin', 'login', '1487311320');
INSERT INTO `log` VALUES ('262', 'admin', 'uploadFile', '1487311325');
INSERT INTO `log` VALUES ('263', 'admin', 'uploadFile', '1487311330');
INSERT INTO `log` VALUES ('264', 'admin', 'login', '1487312503');
INSERT INTO `log` VALUES ('265', 'admin', 'uploadFile', '1487312506');
INSERT INTO `log` VALUES ('266', 'admin', 'login', '1487312638');
INSERT INTO `log` VALUES ('267', 'admin', 'uploadFile', '1487312642');
INSERT INTO `log` VALUES ('268', 'admin', 'login', '1487312700');
INSERT INTO `log` VALUES ('269', 'admin', 'login', '1487312735');
INSERT INTO `log` VALUES ('270', 'admin', 'login', '1487312738');
INSERT INTO `log` VALUES ('271', 'admin', 'uploadFile', '1487312761');
INSERT INTO `log` VALUES ('272', 'admin', 'login', '1487312904');
INSERT INTO `log` VALUES ('273', 'admin', 'uploadFile', '1487312907');
INSERT INTO `log` VALUES ('274', 'admin', 'login', '1487313065');
INSERT INTO `log` VALUES ('275', 'admin', 'uploadFile', '1487313071');
INSERT INTO `log` VALUES ('276', 'admin', 'login', '1487313983');
INSERT INTO `log` VALUES ('277', 'admin', 'uploadFile', '1487313990');
INSERT INTO `log` VALUES ('278', 'admin', 'login', '1487314460');
INSERT INTO `log` VALUES ('279', 'admin', 'uploadFile', '1487314466');
INSERT INTO `log` VALUES ('280', 'admin', 'login', '1487314552');
INSERT INTO `log` VALUES ('281', 'admin', 'uploadFile', '1487314561');
INSERT INTO `log` VALUES ('282', 'admin', 'login', '1487315183');
INSERT INTO `log` VALUES ('283', 'admin', 'uploadFile', '1487315215');
INSERT INTO `log` VALUES ('284', 'admin', 'login', '1487315429');
INSERT INTO `log` VALUES ('285', 'admin', 'uploadFile', '1487315440');
INSERT INTO `log` VALUES ('286', 'admin', 'uploadFile', '1487315623');
INSERT INTO `log` VALUES ('287', 'admin', 'login', '1487315909');
INSERT INTO `log` VALUES ('288', 'admin', 'uploadFile2', '1487315926');
INSERT INTO `log` VALUES ('289', 'admin', 'login', '1487316186');
INSERT INTO `log` VALUES ('290', 'admin', 'uploadFile3', '1487316200');
INSERT INTO `log` VALUES ('291', 'admin', 'login', '1487316715');
INSERT INTO `log` VALUES ('292', 'admin', 'uploadFile2', '1487316801');
INSERT INTO `log` VALUES ('293', 'admin', 'uploadFile', '1487316822');
INSERT INTO `log` VALUES ('294', 'admin', 'login', '1487317082');
INSERT INTO `log` VALUES ('295', 'admin', 'uploadFile2', '1487317086');
INSERT INTO `log` VALUES ('296', 'admin', 'login', '1487317508');
INSERT INTO `log` VALUES ('297', 'admin', 'login', '1487317541');
INSERT INTO `log` VALUES ('298', 'admin', 'uploadFile3', '1487317553');
INSERT INTO `log` VALUES ('299', 'admin', 'uploadFile3', '1487317574');
INSERT INTO `log` VALUES ('300', 'admin', 'uploadFile', '1487317584');
INSERT INTO `log` VALUES ('301', 'admin', 'uploadFile2', '1487317620');
INSERT INTO `log` VALUES ('302', 'admin', 'login', '1487323633');
INSERT INTO `log` VALUES ('303', 'admin', 'getSource', '1487323637');
INSERT INTO `log` VALUES ('304', 'admin', 'login', '1487323791');
INSERT INTO `log` VALUES ('305', 'admin', 'getSource', '1487323795');
INSERT INTO `log` VALUES ('306', 'admin', 'login', '1487323833');
INSERT INTO `log` VALUES ('307', 'admin', 'login', '1487323841');
INSERT INTO `log` VALUES ('308', 'admin', 'getSource', '1487323843');
INSERT INTO `log` VALUES ('309', 'admin', 'login', '1487323896');
INSERT INTO `log` VALUES ('310', 'admin', 'getSource', '1487323899');
INSERT INTO `log` VALUES ('311', 'admin', 'login', '1487324235');
INSERT INTO `log` VALUES ('312', 'admin', 'getSource', '1487324238');
INSERT INTO `log` VALUES ('313', 'admin', 'getSource', '1487324244');
INSERT INTO `log` VALUES ('314', 'admin', 'getSource', '1487324294');
INSERT INTO `log` VALUES ('315', 'admin', 'login', '1487324305');
INSERT INTO `log` VALUES ('316', 'admin', 'getSource', '1487324307');
INSERT INTO `log` VALUES ('317', 'admin', 'login', '1487324348');
INSERT INTO `log` VALUES ('318', 'admin', 'getSource', '1487324350');
INSERT INTO `log` VALUES ('319', 'admin', 'login', '1487324404');
INSERT INTO `log` VALUES ('320', 'admin', 'getSource', '1487324406');
INSERT INTO `log` VALUES ('321', 'admin', 'login', '1487324678');
INSERT INTO `log` VALUES ('322', 'admin', 'login', '1487324700');
INSERT INTO `log` VALUES ('323', 'admin', 'getSource', '1487324703');
INSERT INTO `log` VALUES ('324', 'admin', 'login', '1487324710');
INSERT INTO `log` VALUES ('325', 'admin', 'getSource', '1487324716');
INSERT INTO `log` VALUES ('326', 'admin', 'login', '1487325137');
INSERT INTO `log` VALUES ('327', 'admin', 'getSource', '1487325141');
INSERT INTO `log` VALUES ('328', 'admin', 'login', '1487325211');
INSERT INTO `log` VALUES ('329', 'admin', 'getSource', '1487325212');
INSERT INTO `log` VALUES ('330', 'admin', 'login', '1487325979');
INSERT INTO `log` VALUES ('331', 'admin', 'login', '1487325984');
INSERT INTO `log` VALUES ('332', 'admin', 'getSource', '1487325986');
INSERT INTO `log` VALUES ('333', 'admin', 'uploadFile', '1487326014');
INSERT INTO `log` VALUES ('334', 'admin', 'login', '1487326082');
INSERT INTO `log` VALUES ('335', 'admin', 'uploadFile', '1487326088');

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
