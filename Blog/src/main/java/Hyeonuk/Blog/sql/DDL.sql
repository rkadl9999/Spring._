create database DLOG;

create table member(
    id VARCHAR(32) NOT NULL ,
    password VARCHAR(32) NOT NULL ,
    name VARCHAR(24) NOT NULL ,
    PRIMARY KEY (id)
) ENGINE = INNODB;