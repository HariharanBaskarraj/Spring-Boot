/**
 * 
 */
package com.bookapp.service;

import java.util.List;

import com.bookapp.model.Book;

/**
 * @author HariharanB
 *
 */
public interface IBookService {

	void addBook(Book book);

	void updateBook(Book book);

	void deleteBook(int bookId);

	Book getById(int bookId);

	List<Book> getAll();

	// Derived Queries
	List<Book> getBookByAuthor(String author);

	List<Book> getBookByCategory(String category);

	List<Book> getBookByPrice(double price);

	// Custom Query
	List<Book> getByPriceAuth(double price, String author);

	List<Book> getByCatAndAuth(String category, String author);

	List<Book> getBooksByAuth(String author);

	// Native Query
	List<Book> getBooksByCatPrice(String category, double price);

	int getTotalCount();
	
	int getMinPrice();

	List<Book> getBooksByMinPrice();
	
	// Named Query
	List<Book> getByTitleAuth(String title, String author);
	
	void updateBook(int bookId, double price);
	
}
