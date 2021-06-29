package com.tcs.excercise.bookcatalog.BookService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.tcs.excercise.bookcatalog.model.Book;

public interface IBookService {
	
	public Book addBook(Book book);
	public Book updateBook(Book book) throws Exception;
	public Map<String, Boolean> deleteBook(Book book);
	public Optional<Book> findbookByTitle(String authorName);
	public List<Book> listBookByAuthor(String author);
	public Book findBookByISBN(long isbn);

}
