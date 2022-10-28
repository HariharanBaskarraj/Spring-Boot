/**
 * 
 */
package com.restaurantapp.model;

/**
 * @author HariharanB
 *
 */
public enum Type {

	VEG("Vegetarian"),
	NONVEG("Non-Vegetarian");
	
	public String type;

	private Type(String type) {
		this.type = type;
	}
	
}
