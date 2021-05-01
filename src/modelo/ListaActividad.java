package modelo;

import services.IListaActividadService;

public class ListaActividad implements IListaActividadService{

	private NodoDoble<Actividad>cabeza, fin;
	private String nombreUltimaActivdad;
	private int longitud=0;
	
	public ListaActividad(){
		this.cabeza = null;
		this.fin=null;
	}
	
	@Override
	public void insertarInicio(Actividad actividad){
		
		NodoDoble<Actividad> nodo = new NodoDoble<Actividad>(actividad);
		
        if(cabeza == null){
        	cabeza = fin = nodo;
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
            	System.out.println("no sea imbecil, no repita nombres");
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
				
				NodoDoble<Actividad> aux = cabeza.getSiguiente();
				cabeza.setSiguiente(nodoNuevo);
				nodoNuevo.setAnterior(cabeza);
				nodoNuevo.setSiguiente(aux);
				aux.setAnterior(nodoNuevo);
				
				
			}else{
				
				if(nodo==fin){
					
					fin.setSiguiente(nodoNuevo);
					nodoNuevo.setAnterior(fin);
					fin=nodoNuevo;
					
				}else{
					
					NodoDoble<Actividad> aux = nodo.getSiguiente();
					nodo.setSiguiente(nodoNuevo);
                    nodoNuevo.setAnterior(nodo);
                    nodoNuevo.setSiguiente(aux);
                    aux.setAnterior(nodoNuevo);
					
					 
				}
			}
			longitud++;
			nombreUltimaActivdad = nodoNuevo.getValorNodo().getNombre();
		}else{
			System.out.println("actividad no existe");
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
			
			while(nodo.getSiguiente()!=null){
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
			while(nodo.getSiguiente()!=null){
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

			NodoDoble<Actividad> nodo =  new NodoDoble<Actividad>(actividad);
            fin.setSiguiente(nodo);
            nodo.setAnterior(fin);
            fin = nodo;
			nombreUltimaActivdad = nodo.getValorNodo().getNombre();
			 longitud++;
		}
		
		
	}
	
	@Override
	public void insertarDespuesUltimaActividadInsertada(Actividad actividad){
		
		NodoDoble<Actividad> nodo = buscarNodoActividad(nombreUltimaActivdad);
		if(nodo!=null){

//			if(nodo==cabeza){//agrega despues de la cabeza
//				NodoActividad aux = cabeza.getSiguiente();
//				NodoActividad nuevoNodo = new NodoActividad(actividad);
//				cabeza.setSiguiente(nuevoNodo);
//				nuevoNodo.setSiguiente(aux);
//				nuevoNodo.setAnterior(cabeza);
//				aux.setAnterior(nuevoNodo);
//			}else{
//				if(nodo==fin){//agrega despues del final
//					insertarFinal(actividad);
//				}else{// agrega en el medio de la lista
//					NodoActividad nuevoNodo = new NodoActividad(actividad);
//					NodoActividad aux = nodo.getSiguiente();
//					nuevoNodo.setAnterior(nodo);
//					nodo.setSiguiente(nuevoNodo);
//					nuevoNodo.setSiguiente(aux);
//                    aux.setAnterior(nuevoNodo);
//				}
//			}
//			
			 insertarPosDeterminada(actividad, nombreUltimaActivdad);
			
		}else{
			System.out.println("aun no se crean actividades");
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
	
	public void cambiarActividadesConTareas(String nombreActividad, Actividad actividad){
		
		NodoDoble<Actividad> actividadModificar = buscarNodoActividad(nombreActividad);
		if(actividadModificar!=null){
			
			if(actividad!=null){
				actividadModificar.setValorNodo(actividad);	
			}else{
				System.out.println("la actividad a intercambiar no existe");	
			}
		}else{
			System.out.println("la actividad a intercambiar no existe");
		}
		
	}
	
	public void cambiarActividadesSinTareas(String nombreActividad1, Actividad actividad2){
		
		NodoDoble<Actividad> actividadModificar = buscarNodoActividad(nombreActividad1);
		if(actividadModificar!=null){
				
			if(actividad2!=null){
			     actividadModificar.getValorNodo().setDescripcion(actividad2.getDescripcion());
			     actividadModificar.getValorNodo().setNombre(actividad2.getNombre());
			     actividadModificar.getValorNodo().setEsObligatorio(actividad2.getEsObligatorio());
			}else{
				System.out.println("la actividad a intercambiar no existe");	
			}
			
		}else{
			System.out.println("la actividad a intercambiar no existe");
		}
		
		
	}
	

}
