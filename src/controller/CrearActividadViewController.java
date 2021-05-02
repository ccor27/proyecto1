package controller;

import modelo.ListaProceso;

public class CrearActividadViewController {
	
	ModelFactoryController modelFactoryController;
	ListaProceso listaProceso;
	
	public CrearActividadViewController(){
		modelFactoryController = ModelFactoryController.getInstance();
		listaProceso= modelFactoryController.getLista(); 
	}

	public void crearDespuesUltimaActividadCreada(String nombreProceso, String nombre, String descripcion, boolean b) {
		modelFactoryController.crearDespuesUltimaActividadCreada(nombreProceso, nombre, descripcion, b);
	}

	public void crearActividadFin(String nombreProceso, String nombre, String descripcion, boolean b) {
		modelFactoryController.crearActividadFin(nombreProceso, nombre, descripcion, b);
		
	}

	public void crearActividadPosicionDeterminada(String nombreProceso, String nombreActividadPrecede, String nombre,
			String descripcion, boolean b) {
	  modelFactoryController.crearActividadPosicionDeterminada(nombreProceso, nombreActividadPrecede, nombre, descripcion, b);
		
	}

	public ListaProceso getListaProceso() {
		return listaProceso;
	}

	public void setListaProceso(ListaProceso listaProceso) {
		this.listaProceso = listaProceso;
	}

}
