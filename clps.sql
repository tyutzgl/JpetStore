/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : clps

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-01-22 09:41:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(20) NOT NULL,
  `userid` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `firstname` varchar(80) NOT NULL,
  `lastname` varchar(80) NOT NULL,
  `status` varchar(2) DEFAULT NULL,
  `addr1` varchar(80) NOT NULL,
  `addr2` varchar(40) DEFAULT NULL,
  `city` varchar(80) NOT NULL,
  `state` varchar(80) NOT NULL,
  `zip` varchar(20) NOT NULL,
  `country` varchar(20) NOT NULL,
  `phone` varchar(80) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('9', 'aaaa', '1231', 'aasda', 'Liang', null, '12312', null, '1231', '12312', '1231', '12312', '12312');
INSERT INTO `account` VALUES ('1', 'ACID', 'acid@yourdomain.com', 'ABC', 'XYX', 'OK', '901 San Antonio Road', 'MS UCUP02-206', 'Palo Alto', 'CA', '94303', 'USA', '555-555-5555');
INSERT INTO `account` VALUES ('2', 'j2ee', 'yourname@yourdomain.com', 'ABC', 'XYX', 'OK', '901 San Antonio Road', 'MS UCUP02-206', 'Palo Alto', 'CA', '94303', 'USA', '555-555-5555');

