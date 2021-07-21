package controller;

import javax.swing.JOptionPane;

import modelo.Actividad;
import modelo.ListaActividad;
import modelo.ListaProceso;
import modelo.Nodo;
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

	/**
	 * metodo para crear los datos de prueba
	 */
	public void iniciar() {

		listaProceso = new ListaProceso("lista de procesos");


		Actividad actividad1 = new Actividad("conducir", "como conducir un carro", true);
		Tarea tarea1 = new Tarea("prender", true, 2, 1);
		Tarea tarea2 = new Tarea("arrancar", true, 4, 2);
		Tarea tarea3 = new Tarea("frenar", true, 3, 2);
		Tarea tarea4 = new Tarea("apagar", true, 5, 2);
		actividad1.getConjuntoTareas().insertarInicio(tarea1);
		actividad1.getConjuntoTareas().insertarFinal(tarea2);
		actividad1.getConjuntoTareas().insertarFinal(tarea3);
		actividad1.getConjuntoTareas().insertarFinal(tarea4);

		Actividad actividad2 = new Actividad("ver serie", "como ver un serie", false);
		Tarea tarea5 = new Tarea("entrar a netflix", true, 6, 2);
		Tarea tarea6 = new Tarea("buscar serie", true, 7, 3);
		Tarea tarea7 = new Tarea("verla", true, 6, 2);
		Tarea tarea8 = new Tarea("sorprenderse", true, 8, 2);
		actividad2.getConjuntoTareas().insertarFinal(tarea5);
		actividad2.getConjuntoTareas().insertarFinal(tarea6);
		actividad2.getConjuntoTareas().insertarFinal(tarea7);
		actividad2.getConjuntoTareas().insertarInicio(tarea8);

		Actividad actividad3 = new Actividad("comprar ropa", "como programar", true);
		Tarea tarea10 = new Tarea("elegir prenda", true, 5, 1);
		Tarea tarea11 = new Tarea("ver talla", true,4,2);
		Tarea tarea12 = new Tarea("probarla", true, 8,5);
		Tarea tarea13 = new Tarea("pagar", true, 3, 2);
		actividad3.getConjuntoTareas().insertarFinal(tarea10);
		actividad3.getConjuntoTareas().insertarFinal(tarea11);
		actividad3.getConjuntoTareas().insertarFinal(tarea12);
		actividad3.getConjuntoTareas().insertarFinal(tarea13);

		Actividad actividad4 = new Actividad("hacer desayuno", "como hacer un desayuno", false);
		Tarea tarea18 = new Tarea("freir huevos", true, 6, 2);
		Tarea tarea19 = new Tarea("cortar pan", true, 2, 1);
		Tarea tarea20 = new Tarea("calentar cafe", true, 4, 2);
		Tarea tarea21 = new Tarea("servir ", true, 5, 2);
		actividad4.getConjuntoTareas().insertarFinal(tarea18);
		actividad4.getConjuntoTareas().insertarFinal(tarea19);
		actividad4.getConjuntoTareas().insertarFinal(tarea20);
		actividad4.getConjuntoTareas().insertarFinal(tarea21);

		Actividad actividad5 = new Actividad("como pasar el semestre", "pasos para pasar el semestre", true);
		
		Tarea tarea14 = new Tarea("estudiar", true, 100, 20);
		Tarea tarea15 = new Tarea("leer", true, 10, 5);
		Tarea tarea16 = new Tarea("practicar", true, 20, 10);
		Tarea tarea17 = new Tarea("retroalimentar", true, 15, 8);
		
		actividad5.getConjuntoTareas().insertarInicio(tarea14);
		actividad5.getConjuntoTareas().insertarFinal(tarea15);
		actividad5.getConjuntoTareas().insertarInicio(tarea16);
		actividad5.getConjuntoTareas().insertarFinal(tarea17);
		
		
		Actividad actividad6 = new Actividad("aprender", "como aprender algo nuevo",false);
		Tarea tarea22 = new Tarea("elegir tema", true, 15, 2);
		Tarea tarea23 = new Tarea("investigar", true, 12, 8);
		Tarea tarea24 = new Tarea("leer", true, 15, 8);
		Tarea tarea25 = new Tarea("descansar", true, 10, 5);
		actividad6.getConjuntoTareas().insertarFinal(tarea22);
		actividad6.getConjuntoTareas().insertarFinal(tarea23);
		actividad6.getConjuntoTareas().insertarFinal(tarea24);
		actividad6.getConjuntoTareas().insertarFinal(tarea25);
		
		Actividad actividad7 = new Actividad("leer","",true);
		Tarea tarea26 = new Tarea("elegir libro",true,12, 2);
		Tarea tarea27 = new Tarea("leer 20 min",true,20, 2);
		Tarea tarea28 = new Tarea("reflexionar",true,10, 7);
		actividad7.getConjuntoTareas().insertarFinal(tarea26);
		actividad7.getConjuntoTareas().insertarFinal(tarea27);
		actividad7.getConjuntoTareas().insertarFinal(tarea28);
		
		Actividad actividad8 = new Actividad("pasar examen", "preparacion para un examen",false);
		Tarea tarea29 = new Tarea("estudiar",true, 20, 2);
		Tarea tarea30 = new Tarea("practicar",true, 15, 8);
		Tarea tarea31 = new Tarea("relajarse",true, 15, 5);
		Tarea tarea32 = new Tarea("confiar",true, 2, 1);
		actividad8.getConjuntoTareas().insertarFinal(tarea29);
		actividad8.getConjuntoTareas().insertarFinal(tarea30);
		actividad8.getConjuntoTareas().insertarFinal(tarea31);
		actividad8.getConjuntoTareas().insertarFinal(tarea32);
		
		
		

		Proceso proceso1 = new Proceso(1, "Cosas cotidianas", 0, 0);
		proceso1.getConjuntoActividades().insertarFinal(actividad1);
		proceso1.getConjuntoActividades().insertarFinal(actividad2);
		proceso1.getConjuntoActividades().insertarFinal(actividad3);
		proceso1.getConjuntoActividades().insertarFinal(actividad4);

		Proceso proceso2 = new Proceso(2, "Estudiar", 0, 0);
		proceso2.getConjuntoActividades().insertarFinal(actividad5);
		proceso2.getConjuntoActividades().insertarFinal(actividad6);
		proceso2.getConjuntoActividades().insertarFinal(actividad7);
		proceso2.getConjuntoActividades().insertarFinal(actividad8);
		proceso2.getConjuntoActividades().insertarFinal(actividad1);
		
		listaProceso.insertarProceso(proceso1);
		listaProceso.insertarProceso(proceso2);


	}

	/**
	 * metodo para cargar los datos del archivo binario
	 */
	public void cargarResourceBinario() {

		listaProceso = Persistencia.cargarListaProcesoBinario();

	}

	/**
	 * metodo para guardar los datos en un archivo binario
	 */
	public void guardarResourceBinario() {

		Persistencia.guardarListaProcesoBinario(listaProceso);
	}

	public void crearListaProceso() {
		listaProceso = new ListaProceso();
	}

	public void crearProceso(int id, String nombre, int tiempoMax, int tiempoMin) {
		Proceso proceso = new Proceso(id, nombre, tiempoMax, tiempoMin);
		listaProceso.insertarProceso(proceso);
	}

	// -------------------------------- METODOS ACTIVIDADES-------------
	// -----------------------------------------------------------------

	/**
	 * metodo para crear una actividad al inicio
	 * @param nombreProceso
	 * @param nombre
	 * @param descripcion
	 * @param esObligatorio
	 */
	public void crearActividadInicio(String nombreProceso, String nombre, String descripcion, boolean esObligatorio) {

		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if (proceso != null) {
			Actividad actividad = new Actividad(nombre, descripcion, esObligatorio);
			proceso.getConjuntoActividades().insertarInicio(actividad);
		} else {
			JOptionPane.showMessageDialog(null,"el proceso no existe");
		}
	}

	/**
	 * metodo para crear una actividad al final
	 * @param nombreProceso
	 * @param nombre
	 * @param descripcion
	 * @param esObligatorio
	 * @return 
	 */
	public boolean crearActividadFin(String nombreProceso, String nombre, String descripcion, boolean esObligatorio) {

		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if (proceso != null) {
			Actividad actividad = new Actividad(nombre, descripcion, esObligatorio);
			return proceso.getConjuntoActividades().insertarFinal(actividad);
		} else {
			//JOptionPane.showMessageDialog(null, "el proceso no existe");
			return false;
			
		}
	}

	/**
	 * metodo para crear una actividad en una posicion determinada
	 * @param nombreProceso
	 * @param nombreActividadPrecede
	 * @param nombre
	 * @param descripcion
	 * @param esObligatorio
	 * @return 
	 */
	public boolean crearActividadPosicionDeterminada(String nombreProceso, String nombreActividadPrecede, String nombre,
			String descripcion, boolean esObligatorio) {

		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if (proceso != null) {
			Actividad actividad = new Actividad(nombre, descripcion, esObligatorio);
			return proceso.getConjuntoActividades().insertarPosDeterminada(actividad, nombreActividadPrecede);
		} else {
			//JOptionPane.showMessageDialog(null,"el proceso no existe");
			return false;
		}
	}

	/**
	 * metodo para obtener una actividad dado su nombre
	 * @param nombre
	 * @param nombreProceso
	 * @return
	 */
	public Actividad buscarActivida(String nombre, String nombreProceso) {

		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);

		if (proceso != null) {
			return proceso.getConjuntoActividades().buscarActividad(nombre);

		} else {
			JOptionPane.showMessageDialog(null,"el proceso no existe");
		
			return null;
		}
	}

	/**
	 * metodo para eliminar una actividad, dado su nombre
	 * @param nombreProceso
	 * @param nombre
	 */
	public void eliminarActividad(String nombreProceso, String nombre) {
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if (proceso != null) {
			proceso.getConjuntoActividades().eliminar(nombre);
		} else {
			JOptionPane.showMessageDialog(null,"el proceso no existe");
			
		}
	}

	/**
	 * metodo para crear una activdad despues de la ultima creada
	 * @param nombreProceso
	 * @param nombre
	 * @param descripcion
	 * @param esObligatorio
	 * @return 
	 */
	public boolean crearDespuesUltimaActividadCreada(String nombreProceso, String nombre, String descripcion,
			boolean esObligatorio) {
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if (proceso != null) {
			Actividad actividad = new Actividad(nombre, descripcion, esObligatorio);
			return proceso.getConjuntoActividades().insertarDespuesUltimaActividadInsertada(actividad);
		} else {
			//JOptionPane.showMessageDialog(null,"el proceso no existe");
			return false;
			
		}
	}

	/**
	 * metodo para intercambiar 2 actividades con o sin tareas
	 * @param nombreProceso1
	 * @param nombreProceso2
	 * @param nombreActividad1
	 * @param nombreActividad2
	 * @param cambiarConTareas
	 */
	public void interCambiarActividades(String nombreProceso1, String nombreProceso2, String nombreActividad1,
			String nombreActividad2, boolean cambiarConTareas) {

		listaProceso.intercambiarActividades(nombreProceso1, nombreProceso2, nombreActividad1, nombreActividad2,
				cambiarConTareas);

	}

	/**
	 * metodo para obtener el nombre de la ultima actividad creada
	 * @param nombreProceso
	 * @return
	 */
	public String obtenerNombreActividadActual(String nombreProceso) {
		
		return listaProceso.obtenerProceso(nombreProceso).getConjuntoActividades().getNombreUltimaActivdad();
	}

	/**
	 * metodo para obtener el numero de veces que una actividad esta en los procesos
	 * @param nombreActividad
	 * @return
	 */
	public String vecesActEnProcesos(String nombreActividad) {
		
		return listaProceso.vecesActEnProcesos(nombreActividad);
	}

	// -------------------------------- METODOS TAREAS------------------
	// -----------------------------------------------------------------
	

	/**
	 * metodo para crear tareas al inicio
	 * @param nombreProceso
	 * @param nombreActividad
	 * @param descripcion
	 * @param esObligatorio
	 * @param tiempoMax
	 * @param tiempoMin
	 */
	public void crearTareaInicio(String nombreProceso, String nombreActividad, String descripcion,
			boolean esObligatorio, int tiempoMax, int tiempoMin) {
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

	/**
	 * metodo para crear tareas al final
	 * @param nombreProceso
	 * @param nombreActividad
	 * @param descripcion
	 * @param esObligatorio
	 * @param tiempoMax
	 * @param tiempoMin
	 * @return 
	 */
	public boolean crearTareaFin(String nombreProceso, String nombreActividad, String descripcion, boolean esObligatorio,
			int tiempoMax, int tiempoMin) {
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if (proceso != null) {
			Actividad actividad = proceso.getConjuntoActividades().buscarActividad(nombreActividad);
			if (actividad != null) {
				Tarea tarea = new Tarea(descripcion, esObligatorio, tiempoMax, tiempoMin);
				return actividad.getConjuntoTareas().insertarFinal(tarea);
			} else {
				//JOptionPane.showMessageDialog(null,"la actividad no existe");
				return false;
				
			}
		} else {
			//JOptionPane.showMessageDialog(null,"el proceso no existe");
			return false;
			
		}
	}

	/**
	 * metodo para crear tareas en una posicion determinada
	 * @param nombreProceso
	 * @param nombreActividad
	 * @param indice
	 * @param descripcion
	 * @param esObligatorio
	 * @param tiempoMax
	 * @param tiempoMin
	 * @return 
	 */
	public boolean crearTareaPosicionDeterminada(String nombreProceso, String nombreActividad, int indice,
			String descripcion, boolean esObligatorio, int tiempoMax, int tiempoMin) {
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if (proceso != null) {
			Actividad actividad = proceso.getConjuntoActividades().buscarActividad(nombreActividad);
			if (actividad != null) {
				Tarea tarea = new Tarea(descripcion, esObligatorio, tiempoMax, tiempoMin);
				return actividad.getConjuntoTareas().insertarPosDeterminada(tarea, indice);
			} else {
				//JOptionPane.showMessageDialog(null,"la actividad no existe");
				return false;
				
			}
		} else {
			//JOptionPane.showMessageDialog(null, "el proceso no existe");
			return false;
			
		}
	}

	/**
	 * metodo para obtener una tarea dado su descripcion
	 * @param nombreProceso
	 * @param nombreActividad
	 * @param descripcion
	 * @return
	 */
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

	/**
	 * metodo para buscar una tarea al inicio
	 * @param nombreProceso
	 * @param descripcionTarea
	 * @return
	 */
	public Tarea buscarTareaInicio(String nombreProceso, String descripcionTarea) {
		return listaProceso.buscarTareaDesdeInicio(nombreProceso,descripcionTarea);
	}
	
	/**
	 * metodo para buscar una tarea desde la actual
	 * @param descripcionTarea
	 * @param nombreProceso
	 * @return
	 */
	public Tarea buscarTareaActual(String descripcionTarea, String nombreProceso) {

		Proceso p = listaProceso.obtenerProceso(nombreProceso);
		if(p!=null){
			return p.getConjuntoActividades().buscarTareaActual(descripcionTarea);
		}else{
			return null;
		}
		
	}

	/**
	 * metodo para buscar una tarea dado su descripcion
	 * @param nombreActividad
	 * @param descripcionTarea
	 * @param nombreProceso
	 * @return
	 */
	public Tarea buscarTareaNombreDado(String nombreActividad, String descripcionTarea,String nombreProceso) {
        
		Proceso p = listaProceso.obtenerProceso(nombreProceso);
		if(p!=null){
			return p.getConjuntoActividades().buscarTareaNombreDado(nombreActividad, descripcionTarea);
		}else{
			JOptionPane.showMessageDialog(null, "el proceso no existe");
			return null;
		}
	}


	/**
	 * metodo para calcular el tiempo minimo de un proceso
	 * @param nombreProceso
	 * @return
	 */
	public int calcularTiempoMinProceso(String nombreProceso) {
		return listaProceso.calcularTiempoMin(nombreProceso);
	}

	/**
	 * metodo para calcular el tiempo maximo de un proceso
	 * @param nombreProceso
	 * @return
	 */
	public int calcularTiempoMaxProceso(String nombreProceso) {
		// TODO Auto-generated method stub
		return listaProceso.calcularTiempoMax(nombreProceso);
	}

	// ------------------------------------------ PRUEBAS CON LAS TABLAS
	// ----------------------------------------------------

	public ListaProceso getLista() {
		return this.listaProceso;
	}


}
