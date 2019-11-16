
package acme.features.administrator.noncomercialbanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.noncomercialbanners.NonComercialBanner;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/non-comercial-banner/")
public class AdministratorNonComercialBannerController extends AbstractController<Administrator, NonComercialBanner> {

	@Autowired
	AdministratorNonComercialBannerListService		listService;

	@Autowired
	AdministratorNonComercialBannerShowService		showService;

	@Autowired
	AdministratorNonComercialBannerCreateService	createService;

	@Autowired
	AdministratorNonComercialBannerUpdateService	updateService;

	@Autowired
	AdministratorNonComercialBannerDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);

	}
}
