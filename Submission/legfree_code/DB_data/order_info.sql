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

 Date: 07/11/2022 14:21:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `order_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `vehicle_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `time` int DEFAULT NULL,
  `order_money` int DEFAULT NULL,
  `create_time` datetime(5) DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `fee` bigint DEFAULT NULL,
  `from_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `to_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of order_info
-- ----------------------------
BEGIN;
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106195918', 'TestUser1', '1001', 5, 25, '2022-11-06 19:59:18.00000', 'Paid', 5, '213123', 'G2 8QD');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106210108', 'TestUser12', '1001', 4, 20, '2022-10-18 21:01:08.00000', 'Not Paid', 5, 'G2 8QD', 'G2 7QD');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106212457', 'TestUser5', '1001', 3, 15, '2022-10-07 21:24:57.00000', 'Not Paid', 5, 'G116QF', 'G2 8QD');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106212636', 'TestUser8', '1001', 5, 25, '2022-11-06 21:26:36.00000', 'Not Paid', 5, 'G116QF', 'G2 8QD');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106213440', 'TestUser3', '1001', 7, 35, '2022-10-09 21:34:40.00000', 'Not Paid', 5, 'G116QF', 'G128QQ');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106213621', 'TestUser1', '1001', 23, 115, '2022-11-07 05:36:21.00000', 'Not Paid', 5, 'g2 1ds', 'G128QQ');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106214036', 'TestUser1', '1001', 14, 70, '2022-11-01 21:40:36.00000', 'Not Paid', 5, 'G116QF', 'G128QQ');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106214109', 'TestUser2', '1001', 27, 135, '2022-11-06 21:41:09.00000', 'Not Paid', 5, 'G116QF', 'G116QF');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106214423', 'TestUser1', '1001', 12, 60, '2022-11-06 21:44:23.00000', 'Not Paid', 5, 'G116QF', 'G116QF');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106214820', 'TestUser3', '1001', 20, 100, '2022-11-04 21:48:20.00000', 'Not Paid', 5, 'G116QF', 'G116QF');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106214833', 'TestUser1', '1002', 10, 20, '2022-11-02 21:48:33.00000', 'Not Paid', 2, '545', 'G116QF');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106215310', 'TestUser1', '1001', 17, 85, '2022-11-06 21:53:10.00000', 'Not Paid', 5, 'G116QF', 'G128QQ');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106215353', 'TestUser5', '1001', 19, 95, '2022-11-06 21:53:53.00000', 'Not Paid', 5, 'G116QF', 'G116QF');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106220807', 'TestUser1', '1001', 25, 125, '2022-11-01 22:08:07.00000', 'Not Paid', 5, 'G116QF', 'G116QF');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106220855', 'TestUser13', '1001', 35, 175, '2022-11-06 22:08:55.00000', 'Not Paid', 5, 'G116QF', 'G128QQ');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106221046', 'TestUser5', '1001', 24, 120, '2022-11-06 22:10:46.00000', 'Not Paid', 5, 'G116QF', 'G128QQ');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106221139', 'TestUser13TestUser1', '1001', 3, 15, '2022-10-17 22:11:39.00000', 'Not Paid', 5, 'G116QF', 'G128QQ');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106221212', 'TestUser5', '1001', 2, 10, '2022-11-06 22:12:12.00000', 'Not Paid', 5, 'G116QF', 'G116QF');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106222343', 'TestUser1', '1001', 9, 45, '2022-10-19 22:23:43.00000', 'Not Paid', 5, 'G116QF', 'G128QQ');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106222452', 'TestUser5', '1001', 4, 20, '2022-10-16 22:24:52.00000', 'Not Paid', 5, 'G116QF', 'G128QQ');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106222632', 'TestUser13', '1001', 7, 35, '2022-11-06 22:26:32.00000', 'Not Paid', 5, 'G116QF', 'G116QF');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106222956', 'TestUser13', '1001', 25, 125, '2022-11-06 22:29:56.00000', 'Not Paid', 5, 'G116QF', 'G128QQ');
INSERT INTO `order_info` (`order_id`, `user_id`, `vehicle_id`, `time`, `order_money`, `create_time`, `state`, `fee`, `from_location`, `to_location`) VALUES ('20221106223424', 'TestUser1', '1001', 5, 25, '2022-10-19 22:34:24.00000', 'Not Paid', 5, 'G116QF', 'G128QQ');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
