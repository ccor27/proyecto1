package pruebasUnitarias;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.ModelFactoryController;
import junit.framework.TestCase;
import modelo.Actividad;
import modelo.ColaTarea;
import modelo.Tarea;
import views.PrincipalView;

public class ColaTareaTest extends TestCase{

	Tarea tarea1 = new Tarea("prender carro",true, 1, 2);
	Tarea tarea2 = new Tarea("conducir hasta la U",true, 1, 2);
	Tarea tarea3 = new Tarea("estacionar",true, 1, 2);
	Tarea tarea4 = new Tarea("bajar del auto y dirigirse a clase",true, 1, 2);
	Actividad actividad1 = new Actividad("carro","como usar un carro", true);
	
	
	@Before
	protected void setUp() throws Exception {
		actividad1.getConjuntoTareas().insertarFinal(tarea1);
		actividad1.getConjuntoTareas().insertarFinal(tarea2);
		actividad1.getConjuntoTareas().insertarFinal(tarea3);
		actividad1.getConjuntoTareas().insertarFinal(tarea4);
		super.setUp();	
	}

	@Test
	public void testBuscarTarea() {
		
		Tarea resultadoEsperado = actividad1.getConjuntoTareas().buscarTarea("estacionar");
		Tarea resultado=tarea3;
		assertEquals(resultadoEsperado, resultado);
	}


	@Test
	public void testObtenerTiempoTotalCola() {
		int resultadoActual = 4;
		int resultadoEsperado = actividad1.getConjuntoTareas().obtenerTiempoTotalCola();
		assertEquals(resultadoEsperado, resultadoActual);
	}


	
	@Test
	public void testCalcularTiempoMin() {
		double resultadoActual = 8.0;
		double resultadoEsperado = actividad1.getConjuntoTareas().calcularTiempoMin();
		assertEquals(resultadoEsperado, resultadoActual,0);
	}

	@Test
	public void testCalcularTiempoMax() {
		double resultadoActual = 4.0;
		double resultadoEsperado = actividad1.getConjuntoTareas().calcularTiempoMax();
		assertEquals(resultadoEsperado, resultadoActual,0);
	}
//
//	@Test
//	public void testInsertarFinal() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsertarPosDeterminada() {
//		fail("Not yet implemented");
//	}
//
//
//	@Test
//	public void testInsertarInicio() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSacarPorElInicio() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testObtenerInicio() {
//		fail("Not yet implemented");
//	}

}
