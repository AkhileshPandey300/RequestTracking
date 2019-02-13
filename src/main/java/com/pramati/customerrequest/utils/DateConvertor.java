package com.pramati.customerrequest.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertor {

	public static Timestamp convertStringToTimestamp(String dateString) {
		Timestamp timestamp = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date;

			date = dateFormat.parse(dateString);

			long time = date.getTime();
			timestamp = new Timestamp(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timestamp;
	}

}
