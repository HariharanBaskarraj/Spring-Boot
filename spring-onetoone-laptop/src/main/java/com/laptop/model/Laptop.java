/**
 * 
 */
package com.laptop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author HariharanB
 *
 */
@Entity
public class Laptop {

	@Id
	@GeneratedValue(generator = "laptop_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "laptop_gen", sequenceName = "laptop_seq", initialValue = 101, allocationSize = 1)
	private Integer laptopId;
	private String brand;
	private double price;
	private String model;

	@OneToOne
	@Cascade(value = CascadeType.ALL)
	@JoinColumn(name = "features_id")
	private Features features;

	public Laptop() {
		super();
	}

	public Laptop(String brand, double price, String model, Features features) {
		super();
		this.brand = brand;
		this.price = price;
		this.model = model;
		this.features = features;
	}

	public Integer getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(Integer laptopId) {
		this.laptopId = laptopId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Features getFeatures() {
		return features;
	}

	public void setFeatures(Features features) {
		this.features = features;
	}

	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", brand=" + brand + ", price=" + price + ", model=" + model
				+ ", features=" + features + "]";
	}

}
