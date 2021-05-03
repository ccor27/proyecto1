package views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import controller.ConfigurarProcesoViewController;
import controller.TransferenciaActividadesViewController;
import modelo.Actividad;
import modelo.ListaActividad;
import modelo.ListaProceso;
import modelo.Nodo;
import modelo.NodoDoble;
import modelo.Proceso;

import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Button;

public class TransferenciaActividadesView {

	TransferenciaActividadesViewController transferenciaController = new TransferenciaActividadesViewController();
	private ListaProceso lista= transferenciaController.getListaProceso();
	protected Shell shell;
	private String nombreProcesoUno,nombreProcesoDos;
	private int indexTablaUno,indexTablaDos;
	private String nombreActividadUno;
	private String NombreActividadDos;
	private Actividad actividUno, activiDos;
	private  Button btnSi;
	private Table tblProceso1;
	private Table tblProceso2;
	private Combo comboBoxProceso2;
	private Combo comboBoxProceso1;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TransferenciaActividadesView window = new TransferenciaActividadesView();
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
		shell.open();
		shell.layout();
		cargarDatosComboBox();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(494, 925);
		shell.setText("SWT Application");
		
		Group grpProcesoUno = new Group(shell, SWT.NONE);
		grpProcesoUno.setText("Proceso Uno");
		grpProcesoUno.setBounds(10, 10, 429, 352);
		
		Label lblSeleccionarProceso = new Label(grpProcesoUno, SWT.NONE);
		lblSeleccionarProceso.setBounds(10, 32, 121, 15);
		lblSeleccionarProceso.setText("Seleccionar Proceso:");
		
		tblProceso1 = new Table(grpProcesoUno, SWT.BORDER | SWT.FULL_SELECTION);
		tblProceso1.setBounds(10, 88, 409, 254);
		tblProceso1.setHeaderVisible(true);
		tblProceso1.setLinesVisible(true);
		
		TableColumn tblclmnNombre = new TableColumn(tblProceso1, SWT.NONE);
		tblclmnNombre.setWidth(100);
		tblclmnNombre.setText("Nombre");
		
		TableColumn tblclmnDescripcion = new TableColumn(tblProceso1, SWT.NONE);
		tblclmnDescripcion.setWidth(151);
		tblclmnDescripcion.setText("Descripcion");
		
		TableColumn tblclmnObligatorio = new TableColumn(tblProceso1, SWT.NONE);
		tblclmnObligatorio.setWidth(83);
		tblclmnObligatorio.setText("Obligatorio");
		
		TableColumn tblclmnTiempo = new TableColumn(tblProceso1, SWT.NONE);
		tblclmnTiempo.setWidth(70);
		tblclmnTiempo.setText("Tiempo");
		
		 comboBoxProceso1 = new Combo(grpProcesoUno, SWT.NONE);
		 comboBoxProceso1.addSelectionListener(new SelectionAdapter() {
		 	@Override
		 	public void widgetSelected(SelectionEvent e) {
		 		nombreProcesoUno=comboBoxProceso1.getText();
		 		cargarDatosTablaProceso1(nombreProcesoUno);
		 	}
		 });
		comboBoxProceso1.setBounds(137, 32, 170, 23);
		
		Group grpProcesoDos = new Group(shell, SWT.NONE);
		grpProcesoDos.setText("Proceso Dos");
		grpProcesoDos.setBounds(21, 442, 429, 352);
		
		Label lblSeleccionarProceso_1 = new Label(grpProcesoDos, SWT.NONE);
		lblSeleccionarProceso_1.setText("Seleccionar Proceso:");
		lblSeleccionarProceso_1.setBounds(10, 32, 120, 15);
		
		tblProceso2 = new Table(grpProcesoDos, SWT.BORDER | SWT.FULL_SELECTION);
		tblProceso2.setBounds(10, 78, 409, 264);
		tblProceso2.setHeaderVisible(true);
		tblProceso2.setLinesVisible(true);
		
		TableColumn tblclmnNombre_1 = new TableColumn(tblProceso2, SWT.NONE);
		tblclmnNombre_1.setWidth(100);
		tblclmnNombre_1.setText("Nombre");
		
		TableColumn tblclmnDescripcion_1 = new TableColumn(tblProceso2, SWT.NONE);
		tblclmnDescripcion_1.setWidth(142);
		tblclmnDescripcion_1.setText("Descripcion");
		
		TableColumn tblclmnObligatorio_1 = new TableColumn(tblProceso2, SWT.NONE);
		tblclmnObligatorio_1.setWidth(100);
		tblclmnObligatorio_1.setText("Obligatorio");
		
		TableColumn tblclmnTiempo_1 = new TableColumn(tblProceso2, SWT.NONE);
		tblclmnTiempo_1.setWidth(61);
		tblclmnTiempo_1.setText("Tiempo");
		
