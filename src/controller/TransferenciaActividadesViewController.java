package controller;

import modelo.ListaProceso;

public class TransferenciaActividadesViewController {
	
	ModelFactoryController controller;
	ListaProceso listaProceso;
	
	public TransferenciaActividadesViewController() {
		controller = ModelFactoryController.getInstance();
		listaProceso= controller.getLista();
	}
	
	public ListaProceso getListaProceso() {
		return listaProceso;
	}

	public void setListaProceso(ListaProceso listaProceso) {
		this.listaProceso = listaProceso;
	}

	public void interCambiarActividades(String nombreProcesoUno, String nombreProcesoDos, String actividadUno,
			String actividadDos, boolean cambiarConTareas) {
		
		controller.interCambiarActividades(nombreProcesoUno, nombreProcesoDos, actividadUno, actividadDos, cambiarConTareas);
	}

}
