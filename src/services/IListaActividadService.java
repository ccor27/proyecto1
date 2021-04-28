package services;

import modelo.Actividad;

public interface IListaActividadService {

	void insertarInicio(Actividad actividad);
	void insertarFinal(Actividad actividad);
	void insertarPosDeterminada(Actividad actividad, String nombre);
	void insertarDespuesUltimaActividadInsertada(Actividad actividad);
	void eliminar(String nombre);
}
