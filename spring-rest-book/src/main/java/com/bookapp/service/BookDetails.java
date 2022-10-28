/**
 * 
 */
package com.bookapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookapp.model.Book;

/**
 * @author HariharanB
 *
 */
@Component
public class BookDetails {

	private List<Book> showBooks() {
		return Arrays.asList(new Book(101, "Charlotte's Web", "E.B. White", "Story", 450),
				new Book(102, "The outsiders", "S. E. Hinton", "Adventure", 540),
				new Book(103, "13 Reasons why", "Jay Asher", "Story", 2999),
				new Book(104, "Number the stars", "Lois Lowry", "Selfhelp", 299),
				new Book(105, "The old man and the sea", "Lois Lowry", "Adventure", 800));
	}

	public List<Book> getBooks() {
		return showBooks();
	}
}
