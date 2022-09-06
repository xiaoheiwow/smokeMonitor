/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : hospital_smoke_control

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 06/09/2022 15:14:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `hospital_id` bigint(0) NULL DEFAULT NULL COMMENT '所属医院id',
  `dept_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '部门名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_by` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, 1, '住院部', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `department` VALUES (2, 2, '住院部', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `department` VALUES (3, 2, '行政部', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `department` VALUES (4, 3, '住院部', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `department` VALUES (5, 1, '行政部', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `department` VALUES (6, 3, '行政部', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `department` VALUES (9, 3, '404部', '2022-08-19 09:27:42', '2022-08-19 09:30:28', '199911||yatoro', '199911||yatoro', NULL);
INSERT INTO `department` VALUES (10, 1, '财务部', '2022-08-19 09:30:39', NULL, '199911||yatoro', NULL, NULL);

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `hospital_id` bigint(0) NULL DEFAULT NULL COMMENT '所属医院id',
  `equip_name` varchar(90) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '设备名称',
  `building` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '所在楼宇',
  `equip_location` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '设备点位',
  `ip_location` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'ip地址',
  `equip_status` int(0) NULL DEFAULT NULL COMMENT '设备状态 默认0-离线 1-在线',
  `user_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '使用者',
  `password` varchar(90) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '设备密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_by` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '设备描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `equip_hospital_fk1`(`hospital_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '设备表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES (1, 3, 'XUP-123', '404大楼', '404', '1.1.1.1', 1, 'test6', 'test123', NULL, '2022-08-22 10:44:59', NULL, '199911||yatoro', NULL);
INSERT INTO `equipment` VALUES (2, 3, 'PXW-X278', '新大楼3楼北侧', '3楼精神科第九诊室左侧', '192.168.9.1', 1, 'admin', '123456', NULL, '2022-08-22 11:28:46', NULL, '199911||yatoro', NULL);
INSERT INTO `equipment` VALUES (3, 3, 'PXW-X260', '新大楼1楼南侧', '门诊室右侧', '192.168.9.1', 0, 'admin', '123456', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `equipment` VALUES (4, 2, 'PXW-X250', '新大楼1楼北侧', '门口', '192.168.9.1', 1, 'admin', '123456', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `equipment` VALUES (6, 1, 'PXW-X220', '新大楼1楼南侧', '第一诊室左侧', '192.168.9.1', 0, 'admin', '123456', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `equipment` VALUES (7, 3, 'PXW-X210', '新大楼2楼', '儿科左侧', '192.168.9.1', 1, 'admin', '123456', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `equipment` VALUES (8, 3, 'PXW-X262', '新大楼1楼', '门诊室右侧', '192.168.9.1', 0, 'admin', '123456', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `equipment` VALUES (11, 2, 'XUI-777', '东大楼3楼', '化验室左侧', '2.2.2.2', 1, 'yyy', '123456', '2022-08-18 19:50:39', NULL, '199911||yatoro', NULL, NULL);
INSERT INTO `equipment` VALUES (12, 1, 'MGT-Y-7', 'test', '香蕉道', '3.3.3.3', 0, 'red', 'redbat', '2022-08-18 19:52:05', NULL, '199911||yatoro', NULL, NULL);

-- ----------------------------
-- Table structure for hospital
-- ----------------------------
DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `hospital_name` varchar(90) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '医院名称',
  `hospital_level` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '医院等级',
  `hospital_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '医院类别',
  `hospital_region` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '医院所属区域',
  `hospital_location` varchar(90) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '医院所在位置',
  `equipment_quantity` int(0) NULL DEFAULT NULL COMMENT '设备数量',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_by` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '医院描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '医院列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hospital
-- ----------------------------
INSERT INTO `hospital` VALUES (1, '南京市中心医院', '二级甲等', '综合医院', '玄武区', '成贤街116号', 30, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital` VALUES (2, '南京市中心医院2', '一级甲等', '综合医院', '建邺区', '成贤街116号', 30, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital` VALUES (3, '江苏省人民医院', '三级甲等', '综合医院', '鼓楼区', '广州路300号', 77, NULL, '2022-08-17 16:07:53', NULL, '199911||yatoro', NULL);

-- ----------------------------
-- Table structure for hospital_building
-- ----------------------------
DROP TABLE IF EXISTS `hospital_building`;
CREATE TABLE `hospital_building`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `hospital_id` bigint(0) NOT NULL COMMENT '医院id',
  `building_name` varchar(90) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '楼宇名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_by` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '楼宇备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `hospital_id`(`hospital_id`) USING BTREE,
  CONSTRAINT `hospital_building_ibfk_1` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '医院楼宇表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hospital_building
-- ----------------------------
INSERT INTO `hospital_building` VALUES (1, 1, '门诊综合大楼', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital_building` VALUES (2, 1, '行政办公室', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital_building` VALUES (3, 1, 'CT楼', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital_building` VALUES (4, 2, '门诊综合大楼', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital_building` VALUES (5, 2, 'CT楼', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital_building` VALUES (6, 3, '门诊综合大楼', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital_building` VALUES (10, 3, '404大楼', '2022-08-18 11:07:24', NULL, '199911||yatoro', NULL, NULL);
INSERT INTO `hospital_building` VALUES (13, 3, '500大楼', '2022-08-18 11:42:33', NULL, '199911||yatoro', NULL, NULL);

-- ----------------------------
-- Table structure for hospital_equip_location
-- ----------------------------
DROP TABLE IF EXISTS `hospital_equip_location`;
CREATE TABLE `hospital_equip_location`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `hospital_id` bigint(0) NOT NULL COMMENT '所属医院id',
  `location_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '点位名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_by` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '医院设备点位描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `hospital_id`(`hospital_id`) USING BTREE,
  CONSTRAINT `hospital_equip_location_ibfk_1` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '医院设备点位表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hospital_equip_location
-- ----------------------------
INSERT INTO `hospital_equip_location` VALUES (1, 2, '精神科诊室1左侧', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital_equip_location` VALUES (4, 3, '放射科北侧', NULL, '2022-08-18 11:42:53', NULL, '199911||yatoro', NULL);
INSERT INTO `hospital_equip_location` VALUES (5, 1, '院长办公室右侧', NULL, '2022-08-18 11:53:05', NULL, '199911||yatoro', NULL);
INSERT INTO `hospital_equip_location` VALUES (6, 3, '门诊室', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital_equip_location` VALUES (7, 2, '中药房1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital_equip_location` VALUES (8, 1, '放射科右侧', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital_equip_location` VALUES (9, 3, '放射科066', '2022-08-18 11:42:56', NULL, '199911||yatoro', NULL, NULL);

-- ----------------------------
-- Table structure for hospital_office
-- ----------------------------
DROP TABLE IF EXISTS `hospital_office`;
CREATE TABLE `hospital_office`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `hospital_id` bigint(0) NULL DEFAULT NULL COMMENT '所属医院id',
  `office_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '科室名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_by` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '医院科室注释',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '医院科室表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hospital_office
-- ----------------------------
INSERT INTO `hospital_office` VALUES (1, 1, '院长办公室', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital_office` VALUES (2, 1, '内科', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital_office` VALUES (3, 1, '中药房', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital_office` VALUES (6, 2, '内科', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital_office` VALUES (7, 2, '儿科', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `hospital_office` VALUES (8, 3, '院长办公室', NULL, '2022-08-19 09:45:06', NULL, '199911||yatoro', NULL);
INSERT INTO `hospital_office` VALUES (9, 3, '外科', '2022-08-19 09:45:37', NULL, '199911||yatoro', NULL, NULL);

-- ----------------------------
-- Table structure for hospital_staff
-- ----------------------------
DROP TABLE IF EXISTS `hospital_staff`;
CREATE TABLE `hospital_staff`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '人员id',
  `office_id` bigint(0) NULL DEFAULT NULL COMMENT '科室id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_by` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '医务人员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hospital_staff
-- ----------------------------
INSERT INTO `hospital_staff` VALUES (1, 13, 8, '2022-08-23 09:14:51', NULL, NULL, NULL, NULL);
INSERT INTO `hospital_staff` VALUES (2, 14, 2, '2022-08-03 09:14:51', '2022-08-23 17:21:13', NULL, '199911||yatoro', NULL);
INSERT INTO `hospital_staff` VALUES (3, 15, 3, '2022-08-23 17:24:04', '2022-08-25 20:08:33', '199911||yatoro', '3215555555||sword', NULL);
INSERT INTO `hospital_staff` VALUES (4, 16, 9, '2022-08-23 17:40:20', NULL, '199911||yatoro', NULL, NULL);

-- ----------------------------
-- Table structure for inspector
-- ----------------------------
DROP TABLE IF EXISTS `inspector`;
CREATE TABLE `inspector`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户id',
  `scope` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '巡查范围',
  `cost_time` int(0) NULL DEFAULT NULL COMMENT '花费时间',
  `is_banned` int(0) NULL DEFAULT NULL COMMENT '默认 0-未被禁止 1-已被禁止',
  `banned_time` datetime(0) NULL DEFAULT NULL COMMENT '拉黑时间',
  `last_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `ip_location` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '最后登录ip',
  `login_times` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '登录次数',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_by` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '巡查人员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inspector
-- ----------------------------
INSERT INTO `inspector` VALUES (1, 5, '门诊楼5层', 5, 0, NULL, '2022-08-22 13:49:50', '192.116.82.103', '5', '2022-08-19 13:47:45', '2022-08-22 16:20:59', NULL, '199911||yatoro', NULL);
INSERT INTO `inspector` VALUES (2, 4, '门诊楼3层', 3, 0, NULL, '2022-08-22 13:49:50', '192.116.82.103', '6', '2022-08-19 13:47:45', NULL, NULL, NULL, NULL);
INSERT INTO `inspector` VALUES (3, 3, '门诊楼2层', 3, 0, NULL, '2022-08-22 13:49:50', '192.116.82.103', '11', '2022-08-19 13:47:45', NULL, NULL, NULL, NULL);
INSERT INTO `inspector` VALUES (4, 6, '三栋一层', 3, 1, '2022-08-22 15:14:52', '2022-08-22 13:49:50', '192.116.82.103', '12', '2022-08-19 13:47:45', NULL, NULL, NULL, NULL);
INSERT INTO `inspector` VALUES (5, 7, '二栋一层', 3, 1, '2022-08-22 15:14:57', '2022-08-22 13:49:50', '192.116.82.103', '13', '2022-08-19 13:47:45', NULL, NULL, NULL, NULL);
INSERT INTO `inspector` VALUES (6, 2, 'test', 4, 0, NULL, '2022-08-24 17:13:17', '192.116.2.103', '3', '2022-08-22 17:10:21', NULL, '199911||yatoro', NULL, NULL);
INSERT INTO `inspector` VALUES (10, 11, '车库一层', 5, 0, NULL, '2022-08-22 19:04:52', NULL, '0', '2022-08-22 19:04:52', '2022-08-22 19:14:28', '199911||yatoro', '199911||yatoro', NULL);
INSERT INTO `inspector` VALUES (11, 12, '实验室一层', 3, 0, NULL, '2022-08-22 19:20:10', NULL, '0', '2022-08-22 19:20:10', NULL, '199911||yatoro', NULL, NULL);

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
  `client_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `resource_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `client_secret` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `scope` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `authorized_grant_types` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `authorities` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `access_token_validity` int(0) NULL DEFAULT NULL,
  `refresh_token_validity` int(0) NULL DEFAULT NULL,
  `additional_information` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `autoapprove` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'oauth2' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('web-client', 'test', '$2a$10$j3yNjl/XFWwo4ImjVNcgl.TB9QNpEmU6IyuIuLWnaq047V5wY.NiS', 'read,write', 'authorization_code,password', 'http://www.baidu.com', 'ROLE_ADMIN', 144000, 0, NULL, 'false');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `hospital_id` bigint(0) NULL DEFAULT NULL COMMENT '医院id',
  `handler_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '负责人',
  `pusher_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '提交人/推送者',
  `order_number` varchar(90) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '工单编号',
  `alarm_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '报警类型',
  `order_progress` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '工单进度',
  `priority` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '优先度',
  `situation` int(0) NULL DEFAULT NULL COMMENT '默认0-待处理 1-处理中 2-已处理',
  `handler_phone` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '负责人电话',
  `address` varchar(90) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '地址',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_by` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '报警工单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, 3, 'sword', 'pop', 'DN10068830', '烟感报警', '100%', '中', 2, '1663997754', '江苏省人民医院放射科北侧', '2022-08-23 19:35:42', NULL, NULL, NULL, NULL);
INSERT INTO `order` VALUES (2, 3, 'sword', 'pop', 'DN10068831', '行为感知报警', '0%', '低', 0, '1663997754', '江苏省人民医院放射科北侧', '2022-08-24 14:17:23', '2022-08-24 14:17:46', NULL, '199911||yatoro', NULL);
INSERT INTO `order` VALUES (3, 3, 'sword', 'pop', 'DN10068832', '烟感报警', '40%', '中', 1, '1663997754', '江苏省人民医院放射科北侧', '2022-08-23 19:35:42', NULL, NULL, NULL, NULL);
INSERT INTO `order` VALUES (4, 3, '', 'pop', 'DN10068833', '烟感报警', '0%', '高', 0, '', '江苏省人民医院放射科北侧', '2022-08-23 19:35:42', NULL, NULL, NULL, NULL);
INSERT INTO `order` VALUES (5, 1, 'gua', 'cat', 'DN10068833', '烟感报警', '20%', '紧急', 1, '17777776', '南京市中心医院院长办公室右侧', '2022-08-23 19:35:42', '2022-08-25 09:39:58', NULL, '199911||yatoro', NULL);
INSERT INTO `order` VALUES (6, 1, '', 'cat', 'DN10068833', '烟感报警', '0%', '中', 0, '', '南京市中心医院院长办公室右侧', '2022-08-23 19:35:42', '2022-08-24 10:48:50', NULL, '199911||yatoro', NULL);

-- ----------------------------
-- Table structure for order_record
-- ----------------------------
DROP TABLE IF EXISTS `order_record`;
CREATE TABLE `order_record`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `order_id` bigint(0) NULL DEFAULT NULL COMMENT '处理工单id',
  `pusher_id` bigint(0) NULL DEFAULT NULL COMMENT '推送用户id',
  `handler_id` bigint(0) NULL DEFAULT NULL COMMENT '负责用户id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_by` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '工单记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_record
-- ----------------------------
INSERT INTO `order_record` VALUES (1, 1, 13, 16, '2022-08-22 16:46:42', NULL, NULL, NULL, NULL);
INSERT INTO `order_record` VALUES (2, 2, 13, 16, '2022-08-23 16:46:38', NULL, NULL, NULL, NULL);
INSERT INTO `order_record` VALUES (3, 3, 13, 16, '2022-08-24 16:46:32', NULL, NULL, NULL, NULL);
INSERT INTO `order_record` VALUES (4, 4, 13, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `order_record` VALUES (5, 5, 7, 15, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `order_record` VALUES (6, 6, 7, NULL, NULL, '2022-08-24 10:48:50', NULL, '199911||yatoro', NULL);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父权限id',
  `permission_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '权限名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_by` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 0, '首页', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (2, 15, '摄像机列表', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (3, 15, '摄像机管理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (4, 14, '医院列表', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (5, 14, '点位管理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (6, 0, '报警信息统计', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (7, 16, '工单推送', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (8, 16, '工单处理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (9, 17, '医务人员管理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (10, 17, '部门管理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (11, 17, '巡查人员管理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (12, 17, '用户管理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (13, 17, '角色管理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (14, 0, '医院管理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (15, 0, '设备管理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (16, 0, '报警工单管理', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (17, 0, '系统管理', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_by` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注',
  `comments` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '系统管理-角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', '2022-08-19 10:46:05', '2022-08-19 11:44:27', '', '199911||yatoro', 'admin', '超级');
INSERT INTO `role` VALUES (2, '管理员', '2022-08-11 10:46:08', NULL, NULL, NULL, 'admin', '管理');
INSERT INTO `role` VALUES (3, 'test154', '2022-08-11 10:46:08', '2022-08-19 11:55:25', NULL, '199911||yatoro', 'admin', '测试');
INSERT INTO `role` VALUES (4, '普通用户', '2022-08-22 13:43:49', NULL, NULL, NULL, 'user', '普通');
INSERT INTO `role` VALUES (8, '测试用', '2022-08-29 10:48:24', NULL, '199911||yatoro', NULL, NULL, NULL);
INSERT INTO `role` VALUES (9, '真测试', '2022-08-29 10:52:31', NULL, '3215555555||sword', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_relation`;
CREATE TABLE `role_permission_relation`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(0) NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` bigint(0) NULL DEFAULT NULL COMMENT '权限id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_by` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_permission_fk1`(`role_id`) USING BTREE,
  INDEX `role_permission_fk2`(`permission_id`) USING BTREE,
  CONSTRAINT `role_permission_fk1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_permission_fk2` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '角色权限关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission_relation
-- ----------------------------
INSERT INTO `role_permission_relation` VALUES (1, 1, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (2, 1, 6, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (3, 1, 14, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (4, 1, 15, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (5, 1, 16, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (6, 1, 17, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (7, 2, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (8, 2, 14, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (9, 3, 14, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (10, 4, 16, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (11, 3, 16, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (12, 8, 6, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (13, 8, 16, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (14, 8, 13, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (15, 9, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (16, 9, 6, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (17, 9, 4, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission_relation` VALUES (18, 9, 15, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `role_id` bigint(0) NULL DEFAULT NULL COMMENT '角色id',
  `hospital_id` bigint(0) NULL DEFAULT NULL COMMENT '所属医院id',
  `dept_id` bigint(0) NULL DEFAULT NULL COMMENT '部门id',
  `real_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `account` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账号或ID',
  `real_pass` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '未加密密码',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加密密码',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `sex` int(0) NULL DEFAULT 0 COMMENT '性别 0男 1女 默认0',
  `post_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '职务名称',
  `identification_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '身份证号码',
  `is_enable` int(0) NULL DEFAULT 0 COMMENT '是否被禁用 0否 1已禁用 默认0',
  `is_delete` int(0) NULL DEFAULT 0 COMMENT '是否被删除 0否 1已删除 默认0 ',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `modify_by` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `remarks` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注',
  `need_reLogin` int(0) NULL DEFAULT 0 COMMENT '是否需要重新登录',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `hospital_id`(`hospital_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  INDEX `dept_id`(`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 1, 1, 1, 'yatoro', '199911', '123456', '$2a$10$9rLKaH9tsGwCjacjvNSiUu.LR/klftsNZvYyp/sEmeD3CWkJKRkc2', '88489563', 0, '巡查总督', '23412366666666', 0, 0, NULL, '2022-08-22 11:18:57', NULL, '199911||yatoro', NULL, 0);
INSERT INTO `user` VALUES (2, 1, 3, 4, 'ame', 'atme', '123456', '$2a$10$9rLKaH9tsGwCjacjvNSiUu.LR/klftsNZvYyp/sEmeD3CWkJKRkc2', '151166666', 0, '巡查副总督', '23412315345333', 1, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (3, 2, 2, 2, 'iceice', 'mmy', '123456', '$2a$10$az3BJwWy3FvLZYsq/D2p2eS291Zxe38UXnrzi.EWwvCxMIvd9NeS6', '11458848', 0, '巡查副总督', '3205599776666', 0, 0, NULL, '2022-08-22 11:29:43', NULL, '199911||yatoro', NULL, 0);
INSERT INTO `user` VALUES (4, 3, 2, 2, 'zsmj', 'zsmj', '654321', '$2a$10$cU7.Fe4QPgYc/BQmZ.Rbqe3eLNUPsVSlWbPXnF0fw1.ry4IpzPBcy', '6638772114', 0, '巡查职员', '32027733337587', 0, 0, '2022-08-22 11:42:49', '2022-08-22 11:46:24', '199911||yatoro', '199911||yatoro', NULL, 0);
INSERT INTO `user` VALUES (5, 4, 3, 4, 'lint', 'lin', '654321', '$2a$10$cU7.Fe4QPgYc/BQmZ.Rbqe3eLNUPsVSlWbPXnF0fw1.ry4IpzPBcy', '1374272114', 0, '巡查职员', '320112737333371', 0, 0, '2022-08-22 11:42:49', '2022-08-22 11:46:24', '199911||yatoro', '199911||yatoro', NULL, 0);
INSERT INTO `user` VALUES (6, 4, 1, 1, 'ago', 'dolin', '654321', '$2a$10$cU7.Fe4QPgYc/BQmZ.Rbqe3eLNUPsVSlWbPXnF0fw1.ry4IpzPBcy', '13728176614', 0, '巡查职员', '32011111111171', 0, 0, '2022-08-22 11:42:49', '2022-08-22 11:46:24', '199911||yatoro', '199911||yatoro', NULL, 0);
INSERT INTO `user` VALUES (7, 4, 1, 1, 'cat', 'cat', '654321', '$2a$10$cU7.Fe4QPgYc/BQmZ.Rbqe3eLNUPsVSlWbPXnF0fw1.ry4IpzPBcy', '13734324124', 0, '门卫', '32011444411171', 0, 0, '2022-08-22 11:42:49', '2022-08-22 11:46:24', '199911||yatoro', '199911||yatoro', NULL, 0);
INSERT INTO `user` VALUES (11, 4, 1, 1, 'test', 'testUser', '654321', '$2a$10$cU7.Fe4QPgYc/BQmZ.Rbqe3eLNUPsVSlWbPXnF0fw1.ry4IpzPBcy', '99273368', 0, '门卫', '3209987666865', 0, 0, NULL, '2022-08-22 19:05:25', NULL, '199911||yatoro', NULL, 0);
INSERT INTO `user` VALUES (12, 2, 3, 4, 'ori', '312425', '654321', '$2a$10$hhrLqvdxEfznq9mW3b4S1u.UaAdz16Or7LehztAT8D19PfjXZnhx6', '12666666', 0, NULL, '32166666666613', 0, 0, '2022-08-22 19:20:42', NULL, '199911||yatoro', NULL, NULL, 0);
INSERT INTO `user` VALUES (13, 4, 3, 4, 'pop', 'popLove', '654321', '$2a$10$hhrLqvdxEfznq9mW3b4S1u.UaAdz16Or7LehztAT8D19PfjXZnhx6', '129999966', 0, '院长', '321673333333313', 0, 0, '2022-08-22 19:20:42', NULL, '199911||yatoro', NULL, NULL, 0);
INSERT INTO `user` VALUES (14, 4, 1, 10, 'konami0', 'cry', '654321', '$2a$10$hhrLqvdxEfznq9mW3b4S1u.UaAdz16Or7LehztAT8D19PfjXZnhx6', '12993333333', 0, '主任', '344444444444313', 0, 0, '2022-08-22 19:20:42', '2022-08-23 17:21:13', '199911||yatoro', '199911||yatoro', NULL, 0);
INSERT INTO `user` VALUES (15, 3, 1, 5, 'gua', '2323232323', '666666', '$2a$10$nEKtY6UjkCTB048uAbIr2u7g9C1kjQi2uiZ7AnJSrkPJOBBujIEri', '17777776', 0, '后勤部长', '80880808080', 0, 0, '2022-08-23 17:24:53', '2022-08-25 20:08:33', '199911||yatoro', '3215555555||sword', NULL, 0);
INSERT INTO `user` VALUES (16, 4, 3, 9, 'sword', '3215555555', '123456', '$2a$10$Bx/q/Go0/jphPVXOLgR3PucTYEKopjQMMf00FQX4G.pzeDhG3r0Ru', '1663997754', 0, '门卫', '5555333111122', 0, 0, '2022-08-23 17:40:40', NULL, '199911||yatoro', NULL, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
