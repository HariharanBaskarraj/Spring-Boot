/**
 * 
 */
package com.bookapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.model.Book;

/**
 * @author HariharanB
 *
 */
@Service
public class BookServiceImpl implements IBookService {

	private BookDetails details;
	@Autowired
	public void setDetails(BookDetails details) {
		this.details = details;
	}

	@Override
	public List<Book> getByAuthor(String author) {
		return details.getBooks().stream().filter(book -> book.getAuthor().equalsIgnoreCase(author))
				.collect(Collectors.toList());
	}

	@Override
	public List<Book> getByCategoryAndAuthor(String category, String author) {
		return details.getBooks().stream().filter(
				book -> book.getCategory().equalsIgnoreCase(category) && book.getAuthor().equalsIgnoreCase(author))
				.collect(Collectors.toList());
	}

	@Override
	public Book getById(Integer bookId) {
		return details.getBooks().stream().filter(book -> book.getBookId() == bookId).findFirst().get();
	}

	@Override
	public List<Book> getAll() {
		return details.getBooks();
	}

	@Override
	public List<Book> getByPrice(double price) {
		return details.getBooks().stream().filter(book -> book.getPrice() <= price).collect(Collectors.toList());
	}

}
