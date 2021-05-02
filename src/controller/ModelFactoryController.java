package controller;

import modelo.Actividad;
import modelo.ListaActividad;
import modelo.ListaProceso;
import modelo.Proceso;
import modelo.Tarea;
import views.ConfigurarProcesoView;

public class ModelFactoryController {
	
	private ListaProceso listaProceso;

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
		
		listaProceso = new ListaProceso("a");
		//Proceso proceso1 = new Proceso(1,"primerProceso");
		//Actividad actividad1 = new Actividad();
		Tarea tarea1 = new Tarea("prender carro",true, 1, 2);
		Tarea tarea2 = new Tarea("conducir hasta la U",true, 1, 2);
		Tarea tarea3 = new Tarea("estacionar",true, 1, 2);
		Tarea tarea4 = new Tarea("bajar del auto y dirigirse a clase",true, 1, 2);
		
		Tarea tarea10 = new Tarea("prender estufa",true, 1, 2);
		Tarea tarea20 = new Tarea("poner las ollas",true, 1, 2);
		Tarea tarea30 = new Tarea("esperar...",true, 1, 2);
		Tarea tarea40 = new Tarea("servir para comer",true, 1, 2);
		
		Tarea tarea11 = new Tarea("prender el pc",true, 0.5, 1);
		Tarea tarea22 = new Tarea("abrir eclipse",true, 0.01, 0.01);
		Tarea tarea33 = new Tarea("programar :D",true, 10, 20);
		Tarea tarea44 = new Tarea("cobrar por hackear la nasa",true, 0.0001, 1);
		
		Tarea tarea111 = new Tarea("ponerse los guayos",true, 1, 2);
		Tarea tarea222 = new Tarea("calentar",true, 1, 2);
		Tarea tarea333 = new Tarea("jugar dando lo mejor",true, 1, 2);
		Tarea tarea444 = new Tarea("celebrar porque ganamos el torneo",true, 1, 2);
		
		Actividad actividad1 = new Actividad("carro","como usar un carro", true);
		actividad1.getConjuntoTareas().insertarFinal(tarea1);
		actividad1.getConjuntoTareas().insertarFinal(tarea2);
		actividad1.getConjuntoTareas().insertarFinal(tarea3);
		actividad1.getConjuntoTareas().insertarFinal(tarea4);
		
		Actividad actividad2 = new Actividad("cocinar", "como cocinar",true);
		actividad2.getConjuntoTareas().insertarFinal(tarea10);
		actividad2.getConjuntoTareas().insertarFinal(tarea20);
		actividad2.getConjuntoTareas().insertarFinal(tarea30);
		actividad2.getConjuntoTareas().insertarInicio(tarea40);
		
		Actividad actividad3 = new Actividad("programar","como programar",true);
		actividad3.getConjuntoTareas().insertarFinal(tarea11);
		actividad3.getConjuntoTareas().insertarFinal(tarea22);
		actividad3.getConjuntoTareas().insertarFinal(tarea33);
		actividad3.getConjuntoTareas().insertarFinal(tarea44);
		
