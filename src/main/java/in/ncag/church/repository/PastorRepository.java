package in.ncag.church.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ncag.church.model.Pastor;

@Repository
public interface PastorRepository extends JpaRepository<Pastor, Integer> {
	
	Optional<Pastor> findByEmail(String email);

	//User findByEmailAndPassword(String username, String password);
	
	//Pastor findByEmailAndCredential(String username, String password);
}
