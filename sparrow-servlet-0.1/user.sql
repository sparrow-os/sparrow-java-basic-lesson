/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : sparrow

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 03/10/2022 12:32:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) DEFAULT '' COMMENT '用户名',
  `nick_name` varchar(64) DEFAULT '' COMMENT '昵称',
  `email` varchar(256) DEFAULT '' COMMENT 'E-MAIL',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `gender` tinyint DEFAULT '0' COMMENT '性别',
  `avatar` varchar(256) DEFAULT '' COMMENT '头象',
  `personal_signature` varchar(256) DEFAULT '' COMMENT '签名',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `mobile` varchar(11) DEFAULT '0' COMMENT '手机号码',
  `last_login_time` bigint DEFAULT '0' COMMENT '最近登录时间',
  `cent` bigint DEFAULT '0' COMMENT '积分',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态',
  `is_online` tinyint(1) DEFAULT '0' COMMENT '是否在线',
  `activate` tinyint(1) DEFAULT '0' COMMENT '是否激活',
  `activate_time` bigint DEFAULT '0' COMMENT '激活时间',
  `zone` varchar(32) DEFAULT '' COMMENT '主页',
  `channel` varchar(128) DEFAULT '' COMMENT '渠道来源',
  `website` varchar(128) DEFAULT '' COMMENT '用户注册网站',
  `group_level` varchar(64) DEFAULT '' COMMENT '用户等级',
  `secret_mobile` varchar(64) DEFAULT '' COMMENT 'SECRET MOBILE',
  `device` varchar(16) DEFAULT '' COMMENT '设备',
  `device_id` varchar(64) DEFAULT '' COMMENT '设备id',
  `device_model` varchar(32) DEFAULT '' COMMENT '设备模型',
  `ip` bigint DEFAULT '0' COMMENT 'ip',
  `create_time` bigint NOT NULL DEFAULT '0' COMMENT '注册日期',
  `update_time` bigint DEFAULT '0' COMMENT '最近更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='user';

SET FOREIGN_KEY_CHECKS = 1;
