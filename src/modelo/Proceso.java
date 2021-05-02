package modelo;

public class Proceso {

	private int id;
	private String nombre;
	private ListaActividad conjuntoActividades;
	private double tiempo;
	private double tiempoMin;
	private double tiempoMax;
	
	public Proceso(){
		
	}
	public Proceso(int id, String nombre, double tiempoMin, double tiempoMax){
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
	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	public double getTiempoMin() {
		tiempoMin = conjuntoActividades.calcularTiempoMinActividades();
		return tiempoMin;
	}
	public void setTiempoMin(double tiempoMin) {
		this.tiempoMin = tiempoMin;
	}
	public double getTiempoMax() {
		tiempoMax = conjuntoActividades.calcularTiempoMaxActividades();
		return tiempoMax;
	}
	public void setTiempoMax(double tiempoMax) {
		this.tiempoMax = tiempoMax;
	}
	@Override
	public String toString() {
		return "Proceso "+nombre+"  timepo estimado: "+getTiempo()+" \n "+ conjuntoActividades.mostrarActividades();
	}
	
	
	

	
	
}
