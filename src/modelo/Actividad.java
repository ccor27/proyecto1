package modelo;

public class Actividad {

	private String nombre;
	private String descripcion;
	private boolean esObligatorio;
	private ColaTarea conjuntoTareas = new ColaTarea();
	private int tiempo;
	
	public Actividad(){
		
	}
	public Actividad(String nombre, String descripcion, boolean esObligatorio){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.esObligatorio = esObligatorio;
	}
	
	/**
	 * metodos accesores de la clase
	 */
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isEsObligatorio() {
		return esObligatorio;
	}
	public void setEsObligatorio(boolean esObligatorio) {
		this.esObligatorio = esObligatorio;
	}
	public ColaTarea getConjuntoTareas() {
		return conjuntoTareas;
	}
	public void setConjuntoTareas(ColaTarea conjuntoTareas) {
		this.conjuntoTareas = conjuntoTareas;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
    public void mostrarTareas(){
    	conjuntoTareas.mostrarTareas();
    }
	
}
