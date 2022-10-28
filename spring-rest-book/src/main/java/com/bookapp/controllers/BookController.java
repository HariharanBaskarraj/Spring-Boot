/**
 * 
 */
package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

/**
 * @author HariharanB
 *
 */
@RestController
public class BookController {

	private IBookService bookService;
	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	
//	http://localhost:8080/books/author/Lois Lowry	
	@GetMapping("/books/author/{pathAuthor}")
	List<Book> getByAuthor(@PathVariable("pathAuthor")String author){
		return bookService.getByAuthor(author);
	}

//	http://localhost:8080/books/category/Adventure/author/Lois Lowry	
	@GetMapping("/books/category/{pathCategory}/author/{pathAuthor}")
	List<Book> getByCategoryAndAuthor(@PathVariable("pathCategory") String category,@PathVariable("pathAuthor") String author){
		return bookService.getByCategoryAndAuthor(category, author);
	}

//	http://localhost:8080/books/bookId?bookId=101
	@GetMapping("/books/bookId")
	Book getById(@RequestParam("bookId") Integer bookId) {
		return bookService.getById(bookId);
	}

//  http://localhost:8080/books/
	@GetMapping("/books")
	List<Book> getAll(){
		return bookService.getAll();
	}

//	http://localhost:8080/books/lowprice?price=1000
	@RequestMapping(value = "/books/lowprice", method = RequestMethod.GET)
	List<Book> getByPrice(@RequestParam("price") double price){
		return bookService.getByPrice(price);
	}
	
}
