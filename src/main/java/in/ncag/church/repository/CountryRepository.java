package in.ncag.church.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ncag.church.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{

}
