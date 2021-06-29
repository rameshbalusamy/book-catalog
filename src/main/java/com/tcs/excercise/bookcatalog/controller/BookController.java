package com.tcs.excercise.bookcatalog.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.excercise.bookcatalog.BookService.IBookService;
import com.tcs.excercise.bookcatalog.model.Book;

@RestController
@RequestMapping("/book")
public class BookController {	

@Autowired
IBookService ibookService;

@PostMapping("/add")
public Book addBook(@RequestBody Book book) {
	return ibookService.addBook(book);
}
@PutMapping("/update")
public Book updateBook(@RequestBody Book book) throws Exception {
	return ibookService.updateBook(book);
}

@DeleteMapping("/delete")
public Map<String, Boolean> deleteBook(@RequestBody Book book) {
	return ibookService.deleteBook(book);
}

@GetMapping("/title")
public Optional<Book> listBookByTitle(@RequestHeader(name = "title") String title) {
	System.out.println("title is "+title);
	return ibookService.findbookByTitle(title);
}


@GetMapping("/author")
public List<Book> listBookByAuthor(@RequestParam(name = "author") String author) {
	System.out.println("title is "+author);
	return ibookService.listBookByAuthor(author);
}


@GetMapping("/isbn/{isbn}")
public Book listBookByAuthor(@PathVariable("isbn") Long isbn) {
	System.out.println("title is "+isbn);
	return ibookService.findBookByISBN(isbn);
}
}
