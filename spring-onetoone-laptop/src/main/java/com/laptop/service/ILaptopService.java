/**
 * 
 */
package com.laptop.service;

import java.util.List;

import com.laptop.model.Laptop;

/**
 * @author HariharanB
 *
 */
public interface ILaptopService {

	void addLaptop(Laptop laptop);

	void updateLaptop(Laptop laptop);

	void deleteLaptop(int laptopId);

	Laptop getById(int laptopId);

	List<Laptop> getAll();

	List<Laptop> getByModel(String model);

	List<Laptop> getByModelAndOs(String model, String os);

	List<Laptop> getByBrand(String brand);

	List<Laptop> getByLesserPrice(double price);

	List<Laptop> getByMemory(String memory);

	List<Laptop> getByProcessor(String processor);

	List<Laptop> getByColor(String color);

	List<Laptop> getByProcessorAndMemory(String processor, String memory);

	List<Laptop> getByModelAndColor(String model, String color);
}
