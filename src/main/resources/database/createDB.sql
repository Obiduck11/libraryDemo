DROP SCHEMA IF EXISTS libraryDemo;
CREATE SCHEMA libraryDemo;

CREATE TABLE Book (
                      title VARCHAR(45) PRIMARY KEY,
                      author VARCHAR(45)
);