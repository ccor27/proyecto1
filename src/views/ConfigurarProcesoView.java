package views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

import java.awt.Window;

import javax.swing.JOptionPane;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import controller.ConfigurarProcesoViewController;
import controller.ModelFactoryController;
import modelo.Actividad;
import modelo.ColaTarea;
import modelo.ListaActividad;
import modelo.ListaProceso;
import modelo.Nodo;
import modelo.NodoDoble;
import modelo.Proceso;
import modelo.Tarea;

import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.events.TouchEvent;

public class ConfigurarProcesoView {

	protected Shell shlConfigurarProcesos;
	private Table tblActividades;
	private Table tblTareas;
	private Combo comboBoxProcesos;
	
	ConfigurarProcesoViewController procesoViewController = new ConfigurarProcesoViewController();
	private ListaProceso lista= procesoViewController.getListaProceso();

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
		//cargarDatos();
		shlConfigurarProcesos.open();
		shlConfigurarProcesos.layout();
		while (!shlConfigurarProcesos.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public void setListaProceso(ListaProceso lista){
		this.lista=lista;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlConfigurarProcesos = new Shell();
		shlConfigurarProcesos.setSize(799, 850);
		shlConfigurarProcesos.setText("Configurar  Procesos");
		
		comboBoxProcesos = new Combo(shlConfigurarProcesos, SWT.NONE);
		comboBoxProcesos.setBounds(10, 41, 284, 23);
		cargarDatosComboBox();
		comboBoxProcesos.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String nombreProceso = comboBoxProcesos.getText();
				cargarDatosTablaActivida(nombreProceso);
			}
		});
		
		Label lblProceso = new Label(shlConfigurarProcesos, SWT.NONE);
		lblProceso.setBounds(10, 10, 55, 15);
		lblProceso.setText("Procesos");
		
		Button btnAtras = new Button(shlConfigurarProcesos, SWT.NONE);
		btnAtras.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PrincipalView principalView = new PrincipalView();
				shlConfigurarProcesos.close();
				principalView.open();
			}
		});
		btnAtras.setBounds(446, 693, 117, 25);
		btnAtras.setText("Atras");
		
		Button btnCrearActividad = new Button(shlConfigurarProcesos, SWT.NONE);
		btnCrearActividad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				if(!comboBoxProcesos.getText().equalsIgnoreCase("")){
					String nombreProceso = comboBoxProcesos.getText();
					CrearActividadView crearActividadView = new CrearActividadView();
					crearActividadView.setValores(nombreProceso, lista);
					shlConfigurarProcesos.close();
					crearActividadView.open();
					
					

				}else{
					JOptionPane.showMessageDialog(null, "debe seleccionar un proceso",null, 0, null);
				}
			}
		});
		btnCrearActividad.setBounds(166, 693, 117, 25);
		btnCrearActividad.setText("Crear actividad");
		
		Group grpListaActividad = new Group(shlConfigurarProcesos, SWT.NONE);
		grpListaActividad.setText("Lista actividad");
		grpListaActividad.setBounds(10, 85, 724, 292);
		
		
		TableViewer tableViewer = new TableViewer(grpListaActividad, SWT.BORDER | SWT.FULL_SELECTION);
		tblActividades = tableViewer.getTable();
		tblActividades.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				int a = tblActividades.getSelectionIndex();
				System.out.println(a);
				String c = tblActividades.getItem(a).getText();
				System.out.println(c);
				String nombreProceso = comboBoxProcesos.getText();
				Actividad act = lista.obtenerProceso(nombreProceso).getConjuntoActividades().buscarActividad(c);
				cargarDatosTablaTarea(act);
			}
		});
		tblActividades.setBounds(10, 21, 704, 261);
		tblActividades.setLinesVisible(true);
		tblActividades.setHeaderVisible(true);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNombre = tableViewerColumn.getColumn();
		tblclmnNombre.setWidth(200);
		tblclmnNombre.setText("Nombre");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn_1.getColumn();
		tblclmnNewColumn.setWidth(263);
		tblclmnNewColumn.setText("Descripcion");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnObligatorio = tableViewerColumn_2.getColumn();
		tblclmnObligatorio.setWidth(238);
		tblclmnObligatorio.setText("Obligatorio");
		
		Group grpListaTarea = new Group(shlConfigurarProcesos, SWT.NONE);
		grpListaTarea.setText("Lista tarea");
		grpListaTarea.setBounds(10, 398, 724, 239);
		
		TableViewer tableViewer_1 = new TableViewer(grpListaTarea, SWT.BORDER | SWT.FULL_SELECTION);
		tblTareas = tableViewer_1.getTable();
		tblTareas.setLinesVisible(true);
		tblTareas.setHeaderVisible(true);
		tblTareas.setBounds(10, 25, 704, 204);
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnDescripcion = tableViewerColumn_3.getColumn();
		tblclmnDescripcion.setWidth(311);
		tblclmnDescripcion.setText("descripcion");
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnObligatorio_1 = tableViewerColumn_4.getColumn();
		tblclmnObligatorio_1.setWidth(127);
		tblclmnObligatorio_1.setText("Obligatorio");
		
		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnTiempoMinimo = tableViewerColumn_5.getColumn();
		tblclmnTiempoMinimo.setWidth(127);
		tblclmnTiempoMinimo.setText("Tiempo minimo");
		
		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnTiempoMaximo = tableViewerColumn_6.getColumn();
		tblclmnTiempoMaximo.setWidth(135);
		tblclmnTiempoMaximo.setText("Tiempo maximo");

	}
	
	public void cargarDatosComboBox(){
		
		Nodo<Proceso> puntero = lista.getInicio();
		while(puntero!=null){
			comboBoxProcesos.add(puntero.getValorNodo().getNombre());
			puntero=puntero.getSiguiente();
		}
	}
	
	public void cargarDatosTablaActivida(String nombre){
		
		tblActividades.removeAll();
		Proceso proceso = lista.obtenerProceso(nombre);
		if(proceso!=null){
			ListaActividad listaActividad = proceso.getConjuntoActividades();
			NodoDoble<Actividad> puntero = listaActividad.getCabeza();
			while(puntero!=null){
				Actividad act = puntero.getValorNodo();
				TableItem item = new TableItem(tblActividades, SWT.NONE);
				item.setText(new String[] {act.getNombre(),act.getDescripcion(),String.valueOf(act.getEsObligatorio())});
				puntero=puntero.getSiguiente();
			}
		}else{
			System.out.println("no hay procesos");
		}
	}
	
	public void cargarDatosTablaTarea(Actividad act){
		tblTareas.removeAll();
		ColaTarea cola = act.getConjuntoTareas();
		Nodo<Tarea> puntero = cola.getInicio();
		while(puntero!=null){
			Tarea t = puntero.getValorNodo();
			TableItem item = new TableItem(tblTareas, SWT.NONE);
			item.setText(new String[] {t.getDescripcion(),String.valueOf(t.getEsObligatorio()),t.getTiempoMax()+"",t.getTiempoMin()+""});
			puntero=puntero.getSiguiente();
		}
		
	}
	
	public void cargarDatos(){
 
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
