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

 Date: 25/08/2020 23:32:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_testcase_api
-- ----------------------------
DROP TABLE IF EXISTS `t_testcase_api`;
CREATE TABLE `t_testcase_api`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `env_id` bigint(12) NULL DEFAULT NULL COMMENT '环境id',
  `before_excs` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '前置执行器',
  `project_id` bigint(11) NOT NULL,
  `timout_time` bigint(11) NULL DEFAULT NULL COMMENT '超时时间，单位分',
  `fail_continue` int(2) NULL DEFAULT 0 COMMENT '失败了是否继续0：不继续，1：继续',
  `flags` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '标签',
  `params` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '业务名参数',
  `case_vars` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '用例内部参数',
  `case_type` int(2) NULL DEFAULT 1 COMMENT '1,用例、2：业务',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'system',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'system',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `project_id`(`project_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
