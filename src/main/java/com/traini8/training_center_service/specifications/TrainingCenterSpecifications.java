package com.traini8.training_center_service.specifications;
import org.springframework.data.jpa.domain.Specification;
import com.traini8.training_center_service.entities.TrainingCenter;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class TrainingCenterSpecifications {

    public static Specification<TrainingCenter> filterTrainingCenters(String city, String state, String course) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (city != null) {
                predicates.add(criteriaBuilder.equal(root.get("address").get("city"), city));
            }
            if (state != null) {
                predicates.add(criteriaBuilder.equal(root.get("address").get("state"), state));
            }
            if (course != null) {
                predicates.add(criteriaBuilder.isMember(course, root.get("coursesOffered")));
            }
            if (predicates.isEmpty()) {
                return criteriaBuilder.disjunction();
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
