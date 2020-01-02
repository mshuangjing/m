/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : cu

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 02/01/2020 14:33:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attribute_codelist_info
-- ----------------------------
DROP TABLE IF EXISTS `attribute_codelist_info`;
CREATE TABLE `attribute_codelist_info`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `attribute_id` bigint(20) NULL DEFAULT NULL,
  `code_id` bigint(20) NULL DEFAULT NULL,
  `mc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fl` bigint(20) NULL DEFAULT NULL,
  `bz` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sfyx` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for backups
-- ----------------------------
DROP TABLE IF EXISTS `backups`;
CREATE TABLE `backups`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tables` enum('系统配置','基础数据','用户信息') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备份范围',
  `path_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名称',
  `add_time` datetime(0) NOT NULL COMMENT '备份时间',
  `is_telnet` enum('远程备份','本地备份') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备份方式',
  `telnet_ip` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '远程IP',
  `telnet_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '远程用户',
  `telnet_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '远程密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for basic_domain
-- ----------------------------
DROP TABLE IF EXISTS `basic_domain`;
CREATE TABLE `basic_domain`  (
  `domain_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健，域名id，全局唯一',
  `domain_name` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '域名',
  `service_id` bigint(20) NOT NULL COMMENT '服务id，对应service_info表',
  `status` tinyint(1) NOT NULL COMMENT '0不变，1新增，2修改，3删除',
  PRIMARY KEY (`domain_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '域名信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for basic_frame
-- ----------------------------
DROP TABLE IF EXISTS `basic_frame`;
CREATE TABLE `basic_frame`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健，机房信息id，全局唯一',
  `house_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房id',
  `usertype` tinyint(1) NOT NULL COMMENT '适用类型1.自用，2.出租',
  `distribution` tinyint(1) NOT NULL COMMENT '分配状态 1.未分配 2.已分配',
  `occupancy` tinyint(1) NOT NULL COMMENT '占用状态 2.未占用 2.已占用',
  `frame_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房/机位名称',
  `is_special` tinyint(1) NOT NULL COMMENT '是否为专线 1.否 2.是',
  `status` tinyint(1) NOT NULL COMMENT '0不变，1新增，2修改，3删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '机架信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basic_frame
-- ----------------------------
INSERT INTO `basic_frame` VALUES (1, '10001', 2, 2, 1, '百卓', 1, 0);
INSERT INTO `basic_frame` VALUES (2, '10000', 1, 1, 1, '1-1', 1, 0);

-- ----------------------------
-- Table structure for basic_gateway
-- ----------------------------
DROP TABLE IF EXISTS `basic_gateway`;
CREATE TABLE `basic_gateway`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健，机房互联网入口ID，全局唯一',
  `house_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房id',
  `bandwidth` bigint(20) NOT NULL COMMENT '链路带宽',
  `linktype` tinyint(1) NOT NULL COMMENT '链路类型 1.电信，2.联通，3.移动，3铁通，9.其他',
  `accessunit` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '链路接入单位信息',
  `gatewayip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网管IP地址',
  `status` tinyint(1) NOT NULL COMMENT '0不变，1新增，2修改，3删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '链路信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basic_gateway
-- ----------------------------
INSERT INTO `basic_gateway` VALUES (1, '10001', 100, 2, '无', '192.168.1.1', 0);
INSERT INTO `basic_gateway` VALUES (2, '10000', 10, 2, 'd', '1.1.1.1', 0);

-- ----------------------------
-- Table structure for basic_house
-- ----------------------------
DROP TABLE IF EXISTS `basic_house`;
CREATE TABLE `basic_house`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健',
  `house_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房id，全局唯一',
  `house_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房名称',
  `idc_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'IDC/ISP许可证号',
  `house_type` int(3) NOT NULL COMMENT '机房性质。见10.4',
  `province` int(6) NOT NULL COMMENT '机房所在省或者直辖市',
  `city` int(6) NOT NULL COMMENT '机房所市或者区',
  `county` int(6) NULL DEFAULT NULL COMMENT '机房所有县',
  `house_addr` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房地址',
  `house_zip` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮编',
  `house_officer_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房网络安全责任人姓名',
  `house_officer_idtype` int(3) NOT NULL COMMENT '机房网络安全责任人证件类型见10.3',
  `house_officer_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房网络安全责任人证件号码',
  `house_officer_tel` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房网络安全责任人固定电话',
  `house_officer_mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房网络安全责任人移动电话',
  `house_officer_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房网络安全责任人邮箱',
  `status` tinyint(1) NOT NULL COMMENT '0不变，1新增，2修改，3删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '机房信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basic_house
-- ----------------------------
INSERT INTO `basic_house` VALUES (1, '10001', '百卓2楼', 'BJ_001', 2, 230000, 230100, 0, '百卓大厦', '000000', '马二美', 2, '37028477996452', '135123456789', '13512345678', 'baizhuo@mail.com', 0);
INSERT INTO `basic_house` VALUES (2, '10000', 'test机房', 'BJ_001', 2, 210000, 0, 0, '2', '100010', 'two', 2, 'ww', '010', '16666666666', 'h@123.com', 0);

-- ----------------------------
-- Table structure for basic_idc
-- ----------------------------
DROP TABLE IF EXISTS `basic_idc`;
CREATE TABLE `basic_idc`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健',
  `idc_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'IDC/ISP许可证号',
  `idc_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '经营者名称',
  `idc_addr` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '经营者通信地址',
  `idc_zip` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '经营者通信邮编',
  `idc_corp` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业法人',
  `idc_officer_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网络信息安全责任人姓名',
  `idc_officer_idtype` int(3) NOT NULL COMMENT '网络安全信息责任人证件类型见10.3',
  `idc_officer_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网络信息安全责任人证件号码',
  `idc_officer_tel` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网络信息安全责任人固定电话',
  `idc_officer_mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网络信息安全责任人移动电话',
  `idc_officer_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网络信息安全责任人邮箱',
  `idc_emergency_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应急联系人姓名',
  `idc_emergency_idtype` int(3) NOT NULL COMMENT '应急联系人证件类型见10.3',
  `idc_emergency_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应急联系人证件号码',
  `idc_emergency_tel` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应急联系人固定电话',
  `idc_emergency_mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应急联系人移动电话',
  `idc_emergency_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应急联系人邮箱',
  `idc_status` tinyint(1) NOT NULL COMMENT '0.不变，1.新增，2修改，3删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '经营者信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basic_idc
-- ----------------------------
INSERT INTO `basic_idc` VALUES (1, 'BJ_001', '北京百卓', '百卓大厦', '000000', '陈海滨', '刘大姐', 2, '370222546444444', '1825565599', '13522356789', '333@baizhuo.com', '汤景', 2, '37021465555655462', '182556655', '13522356789', 'baizhuo@mail.com', 0);

-- ----------------------------
-- Table structure for basic_ipseg
-- ----------------------------
DROP TABLE IF EXISTS `basic_ipseg`;
CREATE TABLE `basic_ipseg`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健，IP地址段资源编号，全局唯一',
  `house_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房id',
  `startip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '起始IP地址',
  `endip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '终止IP地址',
  `type` tinyint(1) NOT NULL COMMENT 'IP地址使用类型 0静止，1动态，2保留',
  `user` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用人或者单位',
  `id_type` int(3) NULL DEFAULT NULL COMMENT '使用人证件类型 见10.3',
  `idnumber` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件号码',
  `sourceunit` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '来源单位',
  `allocationunit` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分配单位',
  `usertime` int(10) NOT NULL COMMENT '分配使用时间',
  `status` tinyint(1) NOT NULL COMMENT '0不变，1新增，2修改，3删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basic_ipseg
-- ----------------------------
INSERT INTO `basic_ipseg` VALUES (1, '10001', '1.1.1.1', '255.255.255.255', 1, '张三', 2, '370118199508185566', '百卓', '百卓', 1576684800, 0);
INSERT INTO `basic_ipseg` VALUES (2, '10000', '1.1.1.1', '1.1.1.31', 0, '', NULL, '', '的', '的', 1576684800, 0);

-- ----------------------------
-- Table structure for basic_iptrans
-- ----------------------------
DROP TABLE IF EXISTS `basic_iptrans`;
CREATE TABLE `basic_iptrans`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主健自增',
  `domain_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '域名ID，对应basic_domain表中domain_id',
  `hhid` bigint(20) NOT NULL COMMENT '占用机房信息id',
  `internet_start_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '互联网起始IP地址',
  `internet_end_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '互联网终止IP地址',
  `net_start_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0不变，1新增，2修改，3删除',
  `net_end_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'IP地址转换信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for basic_ispuser_house
-- ----------------------------
DROP TABLE IF EXISTS `basic_ispuser_house`;
CREATE TABLE `basic_ispuser_house`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健',
  `hhid` bigint(20) NOT NULL COMMENT '占用机房信息的id',
  `service_id` bigint(20) NOT NULL COMMENT '服务id，对应service_info表的service_id',
  `house_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'IDC/ISP机房ID',
  `distribute_time` int(10) NOT NULL COMMENT '资源分配时间',
  `frame_info_id` int(10) NULL DEFAULT NULL COMMENT '机架信息ID',
  `band_width` int(10) NULL DEFAULT NULL COMMENT '网络宽带',
  `status` tinyint(1) NOT NULL COMMENT '0不变，1新增，2修改，3删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '占用机房信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for basic_otheruser_house
-- ----------------------------
DROP TABLE IF EXISTS `basic_otheruser_house`;
CREATE TABLE `basic_otheruser_house`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健',
  `hhid` bigint(20) NOT NULL COMMENT '占用机房信息ID',
  `user_id` bigint(20) NOT NULL COMMENT '其他用户id',
  `house_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'IDC/ISP机房ID',
  `distribute_time` int(10) NOT NULL COMMENT '资源分配时间',
  `band_width` int(10) NULL DEFAULT NULL COMMENT '网络宽带',
  `status` tinyint(1) NOT NULL COMMENT '0不变，1新增，2修改，3删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '其他机房信息占用信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for basic_otheruser_ipseg
-- ----------------------------
DROP TABLE IF EXISTS `basic_otheruser_ipseg`;
CREATE TABLE `basic_otheruser_ipseg`  (
  `ip_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健。IP段编号，全局唯一',
  `hhid` bigint(20) NOT NULL COMMENT '占用机房id',
  `start_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '起始IP地址',
  `end_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '终止IP地址',
  `is_special` tinyint(1) NOT NULL,
  `status` tinyint(1) NOT NULL COMMENT '0不变，1新增，2修改，3删除',
  PRIMARY KEY (`ip_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '其他用户机房IP地址信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for basic_service
-- ----------------------------
DROP TABLE IF EXISTS `basic_service`;
CREATE TABLE `basic_service`  (
  `service_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健，服务编号，全局唯一',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `service_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务内容代码，见10.6',
  `regtype` int(3) NULL DEFAULT NULL COMMENT '备案类型，见10.9',
  `regid` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备案号/许可证号',
  `set_mode` int(3) NULL DEFAULT NULL COMMENT '接入方式见10.1',
  `business` tinyint(1) NOT NULL COMMENT '业务类型 1.IDC业务，2.ISP业务',
  `status` tinyint(1) NOT NULL COMMENT '0不变，1新增，2修改，3删除',
  PRIMARY KEY (`service_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '服务信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for basic_user
-- ----------------------------
DROP TABLE IF EXISTS `basic_user`;
CREATE TABLE `basic_user`  (
  `user_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健，用户ID，全局唯一',
  `idc_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'IDC/ISP许可证号',
  `nature` tinyint(1) NOT NULL COMMENT '用户属性 1.提供互联网服务用户 2.其他用户',
  `unitname` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位名称',
  `unitnature` int(3) NOT NULL COMMENT '单位属性，见10.2',
  `id_type` int(3) NOT NULL COMMENT '证件类型，见10.3',
  `idnumber` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '证件号码',
  `officer_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网络信息安全责任人姓名',
  `officer_idtype` int(3) NOT NULL COMMENT '网络信息安全责任人证件类型见10.3',
  `officer_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网络信息安全责任人证件号码',
  `officer_tel` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网络信息安全责任人固定电话',
  `officer_mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网络信息安全责任人移动电话',
  `officer_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网络信息安全责任人邮箱',
  `addr` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位地址',
  `zip_code` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮政编码',
  `service_reg_time` int(10) NOT NULL COMMENT '服务开通时间，只有其他用户时需要填写，互联网用户不需要填写',
  `register_time` int(10) NOT NULL COMMENT '注册时间',
  `status` tinyint(1) NOT NULL COMMENT '0不变，1新增，2修改，3删除',
  `is_user` tinyint(2) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '提供互联网应用服务的用户信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for basic_virtualhost
-- ----------------------------
DROP TABLE IF EXISTS `basic_virtualhost`;
CREATE TABLE `basic_virtualhost`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健',
  `hhid` bigint(20) NOT NULL COMMENT '占用机房信息id',
  `virtual_host_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '虚拟主机名称',
  `virtual_host_state` int(10) NULL DEFAULT NULL COMMENT '虚拟主机状态',
  `virtual_host_type` tinyint(1) NULL DEFAULT NULL COMMENT '虚拟主机类型 1.共享式，2.专用式，3.云虚拟',
  `virtual_host_addr` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '虚拟主机网络地址',
  `virtual_host_management_addr` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '虚拟主机管理地址',
  `status` tinyint(1) NOT NULL COMMENT '0不变，1新增，2修改，3删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '虚拟主机信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cu_commandid
-- ----------------------------
DROP TABLE IF EXISTS `cu_commandid`;
CREATE TABLE `cu_commandid`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健',
  `commandid` bigint(20) NOT NULL COMMENT '指令id，全局唯一',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'commandid全局表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cu_commandid
-- ----------------------------
INSERT INTO `cu_commandid` VALUES (1, 1);
INSERT INTO `cu_commandid` VALUES (2, 2);
INSERT INTO `cu_commandid` VALUES (3, 3);
INSERT INTO `cu_commandid` VALUES (4, 4);
INSERT INTO `cu_commandid` VALUES (5, 5);
INSERT INTO `cu_commandid` VALUES (6, 6);
INSERT INTO `cu_commandid` VALUES (7, 7);
INSERT INTO `cu_commandid` VALUES (8, 8);
INSERT INTO `cu_commandid` VALUES (9, 9);

-- ----------------------------
-- Table structure for cu_hhid
-- ----------------------------
DROP TABLE IF EXISTS `cu_hhid`;
CREATE TABLE `cu_hhid`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增抓紧',
  `hhid` bigint(20) NOT NULL COMMENT '占用机房信息的ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '占用机房信息ID全局表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for device_info
-- ----------------------------
DROP TABLE IF EXISTS `device_info`;
CREATE TABLE `device_info`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `house_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房名称',
  `device_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '社保名称',
  `webservice_addr` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'webservice接口地址',
  `online` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0离线，1在线',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '机房EU设备表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device_info
-- ----------------------------
INSERT INTO `device_info` VALUES (1, '10001', 'baizhui', 'http://10.81.1.10:8888/idcCommand?wsdl', 0);

-- ----------------------------
-- Table structure for isms_rule
-- ----------------------------
DROP TABLE IF EXISTS `isms_rule`;
CREATE TABLE `isms_rule`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增 主健',
  `commandid` bigint(20) NOT NULL COMMENT '与策略表中的ID关联',
  `subtype` tinyint(1) NOT NULL COMMENT '规则代码，见10.7',
  `value_start` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '规则为IP时为起始值，其它类型为规则内容',
  `value_end` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仅在IP规则有效，标识结束IP',
  `keyword_range` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0正文标题及正文本身，1 附件文件题目，2 附件正文 多个之间使用半角逗号隔开',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '规则表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of isms_rule
-- ----------------------------
INSERT INTO `isms_rule` VALUES (1, 5, 1, 'www.163.com', '', '');

-- ----------------------------
-- Table structure for log_active_state
-- ----------------------------
DROP TABLE IF EXISTS `log_active_state`;
CREATE TABLE `log_active_state`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `idc_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'idc/isp许可证号',
  `house_amount` int(10) NOT NULL COMMENT '机房总数',
  `errhouse_amount` int(10) NOT NULL COMMENT '异常机房总数',
  `errhouse_id` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '异常机房id，多个以逗号分隔',
  `timestamp` int(10) NOT NULL COMMENT '上报时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 849 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'isms活动状态表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log_active_state
-- ----------------------------
INSERT INTO `log_active_state` VALUES (1, '', 0, 0, '', 1576565127);
INSERT INTO `log_active_state` VALUES (2, '', 0, 0, '', 1576565727);
INSERT INTO `log_active_state` VALUES (3, '', 0, 0, '', 1576566327);
INSERT INTO `log_active_state` VALUES (4, '', 0, 0, '', 1576566927);
INSERT INTO `log_active_state` VALUES (5, '', 0, 0, '', 1576567527);
INSERT INTO `log_active_state` VALUES (6, '', 0, 0, '', 1576568127);
INSERT INTO `log_active_state` VALUES (7, '', 0, 0, '', 1576568727);
INSERT INTO `log_active_state` VALUES (8, '', 0, 0, '', 1576569327);
INSERT INTO `log_active_state` VALUES (9, '', 0, 0, '', 1576569927);
INSERT INTO `log_active_state` VALUES (10, '', 0, 0, '', 1576570527);
INSERT INTO `log_active_state` VALUES (11, '', 0, 0, '', 1576571127);
INSERT INTO `log_active_state` VALUES (12, '', 0, 0, '', 1576571727);
INSERT INTO `log_active_state` VALUES (13, '', 0, 0, '', 1576572586);
INSERT INTO `log_active_state` VALUES (14, '', 0, 0, '', 1576573186);
INSERT INTO `log_active_state` VALUES (15, '', 0, 0, '', 1576573786);
INSERT INTO `log_active_state` VALUES (16, '', 0, 0, '', 1576574386);
INSERT INTO `log_active_state` VALUES (17, '', 0, 0, '', 1576574986);
INSERT INTO `log_active_state` VALUES (18, '', 0, 0, '', 1576575586);
INSERT INTO `log_active_state` VALUES (19, '', 0, 0, '', 1576576186);
INSERT INTO `log_active_state` VALUES (20, '', 0, 0, '', 1576576786);
INSERT INTO `log_active_state` VALUES (21, '', 0, 0, '', 1576577386);
INSERT INTO `log_active_state` VALUES (22, '', 0, 0, '', 1576577986);
INSERT INTO `log_active_state` VALUES (23, '', 0, 0, '', 1576578586);
INSERT INTO `log_active_state` VALUES (24, '', 0, 0, '', 1576579186);
INSERT INTO `log_active_state` VALUES (25, '', 0, 0, '', 1576579786);
INSERT INTO `log_active_state` VALUES (26, '', 0, 0, '', 1576580386);
INSERT INTO `log_active_state` VALUES (27, '', 0, 0, '', 1576580986);
INSERT INTO `log_active_state` VALUES (28, '', 0, 0, '', 1576581586);
INSERT INTO `log_active_state` VALUES (29, '', 0, 0, '', 1576582186);
INSERT INTO `log_active_state` VALUES (30, '', 0, 0, '', 1576582786);
INSERT INTO `log_active_state` VALUES (31, '', 0, 0, '', 1576583386);
INSERT INTO `log_active_state` VALUES (32, '', 0, 0, '', 1576583986);
INSERT INTO `log_active_state` VALUES (33, '', 0, 0, '', 1576584586);
INSERT INTO `log_active_state` VALUES (34, '', 0, 0, '', 1576585186);
INSERT INTO `log_active_state` VALUES (35, '', 0, 0, '', 1576585786);
INSERT INTO `log_active_state` VALUES (36, '', 0, 0, '', 1576586386);
INSERT INTO `log_active_state` VALUES (37, '', 0, 0, '', 1576586986);
INSERT INTO `log_active_state` VALUES (38, '', 0, 0, '', 1576587586);
INSERT INTO `log_active_state` VALUES (39, '', 0, 0, '', 1576588186);
INSERT INTO `log_active_state` VALUES (40, '', 0, 0, '', 1576588786);
INSERT INTO `log_active_state` VALUES (41, '', 0, 0, '', 1576589386);
INSERT INTO `log_active_state` VALUES (42, '', 0, 0, '', 1576589986);
INSERT INTO `log_active_state` VALUES (43, '', 0, 0, '', 1576590586);
INSERT INTO `log_active_state` VALUES (44, '', 0, 0, '', 1576591186);
INSERT INTO `log_active_state` VALUES (45, '', 0, 0, '', 1576591786);
INSERT INTO `log_active_state` VALUES (46, '', 0, 0, '', 1576592386);
INSERT INTO `log_active_state` VALUES (47, '', 0, 0, '', 1576592986);
INSERT INTO `log_active_state` VALUES (48, '', 0, 0, '', 1576593586);
INSERT INTO `log_active_state` VALUES (49, '', 0, 0, '', 1576594186);
INSERT INTO `log_active_state` VALUES (50, '', 0, 0, '', 1576594786);
INSERT INTO `log_active_state` VALUES (51, '', 0, 0, '', 1576595386);
INSERT INTO `log_active_state` VALUES (52, '', 0, 0, '', 1576595986);
INSERT INTO `log_active_state` VALUES (53, '', 0, 0, '', 1576596586);
INSERT INTO `log_active_state` VALUES (54, '', 0, 0, '', 1576597186);
INSERT INTO `log_active_state` VALUES (55, '', 0, 0, '', 1576597786);
INSERT INTO `log_active_state` VALUES (56, '', 0, 0, '', 1576598386);
INSERT INTO `log_active_state` VALUES (57, '', 0, 0, '', 1576598986);
INSERT INTO `log_active_state` VALUES (58, '', 0, 0, '', 1576599586);
INSERT INTO `log_active_state` VALUES (59, '', 0, 0, '', 1576600186);
INSERT INTO `log_active_state` VALUES (60, '', 0, 0, '', 1576600786);
INSERT INTO `log_active_state` VALUES (61, '', 0, 0, '', 1576601386);
INSERT INTO `log_active_state` VALUES (62, '', 0, 0, '', 1576601986);
INSERT INTO `log_active_state` VALUES (63, '', 0, 0, '', 1576602586);
INSERT INTO `log_active_state` VALUES (64, '', 0, 0, '', 1576603186);
INSERT INTO `log_active_state` VALUES (65, '', 0, 0, '', 1576603786);
INSERT INTO `log_active_state` VALUES (66, '', 0, 0, '', 1576604386);
INSERT INTO `log_active_state` VALUES (67, '', 0, 0, '', 1576604986);
INSERT INTO `log_active_state` VALUES (68, '', 0, 0, '', 1576605586);
INSERT INTO `log_active_state` VALUES (69, '', 0, 0, '', 1576606186);
INSERT INTO `log_active_state` VALUES (70, '', 0, 0, '', 1576606786);
INSERT INTO `log_active_state` VALUES (71, '', 0, 0, '', 1576607386);
INSERT INTO `log_active_state` VALUES (72, '', 0, 0, '', 1576607986);
INSERT INTO `log_active_state` VALUES (73, '', 0, 0, '', 1576608586);
INSERT INTO `log_active_state` VALUES (74, '', 0, 0, '', 1576609186);
INSERT INTO `log_active_state` VALUES (75, '', 0, 0, '', 1576609786);
INSERT INTO `log_active_state` VALUES (76, '', 0, 0, '', 1576610386);
INSERT INTO `log_active_state` VALUES (77, '', 0, 0, '', 1576610986);
INSERT INTO `log_active_state` VALUES (78, '', 0, 0, '', 1576611586);
INSERT INTO `log_active_state` VALUES (79, '', 0, 0, '', 1576612186);
INSERT INTO `log_active_state` VALUES (80, '', 0, 0, '', 1576612786);
INSERT INTO `log_active_state` VALUES (81, '', 0, 0, '', 1576613386);
INSERT INTO `log_active_state` VALUES (82, '', 0, 0, '', 1576613986);
INSERT INTO `log_active_state` VALUES (83, '', 0, 0, '', 1576614586);
INSERT INTO `log_active_state` VALUES (84, '', 0, 0, '', 1576615186);
INSERT INTO `log_active_state` VALUES (85, '', 0, 0, '', 1576615786);
INSERT INTO `log_active_state` VALUES (86, '', 0, 0, '', 1576616386);
INSERT INTO `log_active_state` VALUES (87, '', 0, 0, '', 1576616986);
INSERT INTO `log_active_state` VALUES (88, '', 0, 0, '', 1576617586);
INSERT INTO `log_active_state` VALUES (89, '', 0, 0, '', 1576618186);
INSERT INTO `log_active_state` VALUES (90, '', 0, 0, '', 1576618786);
INSERT INTO `log_active_state` VALUES (91, '', 0, 0, '', 1576619386);
INSERT INTO `log_active_state` VALUES (92, '', 0, 0, '', 1576619986);
INSERT INTO `log_active_state` VALUES (93, '', 0, 0, '', 1576620586);
INSERT INTO `log_active_state` VALUES (94, '', 0, 0, '', 1576621186);
INSERT INTO `log_active_state` VALUES (95, '', 0, 0, '', 1576621786);
INSERT INTO `log_active_state` VALUES (96, '', 0, 0, '', 1576622386);
INSERT INTO `log_active_state` VALUES (97, '', 0, 0, '', 1576622986);
INSERT INTO `log_active_state` VALUES (98, '', 0, 0, '', 1576623586);
INSERT INTO `log_active_state` VALUES (99, '', 0, 0, '', 1576624186);
INSERT INTO `log_active_state` VALUES (100, '', 0, 0, '', 1576624786);
INSERT INTO `log_active_state` VALUES (101, '', 0, 0, '', 1576625386);
INSERT INTO `log_active_state` VALUES (102, '', 0, 0, '', 1576625986);
INSERT INTO `log_active_state` VALUES (103, '', 0, 0, '', 1576626586);
INSERT INTO `log_active_state` VALUES (104, '', 0, 0, '', 1576627186);
INSERT INTO `log_active_state` VALUES (105, '', 0, 0, '', 1576627786);
INSERT INTO `log_active_state` VALUES (106, '', 0, 0, '', 1576628386);
INSERT INTO `log_active_state` VALUES (107, '', 0, 0, '', 1576628986);
INSERT INTO `log_active_state` VALUES (108, '', 0, 0, '', 1576629586);
INSERT INTO `log_active_state` VALUES (109, '', 0, 0, '', 1576630186);
INSERT INTO `log_active_state` VALUES (110, '', 0, 0, '', 1576630786);
INSERT INTO `log_active_state` VALUES (111, '', 0, 0, '', 1576631386);
INSERT INTO `log_active_state` VALUES (112, '', 0, 0, '', 1576631986);
INSERT INTO `log_active_state` VALUES (113, '', 0, 0, '', 1576632586);
INSERT INTO `log_active_state` VALUES (114, '', 0, 0, '', 1576633186);
INSERT INTO `log_active_state` VALUES (115, '', 0, 0, '', 1576633786);
INSERT INTO `log_active_state` VALUES (116, '', 0, 0, '', 1576634386);
INSERT INTO `log_active_state` VALUES (117, '', 0, 0, '', 1576634986);
INSERT INTO `log_active_state` VALUES (118, '', 0, 0, '', 1576635586);
INSERT INTO `log_active_state` VALUES (119, '', 0, 0, '', 1576636186);
INSERT INTO `log_active_state` VALUES (120, '', 0, 0, '', 1576636786);
INSERT INTO `log_active_state` VALUES (121, '', 0, 0, '', 1576637386);
INSERT INTO `log_active_state` VALUES (122, '', 0, 0, '', 1576637986);
INSERT INTO `log_active_state` VALUES (123, '', 0, 0, '', 1576638586);
INSERT INTO `log_active_state` VALUES (124, '', 0, 0, '', 1576639186);
INSERT INTO `log_active_state` VALUES (125, '', 0, 0, '', 1576639786);
INSERT INTO `log_active_state` VALUES (126, '', 0, 0, '', 1576640386);
INSERT INTO `log_active_state` VALUES (127, '', 0, 0, '', 1576640986);
INSERT INTO `log_active_state` VALUES (128, '', 0, 0, '', 1576641586);
INSERT INTO `log_active_state` VALUES (129, '', 0, 0, '', 1576642186);
INSERT INTO `log_active_state` VALUES (130, '', 0, 0, '', 1576642786);
INSERT INTO `log_active_state` VALUES (131, '', 0, 0, '', 1576643386);
INSERT INTO `log_active_state` VALUES (132, '', 0, 0, '', 1576643986);
INSERT INTO `log_active_state` VALUES (133, '', 0, 0, '', 1576644586);
INSERT INTO `log_active_state` VALUES (134, '', 0, 0, '', 1576645186);
INSERT INTO `log_active_state` VALUES (135, '', 0, 0, '', 1576645786);
INSERT INTO `log_active_state` VALUES (136, '', 0, 0, '', 1576646386);
INSERT INTO `log_active_state` VALUES (137, '', 0, 0, '', 1576646986);
INSERT INTO `log_active_state` VALUES (138, '', 0, 0, '', 1576647586);
INSERT INTO `log_active_state` VALUES (139, '', 0, 0, '', 1576648186);
INSERT INTO `log_active_state` VALUES (140, '', 0, 0, '', 1576648786);
INSERT INTO `log_active_state` VALUES (141, '', 0, 0, '', 1576649386);
INSERT INTO `log_active_state` VALUES (142, '', 0, 0, '', 1576649986);
INSERT INTO `log_active_state` VALUES (143, '', 0, 0, '', 1576650586);
INSERT INTO `log_active_state` VALUES (144, '', 0, 0, '', 1576651186);
INSERT INTO `log_active_state` VALUES (145, '', 0, 0, '', 1576651786);
INSERT INTO `log_active_state` VALUES (146, '', 0, 0, '', 1576652386);
INSERT INTO `log_active_state` VALUES (147, '', 0, 0, '', 1576652986);
INSERT INTO `log_active_state` VALUES (148, '', 0, 0, '', 1576653586);
INSERT INTO `log_active_state` VALUES (149, '', 0, 0, '', 1576654186);
INSERT INTO `log_active_state` VALUES (150, '', 0, 0, '', 1576654786);
INSERT INTO `log_active_state` VALUES (151, '', 0, 0, '', 1576655386);
INSERT INTO `log_active_state` VALUES (152, '', 0, 0, '', 1576655986);
INSERT INTO `log_active_state` VALUES (153, '', 0, 0, '', 1576656586);
INSERT INTO `log_active_state` VALUES (154, '', 0, 0, '', 1576657186);
INSERT INTO `log_active_state` VALUES (155, '', 0, 0, '', 1576657786);
INSERT INTO `log_active_state` VALUES (156, '', 0, 0, '', 1576658386);
INSERT INTO `log_active_state` VALUES (157, '', 0, 0, '', 1576658986);
INSERT INTO `log_active_state` VALUES (158, '', 0, 0, '', 1576659586);
INSERT INTO `log_active_state` VALUES (159, '', 0, 0, '', 1576660186);
INSERT INTO `log_active_state` VALUES (160, '', 0, 0, '', 1576660786);
INSERT INTO `log_active_state` VALUES (161, '', 0, 0, '', 1576661386);
INSERT INTO `log_active_state` VALUES (162, '', 0, 0, '', 1576661986);
INSERT INTO `log_active_state` VALUES (163, '', 0, 0, '', 1576662586);
INSERT INTO `log_active_state` VALUES (164, '', 0, 0, '', 1576663186);
INSERT INTO `log_active_state` VALUES (165, '', 0, 0, '', 1576663786);
INSERT INTO `log_active_state` VALUES (166, '', 0, 0, '', 1576664386);
INSERT INTO `log_active_state` VALUES (167, '', 0, 0, '', 1576664986);
INSERT INTO `log_active_state` VALUES (168, '', 0, 0, '', 1576665586);
INSERT INTO `log_active_state` VALUES (169, '', 0, 0, '', 1576666186);
INSERT INTO `log_active_state` VALUES (170, '', 0, 0, '', 1576666786);
INSERT INTO `log_active_state` VALUES (171, '', 0, 0, '', 1576667386);
INSERT INTO `log_active_state` VALUES (172, '', 0, 0, '', 1576667986);
INSERT INTO `log_active_state` VALUES (173, '', 0, 0, '', 1576668586);
INSERT INTO `log_active_state` VALUES (174, '', 0, 0, '', 1576669186);
INSERT INTO `log_active_state` VALUES (175, '', 0, 0, '', 1576669786);
INSERT INTO `log_active_state` VALUES (176, '', 0, 0, '', 1576670386);
INSERT INTO `log_active_state` VALUES (177, '', 0, 0, '', 1576670986);
INSERT INTO `log_active_state` VALUES (178, '', 0, 0, '', 1576671586);
INSERT INTO `log_active_state` VALUES (179, '', 0, 0, '', 1576672186);
INSERT INTO `log_active_state` VALUES (180, '', 0, 0, '', 1576672786);
INSERT INTO `log_active_state` VALUES (181, '', 0, 0, '', 1576673386);
INSERT INTO `log_active_state` VALUES (182, '', 0, 0, '', 1576673986);
INSERT INTO `log_active_state` VALUES (183, '', 0, 0, '', 1576674586);
INSERT INTO `log_active_state` VALUES (184, '', 0, 0, '', 1576675186);
INSERT INTO `log_active_state` VALUES (185, '', 0, 0, '', 1576675786);
INSERT INTO `log_active_state` VALUES (186, '', 0, 0, '', 1576676386);
INSERT INTO `log_active_state` VALUES (187, '', 0, 0, '', 1576676986);
INSERT INTO `log_active_state` VALUES (188, '', 0, 0, '', 1576677586);
INSERT INTO `log_active_state` VALUES (189, '', 0, 0, '', 1576678186);
INSERT INTO `log_active_state` VALUES (190, '', 0, 0, '', 1576678786);
INSERT INTO `log_active_state` VALUES (191, '', 0, 0, '', 1576679386);
INSERT INTO `log_active_state` VALUES (192, '', 0, 0, '', 1576679986);
INSERT INTO `log_active_state` VALUES (193, '', 0, 0, '', 1576680586);
INSERT INTO `log_active_state` VALUES (194, '', 0, 0, '', 1576681186);
INSERT INTO `log_active_state` VALUES (195, '', 0, 0, '', 1576681786);
INSERT INTO `log_active_state` VALUES (196, '', 0, 0, '', 1576682386);
INSERT INTO `log_active_state` VALUES (197, '', 0, 0, '', 1576682986);
INSERT INTO `log_active_state` VALUES (198, '', 0, 0, '', 1576683586);
INSERT INTO `log_active_state` VALUES (199, '', 0, 0, '', 1576684186);
INSERT INTO `log_active_state` VALUES (200, '', 0, 0, '', 1576684786);
INSERT INTO `log_active_state` VALUES (201, '', 0, 0, '', 1576685386);
INSERT INTO `log_active_state` VALUES (202, '', 0, 0, '', 1576685986);
INSERT INTO `log_active_state` VALUES (203, '', 0, 0, '', 1576686586);
INSERT INTO `log_active_state` VALUES (204, '', 0, 0, '', 1576687186);
INSERT INTO `log_active_state` VALUES (205, '', 0, 0, '', 1576687786);
INSERT INTO `log_active_state` VALUES (206, '', 0, 0, '', 1576688386);
INSERT INTO `log_active_state` VALUES (207, '', 0, 0, '', 1576688986);
INSERT INTO `log_active_state` VALUES (208, '', 0, 0, '', 1576689586);
INSERT INTO `log_active_state` VALUES (209, '', 0, 0, '', 1576690186);
INSERT INTO `log_active_state` VALUES (210, '', 0, 0, '', 1576690786);
INSERT INTO `log_active_state` VALUES (211, '', 0, 0, '', 1576691386);
INSERT INTO `log_active_state` VALUES (212, '', 0, 0, '', 1576691986);
INSERT INTO `log_active_state` VALUES (213, '', 0, 0, '', 1576692586);
INSERT INTO `log_active_state` VALUES (214, '', 0, 0, '', 1576693186);
INSERT INTO `log_active_state` VALUES (215, '', 0, 0, '', 1576693786);
INSERT INTO `log_active_state` VALUES (216, '', 0, 0, '', 1576694386);
INSERT INTO `log_active_state` VALUES (217, '', 0, 0, '', 1576694986);
INSERT INTO `log_active_state` VALUES (218, '', 0, 0, '', 1576695586);
INSERT INTO `log_active_state` VALUES (219, '', 0, 0, '', 1576696186);
INSERT INTO `log_active_state` VALUES (220, '', 0, 0, '', 1576696786);
INSERT INTO `log_active_state` VALUES (221, '', 0, 0, '', 1576697386);
INSERT INTO `log_active_state` VALUES (222, '', 0, 0, '', 1576697986);
INSERT INTO `log_active_state` VALUES (223, '', 0, 0, '', 1576698586);
INSERT INTO `log_active_state` VALUES (224, '', 0, 0, '', 1576699186);
INSERT INTO `log_active_state` VALUES (225, '', 0, 0, '', 1576699786);
INSERT INTO `log_active_state` VALUES (226, '', 0, 0, '', 1576700386);
INSERT INTO `log_active_state` VALUES (227, '', 0, 0, '', 1576700986);
INSERT INTO `log_active_state` VALUES (228, '', 0, 0, '', 1576701586);
INSERT INTO `log_active_state` VALUES (229, '', 0, 0, '', 1576702186);
INSERT INTO `log_active_state` VALUES (230, '', 0, 0, '', 1576702786);
INSERT INTO `log_active_state` VALUES (231, '', 0, 0, '', 1576703386);
INSERT INTO `log_active_state` VALUES (232, '', 0, 0, '', 1576703986);
INSERT INTO `log_active_state` VALUES (233, '', 0, 0, '', 1576704586);
INSERT INTO `log_active_state` VALUES (234, '', 0, 0, '', 1576705186);
INSERT INTO `log_active_state` VALUES (235, '', 0, 0, '', 1576705786);
INSERT INTO `log_active_state` VALUES (236, '', 0, 0, '', 1576706386);
INSERT INTO `log_active_state` VALUES (237, '', 0, 0, '', 1576706986);
INSERT INTO `log_active_state` VALUES (238, '', 0, 0, '', 1576707586);
INSERT INTO `log_active_state` VALUES (239, '', 0, 0, '', 1576708186);
INSERT INTO `log_active_state` VALUES (240, '', 0, 0, '', 1576708786);
INSERT INTO `log_active_state` VALUES (241, '', 0, 0, '', 1576709386);
INSERT INTO `log_active_state` VALUES (242, '', 0, 0, '', 1576709986);
INSERT INTO `log_active_state` VALUES (243, '', 0, 0, '', 1576710586);
INSERT INTO `log_active_state` VALUES (244, '', 0, 0, '', 1576711186);
INSERT INTO `log_active_state` VALUES (245, '', 0, 0, '', 1576711786);
INSERT INTO `log_active_state` VALUES (246, '', 0, 0, '', 1576712386);
INSERT INTO `log_active_state` VALUES (247, '', 0, 0, '', 1576712986);
INSERT INTO `log_active_state` VALUES (248, '', 0, 0, '', 1576713586);
INSERT INTO `log_active_state` VALUES (249, '', 0, 0, '', 1576714186);
INSERT INTO `log_active_state` VALUES (250, '', 0, 0, '', 1576714786);
INSERT INTO `log_active_state` VALUES (251, '', 0, 0, '', 1576715386);
INSERT INTO `log_active_state` VALUES (252, '', 0, 0, '', 1576715986);
INSERT INTO `log_active_state` VALUES (253, '', 0, 0, '', 1576716586);
INSERT INTO `log_active_state` VALUES (254, '', 0, 0, '', 1576717186);
INSERT INTO `log_active_state` VALUES (255, '', 0, 0, '', 1576717786);
INSERT INTO `log_active_state` VALUES (256, '', 0, 0, '', 1576718386);
INSERT INTO `log_active_state` VALUES (257, '', 0, 0, '', 1576718986);
INSERT INTO `log_active_state` VALUES (258, '', 0, 0, '', 1576719586);
INSERT INTO `log_active_state` VALUES (259, '', 0, 0, '', 1576720186);
INSERT INTO `log_active_state` VALUES (260, '', 0, 0, '', 1576720786);
INSERT INTO `log_active_state` VALUES (261, '', 0, 0, '', 1576721386);
INSERT INTO `log_active_state` VALUES (262, '', 0, 0, '', 1576721986);
INSERT INTO `log_active_state` VALUES (263, '', 0, 0, '', 1576722586);
INSERT INTO `log_active_state` VALUES (264, '', 0, 0, '', 1576723186);
INSERT INTO `log_active_state` VALUES (265, '', 0, 0, '', 1576723786);
INSERT INTO `log_active_state` VALUES (266, '', 0, 0, '', 1576724386);
INSERT INTO `log_active_state` VALUES (267, '', 0, 0, '', 1576724986);
INSERT INTO `log_active_state` VALUES (268, '', 0, 0, '', 1576725586);
INSERT INTO `log_active_state` VALUES (269, '', 0, 0, '', 1576726186);
INSERT INTO `log_active_state` VALUES (270, '', 0, 0, '', 1576726786);
INSERT INTO `log_active_state` VALUES (271, '', 0, 0, '', 1576727386);
INSERT INTO `log_active_state` VALUES (272, '', 0, 0, '', 1576727986);
INSERT INTO `log_active_state` VALUES (273, '', 0, 0, '', 1576728586);
INSERT INTO `log_active_state` VALUES (274, '', 0, 0, '', 1576729186);
INSERT INTO `log_active_state` VALUES (275, '', 0, 0, '', 1576729786);
INSERT INTO `log_active_state` VALUES (276, '', 0, 0, '', 1576730386);
INSERT INTO `log_active_state` VALUES (277, '', 0, 0, '', 1576730986);
INSERT INTO `log_active_state` VALUES (278, '', 0, 0, '', 1576731586);
INSERT INTO `log_active_state` VALUES (279, '', 0, 0, '', 1576732186);
INSERT INTO `log_active_state` VALUES (280, '', 0, 0, '', 1576732786);
INSERT INTO `log_active_state` VALUES (281, '', 0, 0, '', 1576733386);
INSERT INTO `log_active_state` VALUES (282, '', 0, 0, '', 1576733986);
INSERT INTO `log_active_state` VALUES (283, '', 0, 0, '', 1576734586);
INSERT INTO `log_active_state` VALUES (284, 'BJ_001', 0, 0, '', 1576735186);
INSERT INTO `log_active_state` VALUES (285, 'BJ_001', 1, 1, '10001', 1576735786);
INSERT INTO `log_active_state` VALUES (286, 'BJ_001', 1, 1, '10001', 1576736386);
INSERT INTO `log_active_state` VALUES (287, 'BJ_001', 1, 1, '10001', 1576737162);
INSERT INTO `log_active_state` VALUES (288, 'BJ_001', 1, 1, '10001', 1576737762);
INSERT INTO `log_active_state` VALUES (289, 'BJ_001', 1, 1, '10001', 1576738362);
INSERT INTO `log_active_state` VALUES (290, 'BJ_001', 1, 1, '10001', 1576738962);
INSERT INTO `log_active_state` VALUES (291, 'BJ_001', 1, 1, '10001', 1576739562);
INSERT INTO `log_active_state` VALUES (292, 'BJ_001', 1, 1, '10001', 1576740162);
INSERT INTO `log_active_state` VALUES (293, 'BJ_001', 1, 1, '10001', 1576741262);
INSERT INTO `log_active_state` VALUES (294, 'BJ_001', 1, 1, '10001', 1576741862);
INSERT INTO `log_active_state` VALUES (295, 'BJ_001', 1, 1, '10001', 1576742462);
INSERT INTO `log_active_state` VALUES (296, 'BJ_001', 1, 1, '10001', 1576743062);
INSERT INTO `log_active_state` VALUES (297, 'BJ_001', 1, 1, '10001', 1576743662);
INSERT INTO `log_active_state` VALUES (298, 'BJ_001', 1, 1, '10001', 1576744262);
INSERT INTO `log_active_state` VALUES (299, 'BJ_001', 1, 1, '10001', 1576744862);
INSERT INTO `log_active_state` VALUES (300, 'BJ_001', 1, 1, '10001', 1576745462);
INSERT INTO `log_active_state` VALUES (301, 'BJ_001', 1, 1, '10001', 1576746062);
INSERT INTO `log_active_state` VALUES (302, 'BJ_001', 1, 1, '10001', 1576746662);
INSERT INTO `log_active_state` VALUES (303, 'BJ_001', 1, 1, '10001', 1576747262);
INSERT INTO `log_active_state` VALUES (304, 'BJ_001', 1, 1, '10001', 1576747862);
INSERT INTO `log_active_state` VALUES (305, 'BJ_001', 1, 1, '10001', 1576748462);
INSERT INTO `log_active_state` VALUES (306, 'BJ_001', 2, 2, '10001,10000', 1576749062);
INSERT INTO `log_active_state` VALUES (307, 'BJ_001', 2, 2, '10001,10000', 1576749662);
INSERT INTO `log_active_state` VALUES (308, 'BJ_001', 2, 2, '10001,10000', 1576750262);
INSERT INTO `log_active_state` VALUES (309, 'BJ_001', 2, 2, '10001,10000', 1576750862);
INSERT INTO `log_active_state` VALUES (310, 'BJ_001', 2, 2, '10001,10000', 1576751462);
INSERT INTO `log_active_state` VALUES (311, 'BJ_001', 2, 2, '10001,10000', 1576752062);
INSERT INTO `log_active_state` VALUES (312, 'BJ_001', 2, 2, '10001,10000', 1576752662);
INSERT INTO `log_active_state` VALUES (313, 'BJ_001', 2, 2, '10001,10000', 1576753262);
INSERT INTO `log_active_state` VALUES (314, 'BJ_001', 2, 2, '10001,10000', 1576753862);
INSERT INTO `log_active_state` VALUES (315, 'BJ_001', 2, 2, '10001,10000', 1576754462);
INSERT INTO `log_active_state` VALUES (316, 'BJ_001', 2, 2, '10001,10000', 1576755062);
INSERT INTO `log_active_state` VALUES (317, 'BJ_001', 2, 2, '10001,10000', 1576755662);
INSERT INTO `log_active_state` VALUES (318, 'BJ_001', 2, 2, '10001,10000', 1576756262);
INSERT INTO `log_active_state` VALUES (319, 'BJ_001', 2, 2, '10001,10000', 1576756862);
INSERT INTO `log_active_state` VALUES (320, 'BJ_001', 2, 2, '10001,10000', 1576757462);
INSERT INTO `log_active_state` VALUES (321, 'BJ_001', 2, 2, '10001,10000', 1576758062);
INSERT INTO `log_active_state` VALUES (322, 'BJ_001', 2, 2, '10001,10000', 1576758662);
INSERT INTO `log_active_state` VALUES (323, 'BJ_001', 2, 2, '10001,10000', 1576759262);
INSERT INTO `log_active_state` VALUES (324, 'BJ_001', 2, 2, '10001,10000', 1576759862);
INSERT INTO `log_active_state` VALUES (325, 'BJ_001', 2, 2, '10001,10000', 1576760462);
INSERT INTO `log_active_state` VALUES (326, 'BJ_001', 2, 2, '10001,10000', 1576761062);
INSERT INTO `log_active_state` VALUES (327, 'BJ_001', 2, 2, '10001,10000', 1576761662);
INSERT INTO `log_active_state` VALUES (328, 'BJ_001', 2, 2, '10001,10000', 1576762262);
INSERT INTO `log_active_state` VALUES (329, 'BJ_001', 2, 2, '10001,10000', 1576762862);
INSERT INTO `log_active_state` VALUES (330, 'BJ_001', 2, 2, '10001,10000', 1576763462);
INSERT INTO `log_active_state` VALUES (331, 'BJ_001', 2, 2, '10001,10000', 1576764062);
INSERT INTO `log_active_state` VALUES (332, 'BJ_001', 2, 2, '10001,10000', 1576764662);
INSERT INTO `log_active_state` VALUES (333, 'BJ_001', 2, 2, '10001,10000', 1576765262);
INSERT INTO `log_active_state` VALUES (334, 'BJ_001', 2, 2, '10001,10000', 1576765862);
INSERT INTO `log_active_state` VALUES (335, 'BJ_001', 2, 2, '10001,10000', 1576766462);
INSERT INTO `log_active_state` VALUES (336, 'BJ_001', 2, 2, '10001,10000', 1576767062);
INSERT INTO `log_active_state` VALUES (337, 'BJ_001', 2, 2, '10001,10000', 1576767662);
INSERT INTO `log_active_state` VALUES (338, 'BJ_001', 2, 2, '10001,10000', 1576768262);
INSERT INTO `log_active_state` VALUES (339, 'BJ_001', 2, 2, '10001,10000', 1576768862);
INSERT INTO `log_active_state` VALUES (340, 'BJ_001', 2, 2, '10001,10000', 1576769462);
INSERT INTO `log_active_state` VALUES (341, 'BJ_001', 2, 2, '10001,10000', 1576770063);
INSERT INTO `log_active_state` VALUES (342, 'BJ_001', 2, 2, '10001,10000', 1576770662);
INSERT INTO `log_active_state` VALUES (343, 'BJ_001', 2, 2, '10001,10000', 1576771262);
INSERT INTO `log_active_state` VALUES (344, 'BJ_001', 2, 2, '10001,10000', 1576771862);
INSERT INTO `log_active_state` VALUES (345, 'BJ_001', 2, 2, '10001,10000', 1576772462);
INSERT INTO `log_active_state` VALUES (346, 'BJ_001', 2, 2, '10001,10000', 1576773062);
INSERT INTO `log_active_state` VALUES (347, 'BJ_001', 2, 2, '10001,10000', 1576773662);
INSERT INTO `log_active_state` VALUES (348, 'BJ_001', 2, 2, '10001,10000', 1576774262);
INSERT INTO `log_active_state` VALUES (349, 'BJ_001', 2, 2, '10001,10000', 1576774862);
INSERT INTO `log_active_state` VALUES (350, 'BJ_001', 2, 2, '10001,10000', 1576775462);
INSERT INTO `log_active_state` VALUES (351, 'BJ_001', 2, 2, '10001,10000', 1576776062);
INSERT INTO `log_active_state` VALUES (352, 'BJ_001', 2, 2, '10001,10000', 1576776662);
INSERT INTO `log_active_state` VALUES (353, 'BJ_001', 2, 2, '10001,10000', 1576777262);
INSERT INTO `log_active_state` VALUES (354, 'BJ_001', 2, 2, '10001,10000', 1576777862);
INSERT INTO `log_active_state` VALUES (355, 'BJ_001', 2, 2, '10001,10000', 1576778462);
INSERT INTO `log_active_state` VALUES (356, 'BJ_001', 2, 2, '10001,10000', 1576779062);
INSERT INTO `log_active_state` VALUES (357, 'BJ_001', 2, 2, '10001,10000', 1576779662);
INSERT INTO `log_active_state` VALUES (358, 'BJ_001', 2, 2, '10001,10000', 1576780262);
INSERT INTO `log_active_state` VALUES (359, 'BJ_001', 2, 2, '10001,10000', 1576780862);
INSERT INTO `log_active_state` VALUES (360, 'BJ_001', 2, 2, '10001,10000', 1576781462);
INSERT INTO `log_active_state` VALUES (361, 'BJ_001', 2, 2, '10001,10000', 1576782062);
INSERT INTO `log_active_state` VALUES (362, 'BJ_001', 2, 2, '10001,10000', 1576782662);
INSERT INTO `log_active_state` VALUES (363, 'BJ_001', 2, 2, '10001,10000', 1576783262);
INSERT INTO `log_active_state` VALUES (364, 'BJ_001', 2, 2, '10001,10000', 1576783862);
INSERT INTO `log_active_state` VALUES (365, 'BJ_001', 2, 2, '10001,10000', 1576784462);
INSERT INTO `log_active_state` VALUES (366, 'BJ_001', 2, 2, '10001,10000', 1576785062);
INSERT INTO `log_active_state` VALUES (367, 'BJ_001', 2, 2, '10001,10000', 1576785662);
INSERT INTO `log_active_state` VALUES (368, 'BJ_001', 2, 2, '10001,10000', 1576786262);
INSERT INTO `log_active_state` VALUES (369, 'BJ_001', 2, 2, '10001,10000', 1576786862);
INSERT INTO `log_active_state` VALUES (370, 'BJ_001', 2, 2, '10001,10000', 1576787462);
INSERT INTO `log_active_state` VALUES (371, 'BJ_001', 2, 2, '10001,10000', 1576788062);
INSERT INTO `log_active_state` VALUES (372, 'BJ_001', 2, 2, '10001,10000', 1576788662);
INSERT INTO `log_active_state` VALUES (373, 'BJ_001', 2, 2, '10001,10000', 1576789262);
INSERT INTO `log_active_state` VALUES (374, 'BJ_001', 2, 2, '10001,10000', 1576789862);
INSERT INTO `log_active_state` VALUES (375, 'BJ_001', 2, 2, '10001,10000', 1576790462);
INSERT INTO `log_active_state` VALUES (376, 'BJ_001', 2, 2, '10001,10000', 1576791062);
INSERT INTO `log_active_state` VALUES (377, 'BJ_001', 2, 2, '10001,10000', 1576791662);
INSERT INTO `log_active_state` VALUES (378, 'BJ_001', 2, 2, '10001,10000', 1576792262);
INSERT INTO `log_active_state` VALUES (379, 'BJ_001', 2, 2, '10001,10000', 1576792862);
INSERT INTO `log_active_state` VALUES (380, 'BJ_001', 2, 2, '10001,10000', 1576793462);
INSERT INTO `log_active_state` VALUES (381, 'BJ_001', 2, 2, '10001,10000', 1576794062);
INSERT INTO `log_active_state` VALUES (382, 'BJ_001', 2, 2, '10001,10000', 1576794662);
INSERT INTO `log_active_state` VALUES (383, 'BJ_001', 2, 2, '10001,10000', 1576795262);
INSERT INTO `log_active_state` VALUES (384, 'BJ_001', 2, 2, '10001,10000', 1576795862);
INSERT INTO `log_active_state` VALUES (385, 'BJ_001', 2, 2, '10001,10000', 1576796462);
INSERT INTO `log_active_state` VALUES (386, 'BJ_001', 2, 2, '10001,10000', 1576797062);
INSERT INTO `log_active_state` VALUES (387, 'BJ_001', 2, 2, '10001,10000', 1576797662);
INSERT INTO `log_active_state` VALUES (388, 'BJ_001', 2, 2, '10001,10000', 1576798262);
INSERT INTO `log_active_state` VALUES (389, 'BJ_001', 2, 2, '10001,10000', 1576798862);
INSERT INTO `log_active_state` VALUES (390, 'BJ_001', 2, 2, '10001,10000', 1576799462);
INSERT INTO `log_active_state` VALUES (391, 'BJ_001', 2, 2, '10001,10000', 1576800062);
INSERT INTO `log_active_state` VALUES (392, 'BJ_001', 2, 2, '10001,10000', 1576800662);
INSERT INTO `log_active_state` VALUES (393, 'BJ_001', 2, 2, '10001,10000', 1576801262);
INSERT INTO `log_active_state` VALUES (394, 'BJ_001', 2, 2, '10001,10000', 1576801862);
INSERT INTO `log_active_state` VALUES (395, 'BJ_001', 2, 2, '10001,10000', 1576802462);
INSERT INTO `log_active_state` VALUES (396, 'BJ_001', 2, 2, '10001,10000', 1576803062);
INSERT INTO `log_active_state` VALUES (397, 'BJ_001', 2, 2, '10001,10000', 1576803662);
INSERT INTO `log_active_state` VALUES (398, 'BJ_001', 2, 2, '10001,10000', 1576804262);
INSERT INTO `log_active_state` VALUES (399, 'BJ_001', 2, 2, '10001,10000', 1576804862);
INSERT INTO `log_active_state` VALUES (400, 'BJ_001', 2, 2, '10001,10000', 1576805462);
INSERT INTO `log_active_state` VALUES (401, 'BJ_001', 2, 2, '10001,10000', 1576806062);
INSERT INTO `log_active_state` VALUES (402, 'BJ_001', 2, 2, '10001,10000', 1576806662);
INSERT INTO `log_active_state` VALUES (403, 'BJ_001', 2, 2, '10001,10000', 1576807777);
INSERT INTO `log_active_state` VALUES (404, 'BJ_001', 2, 2, '10001,10000', 1576808377);
INSERT INTO `log_active_state` VALUES (405, 'BJ_001', 2, 2, '10001,10000', 1576808977);
INSERT INTO `log_active_state` VALUES (406, 'BJ_001', 2, 2, '10001,10000', 1576809577);
INSERT INTO `log_active_state` VALUES (407, 'BJ_001', 2, 2, '10001,10000', 1576811113);
INSERT INTO `log_active_state` VALUES (408, 'BJ_001', 2, 2, '10001,10000', 1576811713);
INSERT INTO `log_active_state` VALUES (409, 'BJ_001', 2, 2, '10001,10000', 1576812313);
INSERT INTO `log_active_state` VALUES (410, 'BJ_001', 2, 2, '10001,10000', 1576812913);
INSERT INTO `log_active_state` VALUES (411, 'BJ_001', 2, 2, '10001,10000', 1576813513);
INSERT INTO `log_active_state` VALUES (412, 'BJ_001', 2, 2, '10001,10000', 1576814113);
INSERT INTO `log_active_state` VALUES (413, 'BJ_001', 2, 2, '10001,10000', 1576814713);
INSERT INTO `log_active_state` VALUES (414, 'BJ_001', 2, 2, '10001,10000', 1576815313);
INSERT INTO `log_active_state` VALUES (415, 'BJ_001', 2, 2, '10001,10000', 1576815913);
INSERT INTO `log_active_state` VALUES (416, 'BJ_001', 2, 2, '10001,10000', 1576820653);
INSERT INTO `log_active_state` VALUES (417, 'BJ_001', 2, 2, '10001,10000', 1576821253);
INSERT INTO `log_active_state` VALUES (418, 'BJ_001', 2, 2, '10001,10000', 1576821853);
INSERT INTO `log_active_state` VALUES (419, 'BJ_001', 2, 2, '10001,10000', 1576822453);
INSERT INTO `log_active_state` VALUES (420, 'BJ_001', 2, 2, '10001,10000', 1576823053);
INSERT INTO `log_active_state` VALUES (421, 'BJ_001', 2, 2, '10001,10000', 1576823653);
INSERT INTO `log_active_state` VALUES (422, 'BJ_001', 2, 2, '10001,10000', 1576824253);
INSERT INTO `log_active_state` VALUES (423, 'BJ_001', 2, 2, '10001,10000', 1576824853);
INSERT INTO `log_active_state` VALUES (424, 'BJ_001', 2, 2, '10001,10000', 1576825453);
INSERT INTO `log_active_state` VALUES (425, 'BJ_001', 2, 2, '10001,10000', 1576826053);
INSERT INTO `log_active_state` VALUES (426, 'BJ_001', 2, 2, '10001,10000', 1576826653);
INSERT INTO `log_active_state` VALUES (427, 'BJ_001', 2, 2, '10001,10000', 1576827253);
INSERT INTO `log_active_state` VALUES (428, 'BJ_001', 2, 2, '10001,10000', 1576827853);
INSERT INTO `log_active_state` VALUES (429, 'BJ_001', 2, 2, '10001,10000', 1576828453);
INSERT INTO `log_active_state` VALUES (430, 'BJ_001', 2, 2, '10001,10000', 1576829053);
INSERT INTO `log_active_state` VALUES (431, 'BJ_001', 2, 2, '10001,10000', 1576829653);
INSERT INTO `log_active_state` VALUES (432, 'BJ_001', 2, 2, '10001,10000', 1576830253);
INSERT INTO `log_active_state` VALUES (433, 'BJ_001', 2, 2, '10001,10000', 1576830853);
INSERT INTO `log_active_state` VALUES (434, 'BJ_001', 2, 2, '10001,10000', 1576831453);
INSERT INTO `log_active_state` VALUES (435, 'BJ_001', 2, 2, '10001,10000', 1576832053);
INSERT INTO `log_active_state` VALUES (436, 'BJ_001', 2, 2, '10001,10000', 1576832653);
INSERT INTO `log_active_state` VALUES (437, 'BJ_001', 2, 2, '10001,10000', 1576833253);
INSERT INTO `log_active_state` VALUES (438, 'BJ_001', 2, 2, '10001,10000', 1576833853);
INSERT INTO `log_active_state` VALUES (439, 'BJ_001', 2, 2, '10001,10000', 1576834453);
INSERT INTO `log_active_state` VALUES (440, 'BJ_001', 2, 2, '10001,10000', 1576835053);
INSERT INTO `log_active_state` VALUES (441, 'BJ_001', 2, 2, '10001,10000', 1576835653);
INSERT INTO `log_active_state` VALUES (442, 'BJ_001', 2, 2, '10001,10000', 1576836253);
INSERT INTO `log_active_state` VALUES (443, 'BJ_001', 2, 2, '10001,10000', 1576836853);
INSERT INTO `log_active_state` VALUES (444, 'BJ_001', 2, 2, '10001,10000', 1576837453);
INSERT INTO `log_active_state` VALUES (445, 'BJ_001', 2, 2, '10001,10000', 1576838053);
INSERT INTO `log_active_state` VALUES (446, 'BJ_001', 2, 2, '10001,10000', 1576838653);
INSERT INTO `log_active_state` VALUES (447, 'BJ_001', 2, 2, '10001,10000', 1576839253);
INSERT INTO `log_active_state` VALUES (448, 'BJ_001', 2, 2, '10001,10000', 1576839853);
INSERT INTO `log_active_state` VALUES (449, 'BJ_001', 2, 2, '10001,10000', 1576840453);
INSERT INTO `log_active_state` VALUES (450, 'BJ_001', 2, 2, '10001,10000', 1576841053);
INSERT INTO `log_active_state` VALUES (451, 'BJ_001', 2, 2, '10001,10000', 1576841653);
INSERT INTO `log_active_state` VALUES (452, 'BJ_001', 2, 2, '10001,10000', 1576842253);
INSERT INTO `log_active_state` VALUES (453, 'BJ_001', 2, 2, '10001,10000', 1576842853);
INSERT INTO `log_active_state` VALUES (454, 'BJ_001', 2, 2, '10001,10000', 1576843453);
INSERT INTO `log_active_state` VALUES (455, 'BJ_001', 2, 2, '10001,10000', 1576844053);
INSERT INTO `log_active_state` VALUES (456, 'BJ_001', 2, 2, '10001,10000', 1576844653);
INSERT INTO `log_active_state` VALUES (457, 'BJ_001', 2, 2, '10001,10000', 1576845253);
INSERT INTO `log_active_state` VALUES (458, 'BJ_001', 2, 2, '10001,10000', 1576845853);
INSERT INTO `log_active_state` VALUES (459, 'BJ_001', 2, 2, '10001,10000', 1576846453);
INSERT INTO `log_active_state` VALUES (460, 'BJ_001', 2, 2, '10001,10000', 1576847053);
INSERT INTO `log_active_state` VALUES (461, 'BJ_001', 2, 2, '10001,10000', 1576847653);
INSERT INTO `log_active_state` VALUES (462, 'BJ_001', 2, 2, '10001,10000', 1576848253);
INSERT INTO `log_active_state` VALUES (463, 'BJ_001', 2, 2, '10001,10000', 1576848853);
INSERT INTO `log_active_state` VALUES (464, 'BJ_001', 2, 2, '10001,10000', 1576849453);
INSERT INTO `log_active_state` VALUES (465, 'BJ_001', 2, 2, '10001,10000', 1576850053);
INSERT INTO `log_active_state` VALUES (466, 'BJ_001', 2, 2, '10001,10000', 1576850653);
INSERT INTO `log_active_state` VALUES (467, 'BJ_001', 2, 2, '10001,10000', 1576851253);
INSERT INTO `log_active_state` VALUES (468, 'BJ_001', 2, 2, '10001,10000', 1576851853);
INSERT INTO `log_active_state` VALUES (469, 'BJ_001', 2, 2, '10001,10000', 1576852453);
INSERT INTO `log_active_state` VALUES (470, 'BJ_001', 2, 2, '10001,10000', 1576853053);
INSERT INTO `log_active_state` VALUES (471, 'BJ_001', 2, 2, '10001,10000', 1576853653);
INSERT INTO `log_active_state` VALUES (472, 'BJ_001', 2, 2, '10001,10000', 1576854253);
INSERT INTO `log_active_state` VALUES (473, 'BJ_001', 2, 2, '10001,10000', 1576854853);
INSERT INTO `log_active_state` VALUES (474, 'BJ_001', 2, 2, '10001,10000', 1576855453);
INSERT INTO `log_active_state` VALUES (475, 'BJ_001', 2, 2, '10001,10000', 1576856053);
INSERT INTO `log_active_state` VALUES (476, 'BJ_001', 2, 2, '10001,10000', 1576856653);
INSERT INTO `log_active_state` VALUES (477, 'BJ_001', 2, 2, '10001,10000', 1576857253);
INSERT INTO `log_active_state` VALUES (478, 'BJ_001', 2, 2, '10001,10000', 1576857853);
INSERT INTO `log_active_state` VALUES (479, 'BJ_001', 2, 2, '10001,10000', 1576858453);
INSERT INTO `log_active_state` VALUES (480, 'BJ_001', 2, 2, '10001,10000', 1576859053);
INSERT INTO `log_active_state` VALUES (481, 'BJ_001', 2, 2, '10001,10000', 1576859653);
INSERT INTO `log_active_state` VALUES (482, 'BJ_001', 2, 2, '10001,10000', 1576860253);
INSERT INTO `log_active_state` VALUES (483, 'BJ_001', 2, 2, '10001,10000', 1576860853);
INSERT INTO `log_active_state` VALUES (484, 'BJ_001', 2, 2, '10001,10000', 1576861453);
INSERT INTO `log_active_state` VALUES (485, 'BJ_001', 2, 2, '10001,10000', 1576862053);
INSERT INTO `log_active_state` VALUES (486, 'BJ_001', 2, 2, '10001,10000', 1576862653);
INSERT INTO `log_active_state` VALUES (487, 'BJ_001', 2, 2, '10001,10000', 1576863253);
INSERT INTO `log_active_state` VALUES (488, 'BJ_001', 2, 2, '10001,10000', 1576863853);
INSERT INTO `log_active_state` VALUES (489, 'BJ_001', 2, 2, '10001,10000', 1576864453);
INSERT INTO `log_active_state` VALUES (490, 'BJ_001', 2, 2, '10001,10000', 1576865053);
INSERT INTO `log_active_state` VALUES (491, 'BJ_001', 2, 2, '10001,10000', 1576865653);
INSERT INTO `log_active_state` VALUES (492, 'BJ_001', 2, 2, '10001,10000', 1576866253);
INSERT INTO `log_active_state` VALUES (493, 'BJ_001', 2, 2, '10001,10000', 1576866853);
INSERT INTO `log_active_state` VALUES (494, 'BJ_001', 2, 2, '10001,10000', 1576867453);
INSERT INTO `log_active_state` VALUES (495, 'BJ_001', 2, 2, '10001,10000', 1576868053);
INSERT INTO `log_active_state` VALUES (496, 'BJ_001', 2, 2, '10001,10000', 1576868653);
INSERT INTO `log_active_state` VALUES (497, 'BJ_001', 2, 2, '10001,10000', 1576869253);
INSERT INTO `log_active_state` VALUES (498, 'BJ_001', 2, 2, '10001,10000', 1576869853);
INSERT INTO `log_active_state` VALUES (499, 'BJ_001', 2, 2, '10001,10000', 1576870453);
INSERT INTO `log_active_state` VALUES (500, 'BJ_001', 2, 2, '10001,10000', 1576871053);
INSERT INTO `log_active_state` VALUES (501, 'BJ_001', 2, 2, '10001,10000', 1576871653);
INSERT INTO `log_active_state` VALUES (502, 'BJ_001', 2, 2, '10001,10000', 1576872253);
INSERT INTO `log_active_state` VALUES (503, 'BJ_001', 2, 2, '10001,10000', 1576872853);
INSERT INTO `log_active_state` VALUES (504, 'BJ_001', 2, 2, '10001,10000', 1576873453);
INSERT INTO `log_active_state` VALUES (505, 'BJ_001', 2, 2, '10001,10000', 1576874053);
INSERT INTO `log_active_state` VALUES (506, 'BJ_001', 2, 2, '10001,10000', 1576874653);
INSERT INTO `log_active_state` VALUES (507, 'BJ_001', 2, 2, '10001,10000', 1576875253);
INSERT INTO `log_active_state` VALUES (508, 'BJ_001', 2, 2, '10001,10000', 1576875853);
INSERT INTO `log_active_state` VALUES (509, 'BJ_001', 2, 2, '10001,10000', 1576876453);
INSERT INTO `log_active_state` VALUES (510, 'BJ_001', 2, 2, '10001,10000', 1576877053);
INSERT INTO `log_active_state` VALUES (511, 'BJ_001', 2, 2, '10001,10000', 1576877653);
INSERT INTO `log_active_state` VALUES (512, 'BJ_001', 2, 2, '10001,10000', 1576878253);
INSERT INTO `log_active_state` VALUES (513, 'BJ_001', 2, 2, '10001,10000', 1576878853);
INSERT INTO `log_active_state` VALUES (514, 'BJ_001', 2, 2, '10001,10000', 1576879453);
INSERT INTO `log_active_state` VALUES (515, 'BJ_001', 2, 2, '10001,10000', 1576880053);
INSERT INTO `log_active_state` VALUES (516, 'BJ_001', 2, 2, '10001,10000', 1576880653);
INSERT INTO `log_active_state` VALUES (517, 'BJ_001', 2, 2, '10001,10000', 1576881253);
INSERT INTO `log_active_state` VALUES (518, 'BJ_001', 2, 2, '10001,10000', 1576881853);
INSERT INTO `log_active_state` VALUES (519, 'BJ_001', 2, 2, '10001,10000', 1576882453);
INSERT INTO `log_active_state` VALUES (520, 'BJ_001', 2, 2, '10001,10000', 1576883053);
INSERT INTO `log_active_state` VALUES (521, 'BJ_001', 2, 2, '10001,10000', 1576883653);
INSERT INTO `log_active_state` VALUES (522, 'BJ_001', 2, 2, '10001,10000', 1576884253);
INSERT INTO `log_active_state` VALUES (523, 'BJ_001', 2, 2, '10001,10000', 1576884853);
INSERT INTO `log_active_state` VALUES (524, 'BJ_001', 2, 2, '10001,10000', 1576885453);
INSERT INTO `log_active_state` VALUES (525, 'BJ_001', 2, 2, '10001,10000', 1576886053);
INSERT INTO `log_active_state` VALUES (526, 'BJ_001', 2, 2, '10001,10000', 1576886653);
INSERT INTO `log_active_state` VALUES (527, 'BJ_001', 2, 2, '10001,10000', 1576887253);
INSERT INTO `log_active_state` VALUES (528, 'BJ_001', 2, 2, '10001,10000', 1576887853);
INSERT INTO `log_active_state` VALUES (529, 'BJ_001', 2, 2, '10001,10000', 1576888453);
INSERT INTO `log_active_state` VALUES (530, 'BJ_001', 2, 2, '10001,10000', 1576889053);
INSERT INTO `log_active_state` VALUES (531, 'BJ_001', 2, 2, '10001,10000', 1576889653);
INSERT INTO `log_active_state` VALUES (532, 'BJ_001', 2, 2, '10001,10000', 1576890253);
INSERT INTO `log_active_state` VALUES (533, 'BJ_001', 2, 2, '10001,10000', 1576890853);
INSERT INTO `log_active_state` VALUES (534, 'BJ_001', 2, 2, '10001,10000', 1576891453);
INSERT INTO `log_active_state` VALUES (535, 'BJ_001', 2, 2, '10001,10000', 1576892053);
INSERT INTO `log_active_state` VALUES (536, 'BJ_001', 2, 2, '10001,10000', 1576892653);
INSERT INTO `log_active_state` VALUES (537, 'BJ_001', 2, 2, '10001,10000', 1576893253);
INSERT INTO `log_active_state` VALUES (538, 'BJ_001', 2, 2, '10001,10000', 1576893853);
INSERT INTO `log_active_state` VALUES (539, 'BJ_001', 2, 2, '10001,10000', 1576894453);
INSERT INTO `log_active_state` VALUES (540, 'BJ_001', 2, 2, '10001,10000', 1576895053);
INSERT INTO `log_active_state` VALUES (541, 'BJ_001', 2, 2, '10001,10000', 1576895653);
INSERT INTO `log_active_state` VALUES (542, 'BJ_001', 2, 2, '10001,10000', 1576896253);
INSERT INTO `log_active_state` VALUES (543, 'BJ_001', 2, 2, '10001,10000', 1576896853);
INSERT INTO `log_active_state` VALUES (544, 'BJ_001', 2, 2, '10001,10000', 1576897453);
INSERT INTO `log_active_state` VALUES (545, 'BJ_001', 2, 2, '10001,10000', 1576898053);
INSERT INTO `log_active_state` VALUES (546, 'BJ_001', 2, 2, '10001,10000', 1576898653);
INSERT INTO `log_active_state` VALUES (547, 'BJ_001', 2, 2, '10001,10000', 1576899253);
INSERT INTO `log_active_state` VALUES (548, 'BJ_001', 2, 2, '10001,10000', 1576899853);
INSERT INTO `log_active_state` VALUES (549, 'BJ_001', 2, 2, '10001,10000', 1576900453);
INSERT INTO `log_active_state` VALUES (550, 'BJ_001', 2, 2, '10001,10000', 1576901053);
INSERT INTO `log_active_state` VALUES (551, 'BJ_001', 2, 2, '10001,10000', 1576901653);
INSERT INTO `log_active_state` VALUES (552, 'BJ_001', 2, 2, '10001,10000', 1576902253);
INSERT INTO `log_active_state` VALUES (553, 'BJ_001', 2, 2, '10001,10000', 1576902853);
INSERT INTO `log_active_state` VALUES (554, 'BJ_001', 2, 2, '10001,10000', 1576903453);
INSERT INTO `log_active_state` VALUES (555, 'BJ_001', 2, 2, '10001,10000', 1576904053);
INSERT INTO `log_active_state` VALUES (556, 'BJ_001', 2, 2, '10001,10000', 1576904653);
INSERT INTO `log_active_state` VALUES (557, 'BJ_001', 2, 2, '10001,10000', 1576905253);
INSERT INTO `log_active_state` VALUES (558, 'BJ_001', 2, 2, '10001,10000', 1576905853);
INSERT INTO `log_active_state` VALUES (559, 'BJ_001', 2, 2, '10001,10000', 1576906453);
INSERT INTO `log_active_state` VALUES (560, 'BJ_001', 2, 2, '10001,10000', 1576907053);
INSERT INTO `log_active_state` VALUES (561, 'BJ_001', 2, 2, '10001,10000', 1576907653);
INSERT INTO `log_active_state` VALUES (562, 'BJ_001', 2, 2, '10001,10000', 1576908253);
INSERT INTO `log_active_state` VALUES (563, 'BJ_001', 2, 2, '10001,10000', 1576908853);
INSERT INTO `log_active_state` VALUES (564, 'BJ_001', 2, 2, '10001,10000', 1576909453);
INSERT INTO `log_active_state` VALUES (565, 'BJ_001', 2, 2, '10001,10000', 1576910053);
INSERT INTO `log_active_state` VALUES (566, 'BJ_001', 2, 2, '10001,10000', 1576910653);
INSERT INTO `log_active_state` VALUES (567, 'BJ_001', 2, 2, '10001,10000', 1576911253);
INSERT INTO `log_active_state` VALUES (568, 'BJ_001', 2, 2, '10001,10000', 1576911853);
INSERT INTO `log_active_state` VALUES (569, 'BJ_001', 2, 2, '10001,10000', 1576912453);
INSERT INTO `log_active_state` VALUES (570, 'BJ_001', 2, 2, '10001,10000', 1576913053);
INSERT INTO `log_active_state` VALUES (571, 'BJ_001', 2, 2, '10001,10000', 1576913653);
INSERT INTO `log_active_state` VALUES (572, 'BJ_001', 2, 2, '10001,10000', 1576914253);
INSERT INTO `log_active_state` VALUES (573, 'BJ_001', 2, 2, '10001,10000', 1576914853);
INSERT INTO `log_active_state` VALUES (574, 'BJ_001', 2, 2, '10001,10000', 1576915453);
INSERT INTO `log_active_state` VALUES (575, 'BJ_001', 2, 2, '10001,10000', 1576916053);
INSERT INTO `log_active_state` VALUES (576, 'BJ_001', 2, 2, '10001,10000', 1576916653);
INSERT INTO `log_active_state` VALUES (577, 'BJ_001', 2, 2, '10001,10000', 1576917253);
INSERT INTO `log_active_state` VALUES (578, 'BJ_001', 2, 2, '10001,10000', 1576917853);
INSERT INTO `log_active_state` VALUES (579, 'BJ_001', 2, 2, '10001,10000', 1576918453);
INSERT INTO `log_active_state` VALUES (580, 'BJ_001', 2, 2, '10001,10000', 1576919053);
INSERT INTO `log_active_state` VALUES (581, 'BJ_001', 2, 2, '10001,10000', 1576919653);
INSERT INTO `log_active_state` VALUES (582, 'BJ_001', 2, 2, '10001,10000', 1576920253);
INSERT INTO `log_active_state` VALUES (583, 'BJ_001', 2, 2, '10001,10000', 1576920853);
INSERT INTO `log_active_state` VALUES (584, 'BJ_001', 2, 2, '10001,10000', 1576921453);
INSERT INTO `log_active_state` VALUES (585, 'BJ_001', 2, 2, '10001,10000', 1576922053);
INSERT INTO `log_active_state` VALUES (586, 'BJ_001', 2, 2, '10001,10000', 1576922653);
INSERT INTO `log_active_state` VALUES (587, 'BJ_001', 2, 2, '10001,10000', 1576923253);
INSERT INTO `log_active_state` VALUES (588, 'BJ_001', 2, 2, '10001,10000', 1576923853);
INSERT INTO `log_active_state` VALUES (589, 'BJ_001', 2, 2, '10001,10000', 1576924453);
INSERT INTO `log_active_state` VALUES (590, 'BJ_001', 2, 2, '10001,10000', 1576925053);
INSERT INTO `log_active_state` VALUES (591, 'BJ_001', 2, 2, '10001,10000', 1576925653);
INSERT INTO `log_active_state` VALUES (592, 'BJ_001', 2, 2, '10001,10000', 1576926253);
INSERT INTO `log_active_state` VALUES (593, 'BJ_001', 2, 2, '10001,10000', 1576926853);
INSERT INTO `log_active_state` VALUES (594, 'BJ_001', 2, 2, '10001,10000', 1576927453);
INSERT INTO `log_active_state` VALUES (595, 'BJ_001', 2, 2, '10001,10000', 1576928053);
INSERT INTO `log_active_state` VALUES (596, 'BJ_001', 2, 2, '10001,10000', 1576928653);
INSERT INTO `log_active_state` VALUES (597, 'BJ_001', 2, 2, '10001,10000', 1576929253);
INSERT INTO `log_active_state` VALUES (598, 'BJ_001', 2, 2, '10001,10000', 1576929853);
INSERT INTO `log_active_state` VALUES (599, 'BJ_001', 2, 2, '10001,10000', 1576930453);
INSERT INTO `log_active_state` VALUES (600, 'BJ_001', 2, 2, '10001,10000', 1576931053);
INSERT INTO `log_active_state` VALUES (601, 'BJ_001', 2, 2, '10001,10000', 1576931653);
INSERT INTO `log_active_state` VALUES (602, 'BJ_001', 2, 2, '10001,10000', 1576932253);
INSERT INTO `log_active_state` VALUES (603, 'BJ_001', 2, 2, '10001,10000', 1576932853);
INSERT INTO `log_active_state` VALUES (604, 'BJ_001', 2, 2, '10001,10000', 1576933453);
INSERT INTO `log_active_state` VALUES (605, 'BJ_001', 2, 2, '10001,10000', 1576934053);
INSERT INTO `log_active_state` VALUES (606, 'BJ_001', 2, 2, '10001,10000', 1576934653);
INSERT INTO `log_active_state` VALUES (607, 'BJ_001', 2, 2, '10001,10000', 1576935253);
INSERT INTO `log_active_state` VALUES (608, 'BJ_001', 2, 2, '10001,10000', 1576935853);
INSERT INTO `log_active_state` VALUES (609, 'BJ_001', 2, 2, '10001,10000', 1576936453);
INSERT INTO `log_active_state` VALUES (610, 'BJ_001', 2, 2, '10001,10000', 1576937054);
INSERT INTO `log_active_state` VALUES (611, 'BJ_001', 2, 2, '10001,10000', 1576937653);
INSERT INTO `log_active_state` VALUES (612, 'BJ_001', 2, 2, '10001,10000', 1576938253);
INSERT INTO `log_active_state` VALUES (613, 'BJ_001', 2, 2, '10001,10000', 1576938853);
INSERT INTO `log_active_state` VALUES (614, 'BJ_001', 2, 2, '10001,10000', 1576939453);
INSERT INTO `log_active_state` VALUES (615, 'BJ_001', 2, 2, '10001,10000', 1576940053);
INSERT INTO `log_active_state` VALUES (616, 'BJ_001', 2, 2, '10001,10000', 1576940653);
INSERT INTO `log_active_state` VALUES (617, 'BJ_001', 2, 2, '10001,10000', 1576941253);
INSERT INTO `log_active_state` VALUES (618, 'BJ_001', 2, 2, '10001,10000', 1576941853);
INSERT INTO `log_active_state` VALUES (619, 'BJ_001', 2, 2, '10001,10000', 1576942453);
INSERT INTO `log_active_state` VALUES (620, 'BJ_001', 2, 2, '10001,10000', 1576943053);
INSERT INTO `log_active_state` VALUES (621, 'BJ_001', 2, 2, '10001,10000', 1576943653);
INSERT INTO `log_active_state` VALUES (622, 'BJ_001', 2, 2, '10001,10000', 1576944253);
INSERT INTO `log_active_state` VALUES (623, 'BJ_001', 2, 2, '10001,10000', 1576944853);
INSERT INTO `log_active_state` VALUES (624, 'BJ_001', 2, 2, '10001,10000', 1576945453);
INSERT INTO `log_active_state` VALUES (625, 'BJ_001', 2, 2, '10001,10000', 1576946053);
INSERT INTO `log_active_state` VALUES (626, 'BJ_001', 2, 2, '10001,10000', 1576946653);
INSERT INTO `log_active_state` VALUES (627, 'BJ_001', 2, 2, '10001,10000', 1576947253);
INSERT INTO `log_active_state` VALUES (628, 'BJ_001', 2, 2, '10001,10000', 1576947853);
INSERT INTO `log_active_state` VALUES (629, 'BJ_001', 2, 2, '10001,10000', 1576948453);
INSERT INTO `log_active_state` VALUES (630, 'BJ_001', 2, 2, '10001,10000', 1576949053);
INSERT INTO `log_active_state` VALUES (631, 'BJ_001', 2, 2, '10001,10000', 1576949653);
INSERT INTO `log_active_state` VALUES (632, 'BJ_001', 2, 2, '10001,10000', 1576950253);
INSERT INTO `log_active_state` VALUES (633, 'BJ_001', 2, 2, '10001,10000', 1576950853);
INSERT INTO `log_active_state` VALUES (634, 'BJ_001', 2, 2, '10001,10000', 1576951453);
INSERT INTO `log_active_state` VALUES (635, 'BJ_001', 2, 2, '10001,10000', 1576952053);
INSERT INTO `log_active_state` VALUES (636, 'BJ_001', 2, 2, '10001,10000', 1576952653);
INSERT INTO `log_active_state` VALUES (637, 'BJ_001', 2, 2, '10001,10000', 1576953253);
INSERT INTO `log_active_state` VALUES (638, 'BJ_001', 2, 2, '10001,10000', 1576953853);
INSERT INTO `log_active_state` VALUES (639, 'BJ_001', 2, 2, '10001,10000', 1576954453);
INSERT INTO `log_active_state` VALUES (640, 'BJ_001', 2, 2, '10001,10000', 1576955053);
INSERT INTO `log_active_state` VALUES (641, 'BJ_001', 2, 2, '10001,10000', 1576955653);
INSERT INTO `log_active_state` VALUES (642, 'BJ_001', 2, 2, '10001,10000', 1576956253);
INSERT INTO `log_active_state` VALUES (643, 'BJ_001', 2, 2, '10001,10000', 1576956853);
INSERT INTO `log_active_state` VALUES (644, 'BJ_001', 2, 2, '10001,10000', 1576957453);
INSERT INTO `log_active_state` VALUES (645, 'BJ_001', 2, 2, '10001,10000', 1576958053);
INSERT INTO `log_active_state` VALUES (646, 'BJ_001', 2, 2, '10001,10000', 1576958653);
INSERT INTO `log_active_state` VALUES (647, 'BJ_001', 2, 2, '10001,10000', 1576959253);
INSERT INTO `log_active_state` VALUES (648, 'BJ_001', 2, 2, '10001,10000', 1576959853);
INSERT INTO `log_active_state` VALUES (649, 'BJ_001', 2, 2, '10001,10000', 1576960453);
INSERT INTO `log_active_state` VALUES (650, 'BJ_001', 2, 2, '10001,10000', 1576961053);
INSERT INTO `log_active_state` VALUES (651, 'BJ_001', 2, 2, '10001,10000', 1576961653);
INSERT INTO `log_active_state` VALUES (652, 'BJ_001', 2, 2, '10001,10000', 1576962253);
INSERT INTO `log_active_state` VALUES (653, 'BJ_001', 2, 2, '10001,10000', 1576962853);
INSERT INTO `log_active_state` VALUES (654, 'BJ_001', 2, 2, '10001,10000', 1576963453);
INSERT INTO `log_active_state` VALUES (655, 'BJ_001', 2, 2, '10001,10000', 1576964053);
INSERT INTO `log_active_state` VALUES (656, 'BJ_001', 2, 2, '10001,10000', 1576964653);
INSERT INTO `log_active_state` VALUES (657, 'BJ_001', 2, 2, '10001,10000', 1576965253);
INSERT INTO `log_active_state` VALUES (658, 'BJ_001', 2, 2, '10001,10000', 1576965853);
INSERT INTO `log_active_state` VALUES (659, 'BJ_001', 2, 2, '10001,10000', 1576966453);
INSERT INTO `log_active_state` VALUES (660, 'BJ_001', 2, 2, '10001,10000', 1576967053);
INSERT INTO `log_active_state` VALUES (661, 'BJ_001', 2, 2, '10001,10000', 1576967653);
INSERT INTO `log_active_state` VALUES (662, 'BJ_001', 2, 2, '10001,10000', 1576968253);
INSERT INTO `log_active_state` VALUES (663, 'BJ_001', 2, 2, '10001,10000', 1576968853);
INSERT INTO `log_active_state` VALUES (664, 'BJ_001', 2, 2, '10001,10000', 1576969453);
INSERT INTO `log_active_state` VALUES (665, 'BJ_001', 2, 2, '10001,10000', 1576970053);
INSERT INTO `log_active_state` VALUES (666, 'BJ_001', 2, 2, '10001,10000', 1576970653);
INSERT INTO `log_active_state` VALUES (667, 'BJ_001', 2, 2, '10001,10000', 1576971253);
INSERT INTO `log_active_state` VALUES (668, 'BJ_001', 2, 2, '10001,10000', 1576971853);
INSERT INTO `log_active_state` VALUES (669, 'BJ_001', 2, 2, '10001,10000', 1576972453);
INSERT INTO `log_active_state` VALUES (670, 'BJ_001', 2, 2, '10001,10000', 1576973053);
INSERT INTO `log_active_state` VALUES (671, 'BJ_001', 2, 2, '10001,10000', 1576973653);
INSERT INTO `log_active_state` VALUES (672, 'BJ_001', 2, 2, '10001,10000', 1576974253);
INSERT INTO `log_active_state` VALUES (673, 'BJ_001', 2, 2, '10001,10000', 1576974853);
INSERT INTO `log_active_state` VALUES (674, 'BJ_001', 2, 2, '10001,10000', 1576975453);
INSERT INTO `log_active_state` VALUES (675, 'BJ_001', 2, 2, '10001,10000', 1576976053);
INSERT INTO `log_active_state` VALUES (676, 'BJ_001', 2, 2, '10001,10000', 1576976653);
INSERT INTO `log_active_state` VALUES (677, 'BJ_001', 2, 2, '10001,10000', 1576977253);
INSERT INTO `log_active_state` VALUES (678, 'BJ_001', 2, 2, '10001,10000', 1576977853);
INSERT INTO `log_active_state` VALUES (679, 'BJ_001', 2, 2, '10001,10000', 1576978453);
INSERT INTO `log_active_state` VALUES (680, 'BJ_001', 2, 2, '10001,10000', 1576979053);
INSERT INTO `log_active_state` VALUES (681, 'BJ_001', 2, 2, '10001,10000', 1576979653);
INSERT INTO `log_active_state` VALUES (682, 'BJ_001', 2, 2, '10001,10000', 1576980253);
INSERT INTO `log_active_state` VALUES (683, 'BJ_001', 2, 2, '10001,10000', 1576980853);
INSERT INTO `log_active_state` VALUES (684, 'BJ_001', 2, 2, '10001,10000', 1576981453);
INSERT INTO `log_active_state` VALUES (685, 'BJ_001', 2, 2, '10001,10000', 1576982053);
INSERT INTO `log_active_state` VALUES (686, 'BJ_001', 2, 2, '10001,10000', 1576982653);
INSERT INTO `log_active_state` VALUES (687, 'BJ_001', 2, 2, '10001,10000', 1576983253);
INSERT INTO `log_active_state` VALUES (688, 'BJ_001', 2, 2, '10001,10000', 1576983853);
INSERT INTO `log_active_state` VALUES (689, 'BJ_001', 2, 2, '10001,10000', 1576984453);
INSERT INTO `log_active_state` VALUES (690, 'BJ_001', 2, 2, '10001,10000', 1576985053);
INSERT INTO `log_active_state` VALUES (691, 'BJ_001', 2, 2, '10001,10000', 1576985653);
INSERT INTO `log_active_state` VALUES (692, 'BJ_001', 2, 2, '10001,10000', 1576986253);
INSERT INTO `log_active_state` VALUES (693, 'BJ_001', 2, 2, '10001,10000', 1576986853);
INSERT INTO `log_active_state` VALUES (694, 'BJ_001', 2, 2, '10001,10000', 1576987453);
INSERT INTO `log_active_state` VALUES (695, 'BJ_001', 2, 2, '10001,10000', 1576988053);
INSERT INTO `log_active_state` VALUES (696, 'BJ_001', 2, 2, '10001,10000', 1576988653);
INSERT INTO `log_active_state` VALUES (697, 'BJ_001', 2, 2, '10001,10000', 1576989253);
INSERT INTO `log_active_state` VALUES (698, 'BJ_001', 2, 2, '10001,10000', 1576989853);
INSERT INTO `log_active_state` VALUES (699, 'BJ_001', 2, 2, '10001,10000', 1576990453);
INSERT INTO `log_active_state` VALUES (700, 'BJ_001', 2, 2, '10001,10000', 1576991053);
INSERT INTO `log_active_state` VALUES (701, 'BJ_001', 2, 2, '10001,10000', 1576991653);
INSERT INTO `log_active_state` VALUES (702, 'BJ_001', 2, 2, '10001,10000', 1576992253);
INSERT INTO `log_active_state` VALUES (703, 'BJ_001', 2, 2, '10001,10000', 1576992853);
INSERT INTO `log_active_state` VALUES (704, 'BJ_001', 2, 2, '10001,10000', 1576993453);
INSERT INTO `log_active_state` VALUES (705, 'BJ_001', 2, 2, '10001,10000', 1576994053);
INSERT INTO `log_active_state` VALUES (706, 'BJ_001', 2, 2, '10001,10000', 1576994653);
INSERT INTO `log_active_state` VALUES (707, 'BJ_001', 2, 2, '10001,10000', 1576995253);
INSERT INTO `log_active_state` VALUES (708, 'BJ_001', 2, 2, '10001,10000', 1576995853);
INSERT INTO `log_active_state` VALUES (709, 'BJ_001', 2, 2, '10001,10000', 1576996453);
INSERT INTO `log_active_state` VALUES (710, 'BJ_001', 2, 2, '10001,10000', 1576997053);
INSERT INTO `log_active_state` VALUES (711, 'BJ_001', 2, 2, '10001,10000', 1576997653);
INSERT INTO `log_active_state` VALUES (712, 'BJ_001', 2, 2, '10001,10000', 1576998253);
INSERT INTO `log_active_state` VALUES (713, 'BJ_001', 2, 2, '10001,10000', 1576998853);
INSERT INTO `log_active_state` VALUES (714, 'BJ_001', 2, 2, '10001,10000', 1576999453);
INSERT INTO `log_active_state` VALUES (715, 'BJ_001', 2, 2, '10001,10000', 1577000053);
INSERT INTO `log_active_state` VALUES (716, 'BJ_001', 2, 2, '10001,10000', 1577000653);
INSERT INTO `log_active_state` VALUES (717, 'BJ_001', 2, 2, '10001,10000', 1577001253);
INSERT INTO `log_active_state` VALUES (718, 'BJ_001', 2, 2, '10001,10000', 1577001853);
INSERT INTO `log_active_state` VALUES (719, 'BJ_001', 2, 2, '10001,10000', 1577002453);
INSERT INTO `log_active_state` VALUES (720, 'BJ_001', 2, 2, '10001,10000', 1577003053);
INSERT INTO `log_active_state` VALUES (721, 'BJ_001', 2, 2, '10001,10000', 1577003653);
INSERT INTO `log_active_state` VALUES (722, 'BJ_001', 2, 2, '10001,10000', 1577004253);
INSERT INTO `log_active_state` VALUES (723, 'BJ_001', 2, 2, '10001,10000', 1577004853);
INSERT INTO `log_active_state` VALUES (724, 'BJ_001', 2, 2, '10001,10000', 1577005453);
INSERT INTO `log_active_state` VALUES (725, 'BJ_001', 2, 2, '10001,10000', 1577006053);
INSERT INTO `log_active_state` VALUES (726, 'BJ_001', 2, 2, '10001,10000', 1577006653);
INSERT INTO `log_active_state` VALUES (727, 'BJ_001', 2, 2, '10001,10000', 1577007253);
INSERT INTO `log_active_state` VALUES (728, 'BJ_001', 2, 2, '10001,10000', 1577007853);
INSERT INTO `log_active_state` VALUES (729, 'BJ_001', 2, 2, '10001,10000', 1577008453);
INSERT INTO `log_active_state` VALUES (730, 'BJ_001', 2, 2, '10001,10000', 1577009053);
INSERT INTO `log_active_state` VALUES (731, 'BJ_001', 2, 2, '10001,10000', 1577009653);
INSERT INTO `log_active_state` VALUES (732, 'BJ_001', 2, 2, '10001,10000', 1577010253);
INSERT INTO `log_active_state` VALUES (733, 'BJ_001', 2, 2, '10001,10000', 1577010853);
INSERT INTO `log_active_state` VALUES (734, 'BJ_001', 2, 2, '10001,10000', 1577011453);
INSERT INTO `log_active_state` VALUES (735, 'BJ_001', 2, 2, '10001,10000', 1577012053);
INSERT INTO `log_active_state` VALUES (736, 'BJ_001', 2, 2, '10001,10000', 1577012653);
INSERT INTO `log_active_state` VALUES (737, 'BJ_001', 2, 2, '10001,10000', 1577013253);
INSERT INTO `log_active_state` VALUES (738, 'BJ_001', 2, 2, '10001,10000', 1577013853);
INSERT INTO `log_active_state` VALUES (739, 'BJ_001', 2, 2, '10001,10000', 1577014453);
INSERT INTO `log_active_state` VALUES (740, 'BJ_001', 2, 2, '10001,10000', 1577015053);
INSERT INTO `log_active_state` VALUES (741, 'BJ_001', 2, 2, '10001,10000', 1577015653);
INSERT INTO `log_active_state` VALUES (742, 'BJ_001', 2, 2, '10001,10000', 1577016253);
INSERT INTO `log_active_state` VALUES (743, 'BJ_001', 2, 2, '10001,10000', 1577016853);
INSERT INTO `log_active_state` VALUES (744, 'BJ_001', 2, 2, '10001,10000', 1577017453);
INSERT INTO `log_active_state` VALUES (745, 'BJ_001', 2, 2, '10001,10000', 1577018053);
INSERT INTO `log_active_state` VALUES (746, 'BJ_001', 2, 2, '10001,10000', 1577018653);
INSERT INTO `log_active_state` VALUES (747, 'BJ_001', 2, 2, '10001,10000', 1577019253);
INSERT INTO `log_active_state` VALUES (748, 'BJ_001', 2, 2, '10001,10000', 1577019853);
INSERT INTO `log_active_state` VALUES (749, 'BJ_001', 2, 2, '10001,10000', 1577020453);
INSERT INTO `log_active_state` VALUES (750, 'BJ_001', 2, 2, '10001,10000', 1577021053);
INSERT INTO `log_active_state` VALUES (751, 'BJ_001', 2, 2, '10001,10000', 1577021653);
INSERT INTO `log_active_state` VALUES (752, 'BJ_001', 2, 2, '10001,10000', 1577022253);
INSERT INTO `log_active_state` VALUES (753, 'BJ_001', 2, 2, '10001,10000', 1577022853);
INSERT INTO `log_active_state` VALUES (754, 'BJ_001', 2, 2, '10001,10000', 1577023453);
INSERT INTO `log_active_state` VALUES (755, 'BJ_001', 2, 2, '10001,10000', 1577024053);
INSERT INTO `log_active_state` VALUES (756, 'BJ_001', 2, 2, '10001,10000', 1577024653);
INSERT INTO `log_active_state` VALUES (757, 'BJ_001', 2, 2, '10001,10000', 1577025253);
INSERT INTO `log_active_state` VALUES (758, 'BJ_001', 2, 2, '10001,10000', 1577025853);
INSERT INTO `log_active_state` VALUES (759, 'BJ_001', 2, 2, '10001,10000', 1577026453);
INSERT INTO `log_active_state` VALUES (760, 'BJ_001', 2, 2, '10001,10000', 1577027053);
INSERT INTO `log_active_state` VALUES (761, 'BJ_001', 2, 2, '10001,10000', 1577027653);
INSERT INTO `log_active_state` VALUES (762, 'BJ_001', 2, 2, '10001,10000', 1577028253);
INSERT INTO `log_active_state` VALUES (763, 'BJ_001', 2, 2, '10001,10000', 1577028853);
INSERT INTO `log_active_state` VALUES (764, 'BJ_001', 2, 2, '10001,10000', 1577029453);
INSERT INTO `log_active_state` VALUES (765, 'BJ_001', 2, 2, '10001,10000', 1577030053);
INSERT INTO `log_active_state` VALUES (766, 'BJ_001', 2, 2, '10001,10000', 1577030653);
INSERT INTO `log_active_state` VALUES (767, 'BJ_001', 2, 2, '10001,10000', 1577031253);
INSERT INTO `log_active_state` VALUES (768, 'BJ_001', 2, 2, '10001,10000', 1577031853);
INSERT INTO `log_active_state` VALUES (769, 'BJ_001', 2, 2, '10001,10000', 1577032453);
INSERT INTO `log_active_state` VALUES (770, 'BJ_001', 2, 2, '10001,10000', 1577033053);
INSERT INTO `log_active_state` VALUES (771, 'BJ_001', 2, 2, '10001,10000', 1577033653);
INSERT INTO `log_active_state` VALUES (772, 'BJ_001', 2, 2, '10001,10000', 1577034253);
INSERT INTO `log_active_state` VALUES (773, 'BJ_001', 2, 2, '10001,10000', 1577034853);
INSERT INTO `log_active_state` VALUES (774, 'BJ_001', 2, 2, '10001,10000', 1577035453);
INSERT INTO `log_active_state` VALUES (775, 'BJ_001', 2, 2, '10001,10000', 1577036053);
INSERT INTO `log_active_state` VALUES (776, 'BJ_001', 2, 2, '10001,10000', 1577036653);
INSERT INTO `log_active_state` VALUES (777, 'BJ_001', 2, 2, '10001,10000', 1577037253);
INSERT INTO `log_active_state` VALUES (778, 'BJ_001', 2, 2, '10001,10000', 1577037853);
INSERT INTO `log_active_state` VALUES (779, 'BJ_001', 2, 2, '10001,10000', 1577038453);
INSERT INTO `log_active_state` VALUES (780, 'BJ_001', 2, 2, '10001,10000', 1577039053);
INSERT INTO `log_active_state` VALUES (781, 'BJ_001', 2, 2, '10001,10000', 1577039653);
INSERT INTO `log_active_state` VALUES (782, 'BJ_001', 2, 2, '10001,10000', 1577040253);
INSERT INTO `log_active_state` VALUES (783, 'BJ_001', 2, 2, '10001,10000', 1577040853);
INSERT INTO `log_active_state` VALUES (784, 'BJ_001', 2, 2, '10001,10000', 1577041453);
INSERT INTO `log_active_state` VALUES (785, 'BJ_001', 2, 2, '10001,10000', 1577042053);
INSERT INTO `log_active_state` VALUES (786, 'BJ_001', 2, 2, '10001,10000', 1577042653);
INSERT INTO `log_active_state` VALUES (787, 'BJ_001', 2, 2, '10001,10000', 1577043253);
INSERT INTO `log_active_state` VALUES (788, 'BJ_001', 2, 2, '10001,10000', 1577043853);
INSERT INTO `log_active_state` VALUES (789, 'BJ_001', 2, 2, '10001,10000', 1577044453);
INSERT INTO `log_active_state` VALUES (790, 'BJ_001', 2, 2, '10001,10000', 1577045053);
INSERT INTO `log_active_state` VALUES (791, 'BJ_001', 2, 2, '10001,10000', 1577045653);
INSERT INTO `log_active_state` VALUES (792, 'BJ_001', 2, 2, '10001,10000', 1577046253);
INSERT INTO `log_active_state` VALUES (793, 'BJ_001', 2, 2, '10001,10000', 1577046853);
INSERT INTO `log_active_state` VALUES (794, 'BJ_001', 2, 2, '10001,10000', 1577047453);
INSERT INTO `log_active_state` VALUES (795, 'BJ_001', 2, 2, '10001,10000', 1577048053);
INSERT INTO `log_active_state` VALUES (796, 'BJ_001', 2, 2, '10001,10000', 1577048653);
INSERT INTO `log_active_state` VALUES (797, 'BJ_001', 2, 2, '10001,10000', 1577049253);
INSERT INTO `log_active_state` VALUES (798, 'BJ_001', 2, 2, '10001,10000', 1577049853);
INSERT INTO `log_active_state` VALUES (799, 'BJ_001', 2, 2, '10001,10000', 1577050453);
INSERT INTO `log_active_state` VALUES (800, 'BJ_001', 2, 2, '10001,10000', 1577051053);
INSERT INTO `log_active_state` VALUES (801, 'BJ_001', 2, 2, '10001,10000', 1577051653);
INSERT INTO `log_active_state` VALUES (802, 'BJ_001', 2, 2, '10001,10000', 1577052253);
INSERT INTO `log_active_state` VALUES (803, 'BJ_001', 2, 2, '10001,10000', 1577052853);
INSERT INTO `log_active_state` VALUES (804, 'BJ_001', 2, 2, '10001,10000', 1577053453);
INSERT INTO `log_active_state` VALUES (805, 'BJ_001', 2, 2, '10001,10000', 1577054053);
INSERT INTO `log_active_state` VALUES (806, 'BJ_001', 2, 2, '10001,10000', 1577054653);
INSERT INTO `log_active_state` VALUES (807, 'BJ_001', 2, 2, '10001,10000', 1577055253);
INSERT INTO `log_active_state` VALUES (808, 'BJ_001', 2, 2, '10001,10000', 1577055853);
INSERT INTO `log_active_state` VALUES (809, 'BJ_001', 2, 2, '10001,10000', 1577056453);
INSERT INTO `log_active_state` VALUES (810, 'BJ_001', 2, 2, '10001,10000', 1577057053);
INSERT INTO `log_active_state` VALUES (811, 'BJ_001', 2, 2, '10001,10000', 1577057653);
INSERT INTO `log_active_state` VALUES (812, 'BJ_001', 2, 2, '10001,10000', 1577058253);
INSERT INTO `log_active_state` VALUES (813, 'BJ_001', 2, 2, '10001,10000', 1577058853);
INSERT INTO `log_active_state` VALUES (814, 'BJ_001', 2, 2, '10001,10000', 1577059453);
INSERT INTO `log_active_state` VALUES (815, 'BJ_001', 2, 2, '10001,10000', 1577060053);
INSERT INTO `log_active_state` VALUES (816, 'BJ_001', 2, 2, '10001,10000', 1577060653);
INSERT INTO `log_active_state` VALUES (817, 'BJ_001', 2, 2, '10001,10000', 1577061253);
INSERT INTO `log_active_state` VALUES (818, 'BJ_001', 2, 2, '10001,10000', 1577061853);
INSERT INTO `log_active_state` VALUES (819, 'BJ_001', 2, 2, '10001,10000', 1577062453);
INSERT INTO `log_active_state` VALUES (820, 'BJ_001', 2, 2, '10001,10000', 1577063053);
INSERT INTO `log_active_state` VALUES (821, 'BJ_001', 2, 2, '10001,10000', 1577063653);
INSERT INTO `log_active_state` VALUES (822, 'BJ_001', 2, 2, '10001,10000', 1577064253);
INSERT INTO `log_active_state` VALUES (823, 'BJ_001', 2, 2, '10001,10000', 1577064853);
INSERT INTO `log_active_state` VALUES (824, 'BJ_001', 2, 2, '10001,10000', 1577065453);
INSERT INTO `log_active_state` VALUES (825, 'BJ_001', 2, 2, '10001,10000', 1577066053);
INSERT INTO `log_active_state` VALUES (826, 'BJ_001', 2, 2, '10001,10000', 1577066653);
INSERT INTO `log_active_state` VALUES (827, 'BJ_001', 2, 2, '10001,10000', 1577067253);
INSERT INTO `log_active_state` VALUES (828, 'BJ_001', 2, 2, '10001,10000', 1577067853);
INSERT INTO `log_active_state` VALUES (829, 'BJ_001', 2, 2, '10001,10000', 1577068453);
INSERT INTO `log_active_state` VALUES (830, 'BJ_001', 2, 2, '10001,10000', 1577069053);
INSERT INTO `log_active_state` VALUES (831, 'BJ_001', 2, 2, '10001,10000', 1577069653);
INSERT INTO `log_active_state` VALUES (832, 'BJ_001', 2, 2, '10001,10000', 1577070253);
INSERT INTO `log_active_state` VALUES (833, 'BJ_001', 2, 2, '10001,10000', 1577070853);
INSERT INTO `log_active_state` VALUES (834, 'BJ_001', 2, 2, '10001,10000', 1577071453);
INSERT INTO `log_active_state` VALUES (835, 'BJ_001', 2, 2, '10001,10000', 1577072053);
INSERT INTO `log_active_state` VALUES (836, 'BJ_001', 2, 2, '10001,10000', 1577072653);
INSERT INTO `log_active_state` VALUES (837, 'BJ_001', 2, 2, '10001,10000', 1577073253);
INSERT INTO `log_active_state` VALUES (838, 'BJ_001', 2, 2, '10001,10000', 1577073853);
INSERT INTO `log_active_state` VALUES (839, 'BJ_001', 2, 2, '10001,10000', 1577074453);
INSERT INTO `log_active_state` VALUES (840, 'BJ_001', 2, 2, '10001,10000', 1577075053);
INSERT INTO `log_active_state` VALUES (841, 'BJ_001', 2, 2, '10001,10000', 1577075653);
INSERT INTO `log_active_state` VALUES (842, 'BJ_001', 2, 2, '10001,10000', 1577076253);
INSERT INTO `log_active_state` VALUES (843, 'BJ_001', 2, 2, '10001,10000', 1577076853);
INSERT INTO `log_active_state` VALUES (844, 'BJ_001', 2, 2, '10001,10000', 1577077453);
INSERT INTO `log_active_state` VALUES (845, 'BJ_001', 2, 2, '10001,10000', 1577078053);
INSERT INTO `log_active_state` VALUES (846, 'BJ_001', 2, 2, '10001,10000', 1577078653);
INSERT INTO `log_active_state` VALUES (847, 'BJ_001', 2, 2, '10001,10000', 1577079253);
INSERT INTO `log_active_state` VALUES (848, 'BJ_001', 2, 2, '10001,10000', 1577079853);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` smallint(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `parentid` smallint(6) UNSIGNED NOT NULL DEFAULT 0,
  `app` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用名称app',
  `model` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '控制器',
  `action` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作名称',
  `data` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '额外参数',
  `type` tinyint(1) NOT NULL DEFAULT 0 COMMENT '菜单类型  1：权限认证+菜单；0：只作为菜单',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态，1显示，0不显示',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  `listorder` smallint(6) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `status`(`status`) USING BTREE,
  INDEX `parentid`(`parentid`) USING BTREE,
  INDEX `model`(`model`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 97 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 0, 'Home', 'Default', 'default', '', 0, 1, '权限管理', '', '', 0);
INSERT INTO `menu` VALUES (2, 1, 'Home', 'Basicinfo', '', '', 1, 1, '基础数据管理', '', '', 2);
INSERT INTO `menu` VALUES (3, 1, 'Home', 'Policy', '', '', 1, 1, '策略管理', '', '', 2);
INSERT INTO `menu` VALUES (4, 1, 'Home', 'Log', '', '', 1, 1, '日志管理', '', '', 2);
INSERT INTO `menu` VALUES (5, 1, 'Home', 'Interface', '', '', 1, 1, '配置管理', '', '', 2);
INSERT INTO `menu` VALUES (6, 1, 'Home', 'Systemlog', '', '', 1, 1, '系统管理', NULL, '', 0);
INSERT INTO `menu` VALUES (7, 2, 'Home', 'Basicinfo', 'company', '', 1, 1, 'IDC/ISP经营单位信息', NULL, '', 0);
INSERT INTO `menu` VALUES (8, 2, 'Home', 'Basicinfo', 'room', '', 1, 1, '机房管理', NULL, '', 0);
INSERT INTO `menu` VALUES (9, 2, 'Home', 'Basicinfo', 'user', '', 1, 1, '用户管理', NULL, '', 0);
INSERT INTO `menu` VALUES (10, 3, 'Home', 'Policy', 'basicsearch', '', 1, 1, '基础数据查询', NULL, '', 0);
INSERT INTO `menu` VALUES (12, 3, 'Home', 'Policy', 'basic_check', '', 1, 1, '基础数据核验处理', NULL, '', 0);
INSERT INTO `menu` VALUES (13, 3, 'Home', 'Policy', 'illegal_info', '', 1, 1, '违法信息安全管理', NULL, '', 0);
INSERT INTO `menu` VALUES (15, 3, 'Home', 'Policy', 'illegal_net', '', 1, 1, '违法网站列表', NULL, '', 0);
INSERT INTO `menu` VALUES (17, 3, 'Home', 'Policy', 'no_filter', '', 1, 1, '免过滤网站列表', NULL, '', 0);
INSERT INTO `menu` VALUES (18, 3, 'Home', 'Policy', 'access_log', '', 1, 1, '访问日志查询指令', NULL, '', 0);
INSERT INTO `menu` VALUES (19, 3, 'Home', 'Policy', 'active_resource', '', 1, 1, '活跃资源访问量查询', NULL, '', 0);
INSERT INTO `menu` VALUES (20, 3, 'Home', 'Policy', 'active_time', '', 1, 1, '活跃资源周期', NULL, '', 0);
INSERT INTO `menu` VALUES (21, 4, 'Home', 'Log', 'access_log', '', 1, 1, '访问日志', NULL, '', 0);
INSERT INTO `menu` VALUES (22, 4, 'Home', 'Log', 'active_ip', '', 1, 1, '活跃资源IP', NULL, '', 0);
INSERT INTO `menu` VALUES (24, 4, 'Home', 'Log', 'active_domain', '', 1, 1, '活跃资源域名', NULL, '', 0);
INSERT INTO `menu` VALUES (25, 4, 'Home', 'Log', 'filter_log', '', 1, 1, '监测过滤日志', NULL, '', 0);
INSERT INTO `menu` VALUES (26, 4, 'Home', 'Log', 'illegal_log', '', 1, 1, '违法违规日志', NULL, '', 0);
INSERT INTO `menu` VALUES (27, 4, 'Home', 'Log', 'basic_abnormal', '', 1, 1, '基础数据异常日志', NULL, '', 0);
INSERT INTO `menu` VALUES (28, 4, 'Home', 'Log', 'isms_status', '', 1, 1, 'ISMS活动状态上报', NULL, '', 0);
INSERT INTO `menu` VALUES (29, 5, 'Home', 'Interface', 'cu_eu', '', 1, 1, 'CU与EU参数', NULL, '', 0);
INSERT INTO `menu` VALUES (30, 5, 'Home', 'Interface', 'cu_smms', '', 1, 1, 'CU与SMMS参数', NULL, '', 0);
INSERT INTO `menu` VALUES (31, 5, 'Home', 'Interface', 'cu_du', '', 1, 1, 'CU与DU参数', NULL, '', 0);
INSERT INTO `menu` VALUES (35, 5, 'Home', 'Interface', 'setting_cu', '', 1, 1, 'CU系统配置', NULL, '', 0);
INSERT INTO `menu` VALUES (36, 5, 'Home', 'Interface', 'inner', '', 1, 1, 'EU设备管理', NULL, '', 0);
INSERT INTO `menu` VALUES (37, 6, 'Home', 'Systemlog', 'user', '', 1, 1, '用户管理', NULL, '', 0);
INSERT INTO `menu` VALUES (39, 6, 'Home', 'Systemlog', 'usergroup', '', 1, 1, '用户组管理', NULL, '', 0);
INSERT INTO `menu` VALUES (42, 6, 'Home', 'Systemlog', 'logset', '', 1, 1, '系统日志', NULL, '', 0);
INSERT INTO `menu` VALUES (43, 7, 'Home', 'Basicinfo', 'company_add', '', 1, 1, '添加经营单位', NULL, '', 0);
INSERT INTO `menu` VALUES (44, 7, 'Home', 'Basicinfo', 'company_edit', '', 1, 1, '编辑经营单位', NULL, '', 0);
INSERT INTO `menu` VALUES (46, 7, 'Home', 'Basicinfo', 'company_del', '', 1, 1, '删除经营单位', NULL, '', 0);
INSERT INTO `menu` VALUES (47, 7, 'Home', 'Basicinfo', 'basic_report', '', 1, 1, '基础数据上报', NULL, '', 0);
INSERT INTO `menu` VALUES (48, 8, 'Home', 'Basicinfo', 'room_add', '', 1, 1, '添加机房', NULL, '', 0);
INSERT INTO `menu` VALUES (49, 8, 'Home', 'Basicinfo', 'room_edit', '', 1, 1, '编辑机房', NULL, '', 0);
INSERT INTO `menu` VALUES (50, 8, 'Home', 'Basicinfo', 'room_del', '', 1, 1, '删除机房', NULL, '', 0);
INSERT INTO `menu` VALUES (51, 9, 'Home', 'Basicinfo', 'user_add', '', 1, 1, '添加用户', NULL, '', 0);
INSERT INTO `menu` VALUES (52, 9, 'Home', 'Basicinfo', 'user_edit', '', 1, 1, '编辑用户', NULL, '', 0);
INSERT INTO `menu` VALUES (53, 9, 'Home', 'Basicinfo', 'user_del', '', 1, 1, '删除用户', NULL, '', 0);
INSERT INTO `menu` VALUES (54, 12, 'Home', 'Policy', 'basic_check_operation', '', 1, 1, '处置', NULL, '', 0);
INSERT INTO `menu` VALUES (55, 13, 'Home', 'Policy', 'info_del', '', 1, 1, '取消策略', NULL, '', 0);
INSERT INTO `menu` VALUES (56, 55, 'Home', 'Policy', 'info_realdel', '', 1, 1, '删除策略', NULL, '', 0);
INSERT INTO `menu` VALUES (57, 13, 'Home', 'Policy', 'info_add', '', 1, 1, '下发策略', NULL, '', 0);
INSERT INTO `menu` VALUES (58, 15, 'Home', 'Policy', 'illegal_net_add', '', 1, 1, '添加策略', NULL, '', 0);
INSERT INTO `menu` VALUES (59, 15, 'Home', 'Policy', 'illegal_net_del', '', 1, 1, '取消策略', NULL, '', 0);
INSERT INTO `menu` VALUES (60, 59, 'Home', 'Policy', 'illegal_net_realdel', '', 1, 1, '删除策略', NULL, '', 0);
INSERT INTO `menu` VALUES (61, 17, 'Home', 'Policy', 'no_filter_add', '', 1, 1, '添加策略', NULL, '', 0);
INSERT INTO `menu` VALUES (62, 17, 'Home', 'Policy', 'illegal_net_del', '', 1, 1, '取消策略', NULL, '', 0);
INSERT INTO `menu` VALUES (63, 62, 'Home', 'Policy', 'no_filter_realdel', '', 1, 1, '删除策略', NULL, '', 0);
INSERT INTO `menu` VALUES (64, 18, 'Home', 'Policy', 'access_log_add', '', 1, 1, '添加指令', NULL, '', 0);
INSERT INTO `menu` VALUES (65, 20, 'Home', 'Policy', 'active_time_add', '', 1, 1, '添加策略', NULL, '', 0);
INSERT INTO `menu` VALUES (66, 18, 'Home', 'Policy', 'access_realdel', '', 1, 1, '删除', NULL, '', 0);
INSERT INTO `menu` VALUES (67, 29, 'Home', 'Interface', 'eu_addoredit', '', 1, 1, 'EU服务接口配置', NULL, '', 0);
INSERT INTO `menu` VALUES (68, 30, 'Home', 'Interface', 'smms_addoredit', '', 1, 1, 'SMMS服务接口配置', NULL, '', 0);
INSERT INTO `menu` VALUES (69, 31, 'Home', 'Interface', 'du_addoredit', '', 1, 1, 'DU服务接口配置', NULL, '', 0);
INSERT INTO `menu` VALUES (70, 35, 'Home', 'Interface', 'do_cuaddoredit', '', 1, 1, 'CU系统信息配置', NULL, '', 0);
INSERT INTO `menu` VALUES (71, 36, 'Home', 'Interface', 'inner_addoredit', '', 1, 1, '添加EU设备', NULL, '', 0);
INSERT INTO `menu` VALUES (72, 36, 'Home', 'Interface', 'inner_del', '', 1, 1, '删除EU设备', NULL, '', 0);
INSERT INTO `menu` VALUES (73, 37, 'Home', 'Systemlog', 'user_add', '', 1, 1, '添加用户', NULL, '', 0);
INSERT INTO `menu` VALUES (74, 37, 'Home', 'Systemlog', 'user_edit', '', 1, 1, '修改用户', NULL, '', 0);
INSERT INTO `menu` VALUES (75, 37, 'Home', 'Systemlog', 'user_del', '', 1, 1, '删除用户', NULL, '', 0);
INSERT INTO `menu` VALUES (76, 39, 'Home', 'Systemlog', 'usergroup_add', '', 1, 1, '添加用户组', NULL, '', 0);
INSERT INTO `menu` VALUES (77, 39, 'Home', 'Systemlog', 'usergroup_edite', '', 1, 1, '修改用户组', NULL, '', 0);
INSERT INTO `menu` VALUES (78, 39, 'Home', 'Systemlog', 'usergroup_del', '', 1, 1, '删除用户组', NULL, '', 0);
INSERT INTO `menu` VALUES (79, 39, 'Home', 'Systemlog', 'authorize', '', 1, 1, '权限管理', NULL, '', 0);
INSERT INTO `menu` VALUES (80, 79, 'Home', 'Systemlog', 'authorize_post', '', 1, 1, '权限更新', NULL, '', 0);
INSERT INTO `menu` VALUES (81, 1, 'Home', 'Index', 'index', '', 1, 1, '首页展示', NULL, '', 0);
INSERT INTO `menu` VALUES (84, 39, 'Home', 'Systemlog', 'usergroup_house', '', 1, 1, '分配机房列表', NULL, '', 0);
INSERT INTO `menu` VALUES (85, 39, 'Home', 'Systemlog', 'usergroup_house_edit', '', 1, 1, '分配机房', NULL, '', 0);
INSERT INTO `menu` VALUES (86, 3, 'Home', 'Policy', 'illegal_manage', '', 1, 1, '违法管理指令执行记录指令', NULL, '', 0);
INSERT INTO `menu` VALUES (87, 3, 'Home', 'Policy', 'code_table', '', 1, 1, '代码表发布', NULL, '', 0);
INSERT INTO `menu` VALUES (88, 6, 'Home', 'Systemlog', 'ntf_config', '', 1, 1, 'NTP服务配置', NULL, '', 0);
INSERT INTO `menu` VALUES (89, 88, 'Home', 'Systemlog', 'ntf_config_del', '', 1, 1, 'NTP服务配置删除', NULL, '', 0);
INSERT INTO `menu` VALUES (90, 88, 'Home', 'Systemlog', 'setSysdate', '', 1, 1, 'NTP服务配置添加/修改', NULL, '', 0);
INSERT INTO `menu` VALUES (91, 9, 'Home', 'Basicinfo', 'importUser', '', 1, 1, '用户导入', NULL, '', 0);
INSERT INTO `menu` VALUES (92, 6, 'Home', 'Systemlog', 'backlist', '', 1, 1, '数据备份', NULL, '', 0);
INSERT INTO `menu` VALUES (93, 92, 'Home', 'Systemlog', 'backups', '', 1, 1, '数据备份添加', NULL, '', 0);
INSERT INTO `menu` VALUES (94, 92, 'Home', 'Systemlog', 'restore', '', 1, 1, '数据备份还原', NULL, '', 0);
INSERT INTO `menu` VALUES (95, 92, 'Home', 'Systemlog', 'backDel', '', 1, 1, '数据备份删除', NULL, '', 0);
INSERT INTO `menu` VALUES (96, 2, 'Home', 'Basic', 'room_ip', '', 1, 1, '机房IP域名关系', NULL, '', 0);

-- ----------------------------
-- Table structure for policy_access_query
-- ----------------------------
DROP TABLE IF EXISTS `policy_access_query`;
CREATE TABLE `policy_access_query`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健',
  `commandid` bigint(20) NOT NULL COMMENT '指令id',
  `idc_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '经营单位id',
  `house_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房id',
  `start_time` int(10) NOT NULL COMMENT '查询起始时间',
  `end_time` int(10) NULL DEFAULT NULL COMMENT '查询结束时间',
  `src_start_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '源IP起始IP',
  `src_end_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '源IP结束IP',
  `dst_start_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目的IP起始IP',
  `dst_end_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目的IP结束IP',
  `src_port` int(5) NULL DEFAULT NULL COMMENT '源端口',
  `dst_port` int(5) NULL DEFAULT NULL COMMENT '目的端口',
  `protocol` tinyint(1) NULL DEFAULT NULL COMMENT '1 TCP, 2 UDP',
  `url` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'URL',
  `timestamp` int(10) NOT NULL COMMENT '指令生成时间',
  `source` tinyint(1) NOT NULL COMMENT '0 SMMS 1本地策略',
  `status` tinyint(1) NOT NULL COMMENT '指令状态：1下发中，2下发成功，3查询条件错误，4DU解析错误，5DU系统繁忙，6其他错误，7下发失败',
  `result` tinyint(1) NULL DEFAULT NULL COMMENT '日志上报结果，默认空 1等待DU返回结果，2DU返回查询结果，3DU未查询到结果，4DU上传失败，5.DU返回其他错误',
  `record_num` int(10) NULL DEFAULT NULL COMMENT '上报日志总条数目数',
  `file_number` int(10) NULL DEFAULT NULL COMMENT '返回文件个数',
  `ftp_path` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '包含服务器绝对路径，文件名等信息',
  `upload_status` tinyint(1) NULL DEFAULT NULL COMMENT '0未上报， 1已上报',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '访问日志查询指令表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for policy_active_period
-- ----------------------------
DROP TABLE IF EXISTS `policy_active_period`;
CREATE TABLE `policy_active_period`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `prov_id` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '省份编号',
  `house_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房id',
  `report_time` int(10) NOT NULL COMMENT '上报周期(分钟)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '活跃资源周期指令表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of policy_active_period
-- ----------------------------
INSERT INTO `policy_active_period` VALUES (1, '900', '10001', 1);
INSERT INTO `policy_active_period` VALUES (2, '900', '10000', 5);

-- ----------------------------
-- Table structure for policy_active_view
-- ----------------------------
DROP TABLE IF EXISTS `policy_active_view`;
CREATE TABLE `policy_active_view`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健',
  `commandid` bigint(20) NOT NULL COMMENT '指令id',
  `idc_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'idc/isp许可证号',
  `type` tinyint(1) NOT NULL COMMENT '1顶级域名，2子域名',
  `content` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '查询内容',
  `end_time` int(10) NOT NULL COMMENT '查询截止时间',
  `timestamp` int(10) NOT NULL COMMENT '指令生成时间',
  `view` bigint(1) NULL DEFAULT NULL COMMENT '访问量，默认空',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '活跃资源访问量查询表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for policy_basic_codelist
-- ----------------------------
DROP TABLE IF EXISTS `policy_basic_codelist`;
CREATE TABLE `policy_basic_codelist`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `commandId` bigint(20) NOT NULL,
  `jrfs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dwsx` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zjlx` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jfxz` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dllx` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fwnr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gzlx` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wfwgqk` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `timestamp` int(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for policy_basic_commandrecord
-- ----------------------------
DROP TABLE IF EXISTS `policy_basic_commandrecord`;
CREATE TABLE `policy_basic_commandrecord`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `commandId` bigint(20) UNSIGNED NOT NULL,
  `idcId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `controlsId` bigint(20) UNSIGNED NOT NULL,
  `timestamp` int(10) NOT NULL,
  `view` bigint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for policy_basic_data
-- ----------------------------
DROP TABLE IF EXISTS `policy_basic_data`;
CREATE TABLE `policy_basic_data`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健',
  `commandid` bigint(20) NOT NULL COMMENT '指令id',
  `type` tinyint(1) NOT NULL COMMENT '0查询基础数据，1保留，2保留，3查询基础数据监测异常',
  `start_time` int(10) NULL DEFAULT NULL COMMENT '查询基础数据起始日',
  `end_time` int(10) NULL DEFAULT NULL COMMENT '查询基础数据结束日',
  `idc_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IDS/ISP许可证号',
  `user_id` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '用户id，-1表示不查询，多个之前使用半角逗号分割',
  `house_id` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '机房id，-1表示不查询，多个之间使用半角逗号分隔',
  `timestamp` int(10) NOT NULL COMMENT '生成指令时间',
  `report` tinyint(1) NOT NULL COMMENT '上报结果 0未上报，1已上报',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '基础数据查询指令表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for policy_basic_return
-- ----------------------------
DROP TABLE IF EXISTS `policy_basic_return`;
CREATE TABLE `policy_basic_return`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健',
  `idc_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '经营者id',
  `return_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '退回原因',
  `return_msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退回原因说明',
  `return_stamp` int(10) NOT NULL COMMENT '退回时间',
  `operation_time` int(10) NULL DEFAULT NULL COMMENT '处理时间',
  `operation_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理人',
  `operation_type` tinyint(1) NOT NULL DEFAULT 0 COMMENT '处理状态 0未处理，1已处理',
  `is_return` tinyint(1) NOT NULL COMMENT '0无，1有',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '基础数据核验处理指令' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for policy_black_list
-- ----------------------------
DROP TABLE IF EXISTS `policy_black_list`;
CREATE TABLE `policy_black_list`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健',
  `commandid` bigint(20) NOT NULL COMMENT '指令id',
  `idc_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'IDC/ISP许可证号',
  `operationtype` tinyint(1) NOT NULL COMMENT '0新增 ，2删除',
  `type` tinyint(1) NOT NULL COMMENT '1域名，2IP',
  `contents` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '具体的域名或者IP地址',
  `level` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指令优先级',
  `timestamp` int(10) NOT NULL COMMENT '指令生成时间',
  `source` tinyint(1) NOT NULL COMMENT '0SMMS下发，1本地配置',
  `owner` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '添加人账号，如果来自SMMS则添加SMMS即可，本地添加填写当前登录用户',
  `status` tinyint(1) NOT NULL COMMENT '指令状态：1下发中，2下发成功，3下发失败，4借口不同，5取消中，6取消成功，7取消失败，8未回复ack',
  `house_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '违法网站列表指令表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of policy_black_list
-- ----------------------------
INSERT INTO `policy_black_list` VALUES (1, 7, 'BJ_001', 0, 1, 'baidu.com', '100001000000', 1576746339, 1, 'admin', 2, '10001');
INSERT INTO `policy_black_list` VALUES (2, 8, 'BJ_001', 0, 1, 'sohu.com', '100001000000', 1576748872, 1, 'admin', 2, '10001');

-- ----------------------------
-- Table structure for policy_isms
-- ----------------------------
DROP TABLE IF EXISTS `policy_isms`;
CREATE TABLE `policy_isms`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增，用于关联规则表',
  `commandid` bigint(20) NOT NULL COMMENT '指令id',
  `type` tinyint(1) NOT NULL COMMENT '1监测 2过滤',
  `reason` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '过滤原因，只对过滤策略有效',
  `log_flag` tinyint(1) NOT NULL COMMENT '0不记录日志，1记录日志',
  `report_flag` tinyint(1) NOT NULL COMMENT '0不上传日志，1上次日志',
  `effect_time` int(10) NOT NULL COMMENT '生效时间年月日时分秒',
  `expired_time` int(10) NOT NULL COMMENT '失效时间年月日时分秒',
  `idc_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IDC/ISP许可证号',
  `house_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生效的机房id，使用半角逗号分隔，全部机房生效时不添加',
  `owner` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指令属主，下发策略的用户名',
  `visible` tinyint(1) NOT NULL COMMENT '0不可读，1刻度',
  `operationtype` tinyint(1) NOT NULL COMMENT '0新增，1删除',
  `level` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指令优先级',
  `timestamp` int(10) NOT NULL COMMENT '指令生成时间',
  `source` tinyint(1) NOT NULL COMMENT '0 SMMS下发，1 本地配置',
  `status` tinyint(1) NOT NULL COMMENT '指令状态：1下发中，2下发成功，3下发失败，4接口不通，5取消中，6取消成功，7取消失败，8未回复ACK',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `commandid`(`commandid`) USING BTREE,
  INDEX `status`(`status`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '信息安全管理指令表 - 策略表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of policy_isms
-- ----------------------------
INSERT INTO `policy_isms` VALUES (1, 5, 1, NULL, 1, 1, 1576684800, 1577721600, 'BJ_001', '10001', 'admin', 1, 0, '111001000000', 1576739645, 1, 2);

-- ----------------------------
-- Table structure for policy_isms_execute
-- ----------------------------
DROP TABLE IF EXISTS `policy_isms_execute`;
CREATE TABLE `policy_isms_execute`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主健自增',
  `commandid` bigint(20) NOT NULL COMMENT '指令id',
  `idc_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'idc/isp许可证号',
  `controlsId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '要查询的指令id',
  `timestamp` int(10) NOT NULL COMMENT '指令生成时间',
  `count` bigint(20) NOT NULL COMMENT '指令累计计数，默认空',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '违法管理指令执行记录查询指令' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for policy_no_filter
-- ----------------------------
DROP TABLE IF EXISTS `policy_no_filter`;
CREATE TABLE `policy_no_filter`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健',
  `commandid` bigint(20) NOT NULL COMMENT '指令id',
  `idc_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'IDC/ISP许可证号',
  `operationtype` tinyint(1) NOT NULL COMMENT '0新增，1删除',
  `type` tinyint(1) NOT NULL COMMENT '1域名，2IP',
  `contents` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '具体的域名或IP地址',
  `level` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '指令优先级',
  `timestamp` int(10) NOT NULL COMMENT '指令生成时间',
  `source` tinyint(1) NOT NULL COMMENT '0SMMS下发，1本地配置',
  `owner` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '添加人账号，如果来自SMMS，则添加SMMS即可，本地添加填写当前登录用户',
  `status` tinyint(1) NOT NULL COMMENT '指令状态：1下发中，2下发成功，3下发失败，4借口不同，5取消中，6取消成功，7取消失败，8未回复ack',
  `house_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '免过滤网站指令表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of policy_no_filter
-- ----------------------------
INSERT INTO `policy_no_filter` VALUES (1, 2, 'BJ_001', 0, 1, 'www.123.com', '101001000000', 1576736588, 1, 'admin', 8, '10001');
INSERT INTO `policy_no_filter` VALUES (2, 3, 'BJ_001', 0, 1, 'www.999.com', '101001000000', 1576737213, 1, 'admin', 8, '10001');
INSERT INTO `policy_no_filter` VALUES (3, 4, 'BJ_001', 0, 1, 'www.123.com', '101001000000', 1576737431, 1, 'admin', 2, '10001');

-- ----------------------------
-- Table structure for policy_return_housedata
-- ----------------------------
DROP TABLE IF EXISTS `policy_return_housedata`;
CREATE TABLE `policy_return_housedata`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健',
  `house_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机房id',
  `gateway_id` bigint(20) NULL DEFAULT NULL COMMENT '链路id',
  `ip_seg_id` bigint(20) NULL DEFAULT NULL COMMENT 'IP段id',
  `frame_info_id` bigint(20) NULL DEFAULT NULL COMMENT '机架信息',
  `basic_return_info_id` bigint(20) NULL DEFAULT NULL COMMENT '退回数据id。对应policy_basic_return中的id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '退回机房数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for policy_return_userdata
-- ----------------------------
DROP TABLE IF EXISTS `policy_return_userdata`;
CREATE TABLE `policy_return_userdata`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主健',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `service_id` bigint(20) NULL DEFAULT NULL COMMENT '应用服务id',
  `service_domain_id` bigint(20) NULL DEFAULT NULL COMMENT '应用服务的域名id',
  `service_hh_id` bigint(20) NULL DEFAULT NULL COMMENT '应用服务占用机房id',
  `hh_id` bigint(20) NULL DEFAULT NULL COMMENT '占用机房信息id',
  `basic_return_info_id` bigint(20) NULL DEFAULT NULL COMMENT '退回数据id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '退回用户数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for report_result
-- ----------------------------
DROP TABLE IF EXISTS `report_result`;
CREATE TABLE `report_result`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `data_type` int(10) UNSIGNED NOT NULL,
  `result_code` int(10) UNSIGNED NOT NULL,
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `timestamp` int(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for seting_config
-- ----------------------------
DROP TABLE IF EXISTS `seting_config`;
CREATE TABLE `seting_config`  (
  `config_flag` tinyint(1) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`config_flag`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for seting_ntp
-- ----------------------------
DROP TABLE IF EXISTS `seting_ntp`;
CREATE TABLE `seting_ntp`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ntp_server_ip` char(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'ntp服务器IP',
  `port` int(10) NOT NULL COMMENT '端口：默认123',
  `syn_freq` int(10) NOT NULL COMMENT '同步频率，单位：分钟',
  `state` tinyint(1) NOT NULL COMMENT '状态 0：正常 ；1：异常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for seting_state
-- ----------------------------
DROP TABLE IF EXISTS `seting_state`;
CREATE TABLE `seting_state`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `smms_state` int(16) UNSIGNED NOT NULL DEFAULT 0,
  `ftp_state` int(10) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for setting_cu
-- ----------------------------
DROP TABLE IF EXISTS `setting_cu`;
CREATE TABLE `setting_cu`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `report_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上报模块IP地址',
  `report_ftp_port` int(5) NULL DEFAULT NULL COMMENT '上报模块ftp服务端口',
  `es_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ES模块IP地址',
  `es_port` int(5) NULL DEFAULT NULL COMMENT 'ES数据库端口',
  `es_ftp_port` int(5) NULL DEFAULT NULL COMMENT 'ES模块ftp服务端口',
  `es_device_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'CU系统配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of setting_cu
-- ----------------------------
INSERT INTO `setting_cu` VALUES (1, '10.84.1.20', 21, '10.84.1.20', 9200, 21, '10.84.1.20');

-- ----------------------------
-- Table structure for setting_du
-- ----------------------------
DROP TABLE IF EXISTS `setting_du`;
CREATE TABLE `setting_du`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_passwd` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户口令',
  `authentication_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息认证秘钥',
  `is_encrypt` tinyint(1) NULL DEFAULT NULL COMMENT '0不加密，1加密',
  `aes_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加密秘钥',
  `aes_offset` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '秘钥偏移量',
  `hash_method` tinyint(1) NULL DEFAULT NULL COMMENT '哈希算法，1无哈希，2MD5，3SHA-1',
  `is_zip` tinyint(1) NULL DEFAULT NULL COMMENT '0无压缩，1zip压缩格式',
  `version` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口版本方法',
  `prov_id` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份编号',
  `webservice_addr` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'DU的webservice接口地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'DU参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for setting_es_nodes
-- ----------------------------
DROP TABLE IF EXISTS `setting_es_nodes`;
CREATE TABLE `setting_es_nodes`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '一个ES节点logstash接听的IP',
  `port` int(5) NOT NULL COMMENT '一个ES节点logstash接听的端口',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'ES集群配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of setting_es_nodes
-- ----------------------------
INSERT INTO `setting_es_nodes` VALUES (1, '10.84.1.20', 5000);

-- ----------------------------
-- Table structure for setting_eu
-- ----------------------------
DROP TABLE IF EXISTS `setting_eu`;
CREATE TABLE `setting_eu`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_passwd` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户口令',
  `authentication_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息认证秘钥',
  `is_encrypt` tinyint(1) NOT NULL COMMENT '0不加密，1加密',
  `aes_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '加密秘钥',
  `aes_offset` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '秘钥偏移量',
  `hash_method` tinyint(1) NOT NULL COMMENT '哈希算法 0无哈希，1MD5，2SHA-1',
  `is_zip` tinyint(1) NOT NULL COMMENT '0无压缩，1.zip压缩格式',
  `version` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接口版本方法',
  `prov_id` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '省份编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'EU参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of setting_eu
-- ----------------------------
INSERT INTO `setting_eu` VALUES (1, '999999', 'aaaaaa', 1, '1234567890123456', '1234567890123456', 1, 1, 'v2.0', '900');

-- ----------------------------
-- Table structure for setting_smms
-- ----------------------------
DROP TABLE IF EXISTS `setting_smms`;
CREATE TABLE `setting_smms`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_passwd` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户口令',
  `authentication_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息认证秘钥',
  `is_encrypt` tinyint(1) NOT NULL COMMENT '2不加密，3加密',
  `aes_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '加密秘钥',
  `aes_offset` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '秘钥偏移量',
  `hash_method` tinyint(1) NOT NULL COMMENT '哈希算法，0无哈希，1MD5，2SHA-1',
  `is_zip` tinyint(1) NOT NULL COMMENT '0无压缩，1zip压缩格式',
  `version` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接口版本方法',
  `ftp_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'SMMS提供上班的ftp地址',
  `ftp_port` int(5) NOT NULL COMMENT 'SMMS的ftp服务端口',
  `ftp_path` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'SMMS的ftp上报路径',
  `ftp_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'SMMS的ftp用户名',
  `ftp_passwd` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'SMMS的ftp密码',
  `webservice_addr` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'SMMS的webservice接口地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'SMMS参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆名',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `opt_content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `client_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户端ip',
  `create_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'CURRENT_TIMESTAMP' COMMENT '创建时间',
  `before_operation` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `after_operation` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `countyId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deviceCode` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作类型 1:删除 2:新增 3:更新 4：查询',
  `opt_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作名称',
  `opt_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作结果状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1553 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1548, 'test', NULL, '用户登录', '127.0.0.1', '1577417821', '', '', NULL, '5', '', NULL);
INSERT INTO `sys_log` VALUES (1549, 'test', NULL, '用户登录', '127.0.0.1', '1577417830', '', '', NULL, '5', '', NULL);
INSERT INTO `sys_log` VALUES (1550, 'test', NULL, '用户登录', '127.0.0.1', '1577417837', '', '', NULL, '5', '', NULL);
INSERT INTO `sys_log` VALUES (1551, 'admin', NULL, '用户登录', '127.0.0.1', '1577418076', '', '', NULL, '5', '', NULL);
INSERT INTO `sys_log` VALUES (1552, 'admin', NULL, '用户登录', '127.0.0.1', '1577418141', '', '', NULL, '5', '', NULL);

-- ----------------------------
-- Table structure for t_sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_resource`;
CREATE TABLE `t_sys_resource`  (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `resource_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `resource_href` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源的路径',
  `resource_image` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源图片的路径',
  `resource_type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源类型 1：菜单 2：按钮 3：链接',
  `resource_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源描述',
  `resource_remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源备注',
  `is_active` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '是否可用 1：可用 0：不可用',
  `sort_index` int(11) NULL DEFAULT NULL COMMENT '排序索引 ',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父节点id',
  `is_leaf` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否为叶子节点1:是叶子 0：不是叶子节点',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `temp_one` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用字段 资源编码',
  PRIMARY KEY (`resource_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role`  (
  `role_id` int(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `desp` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_at` datetime(0) NULL DEFAULT NULL,
  `updated_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updated_at` datetime(0) NULL DEFAULT NULL,
  `is_active` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1',
  `role_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES (1, 'admin', '', NULL, NULL, NULL, NULL, '1', NULL);
INSERT INTO `t_sys_role` VALUES (2, 'uuu', '', NULL, NULL, NULL, NULL, '1', NULL);

-- ----------------------------
-- Table structure for t_sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_resource`;
CREATE TABLE `t_sys_role_resource`  (
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`, `resource_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1',
  `type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户类型',
  `company_id` int(20) NULL DEFAULT NULL,
  `login_error_num` int(2) NULL DEFAULT 0,
  `whiteState` int(2) NULL DEFAULT 0 COMMENT '开启白名单状态 0不开启 1开启',
  `user_type` int(32) NULL DEFAULT NULL COMMENT '用户类型 0超级管理员 1管理员 2操作用户',
  `last_login_time` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后登录时间',
  `map_lng` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地图经度',
  `map_lat` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地图纬度',
  `map_level` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地图级别',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES (1, 'admin', 'c0abcbcaed4066350c559f42745cee257e68f33eaf3b2bab871473a1', '18823455432', 'asa@163.com', '2', '0', NULL, 0, 0, 0, '1577418141', NULL, NULL, NULL, '2018-10-29 14:16:43');

-- ----------------------------
-- Table structure for t_sys_user_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_resource`;
CREATE TABLE `t_sys_user_resource`  (
  `user_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `resource_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role`  (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(20) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_sys_user_role
-- ----------------------------
INSERT INTO `t_sys_user_role` VALUES (2, 2);
INSERT INTO `t_sys_user_role` VALUES (43, 3);
INSERT INTO `t_sys_user_role` VALUES (53, 3);
INSERT INTO `t_sys_user_role` VALUES (55, 3);
INSERT INTO `t_sys_user_role` VALUES (58, 3);
INSERT INTO `t_sys_user_role` VALUES (59, 3);
INSERT INTO `t_sys_user_role` VALUES (70, 2);
INSERT INTO `t_sys_user_role` VALUES (71, 2);
INSERT INTO `t_sys_user_role` VALUES (72, 2);

SET FOREIGN_KEY_CHECKS = 1;
