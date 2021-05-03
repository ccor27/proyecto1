package persistencia;

import modelo.ListaProceso;



public class Persistencia {


	
	public static final String RUTA_ARCHIVO_MODELO_BANCO_BINARIO = "src/persistencia/ListaProcesoBinaria.dat";
	
  public static ListaProceso cargarListaProcesoBinario() {
		
		ListaProceso lista = null;
		
		try {
			lista = (ListaProceso)ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_BANCO_BINARIO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	public static void guardarListaProcesoBinario(ListaProceso lista) {

		try {
			ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_BANCO_BINARIO, lista);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
