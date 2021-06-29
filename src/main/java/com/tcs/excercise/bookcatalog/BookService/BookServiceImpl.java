package com.tcs.excercise.bookcatalog.BookService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.excercise.bookcatalog.Repository.BookRepository;
import com.tcs.excercise.bookcatalog.model.Book;

@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public Book addBook(Book book) {
		book.setISBN(generateISBN());
		bookRepository.save(book);
		return book;
	}

	@Override
	public Book updateBook(Book book) throws Exception {
		Optional<Book> dbData=bookRepository.findByBookTitle(book.getBookTitle());
		if(dbData.isPresent()) {
			book.setId(dbData.get().getId());
			book.setISBN(dbData.get().getISBN());
		return bookRepository.save(book);
		}
		else {
			throw new Exception("Book Not Found");
		}
		
	}

	@Override
	public Map<String, Boolean> deleteBook(Book book) {
		Map<String,Boolean> mapObject =new HashMap<>();
		Optional<Book> dbData=bookRepository.findByBookTitle(book.getBookTitle());
		if(dbData.isPresent()) {
			 bookRepository.deleteById(dbData.get().getId());
			 mapObject.put("Book is Deleted Successfully", Boolean.TRUE);
		}
		else {
			mapObject.put("Failed to delete Book. Book Not Found", Boolean.FALSE);
		}
		
		return mapObject;
	}

	@Override
	public List<Book> listBookByAuthor(String authorName) {
		
		return bookRepository.findByAuthorName(authorName);
	}

	@Override
	public Optional<Book> findbookByTitle(String bookTitle) {
		
		return bookRepository.findByBookTitle(bookTitle);
	}

	@Override
	public Book findBookByISBN(long isbn) {
		
		return bookRepository.findByISBN(isbn);
	}
	
	public static long generateISBN() {
	    final Random r = new Random();
	    return 1_000_000_000L * (r.nextInt(9_000) + 1_000)
	            + r.nextInt(1_000_000_000);
	}
}

