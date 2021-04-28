package services;

import modelo.Nodo;
import modelo.NodoTarea;
import modelo.Tarea;

public interface IColaService {

	void insertarFinal(Tarea tarea);
	Nodo<Tarea> sacarPorElInicio();
	void insertarPosDeterminada(Tarea tarea, int indice);
	Tarea buscarTarea(String descrp);
	void insertarInicio(Tarea tarea);

}
