INSERT INTO article(title, content) VALUES ('제목1', '내용1');
INSERT INTO article(title, content) VALUES ('제목2', '내용2');
INSERT INTO article(title, content) VALUES ('제목3', '내용3');

INSERT INTO member(email, password) VALUES ('111@gmail.com', '1234');
INSERT INTO member(email, password) VALUES ('222@gmail.com', '5678');
INSERT INTO member(email, password) VALUES ('333@gmail.com', '9012');

INSERT INTO coffee(name, price) VALUES ('아메리카노', '4500');
INSERT INTO coffee(name, price) VALUES ('라떼', '5000');
INSERT INTO coffee(name, price) VALUES ('카페 모카', '5500');

-- article 테이블에 데이터 추가
INSERT INTO article(title, content) VALUES('당신의 인생 영화는?', '댓글 남겨주세요');
INSERT INTO article(title, content) VALUES('당신의 소울 푸드는?', '댓글 남겨주세요');
INSERT INTO article(title, content) VALUES('당신의 취미는?', '댓글 남겨주세요');

-- 4번 게시글의 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Park', '아이언맨1');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Kim', '아이언맨2');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Choi', '아이언맨3');

-- 5번 게시글의 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Park', '치킨');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Kim', '샤브샤브');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Choi', '초밥');

-- 6번 게시글의 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Park', '조깅');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Kim', '유튜브 시청');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Choi', '독서');

