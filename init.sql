-- 用户信息表
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `salt`   VARCHAR(50) DEFAULT NULL COMMENT '',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';
-- 角色信息表
CREATE TABLE `role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(50) NOT NULL DEFAULT 'ordinary_user' COMMENT '角色名',
  `rdesc` varchar(100) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色信息表';
-- 权限信息表
CREATE TABLE `permission` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) NOT NULL DEFAULT 'query' COMMENT '权限名',
  `url` varchar(100) DEFAULT NULL COMMENT '资源链接',
  `pdesc` varchar(100) DEFAULT NULL COMMENT '资源描述',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限信息表';
-- 用户角色表
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL DEFAULT '1' COMMENT '用户主键id',
  `rid` int(11) NOT NULL DEFAULT '1' COMMENT '角色主键id',
  PRIMARY KEY (`id`),
  KEY `fk_userid` (`uid`),
  KEY `fk_roleid` (`rid`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `fk_roleid` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';
-- 角色权限表
CREATE TABLE `permission_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) NOT NULL DEFAULT '1' COMMENT '角色主键id',
  `pid` int(11) NOT NULL DEFAULT '1' COMMENT '权限主键id',
  PRIMARY KEY (`id`),
  KEY `fk_rid` (`rid`),
  KEY `fk_pid` (`pid`),
  CONSTRAINT `fk_pid` FOREIGN KEY (`pid`) REFERENCES `permission` (`pid`),
  CONSTRAINT `fk_rid` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';


INSERT INTO `shirodemo`.`user` (`uid`, `username`, `password`, `phone`, `address`, `salt`) VALUES ('1', 'BeautifulSoup', '3c823383d7e5f1cfae9f833c3bc1829f', '17864195311', '杭州阿里巴巴', '1997password');
INSERT INTO `shirodemo`.`user` (`uid`, `username`, `password`, `phone`, `address`, `salt`) VALUES ('2', 'James_shu', '3c823383d7e5f1cfae9f833c3bc1829f', '17864195311', '杭州网易', '1997password');

INSERT INTO `shirodemo`.`role` (`rid`, `rname`, `rdesc`) VALUES ('1', 'role1', '普通用户');
INSERT INTO `shirodemo`.`role` (`rid`, `rname`, `rdesc`) VALUES ('2', 'role2', '普通管理员');
INSERT INTO `shirodemo`.`role` (`rid`, `rname`, `rdesc`) VALUES ('3', 'role3', '超级管理员');

INSERT INTO `shirodemo`.`permission` (`pid`, `pname`, `url`, `pdesc`) VALUES ('1', 'item:query', 'item:query', 'item:query');
INSERT INTO `shirodemo`.`permission` (`pid`, `pname`, `url`, `pdesc`) VALUES ('2', 'item:create:01', 'item:create:01', 'item:create:01');
INSERT INTO `shirodemo`.`permission` (`pid`, `pname`, `url`, `pdesc`) VALUES ('3', 'item:*:01', 'item:*:01', 'item:*:01');
INSERT INTO `shirodemo`.`permission` (`pid`, `pname`, `url`, `pdesc`) VALUES ('4', 'item:create:02', 'item:create:02', 'item:create:02');
INSERT INTO `shirodemo`.`permission` (`pid`, `pname`, `url`, `pdesc`) VALUES ('5', 'item:update:02', 'item:update:02', 'item:update:02');
INSERT INTO `shirodemo`.`permission` (`pid`, `pname`, `url`, `pdesc`) VALUES ('6', 'item:delete:02', 'item:delete:02', 'item:delete:02');

INSERT INTO `shirodemo`.`permission_role` (`id`, `rid`, `pid`) VALUES ('1', '1', '1');
INSERT INTO `shirodemo`.`permission_role` (`id`, `rid`, `pid`) VALUES ('3', '2', '2');
INSERT INTO `shirodemo`.`permission_role` (`id`, `rid`, `pid`) VALUES ('4', '2', '3');
INSERT INTO `shirodemo`.`permission_role` (`id`, `rid`, `pid`) VALUES ('5', '2', '5');
INSERT INTO `shirodemo`.`permission_role` (`id`, `rid`, `pid`) VALUES ('6', '3', '4');
INSERT INTO `shirodemo`.`permission_role` (`id`, `rid`, `pid`) VALUES ('7', '3', '6');


INSERT INTO `shirodemo`.`user_role` (`id`, `uid`, `rid`) VALUES ('1', '1', '1');
INSERT INTO `shirodemo`.`user_role` (`id`, `uid`, `rid`) VALUES ('2', '1', '2');
INSERT INTO `shirodemo`.`user_role` (`id`, `uid`, `rid`) VALUES ('3', '2', '1');
INSERT INTO `shirodemo`.`user_role` (`id`, `uid`, `rid`) VALUES ('4', '2', '2');
INSERT INTO `shirodemo`.`user_role` (`id`, `uid`, `rid`) VALUES ('5', '2', '3');
