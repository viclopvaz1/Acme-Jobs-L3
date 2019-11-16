
package acme.features.administrator.comercialbanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.comercialbanners.ComercialBanner;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/comercial-banner/")
public class AdministratorComercialBannerController extends AbstractController<Administrator, ComercialBanner> {

	@Autowired
	private AdministratorComercialBannerListService		listService;

	@Autowired
	private AdministratorComercialBannerShowService		showService;

	@Autowired
	private AdministratorComercialBannerCreateService	createService;

	@Autowired
	private AdministratorComercialBannerUpdateService	updateService;

	@Autowired
	private AdministratorComercialBannerDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}

}
