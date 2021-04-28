package modelo;

import services.IColaService;
/**
 * 
 * posicion determinada agregar tarea
 * buscar tarea por descripcion
 */
public class ColaTarea implements IColaService {

	private Nodo<Tarea> inicio, fin;

	
	public ColaTarea(){
	
		this.inicio = null;
		this.fin = null;
	}

	@Override
	public void insertarFinal(Tarea tarea) {
		
		Nodo<Tarea> nodo = new Nodo<Tarea>(tarea);
		
		if(inicio == null || fin ==null){
			inicio = nodo;
			fin=nodo;
			inicio.setSiguiente(fin);
		}else{
			fin.setSiguiente(nodo);
		}
		fin = nodo;
	}

	/**
	 * insertar una tarea en una posicion determinada
	 */
	@Override
	public void insertarPosDeterminada(Tarea tarea, int indice){
		
		int contador = 1;	
		boolean centinela = false;
		Pila pilaAux = new Pila();
		
		while(centinela == false){
			Nodo<Tarea> nodo = sacarPorElInicio();
			//vamos sacando los elementos de la cola por el inicio y agregandolos a una pila
			// hasta encontrar la posicion pedida
			pilaAux.insertar(nodo.getValorNodo());
			
			if (contador == indice) {
				
                if(!(nodo.getValorNodo().getEsObligatorio())){
                   insertarInicio(tarea);//insertamos la nueva tarea
                   obtenerDatosPila(pilaAux);//ingresamos las tareas anteriormente ingresadas a la pila
                   centinela=true;
                }else{
                	System.out.println("no puede ingresar dos tareas NO obligatorias seguidas");
                }
			}
			contador++;
		}
	}
	
	/**
	 * metodo para ingresar las tareas que se almacenaron temporalmente en la pila en la cola de tareas
	 * @param pila
	 */
	private void obtenerDatosPila(Pila pila){
		
		int tam = pila.getTamanio();
		for (int i = tam; i > 0 ; i--) {
			insertarInicio(pila.sacarTarea());
		}
	}
	
	@Override
	public Tarea buscarTarea(String descrp){
		
		Nodo<Tarea> nodo = inicio;
		Tarea tarea = null;
		while(nodo!= null){
			if(nodo.getValorNodo().getDescripcion().equalsIgnoreCase(descrp)){
				tarea = nodo.getValorNodo();
			}
			nodo = nodo.getSiguiente();
		}
		return tarea;
	}
	@Override
	public void insertarInicio(Tarea tarea){

		
		Nodo<Tarea> nuevoNodo = new Nodo<Tarea>(tarea);
			if(inicio == null){
				inicio = nuevoNodo;
			}else{
				if(inicio.getValorNodo().getEsObligatorio()==true){
					Nodo<Tarea> nodo = inicio;
					nuevoNodo.setSiguiente(nodo);
					inicio = nuevoNodo;
				}else{
					System.out.println("no se pudo ingresar la tarea");
				}

			}
	}

	@Override
	public Nodo<Tarea> sacarPorElInicio() {
		Nodo<Tarea> aux = inicio;
		inicio = inicio.getSiguiente();
		return aux;
	}

	public int obtenerTiempoTotalCola(){
		
		Nodo<Tarea> puntero = inicio;
		int tiempoTotal = 0;
		while(puntero!=null){
			tiempoTotal += puntero.getValorNodo().getTiempo();
			puntero = puntero.getSiguiente();
		}
		return tiempoTotal;
	}
	
	public String mostrarTareas(){
		String datos="";
		Nodo<Tarea> puntero = inicio;
		while(puntero!=null){
			datos += puntero.getValorNodo().toString();
			puntero=puntero.getSiguiente();
		}
		return datos;
	}

}
