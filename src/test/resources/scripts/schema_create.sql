DROP TABLE common_user;
DROP TABLE common_posts;
DROP TABLE common_comments;

create table if not exists common_user (
  uid int (10) unsigned NOT NULL AUTO_INCREMENT,
  addr varchar (255) DEFAULT NULL,
  mobile varchar (16) DEFAULT NULL,
  username varchar (32) DEFAULT NULL,
  display_name varchar (32) DEFAULT NULL,
  user_login varchar (32) NOT NULL,
  password varchar (64) NOT NULL,
  email varchar (255) DEFAULT NULL,
  account_balance decimal (13, 5) NOT NULL DEFAULT '0.00' ,
  user_type varchar (16) NOT NULL DEFAULT 'defalut' ,
  is_avatar tinyint(4) DEFAULT 0,
  level tinyint(4) DEFAULT 0,
  status tinyint(4) DEFAULT 0,
  reg_time datetime DEFAULT NULL,
  reg_ip varchar (32) DEFAULT NULL,
  last_login_time datetime DEFAULT NULL,
  PRIMARY KEY ( uid),
  UNIQUE KEY ( username),
  UNIQUE KEY ( email),
  UNIQUE KEY ( mobile)
) ENGINE =InnoDB DEFAULT CHARSET=utf8;

create table if not exists common_posts (
  post_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  post_author int (10) unsigned NOT NULL DEFAULT 0,
  post_date datetime NOT NULL,
  title varchar (255) NOT NULL,
  content text NOT NULL,
  post_status varchar(20) DEFAULT 'publish',
  comment_status varchar(20) DEFAULT 'open',
  post_modified datetime NOT NULL,
  guid	varchar(255),
  post_type	varchar(20) DEFAULT 'post',
  post_mime_type	varchar(100),
  post_password	varchar(20),
  post_name	varchar(200),
  post_parent	int(10) unsigned DEFAULT 0,
  comment_count	int(10) DEFAULT 0,
  PRIMARY KEY (post_id)
) ENGINE =InnoDB DEFAULT CHARSET=utf8;

create table if not exists common_comments (
  comment_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  post_id int(10) unsigned NOT NULL DEFAULT 0,
  user_id int (10) unsigned DEFAULT 0,
  comment_author tinytext,
  comment_author_email	varchar(100) DEFAULT NULL,
  comment_author_url	varchar(200) DEFAULT NULL,
  comment_author_IP	varchar(100) DEFAULT NULL,
  comment_date datetime DEFAULT '0000-00-00 00:00:00',
  comment_content	text,
  comment_type	varchar(20) DEFAULT NULL,
  comment_parent int(10) unsigned DEFAULT 0,
  PRIMARY KEY (comment_id)
) ENGINE =InnoDB DEFAULT CHARSET=utf8;