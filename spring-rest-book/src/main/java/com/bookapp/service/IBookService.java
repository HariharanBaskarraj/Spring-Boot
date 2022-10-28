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
	List<Book> getByAuthor(String author);

	List<Book> getByCategoryAndAuthor(String category, String author);

	Book getById(Integer bookId);

	List<Book> getAll();

	List<Book> getByPrice(double price);
}
