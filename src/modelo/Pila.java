package modelo;

public class Pila {

	private NodoTarea inicio;
	private int tamanio=0;
	
	public Pila(){
		inicio = null;
	}
	
	public void insertar(Tarea tarea){
		NodoTarea nodo = new NodoTarea(tarea);
		if(inicio == null){
			inicio = nodo;
		}else{
			inicio.setSiguiente(inicio);
			inicio = nodo;
			
		}
		tamanio++;
	}
	
	public Tarea sacarTarea(){
		NodoTarea aux = inicio;
		inicio = inicio.getSiguiente();
		return aux.getTarea();
	}
	
	public int getTamanio(){
		return tamanio;
	}
}
