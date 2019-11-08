
package acme.features.authenticated.request;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.requests.Request;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedRequestRepository extends AbstractRepository {

	@Query("select r from Request r where r.deadline > CURRENT_TIMESTAMP")
	Collection<Request> findMany();

	@Query("select r from Request r where r.id = ?1")
	Request findOneById(int id);

}
