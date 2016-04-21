CREATE TABLE Author (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  last_name  VARCHAR(255) NOT NULL,
);

INSERT INTO Author (first_name, last_name) VALUES ('Erlend', 'Lu');
INSERT INTO Author (first_name, last_name) VALUES ('Francis Scott', 'Fitzgerald');
INSERT INTO Author (first_name, last_name) VALUES ('Franz', 'Kafka');

CREATE TABLE Book (
  id       INT PRIMARY KEY AUTO_INCREMENT,
  title    VARCHAR(255) NOT NULL,
  author_ID INT          NOT NULL,
  year     VARCHAR(4)   NOT NULL,
  format   VARCHAR(1)   NOT NULL,
  FOREIGN KEY (author_ID) REFERENCES Author(id)
);

INSERT INTO Book(title, author_ID, year, format) VALUES ('Naively.Super', '1', '2010','S');
INSERT INTO Book(title, author_ID, year, format) VALUES ('The Great Gatsby', '2', '2013','M');
INSERT INTO Book(title, author_ID, year, format) VALUES ('The Castle', '3', '2012','S');


CREATE TABLE ForRemoving (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
);

INSERT INTO ForRemoving (first_name) VALUES ('Erlend');
INSERT INTO ForRemoving (first_name) VALUES ('lalal');




