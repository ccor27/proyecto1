package views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Group;

public class BuscarTareasView {

	protected Shell shell;
	private Text text;
	private Table table;
	private Table table_1;

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
		shell.setSize(811, 617);
		shell.setText("SWT Application");
		
		Label lblProcesos = new Label(shell, SWT.NONE);
		lblProcesos.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		lblProcesos.setBounds(10, 10, 68, 19);
		lblProcesos.setText("Procesos");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(10, 35, 170, 23);
		combo.setText("Todos los procesos.");
		
		Group grpActividades = new Group(shell, SWT.NONE);
		grpActividades.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		grpActividades.setText("Actividades");
		grpActividades.setBounds(10, 77, 775, 475);
		
		TableViewer tableViewer = new TableViewer(grpActividades, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setBounds(10, 129, 368, 316);
		
		Button btnBuscar = new Button(grpActividades, SWT.NONE);
		btnBuscar.setBounds(401, 56, 75, 25);
		btnBuscar.setText("Buscar");
		
		text = new Text(grpActividades, SWT.BORDER);
		text.setBounds(10, 58, 300, 21);
		
		Label lblIngreseLaActividad = new Label(grpActividades, SWT.NONE);
		lblIngreseLaActividad.setBounds(10, 36, 231, 15);
		lblIngreseLaActividad.setText("Ingrese el nombre de la actividad a buscar.");
		
		TableViewer tableViewer_1 = new TableViewer(grpActividades, SWT.BORDER | SWT.FULL_SELECTION);
		table_1 = tableViewer_1.getTable();
		table_1.setBounds(419, 129, 346, 311);

	}
}
