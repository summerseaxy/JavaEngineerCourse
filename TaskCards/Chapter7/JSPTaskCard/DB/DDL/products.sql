drop  table if exists `products`;


CREATE TABLE `products` (
  `id` int(50)  not null AUTO_INCREMENT COMMENT '产品id' ,
  `productName` varchar(50) NOT NULL COMMENT '产品名',
  `price` varchar(50) NOT NULL COMMENT '产品价格',
  `description` varchar(50) NOT NULL COMMENT '产品描述',
PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='产品信息表';

