/**
 * 
 */
package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

/**
 * @author HariharanB
 *
 */
//@RestController
@RequestMapping("book-api")
public class BookController {

	private IBookService bookService;
	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	
//	http://localhost:8080/book-api/books	
	@PostMapping("/books")
	void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}

//	http://localhost:8080/book-api/books
	@PutMapping("/books")
	void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
	}
//	http://localhost:8080/book-api/books/10
	@DeleteMapping("/books/{bookId}")
	void deleteBook(@PathVariable("bookId")int bookId) {
		bookService.deleteBook(bookId);
	}

//	http://localhost:8080/book-api/books/bookId/5	
	@GetMapping("/books/bookId/{bookId}")
	Book getById(@PathVariable("bookId") int bookId) {
		return bookService.getById(bookId);
	}

//	http://localhost:8080/book-api/books
	@GetMapping("/books")
	List<Book> getAll(){
		return bookService.getAll();
	}

//	http://localhost:8080/book-api/books/author/Lois Lowry	
	@GetMapping("/books/author/{author}")
	List<Book> getBookByAuthor(@PathVariable("author") String author){
		return bookService.getBookByAuthor(author);
	}

//	http://localhost:8080/book-api/books/category/Selfhelp	
	@GetMapping("/books/category/{category}")
	List<Book> getBookByCategory(@PathVariable("category") String category){
		return bookService.getBookByCategory(category);
	}

//	http://localhost:8080/book-api/books/price/500	
	@GetMapping("/books/price/{price}")
	List<Book> getBookByPrice(@PathVariable("price") double price){
		return bookService.getBookByPrice(price);
	}

//	http://localhost:8080/book-api/books/price/500/author/Doyle
	@GetMapping("/books/price/{price}/author/{author}")
	List<Book> getByPriceAuth(@PathVariable("price") double price,@PathVariable("author") String author){
		return bookService.getByPriceAuth(price, author);
	}

//	http://localhost:8080/book-api/books/category/Fiction/author/Kalki Krishnamurthy	
	@GetMapping("/books/category/{category}/author/{author}")
	List<Book> getByCatAndAuth(@PathVariable("category") String category,@PathVariable("author") String author){
		return bookService.getByCatAndAuth(category, author);
	}

}
