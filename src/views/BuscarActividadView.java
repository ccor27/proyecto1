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

	protected Shell shlBuscarActividad;
	private Text txtDescripcionActividad;
	private Text txtEsObligatorioActividad;
	private JTextArea textarea1;
	private Text txtTareasActividad;
	private Combo comboBoxNombreProceso;
	private Combo comboBoxNombreActividad;

	private BuscarActividadViewController buscarActividadViewController = new BuscarActividadViewController();
	private ListaProceso lista= buscarActividadViewController.getListaProceso();
	private Text txtTiempoMax;
	private Text txtTiempoMin;
	private Text txtProcesos;
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
		shlBuscarActividad.open();
		shlBuscarActividad.layout();
		while (!shlBuscarActividad.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBuscarActividad = new Shell();
		shlBuscarActividad.setSize(618, 599);
		shlBuscarActividad.setText("Buscar actividad");
		
		Group grpProceso = new Group(shlBuscarActividad, SWT.NONE);
		grpProceso.setText("Proceso");
		grpProceso.setBounds(10, 10, 568, 68);
		
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
		
		Group grpActividad = new Group(shlBuscarActividad, SWT.NONE);
		grpActividad.setText("Actividad");
		grpActividad.setBounds(10, 84, 592, 406);
		
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
							txtTiempoMax.setText(String.valueOf(act.getTiempoMax()));
							txtTiempoMin.setText(String.valueOf(act.getTiempoMin()));
							txtProcesos.setText(String.valueOf(buscarActividadViewController.vecesActEnProcesos(nombreActividad)));
							//txtNumVecesActividadEnProcesos.setText(String.valueOf(buscarActividadViewController.vecesActEnProcesos(nombreActividad)));
							txtTareasActividad.setText(act.getConjuntoTareas().mostrarTareas());
						}else{
							
						}
					}
				}
			}
		});
		btnBuscar.setBounds(434, 27, 119, 25);
		btnBuscar.setText("Buscar");
		
		Label lblDescripcion = new Label(grpActividad, SWT.NONE);
		lblDescripcion.setBounds(26, 95, 84, 15);
		lblDescripcion.setText("Descripcion:");
		
		txtDescripcionActividad = new Text(grpActividad, SWT.BORDER | SWT.V_SCROLL);
		txtDescripcionActividad.setEditable(false);
		txtDescripcionActividad.setBounds(134, 82, 199, 45);
		
		Label lblObligatorio = new Label(grpActividad, SWT.NONE);
		lblObligatorio.setBounds(25, 188, 75, 15);
		lblObligatorio.setText("Obligatorio: ");
		
		txtEsObligatorioActividad = new Text(grpActividad, SWT.BORDER);
		txtEsObligatorioActividad.setEditable(false);
		txtEsObligatorioActividad.setEnabled(false);
		txtEsObligatorioActividad.setBounds(134, 185, 119, 21);
		
		Label lblTiempo = new Label(grpActividad, SWT.NONE);
		lblTiempo.setBounds(25, 154, 68, 15);
		lblTiempo.setText("Tiempo max: ");
		
		txtTareasActividad = new Text(grpActividad, SWT.BORDER | SWT.V_SCROLL);
		txtTareasActividad.setEnabled(true);
		txtTareasActividad.setEditable(false);
		txtTareasActividad.setBounds(10, 230, 572, 166);
		
		comboBoxNombreActividad = new Combo(grpActividad, SWT.NONE);
		comboBoxNombreActividad.setBounds(134, 29, 199, 23);
		
		txtTiempoMax = new Text(grpActividad, SWT.BORDER);
		txtTiempoMax.setEditable(false);
		txtTiempoMax.setText("");
		txtTiempoMax.setBounds(134, 151, 119, 21);
		
		Label lblTiempoMin = new Label(grpActividad, SWT.NONE);
		lblTiempoMin.setBounds(300, 188, 68, 15);
		lblTiempoMin.setText("Tiempo min: ");
		
		txtTiempoMin = new Text(grpActividad, SWT.BORDER);
		txtTiempoMin.setEditable(false);
		txtTiempoMin.setBounds(400, 185, 119, 21);
		
		Label lblEnCuantosProcesos = new Label(grpActividad, SWT.NONE);
		lblEnCuantosProcesos.setBounds(400, 82, 136, 18);
		lblEnCuantosProcesos.setText("Procesos en los que est\u00E1:");
		
		txtProcesos = new Text(grpActividad, SWT.BORDER | SWT.V_SCROLL);
		txtProcesos.setEditable(false);
		txtProcesos.setBounds(400, 106, 148, 51);
		
		Button btnAtras = new Button(shlBuscarActividad, SWT.NONE);
		btnAtras.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PrincipalView principalView = new PrincipalView();
				shlBuscarActividad.close();
				principalView.open();
			}
		});
		btnAtras.setBounds(503, 496, 75, 25);
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
