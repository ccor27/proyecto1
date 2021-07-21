package pruebasUnitarias;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.ModelFactoryController;
import junit.framework.TestCase;
import modelo.Actividad;
import modelo.ListaActividad;
import modelo.ListaProceso;
import modelo.Proceso;
import modelo.Tarea;

public class ListaActividadTest extends TestCase {
	ModelFactoryController controller = ModelFactoryController.getInstance();
	Proceso proceso1 = new Proceso(1, "proceso1",0,0);
	Actividad actividad1 = new Actividad("carro","como usar un carro", true);
	Tarea tarea1 = new Tarea("prender carro",true, 1, 2);
	Tarea tarea2 = new Tarea("conducir hasta la U",true, 1, 2);
	Tarea tarea3 = new Tarea("estacionar",true, 1, 2);
	Tarea tarea4 = new Tarea("bajar del auto y dirigirse a clase",true, 1, 2);
	
	private ListaActividad lista;
	
	@Before
	protected void setUp() throws Exception {
		
		lista = new ListaActividad();
		proceso1.getConjuntoActividades().insertarFinal(actividad1);
		actividad1.getConjuntoTareas().insertarFinal(tarea1);
		actividad1.getConjuntoTareas().insertarFinal(tarea2);
		actividad1.getConjuntoTareas().insertarFinal(tarea3);
		actividad1.getConjuntoTareas().insertarFinal(tarea4);
		super.setUp();	
	}

//	@Test
//	public void testListaActividad() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsertarInicio() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsertarPosDeterminada() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testBuscarNodoActividad() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testBuscarActividad() {
//		String nombre=actividad1.getNombre();
//		Actividad resultadoEsperado = lista.buscarActividad(nombre);
//		Actividad resultadoActual = actividad1;
//		assertEquals(resultadoEsperado, resultadoActual);
//	}
//

	@Test
	public void testTiempoTodasActividades() {
		int tiempoEstimado = lista.tiempoTodasActividades();
		System.out.println(tiempoEstimado);
		int tiempoActual = 0;
		assertEquals(tiempoEstimado, tiempoActual);
	}
//
//	@Test
//	public void testMostrarActividades() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetCabeza() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCambiarActividadesConTareas() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCambiarActividadesSinTareas() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCalcularTiempoMinActividades() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCalcularTiempoMaxActividades() {
//		fail("Not yet implemented");
//	}

}
