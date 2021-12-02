CREATE DATABASE scanbook;
USE scanbook;


CREATE TABLE authors
(
  author_id INT NOT NULL auto_increment,
  author_name VARCHAR(50) NOT NULL,
  PRIMARY KEY (author_id)
);

CREATE TABLE books
(
  barcode INT NOT NULL,
  isbn INT NOT NULL CHECK(isbn LIKE '9________') UNIQUE,
  title VARCHAR(50) NOT NULL,
  numPages INT NOT NULL,
  isRead BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (barcode)
);

CREATE TABLE books_authors
(
  author_id INT NOT NULL,
  barcode INT NOT NULL,
  PRIMARY KEY (barcode, author_id),
  FOREIGN KEY (barcode) REFERENCES books(barcode) ON delete cascade,
  FOREIGN KEY (author_id) REFERENCES authors(author_id) on delete cascade
);

CREATE TABLE book_notes
(
  barcode INT NOT NULL,
  note_id INT NOT NULL auto_increment,
  note VARCHAR(300) NOT NULL,
  PRIMARY KEY (note_id),
  FOREIGN KEY (barcode) REFERENCES books(barcode)
);
commit;


CREATE VIEW SCANBOOK_FACT_TABLE AS
SELECT 
	b.barcode AS Barcode, 
    b.isbn AS ISBN,
    b.title AS Title,
    group_concat(DISTINCT a.author_name ORDER BY a.author_name SEPARATOR', ') AS Authors ,
    b.numPages AS Pages,
    b.isRead AS 'Read',
    group_concat(bn.note ORDER BY bn.note_id SEPARATOR', ') AS Notes
FROM books b
LEFT JOIN book_notes bn
ON b.barcode = bn.barcode
INNER JOIN books_authors ba
ON b.barcode = ba.barcode
INNER JOIN authors a
ON a.author_id = ba.author_id
GROUP BY barcode;

INSERT INTO books(barcode,isbn,title,numPages,isRead) VALUES(900000001,900000001,'Sputnik Sweetheart',400,false);
INSERT INTO books(barcode,isbn,title,numPages,isRead) VALUES(900000002,900000002,'Harry Potter',500,false);
INSERT INTO books(barcode,isbn,title,numPages,isRead) VALUES(900000003,900000003,'The Alchemist',600,true);

INSERT INTO authors(author_name) VALUES('Paulo Coelho');
INSERT INTO authors(author_name) VALUES('JK Rowling');
INSERT INTO authors(author_name) VALUES('Murakami');
INSERT INTO authors(author_name) VALUES('Sanjoy Dasgupta');

INSERT INTO books_authors(author_id,barcode) VALUES(1,900000003);
INSERT INTO books_authors(author_id,barcode) VALUES(4,900000003);
INSERT INTO books_authors(author_id,barcode) VALUES(3,900000001);
INSERT INTO books_authors(author_id,barcode) VALUES(2,900000002);

INSERT INTO book_notes(barcode,note) VALUES(900000001,'Note 1');
INSERT INTO book_notes(barcode,note) VALUES(900000001,'Note 2');
INSERT INTO book_notes(barcode,note) VALUES(900000002,'Note 3');
commit;

select * from SCANBOOK_FACT_TABLE WHERE title LIKE 'Sput%';

select * from books;
select * from authors;
select * from books_authors;


drop table book_notes;
drop table books_authors;
drop table books;

