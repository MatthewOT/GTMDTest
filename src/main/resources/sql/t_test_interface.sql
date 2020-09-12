/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : rabbit

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 25/08/2020 23:47:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_test_interface
-- ----------------------------
DROP TABLE IF EXISTS `t_test_interface`;
CREATE TABLE `t_test_interface`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '接口名称',
  `business_id` bigint(11) NULL DEFAULT NULL COMMENT '业务流id',
  `business_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '业务流名称',
  `project_id` bigint(11) NOT NULL DEFAULT 0 COMMENT '项目id',
  `type` int(2) NOT NULL DEFAULT 0 COMMENT '类型 0公共接口  业务流接口',
  `status` int(2) NOT NULL DEFAULT 0 COMMENT '状态 0启用 1禁用',
  `remark` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'system' COMMENT 'createBy',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
  `sort` int(10) NULL DEFAULT 0 COMMENT '排序',
  `update_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'system' COMMENT 'updateBy',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'updateTime',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'ui自动化测试计划日志' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
