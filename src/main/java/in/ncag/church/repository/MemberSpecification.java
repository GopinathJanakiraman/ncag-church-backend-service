package in.ncag.church.repository;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import in.ncag.church.dto.MemberDTO;
import in.ncag.church.model.Member;

public class MemberSpecification {
	

    public static Specification<Member> hasName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("firstName"), name);
    }

    public static Specification<Member> hasEmail(String email) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("email"), email);
    }
    
    public static Specification<Member> hasArea(Integer areaId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("areaDetails"), areaId);
    }
    
    public Specification<Member> getMembers(MemberDTO memberDto) {
    	 return (root, query, criteriaBuilder) -> {

             List<Predicate> predicates = new ArrayList<>();
             
             
             if (memberDto.getEmail() != null && !memberDto.getEmail().isEmpty()) {
                 predicates.add(criteriaBuilder.equal(root.get("email"), memberDto.getEmail()));
             }
            
             if (memberDto.getFirstName() != null && !memberDto.getFirstName().isEmpty()) {
                 predicates.add(criteriaBuilder.equal(root.get("firstName"), memberDto.getFirstName()));
             }
             
             if (memberDto.getAreaId() > 0) {
                 predicates.add(criteriaBuilder.equal(root.get("areaDetails"), memberDto.getAreaId()));
             }
             query.orderBy(criteriaBuilder.asc(root.get("firstName")));
             return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    	 };
    }
    
}
