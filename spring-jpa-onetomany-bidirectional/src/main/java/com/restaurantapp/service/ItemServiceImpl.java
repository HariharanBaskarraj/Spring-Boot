package com.restaurantapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Item;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.Type;
import com.restaurantapp.repository.IItemRepository;

@Service
public class ItemServiceImpl implements IItemService {

	private IItemRepository itemRepository;
	@Autowired
	public void setItemRepository(IItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public void addItem(Item item) {

	}

	@Override
	public void updateItem(Restaurant restaurant, Item item) {
		
	}

	@Override
	public void deleteItem(int itemId) {
		
	}

	@Override
	public Item getById(int itemId) {
		return itemRepository.findById(itemId).get();
	}

	@Override
	public List<Item> getByRestaurantName(String restaurantName) {
		return itemRepository.findByRestaurantName(restaurantName);
	}

	@Override
	public List<Item> getByCategory(Category category) {
		return itemRepository.findByCategory(category);
	}

	@Override
	public List<Item> getByHotelCategory(String restaurantName, Category category) {
		return itemRepository.findByHotelCategory(restaurantName, category);
	}

	@Override
	public List<Item> getByHotelItemType(String restaurantName, Type itemType) {
		return itemRepository.findByHotelItemType(restaurantName, itemType);
	}

	@Override
	public List<Item> getByCuisineAndCity(String cuisine, String city) {
		return itemRepository.findByCuisineAndCity(cuisine, city);
	}

	@Override
	public List<Item> getByItemNameRating(String itemName, double ratings) {
		return itemRepository.findByItemNameRatings(itemName, ratings);
	}

}
