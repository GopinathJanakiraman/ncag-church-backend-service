package in.ncag.church.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ncag.church.model.RefreshAccessTokenModel;

@Repository
public interface OauthTokenTransactionRepository extends JpaRepository<RefreshAccessTokenModel, String> {

	public RefreshAccessTokenModel findByTokenId(String accessId);

}
