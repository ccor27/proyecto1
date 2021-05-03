package controller;

import javax.swing.JOptionPane;

import modelo.Actividad;
import modelo.ListaActividad;
import modelo.ListaProceso;
import modelo.Proceso;
import modelo.Tarea;
import persistencia.Persistencia;
import views.ConfigurarProcesoView;

public class ModelFactoryController {

	private ListaProceso listaProceso;

	// ------------------------------ Singleton
	// ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aquí al ser
		// protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();

	}

	// Método para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {
		//iniciar();
		//guardarResourceBinario();
		cargarResourceBinario();

	}

	public void iniciar() {

		listaProceso = new ListaProceso("a");


		Actividad actividad1 = new Actividad("carro", "como usar un carro", true);
		Tarea tarea1 = new Tarea("prender carro", true, 1, 2);
		Tarea tarea2 = new Tarea("conducir hasta la U", true, 1, 2);
		Tarea tarea3 = new Tarea("estacionar", true, 1, 2);
		Tarea tarea4 = new Tarea("bajar del auto y dirigirse a clase", true, 1, 2);
		actividad1.getConjuntoTareas().insertarFinal(tarea1);
		actividad1.getConjuntoTareas().insertarFinal(tarea2);
		actividad1.getConjuntoTareas().insertarFinal(tarea3);
		actividad1.getConjuntoTareas().insertarFinal(tarea4);

		Actividad actividad2 = new Actividad("cocinar", "como cocinar", false);
		Tarea tarea5 = new Tarea("prender estufa", true, 1, 2);
		Tarea tarea6 = new Tarea("poner las ollas", true, 1, 2);
		Tarea tarea7 = new Tarea("esperar...", true, 1, 2);
		Tarea tarea8 = new Tarea("servir para comer", true, 1, 2);
		actividad2.getConjuntoTareas().insertarFinal(tarea5);
		actividad2.getConjuntoTareas().insertarFinal(tarea6);
		actividad2.getConjuntoTareas().insertarFinal(tarea7);
		actividad2.getConjuntoTareas().insertarInicio(tarea8);

		Actividad actividad3 = new Actividad("programar", "como programar", true);
		Tarea tarea10 = new Tarea("analizar el problema", true, 0.5, 1);
		Tarea tarea11 = new Tarea("prender pc", true, 0.01, 0.01);
		Tarea tarea12 = new Tarea("programar :D", true, 10, 20);
		Tarea tarea13 = new Tarea("ir por cafe", true, 0.0001, 1);
		actividad3.getConjuntoTareas().insertarFinal(tarea10);
		actividad3.getConjuntoTareas().insertarFinal(tarea11);
		actividad3.getConjuntoTareas().insertarFinal(tarea12);
		actividad3.getConjuntoTareas().insertarFinal(tarea13);

		Actividad actividad4 = new Actividad("jugar futbol", "como ganar el campeonato", false);
		Tarea tarea18 = new Tarea("ponerse los guayos", true, 1, 2);
		Tarea tarea19 = new Tarea("calentar", true, 1, 2);
		Tarea tarea20 = new Tarea("jugar dando lo mejor", true, 1, 2);
		Tarea tarea21 = new Tarea("celebrar porque ganamos el partido", true, 1, 2);
		actividad4.getConjuntoTareas().insertarFinal(tarea18);
		actividad4.getConjuntoTareas().insertarFinal(tarea19);
		actividad4.getConjuntoTareas().insertarFinal(tarea20);
		actividad4.getConjuntoTareas().insertarFinal(tarea21);

		Actividad actividad5 = new Actividad("como pasar el semestre", "pasos para pasar el semestre", true);
		Tarea tarea14 = new Tarea("estudiar ", true, 10, 20);
		Tarea tarea15 = new Tarea("aplicar lo aprendido", true, 10, 20);
		Tarea tarea16 = new Tarea("repasar mas", true, 10, 20);
		Tarea tarea17 = new Tarea("descansar", true, 10, 20);
		actividad5.getConjuntoTareas().insertarFinal(tarea14);
		actividad5.getConjuntoTareas().insertarFinal(tarea15);
		actividad5.getConjuntoTareas().insertarFinal(tarea16);
		actividad5.getConjuntoTareas().insertarFinal(tarea17);
		
		Actividad actividad6 = new Actividad("hacer ejercicio", "como hacer ejercicio",false);
		Tarea tarea22 = new Tarea("estirar", true, 1, 2);
		Tarea tarea23 = new Tarea("trotar", true, 1, 2);
		Tarea tarea24 = new Tarea("hacer barra y abdominales", true, 1, 2);
		Tarea tarea25 = new Tarea("estirar para evitar calambres", true, 1, 2);
		actividad6.getConjuntoTareas().insertarFinal(tarea22);
		actividad6.getConjuntoTareas().insertarFinal(tarea23);
		actividad6.getConjuntoTareas().insertarFinal(tarea24);
		actividad6.getConjuntoTareas().insertarFinal(tarea25);
		
		Actividad actividad7 = new Actividad("bailar","aprender bailar",true);
		Tarea tarea26 = new Tarea("aprender el ritmo de la cancion",true,2, 2);
		Tarea tarea27 = new Tarea("practicar los pasos",true,2, 2);
		Tarea tarea28 = new Tarea("sacar a alguien a bailar",true,2, 2);
		actividad7.getConjuntoTareas().insertarFinal(tarea26);
		actividad7.getConjuntoTareas().insertarFinal(tarea27);
		actividad7.getConjuntoTareas().insertarFinal(tarea28);
		
		Actividad actividad8 = new Actividad("hacer cafe", "como hacer cafe",false);
		Tarea tarea29 = new Tarea("calentar agua",true, 2, 2);
		Tarea tarea30 = new Tarea("poner una cucharada de cafe instantaneo",true, 2, 2);
		Tarea tarea31 = new Tarea("poner azucar",true, 2, 2);
		Tarea tarea32 = new Tarea("servir",true, 2, 2);
		actividad8.getConjuntoTareas().insertarFinal(tarea29);
		actividad8.getConjuntoTareas().insertarFinal(tarea30);
		actividad8.getConjuntoTareas().insertarFinal(tarea31);
		actividad8.getConjuntoTareas().insertarFinal(tarea32);
		
		
		

		Proceso proceso1 = new Proceso(1, "Vida diaria", 0, 0);
		proceso1.getConjuntoActividades().insertarFinal(actividad1);
		proceso1.getConjuntoActividades().insertarFinal(actividad2);
		proceso1.getConjuntoActividades().insertarFinal(actividad3);
		proceso1.getConjuntoActividades().insertarFinal(actividad4);

		Proceso proceso2 = new Proceso(2, "Estudiar", 0, 0);
		proceso2.getConjuntoActividades().insertarFinal(actividad5);
		proceso2.getConjuntoActividades().insertarFinal(actividad6);
		proceso2.getConjuntoActividades().insertarFinal(actividad7);
		proceso2.getConjuntoActividades().insertarFinal(actividad8);
		
		listaProceso.insertarProceso(proceso1);
		listaProceso.insertarProceso(proceso2);


	}

	public void cargarResourceBinario() {

		listaProceso = Persistencia.cargarListaProcesoBinario();

	}

	public void guardarResourceBinario() {

		Persistencia.guardarListaProcesoBinario(listaProceso);
	}

	public void crearListaProceso() {
		listaProceso = new ListaProceso();
	}

	public void crearProceso(int id, String nombre, double tiempoMax, double tiempoMin) {
		Proceso proceso = new Proceso(id, nombre, tiempoMax, tiempoMin);
		listaProceso.insertarProceso(proceso);
	}

	// -------------------------------- METODOS ACTIVIDADES
	// -----------------------------------------------------------------

	public void crearActividadInicio(String nombreProceso, String nombre, String descripcion, boolean esObligatorio) {

		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if (proceso != null) {
			Actividad actividad = new Actividad(nombre, descripcion, esObligatorio);
			proceso.getConjuntoActividades().insertarInicio(actividad);
		} else {
			JOptionPane.showMessageDialog(null,"el proceso no existe");
		}
	}

	public void crearActividadFin(String nombreProceso, String nombre, String descripcion, boolean esObligatorio) {

		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if (proceso != null) {
			Actividad actividad = new Actividad(nombre, descripcion, esObligatorio);
			proceso.getConjuntoActividades().insertarFinal(actividad);
		} else {
			JOptionPane.showMessageDialog(null, "el proceso no existe");
			
		}
	}

	public void crearActividadPosicionDeterminada(String nombreProceso, String nombreActividadPrecede, String nombre,
			String descripcion, boolean esObligatorio) {

		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if (proceso != null) {
			Actividad actividad = new Actividad(nombre, descripcion, esObligatorio);
			proceso.getConjuntoActividades().insertarPosDeterminada(actividad, nombreActividadPrecede);
		} else {
			JOptionPane.showMessageDialog(null,"el proceso no existe");
		}
	}

	public Actividad buscarActivida(String nombre, String nombreProceso) {

		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);

		if (proceso != null) {
			return proceso.getConjuntoActividades().buscarActividad(nombre);

		} else {
			JOptionPane.showMessageDialog(null,"el proceso no existe");
		
			return null;
		}
	}

	public void eliminarActividad(String nombreProceso, String nombre) {
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if (proceso != null) {
			proceso.getConjuntoActividades().eliminar(nombre);
		} else {
			JOptionPane.showMessageDialog(null,"el proceso no existe");
			
		}
	}

	public void crearDespuesUltimaActividadCreada(String nombreProceso, String nombre, String descripcion,
			boolean esObligatorio) {
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if (proceso != null) {
			Actividad actividad = new Actividad(nombre, descripcion, esObligatorio);
			proceso.getConjuntoActividades().insertarDespuesUltimaActividadInsertada(actividad);
		} else {
			JOptionPane.showMessageDialog(null,"el proceso no existe");
			
		}
	}

	public void interCambiarActividades(String nombreProceso1, String nombreProceso2, String nombreActividad1,
			String nombreActividad2, boolean cambiarConTareas) {

		listaProceso.intercambiarActividades(nombreProceso1, nombreProceso2, nombreActividad1, nombreActividad2,
				cambiarConTareas);

	}

	// -------------------------------- METODOS TAREAS
	// -----------------------------------------------------------------

	public void crearTareaInicio(String nombreProceso, String nombreActividad, String descripcion,
			boolean esObligatorio, double tiempoMax, double tiempoMin) {
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if (proceso != null) {
			Actividad actividad = proceso.getConjuntoActividades().buscarActividad(nombreActividad);
			if (actividad != null) {
				Tarea tarea = new Tarea(descripcion, esObligatorio, tiempoMax, tiempoMin);
				actividad.getConjuntoTareas().insertarInicio(tarea);
			} else {
				JOptionPane.showMessageDialog(null,"la actividad no existe");
				
			}
		} else {
			JOptionPane.showMessageDialog(null,"el proceso no existe");
			
		}
	}

	public void crearTareaFin(String nombreProceso, String nombreActividad, String descripcion, boolean esObligatorio,
			double tiempoMax, double tiempoMin) {
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if (proceso != null) {
			Actividad actividad = proceso.getConjuntoActividades().buscarActividad(nombreActividad);
			if (actividad != null) {
				Tarea tarea = new Tarea(descripcion, esObligatorio, tiempoMax, tiempoMin);
				actividad.getConjuntoTareas().insertarFinal(tarea);
			} else {
				JOptionPane.showMessageDialog(null,"la actividad no existe");
				
			}
		} else {
			JOptionPane.showMessageDialog(null,"el proceso no existe");
			
		}
	}

	public void crearTareaPosicionDeterminada(String nombreProceso, String nombreActividad, int indice,
			String descripcion, boolean esObligatorio, double tiempoMax, double tiempoMin) {
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if (proceso != null) {
			Actividad actividad = proceso.getConjuntoActividades().buscarActividad(nombreActividad);
			if (actividad != null) {
				Tarea tarea = new Tarea(descripcion, esObligatorio, tiempoMax, tiempoMin);
				actividad.getConjuntoTareas().insertarPosDeterminada(tarea, indice);
			} else {
				JOptionPane.showMessageDialog(null,"la actividad no existe");
				
			}
		} else {
			JOptionPane.showMessageDialog(null, "el proceso no existe");
			
		}
	}

	public Tarea obtenerTarea(String nombreProceso, String nombreActividad, String descripcion) {
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if (proceso != null) {
			Actividad actividad = proceso.getConjuntoActividades().buscarActividad(nombreActividad);
			if (actividad != null) {
				return actividad.getConjuntoTareas().buscarTarea(descripcion);
			} else {
				
				JOptionPane.showMessageDialog(null,"la activida no existe");
				
				return null;
			}

		} else {
			
			JOptionPane.showMessageDialog(null, "el proceso no existe");
			
			return null;
		}
	}

	public double calcularTiempoMinProceso(String nombreProceso) {
		return listaProceso.calcularTiempoMin(nombreProceso);
	}

	public double calcularTiempoMaxProceso(String nombreProceso) {
		// TODO Auto-generated method stub
		return listaProceso.calcularTiempoMax(nombreProceso);
	}

	// ------------------------------------------ PRUEBAS CON LAS TABLAS
	// ----------------------------------------------------

	public ListaProceso getLista() {
		return this.listaProceso;
	}

	public Tarea buscarTareaNombreDado(String nombreActividad, String descripcionTarea,String nombreProceso) {
        
		Proceso p = listaProceso.obtenerProceso(nombreProceso);
		if(p!=null){
			return p.getConjuntoActividades().buscarTareaNombreDado(nombreActividad, descripcionTarea);
		}else{
			JOptionPane.showMessageDialog(null, "el proceso no existe");
			return null;
		}
	}

	public Tarea buscarTareaActual(String descripcionTarea, String nombreProceso) {

		Proceso p = listaProceso.obtenerProceso(nombreProceso);
		if(p!=null){
			return p.getConjuntoActividades().buscarTareaActual(descripcionTarea);
		}else{
			return null;
		}
		
	}

	public Tarea buscarTareaInicio(String descripcionTarea, String nombreProceso) {
	
		Proceso p = listaProceso.obtenerProceso(nombreProceso);
		if(p!=null){
			return p.getConjuntoActividades().buscarTareaInicio(descripcionTarea);
		}else{
			return null;
		}
	}



}
