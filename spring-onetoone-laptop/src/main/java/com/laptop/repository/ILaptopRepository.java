/**
 * 
 */
package com.laptop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.laptop.model.Laptop;

/**
 * @author HariharanB
 *
 */
@Repository
public interface ILaptopRepository extends JpaRepository<Laptop, Integer> {

	List<Laptop> findByModel(String model);

	List<Laptop> findByBrand(String brand);

	@Query("from Laptop l inner join l.features f where l.model=?1 and f.os=?2")
	List<Laptop> findByModelAndOs(String model, String os);

	@Query("from Laptop l inner join l.features f where l.price<=?1")
	List<Laptop> findByLesserPrice(double price);

	@Query("from Laptop l inner join l.features f where f.memory=?1")
	List<Laptop> findByMemory(String memory);

	@Query("from Laptop l inner join l.features f where f.processor=?1")
	List<Laptop> findByProcessor(String processor);

	@Query("from Laptop l inner join l.features f where f.color=?1")
	List<Laptop> findByColor(String color);

	@Query("from Laptop l inner join l.features f where f.processor=?1 and f.memory=?2")
	List<Laptop> findByProcessorAndMemory(String processor, String memory);

	@Query("from Laptop l inner join l.features f where l.model=?1 and f.color=?2")
	List<Laptop> findByModelAndColor(String model, String color);
}
