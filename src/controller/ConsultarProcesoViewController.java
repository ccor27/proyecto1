package controller;

import modelo.ListaProceso;

public class ConsultarProcesoViewController {
	
	ModelFactoryController controller;
	ListaProceso listaProceso;
	
	public ConsultarProcesoViewController() {
		controller = ModelFactoryController.getInstance();
		listaProceso= controller.getLista();
	}

	public ListaProceso getListaProceso() {
		return listaProceso;
	}

	public void setListaProceso(ListaProceso listaProceso) {
		this.listaProceso = listaProceso;
	}

	public int calcularTiempoMin(String nombreProceso) {
		// TODO Auto-generated method stub
		return controller.calcularTiempoMinProceso(nombreProceso);
	}
	
	public int calcularTiempoMax(String nombreProceso) {
		// TODO Auto-generated method stub
		return controller.calcularTiempoMaxProceso(nombreProceso);
	}





}
