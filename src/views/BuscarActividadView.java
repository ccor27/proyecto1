package views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Text;

import controller.BuscarActividadViewController;
import controller.CrearActividadViewController;
import modelo.Actividad;
import modelo.ListaProceso;
import modelo.Nodo;
import modelo.NodoDoble;
import modelo.Proceso;

import org.eclipse.swt.widgets.Button;

import java.awt.TextArea;

import javax.swing.JTextArea;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class BuscarActividadView {

	protected Shell shell;
	private Text txtDescripcionActividad;
	private Text txtEsObligatorioActividad;
	private Text txtTiempoActividad;
	private JTextArea textarea1;
	private Text txtTareasActividad;
	private Combo comboBoxNombreProceso;
	private Combo comboBoxNombreActividad;

	private BuscarActividadViewController buscarActividadViewController = new BuscarActividadViewController();
	private ListaProceso lista= buscarActividadViewController.getListaProceso();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BuscarActividadView window = new BuscarActividadView();
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
		shell.setSize(618, 536);
		shell.setText("SWT Application");
		
		Group grpProceso = new Group(shell, SWT.NONE);
		grpProceso.setText("Proceso");
		grpProceso.setBounds(10, 10, 568, 82);
		
		Label lblSeleccionarProceso = new Label(grpProceso, SWT.NONE);
		lblSeleccionarProceso.setBounds(10, 32, 119, 15);
		lblSeleccionarProceso.setText("Seleccionar Proceso:");
		
		comboBoxNombreProceso = new Combo(grpProceso, SWT.NONE);
		comboBoxNombreProceso.setBounds(135, 32, 156, 23);
		cargarNombresProceso();
		comboBoxNombreProceso.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cargarNombresActividad();
			}
		});
		
		Group grpActividad = new Group(shell, SWT.NONE);
		grpActividad.setText("Actividad");
		grpActividad.setBounds(10, 100, 592, 356);
		
		Label lblIngreseElNombre = new Label(grpActividad, SWT.NONE);
		lblIngreseElNombre.setBounds(25, 32, 100, 15);
		lblIngreseElNombre.setText("Ingrese el Nombre:");
		
		Button btnBuscar = new Button(grpActividad, SWT.NONE);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String nombreProceso = comboBoxNombreProceso.getText();
				String nombreActividad = comboBoxNombreActividad.getText();
				if(nombreProceso.equalsIgnoreCase("")){
					System.out.println("debe seleccionar un proceso");
				}else{
					
					if(nombreActividad.equalsIgnoreCase("")){
						System.out.println("debe seleccionar una actividad");
					}else{
						Actividad act =buscarActividadViewController.buscarActivida(nombreActividad, nombreProceso);
						if(act!=null){
							txtDescripcionActividad.setText(act.getDescripcion());
							txtEsObligatorioActividad.setText(String.valueOf(act.getEsObligatorio()));
							txtTiempoActividad.setText(act.getTiempo()+"");
							txtTareasActividad.setText(act.getConjuntoTareas().mostrarTareas());
						}else{
							
						}
					}
				}
			}
		});
		btnBuscar.setBounds(409, 27, 119, 25);
		btnBuscar.setText("Buscar");
		
		Label lblDescripcion = new Label(grpActividad, SWT.NONE);
		lblDescripcion.setBounds(25, 85, 84, 15);
		lblDescripcion.setText("Descripcion:");
		
		txtDescripcionActividad = new Text(grpActividad, SWT.BORDER | SWT.V_SCROLL);
		txtDescripcionActividad.setEditable(false);
		txtDescripcionActividad.setEnabled(false);
		txtDescripcionActividad.setBounds(134, 67, 199, 58);
		
		Label lblObligatorio = new Label(grpActividad, SWT.NONE);
		lblObligatorio.setBounds(329, 143, 75, 15);
		lblObligatorio.setText("Obligatorio: ");
		
		txtEsObligatorioActividad = new Text(grpActividad, SWT.BORDER);
		txtEsObligatorioActividad.setEditable(false);
		txtEsObligatorioActividad.setEnabled(false);
		txtEsObligatorioActividad.setBounds(409, 140, 119, 21);
		
		Label lblTiempo = new Label(grpActividad, SWT.NONE);
		lblTiempo.setBounds(25, 143, 68, 15);
		lblTiempo.setText("Tiempo: ");
		
		txtTiempoActividad = new Text(grpActividad, SWT.BORDER);
		txtTiempoActividad.setEnabled(false);
		txtTiempoActividad.setEditable(false);
		txtTiempoActividad.setBounds(134, 140, 158, 21);
		
		txtTareasActividad = new Text(grpActividad, SWT.BORDER | SWT.V_SCROLL);
		txtTareasActividad.setEnabled(true);
		txtTareasActividad.setEditable(false);
		txtTareasActividad.setBounds(10, 186, 572, 146);
		
		comboBoxNombreActividad = new Combo(grpActividad, SWT.NONE);
		comboBoxNombreActividad.setBounds(131, 32, 161, 23);
		
		Button btnAtras = new Button(shell, SWT.NONE);
		btnAtras.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PrincipalView principalView = new PrincipalView();
				shell.close();
				principalView.open();
			}
		});
		btnAtras.setBounds(501, 462, 75, 25);
		btnAtras.setText("Atras");
		
		
		
		

	}
	public void cargarNombresProceso(){
		comboBoxNombreProceso.removeAll();
		Nodo<Proceso> puntero = lista.getInicio();
		while(puntero!=null){
			comboBoxNombreProceso.add(puntero.getValorNodo().getNombre());
			puntero=puntero.getSiguiente();
		}
	}
	
	public void cargarNombresActividad(){
		comboBoxNombreActividad.removeAll();
		String nombreProceso = comboBoxNombreProceso.getText();
        Proceso proceso = lista.obtenerProceso(nombreProceso);
        if(proceso!=null){
        	NodoDoble<Actividad> puntero = proceso.getConjuntoActividades().getCabeza();
        	while(puntero!=null){
        		comboBoxNombreActividad.add(puntero.getValorNodo().getNombre());
        		puntero=puntero.getSiguiente();
        	}
        }else{
        	System.out.println("proceso no existe");
        }
	}
}
