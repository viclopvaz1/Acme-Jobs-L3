
package acme.features.administrator.dashboard;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select sector, count(a) from CompanyRecord a group by a.sector")
	Collection<Object[]> findBySector();

	@Query("select sector, count(a) from InvestorRecord a group by a.sector")
	Collection<Object[]> findBySector2();

}
