package modelo;

import java.io.Serializable;

public class ListaProceso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Nodo<Proceso> inicio;
	private int longitud;
	private int tiempoProceso;
	private String nombre;
	
	public ListaProceso(String nombre){
		this.nombre = nombre;
		inicio=null;
		this.longitud=0;
		this.tiempoProceso=0;
	}
	public ListaProceso(){
		
	}

	/**
	 * metodo para insertar un proceso 
	 * @param proceso
	 */
	public void insertarProceso(Proceso proceso){
		
		Nodo<Proceso> nodo = new Nodo<Proceso>(proceso); 
		if(inicio==null){
			inicio = nodo;
		}else{
			Nodo<Proceso> puntero = inicio;
			while(puntero.getSiguiente()!=null){
				puntero = puntero.getSiguiente();
			}
			puntero.setSiguiente(nodo);
		}
		
		longitud++;
	}
	
	/**
	 * metodo para calcular el tiempo de todos los procesos
	 * @return
	 */
	public int calcularTiempoProceso(){
	
		Nodo<Proceso> puntero = inicio;
		
		if(puntero==null){
	        return tiempoProceso;		
		}else{
			while(puntero!=null){
				tiempoProceso+=puntero.getValorNodo().getTiempo();
				puntero=puntero.getSiguiente();
			}
			return tiempoProceso;
		}
		
	}
	
	/**
	 * metodo para obtener un proceso dado su nombre
	 * @param nombre
	 * @return
	 */
	public Proceso obtenerProceso(String nombre){
		
		Nodo<Proceso> puntero = inicio;
		Proceso proceso = null;
		while(puntero!=null){
			if(puntero.getValorNodo().getNombre().equalsIgnoreCase(nombre)){
				proceso = puntero.getValorNodo();
			}
			puntero=puntero.getSiguiente();
		}
		return proceso;
	}
	
	/**
	 * metodo para mostrar un proceso
	 */
	public void mostrarProcesos(){
		String datos ="";
		Nodo<Proceso> puntero = inicio;
		while(puntero!=null){
			datos+=puntero.getValorNodo().toString()+"\n";
			puntero=puntero.getSiguiente();
		}
		System.out.println(datos);
	}
	
	/**
	 * metodo para intercambiar actividades con o sin tareas
	 * @param nombreProceso1
	 * @param nombreProceso2
	 * @param nombreActividad1
	 * @param nombreActividad2
	 * @param cambiarConTareas
	 */
	public void intercambiarActividades(String nombreProceso1,String nombreProceso2,String nombreActividad1,String nombreActividad2, boolean cambiarConTareas){
		
		Proceso p1 = obtenerProceso(nombreProceso1);
		Proceso p2 = obtenerProceso(nombreProceso2);
		
		if(p1==null || p2==null){
			
			System.out.println("uno de los procesos no existe");
			
		}else{
			
			Actividad act1 = p1.getConjuntoActividades().buscarActividad(nombreActividad1);
			Actividad act2 = p2.getConjuntoActividades().buscarActividad(nombreActividad2);
			
			if(act1==null || act2==null){
				
				System.out.println("uno de las actividades no existe");
				
			}else{
				
				if(cambiarConTareas){
					p1.getConjuntoActividades().cambiarActividadesConTareas(nombreActividad1, act2);
					p2.getConjuntoActividades().cambiarActividadesConTareas(nombreActividad2, act1);
				}else{
					p1.getConjuntoActividades().cambiarActividadesSinTareas(act1, act2);
				}
			}
		}
	}
	
	
	
	/**
	 * metodo para obtener el tiempo minimo de un proceso
	 * @param nombreProceso
	 * @return
	 */
	public int calcularTiempoMin(String nombreProceso) {
		Proceso p = obtenerProceso(nombreProceso);
		
		if(p==null){
			System.out.println("El proceso no existe.");
			return -1;
		}else{
			return p.getTiempoMin();
		}
		
	}
	
	/**
	 * metodo para obtener el tiempo maximo de un proceso
	 * @param nombreProceso
	 * @return
	 */
	public int calcularTiempoMax(String nombreProceso) {
		Proceso p = obtenerProceso(nombreProceso);
		
		if(p==null){
			System.out.println("El proceso no existe.");
			return -1;
		}else{
			return p.getTiempoMax();
		}
	}
	
	/**
	 * metodo para buscar una tarea desde el inicio de un proceso
	 * @param nombreProceso
	 * @param descripcion
	 * @return
	 */
	public Tarea buscarTareaDesdeInicio(String nombreProceso,String descripcion){
		
		Proceso proceso = obtenerProceso(nombreProceso);
		return proceso.getConjuntoActividades().buscarTareaInicio(descripcion);
	}
	
	/**
	 * metodo para calcular cuantas veces esta una actividad en los procesos
	 * @param nombreAct
	 * @return
	 */
	public String vecesActEnProcesos(String nombreAct){
		String procesos = "";
		Nodo<Proceso> puntero = inicio;
		while(puntero!=null){
			
	    if(puntero.getValorNodo().getConjuntoActividades().buscarActividad(nombreAct)!=null){
	    	procesos += puntero.getValorNodo().getNombre()+"\n";
	       }
	    puntero=puntero.getSiguiente();
		}
		return procesos;
	}
	
	public Nodo<Proceso> getInicio(){
		return this.inicio;
	}
	public int getLongitud(){
		return this.longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	public int getTiempoProceso() {
		return tiempoProceso;
	}
	public void setTiempoProceso(int tiempoProceso) {
		this.tiempoProceso = tiempoProceso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setInicio(Nodo<Proceso> inicio) {
		this.inicio = inicio;
	}
	
	
}
