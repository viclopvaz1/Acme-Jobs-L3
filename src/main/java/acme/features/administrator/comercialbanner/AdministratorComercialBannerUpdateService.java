
package acme.features.administrator.comercialbanner;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.comercialbanners.ComercialBanner;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorComercialBannerUpdateService implements AbstractUpdateService<Administrator, ComercialBanner> {

	@Autowired
	AdministratorComercialBannerRepository repository;


	@Override
	public boolean authorise(final Request<ComercialBanner> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<ComercialBanner> request, final ComercialBanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<ComercialBanner> request, final ComercialBanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "targetUrl", "creditCard", "monthExp", "yearExp", "cvv");

	}

	@Override
	public ComercialBanner findOne(final Request<ComercialBanner> request) {
		assert request != null;

		ComercialBanner result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<ComercialBanner> request, final ComercialBanner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Calendar calendar = new GregorianCalendar();
		Integer month = calendar.getTime().getMonth();
		Integer year = calendar.getTime().getYear() + 1900;

		if (!errors.hasErrors("monthExp")) {
			errors.state(request, entity.getYearExp() > year || entity.getMonthExp() >= month && entity.getYearExp() == year, "monthExp", "administrator.comercial-banner.form.error.monthExp");
		}

		if (!errors.hasErrors("yearExp")) {
			errors.state(request, entity.getYearExp() >= year, "yearExp", "administrator.comercial-banner.form.error.yearExp");
		}
	}

	@Override
	public void update(final Request<ComercialBanner> request, final ComercialBanner entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
