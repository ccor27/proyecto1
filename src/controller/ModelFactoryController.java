package controller;

import modelo.Actividad;
import modelo.ListaActividad;
import modelo.Proceso;
import modelo.Tarea;

public class ModelFactoryController {

	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aquí al ser protected		
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
		
	}

	// Método para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}
	
	public ModelFactoryController(){
		iniciar();
	}
	
	public void iniciar(){
		
		//Proceso proceso1 = new Proceso(1,"primerProceso");
		Actividad actividad1 = new Actividad();
		Tarea tarea1 = new Tarea("prender carro",true, 1, 2);
		Tarea tarea2 = new Tarea("conducir hasta la U",true, 1, 2);
		Tarea tarea3 = new Tarea("estacionar",true, 1, 2);
		Tarea tarea4 = new Tarea("bajar del auto y dirigirse a clase",true, 1, 2);
		
		//actividad1.insertar(tarea1);
		actividad1.getConjuntoTareas().insertarTarea(tarea1);
		actividad1.getConjuntoTareas().insertarTarea(tarea2);
		actividad1.getConjuntoTareas().insertarTarea(tarea3);
		actividad1.getConjuntoTareas().insertarTarea(tarea4);
		actividad1.getConjuntoTareas().mostrarTareas();
		actividad1.getConjuntoTareas().eliminarTarea(actividad1.getConjuntoTareas().obtenerTarea());
		actividad1.getConjuntoTareas().eliminarTarea(actividad1.getConjuntoTareas().obtenerTarea());
		actividad1.getConjuntoTareas().eliminarTarea(actividad1.getConjuntoTareas().obtenerTarea());
		actividad1.getConjuntoTareas().mostrarTareas();
		
		
		
	}
}
