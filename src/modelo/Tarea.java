package modelo;

import java.io.Serializable;

public class Tarea implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descripcion;
	private boolean esObligatorio;
	private int tiempoMax;
	private int tiempoMin;
	private int tiempo;
	
	public Tarea(){
		
	}
	public Tarea(String descripcion, boolean esObligatorio, int tiempoMax, int tiempoMin){
		this.descripcion = descripcion;
		this.esObligatorio = esObligatorio;
		this.tiempoMax = tiempoMax;
		this.tiempoMin = tiempoMin;
		this.tiempo = (tiempoMax+tiempoMin)/2;
	}
	
	public double getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean getEsObligatorio() {
		return esObligatorio;
	}
	public void setEsObligatorio(boolean esObligatorio) {
		this.esObligatorio = esObligatorio;
	}
	public double getTiempoMax() {
		return tiempoMax;
	}
	public void setTiempoMax(int tiempoMax) {
		this.tiempoMax = tiempoMax;
	}
	public double getTiempoMin() {
		return tiempoMin;
	}
	public void setTiempoMin(int tiempoMin) {
		this.tiempoMin = tiempoMin;
	}
	@Override
	public String toString() {
		return "     Tarea: "+"\n"+"        "+"descripcion: "+descripcion+"\n"+"        "+"tiempo: "+tiempo+"\n"+
	                "        tiempo min: "+tiempoMin+"\n"+"        tiempo max: "+tiempoMax+"\n"+"\n";
	}
	
	

}
