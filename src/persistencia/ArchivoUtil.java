package persistencia;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 * Esta clase teine metodo estaticos que permite usarlos sin crear instancias de la clase 
 * Lo que se hizo fue crear esta libreria para el manejo de los archivos
 * @author Admin
 *
 */
public  class ArchivoUtil {	
	
	//------------------------------------SERIALIZACIÓN  y XML
	/**
	 * Escribe en el fichero que se le pasa el objeto que se le envia
	 * 
	 * @param rutaArchivo
	 *            path del fichero que se quiere escribir
	 * @throws IOException
	 */
	//------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public static Object cargarRecursoSerializado(String rutaArchivo)throws Exception 
	{
		Object aux = null;
//		Empresa empresa = null;
		ObjectInputStream ois = null;
		try {
			// Se crea un ObjectInputStream
			ois = new ObjectInputStream(new FileInputStream(rutaArchivo));

			aux = ois.readObject();

		} catch (Exception e2) {
			throw e2;
		} finally {
			if (ois != null)
				ois.close();
		}
		return aux;
	}
	
	
	public static void salvarRecursoSerializado(String rutaArchivo, Object object)	throws Exception {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo)); 
			oos.writeObject(object);
		} catch (Exception e) {
			throw e;
		} finally {
			if (oos != null)
				oos.close();
		}
	}
//	----------------------------------------------------


}
