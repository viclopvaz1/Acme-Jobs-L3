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

package acme.features.provider.request;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Provider;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ProviderRequestCreateService implements AbstractCreateService<Provider, acme.entities.requests.Request> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private ProviderRequestRepository repository;


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

		acme.entities.requests.Request result = new acme.entities.requests.Request();
		//		Date moment;
		//		Date deadline;
		//		Money reward = new Money();
		//		reward.setAmount(0.0);
		//		reward.setCurrency("€");
		//
		//		moment = new Date(System.currentTimeMillis() - 1);
		//		deadline = new Date(System.currentTimeMillis() + 20000);
		//		result.setTitle("Request title");
		//		result.setText("Set here text");
		//		result.setMoment(moment);
		//		result.setDeadline(deadline);
		//		result.setReward(reward);
		//		result.setTicker("RABCD-00000");
		return result;
	}

	@Override
	public void validate(final Request<acme.entities.requests.Request> request, final acme.entities.requests.Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("deadline")) {
			errors.state(request, entity.getDeadline().after(new Date(System.currentTimeMillis() - 1)), "deadline", "provider.request.error.dateafter");
		}
		if (!errors.hasErrors("reward")) {
			errors.state(request, entity.getReward().getCurrency().equals("€") || entity.getReward().getCurrency().equals("EUR"), "reward", "provider.request.error.euro");
		}

		if (!errors.hasErrors("ticker")) {
			errors.state(request, this.repository.existTicker(entity.getTicker()) == null, "ticker", "provider.request.error.tickers");
		}

		errors.state(request, request.getModel().getBoolean("sure"), "sure", "provider.request.error.sure");

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

		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("sure", "false");
		} else {
			request.transfer(model, "sure");
		}

	}

}
