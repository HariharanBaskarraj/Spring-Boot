/**
 * 
 */
package com.employee.model;

/**
 * @author HariharanB
 *
 */
public enum Mode {

	ONLINE ("Virtual"),
	OFFLINE ("In-person");
	
	private String mode;

	private Mode(String mode) {
		this.mode = mode;
	}
	
}
