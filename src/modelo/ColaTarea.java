package modelo;

import java.io.Serializable;

import services.IColaService;

/**
 * 
 * posicion determinada agregar tarea buscar tarea por descripcion
 */
public class ColaTarea implements IColaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Nodo<Tarea> inicio, fin;

	public ColaTarea() {

		this.inicio = null;
		this.fin = null;
	}

	/**
	 * metodo para insertar una tarea al final
	 * 
	 * @return
	 */
	@Override
	public boolean insertarFinal(Tarea tarea) {

		Nodo<Tarea> nodo = new Nodo<Tarea>(tarea);

		if (inicio == null && fin == null) {

			inicio = nodo;
			inicio.setSiguiente(fin);
			return true;
		} else {

			if (fin == null) {// si solo hay una tarea, el final debe ser null

				// validamos que las tareas seguida, no sean No obligatorias
				if (!(nodo.getValorNodo().getEsObligatorio() == false
						&& inicio.getValorNodo().getEsObligatorio() == false)) {
					inicio.setSiguiente(nodo);
					fin = nodo;
					// inicio.setSiguiente(fin);
					// fin.setSiguiente(null);
					return true;
				} else {
					return false;
				}

			} else {// cuando hay 2 o mas tareas

				// validamos que las tareas seguida, no sean No obligatorias
				if (!(nodo.getValorNodo().getEsObligatorio() == false
						&& fin.getValorNodo().getEsObligatorio() == false)) {
					fin.setSiguiente(nodo);
					fin = nodo;
					return true;
				} else {

					return false;
				}
			}

		}

	}

	/**
	 * insertar una tarea en una posicion determinada
	 * 
	 * @return
	 */
	@Override
	public boolean insertarPosDeterminada(Tarea tarea, int indice) {

		int contador = 1;
		Pila pilaAux = new Pila();
		boolean centinela = false;
		Nodo<Tarea> nodo = null;

		while (true) {

			if (indice == 1) {// si se quiere ingresar una tarea en la primer
								// posicion

				if (inicio.getValorNodo().getEsObligatorio() == false && tarea.getEsObligatorio() == false) {
					break;
				} else {
					//insertarInicio(tarea);// insertamos la nueva tarea
					centinela = insertarInicio(tarea);
					break;
				}

			} else {// si se quiere agregar en otra posicion diferente a la
					// primera

				if (contador == indice && nodo != null) {

					if (nodo.getValorNodo().getEsObligatorio() == false && tarea.getEsObligatorio() == false
							&& nodo.getSiguiente().getValorNodo().getEsObligatorio() == false) {
						break;
					} else {
						centinela = insertarInicio(tarea);// insertamos la nueva tarea
						obtenerDatosPila(pilaAux);// ingresamos las tareas
													// anteriormente ingresadas
													// a la pila
						//centinela = true;
						break;
					}
				} else {
					// vamos sacando los elementos de la cola por el inicio y
					// agregandolos a una pila
					// hasta encontrar la posicion pedida
					nodo = sacarPorElInicio();
					pilaAux.insertar(nodo.getValorNodo());
				}
			}

			contador++;
		}
		return centinela;
	}

	/**
	 * metodo para ingresar las tareas que se almacenaron temporalmente en la
	 * pila en la cola de tareas
	 * 
	 * @param pila
	 */
	private void obtenerDatosPila(Pila pila) {

		Tarea tarea = pila.sacarTarea();
		while (tarea != null) {
			insertarInicio(tarea);
			tarea = pila.sacarTarea();
		}
	}

	/**
	 * metodo para buscar una tarea dado su descripcion
	 */
	@Override
	public Tarea buscarTarea(String descrp) {

		Nodo<Tarea> nodo = inicio;
		Tarea tarea = null;
		while (nodo != null) {

			if (nodo.getValorNodo().getDescripcion().equalsIgnoreCase(descrp)) {
				tarea = nodo.getValorNodo();
			}
			nodo = nodo.getSiguiente();
		}
		return tarea;
	}

	/**
	 * metodo para insertar una tarea al inicio de la cola
	 */
	@Override
	public boolean insertarInicio(Tarea tarea) {

		Nodo<Tarea> nuevoNodo = new Nodo<Tarea>(tarea);
		if (inicio == null) {
			inicio = nuevoNodo;
			// fin = nuevoNodo;
			inicio.setSiguiente(fin);
			return true;
		} else {
			if (inicio.getValorNodo().getEsObligatorio() == false && tarea.getEsObligatorio() == false) {
				return false;
				//System.out.println("no se pudo ingresar la tarea linea 176 ColaTarea");
			} else {
				Nodo<Tarea> nodo = inicio;
				nuevoNodo.setSiguiente(nodo);
				inicio = nuevoNodo;
				return true;
			}
		}
	}

	/**
	 * metodo para sacar tareas por el inicio
	 */
	@Override
	public Nodo<Tarea> sacarPorElInicio() {
		Nodo<Tarea> aux = inicio;
		inicio = inicio.getSiguiente();
		return aux;
	}

	/**
	 * metodo para obtener el tiempo total del las tareas.
	 * 
	 * @return tiempoTotal
	 */
	public int obtenerTiempoTotalCola() {

		Nodo<Tarea> puntero = inicio;
		int tiempoTotal = 0;
		while (puntero != null) {
			tiempoTotal += puntero.getValorNodo().getTiempo();
			puntero = puntero.getSiguiente();
		}
		return tiempoTotal;
	}

	/**
	 * metodo para mostrar las tareas
	 * 
	 * @return datos
	 */
	public String mostrarTareas() {
		String datos = "";
		Nodo<Tarea> puntero = inicio;
		while (puntero != null) {
			datos += puntero.getValorNodo().toString();
			puntero = puntero.getSiguiente();
		}
		return datos;
	}

	/**
	 * metodo para calcular el tiempo minimo de las tareas
	 * 
	 * @return tiempoMin
	 */
	public double calcularTiempoMin() {
		double tiempoMin = 0;
		Nodo<Tarea> puntero = inicio;
		while (puntero != null) {
			tiempoMin += puntero.getValorNodo().getTiempoMin();
			puntero = puntero.getSiguiente();
		}

		return tiempoMin;
	}

	/**
	 * metodo para calcular el tiempo maximo de las tareas
	 * 
	 * @return tiempoMax
	 */
	public double calcularTiempoMax() {
		double tiempoMax = 0;
		Nodo<Tarea> puntero = inicio;
		while (puntero != null) {
			tiempoMax += puntero.getValorNodo().getTiempoMax();
			puntero = puntero.getSiguiente();
		}

		return tiempoMax;
	}

	public Nodo<Tarea> getInicio() {
		return inicio;
	}

	public void setInicio(Nodo<Tarea> inicio) {
		this.inicio = inicio;
	}

	public Nodo<Tarea> getFin() {
		return fin;
	}

	public void setFin(Nodo<Tarea> fin) {
		this.fin = fin;
	}

}
