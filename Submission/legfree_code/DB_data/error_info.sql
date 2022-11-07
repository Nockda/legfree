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

 Date: 07/11/2022 14:20:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for error_info
-- ----------------------------
DROP TABLE IF EXISTS `error_info`;
CREATE TABLE `error_info` (
  `error_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `vehicle_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`error_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of error_info
-- ----------------------------
BEGIN;
INSERT INTO `error_info` (`error_id`, `user_id`, `vehicle_id`, `message`) VALUES ('20221107171326', 'TestUser1', '1002', 'Broken');
INSERT INTO `error_info` (`error_id`, `user_id`, `vehicle_id`, `message`) VALUES ('4016466342', '100004', '1002', 'CANNOTUSE');
INSERT INTO `error_info` (`error_id`, `user_id`, `vehicle_id`, `message`) VALUES ('9873747887', '100004', '1001', 'the bike canot be use');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
