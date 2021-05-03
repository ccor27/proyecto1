package views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import controller.ConfigurarProcesoViewController;
import controller.CrearActividadViewController;
import modelo.Actividad;
import modelo.ListaProceso;
import modelo.Nodo;
import modelo.NodoDoble;
import modelo.Proceso;
import modelo.Tarea;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CrearActividadView {

	protected Shell shlCrearActividad;
	private Text txtNombreActividad;
	private Text txtDescripcionActividad;
	private Text txtDescripcionTarea;
	private Text txtTiempoMax;
	private Text txtTiempoMin;
	private Button btnCrearTarea;
	private Button btnCrearActividad;
	private Button rbtnActividadSi;
	private Button rbtnActividadNo;
	private Combo comboBoxNombreActividad;
	private Combo comboBoxTipoCreacionActividad;
	private Combo comboBoxTipoCreacionTarea;
	private Button rbtnTareaSi;
	private Button rbtnTareaNo;

	private String nombreProceso;
	private Text txtNombreActivPrecedida;
	private Text txtPosicionTarea;
	private CrearActividadViewController crearActividadViewController = new CrearActividadViewController();
	
	private ListaProceso lista= crearActividadViewController.getListaProceso();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CrearActividadView window = new CrearActividadView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setValores(String nombreProceso, ListaProceso lista){
		this.lista=lista;
		this.nombreProceso=nombreProceso;
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlCrearActividad.open();
		shlCrearActividad.layout();
		while (!shlCrearActividad.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		shlCrearActividad = new Shell();
		shlCrearActividad.setSize(640, 855);
		shlCrearActividad.setText("Crear actividad\r\n");
		
		Button btnAtras = new Button(shlCrearActividad, SWT.NONE);
		btnAtras.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConfigurarProcesoView configurarProcesoView = new ConfigurarProcesoView();
				shlCrearActividad.close();
				configurarProcesoView.open();
			}
		});
		btnAtras.setBounds(284, 781, 75, 25);
		btnAtras.setText("Atras");
		
		Group grpDatosActividad = new Group(shlCrearActividad, SWT.NONE);
		grpDatosActividad.setText("Datos actividad");
		grpDatosActividad.setBounds(24, 23, 578, 311);
		
		Label lblNombre = new Label(grpDatosActividad, SWT.NONE);
		lblNombre.setBounds(48, 83, 55, 15);
		lblNombre.setText("Nombre");
		
		txtNombreActividad = new Text(grpDatosActividad, SWT.BORDER);
		txtNombreActividad.setBounds(205, 80, 205, 21);
		
		Label lblDescripcion = new Label(grpDatosActividad, SWT.NONE);
		lblDescripcion.setBounds(48, 170, 76, 15);
		lblDescripcion.setText("Descripcion");
		
		txtDescripcionActividad = new Text(grpDatosActividad, SWT.BORDER);
		txtDescripcionActividad.setBounds(205, 167, 205, 21);
		
		Label lblObligatoria = new Label(grpDatosActividad, SWT.NONE);
		lblObligatoria.setBounds(48, 222, 76, 15);
		lblObligatoria.setText("Obligatoria");
		
		rbtnActividadSi = new Button(grpDatosActividad, SWT.RADIO);
		rbtnActividadSi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(rbtnActividadSi.getSelection()){
					rbtnActividadNo.setSelection(false);
				}
			}
		});
		rbtnActividadSi.setBounds(209, 221, 90, 16);
		rbtnActividadSi.setText("si");
		
		
		rbtnActividadNo= new Button(grpDatosActividad, SWT.RADIO);
		rbtnActividadNo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(rbtnActividadNo.getSelection()){
					rbtnActividadSi.setSelection(false);
				}
			}
		});
		rbtnActividadNo.setBounds(359, 221, 90, 16);
		rbtnActividadNo.setText("no");
		
		Button btnLimpiarActividad = new Button(grpDatosActividad, SWT.NONE);
		btnLimpiarActividad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				limpiarCamposActividad();
			}
		});
		btnLimpiarActividad.setBounds(349, 270, 100, 25);
		btnLimpiarActividad.setText("Limpiar");
		
		Label lblNombreActividadPrecedida = new Label(grpDatosActividad, SWT.NONE);
		lblNombreActividadPrecedida.setBounds(48, 129, 151, 15);
		lblNombreActividadPrecedida.setText("Nombre actividad precedida");
		
		txtNombreActivPrecedida = new Text(grpDatosActividad, SWT.BORDER);
		txtNombreActivPrecedida.setBounds(205, 126, 205, 21);
		txtNombreActivPrecedida.setEnabled(false);
		
		Label lblTipoDeCreacion = new Label(grpDatosActividad, SWT.NONE);
		lblTipoDeCreacion.setBounds(48, 32, 110, 15);
		lblTipoDeCreacion.setText("Tipo de creacion");
		
		comboBoxTipoCreacionActividad= new Combo(grpDatosActividad, SWT.NONE);
		comboBoxTipoCreacionActividad.setBounds(204, 32, 206, 23);
		comboBoxTipoCreacionActividad.add("crear al final");
		comboBoxTipoCreacionActividad.add("crear dado el nombre de la actividad que la precederá");
		comboBoxTipoCreacionActividad.add("después de la última actividad creada");
		comboBoxTipoCreacionActividad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String opcion = comboBoxTipoCreacionActividad.getText();

				if(opcion.equalsIgnoreCase("crear dado el nombre de la actividad que la precederá")){
					txtNombreActivPrecedida.setEnabled(true);
				}else{
					txtNombreActivPrecedida.setEnabled(false);
				}
				btnCrearActividad.setEnabled(true);
			}
		});
		

		
	    btnCrearActividad = new Button(grpDatosActividad, SWT.NONE);
	    btnCrearActividad.addSelectionListener(new SelectionAdapter() {
	    	@Override
	    	public void widgetSelected(SelectionEvent e) {
	    		
	    		if(comboBoxTipoCreacionActividad.getText().equalsIgnoreCase("crear dado el nombre de la actividad que la precederá")){
	    		  

	    			if(!camposVaciosActividad2()){
	        			String nombre = txtNombreActividad.getText();
	        			String descripcion = txtDescripcionActividad.getText();
	        			String nombreActividadPrecede = txtNombreActivPrecedida.getText();
	        			if(rbtnActividadSi.getSelection()){
	        				crearActividadViewController.crearActividadPosicionDeterminada(nombreProceso, nombreActividadPrecede, nombre,descripcion, true);
	        				cargarNombresCombo();
	        				limpiarCamposActividad();
	        			}else{
	        				crearActividadViewController.crearActividadPosicionDeterminada(nombreProceso, nombreActividadPrecede, nombre,descripcion, false);
	        				cargarNombresCombo();
	        				limpiarCamposActividad();
	        			}
	    			}else{
	    				JOptionPane.showMessageDialog(null, "debe llenar todos los campos");
	    			}
	    			
	    		}else{
	    			
                    if(comboBoxTipoCreacionActividad.getText().equalsIgnoreCase("crear al final")){
                		if(!camposVaciosActividad1()){
                			
                			String nombre = txtNombreActividad.getText();
                			String descripcion = txtDescripcionActividad.getText();
                			if(rbtnActividadSi.getSelection()){
                				 crearActividadViewController.crearActividadFin( nombreProceso, nombre,descripcion, true);
                				 cargarNombresCombo();
                				 limpiarCamposActividad();
                			}else{
                				crearActividadViewController.crearActividadFin(nombreProceso, nombre,descripcion,false);
                				cargarNombresCombo();
                				limpiarCamposActividad();
                			}
                			
                		}else{
                			JOptionPane.showMessageDialog(null, "debe llenar todos los campos");
                		}
                		
                    }else{
                    	//se crea despues de la ultima actividad creada
                		if(!camposVaciosActividad1()){
                	
                			String nombre = txtNombreActividad.getText();
                			String descripcion = txtDescripcionActividad.getText();
                			
                			if(rbtnActividadSi.getSelection()){
                    			crearActividadViewController. crearDespuesUltimaActividadCreada(nombreProceso,nombre,descripcion,true);
                    			cargarNombresCombo();
                    			limpiarCamposActividad();
                			}else{
                				crearActividadViewController. crearDespuesUltimaActividadCreada(nombreProceso,nombre,descripcion,false);
                				cargarNombresCombo();
                				limpiarCamposActividad();
                			}
                		
                			
                		}else{
                			JOptionPane.showMessageDialog(null, "debe llenar todos los campos");
                		}
                		
                    	
                    }
	    		}
	    	}
	    });
		btnCrearActividad.setBounds(136, 270, 100, 25);
		btnCrearActividad.setText("Crear");
		btnCrearActividad.setEnabled(false);
		
		Group grpDatosTarea = new Group(shlCrearActividad, SWT.NONE);
		grpDatosTarea.setText("Datos tarea\r\n");
		grpDatosTarea.setBounds(24, 358, 578, 417);
		
		Label lblDescripcion_1 = new Label(grpDatosTarea, SWT.NONE);
		lblDescripcion_1.setBounds(51, 128, 72, 15);
		lblDescripcion_1.setText("Descripcion");
		
		txtDescripcionTarea = new Text(grpDatosTarea, SWT.BORDER);
		txtDescripcionTarea.setBounds(206, 125, 205, 21);
		
		Label lblTiempoMax = new Label(grpDatosTarea, SWT.NONE);
		lblTiempoMax.setBounds(51, 173, 81, 15);
		lblTiempoMax.setText("Tiempo max");
		
		txtTiempoMax = new Text(grpDatosTarea, SWT.BORDER);
		txtTiempoMax.setBounds(206, 170, 205, 21);
		
		Label lblTiempoMin = new Label(grpDatosTarea, SWT.NONE);
		lblTiempoMin.setBounds(51, 222, 84, 15);
		lblTiempoMin.setText("Tiempo min");
		
		txtTiempoMin = new Text(grpDatosTarea, SWT.BORDER);
		txtTiempoMin.setBounds(206, 219, 205, 21);
		
		Label lblObligatorio = new Label(grpDatosTarea, SWT.NONE);
		lblObligatorio.setBounds(51, 306, 72, 15);
		lblObligatorio.setText("Obligatorio");
		
		rbtnTareaSi= new Button(grpDatosTarea, SWT.RADIO);
		rbtnTareaSi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(rbtnTareaSi.getSelection()){
					rbtnTareaNo.setSelection(false);
				}
			}
		});
		rbtnTareaSi.setBounds(206, 305, 90, 16);
		rbtnTareaSi.setText("si");
		
		rbtnTareaNo= new Button(grpDatosTarea, SWT.RADIO);
		rbtnTareaNo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(rbtnTareaNo.getSelection()){
					rbtnTareaSi.setSelection(false);
				}
			}
		});
		rbtnTareaNo.setBounds(332, 305, 90, 16);
		rbtnTareaNo.setText("no");
		
	    btnCrearTarea= new Button(grpDatosTarea, SWT.NONE);
	    btnCrearTarea.addSelectionListener(new SelectionAdapter() {
	    	@Override
	    	public void widgetSelected(SelectionEvent e) {
	    		
	    		if(comboBoxTipoCreacionTarea.getText().equalsIgnoreCase("crear posicion determinada")){
	    			
	    			if(!comboBoxNombreActividad.getText().equalsIgnoreCase("")){
                          
	    				if(camposVaciosActividad2()){

	    					if(rbtnTareaSi.getSelection()){
			    				Proceso p = lista.obtenerProceso(nombreProceso);
			    				String nombreActividad = comboBoxNombreActividad.getText();
				    			Actividad act = p.getConjuntoActividades().buscarActividad(nombreActividad);
				    			int pos = Integer.parseInt(txtPosicionTarea.getText().trim());
				    			String descripcion = txtDescripcionTarea.getText();
				    			int tiempoMin = Integer.parseInt(txtTiempoMin.getText().trim());
				    			int tiempoMax = Integer.parseInt(txtTiempoMax.getText().trim());
				    			Tarea tarea = new Tarea(descripcion, true, tiempoMax, tiempoMin);
				    			act.getConjuntoTareas().insertarPosDeterminada(tarea, pos);
				    			limpiarCamposTarea();
	    					}else{
			    				Proceso p = lista.obtenerProceso(nombreProceso);
			    				String nombreActividad = comboBoxNombreActividad.getText();
				    			Actividad act = p.getConjuntoActividades().buscarActividad(nombreActividad);
				    			int pos = Integer.parseInt(txtPosicionTarea.getText().trim());
				    			String descripcion = txtDescripcionTarea.getText();
				    			int tiempoMin = Integer.parseInt(txtTiempoMin.getText().trim());
				    			int tiempoMax = Integer.parseInt(txtTiempoMax.getText().trim());
				    			Tarea tarea = new Tarea(descripcion, false, tiempoMax, tiempoMin);
				    			act.getConjuntoTareas().insertarPosDeterminada(tarea, pos);
				    			limpiarCamposTarea();
	    					}
	    						
	    				}else{
	    					System.out.println("debe llenar todos los campos");
	    				}
		    			
	    			}else{
	    				System.out.println("debe seleccionar una actividad");
	    			}
	    			
	    		}else{
	    			if(!comboBoxNombreActividad.getText().equalsIgnoreCase("")){
	    			
    				if(camposVaciosActividad1()){

    					if(rbtnTareaSi.getSelection()){
		    				Proceso p = lista.obtenerProceso(nombreProceso);
		    				String nombreActividad = comboBoxNombreActividad.getText();
			    			Actividad act = p.getConjuntoActividades().buscarActividad(nombreActividad);
			    			String descripcion = txtDescripcionTarea.getText();
			    			int tiempoMin = Integer.parseInt(txtTiempoMin.getText().trim());
			    			int tiempoMax = Integer.parseInt(txtTiempoMax.getText().trim());
			    			Tarea tarea = new Tarea(descripcion, true, tiempoMax, tiempoMin);
			    			act.getConjuntoTareas().insertarFinal(tarea);
			    			limpiarCamposTarea();
    					}else{
		    				Proceso p = lista.obtenerProceso(nombreProceso);
		    				String nombreActividad = comboBoxNombreActividad.getText();
			    			Actividad act = p.getConjuntoActividades().buscarActividad(nombreActividad);
			    			String descripcion = txtDescripcionTarea.getText();
			    			int tiempoMin = Integer.parseInt(txtTiempoMin.getText().trim());
			    			int tiempoMax = Integer.parseInt(txtTiempoMax.getText().trim());
			    			Tarea tarea = new Tarea(descripcion, false, tiempoMax, tiempoMin);
			    			act.getConjuntoTareas().insertarFinal(tarea);
			    			limpiarCamposTarea();
    					}
    						
    				}else{
    					System.out.println("debe llenar todos los campos");
    				}
	    			}else{
	    				System.out.println("debe seleccionar una actividad");
	    			}
	    		}
	    	}
	    });
		btnCrearTarea.setBounds(141, 348, 100, 25);
		btnCrearTarea.setText("Crear ");
		btnCrearTarea.setEnabled(false);
		
		Button btnLimpiarTarea = new Button(grpDatosTarea, SWT.NONE);
		btnLimpiarTarea.setBounds(348, 348, 100, 25);
		btnLimpiarTarea.setText("Limpiar");
		
		txtPosicionTarea = new Text(grpDatosTarea, SWT.BORDER);
		txtPosicionTarea.setBounds(206, 265, 205, 21);
		txtPosicionTarea.setEnabled(false);
		
		Label lblPosicion = new Label(grpDatosTarea, SWT.NONE);
		lblPosicion.setBounds(51, 268, 55, 15);
		lblPosicion.setText("Posicion");
		
		Label lblTipoDeCreacion_1 = new Label(grpDatosTarea, SWT.NONE);
		lblTipoDeCreacion_1.setBounds(53, 33, 100, 15);
		lblTipoDeCreacion_1.setText("Tipo de creacion");
		
		comboBoxTipoCreacionTarea= new Combo(grpDatosTarea, SWT.NONE);
		comboBoxTipoCreacionTarea.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(comboBoxTipoCreacionTarea.getText().equalsIgnoreCase("crear posicion determinada")){
					txtPosicionTarea.setEnabled(true);
				}else{
					txtPosicionTarea.setEnabled(false);
				}
				btnCrearTarea.setEnabled(true);
			}
		});
		comboBoxTipoCreacionTarea.setBounds(206, 30, 205, 23);
		comboBoxTipoCreacionTarea.add("crear al final");
		comboBoxTipoCreacionTarea.add("crear posicion determinada");
		
		
		Label lblActividad = new Label(grpDatosTarea, SWT.NONE);
		lblActividad.setBounds(50, 79, 55, 15);
		lblActividad.setText("Actividad");
		
		comboBoxNombreActividad = new Combo(grpDatosTarea, SWT.NONE);
		comboBoxNombreActividad.setBounds(206, 76, 205, 23);
		cargarNombresCombo();

	}
	
	public boolean camposVaciosTarea1(){
		
		if(txtDescripcionTarea.getText().equalsIgnoreCase("")||txtTiempoMax.getText().equalsIgnoreCase("")||txtTiempoMin.getText().equalsIgnoreCase("")){
			return true;
		}else{
			return false;
		}
	}
	public boolean camposVaciosTarea2(){
		
		if(txtDescripcionTarea.getText().equalsIgnoreCase("")||txtTiempoMax.getText().equalsIgnoreCase("")
		   ||txtTiempoMin.getText().equalsIgnoreCase("")||txtPosicionTarea.getText().equalsIgnoreCase("")){
			return true;
		}else{
			return false;
		}
	}
	
	public void limpiarCamposTarea(){
		comboBoxNombreActividad.removeAll();
		txtDescripcionTarea.setText("");
		txtTiempoMax.setText("");
		txtTiempoMin.setText("");
		txtPosicionTarea.setText("");
		rbtnTareaSi.setSelection(false);
		rbtnTareaNo.setSelection(false);
	}
	//----------------ACTIVIDAD-----------------------
	
	public boolean camposVaciosActividad1(){
		
		if(txtNombreActividad.getText().equalsIgnoreCase("") || txtDescripcionActividad.getText().equalsIgnoreCase("")){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean camposVaciosActividad2(){
		if(txtNombreActividad.getText().equalsIgnoreCase("") || txtDescripcionActividad.getText().equalsIgnoreCase("") || txtNombreActivPrecedida.getText().equalsIgnoreCase("")){
			return true;
		}else{
			return false;
		}
	}
	
	public void cargarNombresCombo(){
		comboBoxNombreActividad.removeAll();
		Proceso p = lista.obtenerProceso(nombreProceso);
		NodoDoble<Actividad> puntero = p.getConjuntoActividades().getCabeza();
		while(puntero!=null){
			comboBoxNombreActividad.add(puntero.getValorNodo().getNombre());
			puntero=puntero.getSiguiente();
		}
		
	}
	
	public void limpiarCamposActividad(){

		txtNombreActividad.setText("");
		txtDescripcionActividad.setText("");
		txtNombreActivPrecedida.setText("");
		rbtnActividadNo.setSelection(false);
		rbtnActividadSi.setSelection(false);
	}
}
