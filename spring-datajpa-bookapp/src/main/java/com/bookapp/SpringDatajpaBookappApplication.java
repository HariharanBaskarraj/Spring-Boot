package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringDatajpaBookappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaBookappApplication.class, args);
	}

	@Autowired
	private IBookService bookService;

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public void run(String... args) throws Exception {
//		Book book = new Book("Charlotte's Web", 4, "E.B. White", 450, "Story");
//		bookService.addBook(book);
//		book = new Book("Mieko and the fifth treasure", 5, "Elanor Coerr", 600, "Adventure");
//		bookService.addBook(book);
//		book = new Book("The outsiders", 6, "S. E. Hinton", 540, "Adventure");
//		bookService.addBook(book);
//		Book book = new Book("13 Reasons why", 7, "Jay Asher", 2999, "Story");
//		bookService.addBook(book);
//		book = new Book("Number the stars", 8, "Lois Lowry", 299, "Selfhelp");
//		bookService.addBook(book);
//		book = new Book("The old man and the sea", 9, "Lois Lowry", 800, "Adventure");
//		bookService.addBook(book);
//		Book book = new Book("Secret",1,"Rhonde",500,"Selfhelp");
//		bookService.updateBook(book);
//		book = new Book("PS",2,"Kalki",1500,"Fiction");
//		bookService.addBook(book);
//		book = new Book("Sherlock Holmes",3,"Doyle",150,"Fiction");
//		bookService.addBook(book);

//		System.out.println("Update books");
//		Book book =bookService.getById(2);
//		book.setAuthor("Kalki Krishnamurthy");
//		book.setTitle("Ponniyin Selvan");
//		bookService.updateBook(book);

		System.out.println("All books: ");
		bookService.getAll().forEach(System.out::println);
		
		System.out.println("\nGet by Id: ");
		System.out.println(bookService.getById(1));
		
		System.out.println("\nGet by author: (Kalki)");
		bookService.getBookByAuthor("Kalki Krishnamurthy").forEach(System.out::println);
		
		System.out.println("\nGet by category: (Fiction)");
		bookService.getBookByCategory("Fiction").forEach(System.out::println);
		
		System.out.println("\nGet lesser price: (550)");
		bookService.getBookByPrice(550).forEach(System.out::println);
		
		System.out.println("\nGet by author (custom):(Lois Lowry)");
		bookService.getBooksByAuth("Lois Lowry").forEach(System.out::println);
		
		System.out.println("\nGet by author and price:");
		bookService.getByPriceAuth(300, "Lois Lowry").forEach(System.out::println);
		
		System.out.println("\nGet by author and category:");
		bookService.getByCatAndAuth("Story", "Jay Asher").forEach(System.out::println);
		
		System.out.println("\nGet by category and price: (native)");
		bookService.getBooksByCatPrice("Fiction", 1000).forEach(System.out::println);
		
		System.out.println("\nGet count:");
		System.out.println(bookService.getTotalCount());
		
		System.out.println("\nMinimum price:");
		bookService.getBooksByMinPrice().forEach(System.out::println);
		
		System.out.println("\nGet title and author: (named)");
		bookService.getByTitleAuth("Sherlock Holmes", "Doyle").forEach(System.out::println);
		
		System.out.println("\nUpdate process: ");
		bookService.updateBook(2, 1499);
	}

}
