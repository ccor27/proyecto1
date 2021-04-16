package modelo;

import services.IListaActividadService;

public class ListaActividad implements IListaActividadService{

	private NodoActividad cabeza;
	private String nombreUltimaActivdad;
	
	public ListaActividad(){
		this.cabeza = null;
	}
	
	@Override
	public void insertarInicio(Actividad actividad){
		
		NodoActividad nodo = new NodoActividad(actividad);
		
        if(cabeza == null){
        	cabeza = nodo;
        	nombreUltimaActivdad = actividad.getNombre();
        }else{
            if(!verificarRepetido(actividad.getNombre())){
            	cabeza.setAnterior(nodo);
               nodo.setSiguiente(cabeza);
               cabeza = nodo;
               nombreUltimaActivdad = actividad.getNombre();
               
            }else{
            	System.out.println("no sea imbecil, no repita nombres");
            }
        }
		
	}
	public boolean verificarRepetido(String nombre){
	 NodoActividad nodo = cabeza;
	 boolean centinela = false;
	 while(nodo!=null){
		 if(nodo.getActividad().getNombre().equalsIgnoreCase(nombre)){
			 centinela = true;
		 }
	 }
	 return centinela;
	}
	
	public void insertarPosDeterminada(Actividad actividad, String nombre){
		NodoActividad nodoNuevo = new NodoActividad(actividad);
		NodoActividad nodo =buscarActividad(nombre);
		if(nodo!=null){
			NodoActividad aux = nodo.getSiguiente();
			nodo.setSiguiente(nodoNuevo);
			nodoNuevo.setSiguiente(aux);
			nodoNuevo.setAnterior(nodo);
			aux.setAnterior(nodoNuevo);
			nombreUltimaActivdad = nodoNuevo.getActividad().getNombre();
			
		}else{
			System.out.println("actividad no existe");
		}
	}

	public NodoActividad buscarActividad(String nombre){
		NodoActividad nodo = cabeza;
		NodoActividad encontrado = null;
		while(nodo!=null){
			if(nodo.getActividad().getNombre().equalsIgnoreCase(nombre)){
				encontrado = nodo;
			}
			nodo = nodo.getSiguiente();
		}
		return encontrado;
	}
	
	@Override
	public Actividad obtenerActividad() {
		return null;
	}

	@Override
	public void eliminar(Actividad actividad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertarFinal(Actividad actividad) {
		
		if (cabeza == null) {
			insertarInicio(actividad);
		} else {

			NodoActividad nodo =  new NodoActividad(actividad);
			NodoActividad puntero = cabeza;
			while(puntero.getSiguiente()!= null){
				puntero = puntero.getSiguiente();
			}
			puntero.setSiguiente(nodo);
			puntero.getSiguiente().setAnterior(puntero);
			nombreUltimaActivdad = nodo.getActividad().getNombre();
		}
	}
	
	public void insertarDespuesUltimaActividadInsertada(Actividad actividad){
		
		NodoActividad nodo = buscarActividad(nombreUltimaActivdad);
		if(nodo!=null){
			NodoActividad nodoNuevo = new NodoActividad(actividad);
			NodoActividad aux = nodo.getSiguiente();
			nodo.setSiguiente(nodoNuevo);
			nodoNuevo.setSiguiente(aux);
			nodoNuevo.setAnterior(nodo);
			aux.setAnterior(nodoNuevo);
		}else{
			System.out.println("aun no se crean actividades");
		}
	}

	@Override
	public void insertarMedio(Actividad actividad) {
		// TODO Auto-generated method stub
		
	}
	

}
