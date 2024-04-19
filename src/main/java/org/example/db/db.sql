DROP DATABASE IF EXISTS sbs_proj;
CREATE DATABASE sbs_proj;
USE sbs_proj;



CREATE TABLE article (
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
regDate DATETIME NOT NULL,
updateDate DATETIME NOT NULL,
title CHAR(100) NOT NULL,
`body` TEXT NOT NULL,
memberId INT(10) UNSIGNED NOT NULL,
boardId INT(10) UNSIGNED NOT NULL,
hit INT(100) UNSIGNED NOT NULL,
INDEX boardId(`boardId`)

);

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목1',
`body` = '내용1',
memberId = 1,
boardId = 1,
hit = 50;

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목2',
`body` = '내용2',
memberId = 2,
boardId = 1,
hit = 7;

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = '제목3',
`body` = '내용3',
memberId = 2,
boardId = 2,
hit = 30;

SELECT * FROM article;

ALTER TABLE article ADD COLUMN hit INT(10) UNSIGNED NOT NULL;

SELECT * FROM article;

CREATE TABLE articleReply (
 id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
 regDate DATETIME NOT NULL,
 updateDate DATETIME NOT NULL,
 `body` CHAR(100) NOT NULL,
 memberId INT(10) UNSIGNED NOT NULL,
 articleId INT(10) UNSIGNED NOT NULL,
 INDEX articleId(`articleId`)
);

INSERT INTO articleReply
SET regDate = NOW(),
updateDate = NOW(),
`body` = '댓글1',
memberId = 1,
articleId = 2;

INSERT INTO articleReply
SET regDate = NOW(),
updateDate = NOW(),
`body` = '댓글2',
memberId = 2,
articleId = 1;

SELECT * FROM articleReply;



CREATE TABLE `member` (
 id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
 regDate DATETIME NOT NULL,
 updateDate DATETIME NOT NULL,
 loginId CHAR(100) NOT NULL UNIQUE,
 loginPw CHAR(100) NOT NULL,
 `name` CHAR(100) NOT NULL
);

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'admin',
loginPw = 'admin',
`name` = '관리자';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user',
loginPw = 'user',
`name` = '짱구';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'user1',
loginPw = 'user1',
`name` = '맹구';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'qwer',
loginPw = 'qwer',
`name` = '철수';


SELECT * FROM `member`;

CREATE TABLE board (
 id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
 regDate DATETIME NOT NULL,
 updateDate DATETIME NOT NULL,
 `code` CHAR(100) NOT NULL UNIQUE, # free/nptice
 `name` CHAR(100) NOT NULL # 자유/ 공지
);

INSERT INTO `board`
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'notice',
`name` = '공지';

INSERT INTO `board`
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'free',
`name` = '자유';

# 신규 추가 부분

DROP TABLE `Check`;

CREATE TABLE `Check` ( #예약
     id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `time` DATETIME NOT NULL,
    `reservation` CHAR(100) UNIQUE NOT NULL UNIQUE,
     checkPw CHAR(100) NOT NULL,
    `name` CHAR(100) NOT NULL
);

INSERT INTO `check`
SET `time` = NOW(),
`reservation` = '7타임',
 checkPw = '999',
`name` = '유리';




DROP TABLE Cul;


CREATE TABLE Cul (
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    member_name CHAR(100) UNIQUE NOT NULL,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    `STATUS` VARCHAR(20) NOT NULL
);

INSERT INTO Cul
SET member_name = '오수',
regDate = NOW(),
updateDate = NOW(),
`status` = '미출석';


INSERT INTO Cul ( member_name, regDate, updateDate, STATUS)
VALUES ( '짱아', NOW(), NOW(), '출석');

SELECT * FROM Cul;

SELECT * FROM board;

SELECT * FROM article;

SELECT * FROM `member`;

SELECT * FROM `Check`;

SELECT * FROM Cul;


