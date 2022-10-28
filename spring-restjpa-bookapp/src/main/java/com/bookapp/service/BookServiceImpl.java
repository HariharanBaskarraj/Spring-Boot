package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exceptions.IDNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService {

	private IBookRepository bookRepository;

	@Autowired
	public void setBookRepository(IBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void addBook(Book book) {
		bookRepository.save(book); // If the current id is not there, it will create a new row.
	}

	@Override
	public void updateBook(Book book) {
		// If the current id is there, it will update.
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public Book getById(int bookId) {
		return bookRepository.findById(bookId)
				.orElseThrow(() -> new IDNotFoundException("ID Not Found"));

	}

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	public List<Book> getBookByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		return bookRepository.readByCategory(category);
	}

	@Override
	public List<Book> getBookByPrice(double price) {
		return bookRepository.findByPriceLessThan(price);
	}

	@Override
	public List<Book> getByPriceAuth(double cost, String author) {
		return bookRepository.findByPriceAuth(cost, author);
	}

	@Override
	public List<Book> getByCatAndAuth(String category, String author) {
		return bookRepository.findByCatAndAuth(category, author);
	}

}
