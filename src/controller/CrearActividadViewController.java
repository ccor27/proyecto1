package controller;

import modelo.ListaProceso;

public class CrearActividadViewController {
	
	ModelFactoryController modelFactoryController;
	ListaProceso listaProceso;
	
	public CrearActividadViewController(){
		modelFactoryController = ModelFactoryController.getInstance();
		listaProceso= modelFactoryController.getLista(); 
	}

	public boolean crearDespuesUltimaActividadCreada(String nombreProceso, String nombre, String descripcion, boolean b) {
		return modelFactoryController.crearDespuesUltimaActividadCreada(nombreProceso, nombre, descripcion, b);
	}

	public boolean crearActividadFin(String nombreProceso, String nombre, String descripcion, boolean b) {
		return modelFactoryController.crearActividadFin(nombreProceso, nombre, descripcion, b);
		
	}

	public boolean crearActividadPosicionDeterminada(String nombreProceso, String nombreActividadPrecede, String nombre,
			String descripcion, boolean b) {
	 return modelFactoryController.crearActividadPosicionDeterminada(nombreProceso, nombreActividadPrecede, nombre, descripcion, b);
		
	}

	public ListaProceso getListaProceso() {
		return listaProceso;
	}

	public void setListaProceso(ListaProceso listaProceso) {
		this.listaProceso = listaProceso;
	}

	public boolean crearTareaPosDeterminada(String nombreProceso, String nombreActividad, int indice, String descripcion, boolean esObligatorio,
			int tiempoMax, int tiempoMin) {
	return	modelFactoryController.crearTareaPosicionDeterminada(nombreProceso, nombreActividad, indice, descripcion, esObligatorio, tiempoMax, tiempoMin);
		
	}

	public boolean creaeTareaFin(String nombreProceso, String nombreActividad, String descripcion, boolean esObligatorio, int tiempoMax, int tiempoMin) {
		return modelFactoryController.crearTareaFin(nombreProceso, nombreActividad, descripcion, esObligatorio, tiempoMax, tiempoMin);
		
	}



}
