package modelo;

public class ListaProceso {

	private Nodo<Proceso> inicio;
	private int longitud;
	private int tiempoProceso;
	
	public ListaProceso(){
		inicio=null;
		this.longitud=0;
		this.tiempoProceso=0;
	}
	
	public void insertarProceso(Proceso proceso){
		
		Nodo<Proceso> nodo = new Nodo<Proceso>(proceso); 
		if(inicio==null){
			inicio = nodo;
		}else{
			Nodo<Proceso> puntero = inicio;
			while(puntero.getSiguiente()!=null){
				puntero = puntero.getSiguiente();
			}
			puntero.setSiguiente(nodo);
		}
		
		longitud++;
	}
	
	public int calcularTiempoProceso(){
	
		Nodo<Proceso> puntero = inicio;
		
		if(puntero==null){
	        return tiempoProceso;		
		}else{
			while(puntero!=null){
				tiempoProceso+=puntero.getValorNodo().getTiempo();
				puntero=puntero.getSiguiente();
			}
			return tiempoProceso;
		}
		
	}
	
	public Proceso obtenerProceso(String nombre){
		
		Nodo<Proceso> puntero = inicio;
		Proceso proceso = null;
		while(puntero!=null){
			if(puntero.getValorNodo().getNombre().equalsIgnoreCase(nombre)){
				proceso = puntero.getValorNodo();
			}
			puntero=puntero.getSiguiente();
		}
		return proceso;
	}
	
	public void mostrarProcesos(){
		String datos ="";
		Nodo<Proceso> puntero = inicio;
		while(puntero!=null){
			datos+=puntero.getValorNodo().toString()+"\n";
			puntero=puntero.getSiguiente();
		}
		System.out.println(datos);
	}
	
	public int obtenerCantidadProcesos(){
		return longitud;
	}
	
	public void intercambiarActividades(String nombreProceso1,String nombreProceso2,String nombreActividad1,String nombreActividad2, boolean cambiarConTareas){
		
		Proceso p1 = obtenerProceso(nombreProceso1);
		Proceso p2 = obtenerProceso(nombreProceso2);
		
		if(p1==null || p2==null){
			
			System.out.println("uno de los procesos no existe");
			
		}else{
			
			Actividad act1 = p1.getConjuntoActividades().buscarActividad(nombreActividad1);
			Actividad act2 = p2.getConjuntoActividades().buscarActividad(nombreActividad2);
			
			if(act1==null || act2==null){
				
				System.out.println("uno de las actividades no existe");
				
			}else{
				
				if(cambiarConTareas){
					p1.getConjuntoActividades().cambiarActividadesConTareas(nombreActividad1, act2);
					p2.getConjuntoActividades().cambiarActividadesConTareas(nombreActividad2, act1);
				}else{
					p1.getConjuntoActividades().cambiarActividadesSinTareas(nombreActividad1, act2);
					p2.getConjuntoActividades().cambiarActividadesSinTareas(nombreActividad2, act1);
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
