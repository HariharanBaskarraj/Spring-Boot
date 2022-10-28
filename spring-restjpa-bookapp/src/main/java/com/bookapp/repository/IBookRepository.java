/**
 * 
 */
package com.bookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

/**
 * @author HariharanB
 *
 */
@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
	
//	@Query(name="findAuthNamed")
	List<Book> findByAuthor(String author);

	List<Book> readByCategory(String category);

	List<Book> findByPriceLessThan(double price);

	@Query("from Book b where b.price<=?1 and b.author=?2")
	List<Book> findByPriceAuth(double cost, String author);

	@Query("from Book b where b.category=?1 and b.author=?2")
	List<Book> findByCatAndAuth(String category, String author);

	@Query("from Book b where b.author=?1")
	List<Book> findBooksByAuth(String author);

}
