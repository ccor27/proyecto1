package views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;

public class CrearActividadView {

	protected Shell shlCrearActividad;
	private Text txtNombreActividad;
	private Text txtDescripcionActividad;
	private Text txtDescripcionTarea;
	private Text txtTiempoMax;
	private Text txtTiempoMin;

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
		shlCrearActividad.setSize(525, 680);
		shlCrearActividad.setText("Crear actividad\r\n");
		
		Button btnAtras = new Button(shlCrearActividad, SWT.NONE);
		btnAtras.setBounds(223, 606, 75, 25);
		btnAtras.setText("Atras");
		
		Group grpDatosActividad = new Group(shlCrearActividad, SWT.NONE);
		grpDatosActividad.setText("Datos actividad");
		grpDatosActividad.setBounds(24, 23, 456, 254);
		
		Label lblNombre = new Label(grpDatosActividad, SWT.NONE);
		lblNombre.setBounds(48, 43, 55, 15);
		lblNombre.setText("Nombre");
		
		txtNombreActividad = new Text(grpDatosActividad, SWT.BORDER);
		txtNombreActividad.setBounds(138, 40, 168, 21);
		
		Label lblDescripcion = new Label(grpDatosActividad, SWT.NONE);
		lblDescripcion.setBounds(47, 96, 76, 15);
		lblDescripcion.setText("Descripcion");
		
		txtDescripcionActividad = new Text(grpDatosActividad, SWT.BORDER);
		txtDescripcionActividad.setBounds(138, 93, 168, 21);
		
		Label lblObligatoria = new Label(grpDatosActividad, SWT.NONE);
		lblObligatoria.setBounds(47, 149, 76, 15);
		lblObligatoria.setText("Obligatoria");
		
		Button rbtnActividadSi = new Button(grpDatosActividad, SWT.RADIO);
		rbtnActividadSi.setBounds(158, 148, 90, 16);
		rbtnActividadSi.setText("si");
		
		Button rbtnActividadNo = new Button(grpDatosActividad, SWT.RADIO);
		rbtnActividadNo.setBounds(242, 148, 90, 16);
		rbtnActividadNo.setText("no");
		
		Button btnCrearActividad = new Button(grpDatosActividad, SWT.NONE);
		btnCrearActividad.setBounds(64, 212, 100, 25);
		btnCrearActividad.setText("Crear actividad\r\n");
		
		Button btnLimpiarActividad = new Button(grpDatosActividad, SWT.NONE);
		btnLimpiarActividad.setBounds(280, 212, 75, 25);
		btnLimpiarActividad.setText("Limpiar");
		
		Group grpDatosTarea = new Group(shlCrearActividad, SWT.NONE);
		grpDatosTarea.setText("Datos tarea\r\n");
		grpDatosTarea.setBounds(24, 298, 456, 285);
		
		Label lblDescripcion_1 = new Label(grpDatosTarea, SWT.NONE);
		lblDescripcion_1.setBounds(34, 50, 72, 15);
		lblDescripcion_1.setText("Descripcion");
		
		txtDescripcionTarea = new Text(grpDatosTarea, SWT.BORDER);
		txtDescripcionTarea.setBounds(119, 47, 273, 21);
		
		Label lblTiempoMax = new Label(grpDatosTarea, SWT.NONE);
		lblTiempoMax.setBounds(25, 103, 81, 15);
		lblTiempoMax.setText("Tiempo max");
		
		txtTiempoMax = new Text(grpDatosTarea, SWT.BORDER);
		txtTiempoMax.setBounds(119, 100, 273, 21);
		
		Label lblTiempoMin = new Label(grpDatosTarea, SWT.NONE);
		lblTiempoMin.setBounds(31, 150, 84, 15);
		lblTiempoMin.setText("Tiempo min");
		
		txtTiempoMin = new Text(grpDatosTarea, SWT.BORDER);
		txtTiempoMin.setBounds(119, 144, 273, 21);
		
		Label lblObligatorio = new Label(grpDatosTarea, SWT.NONE);
		lblObligatorio.setBounds(34, 194, 72, 15);
		lblObligatorio.setText("Obligatorio");
		
		Button rbtnTareaSi = new Button(grpDatosTarea, SWT.RADIO);
		rbtnTareaSi.setBounds(153, 193, 90, 16);
		rbtnTareaSi.setText("si");
		
		Button rbtnTareaNo = new Button(grpDatosTarea, SWT.RADIO);
		rbtnTareaNo.setBounds(300, 194, 90, 16);
		rbtnTareaNo.setText("no");
		
		Button btnCrearTarea = new Button(grpDatosTarea, SWT.NONE);
		btnCrearTarea.setBounds(89, 250, 100, 25);
		btnCrearTarea.setText("Crear tarea");
		
		Button btnLimpiarTarea = new Button(grpDatosTarea, SWT.NONE);
		btnLimpiarTarea.setBounds(258, 250, 100, 25);
		btnLimpiarTarea.setText("Limpiar");

	}
}
