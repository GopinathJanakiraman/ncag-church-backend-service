package in.ncag.church.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ncag.church.model.Religion;

public interface ReligionRepository extends JpaRepository<Religion, Integer>{

}
