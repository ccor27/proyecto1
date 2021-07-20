package controller;

import modelo.Actividad;
import modelo.ListaProceso;


public class BuscarActividadViewController {

	  ModelFactoryController modelFactoryController;
	  ListaProceso listaProceso;
	  
	  public BuscarActividadViewController(){
			modelFactoryController = ModelFactoryController.getInstance();
			listaProceso= modelFactoryController.getLista();
	  }

	public ListaProceso getListaProceso() {
		
		return this.listaProceso;
	}

	public Actividad buscarActivida(String nombreActividad, String nombreProceso) {
		
		return modelFactoryController.buscarActivida(nombreActividad, nombreProceso);
		
	}

	public String vecesActEnProcesos(String nombreActividad) {
		
		return modelFactoryController.vecesActEnProcesos(nombreActividad);
	}

}
