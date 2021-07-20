package services;

import modelo.Actividad;

public interface IListaActividadService {

	boolean insertarInicio(Actividad actividad);
	boolean insertarFinal(Actividad actividad);
	boolean insertarPosDeterminada(Actividad actividad, String nombre);
	boolean insertarDespuesUltimaActividadInsertada(Actividad actividad);
	void eliminar(String nombre);
}
