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
import org.eclipse.jface.viewers.ComboViewer;

public class CrearActividadYTareaView {

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
	private Text txtPosicionTarea;
	private CrearActividadViewController crearActividadViewController = new CrearActividadViewController();
	
	private ListaProceso lista= crearActividadViewController.getListaProceso();
	private Combo comboBoxNombrePrecedida;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CrearActividadYTareaView window = new CrearActividadYTareaView();
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
		shlCrearActividad.setSize(1024, 519);
		shlCrearActividad.setText("Crear actividad y/o tarea\r\n");
		
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
		grpDatosActividad.setBounds(10, 10, 486, 393);
		
		Label lblNombre = new Label(grpDatosActividad, SWT.NONE);
		lblNombre.setBounds(50, 100, 55, 15);
		lblNombre.setText("Nombre");
		
		txtNombreActividad = new Text(grpDatosActividad, SWT.BORDER);
		txtNombreActividad.setBounds(205, 97, 205, 21);
		
		Label lblDescripcion = new Label(grpDatosActividad, SWT.NONE);
		lblDescripcion.setBounds(48, 221, 76, 15);
		lblDescripcion.setText("Descripcion");
		
		txtDescripcionActividad = new Text(grpDatosActividad, SWT.BORDER);
		txtDescripcionActividad.setBounds(205, 218, 205, 21);
		
		Label lblObligatoria = new Label(grpDatosActividad, SWT.NONE);
		lblObligatoria.setBounds(48, 282, 76, 15);
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
		rbtnActividadSi.setBounds(208, 281, 90, 16);
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
		rbtnActividadNo.setBounds(320, 281, 90, 16);
		rbtnActividadNo.setText("no");
		