		Actividad actividad4 = new Actividad("jugar futbol", "como ganar el campeonato",true);
		actividad4.getConjuntoTareas().insertarFinal(tarea111);
		actividad4.getConjuntoTareas().insertarFinal(tarea222);
		actividad4.getConjuntoTareas().insertarFinal(tarea333);
		actividad4.getConjuntoTareas().insertarFinal(tarea444);
		
		
		Proceso proceso1 = new Proceso(1, "proceso1",0,0);
     	proceso1.getConjuntoActividades().insertarFinal(actividad1);
		proceso1.getConjuntoActividades().insertarFinal(actividad4);
		proceso1.getConjuntoActividades().insertarFinal(actividad3);
		//proceso1.getConjuntoActividades().insertarFinal(actividad2);
//		proceso1.getConjuntoActividades().insertarPosDeterminada(actividad2, "jugar futbol");
//		Proceso proceso2 = new Proceso(2,"proceso2");
//		proceso2.getConjuntoActividades().insertarFinal(actividad2);
		listaProceso.insertarProceso(proceso1);
		//listaProceso.insertarProceso(proceso2);
		//listaProceso.mostrarProcesos();

        
		//actividad1.getConjuntoTareas().mostrarTareas();
		
		
		
	}
	

	public void crearListaProceso(){
		listaProceso= new ListaProceso();
	}
	
	public void crearProceso(int id, String nombre, double tiempoMax, double tiempoMin){
		Proceso proceso = new Proceso(id, nombre, tiempoMax, tiempoMin);
		listaProceso.insertarProceso(proceso);
	}
	
	//-------------------------------- METODOS ACTIVIDADES -----------------------------------------------------------------
	
	public void crearActividadInicio(String nombreProceso, String nombre, String descripcion, boolean esObligatorio){
		
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if(proceso!=null){
			Actividad actividad = new Actividad(nombre, descripcion, esObligatorio);
			proceso.getConjuntoActividades().insertarInicio(actividad);
		}else{
			System.out.println("el proceso no existe");
		}
	}
	public void crearActividadFin(String nombreProceso, String nombre, String descripcion, boolean esObligatorio){
		
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if(proceso!=null){
			Actividad actividad = new Actividad(nombre, descripcion, esObligatorio);
			proceso.getConjuntoActividades().insertarFinal(actividad);
		}else{
			System.out.println("el proceso no existe");
		}
	}
	
	public void crearActividadPosicionDeterminada(String nombreProceso,String nombreActividadPrecede, String nombre, String descripcion, boolean esObligatorio){
		
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if(proceso!=null){
			Actividad actividad = new Actividad(nombre, descripcion, esObligatorio);
			proceso.getConjuntoActividades().insertarPosDeterminada(actividad, nombreActividadPrecede);
		}else{
			System.out.println("el proceso no existe");
		}
	}
	
	public Actividad buscarActivida(String nombre, String nombreProceso){
		
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		
		if(proceso!=null){
			return  proceso.getConjuntoActividades().buscarActividad(nombre);

		}else{
			System.out.println("el proceso no existe");
			//hacer una excepcion
			return null;
		}
	}
	
	public void eliminarActividad(String nombreProceso, String nombre){
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if(proceso!=null){
			proceso.getConjuntoActividades().eliminar(nombre);
		}else{
			System.out.println("el proceso no existe");
		}
	}
	
	public void crearDespuesUltimaActividadCreada(String nombreProceso, String nombre, String descripcion, boolean esObligatorio){
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if(proceso!=null){
			Actividad actividad = new Actividad(nombre, descripcion, esObligatorio);
			proceso.getConjuntoActividades().insertarDespuesUltimaActividadInsertada(actividad);
		}else{
			System.out.println("el proceso no existe");
		}
	}
	
	//-------------------------------- METODOS TAREAS -----------------------------------------------------------------
	
	public void crearTareaInicio(String nombreProceso, String nombreActividad, String descripcion, boolean esObligatorio, double tiempoMax, double tiempoMin){
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if(proceso!=null){
			Actividad actividad = proceso.getConjuntoActividades().buscarActividad(nombreActividad);
			if(actividad!=null){
				Tarea tarea = new Tarea(descripcion, esObligatorio, tiempoMax, tiempoMin);
				actividad.getConjuntoTareas().insertarInicio(tarea);
			}else{
				System.out.println("la actividad no existe");
			}
		}else{
			System.out.println("el proceso no existe");
		}
	}
	
	public void crearTareaFin(String nombreProceso, String nombreActividad, String descripcion, boolean esObligatorio, double tiempoMax, double tiempoMin){
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if(proceso!=null){
			Actividad actividad = proceso.getConjuntoActividades().buscarActividad(nombreActividad);
			if(actividad!=null){
				Tarea tarea = new Tarea(descripcion, esObligatorio, tiempoMax, tiempoMin);
				actividad.getConjuntoTareas().insertarFinal(tarea);
			}else{
				System.out.println("la actividad no existe");
			}
		}else{
			System.out.println("el proceso no existe");	
		}
	}
	
	public void crearTareaPosicionDeterminada(String nombreProceso, String nombreActividad,int indice, String descripcion, boolean esObligatorio, double tiempoMax, double tiempoMin){
		Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
		if(proceso!=null){
			Actividad actividad = proceso.getConjuntoActividades().buscarActividad(nombreActividad);
			if(actividad!=null){
				Tarea tarea = new Tarea(descripcion, esObligatorio, tiempoMax, tiempoMin);
				actividad.getConjuntoTareas().insertarPosDeterminada(tarea, indice);
			}else{
				System.out.println("la actividad no existe");
			}
		}else{
			System.out.println("el proceso no existe");
		}
	}
	
    public Tarea obtenerTarea(String nombreProceso, String nombreActividad, String descripcion){
    	Proceso proceso = listaProceso.obtenerProceso(nombreProceso);
    	if(proceso!=null){
    		Actividad actividad = proceso.getConjuntoActividades().buscarActividad(nombreActividad);
    		if(actividad!=null){
    			return actividad.getConjuntoTareas().buscarTarea(descripcion);
    		}else{
    			//hacer excepcion
    			System.out.println("la activida no existe");
    			return null;
    		}
    		
    	}else{
    		//hacer excepcion
    		System.out.println("el proceso no existe");
    		return null;
    	}
    }
    
    public double calcularTiempoMinProceso (String nombreProceso){
    	return listaProceso.calcularTiempoMin(nombreProceso);
    }
    
	public double calcularTiempoMaxProceso(String nombreProceso) {
		// TODO Auto-generated method stub
		return listaProceso.calcularTiempoMax(nombreProceso);
	}
	
    
    //------------------------------------------ PRUEBAS CON LAS TABLAS ----------------------------------------------------
    
    public ListaProceso getLista(){
    	return this.listaProceso;
    }
   
	
}
