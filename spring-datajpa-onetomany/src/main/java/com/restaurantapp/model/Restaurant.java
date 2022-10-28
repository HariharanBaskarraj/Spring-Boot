/**
 * 
 */
package com.restaurantapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


/**
 * @author HariharanB
 *
 */
@Entity
public class Restaurant {
	@Id
	@GeneratedValue(generator = "restaurant_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "restaurant_gen", sequenceName = "restaurant_seq", initialValue = 101, allocationSize = 1)
	private Integer restaurantId;
	@Column(length = 35)
	private String name;
	@Column(length = 35)
	private String city;
	@Column(length = 15)
	@Enumerated(EnumType.STRING)
	private Type type;

	private double ratings;
	@OneToMany (cascade =CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "rest_id")
	private Set<Item> items;

	public Restaurant() {
		super();
	}

	public Restaurant(String name, String city, Type type, double ratings, Set<Item> items) {
		super();
		this.name = name;
		this.city = city;
		this.type = type;
		this.ratings = ratings;
		this.items = items;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", city=" + city + ", type=" + type
				+ ", ratings=" + ratings + ", items=" + items + "]";
	}

}
