/**
 * 
 */
package com.restaurantapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.Type;

/**
 * @author HariharanB
 *
 */
@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer> {

	List<Restaurant> findByCity(String city);

	List<Restaurant> findByType(Type type);

	List<Restaurant> findByRatings(double rating);
	
	@Query("from Restaurant r inner join r.items i where i.itemName=?1")
	List<Restaurant> findByItemName(String itemName);

	@Query("from Restaurant r inner join r.items i where i.itemName=?1 and i.category=?2")
	List<Restaurant> findByItemNameCategory(String itemName, Category category);

	@Query("from Restaurant r inner join r.items i where i.cuisine=?1")
	List<Restaurant> findByCuisine(String cuisine);

	@Query("from Restaurant r inner join r.items i where i.category=?1")
	List<Restaurant> findByCategory(Category category);

	@Query("from Restaurant r inner join r.items i where i.cuisine=?1 and r.type=?2")
	List<Restaurant> findByCuisineAndType(String cuisine, Type type);

	@Query("from Restaurant r inner join r.items i where i.itemName=?1 and i.price<=?2")
	List<Restaurant> findByItemNameLessPrice(String itemName, double price);
	}
