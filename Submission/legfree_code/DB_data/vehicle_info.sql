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

 Date: 07/11/2022 14:21:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for vehicle_info
-- ----------------------------
DROP TABLE IF EXISTS `vehicle_info`;
CREATE TABLE `vehicle_info` (
  `vehicle_id` bigint NOT NULL COMMENT '车辆id',
  `vehicle_name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '车辆名称',
  `vehicle_location` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '车辆位置',
  `vehicle_free` bigint NOT NULL COMMENT '车辆费用 英镑/h',
  `vehicle_battery` bigint NOT NULL COMMENT '车辆电量',
  `vehicle_state` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '车辆状态0未使用1使用中2损坏',
  `vehicle_durable` bigint NOT NULL COMMENT '车辆耐久度',
  PRIMARY KEY (`vehicle_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of vehicle_info
-- ----------------------------
BEGIN;
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1001, 'electric scooters', 'g2 1ds', 5, 31, 'In Use', 79);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1002, 'electric bikes', 'G76WS', 2, 80, 'In Use', 87);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1003, 'electric scooters', 'G116QF', 5, 25, 'Normal', 51);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1004, 'electric bikes', 'G96WG', 2, 34, 'Normal', 77);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1005, 'electric bikes', 'G42TH', 2, 70, 'In Use', 94);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1006, 'electric scooters', 'G97ED', 5, 51, 'Normal', 57);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1007, 'electric scooters', 'G182ED', 5, 26, 'Normal', 92);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1008, 'electric cars', 'G95TC', 10, 38, 'Normal', 44);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1009, 'electric bikes', 'G19STC', 2, 100, 'In Use', 49);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1010, 'electric bikes', 'G97EX', 2, 8, 'Normal', 72);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1011, 'electric scooters', 'G98ES', 5, 6, 'In Use', 75);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1012, 'electric cars', 'G128GK', 10, 60, 'Normal', 76);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1013, 'electric bikes', 'G128QQ', 2, 77, 'In Use', 52);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1014, 'electric scooters', 'G518TF', 5, 17, 'In Use', 78);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1015, 'electric cars', 'G42TH', 10, 29, 'Normal', 84);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1016, 'electric bikes', 'G927ID', 2, 79, 'In Use', 82);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1017, 'electric cars', 'G73OS', 10, 86, 'Normal', 43);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1018, 'electric scooters', 'G297TS', 5, 44, 'Normal', 88);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1019, 'electric scooters', 'G86KS', 5, 73, 'In Use', 96);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1020, 'electric bikes', 'G19SOW', 2, 73, 'Normal', 48);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1021, 'electric cars', 'G297ZS', 10, 15, 'In Use', 58);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1022, 'electric bikes', 'G197WC', 2, 94, 'Normal', 93);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1023, 'electric bikes', 'G29WCS', 2, 9, 'Normal', 55);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1024, 'electric scooters', 'G872WL', 5, 32, 'In Use', 82);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1025, 'electric cars', 'G98ALW', 10, 70, 'Normal', 50);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1026, 'electric bikes', 'G91WFH', 2, 8, 'Normal', 98);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1027, 'electric cars', 'G128QQ', 10, 86, 'Normal', 55);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1028, 'electric bikes', 'G116QF', 2, 79, 'In Use', 78);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1029, 'electric cars', 'G116PS', 10, 5, 'Normal', 46);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1030, 'electric bikes', 'G19TS', 2, 66, 'In Use', 67);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1031, 'electric bikes', 'G91WO', 2, 46, 'Normal', 43);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1032, 'electric cars', 'G128QQ', 10, 71, 'Normal', 47);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1033, 'electric bikes', 'G27BWQ', 2, 65, 'Normal', 92);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1034, 'electric bikes', 'G28BJG', 2, 69, 'In Use', 69);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1035, 'electric bikes', 'G98GSL', 2, 25, 'Normal', 46);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1036, 'electric bikes', 'G27BWQ', 2, 99, 'In Use', 41);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1037, 'electric bikes', 'G862WD', 2, 27, 'In Use', 58);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1038, 'electric bikes', 'G86JGK', 2, 20, 'Normal', 43);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1039, 'electric cars', 'G286WL', 10, 12, 'Normal', 49);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1040, 'electric scooters', 'G27GWL', 5, 0, 'Normal', 63);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1041, 'electric bikes', 'G286LH', 2, 14, 'In Use', 82);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1042, 'electric scooters', 'G275WL', 5, 36, 'Normal', 98);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1043, 'electric scooters', 'G19GLW', 5, 94, 'In Use', 55);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1044, 'electric cars', 'G343QQ', 10, 91, 'In Use', 44);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1045, 'electric scooters', 'G17WBY', 5, 76, 'Normal', 71);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1046, 'electric bikes', 'G872KD', 2, 17, 'In Use', 73);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1047, 'electric scooters', 'G862WD', 5, 56, 'In Use', 48);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1048, 'electric cars', 'G64WFS', 10, 2, 'Normal', 61);
INSERT INTO `vehicle_info` (`vehicle_id`, `vehicle_name`, `vehicle_location`, `vehicle_free`, `vehicle_battery`, `vehicle_state`, `vehicle_durable`) VALUES (1049, 'electric scooters', 'G75WOJ', 5, 60, 'In Use', 47);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
