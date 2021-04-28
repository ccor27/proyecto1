package modelo;

public class NodoDoble<T> {

	private NodoDoble<T> siguiente;
	private NodoDoble<T> anterior;
	private T valorNodo;
	
	

	public NodoDoble() {

	}
	
	
	public NodoDoble(T valorNodo) {
		super();
		this.valorNodo = valorNodo;
		this.siguiente = null;
		this.anterior = null;
	}
	

	//Metodos get y set de la clase Nodo
	
	public NodoDoble<T> getSiguiente() {
		return siguiente;
	}


	public void setSiguiente(NodoDoble<T> siguienteNodo) {
		this.siguiente = siguienteNodo;
	}


	public T getValorNodo() {
		return valorNodo;
	}


	public void setValorNodo(T valorNodo) {
		this.valorNodo = valorNodo;
	}


	public NodoDoble<T> getAnterior() {
		return anterior;
	}


	public void setAnterior(NodoDoble<T> anteriorNodo) {
		this.anterior = anteriorNodo;
	}
	
	
	
}
