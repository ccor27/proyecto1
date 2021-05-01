package views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

public class PrincipalView {

	protected Shell shlPrincipal;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PrincipalView window = new PrincipalView();
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
		shlPrincipal.open();
		shlPrincipal.layout();
		while (!shlPrincipal.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPrincipal = new Shell();
		shlPrincipal.setSize(714, 487);
		shlPrincipal.setText("Principal\r\n");
		
		Button btnCrearProceso = new Button(shlPrincipal, SWT.NONE);
		btnCrearProceso.setBounds(129, 138, 149, 25);
		btnCrearProceso.setText("Crear proceso");
		
		Button btnConsultarProceso = new Button(shlPrincipal, SWT.NONE);
		btnConsultarProceso.setBounds(383, 138, 149, 25);
		btnConsultarProceso.setText("Confiurar proceso");
		
		Button btnConsultarTiempoProceso = new Button(shlPrincipal, SWT.NONE);
		btnConsultarTiempoProceso.setBounds(129, 202, 149, 36);
		btnConsultarTiempoProceso.setText("Consultar tiempo proceso");
		
		Button btnBuscarActividad = new Button(shlPrincipal, SWT.NONE);
		btnBuscarActividad.setBounds(383, 208, 149, 25);
		btnBuscarActividad.setText("Buscar actividad");
		
		Button btnBuscarTarea = new Button(shlPrincipal, SWT.NONE);
		btnBuscarTarea.setBounds(129, 271, 149, 25);
		btnBuscarTarea.setText("Buscar Tarea");
		
		Button btnSalir = new Button(shlPrincipal, SWT.NONE);
		btnSalir.setBounds(383, 271, 149, 25);
		btnSalir.setText("Salir");

	}
}
