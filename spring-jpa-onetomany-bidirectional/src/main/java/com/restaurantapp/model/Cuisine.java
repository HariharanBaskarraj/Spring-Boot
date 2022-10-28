/**
 * 
 */
package com.restaurantapp.model;

/**
 * @author HariharanB
 *
 */
public enum Cuisine {
	SOUTH("South-Indian"),
	NORTH("North-Indian"),
	CHINESE("Chinese"),
	ITALIAN("Italian");

	public String cuisine;

	private Cuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	
	
}
