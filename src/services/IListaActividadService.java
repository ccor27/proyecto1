package services;

import modelo.Actividad;

public interface IListaActividadService {

	void insertarInicio(Actividad actividad);
	void insertarFinal(Actividad actividad);
	void insertarMedio(Actividad actividad);
	Actividad obtenerActividad();
	void eliminar(Actividad actividad);
}
