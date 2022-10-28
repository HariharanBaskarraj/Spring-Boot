package com.bookapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author HariharanB
 *
 */

//@NamedQuery(name="findByTitleAuth", query="from Book b where b.title=?1 and b.author=?2")

@NamedQueries({ 
	@NamedQuery(name="findByTitleAuth", query="from Book b where b.title=?1 and b.author=?2"), 
	@NamedQuery(name = "findAuthNamed", query = "from Book b where b.author=?1")
})

@NamedNativeQueries({
	@NamedNativeQuery(name = "findTotalCount", query = "select count(*) from book"),
	@NamedNativeQuery(name = "findMinCost", query = "select min(cost) from book"),
	@NamedNativeQuery(name = "findCatCost", query = "select * from book where category=?1 and cost<=?2")
})

@Entity
//JPA Converts this class into a table.
public class Book {
	private String title;
	@Id
	private Integer bookID;
	private String author;
	@Column(name="cost")
	private double price;
	private String category;

	public Book() {
		super();
	}

	public Book(String title, Integer bookID, String author, double price, String category) {
		super();
		this.title = title;
		this.bookID = bookID;
		this.author = author;
		this.price = price;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getBookID() {
		return bookID;
	}

	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", bookID=" + bookID + ", author=" + author + ", price=" + price + ", category="
				+ category + "]";
	}

}
