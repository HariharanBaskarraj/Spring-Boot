/**
 * 
 */
package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

/**
 * @author HariharanB
 *
 */
@RestController
@RequestMapping("book-api")
public class BookResponseController {

	private IBookService bookService;
	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	
//	http://localhost:8080/book-api/books	
	@PostMapping("/books")
	ResponseEntity<Void> addBook(@RequestBody Book book) {
		bookService.addBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

//	http://localhost:8080/book-api/books
	@PutMapping("/books")
	ResponseEntity<Void> updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
//	http://localhost:8080/book-api/books/10
	@DeleteMapping("/books/{bookId}")
	ResponseEntity<Void> deleteBook(@PathVariable("bookId")int bookId) {
		bookService.deleteBook(bookId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

//	http://localhost:8080/book-api/books/bookId/5	
	@GetMapping("/books/bookId/{bookId}")
	ResponseEntity<Book> getById(@PathVariable("bookId") int bookId) {
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "get book by Id");
		return ResponseEntity.ok().headers(header).body(bookService.getById(bookId));
	}

//	http://localhost:8080/book-api/books
	@GetMapping("/books")
	ResponseEntity<List<Book>> getAll(){
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "Returns a list of books");
		header.add("info", "API - Get all books");
		List<Book> books = bookService.getAll();
		ResponseEntity<List<Book>> responseEntity =new ResponseEntity<>(books, header,HttpStatus.OK);
		return responseEntity;
	}

//	http://localhost:8080/book-api/books/author/Lois Lowry	
	@GetMapping("/books/author/{author}")
	ResponseEntity<List<Book>> getBookByAuthor(@PathVariable("author") String author){
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "Returns a list of books by author "+author);
		List<Book> books = bookService.getBookByAuthor(author);
		return ResponseEntity.ok().headers(header).body(books);
	}

//	http://localhost:8080/book-api/books/category/Selfhelp	
	@GetMapping("/books/category/{category}")
	ResponseEntity<List<Book>> getBookByCategory(@PathVariable("category") String category){
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "Returns a list of books by category "+category);
		List<Book> books = bookService.getBookByCategory(category);
		return ResponseEntity.ok(books);
	}

//	http://localhost:8080/book-api/books/price/500	
	@GetMapping("/books/price/{price}")
	ResponseEntity<List<Book>> getBookByPrice(@PathVariable("price") double price){
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "Returns a list of books lesser than the given price "+price);
		List<Book> books = bookService.getBookByPrice(price);
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(books);
	}

//	http://localhost:8080/book-api/books/price/500/author/Doyle
	@GetMapping("/books/price/{price}/author/{author}")
	ResponseEntity<List<Book>> getByPriceAuth(@PathVariable("price") double price,@PathVariable("author") String author){
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "Returns a list of books lesser than the given price "+price+" and author "+author);
		List<Book> books = bookService.getByPriceAuth(price, author);
		return ResponseEntity.ok().headers(header).body(books);
	}

//	http://localhost:8080/book-api/books/category/Fiction/author/Kalki Krishnamurthy	
	@GetMapping("/books/category/{category}/author/{author}")
	ResponseEntity<List<Book>> getByCatAndAuth(@PathVariable("category") String category,@PathVariable("author") String author){
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "Returns a list of books lesser than the given category "+category+" and author "+author);
		List<Book> books = bookService.getByCatAndAuth(category, author);
		return ResponseEntity.ok(books);
	}

}
