DROP TABLE IF EXISTS USER;

CREATE TABLE IF NOT EXISTS USER
(
    USER_ID           VARCHAR(20) UNIQUE NOT NULL,
    PASSWORD          VARCHAR(60)        NOT NULL,
    USER_NAME         VARCHAR(60)        NOT NULL,
    USER_PHONE_NUMBER VARCHAR(12)        NOT NULL,
    USER_DEFAULT_ADDR VARCHAR(100)       NOT NULL,
    USER_EMAIL        VARCHAR(60),
    PRIMARY KEY (`USER_ID`)
);