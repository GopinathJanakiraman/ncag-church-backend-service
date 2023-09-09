package in.ncag.church.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.ncag.church.model.PastorRoleMapping;

@Repository
public interface PastorRoleMappingRepository extends JpaRepository<PastorRoleMapping, Integer> {

	@Query("SELECT u FROM PastorRoleMapping u WHERE u.roleId=:roldId")
	List<PastorRoleMapping> findByRoleId(@Param("roldId")Integer roleId);
}
