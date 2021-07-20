package services;

import modelo.Nodo;
import modelo.Tarea;

public interface IColaService {

	boolean insertarFinal(Tarea tarea);
	Nodo<Tarea> sacarPorElInicio();
	boolean insertarPosDeterminada(Tarea tarea, int indice);
	Tarea buscarTarea(String descrp);
	boolean insertarInicio(Tarea tarea);

}
