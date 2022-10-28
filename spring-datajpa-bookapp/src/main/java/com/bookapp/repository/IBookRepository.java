/**
 * 
 */
package com.bookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

	@Query(value = "select * from book where category=?1 and cost<=?2", nativeQuery = true)
//	@Query(name = "findCatCost")
	List<Book> findBooksByCatPrice(String category, double price);

//	@Query(value = "select count(*) from book", nativeQuery = true)
	@Query(name="findTotalCount")
	int findTotalCount();
	
//	@Query(value = "select min(cost) from book", nativeQuery = true)
	@Query(name="findMinCost")
	int findMinPrice();

	@Query(value = "select * from book where cost=(select min(cost) from book)", nativeQuery = true)
	List<Book> findBooksByMinPrice();
	
	@Query(name="findByTitleAuth")
	List<Book> findBooksByTitleAuth(String title, String author);
	
	@Modifying // because here it is dml
	@Query(value="update Book set cost=?2 where bookid=?1",nativeQuery = true)
	void updateBook(int bookId, double price);

}
