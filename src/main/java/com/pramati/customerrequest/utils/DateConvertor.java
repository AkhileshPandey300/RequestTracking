package com.pramati.customerrequest.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertor {

	public static Timestamp convertStringToTimestamp(String dateString) {

		Timestamp timestamp = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
			Date parsedDate = dateFormat.parse(dateString);
			timestamp = new java.sql.Timestamp(parsedDate.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timestamp;
	}

}
