package views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class CrearTareaView {

	protected Shell shlCrearTarea;
	private Text txtDescripcion;
	private Text txtTiempoMax;
	private Text txtTiempoMin;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CrearTareaView window = new CrearTareaView();
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
		shlCrearTarea.open();
		shlCrearTarea.layout();
		while (!shlCrearTarea.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCrearTarea = new Shell();
		shlCrearTarea.setSize(470, 548);
		shlCrearTarea.setText("Crear tarea");
		
		Group grpActividadDondeSe = new Group(shlCrearTarea, SWT.NONE);
		grpActividadDondeSe.setText("Actividad donde se va agregar la tarea");
		grpActividadDondeSe.setBounds(10, 42, 430, 106);
		
		Combo comboBoxNombreActivida = new Combo(grpActividadDondeSe, SWT.NONE);
		comboBoxNombreActivida.setBounds(10, 41, 237, 23);
		
		Group grpDatosTarea = new Group(shlCrearTarea, SWT.NONE);
		grpDatosTarea.setText("Datos tarea");
		grpDatosTarea.setBounds(10, 169, 430, 244);
		
		Label lblNewLabel = new Label(grpDatosTarea, SWT.NONE);
		lblNewLabel.setBounds(10, 42, 62, 15);
		lblNewLabel.setText("Descripcion");
		
		txtDescripcion = new Text(grpDatosTarea, SWT.BORDER);
		txtDescripcion.setBounds(93, 36, 263, 21);
		
		Label lblTiempoMax = new Label(grpDatosTarea, SWT.NONE);
		lblTiempoMax.setBounds(10, 94, 77, 15);
		lblTiempoMax.setText("Tiempo max");
		
		Label lblTiempoMin = new Label(grpDatosTarea, SWT.NONE);
		lblTiempoMin.setBounds(10, 143, 77, 15);
		lblTiempoMin.setText("Tiempo min");
		
		Label lblObligatorio = new Label(grpDatosTarea, SWT.NONE);
		lblObligatorio.setBounds(10, 188, 62, 15);
		lblObligatorio.setText("Obligatorio");
		
		txtTiempoMax = new Text(grpDatosTarea, SWT.BORDER);
		txtTiempoMax.setBounds(93, 88, 263, 21);
		
		txtTiempoMin = new Text(grpDatosTarea, SWT.BORDER);
		txtTiempoMin.setBounds(93, 140, 263, 21);
		
		Button rbtnSi = new Button(grpDatosTarea, SWT.RADIO);
		rbtnSi.setBounds(107, 188, 90, 16);
		rbtnSi.setText("si");
		
		Button rbtnNo = new Button(grpDatosTarea, SWT.RADIO);
		rbtnNo.setBounds(255, 188, 90, 16);
		rbtnNo.setText("no");
		
		Button btnCrear = new Button(shlCrearTarea, SWT.NONE);
		btnCrear.setBounds(102, 444, 75, 25);
		btnCrear.setText("Crear");
		
		Button btnAtras = new Button(shlCrearTarea, SWT.NONE);
		btnAtras.setBounds(268, 444, 75, 25);
		btnAtras.setText("Atras");

	}

}
