package views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

import java.awt.TextArea;

import javax.swing.JTextArea;

public class BuscarActividadView {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private JTextArea textarea1;
	private Text text_4;

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
		lblSeleccionarProceso.setBounds(10, 32, 138, 15);
		lblSeleccionarProceso.setText("Seleccionar Proceso:");
		
		ComboViewer comboViewer = new ComboViewer(grpProceso, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		combo.setBounds(165, 32, 176, 23);
		
		Group grpActividad = new Group(shell, SWT.NONE);
		grpActividad.setText("Actividad");
		grpActividad.setBounds(10, 100, 592, 356);
		
		Label lblIngreseElNombre = new Label(grpActividad, SWT.NONE);
		lblIngreseElNombre.setBounds(25, 32, 110, 15);
		lblIngreseElNombre.setText("Ingrese el Nombre:");
		
		text = new Text(grpActividad, SWT.BORDER);
		text.setBounds(134, 29, 158, 21);
		
		Button btnBuscar = new Button(grpActividad, SWT.NONE);
		btnBuscar.setBounds(409, 27, 119, 25);
		btnBuscar.setText("Buscar");
		
		Label lblDescripcion = new Label(grpActividad, SWT.NONE);
		lblDescripcion.setBounds(25, 85, 84, 15);
		lblDescripcion.setText("Descripcion:");
		
		text_1 = new Text(grpActividad, SWT.BORDER | SWT.V_SCROLL);
		text_1.setEditable(false);
		text_1.setEnabled(false);
		text_1.setBounds(134, 67, 199, 58);
		
		Label lblObligatorio = new Label(grpActividad, SWT.NONE);
		lblObligatorio.setBounds(329, 143, 75, 15);
		lblObligatorio.setText("Obligatorio: ");
		
		text_2 = new Text(grpActividad, SWT.BORDER);
		text_2.setEditable(false);
		text_2.setEnabled(false);
		text_2.setBounds(409, 140, 119, 21);
		
		Label lblTiempo = new Label(grpActividad, SWT.NONE);
		lblTiempo.setBounds(25, 143, 68, 15);
		lblTiempo.setText("Tiempo: ");
		
		text_3 = new Text(grpActividad, SWT.BORDER);
		text_3.setEnabled(false);
		text_3.setEditable(false);
		text_3.setBounds(134, 140, 158, 21);
		
		text_4 = new Text(grpActividad, SWT.BORDER | SWT.V_SCROLL);
		text_4.setEnabled(false);
		text_4.setEditable(false);
		text_4.setBounds(10, 186, 572, 146);
		
		Button btnAtras = new Button(shell, SWT.NONE);
		btnAtras.setBounds(501, 462, 75, 25);
		btnAtras.setText("Atras");
		
		
		
		

	}
}
