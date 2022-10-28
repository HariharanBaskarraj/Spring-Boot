/**
 * 
 */
package com.restaurantapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author HariharanB
 *
 */
@Entity
public class Item {
	@Id
	@GeneratedValue(generator = "item_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "item_gen", sequenceName = "item_seq", initialValue = 201, allocationSize = 1)
	private Integer itemId;

	@Column(length = 35)
	private String itemName;

	@Column(length = 35)
	private String cuisine;

	@Column(length = 15)
	@Enumerated(EnumType.STRING)
	private Category category;

	@Column(length = 15)
	@Enumerated(EnumType.STRING)
	private Type itemType;

	private double price;

	public Item() {
		super();
	}

	public Item(String itemName, String cuisine, Category category, Type itemType, double price) {
		super();
		this.itemName = itemName;
		this.cuisine = cuisine;
		this.category = category;
		this.itemType = itemType;
		this.price = price;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Type getItemType() {
		return itemType;
	}

	public void setItemType(Type itemType) {
		this.itemType = itemType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", cuisine=" + cuisine + ", category=" + category
				+ ", itemType=" + itemType + ", price=" + price + "]";
	}

}
