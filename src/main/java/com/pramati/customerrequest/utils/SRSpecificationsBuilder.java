package com.pramati.customerrequest.utils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import com.pramati.customerrequest.pojo.ServiceRequest;
import com.pramati.customerrequest.repository.ServiceRequesrSpecification;

public class SRSpecificationsBuilder {
    private final List<SpecSearchCriteria> params;

    public SRSpecificationsBuilder() {
        params = new ArrayList<>();
    }
    public final SRSpecificationsBuilder with(final String key, final String operation, final Object value, final String prefix, final String suffix) {
        return with(null, key, operation, value, prefix, suffix);
    }

    public final SRSpecificationsBuilder with(final String orPredicate, final String key, final String operation, final Object value, final String prefix, final String suffix) {
        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        if (op != null) {
            if (op == SearchOperation.EQUALITY) { 
                final boolean startWithAsterisk = prefix != null && prefix.contains(SearchOperation.ZERO_OR_MORE_REGEX);
                final boolean endWithAsterisk = suffix != null && suffix.contains(SearchOperation.ZERO_OR_MORE_REGEX);

                if (startWithAsterisk && endWithAsterisk) {
                    op = SearchOperation.CONTAINS;
                } else if (startWithAsterisk) {
                    op = SearchOperation.ENDS_WITH;
                } else if (endWithAsterisk) {
                    op = SearchOperation.STARTS_WITH;
                }
            }
            params.add(new SpecSearchCriteria(orPredicate, key, op, value));
        }
        return this;
    }

    public Specification<ServiceRequest> build() {
        if (params.size() == 0)
            return null;

        Specification<ServiceRequest> result = new ServiceRequesrSpecification(params.get(0));
     
        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
              ? Specification.where(result).or(new ServiceRequesrSpecification(params.get(i))) 
              : Specification.where(result).and(new ServiceRequesrSpecification(params.get(i)));
        }
        
        return result;
    }

    public final SRSpecificationsBuilder with(ServiceRequesrSpecification spec) {
        params.add(spec.getCriteria());
        return this;
    }

    public final SRSpecificationsBuilder with(SpecSearchCriteria criteria) {
        params.add(criteria);
        return this;
    }
}
