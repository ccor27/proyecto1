package controller;

import modelo.Actividad;
import modelo.ListaProceso;
import modelo.Proceso;
import modelo.Tarea;

public class BuscarTareasViewController {
	
	ModelFactoryController modelFactoryController;
	ListaProceso listaProceso;
	
	public BuscarTareasViewController() {
		modelFactoryController = ModelFactoryController.getInstance();
		listaProceso= modelFactoryController.getLista();
	}

	public ListaProceso getListaProceso() {
		return listaProceso;
	}

	public void setListaProceso(ListaProceso listaProceso) {
		this.listaProceso = listaProceso;
	}

	public Tarea buscarTareaNombreDado(String nombreActividad, String descripcionTarea,String nombreProceso) {
		
		return modelFactoryController.buscarTareaNombreDado(nombreActividad,descripcionTarea, nombreProceso);
	}

	public Tarea buscarTareaActual(String descripcionTarea, String nombreProceso) {
  
	      return modelFactoryController.buscarTareaActual(descripcionTarea,nombreProceso);	
	}

	public Tarea buscarTareaInicio(String descripcionTarea, String nombreProceso) {
		
		return modelFactoryController.buscarTareaInicio(descripcionTarea,nombreProceso);
	}

}
