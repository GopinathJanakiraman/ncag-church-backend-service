package in.ncag.church.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.ncag.church.model.PastorCapability;





@Repository
public interface PastorCapabilityRepository extends JpaRepository<PastorCapability, Integer> {

	@Query(value = "SELECT u FROM PastorCapability u WHERE u.id IN :ID")
	List<PastorCapability> findByIds(@Param("ID") List<Integer> ids);

	@Query(value = "SELECT c.name FROM capabilities c inner join role_mapping r on r.capability_id_fk = c.id WHERE r.role_id_fk = :ID and r.status=1",nativeQuery = true)
	List<String> getCapabilityByRole(@Param("ID") Integer id);
}
