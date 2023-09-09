package in.ncag.church.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ncag.church.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	
}
