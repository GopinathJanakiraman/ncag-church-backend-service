package in.ncag.church.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import in.ncag.church.model.Region;

public interface RegionRepository extends JpaRepository<Region, Integer>, PagingAndSortingRepository<Region, Integer>{
	public Page<Region> findAll(Pageable pageable);
}
