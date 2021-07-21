package views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
//import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import controller.BuscarActividadViewController;
import controller.BuscarTareasViewController;
import controller.TransferenciaActividadesViewController;
import modelo.Actividad;
import modelo.ListaProceso;
import modelo.Nodo;
import modelo.NodoDoble;
import modelo.Proceso;
import modelo.Tarea;

import org.eclipse.swt.widgets.Composite;

import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.JOptionPane;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Group;

public class BuscarTareasView {

	BuscarTareasViewController buscarTareasViewController = new BuscarTareasViewController();
	private ListaProceso lista= buscarTareasViewController.getListaProceso();
	protected Shell shlBuscarTareas;
	String nombreProceso;
	Combo comboBoxNombreProceso;
	private Combo comboBoxNombreActividad;
	private Text txtDescripcion;
	private Text txtMaximo;
	private Text txtMinimo;
	private Text txtObligatorio;
	String nombreActividad;
	private Text txtVeces;
	private Button btnBuscarDadoNombre;
	private Button btnBuscarActual;
	private Button btnBuscarInicio;
	private Combo comboDescripTarea;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BuscarTareasView window = new BuscarTareasView();
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
		cargarNombreProcesosComboBox();
		shlBuscarTareas.open();
		shlBuscarTareas.layout();
		while (!shlBuscarTareas.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBuscarTareas = new Shell();
		shlBuscarTareas.setSize(680, 565);
		shlBuscarTareas.setText("Buscar Tareas");
		
		
		
		Group grpDetalleTarea = new Group(shlBuscarTareas, SWT.NONE);
		grpDetalleTarea.setText("Detalle Tarea");
		grpDetalleTarea.setBounds(10, 281, 627, 171);
		
		Label lblObligatorio_1 = new Label(grpDetalleTarea, SWT.NONE);
		lblObligatorio_1.setBounds(335, 24, 78, 15);
		lblObligatorio_1.setText("Obligatorio: ");
		
		txtObligatorio = new Text(grpDetalleTarea, SWT.BORDER);
		txtObligatorio.setBounds(430, 21, 122, 21);
		txtObligatorio.setEditable(false);
		txtObligatorio.setEnabled(false);
		
		Label lblTiempoMinimo = new Label(grpDetalleTarea, SWT.NONE);
		lblTiempoMinimo.setBounds(335, 77, 91, 15);
		lblTiempoMinimo.setText("Tiempo minimo:");
		
		txtMinimo = new Text(grpDetalleTarea, SWT.BORDER);
		txtMinimo.setBounds(430, 77, 122, 21);
		txtMinimo.setEditable(false);
		txtMinimo.setEnabled(false);
		
		Label lblDescripcion_1 = new Label(grpDetalleTarea, SWT.NONE);
		lblDescripcion_1.setBounds(20, 40, 80, 15);
		lblDescripcion_1.setText("Descripcion: ");
		
		txtDescripcion = new Text(grpDetalleTarea, SWT.BORDER | SWT.V_SCROLL);
		txtDescripcion.setEnabled(false);
		txtDescripcion.setEditable(false);
		txtDescripcion.setBounds(125, 21, 170, 51);
		
		Label lblTiempoMaximo = new Label(grpDetalleTarea, SWT.NONE);
		lblTiempoMaximo.setBounds(20, 86, 102, 15);
		lblTiempoMaximo.setText("Tiempo maximo:");
		
		txtMaximo = new Text(grpDetalleTarea, SWT.BORDER);
		txtMaximo.setBounds(123, 86, 172, 21);
		txtMaximo.setEnabled(false);
		txtMaximo.setEditable(false);
		
		Label lblEnCuantasActividades = new Label(grpDetalleTarea, SWT.NONE);
		lblEnCuantasActividades.setBounds(10, 127, 143, 15);
		lblEnCuantasActividades.setText("En cuantas actividades esta");
		
		txtVeces = new Text(grpDetalleTarea, SWT.BORDER);
		txtVeces.setBounds(159, 121, 136, 21);
		
		Button btnAtras = new Button(shlBuscarTareas, SWT.NONE);
		btnAtras.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PrincipalView principalView = new PrincipalView();
				shlBuscarTareas.close();
				principalView.open();
			}
		});
		btnAtras.setBounds(270, 475, 96, 25);
		btnAtras.setText("Atras");
		
		Group grpBuscar = new Group(shlBuscarTareas, SWT.NONE);
		grpBuscar.setText("Buscar Tarea");
		grpBuscar.setBounds(10, 10, 627, 247);
		
		Label lblProcesos = new Label(grpBuscar, SWT.NONE);
		lblProcesos.setBounds(319, 67, 68, 19);
		lblProcesos.setText("Procesos");
		
		Label lblIngreseLaActividad = new Label(grpBuscar, SWT.NONE);
		lblIngreseLaActividad.setBounds(10, 121, 103, 15);
		lblIngreseLaActividad.setText("nombre actividad");
		
		comboBoxNombreProceso = new Combo(grpBuscar, SWT.NONE);
		comboBoxNombreProceso.setBounds(421, 64, 170, 23);
		
		comboBoxNombreActividad = new Combo(grpBuscar, SWT.NONE);
		comboBoxNombreActividad.setBounds(121, 118, 170, 23);
		
		btnBuscarDadoNombre = new Button(grpBuscar, SWT.NONE);
		btnBuscarDadoNombre.setBounds(30, 200, 144, 25);
		btnBuscarDadoNombre.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				if(!(comboDescripTarea.getText().equalsIgnoreCase("") || comboBoxNombreProceso.getText().equalsIgnoreCase("") 
						|| comboBoxNombreActividad.getText().equalsIgnoreCase(""))){
					
					Tarea tarea = buscarTareasViewController.buscarTareaNombreDado(comboBoxNombreActividad.getText(),comboDescripTarea.getText(),comboBoxNombreProceso.getText());
					if(tarea!=null){
						mostrar(tarea);
					}else{
						JOptionPane.showMessageDialog(null, "la tarea no existe en el proceso.");
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "debe seleccionar el nombre del proceso y \n el nombre de la actividad");
				}
