
package acme.features.authenticated.offer;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedOfferListService implements AbstractListService<Authenticated, Offer> {

	@Autowired
	AuthenticatedOfferRepository repository;


	@Override
	public boolean authorise(final Request<Offer> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "text", "deadline");
	}

	@Override
	public Collection<Offer> findMany(final Request<Offer> request) {
		assert request != null;
		Collection<Offer> result;
		Calendar cal = Calendar.getInstance();
		Date moment = cal.getTime();
		int mes = moment.getMonth();
		moment.setMonth(mes - 1);
		result = this.repository.findManyByMoment(moment);

		return result;
	}
}
