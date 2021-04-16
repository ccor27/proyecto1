package modelo;

public class NodoTarea {

	private NodoTarea siguiente;
	private Tarea tarea;
	
	public NodoTarea(){
		
	}
	public NodoTarea(Tarea tarea){
		this.tarea = tarea;
		this.siguiente = null;
	}
	public NodoTarea getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoTarea siguiente) {
		this.siguiente = siguiente;
	}
	public Tarea getTarea() {
		return tarea;
	}
	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	
}
