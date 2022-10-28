/**
 * 
 */
package com.employee.model;

/**
 * @author HariharanB
 *
 */
public enum Category {

	FRONT("Front end"),
	BACK("Back end"),
	TEST("Testing"),
	PHILOSOPHY("Philosophy");
	
	private String category;

	private Category(String category) {
		this.category = category;
	}
	
	
}
