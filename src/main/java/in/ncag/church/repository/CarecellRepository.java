package in.ncag.church.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import in.ncag.church.model.Carecell;

@Repository
public interface CarecellRepository extends JpaRepository<Carecell, Integer>, JpaSpecificationExecutor<Carecell>, PagingAndSortingRepository<Carecell, Integer> {
	public Page<Carecell> findAll(Pageable pageable);
	public Page<Carecell> findAll(Specification<Carecell> spec, Pageable pageable);
}
