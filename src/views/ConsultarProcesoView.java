package views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;

public class ConsultarProcesoView {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ConsultarProcesoView window = new ConsultarProcesoView();
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
		shell.setModified(true);
		shell.setSize(408, 282);
		shell.setText("SWT Application");
		
		Label lblConsultarTiempoDe = new Label(shell, SWT.NONE);
		//lblConsultarTiempoDe.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		lblConsultarTiempoDe.setBounds(10, 10, 332, 24);
		lblConsultarTiempoDe.setText("Consultar tiempo de la demora de un proceso.");
		
		Combo combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setBounds(10, 64, 143, 23);
		combo_1.setText("Seleccione el proceso.");
		
		Button btnConsultar = new Button(shell, SWT.NONE);
		btnConsultar.setBounds(246, 64, 75, 25);
		btnConsultar.setText("Consultar");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(10, 119, 311, 92);

	}
}
