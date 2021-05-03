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
	
	@Override
	public void insertarInicio(Actividad actividad){
		
		NodoDoble<Actividad> nodo = new NodoDoble<Actividad>(actividad);
		
        if(cabeza == null){
        	cabeza = fin = nodo;
        	cabeza.setSiguiente(fin);
        	fin.setAnterior(cabeza);
        	nombreUltimaActivdad = actividad.getNombre();
        	longitud++;
        }else{
            if(!verificarRepetido(actividad.getNombre())){
               cabeza.setAnterior(nodo);
               nodo.setSiguiente(cabeza);
               cabeza = nodo;
               nombreUltimaActivdad = actividad.getNombre();
               longitud++;
            }else{
            	JOptionPane.showMessageDialog(null, "no puede ingresar actividades con el mismo nombre");
            }
        }
		
	}
	private boolean verificarRepetido(String nombre){
	
		NodoDoble<Actividad> nodo = cabeza;
	 boolean centinela = false;
	 
	 while(nodo.getSiguiente()!=null){
		
		 if(nodo.getValorNodo().getNombre().equalsIgnoreCase(nombre)){
			 centinela = true;
		 }
		 nodo=nodo.getSiguiente();
	 }
	
	 return centinela;
	}
	
	/**
	 * precede = anterior
	 * insertar una actividad
	 * @param actividad
	 * @param nombre
	 */
	@Override
	public void insertarPosDeterminada(Actividad actividad, String nombre){
		NodoDoble<Actividad> nodoNuevo = new NodoDoble<Actividad>(actividad);
		NodoDoble<Actividad> nodo =buscarNodoActividad(nombre);
		if(nodo!=null){
           
			if(nodo==cabeza){

				if(!verificarRepetido(actividad.getNombre())){

	  				NodoDoble<Actividad> aux = cabeza.getSiguiente();
	  				cabeza.setSiguiente(nodoNuevo);
	  				nodoNuevo.setAnterior(cabeza);
	  				nodoNuevo.setSiguiente(aux);
	  				aux.setAnterior(nodoNuevo);
				}else{
	  				JOptionPane.showMessageDialog(null, "no puede ingresar actividades con el mismo nombre");
				}

				
			}else{
				
				if(nodo==fin){
					
					if(!verificarRepetido(actividad.getNombre())){
						fin.setSiguiente(nodoNuevo);
						nodoNuevo.setAnterior(fin);
						fin=nodoNuevo;
					}else{
						JOptionPane.showMessageDialog(null, "no puede ingresar actividades con el mismo nombre");
						
					}

					
				}else{
					
					if(!verificarRepetido(actividad.getNombre())){
						NodoDoble<Actividad> aux = nodo.getSiguiente();
						nodo.setSiguiente(nodoNuevo);
	                    nodoNuevo.setAnterior(nodo);
	                    nodoNuevo.setSiguiente(aux);
	                    aux.setAnterior(nodoNuevo);
					}else{
						JOptionPane.showMessageDialog(null, "no puede ingresar actividades con el mismo nombre");
						
					}

					
					 
				}
			}
			longitud++;
			nombreUltimaActivdad = nodoNuevo.getValorNodo().getNombre();
		}else{
			JOptionPane.showMessageDialog(null, "actividad no existe");
			
		}
		
	}

	/**
	 *  METODO PARA BUSCAR Y RETORNAR UN NODO-ACTIVIDAD DADO SU NOMBRE
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
	 *  METODO PARA BUSCAR Y RETORNAR UNA ACRTIVIDAD DADO SU NOMBRE	
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
	
	@Override
	/// cambiarlo despues 
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

	@Override
	public void insertarFinal(Actividad actividad) {
		
		if (cabeza == null) {
			insertarInicio(actividad);
		} else {

			if(!verificarRepetido(actividad.getNombre())){
				NodoDoble<Actividad> nodo =  new NodoDoble<Actividad>(actividad);
	            fin.setSiguiente(nodo);
	            nodo.setAnterior(fin);
	            fin = nodo;
				nombreUltimaActivdad = nodo.getValorNodo().getNombre();
				 longitud++;
			}else{
				JOptionPane.showMessageDialog(null, "no puede ingresar actividades con el mismo nombre");
			}


		}
		
		
	}
	
	@Override
	public void insertarDespuesUltimaActividadInsertada(Actividad actividad){
		System.out.println(nombreUltimaActivdad);
		NodoDoble<Actividad> nodo = buscarNodoActividad(nombreUltimaActivdad);
		if(nodo!=null){
			
			 insertarPosDeterminada(actividad, nombreUltimaActivdad);
			
		}else{
			JOptionPane.showMessageDialog(null, "aun no se crean actividades");
		}
	}

	public int tiempoTodasActividades(){
	
		int tiempo=0;
		NodoDoble<Actividad> puntero = cabeza;
		while(puntero!=null){
			tiempo+= puntero.getValorNodo().getTiempo();
			puntero = puntero.getSiguiente();
		}
		return tiempo;
	}
	

	public String mostrarActividades(){
		String datos ="";
		NodoDoble<Actividad> puntero = cabeza;
        
//		if(puntero ==fin ){
//			datos+=puntero.getActividad().toString()+"\n";
//		}else{
			while(puntero!=null){
				datos+=puntero.getValorNodo().toString()+"\n";
				puntero=puntero.getSiguiente();
			}
		//}
		return datos;
	}
	
	public NodoDoble<Actividad> getCabeza(){
		return this.cabeza;
	}
	
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
	
	public double calcularTiempoMinActividades (){
		double tiempoMinActividades =0;
		NodoDoble<Actividad> puntero = cabeza;
		while(puntero!=null){
			tiempoMinActividades+=puntero.getValorNodo().getTiempoMin();
			puntero=puntero.getSiguiente();
		}
		return tiempoMinActividades;
	}
	
	public double calcularTiempoMaxActividades (){
		double tiempoMaxActividades =0;
		NodoDoble<Actividad> puntero = cabeza;
		while(puntero!=null){
			tiempoMaxActividades+=puntero.getValorNodo().getTiempoMax();
			puntero=puntero.getSiguiente();
		}
		return tiempoMaxActividades;
	}
	
	public Tarea buscarTareaInicio(String descripcion){
		numVecesTareaEnActividad=0;
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
		System.out.println("las veces que esta en actividades es: "+numVecesTareaEnActividad);
		return encontrada;
	}
	
	public Tarea buscarTareaNombreDado(String nombreActividad, String descripcionTarea){
		numVecesTareaEnActividad=0;
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
		System.out.println("las veces que esta en actividades es: "+numVecesTareaEnActividad);
		return encontrada;
	}
	public Tarea buscarTareaActual(String descrp){
		numVecesTareaEnActividad=0;
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
		System.out.println("las veces que esta en actividades es: "+numVecesTareaEnActividad);
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
