package modelo;

public class NodoProceso {

	private NodoProceso siguiente;
	private Actividad actividad;
	
	public NodoProceso(){
		
	}
	public NodoProceso(Actividad actividad){
		this.actividad = actividad;
	}
	public NodoProceso getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoProceso siguiente) {
		this.siguiente = siguiente;
	}
	public Actividad getActividad() {
		return actividad;
	}
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	
}
