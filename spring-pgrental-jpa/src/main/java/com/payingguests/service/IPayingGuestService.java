/**
 * 
 */
package com.payingguests.service;

import java.util.List;

import com.payingguests.model.PayingGuest;

/**
 * @author HariharanB
 *
 */
public interface IPayingGuestService {

	void addPayingGuest(PayingGuest payingGuest);

	void updatePayingGuest(PayingGuest payingGuest);

	void deletePayingGuest(int payingGuestId);

	PayingGuest getById(int payingGuestId);

	List<PayingGuest> getAll();

	List<PayingGuest> getPayingGuestByLocation(String location);

	List<PayingGuest> getPayingGuestByCategory(String category);

	
}
