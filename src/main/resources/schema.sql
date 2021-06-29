DROP TABLE IF EXISTS BOOK;
  
CREATE TABLE book (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  book_title VARCHAR(100) NOT NULL,
  author_name VARCHAR(50) NOT NULL,
  publication_date datetime,
  isbn long
);