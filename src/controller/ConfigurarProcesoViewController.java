package controller;

import modelo.ListaProceso;

public class ConfigurarProcesoViewController {

	ModelFactoryController controller;
	ListaProceso listaProceso;
	
	public ConfigurarProcesoViewController() {
		controller = ModelFactoryController.getInstance();
		listaProceso= controller.getLista();
	}

	public ListaProceso getListaProceso() {
		return listaProceso;
	}

	public void setListaProceso(ListaProceso listaProceso) {
		this.listaProceso = listaProceso;
	}

}
