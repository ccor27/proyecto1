package modelo;

public class Pila {

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
			inicio.setSiguiente(inicio);
			inicio = nodo;
			
		}
		tamanio++;
	}
	
	public Tarea sacarTarea(){
		Nodo<Tarea>  aux = inicio;
		inicio = inicio.getSiguiente();
		return aux.getValorNodo();
	}
	
	public int getTamanio(){
		return tamanio;
	}
}
