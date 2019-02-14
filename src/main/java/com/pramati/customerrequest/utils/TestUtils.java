package com.pramati.customerrequest.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.data.jpa.domain.Specification;

import com.google.common.base.Joiner;
import com.pramati.customerrequest.pojo.ServiceRequest;

public class TestUtils {

	public  static Specification<ServiceRequest> builder(String specs) {
		SRSpecificationsBuilder builder = new SRSpecificationsBuilder();
		String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
		Pattern pattern = Pattern
				.compile("(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)([\\w-\\s:]+?)(\\p{Punct}?),");
		Matcher matcher = pattern.matcher(specs + ",");
		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(4), matcher.group(3), matcher.group(5));
		}
		Specification<ServiceRequest> spec = builder.build();
		return spec;
	}

}
