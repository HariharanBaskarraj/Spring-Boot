/**
 * 
 */
package com.laptop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author HariharanB
 *
 */
@Entity
public class Features {
	@Id
	@GeneratedValue(generator = "features_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "features_gen", sequenceName = "features_seq", initialValue = 201, allocationSize = 1)
	private Integer featuresId;

	private String os;
	private String memory;
	private String processor;
	private String color;

	public Features() {
		super();
	}

	public Features(String os, String memory, String processor, String color) {
		super();
		this.os = os;
		this.memory = memory;
		this.processor = processor;
		this.color = color;
	}

	public Integer getFeaturesId() {
		return featuresId;
	}

	public void setFeaturesId(Integer featuresId) {
		this.featuresId = featuresId;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Features [featuresId=" + featuresId + ", os=" + os + ", memory=" + memory + ", processor=" + processor
				+ ", color=" + color + "]";
	}

}
