-- user 테이블 생성 (id, username, password)
CREATE TABLE user (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      username VARCHAR(255) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL
);

-- 테스트 데이터 삽입
INSERT INTO user (username, password) VALUES ('user1', 'pw1');
INSERT INTO user (username, password) VALUES ('user2', 'pw2');
INSERT INTO user (username, password) VALUES ('user3', 'pw3');