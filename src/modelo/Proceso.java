package modelo;

public class Proceso {

	private int id;
	private String nombre;
	private ListaActividad conjuntoActividades;
	private int tiempo;
	
	public Proceso(){
		
	}
	public Proceso(int id, String nombre){
		this.id = id;
		this.nombre = nombre;
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
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	
}
