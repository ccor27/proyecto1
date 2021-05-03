package controller;

import modelo.ListaProceso;

public class ProcesoViewController {
	
	ModelFactoryController modelFactoryController;
	ListaProceso listaProceso;
	
	public ProcesoViewController() {
		modelFactoryController = ModelFactoryController.getInstance();
		listaProceso= modelFactoryController.getLista();
	}
	
	public ListaProceso getListaProceso() {
		return listaProceso;
	}

	public void setListaProceso(ListaProceso listaProceso) {
		this.listaProceso = listaProceso;
	}

	public void crearProceso(int id, String nombre) {
		// TODO Auto-generated method stub
		modelFactoryController.crearProceso(id, nombre, 0, 0);
	}

}
