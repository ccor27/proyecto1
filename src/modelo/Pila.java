package modelo;

import java.io.Serializable;

public class Pila implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Nodo<Tarea> inicio;
	private int tamanio=0;
	
	public Pila(){
		inicio = null;
	}
	

	public void insertar(Tarea tarea){
		Nodo<Tarea>  nodo = new Nodo<Tarea> (tarea);
		if(inicio == null){
			inicio = nodo;
		}else{
			nodo.setSiguiente(inicio);
			inicio = nodo;
			
		}
		tamanio++;
	}
	
	public Tarea sacarTarea(){
		
		if(inicio==null){
			return null;
		}else{
			Nodo<Tarea>  aux = inicio;
			inicio = inicio.getSiguiente();
			tamanio--;
			return aux.getValorNodo();
		}

	}
	
	public int getTamanio(){
		return tamanio;
	}
	public Nodo<Tarea> getInicio() {
		return inicio;
	}

	public void setInicio(Nodo<Tarea> inicio) {
		this.inicio = inicio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
}
