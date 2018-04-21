/*
Navicat MySQL Data Transfer

Source Server         : hello
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : ssm_crud

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-04-21 15:59:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '开发部');
INSERT INTO `dept` VALUES ('2', '测试部');

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `worker_id` int(11) NOT NULL AUTO_INCREMENT,
  `worker_name` varchar(255) DEFAULT NULL,
  `worker_gender` char(255) DEFAULT NULL,
  `worker_email` varchar(255) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`worker_id`),
  KEY `wd` (`d_id`),
  CONSTRAINT `wd` FOREIGN KEY (`d_id`) REFERENCES `dept` (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=326 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES ('285', '272fe84', 'M', '272fe84@com', '1');
INSERT INTO `worker` VALUES ('286', '0ab3a85', 'M', '0ab3a85@com', '1');
INSERT INTO `worker` VALUES ('287', '98a8c86', 'M', '98a8c86@com', '1');
INSERT INTO `worker` VALUES ('288', '9d23a87', 'M', '9d23a87@com', '1');
INSERT INTO `worker` VALUES ('289', 'd290a88', 'M', 'd290a88@com', '1');
INSERT INTO `worker` VALUES ('290', 'e9acf89', 'M', 'e9acf89@com', '1');
INSERT INTO `worker` VALUES ('291', 'b6aea90', 'M', 'b6aea90@com', '1');
INSERT INTO `worker` VALUES ('292', '1818091', 'M', '1818091@com', '1');
INSERT INTO `worker` VALUES ('293', '1b74f92', 'M', '1b74f92@com', '1');
INSERT INTO `worker` VALUES ('294', '0e79d93', 'M', '0e79d93@com', '1');
INSERT INTO `worker` VALUES ('295', 'c191b94', 'M', 'c191b94@com', '1');
INSERT INTO `worker` VALUES ('296', 'a49b795', 'M', 'a49b795@com', '1');
INSERT INTO `worker` VALUES ('297', '0ac5696', 'M', '0ac5696@com', '1');
INSERT INTO `worker` VALUES ('298', '51fa297', 'M', '51fa297@com', '1');
INSERT INTO `worker` VALUES ('299', '9452598', 'M', '9452598@com', '1');
INSERT INTO `worker` VALUES ('300', '81fa899', 'M', '81fa899@com', '1');
INSERT INTO `worker` VALUES ('301', '123', 'M', '111', '1');
INSERT INTO `worker` VALUES ('302', '123', 'M', '111', '1');
INSERT INTO `worker` VALUES ('303', 'zhangdazhuang', 'W', '12312', '2');
INSERT INTO `worker` VALUES ('304', '1111', 'M', '11111', '1');
INSERT INTO `worker` VALUES ('305', '123455', 'W', '994683607@qq.com', '1');
INSERT INTO `worker` VALUES ('306', '1111aa', 'M', '994683607@qq.com', '1');
INSERT INTO `worker` VALUES ('307', '1111aa', 'M', '994687@qq.co', '1');
INSERT INTO `worker` VALUES ('308', '121121', null, '1231QW@qq.com', '1');
INSERT INTO `worker` VALUES ('309', '1111aa1', null, '1111@qq.com', '1');
INSERT INTO `worker` VALUES ('310', 'aa1231', null, '1231@qq.com', '1');
INSERT INTO `worker` VALUES ('311', 'bf7000', 'M', '1231@qq.com', '1');
INSERT INTO `worker` VALUES ('312', '1111aa111111', 'M', '994683607@qq.com', '2');
INSERT INTO `worker` VALUES ('313', '1111aa111111', 'M', '994683607@qq.com', '2');
INSERT INTO `worker` VALUES ('314', '1111aa111111', 'M', '994683607@qq.com', '2');
INSERT INTO `worker` VALUES ('315', '123111', 'W', '1231231@qq.com', '1');
INSERT INTO `worker` VALUES ('316', '张鑫', 'M', '1231231@qq.com', '1');
INSERT INTO `worker` VALUES ('317', '1233241', 'M', '994683607@qq.com', '1');
INSERT INTO `worker` VALUES ('318', 'aaaaaa', 'M', '13@qq.cpm', '1');
INSERT INTO `worker` VALUES ('319', '123123', 'M', '123213@qq.com', '1');
INSERT INTO `worker` VALUES ('320', '2132131', 'M', '212e1@qq.com', '1');
INSERT INTO `worker` VALUES ('321', '21311233', 'M', '1231@qq.com', '2');
INSERT INTO `worker` VALUES ('323', 'hellpo', 'M', '99231@qq.com', '1');
INSERT INTO `worker` VALUES ('324', '1232131213', 'W', '12311111@qq.com', '2');
INSERT INTO `worker` VALUES ('325', '213121', 'W', '1231@qq.com', '2');
