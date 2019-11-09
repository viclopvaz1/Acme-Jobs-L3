/*
 * AuthenticatedProviderCreateService.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.offer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.datatypes.Money;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedOfferCreateService implements AbstractCreateService<Authenticated, Offer> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedOfferRepository repository;


	@Override
	public void bind(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors);
	}

	@Override
	public Offer instantiate(final Request<Offer> request) {
		assert request != null;

		Offer result;
		Date moment;
		Date deadline;
		Money rewardMax = new Money();
		rewardMax.setAmount(1.0);
		rewardMax.setCurrency("€");
		Money rewardMin = new Money();
		rewardMin.setAmount(0.0);
		rewardMin.setCurrency("€");

		moment = new Date(System.currentTimeMillis() - 1);
		deadline = new Date(System.currentTimeMillis() + 20000);
		result = new Offer();
		result.setTitle("Offer title");
		result.setText("Set here text");
		result.setMoment(moment);
		result.setDeadline(deadline);
		result.setRewardMax(rewardMax);
		result.setRewardMin(rewardMin);
		result.setTicker("OABCD-00000");
		return result;
	}

	@Override
	public void validate(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Offer> request, final Offer entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

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

		request.unbind(entity, model, "title", "text", "moment", "deadline", "rewardMax", "rewardMin", "ticker");

	}

}
