package modelo;

public class NodoActividad {

  private NodoActividad siguiente;
  private NodoActividad anterior;
  private Actividad actividad;
  
  public NodoActividad(Actividad actividad){
	  this.actividad = actividad;
	  this.siguiente=null;
	  this.anterior=null;
  }
  public NodoActividad(){
	  
  }
public NodoActividad getSiguiente() {
	return siguiente;
}
public void setSiguiente(NodoActividad siguiente) {
	this.siguiente = siguiente;
}
public NodoActividad getAnterior() {
	return anterior;
}
public void setAnterior(NodoActividad anterior) {
	this.anterior = anterior;
}
public Actividad getActividad() {
	return actividad;
}
public void setActividad(Actividad actividad) {
	this.actividad = actividad;
}

  
  
}
