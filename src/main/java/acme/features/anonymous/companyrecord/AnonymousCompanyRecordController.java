
package acme.features.anonymous.companyrecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.companyrecords.CompanyRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/company-record/")
public class AnonymousCompanyRecordController extends AbstractController<Anonymous, CompanyRecord> {

	@Autowired
	AnonymousCompanyRecordListService		listService;

	@Autowired
	AnonymousCompanyRecordShowService		showService;

	@Autowired
	AnonymousCompanyRecordListTopsService	listTopService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

		super.addCustomCommand(CustomCommand.STARS, BasicCommand.LIST, this.listTopService);
		//super.addCustomCommand(CustomCommand.STARS, BasicCommand.SHOW, this.showService);
	}
}
