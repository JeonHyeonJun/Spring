create database springboard_db;

use springboard_db;

create table member(
idx int primary key auto_increment,
id varchar(30),
pass varchar(30),
name varchar(30)
);

create table board(
idx int primary key auto_increment,
title varchar(50),
content varchar(10000),
writer varchar(30),
writeDate date,
readCount int,
fileId int,
writerIdx int
);

create table reple(
idx int primary key auto_increment,
boardIdx int,
content varchar(1000),
writer varchar(30),
writeDate date,
groupCode int,
groupSeq int,
groupLv int,
parent int,
isDelete varchar(2),
writerIdx int,
parentName varchar(30),
foreign key(boardIdx) references board(idx) ON DELETE CASCADE ON UPDATE CASCADE
);

create table file(
fileId int primary key auto_increment,
originFileName varchar(100),
uri varchar(200)
);
