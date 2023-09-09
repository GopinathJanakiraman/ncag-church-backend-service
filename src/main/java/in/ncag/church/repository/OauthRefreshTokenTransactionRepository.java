package in.ncag.church.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ncag.church.model.RefreshTokenModel;


@Repository
public interface OauthRefreshTokenTransactionRepository extends JpaRepository<RefreshTokenModel, String> {

	public Optional<RefreshTokenModel> findById(String token);
}
