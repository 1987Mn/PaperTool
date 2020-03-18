/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : papertools

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-03-18 10:34:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_clbum`
-- ----------------------------
DROP TABLE IF EXISTS `t_clbum`;
CREATE TABLE `t_clbum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clbumName` varchar(10) DEFAULT NULL,
  `major` varchar(15) DEFAULT NULL,
  `nianji` int(4) DEFAULT NULL,
  `peopleNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_clbum
-- ----------------------------

-- ----------------------------
-- Table structure for `t_exam`
-- ----------------------------
DROP TABLE IF EXISTS `t_exam`;
CREATE TABLE `t_exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paperId` int(11) DEFAULT NULL,
  `clbumId` int(11) DEFAULT NULL,
  `testDate` datetime DEFAULT NULL,
  `clbumRoom` varchar(20) DEFAULT NULL,
  `peopleNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `exam_clbum` (`clbumId`),
  KEY `exam_paper` (`paperId`),
  CONSTRAINT `t_exam_ibfk_1` FOREIGN KEY (`clbumId`) REFERENCES `t_clbum` (`id`),
  CONSTRAINT `t_exam_ibfk_2` FOREIGN KEY (`paperId`) REFERENCES `t_paper` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_exam
-- ----------------------------

-- ----------------------------
-- Table structure for `t_grade`
-- ----------------------------
DROP TABLE IF EXISTS `t_grade`;
CREATE TABLE `t_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `smallQuestionId` int(11) DEFAULT NULL,
  `examId` int(11) DEFAULT NULL,
  `studentId` char(15) DEFAULT NULL,
  `totalPoint` double DEFAULT NULL,
  `scorePoint1` double DEFAULT NULL,
  `scorePoint2` double DEFAULT NULL,
  `scorePoint3` double DEFAULT NULL,
  `scorePoint4` double DEFAULT NULL,
  `scorePoint5` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `grade_stu` (`studentId`),
  KEY `grade_sq` (`smallQuestionId`),
  KEY `grade_exam` (`examId`),
  CONSTRAINT `t_grade_ibfk_1` FOREIGN KEY (`examId`) REFERENCES `t_exam` (`id`),
  CONSTRAINT `t_grade_ibfk_2` FOREIGN KEY (`smallQuestionId`) REFERENCES `t_smallquestion` (`id`),
  CONSTRAINT `t_grade_ibfk_3` FOREIGN KEY (`studentId`) REFERENCES `t_student` (`sId`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grade
-- ----------------------------

-- ----------------------------
-- Table structure for `t_paper`
-- ----------------------------
DROP TABLE IF EXISTS `t_paper`;
CREATE TABLE `t_paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(40) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  `courseNum` varchar(15) DEFAULT NULL,
  `college` varchar(15) DEFAULT NULL,
  `teacher` varchar(40) DEFAULT NULL,
  `classAMajor` varchar(20) DEFAULT NULL,
  `testNum` char(2) DEFAULT NULL,
  `testTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `testWay` char(5) DEFAULT NULL,
  `questionNum` int(11) DEFAULT NULL,
  `smallQuestionNum` int(11) DEFAULT NULL,
  `totalPoints` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_paper
-- ----------------------------

-- ----------------------------
-- Table structure for `t_question`
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paperId` int(11) NOT NULL,
  `content` varchar(40) DEFAULT NULL,
  `score` double(10,0) DEFAULT NULL,
  `smallQuestionNum` int(11) DEFAULT NULL,
  `content1` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `question_paper` (`paperId`),
  CONSTRAINT `t_question_ibfk_1` FOREIGN KEY (`paperId`) REFERENCES `t_paper` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_question
-- ----------------------------

-- ----------------------------
-- Table structure for `t_smallquestion`
-- ----------------------------
DROP TABLE IF EXISTS `t_smallquestion`;
CREATE TABLE `t_smallquestion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questionId` int(11) NOT NULL,
  `content` varchar(40) DEFAULT NULL,
  `score` double(10,0) DEFAULT NULL,
  `scorePointNum` int(11) DEFAULT NULL,
  `scorePoint1` double(10,0) DEFAULT NULL,
  `scorePoint2` double(10,0) DEFAULT NULL,
  `scorePoint3` double(10,0) DEFAULT NULL,
  `scorePoint4` double(10,0) DEFAULT NULL,
  `scorePoint5` double(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `squestion_question` (`questionId`),
  CONSTRAINT `t_smallquestion_ibfk_1` FOREIGN KEY (`questionId`) REFERENCES `t_question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=338 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_smallquestion
-- ----------------------------

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `sId` char(15) NOT NULL,
  `clbumId` int(11) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`sId`),
  KEY `student_clbum` (`clbumId`),
  CONSTRAINT `t_student_ibfk_1` FOREIGN KEY (`clbumId`) REFERENCES `t_clbum` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
