package modelo;

public class Tarea {
	
	private String descripcion;
	private boolean esObligatorio;
	private double tiempoMax;
	private double tiempoMin;
	private double tiempo;
	
	public Tarea(){
		
	}
	public Tarea(String descripcion, boolean esObligatorio, double tiempoMax, double tiempoMin){
		this.descripcion = descripcion;
		this.esObligatorio = esObligatorio;
		this.tiempoMax = tiempoMax;
		this.tiempoMin = tiempoMin;
		this.tiempo = (tiempoMax+tiempoMin)/2;
	}
	
	public double getTiempo() {
		return tiempo;
	}
	public void setTiempo(double tiempo) {
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
	public void setTiempoMax(double tiempoMax) {
		this.tiempoMax = tiempoMax;
	}
	public double getTiempoMin() {
		return tiempoMin;
	}
	public void setTiempoMin(double tiempoMin) {
		this.tiempoMin = tiempoMin;
	}
	@Override
	public String toString() {
		return "     Tarea: "+"\n"+"        "+descripcion+"\n"+"        "+tiempo+"\n"+"  "+"\n";
	}
	
	

}
