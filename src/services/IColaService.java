package services;

import modelo.NodoTarea;
import modelo.Tarea;

public interface IColaService {

	void insertarFinal(Tarea tarea);
	void eliminarTarea(Tarea tarea);
	void insertarPosDeterminada(Tarea tarea, int indice);
	Tarea buscarTarea(String descrp);
	void insertarInicio(Tarea tarea);

}
