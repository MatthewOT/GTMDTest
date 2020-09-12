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

 Date: 25/08/2020 23:48:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_step_api
-- ----------------------------
DROP TABLE IF EXISTS `t_step_api`;
CREATE TABLE `t_step_api`  (
  `id` bigint(18) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '步骤名称',
  `type` int(1) NULL DEFAULT NULL COMMENT '1:api',
  `testcase_id` bigint(18) NOT NULL COMMENT '用例id',
  `source_id` bigint(18) NULL DEFAULT NULL COMMENT 'type为1则为api_id',
  `status` int(2) NOT NULL DEFAULT 1 COMMENT '状态：1启用 0禁用',
  `method` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求类型',
  `domain` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求的协议+域名',
  `path` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求路径',
  `api_params` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'api请求参数',
  `before_excs` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '前置执行器',
  `req_header` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求头',
  `req_query` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求query',
  `req_body_data` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求body from-data格式',
  `req_body_json` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求body json格式',
  `req_body_type` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'raw' COMMENT '请求body的类型',
  `req_extract` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求提取参数',
  `req_assert` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求断言',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `sort` int(8) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `testcase_id`(`testcase_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 169 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
