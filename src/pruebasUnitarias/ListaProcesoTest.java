package pruebasUnitarias;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.ModelFactoryController;
import junit.framework.TestCase;
import modelo.Actividad;
import modelo.ListaProceso;
import modelo.Proceso;
import modelo.Tarea;

public class ListaProcesoTest extends TestCase {

	ListaProceso lista;
	ModelFactoryController controller = ModelFactoryController.getInstance();
	Proceso proceso1 = new Proceso(1, "Vida diaria", 0, 0);
	Actividad actividad1 = new Actividad("carro","como usar un carro", true);
	Tarea tarea1 = new Tarea("prender carro",true, 1, 2);
	Tarea tarea2 = new Tarea("conducir hasta la U",true, 1, 2);
	Tarea tarea3 = new Tarea("estacionar",true, 1, 2);
	Tarea tarea4 = new Tarea("bajar del auto y dirigirse a clase",true, 1, 2);
	@Before
	public void setUp() throws Exception {
		lista = controller.getLista();
		actividad1.getConjuntoTareas().insertarFinal(tarea1);
		actividad1.getConjuntoTareas().insertarFinal(tarea2);
		actividad1.getConjuntoTareas().insertarFinal(tarea3);
		actividad1.getConjuntoTareas().insertarFinal(tarea4);
		proceso1.getConjuntoActividades().insertarFinal(actividad1);
	}

//	@Test
//	public void testInsertarProceso() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testCalcularTiempoProceso() {
		int tiempoEsperado = lista.calcularTiempoProceso();
		int tiempoActual = 105;
		assertEquals(tiempoEsperado, tiempoActual);
	}

//	@Test
//	public void testObtenerProceso() {
//		Proceso procesoEsperado = lista.obtenerProceso(proceso1.getNombre());	
//		Proceso procesoActual = proceso1;
//		assertEquals(procesoEsperado, procesoActual);
//	}
//
//	@Test
//	public void testMostrarProcesos() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testObtenerCantidadProcesos() {
		int cantidadEsperada = lista.getLongitud();
		int cantidadActual = 2;
		assertEquals(cantidadEsperada, cantidadActual);
	}
//
//	@Test
//	public void testIntercambiarActividades() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testCalcularTiempoMin() {
		double tiempoMinEsperado = lista.calcularTiempoMin(proceso1.getNombre());
		double tiempoMinActual = 46.010000000000005; 
		assertEquals(tiempoMinEsperado, tiempoMinActual);
	}

	@Test
	public void testCalcularTiempoMax() {
		double tiempoMaxEsperado = lista.calcularTiempoMax(proceso1.getNombre());
		double tiempoMaxActual = 22.5101;
		assertEquals(tiempoMaxEsperado, tiempoMaxActual);
	}

}
