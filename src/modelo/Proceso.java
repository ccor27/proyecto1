package modelo;

import java.io.Serializable;

public class Proceso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private ListaActividad conjuntoActividades;
	private int tiempo;
	private int tiempoMin;
	private int tiempoMax;
	
	public Proceso(){
		
	}
	public Proceso(int id, String nombre, int tiempoMin, int tiempoMax){
		this.id = id;
		this.nombre = nombre;
		this.tiempoMin = tiempoMin;
		this.tiempoMax = tiempoMax;
		this.conjuntoActividades = new ListaActividad();
		
	}

	/**
	 * 
	 * metodos accesores de los atributos de la clase
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ListaActividad getConjuntoActividades() {
		return conjuntoActividades;
	}
	public void setConjuntoActividades(ListaActividad conjuntoActividades) {
		this.conjuntoActividades = conjuntoActividades;
	}
	public double getTiempo() {
		tiempo = conjuntoActividades.tiempoTodasActividades();
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public int getTiempoMin() {
		tiempoMin = conjuntoActividades.calcularTiempoMinActividades();
		return tiempoMin;
	}
	public void setTiempoMin(int tiempoMin) {
		this.tiempoMin = tiempoMin;
	}
	public int getTiempoMax() {
		tiempoMax = conjuntoActividades.calcularTiempoMaxActividades();
		return tiempoMax;
	}
	public void setTiempoMax(int tiempoMax) {
		this.tiempoMax = tiempoMax;
	}
	@Override
	public String toString() {
		return "Proceso "+nombre+"  timepo estimado: "+getTiempo()+" \n "+ conjuntoActividades.mostrarActividades();
	}
	
	
	

	
	
}
