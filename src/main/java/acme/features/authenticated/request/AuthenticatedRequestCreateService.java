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

package acme.features.authenticated.request;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.datatypes.Money;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedRequestCreateService implements AbstractCreateService<Authenticated, acme.entities.requests.Request> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedRequestRepository repository;


	@Override
	public void bind(final Request<acme.entities.requests.Request> request, final acme.entities.requests.Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors);
	}

	@Override
	public acme.entities.requests.Request instantiate(final Request<acme.entities.requests.Request> request) {
		assert request != null;

		acme.entities.requests.Request result;
		Date moment;
		Date deadline;
		Money reward = new Money();
		reward.setAmount(0.0);
		reward.setCurrency("€");

		moment = new Date(System.currentTimeMillis() - 1);
		deadline = new Date(System.currentTimeMillis() + 20000);
		result = new acme.entities.requests.Request();
		result.setTitle("Request title");
		result.setText("Set here text");
		result.setMoment(moment);
		result.setDeadline(deadline);
		result.setReward(reward);
		result.setTicker("RABCD-00000");
		return result;
	}

	@Override
	public void validate(final Request<acme.entities.requests.Request> request, final acme.entities.requests.Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<acme.entities.requests.Request> request, final acme.entities.requests.Request entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

	@Override
	public boolean authorise(final Request<acme.entities.requests.Request> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<acme.entities.requests.Request> request, final acme.entities.requests.Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "text", "moment", "deadline", "reward", "ticker");

	}

}
