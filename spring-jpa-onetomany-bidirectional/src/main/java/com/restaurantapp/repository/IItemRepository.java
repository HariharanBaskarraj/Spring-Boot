package com.restaurantapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Item;
import com.restaurantapp.model.Type;

@Repository
public interface IItemRepository extends JpaRepository<Item, Integer> {
	List<Item> findByRestaurantName(String restaurantName);

	List<Item> findByCategory(Category category);

	@Query("from Restaurant r inner join r.items i where r.name=?1 and i.category=?2")
	List<Item> findByHotelCategory(String restaurantName, Category category);

	@Query("from Restaurant r inner join r.items i where r.name=?1 and r.type=?2")
	List<Item> findByHotelItemType(String restaurantName, Type itemType);

	@Query("from Restaurant r inner join r.items i where r.name=?1 and r.city=?2")
	List<Item> findByCuisineAndCity(String cuisine, String city);

	@Query("from Restaurant r inner join r.items i where i.itemName=?1 and r.ratings=?2")
	List<Item> findByItemNameRatings(String itemName, double ratings);
}
