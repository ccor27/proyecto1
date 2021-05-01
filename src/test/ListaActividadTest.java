package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import modelo.Actividad;
import modelo.ListaActividad;
import modelo.NodoDoble;

public class ListaActividadTest {

	static ListaActividad lista;
	
	@BeforeClass
	public static void beforeClass(){
		lista = new ListaActividad();
	}

	@Test
	public void testInsertarInicio() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertarPosDeterminada(Actividad actividad, String nombre) {
		
		NodoDoble<Actividad> nodoNuevo = new NodoDoble<Actividad>(actividad);
		NodoDoble<Actividad> nodo = lista.buscarNodoActividad(nombre);
		
       assertNotNull(nodo);
	}

	@Test
	public void testBuscarActividad() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertarFinal() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertarDespuesUltimaActividadInsertada() {
		fail("Not yet implemented");
	}

	
}
