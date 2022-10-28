package com.payingguests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.payingguests.model.Category;
import com.payingguests.model.PayingGuest;
import com.payingguests.service.IPayingGuestService;

@SpringBootApplication
public class SpringPgrentalJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringPgrentalJdbcApplication.class, args);
	}

	@Autowired
	IPayingGuestService payingGuestService;
	public SpringPgrentalJdbcApplication(IPayingGuestService payingGuestService) {
		super();
		this.payingGuestService = payingGuestService;
	}

	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Adding Paying Guest... ");
		payingGuestService.addPayingGuest(new PayingGuest(111,"Checking PG","Delhi",Category.CO.category)); 
		System.out.println("\nUpdating the category...");
		payingGuestService.updatePayingGuest(111, Category.BOYS.category);
		System.out.println("\nGetting all the Paying Guests...");
		payingGuestService.getAllPayingGuest().forEach(System.out::println);
		System.out.println("\nGetting Paying Guests by ID.....");
		System.out.println(payingGuestService.getPayingGuestById(109));
		System.out.println("\nGetting Paying Guests by location...");
		payingGuestService.getPayingGuestByLocation("Delhi").forEach(System.out::println);
		System.out.println("\nGetting Paying Guests by category...");
		payingGuestService.getPayingGuestByCategory(Category.GIRLS.category).forEach(System.out::println);
		System.out.println("\nDeleting the Paying Guest...");
		payingGuestService.deletePayingGuest(111);
		
	}

}
