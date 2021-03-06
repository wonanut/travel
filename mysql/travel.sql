/*
 Navicat MySQL Data Transfer

 Source Server         : travel
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : travel

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 28/04/2021 14:16:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminID` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`adminID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'root123');
INSERT INTO `admin` VALUES (2, 'admin_super', 'super123');

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel`  (
  `hotelID` int(11) NOT NULL AUTO_INCREMENT,
  `hotelName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotelAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotelPrice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotelDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotelPicture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotelStar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotelAuthor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotelDate` datetime NULL DEFAULT NULL,
  `hotelPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotelRemain` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hotelStatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'normal',
  PRIMARY KEY (`hotelID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES (1, '????????????1', '??????????????????', '30/???', '????????????????????????', 'https://5b0988e595225.cdn.sohucs.com/images/20171212/14f763a8cd144b60860d560c39ebce4f.jpeg', '4', 'admin', '2021-03-31 13:43:28', '19200982672', '2', NULL);
INSERT INTO `hotel` VALUES (7, '????????????', '??????????????????1??????', '100/???', '?????????????????????????????????????????????', 'https://5b0988e595225.cdn.sohucs.com/images/20171212/14f763a8cd144b60860d560c39ebce4f.jpeg', '5', 'admin', '2021-04-01 13:35:04', '18293886542', '10', 'normal');
INSERT INTO `hotel` VALUES (8, '??????????????????', '????????????', '200/???', '????????????????????????', 'https://5b0988e595225.cdn.sohucs.com/images/20171212/14f763a8cd144b60860d560c39ebce4f.jpeg', '4', 'admin', '2021-04-25 13:44:08', '19200982672', '5', 'normal');

-- ----------------------------
-- Table structure for mesg
-- ----------------------------
DROP TABLE IF EXISTS `mesg`;
CREATE TABLE `mesg`  (
  `mesgID` int(11) NOT NULL AUTO_INCREMENT,
  `mesgTitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mesgDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mesgAuthor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mesgDate` datetime NULL DEFAULT NULL,
  `mesgPicture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`mesgID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mesg
-- ----------------------------
INSERT INTO `mesg` VALUES (1, '????????????????????????', '????????????????????????', 'admin', '2021-04-20 00:00:00', NULL);
INSERT INTO `mesg` VALUES (7, '???????????????????????????????????????????????????', '????????????????????????????????????????????????????????????????????????????????????????????????1', 'admin', '2021-04-24 21:38:28', NULL);
INSERT INTO `mesg` VALUES (8, 'test', 'test', 'admin', NULL, NULL);

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note`  (
  `noteID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `noteDate` datetime NULL DEFAULT NULL,
  `noteName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `noteDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`noteID`) USING BTREE,
  INDEX `userID`(`userID`) USING BTREE,
  CONSTRAINT `userID` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of note
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `productID` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productAuthor` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productPicture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productPrice` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productPhone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productRemain` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productStatus` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'normal',
  `productDate` datetime NULL DEFAULT NULL,
  `productStar` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`productID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '????????????1', '????????????????????????', 'admin', 'http://img1.voc.com.cn/UpLoadFile/2018/10/13/201810130918314508.jpg', '100.00', '18241887655', '1', NULL, '2021-03-31 13:59:49', '4');
INSERT INTO `product` VALUES (2, '??????????????????', '????????????', 'admin', 'https://5b0988e595225.cdn.sohucs.com/images/20171212/14f763a8cd144b60860d560c39ebce4f.jpeg', '129', '12078998765', '10', NULL, '2021-04-25 14:26:09', '4');
INSERT INTO `product` VALUES (4, '??????????????????', '????????????', 'admin', 'http://localhost:8080/upload/pictures/7c657d82-5cce-4c47-93e8-6c6df24eacd0.jpg', '129', '12078998765', '10', 'normal', '2021-04-25 19:30:48', '4');

-- ----------------------------
-- Table structure for site
-- ----------------------------
DROP TABLE IF EXISTS `site`;
CREATE TABLE `site`  (
  `siteID` int(11) NOT NULL AUTO_INCREMENT COMMENT '??????ID',
  `siteTitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '????????????',
  `siteCity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '??????????????????',
  `siteStar` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '????????????',
  `sitePrice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '????????????',
  `siteDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '????????????',
  `sitePicture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '????????????',
  `siteAuthor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '?????????',
  PRIMARY KEY (`siteID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of site
-- ----------------------------
INSERT INTO `site` VALUES (3, '??????????????????????????????', '??????????????????', '5', '60', '????????????????????????????????????????????????~', 'http://img.mp.itc.cn/upload/20170703/9f5f4a5cdd3845409d704b76dfed0663_th.jpg', 'admin');
INSERT INTO `site` VALUES (9, '???????????????', '??????????????????', '5', '125', '????????????????????????', 'http://img.mp.itc.cn/upload/20170703/9f5f4a5cdd3845409d704b76dfed0663_th.jpg', 'admin');
INSERT INTO `site` VALUES (20, '????????????', '????????????', '4', '122', '????????????', 'http://localhost:8080/upload/pictures/a3cd04c6-d95e-4b8a-bab6-97c5acdec946.jpg', 'admin');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `userName` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '??????',
  `userPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '??????',
  `userSex` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '??????',
  `userAge` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '??????',
  `userPhone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '??????????????????',
  `userDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '??????????????????',
  `userProfile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'http://localhost:8080/upload/userProfiles/default.jpg' COMMENT '??????????????????',
  `userStatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'normal' COMMENT '????????????',
  PRIMARY KEY (`userID`, `userName`) USING BTREE,
  INDEX `userID`(`userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (13, '??????', '1234qwer', '???', '25', '18292886424', '?????????????????????????????????~', 'http://localhost:8080/upload/userProfiles/bf6d0d06-a554-4e35-98dc-0e2c5320cc94.jpg', 'normal');
INSERT INTO `user` VALUES (14, '??????', 'qwerlisi', '???', '24', '12340098821', '???????????????????????????', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (15, '??????', 'ceshiyonghu', '???', '25', '19823202312', '?????????????????????????????????~', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (16, '????????????', 'qwer1234', '???', '24', '-', '?????????????????????????????????~', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (17, '??????', 'mimaya', '???', '??????', '123', '?????????????????????????????????~', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (18, '?????????', 'wangjianbing', '???', '21', '18292776251', '?????????????????????????????????~', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (19, '??????', 'xuxiangmima', '???', '23', '18723091232', '?????????????????????????????????~', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (20, '?????????', 'zhangjunwen', '???', '22', '-', '?????????????????????????????????~', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (21, '?????????', 'guoanjie', '???', '21', '-', '??????????????????????????????', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (22, '??????', 'woshizhangjie', '???', '32', '-', '?????????????????????', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (23, '??????', 'wuxiaa', '???', '22', '15290887621', '????????????', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (29, 'tongyao', 'qwer1234', '???', '21', '18292887621', '???????????????????????????', 'http://localhost:8080/upload/userProfiles/daf6c6ac-5fb5-487a-a77f-9e3359c2718b.jpg', 'normal');
INSERT INTO `user` VALUES (36, '??????2', 'qwer1234', '???', '20', '-', '?????????????????????????????????~', 'http://localhost:8080/upload/userProfiles/fae200df-75fa-47ce-9a3d-c440919e627e.jpg', 'normal');
INSERT INTO `user` VALUES (37, '??????', 'lisi', '???', '21', '182922346424', '?????????????????????2???', 'null', 'normal');

SET FOREIGN_KEY_CHECKS = 1;