		comboBoxProceso2 = new Combo(grpProcesoDos, SWT.NONE);
		comboBoxProceso2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				nombreProcesoDos=comboBoxProceso2.getText();
				cargarDatosTablaProceso2(nombreProcesoDos);
			}
		});
		comboBoxProceso2.setBounds(135, 32, 169, 23);
		
		Label lblTransferirConTareas = new Label(shell, SWT.NONE);
		lblTransferirConTareas.setBounds(21, 391, 119, 15);
		lblTransferirConTareas.setText("Transferir con tareas:");
		
		btnSi = new Button(shell, SWT.RADIO);
		btnSi.setBounds(152, 390, 40, 16);
		btnSi.setText("Si");
		
		Button btnNo = new Button(shell, SWT.RADIO);
		btnNo.setBounds(219, 390, 54, 16);
		btnNo.setText("No");
		
		Button btnTransferir = new Button(shell, SWT.NONE);
		btnTransferir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				int indicetblProce1 = tblProceso1.getSelectionIndex();
				nombreActividadUno = tblProceso1.getItem(indicetblProce1).getText();
				int indicetblProce2 = tblProceso2.getSelectionIndex();
				NombreActividadDos = tblProceso2.getItem(indicetblProce2).getText();
				
				if(nombreActividadUno.equalsIgnoreCase("")||NombreActividadDos.equalsIgnoreCase("")){
					System.out.println("debe seleccionar una actividad por tarea");
				}else{
					
					transferenciaController.interCambiarActividades(nombreProcesoUno, nombreProcesoDos, nombreActividadUno, 
							NombreActividadDos, btnSi.getSelection() );
					
					cargarDatosTablaProceso1(nombreProcesoUno);
					cargarDatosTablaProceso2(nombreProcesoDos);
				}

			}
		});
		btnTransferir.setBounds(301, 381, 75, 25);
		btnTransferir.setText("Transferir");
		
		Button btnAtras = new Button(shell, SWT.NONE);
		btnAtras.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PrincipalView principalView = new PrincipalView();
				shell.close();
				principalView.open();
			}
		});
		btnAtras.setBounds(169, 833, 75, 25);
		btnAtras.setText("Atras");

	}
	public void cargarDatosComboBox(){
		
		Nodo<Proceso> puntero = lista.getInicio();
		while(puntero!=null){
			comboBoxProceso1.add(puntero.getValorNodo().getNombre());
			comboBoxProceso2.add(puntero.getValorNodo().getNombre());
			puntero=puntero.getSiguiente();
		}
	}
	public void cargarDatosTablaProceso1(String nombre){
		
		Proceso proceso = lista.obtenerProceso(nombre);
		if(proceso!=null){
			NodoDoble<Actividad> puntero = proceso.getConjuntoActividades().getCabeza();
			tblProceso1.removeAll();
			while(puntero!=null){
				Actividad act = puntero.getValorNodo();
				TableItem item = new TableItem(tblProceso1, SWT.NONE);
				item.setText(new String[] {act.getNombre(),act.getDescripcion(),String.valueOf(act.getEsObligatorio()),String.valueOf(act.getTiempo())});
				puntero=puntero.getSiguiente();
			}
		}else{
			System.out.println("proceso no existe");
		}

//		tblProceso1.removeAll();
//		Proceso proceso = lista.obtenerProceso(nombre);
//		if(proceso!=null){
//			ListaActividad listaActividad = proceso.getConjuntoActividades();
//			NodoDoble<Actividad> puntero = listaActividad.getCabeza();
//			while(puntero!=null){
//				Actividad act = puntero.getValorNodo();
//				TableItem item = new TableItem(tblProceso1, SWT.NONE);
//				item.setText(new String[] {act.getNombre(),act.getDescripcion(),String.valueOf(act.getEsObligatorio()),
//						String.valueOf(act.getTiempo())});
//				puntero=puntero.getSiguiente();
//			}
//		}else{
//			System.out.println("no hay procesos");
//		}
	}
	public void cargarDatosTablaProceso2(String nombre){
		
		Proceso proceso = lista.obtenerProceso(nombre);
		if(proceso!=null){
			NodoDoble<Actividad> puntero = proceso.getConjuntoActividades().getCabeza();
			tblProceso2.removeAll();
			while(puntero!=null){
				Actividad act = puntero.getValorNodo();
				TableItem item = new TableItem(tblProceso2, SWT.NONE);
				item.setText(new String[] {act.getNombre(),act.getDescripcion(),String.valueOf(act.getEsObligatorio()),String.valueOf(act.getTiempo())});
				puntero=puntero.getSiguiente();
			}
		}else{
			System.out.println("proceso no existe");
		}

	}
//		tblProceso2.removeAll();
//		Proceso proceso = lista.obtenerProceso(nombre);
//		if(proceso!=null){
//			ListaActividad listaActividad = proceso.getConjuntoActividades();
//			NodoDoble<Actividad> puntero = listaActividad.getCabeza();
//			while(puntero!=null){
//				Actividad act = puntero.getValorNodo();
//				TableItem item = new TableItem(tblProceso2, SWT.NONE);
//				item.setText(new String[] {act.getNombre(),act.getDescripcion(),String.valueOf(act.getEsObligatorio()),
//						String.valueOf(act.getTiempo())});
//				puntero=puntero.getSiguiente();
//			}
//		}else{
//			System.out.println("no hay procesos");
//		}
//	}
}
