package modelo;


public class Nodo<T> {

	private Nodo<T> siguiente;
	private T valorNodo;
	

	public Nodo() {
		
	}
	

	public Nodo(T valorNodo) {
		this.valorNodo = valorNodo;
		this.siguiente = null;
	}
	
	public Nodo<T> getSiguiente() {
		return siguiente;
	}


	public void setSiguiente(Nodo<T> siguienteNodo) {
		this.siguiente = siguienteNodo;
	}


	public T getValorNodo() {
		return valorNodo;
	}


	public void setValorNodo(T valorNodo) {
		this.valorNodo = valorNodo;
	}
}
