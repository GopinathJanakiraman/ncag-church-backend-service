package in.ncag.church.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ncag.church.model.PastorRole;


@Repository
public interface PastorRoleRepository extends JpaRepository<PastorRole, Integer>{

}
