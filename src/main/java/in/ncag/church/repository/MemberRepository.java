package in.ncag.church.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import in.ncag.church.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>, JpaSpecificationExecutor<Member>, PagingAndSortingRepository<Member, Integer> {
		
    public Page<Member> findAll(Specification<Member> spec, Pageable pageable);
    
    public Page<Member> findAll(Pageable pageable);
    
    public List<Member> findAll(Specification<Member> spec);

}
