/*
Navicat MySQL Data Transfer

Source Server         : 0623
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : bagevent_test

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-06-23 23:40:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱（用户账户）',
  `cellphone` varchar(11) DEFAULT NULL COMMENT '手机号（用户账户）',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) DEFAULT NULL,
  `state` int(1) DEFAULT NULL COMMENT '0:删除，1：正常',
  `create_time` varchar(14) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userloginlog
-- ----------------------------
DROP TABLE IF EXISTS `userloginlog`;
CREATE TABLE `userloginlog` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `login_time` varchar(11) NOT NULL COMMENT '登陆时间',
  `login_ip` varchar(15) NOT NULL COMMENT '登录IP',
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
