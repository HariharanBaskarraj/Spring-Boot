package com.payingguests.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.payingguests.exceptions.PayingGuestNotFoundException;
import com.payingguests.model.PayingGuest;
import com.payingguests.util.PayingGuestMapper;
import com.payingguests.util.Queries;

@Repository
public class PayingGuestDaoImpl implements IPayingGuestDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addPayingGuest(PayingGuest payingGuest) {
		Object[] payingGuests = { payingGuest.getPayingGuestId(), payingGuest.getPayingGuestName(),
				payingGuest.getLocation(), payingGuest.getCategory() };
		jdbcTemplate.update(Queries.INSERTPGQUERY, payingGuests);
	}

	@Override
	public int updatePayingGuest(int payingGuestId, String category) {
		return jdbcTemplate.update(Queries.UPDATEPGCATEGORY, category, payingGuestId);
	}

	@Override
	public List<PayingGuest> findAllPayingGuest() throws PayingGuestNotFoundException {
		return jdbcTemplate.query(Queries.SELECTPGQUERY, new PayingGuestMapper());
	}

	@Override
	public PayingGuest findPayingGuestById(int payingGuestId) throws PayingGuestNotFoundException {
		return jdbcTemplate.queryForObject(Queries.QUERYBYPGID, new PayingGuestMapper(), payingGuestId);
	}

	@Override
	public List<PayingGuest> findPayingGuestByLocation(String location) throws PayingGuestNotFoundException {
		return jdbcTemplate.query(Queries.QUERYBYLOCATION, new PayingGuestMapper(), location);
	}

	@Override
	public List<PayingGuest> findPayingGuestByCategory(String category) throws PayingGuestNotFoundException {
		return jdbcTemplate.query(Queries.QUERYBYCATEGORY, new PayingGuestMapper(), category);
	}

	@Override
	public int deletePayingGuest(int payingGuestId) {
		return jdbcTemplate.update(Queries.DELETEPGQUERY,payingGuestId);
	}

}
