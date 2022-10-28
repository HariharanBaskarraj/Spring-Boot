/**
 * 
 */
package com.laptop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptop.model.Laptop;
import com.laptop.repository.ILaptopRepository;

/**
 * @author HariharanB
 *
 */
@Service
public class LaptopServiceImpl implements ILaptopService {

	private ILaptopRepository laptopRepository;

	@Autowired
	public void setLaptopRepository(ILaptopRepository laptopRepository) {
		this.laptopRepository = laptopRepository;
	}

	@Override
	public void addLaptop(Laptop laptop) {
		laptopRepository.save(laptop);

	}

	@Override
	public void updateLaptop(Laptop laptop) {
		laptopRepository.save(laptop);
	}

	@Override
	public void deleteLaptop(int laptopId) {
		laptopRepository.deleteById(laptopId);
	}

	@Override
	public Laptop getById(int laptopId) {
		return laptopRepository.findById(laptopId).get();
	}

	@Override
	public List<Laptop> getAll() {
		return laptopRepository.findAll();
	}

	@Override
	public List<Laptop> getByModel(String model) {
		return laptopRepository.findByModel(model);
	}

	@Override
	public List<Laptop> getByModelAndOs(String model, String os) {
		return laptopRepository.findByModelAndOs(model, os);
	}

	@Override
	public List<Laptop> getByBrand(String brand) {
		return laptopRepository.findByBrand(brand);
	}

	@Override
	public List<Laptop> getByLesserPrice(double price) {
		return laptopRepository.findByLesserPrice(price);
	}

	@Override
	public List<Laptop> getByMemory(String memory) {
		return laptopRepository.findByMemory(memory);
	}

	@Override
	public List<Laptop> getByProcessor(String processor) {
		return laptopRepository.findByProcessor(processor);
	}

	@Override
	public List<Laptop> getByColor(String color) {
		return laptopRepository.findByColor(color);
	}

	@Override
	public List<Laptop> getByProcessorAndMemory(String processor, String memory) {
		return laptopRepository.findByProcessorAndMemory(processor, memory);
	}

	@Override
	public List<Laptop> getByModelAndColor(String model, String color) {
		return laptopRepository.findByModelAndColor(model, color);
	}

}
