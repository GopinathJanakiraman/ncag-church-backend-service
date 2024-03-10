package in.ncag.church.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import in.ncag.church.dto.MemberDTO;
import in.ncag.church.model.Carecell;

public class CarecellSpecification {
	public Specification<Carecell> getCarecellMembers(MemberDTO memberDto) {
   	 return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            
            
         
            if (memberDto.getAreaId() > 0) {
                predicates.add(criteriaBuilder.equal(root.get("areaDetails"), memberDto.getAreaId()));
            }
       
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
   	 };
   }
}
