package com.payingguests.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payingguests.model.PayingGuest;
import com.payingguests.repository.IPayingGuestRepository;

@Service
public class PayingGuestServiceImpl implements IPayingGuestService {

	private IPayingGuestRepository payingGuestRepository;

	@Autowired
	public void setPayingGuestRepository(IPayingGuestRepository payingGuestRepository) {
		this.payingGuestRepository = payingGuestRepository;
	}

	@Override
	public void addPayingGuest(PayingGuest payingGuest) {
		payingGuestRepository.save(payingGuest);
	}

	@Override
	public void updatePayingGuest(PayingGuest payingGuest) {
		payingGuestRepository.save(payingGuest);
	}

	@Override
	public void deletePayingGuest(int payingGuestId) {
		payingGuestRepository.deleteById(payingGuestId);

	}

	@Override
	public PayingGuest getById(int payingGuestId) {
		return payingGuestRepository.findById(payingGuestId).get();
	}

	@Override
	public List<PayingGuest> getAll() {
		return payingGuestRepository.findAll();
	}

	@Override
	public List<PayingGuest> getPayingGuestByLocation(String location) {
		return payingGuestRepository.findByLocation(location);
	}

	@Override
	public List<PayingGuest> getPayingGuestByCategory(String category) {
		return payingGuestRepository.findByCategory(category);
	}

}
