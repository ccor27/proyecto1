package modelo;

import services.IColaService;
/**
 * 
 * posicion determinada agregar tarea
 * buscar tarea por descripcion
 */
public class ColaTarea implements IColaService {

	private NodoTarea inicio, fin;

	
	public ColaTarea(){
	
		this.inicio = null;
		this.fin = null;
	}

	@Override
	public void insertarFinal(Tarea tarea) {
		
		NodoTarea nodo = new NodoTarea(tarea);
		if(inicio == null){
			inicio = nodo;
		}else{
			fin.setSiguiente(nodo);
		}
		fin = nodo;
	}

	@Override
	public void eliminarTarea(Tarea tarea) {
     tarea = null;
	}
	
	public void mostrarTareas(){
		
		String datos ="";
		NodoTarea nodo = inicio;
		while(nodo!= null){
			datos += nodo.getTarea().getDescripcion()+"\n";
			nodo = nodo.getSiguiente();
		}
		System.out.println(datos);
	}
	@Override
	public void insertarPosDeterminada(Tarea tarea, int indice){
		int contador = 1;
		NodoTarea nuevoNodo = new NodoTarea(tarea);
		NodoTarea nodo = inicio;
		while(nodo!= null){
			if (contador == indice) {
				NodoTarea aux = nodo.getSiguiente();
				nodo.setSiguiente(nuevoNodo);
				nuevoNodo.setSiguiente(aux);
			}
			contador++;
			nodo = nodo.getSiguiente();
		}
	}
	@Override
	public Tarea buscarTarea(String descrp){
		
		NodoTarea nodo = inicio;
		Tarea tarea = null;
		while(nodo!= null){
			if(nodo.getTarea().getDescripcion().equalsIgnoreCase(descrp)){
				tarea = nodo.getTarea();
			}
			nodo = nodo.getSiguiente();
		}
		return tarea;
	}
	@Override
	public void insertarInicio(Tarea tarea){
		NodoTarea nuevoNodo = new NodoTarea(tarea);
		NodoTarea nodo = inicio;
		nuevoNodo.setSiguiente(nodo);
		inicio = nuevoNodo;
	}
	
}
