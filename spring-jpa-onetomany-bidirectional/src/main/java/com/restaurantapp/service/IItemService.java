package com.restaurantapp.service;

import java.util.List;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Item;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.Type;

public interface IItemService {

	void addItem(Item item);

	void updateItem(Restaurant restaurant, Item item);

	void deleteItem(int itemId);

	Item getById(int itemId);

	List<Item> getByRestaurantName(String restaurantName);

	List<Item> getByCategory(Category category);

	List<Item> getByHotelCategory(String restaurantName, Category category);

	List<Item> getByHotelItemType(String restaurantName, Type itemType);

	List<Item> getByCuisineAndCity(String cuisine, String city);

	List<Item> getByItemNameRating(String itemName, double rating);
}
