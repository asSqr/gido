DROP TABLE IF EXISTS M_SENTENCE;

CREATE TABLE M_SENTENCE
(
    ID CHAR(10) PRIMARY KEY,
    AUTHOR VARCHAR(100),
    TEXT VARCHAR(300)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;
