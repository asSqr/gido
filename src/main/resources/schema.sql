DROP TABLE IF EXISTS M_SENTENCE;

CREATE TABLE M_SENTENCE
(
    ID CHAR(40) PRIMARY KEY,
    AUTHOR VARCHAR(256),
    TEXT VARCHAR(8096)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;