//		        Tarea tarea;
//				String nombreProceso = comboBoxNombreProceso.getText();
//				String nombreActividad = comboBoxNombreActividad.getText();
//				String descripcionTarea = txtDecsripTarea.getText();
//				if(nombreProceso.equalsIgnoreCase("")||nombreActividad.equalsIgnoreCase("")||descripcionTarea.equalsIgnoreCase("")){
//					JOptionPane.showMessageDialog(null, "falto por ingresear la descripcion o seleccionar la actividad o el proceso");
//				}else{
//				     tarea = buscarTareasViewController.buscarTareaNombreDado(nombreActividad,descripcionTarea,nombreProceso);
//				     if(tarea==null){
//				    	 JOptionPane.showMessageDialog(null, "la tarea no existe");
//				     }else{
//				    	 mostrar(tarea);
//				    	 limpiar();
//				     }
//				}
		}
				
		});
		btnBuscarDadoNombre.setText("Buscar dada su nombre");
		
		btnBuscarActual = new Button(grpBuscar, SWT.NONE);
		btnBuscarActual.setBounds(243, 200, 144, 25);
		btnBuscarActual.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				
//				
//				if (comboBoxNombreProceso.getText().equalsIgnoreCase("") || text_Buscar3.getText().equalsIgnoreCase("")) {
//					JOptionPane.showMessageDialog(null, "Ingrese Todos los Campos");
//				}else {
//					Proceso proceso= lista.obtenerProceso(comboBoxNombreProceso.getText());
//					String buscar= text_Buscar3.getText();
//					
//					tarea = buscarTareasViewController.buscarTareaActual(proceso, buscar);
//					
//					txtDescripcion.setText(tarea.getDescripcion());
//					txtObligatorio.setText(String.valueOf(tarea.getEsObligatorio()));
//					txtMinimo.setText((String.valueOf(tarea.getTiempoMin())));
//					txtMaximo.setText((String.valueOf(tarea.getTiempoMax())));
//					
//				}
				Tarea tarea;
				String nombreProceso = comboBoxNombreProceso.getText();
				String descripcionTarea = comboDescripTarea.getText();
				if(nombreProceso.equalsIgnoreCase("")||descripcionTarea.equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(null, "seleccione un proceso");	
				}else{
					tarea = buscarTareasViewController.buscarTareaActual(descripcionTarea,nombreProceso);
				     if(tarea==null){
				    	 JOptionPane.showMessageDialog(null, "la tarea no existe en el proceso.");
				     }else{
				    	 mostrar(tarea);
				    	 limpiar();
				     }
				}

			}
		});
		btnBuscarActual.setText("Buscar desde actual");
		
		btnBuscarInicio = new Button(grpBuscar, SWT.NONE);
		btnBuscarInicio.setBounds(447, 200, 144, 25);
		btnBuscarInicio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(!(comboBoxNombreProceso.getText().equalsIgnoreCase("") || comboDescripTarea.getText().equalsIgnoreCase(""))){
					Tarea tarea = buscarTareasViewController.buscarTareaInicio(comboBoxNombreProceso.getText(),comboDescripTarea.getText());
					if(tarea!=null){
						mostrar(tarea);
					}else{
						JOptionPane.showMessageDialog(null, "la tarea no existe en el proceso.");
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "eliga un proceso y escriba la descripcion\n de la tarea por favor.");
				}
			}
		});
		btnBuscarInicio.setText("Buscar desde el inicio");
		
		Label lblDescripcionTarea = new Label(grpBuscar, SWT.NONE);
		lblDescripcionTarea.setBounds(322, 121, 93, 15);
		lblDescripcionTarea.setText("Descripcion tarea");
		
		Label lblComoDeseaBuscar = new Label(grpBuscar, SWT.NONE);
		lblComoDeseaBuscar.setBounds(10, 67, 104, 15);
		lblComoDeseaBuscar.setText("Como desea buscar");
		
		Combo comboBoxTipoBusqueda = new Combo(grpBuscar, SWT.NONE);
		comboBoxTipoBusqueda.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(comboBoxTipoBusqueda.getText().equalsIgnoreCase("desde el inicio")){
					//txtDecsripTarea.setEnabled(true);
					comboDescripTarea.setEnabled(true);
					comboBoxNombreActividad.setEnabled(false);
					comboBoxNombreProceso.setEnabled(true);
					btnBuscarActual.setEnabled(false);
					btnBuscarDadoNombre.setEnabled(false);
					btnBuscarInicio.setEnabled(true);
				
					
				}else{
					if(comboBoxTipoBusqueda.getText().equalsIgnoreCase("desde la actividad actual")){
						//txtDecsripTarea.setEnabled(true);
						comboDescripTarea.setEnabled(true);
						comboBoxNombreActividad.setEnabled(false);
						comboBoxNombreProceso.setEnabled(true);
						btnBuscarActual.setEnabled(true);
						btnBuscarDadoNombre.setEnabled(false);
						btnBuscarInicio.setEnabled(false);
						
					}else{
						
						//txtDecsripTarea.setEnabled(true);
						comboDescripTarea.setEnabled(true);
						comboBoxNombreActividad.setEnabled(true);
						comboBoxNombreProceso.setEnabled(true);
						btnBuscarActual.setEnabled(false);
						btnBuscarDadoNombre.setEnabled(true);
						btnBuscarInicio.setEnabled(false);
						
					}
				}
			}
		});
		comboBoxTipoBusqueda.setItems(new String[] {"Desde el inicio", "Desde la actividad actual", "Desde una actividad dado su nombre"});
		comboBoxTipoBusqueda.setBounds(121, 67, 170, 23);
		
		comboDescripTarea = new Combo(grpBuscar, SWT.NONE);
		comboDescripTarea.setBounds(421, 118, 170, 23);
		comboBoxNombreActividad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				nombreActividad = comboBoxNombreActividad.getText();
				cargarDescripcion();
				
			}
		});
		comboBoxNombreProceso.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				nombreProceso = comboBoxNombreProceso.getText();
				cargarNombresActividad();
				if(comboBoxTipoBusqueda.getText().equalsIgnoreCase("Desde la actividad actual")){
					nombreActividad = buscarTareasViewController.obtenerNombreActivadActual(nombreProceso);
					cargarDescripcion();
				}else{
					if(comboBoxTipoBusqueda.getText().equalsIgnoreCase("Desde el inicio")){
					cargarDescripcion2();	
					}
				}
				
				
				
			}
		});
		camposAlIniciar();
	}
	public void cargarNombreProcesosComboBox(){
		
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
	
	public void camposAlIniciar(){
		comboBoxNombreActividad.setEnabled(false);
		comboBoxNombreProceso.setEnabled(false);
		btnBuscarActual.setEnabled(false);
		btnBuscarDadoNombre.setEnabled(false);
		btnBuscarInicio.setEnabled(false);
		txtVeces.setEnabled(false);
		txtVeces.setEditable(false);
	}
	
	public void mostrar(Tarea tarea){
		txtDescripcion.setText(tarea.getDescripcion());
		txtMaximo.setText(tarea.getTiempoMax()+"");
		txtMinimo.setText(tarea.getTiempoMin()+"");
		txtObligatorio.setText(String.valueOf(tarea.getEsObligatorio()));
	}
	
	public void cargarDescripcion(){
		comboDescripTarea.removeAll();
		Proceso p = lista.obtenerProceso(comboBoxNombreProceso.getText());
		Actividad a = p.getConjuntoActividades().buscarActividad(nombreActividad);
		//Tarea t = a.getConjuntoTareas().getInicio().getValorNodo();
		Nodo<Tarea> t = a.getConjuntoTareas().getInicio();
		while(t!=null){
			comboDescripTarea.add(t.getValorNodo().getDescripcion());
			t=t.getSiguiente();
			
		}
	}
	public void cargarDescripcion2(){
		comboDescripTarea.removeAll();
		Proceso p = lista.obtenerProceso(comboBoxNombreProceso.getText());
		NodoDoble<Actividad> act = p.getConjuntoActividades().getCabeza();
		while(act!=null){
			Nodo<Tarea> t = act.getValorNodo().getConjuntoTareas().getInicio();
			while(t!=null){
				comboDescripTarea.add(t.getValorNodo().getDescripcion());
				t=t.getSiguiente();
				
			}
			act=act.getSiguiente();
		}

	}
	
	public void limpiar(){
		//txtDecsripTarea.setText("");
	}
}
