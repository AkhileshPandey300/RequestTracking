package com.pramati.customerrequest.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.pramati.customerrequest.pojo.ServiceRequest;
import com.pramati.customerrequest.utils.DateConvertor;
import com.pramati.customerrequest.utils.SpecSearchCriteria;

public class ServiceRequesrSpecification implements Specification<ServiceRequest> {

	private static final long serialVersionUID = -5890953512704135810L;
	private SpecSearchCriteria criteria;

	public ServiceRequesrSpecification(final SpecSearchCriteria criteria) {
		super();
		this.criteria = criteria;
	}

	public SpecSearchCriteria getCriteria() {
		return criteria;
	}

	@Override
	public Predicate toPredicate(final Root<ServiceRequest> root, final CriteriaQuery<?> query,
			final CriteriaBuilder builder) {
		switch (criteria.getOperation()) {
		case EQUALITY:
			return builder.equal(root.get(criteria.getKey()), criteria.getValue());
		case NEGATION:
			return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
		case GREATER_THAN:
			return builder.greaterThan(root.get(criteria.getKey()),
					DateConvertor.convertStringToTimestamp(criteria.getValue().toString()));
		case LESS_THAN:
			return builder.lessThan(root.get(criteria.getKey()),
					DateConvertor.convertStringToTimestamp(criteria.getValue().toString()));
		case LIKE:
			return builder.like(root.get(criteria.getKey()), criteria.getValue().toString());
		case STARTS_WITH:
			return builder.like(root.get(criteria.getKey()), criteria.getValue() + "%");
		case ENDS_WITH:
			return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue());
		case CONTAINS:
			return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
		default:
			return null;
		}
	}

}