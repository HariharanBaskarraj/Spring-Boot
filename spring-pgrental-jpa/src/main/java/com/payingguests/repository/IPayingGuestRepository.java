/**
 * 
 */
package com.payingguests.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payingguests.model.PayingGuest;

/**
 * @author HariharanB
 *
 */
@Repository
public interface IPayingGuestRepository extends JpaRepository<PayingGuest, Integer> {
	
	List<PayingGuest> findByLocation(String location);

	List<PayingGuest> findByCategory(String category);

}