		Button btnLimpiarActividad = new Button(grpDatosActividad, SWT.NONE);
		btnLimpiarActividad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				limpiarCamposActividad();
			}
		});
		btnLimpiarActividad.setBounds(279, 345, 100, 25);
		btnLimpiarActividad.setText("Limpiar");
		
		Label lblNombreActividadPrecedida = new Label(grpDatosActividad, SWT.NONE);
		lblNombreActividadPrecedida.setBounds(48, 160, 151, 15);
		lblNombreActividadPrecedida.setText("Nombre actividad precedida");
		
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
					comboBoxNombrePrecedida.setEnabled(true);
					cargarNombreActividad();
					//txtNombreActivPrecedida.setEnabled(true);
				}else{
					comboBoxNombrePrecedida.setEnabled(false);
					//txtNombreActivPrecedida.setEnabled(false);
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
	        			String nombreActividadPrecede = comboBoxNombrePrecedida.getText();
	        			if(rbtnActividadSi.getSelection()){
	        				
	        				
	        				if(crearActividadViewController.crearActividadPosicionDeterminada(nombreProceso, nombreActividadPrecede, nombre,descripcion, true)){
	        					JOptionPane.showMessageDialog(null, "Actividad creada con exito.");		
	        				}else{
	        					JOptionPane.showMessageDialog(null, "Accion invalida\nactividades con el mismo nombre, la actividad no existe o el proceso no existe.");
	        				}
	        			}else{
	        				
	        				if(crearActividadViewController.crearActividadPosicionDeterminada(nombreProceso, nombreActividadPrecede, nombre,descripcion, false)){
	        					JOptionPane.showMessageDialog(null, "Actividad creada con exito.");		
	        				}else{
	        					JOptionPane.showMessageDialog(null, "Accion invalida\nactividades con el mismo nombre, la actividad no existe o el proceso no existe.");
	        				}

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
                				
                				if(crearActividadViewController.crearActividadFin(nombreProceso, nombre,descripcion,true)){
                					JOptionPane.showMessageDialog(null, "Actividad creada con exito.");		
                				}else{
                					JOptionPane.showMessageDialog(null, "Accion invalida\nactividades con el mismo nombre o el proceso no existe.");
                				}

                			}else{
                				
                				if(crearActividadViewController.crearActividadFin(nombreProceso, nombre,descripcion,false)){
                					JOptionPane.showMessageDialog(null, "Actividad creada con exito.");		
                				}else{
                					JOptionPane.showMessageDialog(null, "Accion invalida\nactividades con el mismo nombre o el proceso no existe.");
                				}

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
                				
                    			if(crearActividadViewController. crearDespuesUltimaActividadCreada(nombreProceso,nombre,descripcion,true)){
                    				JOptionPane.showMessageDialog(null, "Actividad creada con exito.");		
                    			}else{
                    				JOptionPane.showMessageDialog(null, "Accion invalida\n actividades con el mismo nombre, aun no se crean actividades o el proceso no existe.");
                    			}

                			}else{
                				
                    			if(crearActividadViewController. crearDespuesUltimaActividadCreada(nombreProceso,nombre,descripcion,false)){
                    				JOptionPane.showMessageDialog(null, "Actividad creada con exito.");		
                    			}else{
                    				JOptionPane.showMessageDialog(null, "Accion invalida\n actividades con el mismo nombre, aun no se crean actividades o el proceso no existe.");
                    			}

                			}
                			
                			
                		}else{
                			JOptionPane.showMessageDialog(null, "debe llenar todos los campos");
                		}
                		
                    	
                    }
	    		}
	    		cargarNombresCombo();
	    		limpiarCamposActividad();
	    	}
	    });
		btnCrearActividad.setBounds(134, 345, 100, 25);
		btnCrearActividad.setText("Crear");
		btnCrearActividad.setEnabled(false);
		
		comboBoxNombrePrecedida = new Combo(grpDatosActividad, SWT.NONE);
		comboBoxNombrePrecedida.setBounds(207, 160, 203, 23);
		
		Group grpDatosTarea = new Group(shlCrearActividad, SWT.NONE);
		grpDatosTarea.setText("Datos tarea\r\n");
		grpDatosTarea.setBounds(512, 10, 486, 393);
		
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
		
		comboBoxNombreActividad = new Combo(grpDatosTarea, SWT.NONE);
		comboBoxNombreActividad.setBounds(206, 76, 205, 23);
		
	    btnCrearTarea= new Button(grpDatosTarea, SWT.NONE);
	    btnCrearTarea.addSelectionListener(new SelectionAdapter() {
	    	@Override
	    	public void widgetSelected(SelectionEvent e) {
	    		
	    		if(comboBoxTipoCreacionTarea.getText().equalsIgnoreCase("crear posicion determinada")){
	    			
	    			if(!(comboBoxNombreActividad.getText().equalsIgnoreCase(""))){
                          
	    				if(!camposVaciosTarea2()){

	    					if(rbtnTareaSi.getSelection()){

	   
	    						if( crearActividadViewController.crearTareaPosDeterminada(nombreProceso,comboBoxNombreActividad.getText()
	    								,Integer.parseInt(txtPosicionTarea.getText().trim()),txtDescripcionTarea.getText(),true,Integer.parseInt(txtTiempoMax.getText().trim())
	    								,Integer.parseInt(txtTiempoMin.getText().trim()))  ) {
	    							
	    							JOptionPane.showMessageDialog(null, "tarea creada con exito.");
	    							
	    						}else{
	    							JOptionPane.showMessageDialog(null, "Accion invalida\n tareas No obligatorias seguidas, actividad no existe o el proceso no existe.");
	    						}
				    			limpiarCamposTarea();
	    					}else{
	    						if( crearActividadViewController.crearTareaPosDeterminada(nombreProceso,comboBoxNombreActividad.getText()
	    								,Integer.parseInt(txtPosicionTarea.getText().trim()),txtDescripcionTarea.getText(),false,Integer.parseInt(txtTiempoMax.getText().trim())
	    								,Integer.parseInt(txtTiempoMin.getText().trim()))  ) {
	    							
	    							JOptionPane.showMessageDialog(null, "tarea creada con exito.");
	    							
	    						}else{
	    							JOptionPane.showMessageDialog(null, "Accion invalida\n tareas No obligatorias seguidas, actividad no existe o el proceso no existe.");
	    						}
				    			limpiarCamposTarea();

	    					}
	    					
	    					
	    						
	    				}else{
	    					JOptionPane.showMessageDialog(null, "debe llenar todos los campos");
	    					
	    				}
		    			
	    			}else{
	    				JOptionPane.showMessageDialog(null, "debe seleccionar una actividad");
	    				
	    			}
	    			
	    		}else{
	    			//se crea al final
	    			if(!comboBoxNombreActividad.getText().equalsIgnoreCase("")){
	    			
    				if(!camposVaciosTarea1()){

    					if(rbtnTareaSi.getSelection()){

    						if( crearActividadViewController.creaeTareaFin(nombreProceso,comboBoxNombreActividad.getText()
    								,txtDescripcionTarea.getText(),true,Integer.parseInt(txtTiempoMax.getText().trim())
    								,Integer.parseInt(txtTiempoMin.getText().trim()) ) ){
    					
    							JOptionPane.showMessageDialog(null, "tarea creada con exito.");
    							
    						}else{
    							JOptionPane.showMessageDialog(null, "Accion invalida\n tareas No obligatorias seguidas, actividad no existe o el proceso no existe.");
    						}
			    			limpiarCamposTarea();
    					}else{
     						if( crearActividadViewController.creaeTareaFin(nombreProceso,comboBoxNombreActividad.getText()
    								,txtDescripcionTarea.getText(),false,Integer.parseInt(txtTiempoMax.getText().trim())
    								,Integer.parseInt(txtTiempoMin.getText().trim()) ) ){
    					
    							JOptionPane.showMessageDialog(null, "tarea creada con exito.");
    							
    						}else{
    							JOptionPane.showMessageDialog(null, "Accion invalida\n tareas No obligatorias seguidas, actividad no existe o el proceso no existe.");
    						}
			    			limpiarCamposTarea();

    					}
    					
    				}else{
    					JOptionPane.showMessageDialog(null, "debe llenar todos los campos");
   
    				}
	    			}else{
	    				JOptionPane.showMessageDialog(null, "debe seleccionar una actividad");
	    				
	    			}
	    		}
	    	}
	    });
		btnCrearTarea.setBounds(110, 348, 100, 25);
		btnCrearTarea.setText("Crear ");
		btnCrearTarea.setEnabled(false);
		
		Button btnLimpiarTarea = new Button(grpDatosTarea, SWT.NONE);
		btnLimpiarTarea.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				limpiarCamposTarea();
			}
		});
		btnLimpiarTarea.setBounds(306, 348, 100, 25);
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
		
		Button btnAtras_1 = new Button(shlCrearActividad, SWT.NONE);
		btnAtras_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConfigurarProcesoView configurarProcesoView = new ConfigurarProcesoView();
				shlCrearActividad.close();
				configurarProcesoView.open();
			}
		});
		btnAtras_1.setBounds(455, 429, 100, 25);
		btnAtras_1.setText("Atras");
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
		//comboBoxNombreActividad.removeAll();
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
		if(txtNombreActividad.getText().equalsIgnoreCase("") || txtDescripcionActividad.getText().equalsIgnoreCase("") || comboBoxNombrePrecedida.getText().equalsIgnoreCase("")){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean camposVaciosTarea(){
		
		if(comboBoxNombreActividad.getText().equalsIgnoreCase("") || txtDescripcionActividad.getText().equalsIgnoreCase("") || 
				txtTiempoMax.getText().equalsIgnoreCase("") || txtTiempoMin.getText().equalsIgnoreCase("") || txtPosicionTarea.getText().equalsIgnoreCase("")){
			return true;
		}else{
		return false;
		}
	}
	
	public void cargarNombreActividad(){
		comboBoxNombrePrecedida.removeAll();
		Proceso p = lista.obtenerProceso(nombreProceso);
		NodoDoble<Actividad> puntero = p.getConjuntoActividades().getCabeza();
		while(puntero!=null){
			comboBoxNombrePrecedida.add(puntero.getValorNodo().getNombre());
			puntero=puntero.getSiguiente();
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
		//txtNombreActivPrecedida.setText("");
		rbtnActividadNo.setSelection(false);
		rbtnActividadSi.setSelection(false);
	}
}
