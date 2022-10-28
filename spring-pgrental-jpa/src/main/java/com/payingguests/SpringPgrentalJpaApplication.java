package com.payingguests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.payingguests.model.Category;
import com.payingguests.model.PayingGuest;
import com.payingguests.service.IPayingGuestService;

@SpringBootApplication
public class SpringPgrentalJpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringPgrentalJpaApplication.class, args);
	}
	
	private IPayingGuestService payingGuestService;
	@Autowired
	public void setPayingGuestService(IPayingGuestService payingGuestService) {
		this.payingGuestService = payingGuestService;
	}

	@Override
	public void run(String... args) throws Exception {
//		PayingGuest payingGuest = new PayingGuest(101,"Amigo's PG","Hyderabad",Category.GIRLS.category);
//		payingGuestService.addPayingGuest(payingGuest);
//		payingGuest = new PayingGuest(102,"Venkateshwara PG","Delhi",Category.BOYS.category);
//		payingGuestService.addPayingGuest(payingGuest);
//		payingGuest = new PayingGuest(103,"Sai Darshini Women's PG","Hyderabad",Category.GIRLS.category);
//		payingGuestService.addPayingGuest(payingGuest);
//		payingGuest = new PayingGuest(104,"My Home Luxury Men's Hostel","Coimbatore",Category.CO.category);
//		payingGuestService.addPayingGuest(payingGuest);
//		payingGuest = new PayingGuest(105,"Niroshan's Magic","Chennai",Category.CO.category);
//		payingGuestService.addPayingGuest(payingGuest);
//		payingGuest = new PayingGuest(106,"Classic Men's Hostel","Hyderabad",Category.BOYS.category);
//		payingGuestService.addPayingGuest(payingGuest);
//		payingGuest = new PayingGuest(107,"Home away from home","Chennai",Category.CO.category);
//		payingGuestService.addPayingGuest(payingGuest);
//		payingGuest = new PayingGuest(108,"Navadweepa Women's World","Coimbatore",Category.GIRLS.category);
//		payingGuestService.addPayingGuest(payingGuest);
//		payingGuest = new PayingGuest(109,"Alishka's Den","Delhi",Category.CO.category);
//		payingGuestService.addPayingGuest(payingGuest);
//		payingGuest = new PayingGuest(110,"Vinayaga Men's Hostel","Hyderabad",Category.BOYS.category);
//		payingGuestService.addPayingGuest(payingGuest);
//		payingGuest = new PayingGuest(111,"Sample Hostel","Hyderabad",Category.CO.category);
//		payingGuestService.addPayingGuest(payingGuest);

		System.out.println("Update Paying Guest: ");
		PayingGuest payingGuest = new PayingGuest(111,"Sample Hostel","Hyderabad",Category.CO.category);
		payingGuestService.updatePayingGuest(payingGuest);
		
		System.out.println("\nAll Paying Guests: ");
		payingGuestService.getAll().forEach(System.out::println);
		
		System.out.println("\nGet by Id: ");
		System.out.println(payingGuestService.getById(105));
		
		System.out.println("\nGet by location: (Hyderabad)");
		payingGuestService.getPayingGuestByLocation("Hyderabad").forEach(System.out::println);
		
		System.out.println("\nGet by category: (CO)");
		payingGuestService.getPayingGuestByCategory(Category.CO.category).forEach(System.out::println);
		
		System.out.println("\nDelete Paying Guest: ");
		payingGuestService.deletePayingGuest(111);
	}

}
