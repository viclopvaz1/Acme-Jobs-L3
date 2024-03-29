
package acme.features.administrator.estadistica;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.estadisticas.Estadistica;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/estadistica/")
public class AdministratorEstadisticaController extends AbstractController<Administrator, Estadistica> {

	@Autowired
	private AdministratorEstadisticaListService listService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
	}

}
