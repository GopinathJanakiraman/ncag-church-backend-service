package in.ncag.church.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import in.ncag.church.model.Area;

public interface AreaRepository extends JpaRepository<Area, Integer>, PagingAndSortingRepository<Area, Integer>{
	public Page<Area> findAll(Pageable pageable);
}
