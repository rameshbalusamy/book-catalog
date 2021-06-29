package com.tcs.excercise.bookcatalog.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tcs.excercise.bookcatalog.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {

	Optional<Book> findByBookTitle(String bookTitle);
	void deleteByBookTitle(String bookTitle);
	List<Book> findByAuthorName(String authorName);
	Book findByISBN(long isbn);
	

}