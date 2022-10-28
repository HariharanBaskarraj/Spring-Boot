package com.restaurantapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Cuisine;
import com.restaurantapp.model.Item;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.Type;
import com.restaurantapp.service.IItemService;
import com.restaurantapp.service.IRestaurantService;

@SpringBootApplication
public class SpringJpaOnetomanyBidirectionalApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOnetomanyBidirectionalApplication.class, args);
	}

	private IRestaurantService restaurantService;

	@Autowired
	public void setRestaurantService(IRestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	
	private IItemService itemService;

	@Autowired
	public void setItemService(IItemService itemService) {
		this.itemService = itemService;
	}
	
	@Override
	public void run(String... args) throws Exception {
//		Item itemOne = new Item("Dosa", Cuisine.SOUTH.cuisine, Category.BREAKFAST, Type.VEG, 50);
//		Item itemTwo = new Item("Idli", Cuisine.SOUTH.cuisine, Category.BREAKFAST, Type.VEG, 30);
//		Item itemThree = new Item("Venpongal", Cuisine.SOUTH.cuisine, Category.BREAKFAST, Type.VEG, 110);
//		Set<Item> items = new HashSet<Item>(Arrays.asList(itemOne, itemTwo, itemThree));
//		Restaurant restaurant = new Restaurant("Breakfast Express", "Kukatpally", Type.VEG, 4.5, items);
//		restaurantService.addRestaurant(restaurant);
//		itemOne = new Item("Chicken Curry", Cuisine.SOUTH.cuisine, Category.MAINCOURSE, Type.NONVEG, 50);
//		itemTwo = new Item("Paneer Kofta", Cuisine.NORTH.cuisine, Category.STARTERS, Type.VEG, 30);
//		itemThree = new Item("Falooda", Cuisine.SOUTH.cuisine, Category.DESSERTS, Type.VEG, 110);
//		items = new HashSet<Item>(Arrays.asList(itemOne, itemTwo, itemThree));
//		restaurant = new Restaurant("Biryani Times", "Madhapur", Type.NONVEG, 3.7, items);
//		restaurantService.addRestaurant(restaurant);
//		itemOne = new Item("Aracini", Cuisine.ITALIAN.cuisine, Category.MAINCOURSE, Type.NONVEG, 250);
//		itemTwo = new Item("Lasagna", Cuisine.ITALIAN.cuisine, Category.MAINCOURSE, Type.NONVEG, 330);
//		itemThree = new Item("Risotto", Cuisine.ITALIAN.cuisine, Category.MAINCOURSE, Type.NONVEG, 410);
//		items = new HashSet<Item>(Arrays.asList(itemOne, itemTwo, itemThree));
//		restaurant = new Restaurant("Italian Delight", "Gachibowli", Type.NONVEG, 4.2, items);
//		restaurantService.addRestaurant(restaurant);
//		itemOne = new Item("Kung Pao Chicken", Cuisine.CHINESE.cuisine, Category.STARTERS, Type.NONVEG, 280);
//		itemTwo = new Item("Ma Po Tofu", Cuisine.CHINESE.cuisine, Category.MAINCOURSE, Type.NONVEG, 450);
//		itemThree = new Item("Cantonese Dimsum", Cuisine.CHINESE.cuisine, Category.STARTERS, Type.VEG, 300);
//		Item itemFour = new Item("Carbonated Drinks", Cuisine.CHINESE.cuisine, Category.BEVERAGES, Type.VEG, 60);
//		Item itemFive = new Item("Icecream Scoop", Cuisine.CHINESE.cuisine, Category.DESSERTS, Type.VEG, 75);
//		items = new HashSet<Item>(Arrays.asList(itemOne, itemTwo, itemThree, itemFour, itemFive));
//		restaurant = new Restaurant("Chinese Sparklers", "Durgam Cheruvu", Type.NONVEG, 4.9, items);
//		restaurantService.addRestaurant(restaurant);
//		itemOne = new Item("Hamburger", Cuisine.NORTH.cuisine, Category.FASTFOOD, Type.NONVEG, 280);
//		itemTwo = new Item("Chicken Legs", Cuisine.NORTH.cuisine, Category.FASTFOOD, Type.NONVEG, 450);
//		itemThree = new Item("French fries", Cuisine.NORTH.cuisine, Category.FASTFOOD, Type.VEG, 300);
//		itemFour = new Item("Coca cola", Cuisine.NORTH.cuisine, Category.BEVERAGES, Type.VEG, 60);
//		itemFive = new Item("Icecream Cone", Cuisine.NORTH.cuisine, Category.DESSERTS, Type.VEG, 95);
//		Item itemSix = new Item("Donuts", Cuisine.NORTH.cuisine, Category.DESSERTS, Type.VEG, 175);
//		items = new HashSet<Item>(Arrays.asList(itemOne, itemTwo, itemThree, itemFour, itemFive, itemSix));
//		restaurant = new Restaurant("Express Fastfoods", "Durgam Cheruvu", Type.NONVEG, 4.9, items);
//		restaurantService.addRestaurant(restaurant);		
		
		System.out.println(itemService.getById(205));
		itemService.getByRestaurantName("Express Fastfoods");
		itemService.getByCategory(Category.MAINCOURSE);
		itemService.getByCuisineAndCity("Chinese", "Durgam Cheruvu");
		
		Restaurant addRestaurant = restaurantService.getById(105);
		Item addItem = new Item("Dal Tadka",Cuisine.NORTH.cuisine,Category.BREAKFAST,Type.VEG,230);
		addItem.setRestaurant(addRestaurant);
		
		
	}

}
