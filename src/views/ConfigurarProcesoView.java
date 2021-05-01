package views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import controller.ModelFactoryController;
import modelo.Actividad;
import modelo.ListaActividad;
import modelo.ListaProceso;
import modelo.Nodo;
import modelo.NodoDoble;
import modelo.Proceso;

import org.eclipse.jface.viewers.TableViewerColumn;

public class ConfigurarProcesoView {

	protected Shell shlConfigurarProcesos;
	private Table tblActividades;
	private Table tblTareas;
	private ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ConfigurarProcesoView window = new ConfigurarProcesoView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		cargarDatos();
		shlConfigurarProcesos.open();
		shlConfigurarProcesos.layout();
		while (!shlConfigurarProcesos.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlConfigurarProcesos = new Shell();
		shlConfigurarProcesos.setSize(718, 520);
		shlConfigurarProcesos.setText("Configurar  Procesos");
		
		Combo comboBoxProcesos = new Combo(shlConfigurarProcesos, SWT.NONE);
		comboBoxProcesos.setBounds(10, 41, 284, 23);
		
		TableViewer tableViewer = new TableViewer(shlConfigurarProcesos, SWT.BORDER | SWT.FULL_SELECTION);
		tblActividades = tableViewer.getTable();
		tblActividades.setLinesVisible(true);
		tblActividades.setHeaderVisible(true);
		tblActividades.setBounds(10, 133, 399, 247);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNombre = tableViewerColumn.getColumn();
		tblclmnNombre.setWidth(100);
		tblclmnNombre.setText("Nombre");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn_1.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("obligatorio");
		
		TableViewer tableViewer_1 = new TableViewer(shlConfigurarProcesos, SWT.BORDER | SWT.FULL_SELECTION);
		tblTareas = tableViewer_1.getTable();
		tblTareas.setBounds(472, 133, 220, 247);
		
		Label lblActividad = new Label(shlConfigurarProcesos, SWT.NONE);
		lblActividad.setBounds(10, 102, 55, 15);
		lblActividad.setText("Actividad");
		
		Label lblTareas = new Label(shlConfigurarProcesos, SWT.NONE);
		lblTareas.setBounds(475, 102, 55, 15);
		lblTareas.setText("Tareas");
		
		Label lblProceso = new Label(shlConfigurarProcesos, SWT.NONE);
		lblProceso.setBounds(10, 10, 55, 15);
		lblProceso.setText("Procesos");
		
		Button btnAtras = new Button(shlConfigurarProcesos, SWT.NONE);
		btnAtras.setBounds(337, 432, 117, 25);
		btnAtras.setText("Atras");
		
		Button btnCrearActividad = new Button(shlConfigurarProcesos, SWT.NONE);
		btnCrearActividad.setBounds(137, 432, 117, 25);
		btnCrearActividad.setText("Crear actividad");
		
		Button btnCrearTarea = new Button(shlConfigurarProcesos, SWT.NONE);
		btnCrearTarea.setBounds(540, 432, 75, 25);
		btnCrearTarea.setText("Crear tarea");

	}
	
	public void cargarDatos(){
 
		ListaProceso lista = modelFactoryController.getLista();
		Nodo<Proceso> puntero = lista.getInicio();
		ListaActividad list = puntero.getValorNodo().getConjuntoActividades();
		NodoDoble<Actividad> puntero2 = list.getCabeza();
         
         while(puntero2!=null){
 			TableItem item = new TableItem(tblActividades, SWT.NONE);
 			String nombre =puntero2.getValorNodo().getNombre();
 			String oblig = String.valueOf(puntero2.getValorNodo().getEsObligatorio());
 			item.setText(new String[] {nombre,oblig});
 			puntero2=puntero2.getSiguiente();
         }
	}
}
