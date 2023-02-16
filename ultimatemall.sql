/*
 Navicat Premium Data Transfer

 Source Server         : MySQL80
 Source Server Type    : MySQL
 Source Server Version : 80027 (8.0.27)
 Source Host           : localhost:3306
 Source Schema         : ultimatemall

 Target Server Type    : MySQL
 Target Server Version : 80027 (8.0.27)
 File Encoding         : 65001

 Date: 11/12/2022 10:58:20
*/

DROP Database IF EXISTS `ultimatemall`;
CREATE DATABASE `ultimatemall`;
USE `ultimatemall`;


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `address_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_name` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `label` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_default` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1600774042250391555 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1600015257550577666, '1599423857683345409', '福建省日喀则地区清涧县', '雷娜', '18146212525', 'dolore ad veniam et Ut', 0);
INSERT INTO `address` VALUES (1600015555815923713, '1599423857683345409', '甘肃省包头市-', '傅军', '13438385260', 'quis officia culpa est aliquip', 0);
INSERT INTO `address` VALUES (1600016178556821505, '1599423857683345409', '内蒙古自治区泰州市历城区', '刘洋', '19827341152', 'dolore', 90);
INSERT INTO `address` VALUES (1600016611471908866, '1599423857683345409', '江苏省澳门半岛河西区', '常秀英', '18112772370', 'cillum sed ea', 0);
INSERT INTO `address` VALUES (1600774042250391554, NULL, '香港特别行政区白城市山海关区', '姚涛', '18141175044', 'ex ad ut do', 29);

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `user_id` bigint NOT NULL,
  `item_id` bigint NOT NULL,
  `item_num` int NOT NULL,
  PRIMARY KEY (`user_id`, `item_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (1599424913846833153, 1599437023712681986, 100);
INSERT INTO `cart` VALUES (1599424913846833153, 1599437174372081665, 9);

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`  (
  `item_id` bigint NOT NULL AUTO_INCREMENT,
  `item_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `item_price` decimal(10, 2) NULL DEFAULT NULL,
  `item_kind` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `item_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `item_num` int NULL DEFAULT NULL,
  `item_sell` int NULL DEFAULT 0,
  `item_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `item_state` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1599985774248349709 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES (1599436757701533697, '用照会却', 42.00, '军火', 'http://lovsovrtj.tk/xjdkwufd', 79, NULL, 'reprehenderit nulla labore sit', 0);
INSERT INTO `item` VALUES (1599437023712681986, '感看小天道农战', 2.00, '能源', 'http://hfpeboxjg.cx/qttokfiv', 28, NULL, 'laboris', 0);
INSERT INTO `item` VALUES (1599437174372081665, '十广直石音高已', 71.00, 'distinct test', 'http://ifbpl.mt/nrierir', 42, NULL, 'quis elit', 1);
INSERT INTO `item` VALUES (1599437205032443906, '上低量', 74.00, 'distinct test', 'http://bocpaqkpmw.mz/fkeuhdv', 52, NULL, 'occaecat nostrud sed', 0);
INSERT INTO `item` VALUES (1599437259025719298, '调都自照于参好', 56.00, 'elit nostrud', 'http://zfhikfqm.as/kideqd', 35, 88, 'non voluptate', 0);
INSERT INTO `item` VALUES (1599437302667452417, '济持团于', 72.00, 'distinct', 'http://gbrg.mo/ttbdnzu', 14, NULL, 'ullamco fugiat tempor Excepteur', 0);
INSERT INTO `item` VALUES (1599979933961039873, '标消积', 9.00, '军火', 'ee04a05a-1230-46b6-8ad5-1a95b140fff3.png', 38, 0, 'sint sed id Lorem', 0);
INSERT INTO `item` VALUES (1599985774248349701, '三星手机', 1999.00, '数码', '217.jpg', 100, 50, 'sint sed id Lorem', 0);
INSERT INTO `item` VALUES (1599985774248349702, '荣耀盒子', 1999.00, '数码', 'adv_l1.jpg', 100, 50, 'sint sed id Lorem', 0);
INSERT INTO `item` VALUES (1599985774248349703, '耳机', 1999.00, '数码', 'adv_l2.jpg', 100, 50, 'sint sed id Lorem', 0);
INSERT INTO `item` VALUES (1599985774248349704, '荣耀手机', 1999.00, '数码', 'adv1.jpg', 100, 50, 'sint sed id Lorem', 0);
INSERT INTO `item` VALUES (1599985774248349705, '荣耀手机2', 1999.00, '数码', 'adv2.jpg', 100, 50, 'sint sed id Lorem', 0);
INSERT INTO `item` VALUES (1599985774248349706, '荣耀手机3', 1999.00, '数码', 'adv3.jpg', 100, 50, 'sint sed id Lorem', 0);
INSERT INTO `item` VALUES (1599985774248349707, '荣耀手机4', 1999.00, '数码', 'adv4.jpg', 100, 50, 'sint sed id Lorem', 0);
INSERT INTO `item` VALUES (1599985774248349708, '华为盒子', 1999.00, '数码', 'banner_big.jpg', 100, 50, 'sint sed id Lorem', 0);

