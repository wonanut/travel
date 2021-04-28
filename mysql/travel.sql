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
INSERT INTO `hotel` VALUES (1, '民宿信息1', '陕西省延安市', '30/天', '民宿信息详细介绍', 'https://5b0988e595225.cdn.sohucs.com/images/20171212/14f763a8cd144b60860d560c39ebce4f.jpeg', '4', 'admin', '2021-03-31 13:43:28', '19200982672', '2', NULL);
INSERT INTO `hotel` VALUES (7, '搬木民宿', '搬木庄园内部1号楼', '100/天', '搬木民宿，质量有保证，值得信赖', 'https://5b0988e595225.cdn.sohucs.com/images/20171212/14f763a8cd144b60860d560c39ebce4f.jpeg', '5', 'admin', '2021-04-01 13:35:04', '18293886542', '10', 'normal');
INSERT INTO `hotel` VALUES (8, '民宿信息测试', '搬木庄园', '200/天', '民宿信息详细介绍', 'https://5b0988e595225.cdn.sohucs.com/images/20171212/14f763a8cd144b60860d560c39ebce4f.jpeg', '4', 'admin', '2021-04-25 13:44:08', '19200982672', '5', 'normal');

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
INSERT INTO `mesg` VALUES (1, '这是一条测试公告', '这是一条测试公告', 'admin', '2021-04-20 00:00:00', NULL);
INSERT INTO `mesg` VALUES (7, '搬木民宿庄园线上平台正式上线运行啦', '搬木民宿庄园线上平台正式上线运行啦，从今天起一个月为对外测试时间1', 'admin', '2021-04-24 21:38:28', NULL);
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
INSERT INTO `product` VALUES (1, '特产信息1', '特产信息详细介绍', 'admin', 'http://img1.voc.com.cn/UpLoadFile/2018/10/13/201810130918314508.jpg', '100.00', '18241887655', '1', NULL, '2021-03-31 13:59:49', '4');
INSERT INTO `product` VALUES (2, '特产模块测试', '测试内容', 'admin', 'https://5b0988e595225.cdn.sohucs.com/images/20171212/14f763a8cd144b60860d560c39ebce4f.jpeg', '129', '12078998765', '10', NULL, '2021-04-25 14:26:09', '4');
INSERT INTO `product` VALUES (4, '特产模块测试', '测试内容', 'admin', 'http://localhost:8080/upload/pictures/7c657d82-5cce-4c47-93e8-6c6df24eacd0.jpg', '129', '12078998765', '10', 'normal', '2021-04-25 19:30:48', '4');

-- ----------------------------
-- Table structure for site
-- ----------------------------
DROP TABLE IF EXISTS `site`;
CREATE TABLE `site`  (
  `siteID` int(11) NOT NULL AUTO_INCREMENT COMMENT '景点ID',
  `siteTitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '景点名称',
  `siteCity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '景点所在城市',
  `siteStar` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推荐星级',
  `sitePrice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '景点门票',
  `siteDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '景点介绍',
  `sitePicture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '景点图片',
  `siteAuthor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布人',
  PRIMARY KEY (`siteID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of site
-- ----------------------------
INSERT INTO `site` VALUES (3, '搬木民宿庄园必看景点', '甘肃省兰州市', '5', '60', '搬木民宿庄园必看景点，快点预定吧~', 'http://img.mp.itc.cn/upload/20170703/9f5f4a5cdd3845409d704b76dfed0663_th.jpg', 'admin');
INSERT INTO `site` VALUES (9, '宝鸡农家乐', '陕西省宝鸡市', '5', '125', '景点信息详细介绍', 'http://img.mp.itc.cn/upload/20170703/9f5f4a5cdd3845409d704b76dfed0663_th.jpg', 'admin');
INSERT INTO `site` VALUES (20, '测试内容', '测试内容', '4', '122', '测试内容', 'http://localhost:8080/upload/pictures/a3cd04c6-d95e-4b8a-bab6-97c5acdec946.jpg', 'admin');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `userName` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `userPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `userSex` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `userAge` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年龄',
  `userPhone` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户个人电话',
  `userDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户个人描述',
  `userProfile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'http://localhost:8080/upload/userProfiles/default.jpg' COMMENT '用户头像地址',
  `userStatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'normal' COMMENT '账户状态',
  PRIMARY KEY (`userID`, `userName`) USING BTREE,
  INDEX `userID`(`userID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (13, '张三', '1234qwer', '男', '25', '18292886424', '这个人很懒，什么都没写~', 'http://localhost:8080/upload/userProfiles/bf6d0d06-a554-4e35-98dc-0e2c5320cc94.jpg', 'normal');
INSERT INTO `user` VALUES (14, '李四', 'qwerlisi', '男', '24', '12340098821', '我是尊贵的测试用户', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (15, '测试', 'ceshiyonghu', '男', '25', '19823202312', '这个人很懒，什么都没写~', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (16, '测试用户', 'qwer1234', '男', '24', '-', '这个人很懒，什么都没写~', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (17, '王五', 'mimaya', '女', '未知', '123', '这个人很懒，什么都没写~', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (18, '汪检兵', 'wangjianbing', '男', '21', '18292776251', '这个人很懒，什么都没写~', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (19, '许翔', 'xuxiangmima', '男', '23', '18723091232', '这个人很懒，什么都没写~', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (20, '张俊雯', 'zhangjunwen', '女', '22', '-', '这个人很懒，什么都没写~', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (21, '郭安杰', 'guoanjie', '男', '21', '-', '作为测试用户我很自豪', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (22, '张杰', 'woshizhangjie', '男', '32', '-', '我不是唱歌的吗', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (23, '吴霞', 'wuxiaa', '女', '22', '15290887621', '测试用户', 'http://localhost:8080/upload/userProfiles/default.jpg', 'normal');
INSERT INTO `user` VALUES (29, 'tongyao', 'qwer1234', '男', '21', '18292887621', '我是专业的测试账号', 'http://localhost:8080/upload/userProfiles/daf6c6ac-5fb5-487a-a77f-9e3359c2718b.jpg', 'normal');
INSERT INTO `user` VALUES (36, '测试2', 'qwer1234', '男', '20', '-', '这个人很懒，什么都没写~', 'http://localhost:8080/upload/userProfiles/fae200df-75fa-47ce-9a3d-c440919e627e.jpg', 'normal');
INSERT INTO `user` VALUES (37, '李四', 'lisi', '男', '21', '182922346424', '尊贵的测试用户2！', 'null', 'normal');

SET FOREIGN_KEY_CHECKS = 1;
