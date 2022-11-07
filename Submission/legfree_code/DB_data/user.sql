/*
 Navicat Premium Data Transfer

 Source Server         : ps_tapp
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : tapp_database

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 07/11/2022 14:20:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `user_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '加密盐值',
  `level` int NOT NULL COMMENT '用户权限等级',
  `created_time` datetime DEFAULT NULL COMMENT '用户信息创建时间',
  `money` bigint DEFAULT NULL COMMENT '账户金额',
  `user_location` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '用户位置',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '用户信息修改时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1000011 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`user_id`, `user_name`, `password`, `salt`, `level`, `created_time`, `money`, `user_location`, `update_time`) VALUES (100001, 'admin', '5124f27da43b737004dab687db2a902f', 'wjfncV%u', 1, '2022-10-08 10:06:47', NULL, NULL, '2022-10-08 11:37:03');
INSERT INTO `user` (`user_id`, `user_name`, `password`, `salt`, `level`, `created_time`, `money`, `user_location`, `update_time`) VALUES (100004, 'TestUser1', '5124f27da43b737004dab687db2a902f', 'wjfncV%u', 5, '2022-10-08 16:49:29', 5010, 'G128QQ', '2022-11-07 05:39:43');
INSERT INTO `user` (`user_id`, `user_name`, `password`, `salt`, `level`, `created_time`, `money`, `user_location`, `update_time`) VALUES (100005, 'TestUser2', '5124f27da43b737004dab687db2a902f', 'wjfncV%u', 5, '2022-10-13 17:58:03', 85, 'G116QF', '2022-11-04 06:58:01');
INSERT INTO `user` (`user_id`, `user_name`, `password`, `salt`, `level`, `created_time`, `money`, `user_location`, `update_time`) VALUES (100006, 'TestUser3', '5124f27da43b737004dab687db2a902f', 'wjfncV%u', 5, '2022-11-03 20:01:13', 10, 'G116PS', '2022-11-07 02:02:09');
INSERT INTO `user` (`user_id`, `user_name`, `password`, `salt`, `level`, `created_time`, `money`, `user_location`, `update_time`) VALUES (100007, 'TestUser4', '5124f27da43b737004dab687db2a902f', 'wjfncV%u', 5, '2022-10-20 18:02:40', 309, 'G23WL', '2022-11-07 06:59:25');
INSERT INTO `user` (`user_id`, `user_name`, `password`, `salt`, `level`, `created_time`, `money`, `user_location`, `update_time`) VALUES (100008, 'TsetUser5', '5124f27da43b737004dab687db2a902f', 'wjfncV%u', 5, '2022-10-04 18:03:47', 863, 'G129BG', '2022-11-07 02:05:22');
INSERT INTO `user` (`user_id`, `user_name`, `password`, `salt`, `level`, `created_time`, `money`, `user_location`, `update_time`) VALUES (100009, 'TsetUser9', '5124f27da43b737004dab687db2a902f', 'wjfncV%u', 5, '2022-10-13 13:05:53', 937, 'G129LN', '2022-11-07 02:06:34');
INSERT INTO `user` (`user_id`, `user_name`, `password`, `salt`, `level`, `created_time`, `money`, `user_location`, `update_time`) VALUES (100011, 'TestUser6', '5124f27da43b737004dab687db2a902f', 'wjfncV%u', 5, '2022-11-01 18:07:07', 2863, 'G116NU', '2022-11-07 02:07:54');
INSERT INTO `user` (`user_id`, `user_name`, `password`, `salt`, `level`, `created_time`, `money`, `user_location`, `update_time`) VALUES (100012, 'TestUser7', '5124f27da43b737004dab687db2a902f', 'wjfncV%u', 5, '2022-10-14 15:08:27', 9274, 'G116NU', '2022-11-07 02:09:04');
INSERT INTO `user` (`user_id`, `user_name`, `password`, `salt`, `level`, `created_time`, `money`, `user_location`, `update_time`) VALUES (100013, 'TestUser13', '5124f27da43b737004dab687db2a902f', 'wjfncV%u', 5, '2022-10-13 13:11:01', 9735, 'G38TX', '2022-11-07 02:11:34');
INSERT INTO `user` (`user_id`, `user_name`, `password`, `salt`, `level`, `created_time`, `money`, `user_location`, `update_time`) VALUES (100014, 'TestUser8', '5124f27da43b737004dab687db2a902f', 'wjfncV%u', 5, '2022-11-01 17:09:44', 924, 'G128QQ', '2022-11-07 02:10:16');
INSERT INTO `user` (`user_id`, `user_name`, `password`, `salt`, `level`, `created_time`, `money`, `user_location`, `update_time`) VALUES (100015, 'TestUser10', '5124f27da43b737004dab687db2a902f', 'wjfncV%u', 5, '2022-10-05 18:01:06', 873, 'G37TF', '2022-11-07 02:12:53');
INSERT INTO `user` (`user_id`, `user_name`, `password`, `salt`, `level`, `created_time`, `money`, `user_location`, `update_time`) VALUES (1000010, 'operator', '5124f27da43b737004dab687db2a902f', 'wjfncV%u', 3, '2022-10-05 18:01:06', NULL, NULL, '2022-11-07 14:15:15');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
