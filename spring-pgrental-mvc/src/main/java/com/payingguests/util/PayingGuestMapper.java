package com.payingguests.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.payingguests.model.PayingGuest;

public class PayingGuestMapper implements RowMapper<PayingGuest> {

	@Override
	public PayingGuest mapRow(ResultSet rs, int rowNum) throws SQLException {
		PayingGuest payingGuest = new PayingGuest();
		payingGuest.setPayingGuestId(rs.getInt("PGId"));
		payingGuest.setPayingGuestName(rs.getString("PGName"));
		payingGuest.setLocation(rs.getString("Location"));
		payingGuest.setCategory(rs.getString("Category"));
		return payingGuest;
	}

}
