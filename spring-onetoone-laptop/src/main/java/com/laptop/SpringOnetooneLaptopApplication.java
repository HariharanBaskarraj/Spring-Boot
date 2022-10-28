package com.laptop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.laptop.model.Features;
import com.laptop.model.Laptop;
import com.laptop.service.ILaptopService;

@SpringBootApplication
public class SpringOnetooneLaptopApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringOnetooneLaptopApplication.class, args);
	}

	private ILaptopService laptopService;
	
	@Autowired
	public void setLaptopService(ILaptopService laptopService) {
		this.laptopService = laptopService;
	}

	@Override
	public void run(String... args) throws Exception {
		Features features = new Features("Windows", "1 TB","Intel core","Blue");
		Laptop laptop = new Laptop("Dell",75000,"L4",features);
		laptopService.addLaptop(laptop);
		features = new Features("Windows", "512 GB","Ryzen","Red");
		laptop = new Laptop("Dell",60000,"G7",features);
		laptopService.addLaptop(laptop);
		features = new Features("Linux", "512 GB","Intel core","Black");
		laptop = new Laptop("HP",65000,"E5",features);
		laptopService.addLaptop(laptop);
		features = new Features("Windows", "1 TB","Ryzen","Black");
		laptop = new Laptop("HP",90000,"L8",features);
		laptopService.addLaptop(laptop);
		
		laptopService.getAll().forEach(System.out::println);
		laptopService.getByBrand("HP").forEach(System.out::println);
		laptopService.getByColor("Black").forEach(System.out::println);
		laptopService.getByMemory("1 TB").forEach(System.out::println);
		laptopService.getByModelAndColor("G7", "Red").forEach(System.out::println);
		laptopService.getByModelAndOs("L4", "Windows").forEach(System.out::println);
		laptopService.getByProcessor("Intel core").forEach(System.out::println);
		laptopService.getByProcessorAndMemory("Intel core", "1 TB").forEach(System.out::println);
		laptopService.getByLesserPrice(70000);
		laptopService.getById(102);
		
	}

}
