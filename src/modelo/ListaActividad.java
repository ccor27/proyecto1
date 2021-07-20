package modelo;

import java.io.Serializable;

import javax.swing.JOptionPane;

import services.IListaActividadService;

public class ListaActividad implements IListaActividadService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private NodoDoble<Actividad>cabeza, fin;
	private String nombreUltimaActivdad="";
	private int longitud=0;
	private int numVecesTareaEnActividad;
	
	public ListaActividad(){
		this.cabeza = null;
		this.fin=null;
	}
	
	/**
	 * metodo para insertar una actividad al inicio de la lista
	 */
	@Override
	public boolean insertarInicio(Actividad actividad){
		
		NodoDoble<Actividad> nodo = new NodoDoble<Actividad>(actividad);
		
        if(cabeza == null){
        	cabeza = fin = nodo;
        	nombreUltimaActivdad = actividad.getNombre();
        	longitud++;
        	return true;
        }else{
            if(!verificarRepetido(actividad.getNombre())){
               cabeza.setAnterior(nodo);
               nodo.setSiguiente(cabeza);
               cabeza = nodo;
               nombreUltimaActivdad = actividad.getNombre();
               longitud++;
               return true;
            }else{
            	//JOptionPane.showMessageDialog(null, "no puede ingresar actividades con el mismo nombre");
            	return false;
            }
        }
		
	}
	/**
	 * metodo para verificar que una actividad no se agregue 2 veces
	 * @param nombre
	 * @return centinela
	 */
	private boolean verificarRepetido(String nombre){
	System.out.println("entro al metodo de verificarrepetido");
		NodoDoble<Actividad> nodo = cabeza;
	 boolean centinela = false;
	 
	 while(nodo!=null){
		
		 if(nodo.getValorNodo().getNombre().equalsIgnoreCase(nombre)){
			 System.out.println("hay nombres repetidos");
			 centinela = true;
		 }
		 nodo=nodo.getSiguiente();
	 }
	
	 return centinela;
	}
	
	/**
	 *  metodo para insertar una actividad en una posicion determinada
	 * @param actividad
	 * @param nombre
	 * @return 
	 */
	@Override
	public boolean insertarPosDeterminada(Actividad actividad, String nombre){
		NodoDoble<Actividad> nodoNuevo = new NodoDoble<Actividad>(actividad);
		NodoDoble<Actividad> nodo =buscarNodoActividad(nombre);
		if(nodo!=null){

			if(nodo==cabeza && cabeza.getSiguiente()==null){
				cabeza.setSiguiente(nodoNuevo);
				nodoNuevo.setAnterior(cabeza);
				fin = nodoNuevo;
				longitud++;
				nombreUltimaActivdad = nodoNuevo.getValorNodo().getNombre();
				return true;
				
			}else{
				
				if(nodo==cabeza){

					if(!verificarRepetido(actividad.getNombre())){

		  				NodoDoble<Actividad> aux = cabeza.getSiguiente();
		  				cabeza.setSiguiente(nodoNuevo);
		  				nodoNuevo.setAnterior(cabeza);
		  				nodoNuevo.setSiguiente(aux);
		  				aux.setAnterior(nodoNuevo);
		  				longitud++;
		  				nombreUltimaActivdad = nodoNuevo.getValorNodo().getNombre();
		  				return true;
					}else{
		  				//JOptionPane.showMessageDialog(null, "no puede ingresar actividades con el mismo nombre");
						return false;
					}

					
				}else{
					
					if(nodo==fin){
						
						if(!verificarRepetido(actividad.getNombre())){
							fin.setSiguiente(nodoNuevo);
							nodoNuevo.setAnterior(fin);
							fin=nodoNuevo;
							longitud++;
							nombreUltimaActivdad = nodoNuevo.getValorNodo().getNombre();
							return true;
						}else{
							//JOptionPane.showMessageDialog(null, "no puede ingresar actividades con el mismo nombre");
							return false;
							
						}

						
					}else{
						
						if(!verificarRepetido(actividad.getNombre())){
							NodoDoble<Actividad> aux = nodo.getSiguiente();
							nodo.setSiguiente(nodoNuevo);
		                    nodoNuevo.setAnterior(nodo);
		                    nodoNuevo.setSiguiente(aux);
		                    aux.setAnterior(nodoNuevo);
		        			longitud++;
		        			nombreUltimaActivdad = nodoNuevo.getValorNodo().getNombre();
		                    return true;
						}else{
							//JOptionPane.showMessageDialog(null, "no puede ingresar actividades con el mismo nombre");
							return false;
							
						}

						
						 
					}
				}
			}
		
		}else{
			//JOptionPane.showMessageDialog(null, "actividad no existe");
			return false;
			
		}
		
	}

	/**
	 * metodo para buscar y retornar un nodo-actividad dado su nombre
	 * @param nombre
	 * @return
	 */
	public NodoDoble<Actividad>  buscarNodoActividad(String nombre){
		NodoDoble<Actividad> nodo = cabeza;
		NodoDoble<Actividad> encontrado = null;
		
		if(longitud==1){//si solo hay una actividad
			
			if(nodo.getValorNodo().getNombre().equalsIgnoreCase(nombre)){
				encontrado = nodo;
			}
			
		}else{//si hay mas de una actividad
			
			while(nodo!=null){
				if(nodo.getValorNodo().getNombre().equalsIgnoreCase(nombre)){
					encontrado = nodo;
				}
				nodo = nodo.getSiguiente();
			}
		}

		return encontrado;
	}
	
	/**
	 * metodo para buscar y retornar una actividad dado su nombre	
	 * @param nombre
	 * @return 
	 */
	public Actividad buscarActividad(String nombre){
		NodoDoble<Actividad> nodo = cabeza;
		Actividad actividad = null;
		
		if(longitud==1){//si solo hay una actividad
			if(nodo.getValorNodo().getNombre().equalsIgnoreCase(nombre)){
				actividad = nodo.getValorNodo();
			}
		}else{//si hay mas de una actividad
			while(nodo!=null){
				if(nodo.getValorNodo().getNombre().equalsIgnoreCase(nombre)){
					actividad = nodo.getValorNodo();
				}
				nodo = nodo.getSiguiente();
			}
		}

		return actividad;
	}
	
	/**
	 * metodo para eliminar una actividad dado su nombre
	 */
	@Override
	public void eliminar(String nombre) {
		
		NodoDoble<Actividad> nodo = buscarNodoActividad(nombre);
		if(nodo!=null){
             
			if(nodo==cabeza){//es el inicio
                  
				NodoDoble<Actividad> aux = cabeza.getSiguiente();
				aux.setAnterior(fin);
				fin.setSiguiente(aux);
				
			}else{
				
				if(nodo==fin){//es el final
					
					NodoDoble<Actividad> aux2 = fin.getAnterior();
					aux2.setSiguiente(cabeza);
					cabeza.setAnterior(aux2);
					
				}else{
					
					NodoDoble<Actividad> aux3 = nodo.getSiguiente();
					NodoDoble<Actividad> aux4 = nodo.getAnterior();
					aux3.setAnterior(aux4);
					aux4.setSiguiente(aux3);
				}
			}
		}else{
			System.out.println("la actividad a eliminar no existe");
		}
	}

	/**
	 * metodo para insertar una activadad al final
	 * @return 
	 */
	@Override
	public boolean insertarFinal(Actividad actividad) {
		
		if (cabeza == null) {
			return insertarInicio(actividad);
		} else {

			if(!verificarRepetido(actividad.getNombre())){
				NodoDoble<Actividad> nodo =  new NodoDoble<Actividad>(actividad);
	            fin.setSiguiente(nodo);
	            nodo.setAnterior(fin);
	            fin = nodo;
				nombreUltimaActivdad = nodo.getValorNodo().getNombre();
				 longitud++;
				
				 return true;
			}else{
				//JOptionPane.showMessageDialog(null, "no puede ingresar actividades con el mismo nombre");
				return false;
				
			}


		}
		
		
	}
	
	/**
	 * metodo para insertar una actividad despues de la ultima creada
	 * @return 
	 */
	@Override
	public boolean insertarDespuesUltimaActividadInsertada(Actividad actividad){
		System.out.println(nombreUltimaActivdad);
		NodoDoble<Actividad> nodo = buscarNodoActividad(nombreUltimaActivdad);
		if(nodo!=null){
			
			 return insertarPosDeterminada(actividad, nombreUltimaActivdad);
			
		}else{
			//JOptionPane.showMessageDialog(null, "aun no se crean actividades");
			return false;
		}
	}

	/**
	 * metodo para obtener el tiempo de todas las actividades
	 * @return
	 */
	public int tiempoTodasActividades(){
	
		int tiempo=0;
		NodoDoble<Actividad> puntero = cabeza;
		while(puntero!=null){
			tiempo+= puntero.getValorNodo().getTiempo();
			puntero = puntero.getSiguiente();
		}
		return tiempo;
	}
	

	/**
	 * metodo para mostrar todas las actividades
	 */
	public String mostrarActividades(){
		String datos ="";
		NodoDoble<Actividad> puntero = cabeza;
        
			while(puntero!=null){
				datos+=puntero.getValorNodo().toString()+"\n";
				puntero=puntero.getSiguiente();
			}
		return datos;
	}
	
	public NodoDoble<Actividad> getCabeza(){
		return this.cabeza;
	}
	
	/**
	 * metodo para cambiar 2 actividades con sus tareas
	 * @param nombreActividad
	 * @param actividad
	 */
	public void cambiarActividadesConTareas(String nombreActividad, Actividad actividad){
		
		NodoDoble<Actividad> actividadModificar = buscarNodoActividad(nombreActividad);
		if(actividadModificar!=null){
			
			if(actividad!=null){
				actividadModificar.setValorNodo(actividad);	
			}else{
				JOptionPane.showMessageDialog(null, "aun no se crean actividades");
				
				
			}
		}else{
			JOptionPane.showMessageDialog(null, "la actividad a intercambiar no existe");
			
		}
		
	}
	
	/**
	 * metodo para cambiar 2 actividades sin sus tareas
	 * @param actividad1
	 * @param actividad2
	 */
	public void cambiarActividadesSinTareas(Actividad actividad1, Actividad actividad2){
		
		String nombreAct1 = actividad1.getNombre();
		String descripcionAct1 = actividad1.getDescripcion();
		boolean esObligatorio1 = actividad1.getEsObligatorio();

		String nombreAct2 = actividad2.getNombre();
		String descripcionAct2 = actividad2.getDescripcion();
		boolean esObligatorio2 = actividad2.getEsObligatorio();
		
		actividad1.setNombre(nombreAct2);
		actividad1.setDescripcion(descripcionAct2);
		actividad1.setEsObligatorio(esObligatorio2);
		
		actividad2.setNombre(nombreAct1);
		actividad2.setDescripcion(descripcionAct1);
		actividad2.setEsObligatorio(esObligatorio1);
		
	}
	
	/**
	 * metodo para calcular el tiempo minimo de todas las actividades
	 * @return
	 */
	public int calcularTiempoMinActividades (){
		int tiempoMinActividades =0;
		NodoDoble<Actividad> puntero = cabeza;
		while(puntero!=null){
			tiempoMinActividades+=puntero.getValorNodo().getTiempoMin();
			puntero=puntero.getSiguiente();
		}
		return tiempoMinActividades;
	}
	
	/**
	 * metodo para calcular el tiempo maximo de todas las actividades
	 * @return
	 */
	public int calcularTiempoMaxActividades (){
		int tiempoMaxActividades =0;
		NodoDoble<Actividad> puntero = cabeza;
		while(puntero!=null){
			tiempoMaxActividades+=puntero.getValorNodo().getTiempoMax();
			puntero=puntero.getSiguiente();
		}
		return tiempoMaxActividades;
	}
	
	/**
	 * metodo para buscar una tareas desde el inicio 
	 * @param descripcion
	 * @return
	 */
	public Tarea buscarTareaInicio(String descripcion){
		
		NodoDoble<Actividad> puntero = cabeza;
		Tarea encontrada = null;
		while(puntero!=null){
			
			Tarea t = puntero.getValorNodo().getConjuntoTareas().buscarTarea(descripcion);
			if(t!=null){
				encontrada=t;
				numVecesTareaEnActividad++;
			}
			puntero=puntero.getSiguiente();
		}
		
		return encontrada;
	}
	
	/**
	 * metodo par buscar una tarea dada su descripcion
	 * @param nombreActividad
	 * @param descripcionTarea
	 * @return
	 */
	public Tarea buscarTareaNombreDado(String nombreActividad, String descripcionTarea){
		
		NodoDoble<Actividad> puntero = buscarNodoActividad(nombreActividad);
		Tarea encontrada = null;
		while(puntero!=null){
			Tarea t = puntero.getValorNodo().getConjuntoTareas().buscarTarea(descripcionTarea);
			
			if(t!=null){
				encontrada=t;
				numVecesTareaEnActividad++;
			}
			puntero=puntero.getSiguiente();
		}

		return encontrada;
	}
	/**
	 * metodo para buscar la ultima tarea creada
	 * @param descrp
	 * @return
	 */
	public Tarea buscarTareaActual(String descrp){
		
		NodoDoble<Actividad> puntero = buscarNodoActividad(nombreUltimaActivdad);
		Tarea encontrada = null;
		while(puntero!=null){
			Tarea t = puntero.getValorNodo().getConjuntoTareas().buscarTarea(descrp);
			if(t!=null){
				encontrada=t;
				numVecesTareaEnActividad++;
			}
			puntero=puntero.getSiguiente();
		}
		return encontrada;
		
	}
	

	public int getNumVecesTareaEnActividad() {
		return numVecesTareaEnActividad;
	}

	public void setNumVecesTareaEnActividad(int numVecesTareaEnActividad) {
		this.numVecesTareaEnActividad = numVecesTareaEnActividad;
	}

	public NodoDoble<Actividad> getFin() {
		return fin;
	}

	public void setFin(NodoDoble<Actividad> fin) {
		this.fin = fin;
	}

	public String getNombreUltimaActivdad() {
		return nombreUltimaActivdad;
	}

	public void setNombreUltimaActivdad(String nombreUltimaActivdad) {
		this.nombreUltimaActivdad = nombreUltimaActivdad;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public void setCabeza(NodoDoble<Actividad> cabeza) {
		this.cabeza = cabeza;
	}
}
