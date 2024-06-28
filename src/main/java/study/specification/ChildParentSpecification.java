package study.specification;

import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import study.model.Child;
import study.model.Parent;

import java.util.ArrayList;
import java.util.List;

public class ChildParentSpecification {

    public static Specification<Child> findBySalaryLessThan(long salary){
        return (Root<Child> root, CriteriaQuery<?> query, CriteriaBuilder cb)->{
            Join<Object, Object> parentJoin = root.join("parent", JoinType.LEFT);
            List<Selection<?>> selections = new ArrayList<>();
            selections.add(root.get("id"));
            selections.add(root.get("name"));
            selections.add(root.get("salary"));
            selections.add(parentJoin.get("name"));

            query.multiselect(selections);

            return cb.lessThanOrEqualTo(root.get("salary"), salary);
        };
    }
}
