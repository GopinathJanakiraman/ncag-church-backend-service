package in.ncag.church.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ncag.church.model.City;

public interface CityRepository extends JpaRepository<City, Integer>{

}