-- ----------------------------
-- Table structure for bannerdata
-- ----------------------------
DROP TABLE IF EXISTS `bannerdata`;
CREATE TABLE `bannerdata` (
  `favcategory` varchar(80) NOT NULL,
  `bannername` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`favcategory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bannerdata
-- ----------------------------
INSERT INTO `bannerdata` VALUES ('BIRDS', '<image src=\"images/banner_birds.gif\">');
INSERT INTO `bannerdata` VALUES ('CATS', '<image src=\"images/banner_cats.gif\">');
INSERT INTO `bannerdata` VALUES ('DOGS', '<image src=\"images/banner_dogs.gif\">');
INSERT INTO `bannerdata` VALUES ('FISH', '<image src=\"images/banner_fish.gif\">');
INSERT INTO `bannerdata` VALUES ('REPTILES', '<image src=\"images/banner_reptiles.gif\">');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `itemid` varchar(10) DEFAULT NULL,
  `userid` varchar(25) DEFAULT NULL,
  `quantity` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item` (`itemid`),
  KEY `userid` (`userid`),
  CONSTRAINT `item` FOREIGN KEY (`itemid`) REFERENCES `item` (`itemid`),
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `signon` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('123', 'EST-10', 'j2ee', '2');
INSERT INTO `cart` VALUES ('124', 'EST-4', 'j2ee', '5');
INSERT INTO `cart` VALUES ('126', 'EST-27', 'j2ee', '1');
INSERT INTO `cart` VALUES ('131', 'EST-4', 'ACID', '1');
INSERT INTO `cart` VALUES ('132', 'EST-14', 'j2ee', '1');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `catid` varchar(10) NOT NULL,
  `name` varchar(80) DEFAULT NULL,
  `descn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`catid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('BIRDS', 'Birds', '<image src=\"images/birds_icon.gif\"><font size=\"5\" color=\"blue\"> Birds</font>');
INSERT INTO `category` VALUES ('CATS', 'Cats', '<image src=\"images/cats_icon.gif\"><font size=\"5\" color=\"blue\"> Cats</font>');
INSERT INTO `category` VALUES ('DOGS', 'Dogs', '<image src=\"images/dogs_icon.gif\"><font size=\"5\" color=\"blue\"> Dogs</font>');
INSERT INTO `category` VALUES ('FISH', 'Fish', '<image src=\"images/fish_icon.gif\"><font size=\"5\" color=\"blue\"> Fish</font>');
INSERT INTO `category` VALUES ('REPTILES', 'Reptiles', '<image src=\"images/reptiles_icon.gif\"><font size=\"5\" color=\"blue\"> Reptiles</font>');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` int(4) NOT NULL AUTO_INCREMENT,
  `dname` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `location` varchar(255) DEFAULT NULL COMMENT '部门位置',
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('10', 'sales', 'hell');
INSERT INTO `dept` VALUES ('20', 'analysis', 'heven');
INSERT INTO `dept` VALUES ('30', 'operation', 'beijing');
INSERT INTO `dept` VALUES ('40', null, null);

-- ----------------------------
-- Table structure for emp1
-- ----------------------------
DROP TABLE IF EXISTS `emp1`;
CREATE TABLE `emp1` (
  `empno` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `ename` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `job` varchar(255) DEFAULT NULL COMMENT '员工职位',
  `salary` int(6) DEFAULT NULL COMMENT '员工薪水',
  `comm` int(6) DEFAULT NULL COMMENT '员工奖金',
  `dept` int(4) DEFAULT NULL COMMENT '员工所属部门',
  `manager` varchar(255) DEFAULT NULL COMMENT '上级的编号',
  PRIMARY KEY (`empno`),
  KEY `emp_ibfk_1` (`dept`),
  CONSTRAINT `FKn0fxoeil521q19dbnw5cvf8gn` FOREIGN KEY (`dept`) REFERENCES `dept` (`deptno`),
  CONSTRAINT `emp1_ibfk_1` FOREIGN KEY (`dept`) REFERENCES `dept` (`deptno`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1014 DEFAULT CHARSET=utf8 COMMENT='员工表';

-- ----------------------------
-- Records of emp1
-- ----------------------------
INSERT INTO `emp1` VALUES ('1001', 'tom', 'ALTER TABLE emp MODIFY sex ENUM(\"男\",\"女\");', '5000', '200', '10', '1010');
INSERT INTO `emp1` VALUES ('1002', 'jack', 'operator', '2500', null, '30', '1005');
INSERT INTO `emp1` VALUES ('1003', 'mary', 'operator', '3000', null, '30', '1005');
INSERT INTO `emp1` VALUES ('1004', 'dan', 'salesman', '3100', '100', '10', '1001');
INSERT INTO `emp1` VALUES ('1005', 'json', 'operator', '3300', null, '30', '1010');
INSERT INTO `emp1` VALUES ('1006', 'mark', 'salesman', '5460', '110', '10', '1001');
INSERT INTO `emp1` VALUES ('1007', 'jerry', 'operator', '3200', null, '30', '1005');
INSERT INTO `emp1` VALUES ('1008', 'steven', 'analist', '5000', null, '20', '1010');
INSERT INTO `emp1` VALUES ('1009', 'carl', 'manager', '6000', null, '20', '1008');
INSERT INTO `emp1` VALUES ('1011', 'tom', 'manager', '3000', '0', null, '1010');
INSERT INTO `emp1` VALUES ('1013', 'zhang', '123', '9000', null, null, '1010');

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `itemid` varchar(10) NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY (`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inventory
-- ----------------------------
INSERT INTO `inventory` VALUES ('EST-1', '10000');
INSERT INTO `inventory` VALUES ('EST-10', '9984');
INSERT INTO `inventory` VALUES ('EST-11', '10000');
INSERT INTO `inventory` VALUES ('EST-12', '10000');
INSERT INTO `inventory` VALUES ('EST-13', '10000');
INSERT INTO `inventory` VALUES ('EST-14', '9998');
INSERT INTO `inventory` VALUES ('EST-15', '10000');
INSERT INTO `inventory` VALUES ('EST-16', '10000');
INSERT INTO `inventory` VALUES ('EST-17', '10000');
INSERT INTO `inventory` VALUES ('EST-18', '10000');
INSERT INTO `inventory` VALUES ('EST-19', '10000');
INSERT INTO `inventory` VALUES ('EST-2', '10000');
INSERT INTO `inventory` VALUES ('EST-20', '10000');
INSERT INTO `inventory` VALUES ('EST-21', '10000');
INSERT INTO `inventory` VALUES ('EST-22', '10000');
INSERT INTO `inventory` VALUES ('EST-23', '10000');
INSERT INTO `inventory` VALUES ('EST-24', '10000');
INSERT INTO `inventory` VALUES ('EST-25', '10000');
INSERT INTO `inventory` VALUES ('EST-26', '10000');
INSERT INTO `inventory` VALUES ('EST-27', '9992');
INSERT INTO `inventory` VALUES ('EST-28', '10000');
INSERT INTO `inventory` VALUES ('EST-3', '10000');
INSERT INTO `inventory` VALUES ('EST-4', '9959');
INSERT INTO `inventory` VALUES ('EST-5', '10000');
INSERT INTO `inventory` VALUES ('EST-6', '10000');
INSERT INTO `inventory` VALUES ('EST-7', '10000');
INSERT INTO `inventory` VALUES ('EST-8', '10000');
INSERT INTO `inventory` VALUES ('EST-9', '10000');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `itemid` varchar(10) NOT NULL,
  `productid` varchar(10) NOT NULL,
  `listprice` decimal(10,2) DEFAULT NULL,
  `unitcost` decimal(10,2) DEFAULT NULL,
  `supplier` int(11) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `attr1` varchar(80) DEFAULT NULL,
  `attr2` varchar(80) DEFAULT NULL,
  `attr3` varchar(80) DEFAULT NULL,
  `attr4` varchar(80) DEFAULT NULL,
  `attr5` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `itemProd` (`productid`),
  KEY `FKl54nt66s2uam75j8m51gutnwu` (`supplier`),
  CONSTRAINT `FK2ltdskt1syqkei1yxj8c1eiug` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`),
  CONSTRAINT `FKl54nt66s2uam75j8m51gutnwu` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`suppid`),
  CONSTRAINT `fk_item_1` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`),
  CONSTRAINT `fk_item_2` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`suppid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('EST-1', 'FI-SW-01', '16.50', '10.00', '1', 'P', 'Large', null, null, null, null);
INSERT INTO `item` VALUES ('EST-10', 'K9-DL-01', '18.50', '12.00', '1', 'P', 'Spotted Adult Female', null, null, null, null);
INSERT INTO `item` VALUES ('EST-11', 'RP-SN-01', '18.50', '12.00', '1', 'P', 'Venomless', null, null, null, null);
INSERT INTO `item` VALUES ('EST-12', 'RP-SN-01', '18.50', '12.00', '1', 'P', 'Rattleless', null, null, null, null);
INSERT INTO `item` VALUES ('EST-13', 'RP-LI-02', '18.50', '12.00', '1', 'P', 'Green Adult', null, null, null, null);
INSERT INTO `item` VALUES ('EST-14', 'FL-DSH-01', '58.50', '12.00', '1', 'P', 'Tailless', null, null, null, null);
INSERT INTO `item` VALUES ('EST-15', 'FL-DSH-01', '23.50', '12.00', '1', 'P', 'With tail', null, null, null, null);
INSERT INTO `item` VALUES ('EST-16', 'FL-DLH-02', '93.50', '12.00', '1', 'P', 'Adult Female', null, null, null, null);
INSERT INTO `item` VALUES ('EST-17', 'FL-DLH-02', '93.50', '12.00', '1', 'P', 'Adult Male', null, null, null, null);
INSERT INTO `item` VALUES ('EST-18', 'AV-CB-01', '193.50', '92.00', '1', 'P', 'Adult Male', null, null, null, null);
INSERT INTO `item` VALUES ('EST-19', 'AV-SB-02', '15.50', '2.00', '1', 'P', 'Adult Male', null, null, null, null);
INSERT INTO `item` VALUES ('EST-2', 'FI-SW-01', '16.50', '10.00', '1', 'P', 'Small', null, null, null, null);
INSERT INTO `item` VALUES ('EST-20', 'FI-FW-02', '5.50', '2.00', '1', 'P', 'Adult Male', null, null, null, null);
INSERT INTO `item` VALUES ('EST-21', 'FI-FW-02', '5.29', '1.00', '1', 'P', 'Adult Female', null, null, null, null);
INSERT INTO `item` VALUES ('EST-22', 'K9-RT-02', '135.50', '100.00', '1', 'P', 'Adult Male', null, null, null, null);
INSERT INTO `item` VALUES ('EST-23', 'K9-RT-02', '145.49', '100.00', '1', 'P', 'Adult Female', null, null, null, null);
INSERT INTO `item` VALUES ('EST-24', 'K9-RT-02', '255.50', '92.00', '1', 'P', 'Adult Male', null, null, null, null);
INSERT INTO `item` VALUES ('EST-25', 'K9-RT-02', '325.29', '90.00', '1', 'P', 'Adult Female', null, null, null, null);
INSERT INTO `item` VALUES ('EST-26', 'K9-CW-01', '125.50', '92.00', '1', 'P', 'Adult Male', null, null, null, null);
INSERT INTO `item` VALUES ('EST-27', 'K9-CW-01', '155.29', '90.00', '1', 'P', 'Adult Female', null, null, null, null);
INSERT INTO `item` VALUES ('EST-28', 'K9-RT-01', '155.29', '90.00', '1', 'P', 'Adult Female', null, null, null, null);
INSERT INTO `item` VALUES ('EST-3', 'FI-SW-02', '18.50', '12.00', '1', 'P', 'Toothless', null, null, null, null);
INSERT INTO `item` VALUES ('EST-4', 'FI-FW-01', '18.50', '12.00', '1', 'P', 'Spotted', null, null, null, null);
INSERT INTO `item` VALUES ('EST-5', 'FI-FW-01', '18.50', '12.00', '1', 'P', 'Spotless', null, null, null, null);
INSERT INTO `item` VALUES ('EST-6', 'K9-BD-01', '18.50', '12.00', '1', 'P', 'Male Adult', null, null, null, null);
INSERT INTO `item` VALUES ('EST-7', 'K9-BD-01', '18.50', '12.00', '1', 'P', 'Female Puppy', null, null, null, null);
INSERT INTO `item` VALUES ('EST-8', 'K9-PO-02', '18.50', '12.00', '1', 'P', 'Male Puppy', null, null, null, null);
INSERT INTO `item` VALUES ('EST-9', 'K9-DL-01', '18.50', '12.00', '1', 'P', 'Spotless Male Puppy', null, null, null, null);

-- ----------------------------
-- Table structure for lineitem
-- ----------------------------
DROP TABLE IF EXISTS `lineitem`;
CREATE TABLE `lineitem` (
  `orderid` int(11) NOT NULL,
  `linenum` int(11) NOT NULL,
  `itemid` varchar(10) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unitprice` decimal(10,2) NOT NULL,
  PRIMARY KEY (`orderid`,`linenum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lineitem
-- ----------------------------
INSERT INTO `lineitem` VALUES ('16', '1', 'EST-10', '2', '18.50');
INSERT INTO `lineitem` VALUES ('16', '2', 'EST-4', '5', '18.50');
INSERT INTO `lineitem` VALUES ('16', '3', 'EST-27', '1', '155.29');
INSERT INTO `lineitem` VALUES ('18', '1', 'EST-10', '2', '18.50');
INSERT INTO `lineitem` VALUES ('18', '2', 'EST-4', '5', '18.50');
INSERT INTO `lineitem` VALUES ('18', '3', 'EST-27', '1', '155.29');
INSERT INTO `lineitem` VALUES ('18', '4', 'EST-14', '1', '58.50');
INSERT INTO `lineitem` VALUES ('19', '1', 'EST-10', '2', '18.50');
INSERT INTO `lineitem` VALUES ('19', '2', 'EST-4', '5', '18.50');
INSERT INTO `lineitem` VALUES ('19', '3', 'EST-27', '1', '155.29');
INSERT INTO `lineitem` VALUES ('19', '4', 'EST-14', '1', '58.50');

-- ----------------------------
-- Table structure for mytable
-- ----------------------------
DROP TABLE IF EXISTS `mytable`;
CREATE TABLE `mytable` (
  `personid` int(4) NOT NULL,
  `personname` varchar(255) NOT NULL,
  KEY `myindex` (`personname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mytable
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(80) NOT NULL,
  `orderdate` date NOT NULL,
  `shipaddr1` varchar(80) NOT NULL,
  `shipaddr2` varchar(80) DEFAULT NULL,
  `shipcity` varchar(80) NOT NULL,
  `shipstate` varchar(80) NOT NULL,
  `shipzip` varchar(20) NOT NULL,
  `shipcountry` varchar(20) NOT NULL,
  `billaddr1` varchar(80) NOT NULL,
  `billaddr2` varchar(80) DEFAULT NULL,
  `billcity` varchar(80) DEFAULT NULL,
  `billstate` varchar(80) DEFAULT NULL,
  `billzip` varchar(20) DEFAULT NULL,
  `billcountry` varchar(20) DEFAULT NULL,
  `courier` varchar(80) DEFAULT NULL,
  `totalprice` decimal(10,2) DEFAULT NULL,
  `billtofirstname` varchar(80) DEFAULT NULL,
  `billtolastname` varchar(80) DEFAULT NULL,
  `shiptofirstname` varchar(80) DEFAULT NULL,
  `shiptolastname` varchar(80) DEFAULT NULL,
  `creditcard` varchar(80) DEFAULT NULL,
  `exprdate` varchar(7) DEFAULT NULL,
  `cardtype` varchar(80) DEFAULT NULL,
  `locale` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('15', 'j2ee', '2018-01-18', '901 San Antonio Road', null, 'Palo Alto', '22', '94303', 'USA', '901 San Antonio Road', null, 'Palo Alto', 'CA', '94303', 'USA', '顺丰速运', '284.79', 'ABC', 'liang', 'ABC', 'liang', '9999 9999 999999', '12/03', '美国运通信用卡', '浦东软件园');
INSERT INTO `orders` VALUES ('16', 'j2ee', '2018-01-18', '901 San Antonio Road', null, 'Palo Alto', '22', '94303', 'USA', '901 San Antonio Road', null, 'Palo Alto', 'CA', '94303', 'USA', '顺丰速运', '284.79', 'ABC', 'liang', 'ABC', 'liang', '9999 9999 999999', '12/03', '美国运通信用卡', '浦东软件园');
INSERT INTO `orders` VALUES ('17', 'ACID', '2018-01-18', '901 San Antonio Road', null, 'Palo Alto', '22', '94303', 'USA', '901 San Antonio Road', null, 'Palo Alto', 'CA', '94303', 'USA', '顺丰速运', '18.50', 'ABC', 'liang', 'ABC', 'liang', '9999 9999 999999', '12/03', '美国运通信用卡', '浦东软件园');
INSERT INTO `orders` VALUES ('18', 'j2ee', '2018-01-19', '901 San Antonio Road', null, 'Palo Alto', '22', '94303', 'USA', '901 San Antonio Road', null, 'Palo Alto', 'CA', '94303', 'USA', '顺丰速运', '343.29', 'ABC', 'liang', 'ABC', 'liang', '9999 9999 999999', '12/03', '美国运通信用卡', '浦东软件园');
INSERT INTO `orders` VALUES ('19', 'j2ee', '2018-01-19', '901 San Antonio Road', null, 'Palo Alto', '22', '94303', 'USA', '901 San Antonio Road', null, 'Palo Alto', 'CA', '94303', 'USA', '顺丰速运', '343.29', 'ABC', 'liang', 'ABC', 'liang', '9999 9999 999999', '12/03', '美国运通信用卡', '浦东软件园');

-- ----------------------------
-- Table structure for orderstatus
-- ----------------------------
DROP TABLE IF EXISTS `orderstatus`;
CREATE TABLE `orderstatus` (
  `orderid` int(11) NOT NULL,
  `linenum` int(11) NOT NULL,
  `timestamp` date NOT NULL,
  `status` varchar(2) NOT NULL,
  PRIMARY KEY (`orderid`,`linenum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderstatus
-- ----------------------------
INSERT INTO `orderstatus` VALUES ('16', '1', '2018-01-18', 'p');
INSERT INTO `orderstatus` VALUES ('17', '1', '2018-01-18', 'p');
INSERT INTO `orderstatus` VALUES ('18', '1', '2018-01-19', 'p');
INSERT INTO `orderstatus` VALUES ('19', '1', '2018-01-19', 'p');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `productid` varchar(10) NOT NULL,
  `category` varchar(10) NOT NULL,
  `name` varchar(80) DEFAULT NULL,
  `descn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`productid`),
  KEY `productCat` (`category`),
  KEY `productName` (`name`),
  CONSTRAINT `FKqx9wikktsev17ctu0kcpkrafc` FOREIGN KEY (`category`) REFERENCES `category` (`catid`),
  CONSTRAINT `fk_product_1` FOREIGN KEY (`category`) REFERENCES `category` (`catid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('AV-CB-01', 'BIRDS', 'Amazon Parrot', '<image src=\"images/bird2.gif\">Great companion for up to 75 years');
INSERT INTO `product` VALUES ('AV-SB-02', 'BIRDS', 'Finch', '<image src=\"images/bird1.gif\">Great stress reliever');
INSERT INTO `product` VALUES ('FI-FW-01', 'FISH', 'Koi', '<image src=\"images/fish3.gif\">Fresh Water fish from Japan');
INSERT INTO `product` VALUES ('FI-FW-02', 'FISH', 'Goldfish', '<image src=\"images/fish2.gif\">Fresh Water fish from China');
INSERT INTO `product` VALUES ('FI-SW-01', 'FISH', 'Angelfish', '<image src=\"images/fish1.gif\">Salt Water fish from Australia');
INSERT INTO `product` VALUES ('FI-SW-02', 'FISH', 'Tiger Shark', '<image src=\"images/fish4.gif\">Salt Water fish from Australia');
INSERT INTO `product` VALUES ('FL-DLH-02', 'CATS', 'Persian', '<image src=\"images/cat1.gif\">Friendly house cat, doubles as a princess');
INSERT INTO `product` VALUES ('FL-DSH-01', 'CATS', 'Manx', '<image src=\"images/cat2.gif\">Great for reducing mouse populations');
INSERT INTO `product` VALUES ('K9-BD-01', 'DOGS', 'Bulldog', '<image src=\"images/dog2.gif\">Friendly dog from England');
INSERT INTO `product` VALUES ('K9-CW-01', 'DOGS', 'Chihuahua', '<image src=\"images/dog4.gif\">Great companion dog');
INSERT INTO `product` VALUES ('K9-DL-01', 'DOGS', 'Dalmation', '<image src=\"images/dog5.gif\">Great dog for a Fire Station');
INSERT INTO `product` VALUES ('K9-PO-02', 'DOGS', 'Poodle', '<image src=\"images/dog6.gif\">Cute dog from France');
INSERT INTO `product` VALUES ('K9-RT-01', 'DOGS', 'Golden Retriever', '<image src=\"images/dog1.gif\">Great family dog');
INSERT INTO `product` VALUES ('K9-RT-02', 'DOGS', 'Labrador Retriever', '<image src=\"images/dog5.gif\">Great hunting dog');
INSERT INTO `product` VALUES ('RP-LI-02', 'REPTILES', 'Iguana', '<image src=\"images/lizard1.gif\">Friendly green friend');
INSERT INTO `product` VALUES ('RP-SN-01', 'REPTILES', 'Rattlesnake', '<image src=\"images/snake1.gif\">Doubles as a watch dog');

-- ----------------------------
-- Table structure for profile
-- ----------------------------
DROP TABLE IF EXISTS `profile`;
CREATE TABLE `profile` (
  `userid` varchar(80) NOT NULL,
  `langpref` varchar(80) NOT NULL,
  `favcategory` varchar(30) DEFAULT NULL,
  `mylistopt` int(11) DEFAULT NULL,
  `banneropt` int(11) DEFAULT NULL,
  `id` int(20) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of profile
-- ----------------------------
INSERT INTO `profile` VALUES ('aaaa', 'ENGLISH', 'CATS', '0', '0', '7');
INSERT INTO `profile` VALUES ('ACID', 'english', 'CATS', '1', '1', '1');
INSERT INTO `profile` VALUES ('j2ee', 'english', 'DOGS', '1', '1', '2');

-- ----------------------------
-- Table structure for sequence
-- ----------------------------
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `name` varchar(30) NOT NULL,
  `nextid` int(11) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sequence
-- ----------------------------
INSERT INTO `sequence` VALUES ('ordernum', '1000');

-- ----------------------------
-- Table structure for signon
-- ----------------------------
DROP TABLE IF EXISTS `signon`;
CREATE TABLE `signon` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of signon
-- ----------------------------
INSERT INTO `signon` VALUES ('aaaa', 'aaaa');
INSERT INTO `signon` VALUES ('ACID', 'ACID');
INSERT INTO `signon` VALUES ('j2ee', 'j2ee');

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `count` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('1', 'android', '15');
INSERT INTO `store` VALUES ('2', 'iphone', '14');
INSERT INTO `store` VALUES ('3', 'iphone', '20');
INSERT INTO `store` VALUES ('4', 'android', '5');
INSERT INTO `store` VALUES ('5', 'android', '13');
INSERT INTO `store` VALUES ('6', 'iphone', '13');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sno` int(4) NOT NULL,
  `sname` varchar(255) DEFAULT NULL,
  `sage` int(3) DEFAULT NULL,
  `enrollment_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sex` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sno`),
  UNIQUE KEY `uk_student_name` (`sname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `suppid` int(11) NOT NULL,
  `name` varchar(80) DEFAULT NULL,
  `status` varchar(2) NOT NULL,
  `addr1` varchar(80) DEFAULT NULL,
  `addr2` varchar(80) DEFAULT NULL,
  `city` varchar(80) DEFAULT NULL,
  `state` varchar(80) DEFAULT NULL,
  `zip` varchar(5) DEFAULT NULL,
  `phone` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`suppid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', 'XYZ Pets', 'AC', '600 Avon Way', '', 'Los Angeles', 'CA', '94024', '212-947-0797');
INSERT INTO `supplier` VALUES ('2', 'ABC Pets', 'AC', '700 Abalone Way', '', 'San Francisco ', 'CA', '94024', '415-947-0797');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '用户名、登录名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'root', 'root');
INSERT INTO `user` VALUES ('2', 'zhang', 'zhang12345');

-- ----------------------------
-- View structure for emp3_view
-- ----------------------------
DROP VIEW IF EXISTS `emp3_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `emp3_view` AS (select `d`.`deptno` AS `deptno`,`d`.`dname` AS `dname`,max(`e`.`salary`) AS `MAX(salary)`,min(`e`.`salary`) AS `min(salary)`,avg(`e`.`salary`) AS `AVG(salary)` from (`emp1` `e` join `dept` `d`) where (`e`.`dept` = `d`.`deptno`) group by `d`.`deptno`,`d`.`dname`) ;

-- ----------------------------
-- View structure for emp4_view
-- ----------------------------
DROP VIEW IF EXISTS `emp4_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `emp4_view` AS (select `emp1`.`empno` AS `empno`,`emp1`.`ename` AS `ename`,`emp1`.`job` AS `job`,`emp1`.`salary` AS `salary`,`emp1`.`comm` AS `comm`,`emp1`.`dept` AS `dept`,`emp1`.`manager` AS `manager` from `emp1`) ;

-- ----------------------------
-- Procedure structure for getstore
-- ----------------------------
DROP PROCEDURE IF EXISTS `getstore`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `getstore`()
BEGIN
#Routine body goes here...

#创建接收游标数据的变量
DECLARE c int;
DECLARE b varchar(20);

#创建总数变量
DECLARE total int DEFAULT 0;

#创建结束标志变量
DECLARE done int DEFAULT false;

#创建游标
DECLARE cur CURSOR FOR SELECT name,count FROM store WHERE name = 'iphone';

#指定游标循环结束时的返回值
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = true;

#设置初始值
SET total = 0;
#1.打开游标
OPEN cur;
#2.开始循环游标里的数据
read_loop:loop
#3根据游标当前志向的一条数据，判定循环是否结束
FETCH cur into b,c;

if done THEN
LEAVE read_loop;
END IF;

SET total = total + c;
#4.跳出游标循环
END loop;
#5.关闭游标
CLOSE cur;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for mypro
-- ----------------------------
DROP PROCEDURE IF EXISTS `mypro`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `mypro`(IN `a` int,IN `b` int,OUT `c` int)
    COMMENT '计算两个数的和'
BEGIN
	#Routine body goes here...
	IF ISNULL(a) THEN SET a=0;
	END IF;
	IF ISNULL(b) THEN SET b=0;
	END IF;
	SET c=a+b;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_case
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_case`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `proc_case`(IN `type` int)
BEGIN
	#Routine body goes here...
	DECLARE c VARCHAR(255);
	CASE type
	WHEN 0 THEN
		SET c='0';
	WHEN 1 THEN
		SET c='1';
	ELSE
		SET c='2';
	END CASE;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_if
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_if`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `proc_if`(IN `type` int)
BEGIN
	#Routine body goes here...
	DECLARE c VARCHAR(255);
  IF type=0 THEN
		SET c = 'aaaaaa';
	ELSEIF type=1 THEN
		SET c = 'bbbbbb';
	ELSE
		set c='ccccccc';
	END IF;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for proc_while
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_while`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `proc_while`(IN `n` int)
BEGIN
	#Routine body goes here...
	DECLARE i INT;
	DECLARE s INT;

	WHILE i <= n DO
		SET s=s+i;
		SET i=i+1;
	END WHILE;
END
;;
DELIMITER ;
