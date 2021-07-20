package views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

import javax.swing.JOptionPane;

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
	protected Shell shlTrasferenciaDeActividades;
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
	private Button btnNo;
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
		shlTrasferenciaDeActividades.open();
		shlTrasferenciaDeActividades.layout();
		cargarDatosComboBox();
		while (!shlTrasferenciaDeActividades.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlTrasferenciaDeActividades = new Shell();
		shlTrasferenciaDeActividades.setSize(920, 518);
		shlTrasferenciaDeActividades.setText("Trasferencia de actividades");
		
		Group grpProcesoUno = new Group(shlTrasferenciaDeActividades, SWT.NONE);
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
		
		Group grpProcesoDos = new Group(shlTrasferenciaDeActividades, SWT.NONE);
		grpProcesoDos.setText("Proceso Dos");
		grpProcesoDos.setBounds(465, 10, 429, 352);
		
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
		
		Label lblTransferirConTareas = new Label(shlTrasferenciaDeActividades, SWT.NONE);
		lblTransferirConTareas.setBounds(290, 387, 119, 15);
		lblTransferirConTareas.setText("Transferir con tareas:");
		
		btnSi = new Button(shlTrasferenciaDeActividades, SWT.RADIO);
		btnSi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnSi.setBounds(421, 386, 40, 16);
		btnSi.setText("Si");
		
		btnNo = new Button(shlTrasferenciaDeActividades, SWT.RADIO);
		btnNo.setBounds(488, 386, 54, 16);
		btnNo.setText("No");
		
		Button btnTransferir = new Button(shlTrasferenciaDeActividades, SWT.NONE);
		btnTransferir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

		if(comboBoxProceso1.getText().equalsIgnoreCase("") || comboBoxProceso2.getText().equalsIgnoreCase("")){
			JOptionPane.showMessageDialog(null, "Debe seleccionar los procesos");
		}else{
			int indicetblProce1 = tblProceso1.getSelectionIndex();
			int indicetblProce2 = tblProceso2.getSelectionIndex();
			if(indicetblProce1>=0 && indicetblProce2>=0){
				
				nombreActividadUno = tblProceso1.getItem(indicetblProce1).getText();
				NombreActividadDos = tblProceso2.getItem(indicetblProce2).getText();
				
				if(btnSi.getSelection() || btnNo.getSelection()){
					if(nombreActividadUno.equalsIgnoreCase("")||NombreActividadDos.equalsIgnoreCase("")){
						
						System.out.println("debe seleccionar una actividad por tarea");
						
					}else{
						
						if(btnSi.getSelection()){
							transferenciaController.interCambiarActividades(nombreProcesoUno, nombreProcesoDos, nombreActividadUno, 
									NombreActividadDos, true );
							
							        cargarDatosTablaProceso1(nombreProcesoUno);
							        cargarDatosTablaProceso2(nombreProcesoDos);
							        btnSi.setSelection(false);
							        btnNo.setSelection(false);
							        
						}else{
							transferenciaController.interCambiarActividades(nombreProcesoUno, nombreProcesoDos, nombreActividadUno, 
									NombreActividadDos, false );
							
							        cargarDatosTablaProceso1(nombreProcesoUno);
							        cargarDatosTablaProceso2(nombreProcesoDos);
							        btnSi.setSelection(false);
							        btnNo.setSelection(false);
							        
						}

					}
				}else{
					
					JOptionPane.showMessageDialog(null, "debe seleccionar si se trasfiere con o sin tareas.");
				}
			}else{
				 JOptionPane.showMessageDialog(null, "debe seleccionar una actividad de cada tabla");
			}
			
		}
//				
//				
//				
//				
//				
//				if(nombreActividadUno.equalsIgnoreCase("")||NombreActividadDos.equalsIgnoreCase("")){
//					
//				}else{
//					
//					transferenciaController.interCambiarActividades(nombreProcesoUno, nombreProcesoDos, nombreActividadUno, 
//							NombreActividadDos, btnSi.getSelection() );
//					
//					cargarDatosTablaProceso1(nombreProcesoUno);
//					cargarDatosTablaProceso2(nombreProcesoDos);
//				}

			}
		});
		btnTransferir.setBounds(343, 420, 75, 25);
		btnTransferir.setText("Transferir");
		
		Button btnAtras = new Button(shlTrasferenciaDeActividades, SWT.NONE);
		btnAtras.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PrincipalView principalView = new PrincipalView();
				shlTrasferenciaDeActividades.close();
				principalView.open();
			}
		});
		btnAtras.setBounds(169, 833, 75, 25);
		btnAtras.setText("Atras");
		
		Button btnAtras_1 = new Button(shlTrasferenciaDeActividades, SWT.NONE);
		btnAtras_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PrincipalView principalView = new PrincipalView();
				shlTrasferenciaDeActividades.close();
				principalView.open();
			}
		});
		btnAtras_1.setBounds(482, 420, 75, 25);
		btnAtras_1.setText("Atras");

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
}
