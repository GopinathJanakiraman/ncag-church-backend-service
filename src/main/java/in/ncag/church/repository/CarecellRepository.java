package in.ncag.church.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ncag.church.model.Carecell;

@Repository
public interface CarecellRepository extends JpaRepository<Carecell, Integer> {

}
