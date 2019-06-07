/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.28 : Database - hsmt
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hsmt` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hsmt`;

/*Table structure for table `areabox` */

DROP TABLE IF EXISTS `areabox`;

CREATE TABLE `areabox` (
  `id` int(10) DEFAULT NULL,
  `value_field` varchar(10) DEFAULT NULL,
  `text_field` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `areabox` */

insert  into `areabox`(`id`,`value_field`,`text_field`) values (1,'高中','高中'),(2,'大专','大专'),(3,'中专','中专'),(4,'本科','本科'),(5,'研究生','研究生'),(6,'博士','博士'),(7,'技校','技校');

/*Table structure for table `client` */

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `client_id` int(10) DEFAULT NULL COMMENT '客户编号',
  `client_name` varchar(10) DEFAULT NULL COMMENT '客户名字',
  `client_age` int(10) DEFAULT NULL COMMENT '客户年龄',
  `client_number` int(11) DEFAULT NULL COMMENT '客户电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `client` */

insert  into `client`(`id`,`client_id`,`client_name`,`client_age`,`client_number`) values (1,1,'巩旭辉',23,2147483647),(2,2,'小白',40,2147483647),(3,3,'大白',30,2147483647),(4,4,'路飞',20,2147483647),(5,5,'鹰眼',50,2147483647),(6,6,'名人',30,2147483647),(7,7,'佐助',30,2147483647),(8,8,'knight',40,2147483647),(9,9,'娜美',18,2147483647),(10,10,'小樱',18,2147483647);

/*Table structure for table `depart_group` */

DROP TABLE IF EXISTS `depart_group`;

CREATE TABLE `depart_group` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `depart_id` int(10) DEFAULT NULL,
  `group_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `depart_group` */

insert  into `depart_group`(`id`,`depart_id`,`group_id`) values (1,2,1),(2,2,2),(3,2,3),(4,3,4),(5,3,5),(6,4,6),(7,5,7),(8,5,8),(9,5,9),(10,5,10);

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `emp_id` varchar(10) NOT NULL,
  `emp_name` varchar(20) DEFAULT NULL,
  `emp_age` int(10) DEFAULT NULL,
  `emp_sex` varchar(10) DEFAULT NULL,
  `emp_hiredate` varchar(10) DEFAULT NULL,
  `emp_area` varchar(20) DEFAULT NULL,
  `emp_level` varchar(20) DEFAULT NULL,
  `emp_salary` int(10) DEFAULT NULL,
  `emp_group` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`emp_id`,`emp_name`,`emp_age`,`emp_sex`,`emp_hiredate`,`emp_area`,`emp_level`,`emp_salary`,`emp_group`) values ('12321','巩小辉',11,'男','2016-04-06','中专','高级工程师',985,'配置管理组'),('123987','王甜甜',78,'女','1899-11-30','研究生','部门经理',10780,'项目组'),('1321','阿力',30,'男','2016-04-06','中专','中级工程师',3000,'质量体系组'),('1328','发斯蒂芬',33,'女','2016-04-05','中专','中级工程师',8989,'质量体系组'),('150166','周小全',36,'男','2016-04-11','大专','部门组长',7000,'配置管理组'),('189','大个',23,'男','2016-03-24','大专','中级工程师',231,'商务组'),('227979','王夏利',96,'男','2016-04-11','大专','部门组长',9999,'配置管理组'),('3','小同',58,'男','1899-11-30','大专','初级工程师',1321,'人事行政组'),('351610','王璐璐',23,'男','2016-04-12','本科','部门组长',5632,'销售组'),('5647','123456',78,'女','1899-11-30','本科','高级工程师',1234,'配置管理组'),('5689','巩旭辉',89,'女','2016-04-06','本科','高级工程师',985,'配置管理组'),('6','小白',45,'男','2016-03-24','本科','初级工程师',1321,'人事行政组'),('664','供需胡',23,'女','2016-03-30','本科','高级工程师',9630,'合同管理组'),('675756','巩亚伟',11,'男','2016-04-11','本科','中级工程师',1321,'销售组'),('7','事的',14,'男','2016-03-22','本科','初级工程师',1321,'人事行政组'),('714106','巩旭辉',131,'男','2016-04-11','本科','中级工程师',11,'销售组'),('760781','巩旭辉',23,'男','2016-04-13','本科','部门组长',5560,'测试组'),('763903','巩旭辉',79,'女','2016-04-11','本科','部门组长',13213,'测试组'),('791198','共',65,'女','2016-04-11','本科','部门组长',36541,'技术支持组'),('8','王大力',80,'女','2016-03-24','本科','部门经理',7777,'技术支持组'),('816111','张蒙台',23,'女','2016-04-12','本科','部门组长',1236,'技术支持组'),('851852','乔尖峰',24,'男','2016-04-12','本科','新员工',3654,'技术支持组'),('890','巩旭辉',44,'男','2016-03-24','研究生','中级工程师',7777,'合同管理组'),('897','刘丹莉',11,'男','1899-11-30','研究生','中级工程师',5000,'合同管理组'),('961073','共里',12,'女','2016-03-29','研究生','新员工',1111,'共享开发组'),('BBH269293','白百何',36,'女','2016-05-24','技校','中级工程师',2345,'质量体系组'),('BDD483916','班冬冬',24,'男','2016-05-22','研究生','实习生',4563,'技术支持组'),('GLL90431','巩里龙',25,'男','2016-05-24','技校','初级工程师',1231,'销售组'),('GXH436307','巩小辉',23,'男','2016-05-24','本科','高级工程师',6000,'合同管理组'),('GXH6824','巩旭辉',123,'男','2016-02-09','本科','高级工程师',7899,'共享开发组'),('LDL894281','刘丹莉',24,'女','2016-05-09','研究生','高级工程师',10000,'共享开发组'),('LF687586','李飞',23,'男','2016-05-24','博士','高级工程师',10000,'项目组'),('LHL974674','李海林',27,'男','2016-05-01','大专','初级工程师',2323,'技术支持组'),('LLY26755','李连义',23,'男','2016-05-04','中专','高级工程师',3654,'技术支持组'),('LNN111834','李娜娜',24,'女','2016-05-24','中专','中级工程师',6000,'项目组'),('LXY616022','李逍遥',34,'男','2016-05-24','研究生','高级工程师',8000,'项目组'),('LYY78762','刘英勇',23,'男','2016-05-24','研究生','初级工程师',5000,'项目组'),('SQ965725','商祺',23,'男','2016-05-03','本科','初级工程师',5230,'配置管理组'),('TT644961','天天',23,'女','2016-05-25','高中','实习生',3000,'共享开发组'),('WDL571488','王大力',34,'男','2016-04-19','大专','高级工程师',9875,'人事行政组'),('WLL643390','王路路',23,'男','2016-05-01','本科','中级工程师',6354,'测试组'),('YH241462','杨华',30,'男','2016-05-24','本科','中级工程师',6000,'商务组'),('ZLE643710','赵灵儿',23,'女','2016-05-23','本科','中级工程师',8000,'项目组'),('ZXQ82069','周小全',30,'男','2016-05-24','大专','中级工程师',5000,'共享开发组');

/*Table structure for table `groupbox` */

DROP TABLE IF EXISTS `groupbox`;

CREATE TABLE `groupbox` (
  `id` int(10) DEFAULT NULL,
  `value_field` varchar(10) DEFAULT NULL,
  `text_field` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `groupbox` */

insert  into `groupbox`(`id`,`value_field`,`text_field`) values (NULL,'人事行政组','人事行政组'),(NULL,'商务组','商务组'),(NULL,'合同管理组','合同管理组'),(NULL,'质量体系组','质量体系组'),(NULL,'配置管理组','配置管理组'),(NULL,'销售组','销售组'),(NULL,'测试组','测试组'),(NULL,'技术支持组','技术支持组'),(NULL,'共享开发组','共享开发组'),(NULL,'项目组','项目组');

/*Table structure for table `indent` */

DROP TABLE IF EXISTS `indent`;

CREATE TABLE `indent` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` int(10) DEFAULT NULL COMMENT '订单编号',
  `product_id` int(10) DEFAULT NULL COMMENT '产品编号',
  `order_amount` int(10) DEFAULT NULL COMMENT '订单数量',
  `client_id` int(10) DEFAULT NULL COMMENT '客户编号',
  `order_date` varchar(10) DEFAULT NULL COMMENT '订单时间',
  `order_adress` varchar(10) DEFAULT NULL COMMENT '发货地点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `indent` */

insert  into `indent`(`id`,`order_id`,`product_id`,`order_amount`,`client_id`,`order_date`,`order_adress`) values (1,1,1,22,1,'2015-01-01','华西地区'),(2,2,1,33,1,'2015-02-01','华西地区'),(3,3,2,44,2,'2015-03-01','华北地区'),(4,4,2,55,2,'2015-04-01','华南地区'),(5,5,3,66,3,'2015-05-06','华北地区'),(6,6,4,11,3,'2015-06-06','华东地区'),(7,7,5,88,3,'2015-07-06','华东地区'),(8,8,3,11,4,'2015-08-10','华东地区'),(9,9,4,1,5,'2015-09-01','华东地区'),(10,10,5,2,7,'2015-10-01','华东地区'),(11,11,1,12,1,'2015-11-01','华西地区'),(12,12,1,3,1,'2015-12-01','华西地区'),(13,13,1,4,2,'2014-01-01','华西地区'),(14,14,1,52,3,'2014-02-01','华西地区'),(15,15,1,11,4,'2014-03-01','华西地区'),(16,16,2,21,5,'2014-04-01','华西地区'),(17,17,3,5,6,'2014-05-01','华西地区'),(18,18,4,8,8,'2014-06-01','华西地区'),(19,19,5,7,7,'2014-07-01','华东地区'),(20,20,1,6,9,'2014-08-01','华东地区'),(21,21,2,7,1,'2014-09-01','华东地区'),(22,22,3,6,10,'2014-10-01','华东地区'),(23,23,4,4,3,'2014-11-01','华东地区'),(24,24,1,99,2,'2014-12-01','华北地区'),(25,25,5,5,5,'2013-01-01','华东地区'),(26,26,2,7,4,'2013-02-01','华北地区'),(27,27,3,3,6,'2013-03-01','华北地区'),(28,28,5,7,6,'2013-04-01','华北地区'),(29,29,4,9,7,'2013-05-01','华北地区'),(30,30,1,4,7,'2013-06-01','华北地区'),(31,31,2,8,8,'2013-06-01','华南地区');

/*Table structure for table `levelbox` */

DROP TABLE IF EXISTS `levelbox`;

CREATE TABLE `levelbox` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `value_field` varchar(10) DEFAULT NULL,
  `text_field` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `levelbox` */

insert  into `levelbox`(`id`,`value_field`,`text_field`) values (1,'实习生','实习生'),(2,'初级工程师','初级工程师'),(3,'中级工程师','中级工程师'),(4,'高级工程师','高级工程师'),(5,'部门组长','部门组长'),(6,'部门经理','部门经理');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_id` int(10) DEFAULT NULL COMMENT '产品编号',
  `product_name` varchar(10) DEFAULT NULL COMMENT '产品名字',
  `product_price` int(10) DEFAULT NULL COMMENT '单价',
  `product_stock` int(10) DEFAULT NULL COMMENT '库存量',
  `product_sum` int(10) DEFAULT NULL COMMENT '产品总数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`product_id`,`product_name`,`product_price`,`product_stock`,`product_sum`) values (1,1,'管理软件',10,100,500),(2,2,'统计软件',20,300,500),(3,3,'教育软件',30,152,500),(4,4,'科技软件',21,30,500),(5,5,'手机软件',6,400,500);

/*Table structure for table `t_menu` */

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `mu` int(50) NOT NULL AUTO_INCREMENT,
  `id` int(50) DEFAULT NULL,
  `text` varchar(50) DEFAULT NULL,
  `pid` int(50) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `depart_id` int(10) DEFAULT NULL,
  `group_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`mu`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `t_menu` */

insert  into `t_menu`(`mu`,`id`,`text`,`pid`,`state`,`depart_id`,`group_id`) values (1,1,'华胜鸣天',999,'closed',1,NULL),(2,2,'管理部',1,'closed',2,NULL),(3,3,'质量部',1,'closed',3,NULL),(4,4,'销售部',1,'closed',4,NULL),(5,5,'总工办',1,'closed',5,NULL),(6,6,'人事行政组',2,'open',NULL,1),(7,7,'商务组',2,'open',NULL,2),(8,8,'合同管理组',2,'open',NULL,3),(9,9,'质量体系组',3,'open',NULL,4),(10,10,'配置管理组',3,'open',NULL,5),(11,11,'销售组',4,'open',NULL,6),(12,12,'测试组',5,'open',NULL,7),(13,13,'技术支持组',5,'open',NULL,8),(14,14,'共享开发组',5,'open',NULL,9),(15,15,'项目组',5,'open',NULL,10),(20,16,'老板',1,'open',6,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`) values (1,'gxh','19930402gxh'),(2,'ldl','19920624ldl'),(3,'knight','123456'),(4,'123456','123456');

/*Table structure for table `emp` */

DROP TABLE IF EXISTS `emp`;

/*!50001 DROP VIEW IF EXISTS `emp` */;
/*!50001 DROP TABLE IF EXISTS `emp` */;

/*!50001 CREATE TABLE  `emp`(
 `id` varchar(10) ,
 `name` int(10) 
)*/;

/*Table structure for table `emps` */

DROP TABLE IF EXISTS `emps`;

/*!50001 DROP VIEW IF EXISTS `emps` */;
/*!50001 DROP TABLE IF EXISTS `emps` */;

/*!50001 CREATE TABLE  `emps`(
 `emp_id` varchar(10) ,
 `emp_age` int(10) 
)*/;

/*View structure for view emp */

/*!50001 DROP TABLE IF EXISTS `emp` */;
/*!50001 DROP VIEW IF EXISTS `emp` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `emp` AS select `e`.`emp_id` AS `id`,`e`.`emp_age` AS `name` from `employee` `e` */;

/*View structure for view emps */

/*!50001 DROP TABLE IF EXISTS `emps` */;
/*!50001 DROP VIEW IF EXISTS `emps` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `emps` AS select `e`.`emp_id` AS `emp_id`,`e`.`emp_age` AS `emp_age` from `employee` `e` */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
