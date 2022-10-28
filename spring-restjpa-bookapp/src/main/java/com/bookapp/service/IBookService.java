/**
 * 
 */
package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IDNotFoundException;
import com.bookapp.model.Book;

/**
 * @author HariharanB
 *
 */
public interface IBookService {

	void addBook(Book book);

	void updateBook(Book book);

	void deleteBook(int bookId);
	
	Book getById(int bookId) throws IDNotFoundException;

	List<Book> getAll();

	// Derived Queries
	List<Book> getBookByAuthor(String author) throws BookNotFoundException;

	List<Book> getBookByCategory(String category);

	List<Book> getBookByPrice(double price);

	// Custom Query
	List<Book> getByPriceAuth(double price, String author);

	List<Book> getByCatAndAuth(String category, String author);
	
}