-- ----------------------------
-- Table structure for kind
-- ----------------------------
DROP TABLE IF EXISTS `kind`;
CREATE TABLE `kind`  (
  `item_kind` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`item_kind`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kind
-- ----------------------------
INSERT INTO `kind` VALUES ('家具');
INSERT INTO `kind` VALUES ('新军火');
INSERT INTO `kind` VALUES ('水果');
INSERT INTO `kind` VALUES ('测试更新类别');
INSERT INTO `kind` VALUES ('能源');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `item_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `item_num` int NULL DEFAULT NULL,
  `order_id` bigint NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1599436757701533697', 435, 1600037459159166977);
INSERT INTO `order_detail` VALUES ('1599437023712681986', 23, 1600037459159166977);
INSERT INTO `order_detail` VALUES ('1599437259025719298', 87, 1600040843845046273);
INSERT INTO `order_detail` VALUES ('1599437302667452417', 15, 1600040843845046273);
INSERT INTO `order_detail` VALUES ('1599979933961039873', 10, 1600037459159166977);
INSERT INTO `order_detail` VALUES ('1599437259025719298', 8, 1600041153531482113);
INSERT INTO `order_detail` VALUES ('1599437302667452417', 15, 1600041153531482113);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NULL DEFAULT NULL,
  `address_id` bigint NULL DEFAULT NULL,
  `order_amount` decimal(10, 2) NULL DEFAULT NULL,
  `order_state` tinyint(1) NULL DEFAULT NULL,
  `order_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1600041153531482114 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1600037459159166977, 1599423857683345409, 1600016178556821505, 90.00, 0, '2022-12-06 16:00:32');
INSERT INTO `orders` VALUES (1600040843845046273, 1599423857683345409, 89, 23.00, 0, '2022-12-06 16:13:59');
INSERT INTO `orders` VALUES (1600041153531482113, 1599423857683345409, 89, 2322.00, 0, '2022-12-06 16:15:13');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_mail` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_kind` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1600026330399776770 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (123, '吴鹏', '123', '1781287641@qq.com', 0);
INSERT INTO `user` VALUES (1599423737503952898, '丁静', 'dolor', 'j.wxwkdqomm@qq.com', NULL);
INSERT INTO `user` VALUES (1599423857683345409, 'abc', '123', 'j.wxwkdqomm@qq.com', 0);
INSERT INTO `user` VALUES (1599424913846833153, '武明', 'deseruntnon', 'j.eur@qq.com', 0);
INSERT INTO `user` VALUES (1599975147278708737, '田艳', 'deserunt consequat', 'h.mkgbylso@qq.com', 0);
INSERT INTO `user` VALUES (1600026330399776769, 'test', '123456', '123@abc.com', 0);

SET FOREIGN_KEY_CHECKS = 1;
