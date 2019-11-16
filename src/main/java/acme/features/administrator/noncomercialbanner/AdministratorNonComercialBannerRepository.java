
package acme.features.administrator.noncomercialbanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.noncomercialbanners.NonComercialBanner;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorNonComercialBannerRepository extends AbstractRepository {

	@Query("select ncb from NonComercialBanner ncb")
	Collection<NonComercialBanner> findMany();

	@Query("select ncb from NonComercialBanner ncb where ncb.id = ?1")
	NonComercialBanner findOneById(int id);

}
