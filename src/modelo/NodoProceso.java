package modelo;

public class NodoProceso {

	private NodoProceso siguiente;
	private Proceso proceso;
	
	public NodoProceso(){
		
	}

	public NodoProceso(Proceso proceso){
		this.proceso=proceso;
		this.siguiente=null;
	}

	public NodoProceso getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoProceso siguiente) {
		this.siguiente = siguiente;
	}

	public Proceso getProceso() {
		return proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}
	
	
}
