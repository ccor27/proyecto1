package views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;

public class ProcesoView {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ProcesoView window = new ProcesoView();
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
		shell.setSize(619, 429);
		shell.setText("SWT Application");
		
		Group grpProceso = new Group(shell, SWT.NONE);
		grpProceso.setText("Proceso");
		grpProceso.setBounds(23, 10, 570, 75);
		
		Label lblId = new Label(grpProceso, SWT.NONE);
		lblId.setBounds(10, 23, 33, 15);
		lblId.setText("Id:");
		
		Label lblNombre = new Label(grpProceso, SWT.NONE);
		lblNombre.setBounds(182, 23, 55, 15);
		lblNombre.setText("Nombre:");
		
		text = new Text(grpProceso, SWT.BORDER);
		text.setBounds(49, 20, 82, 21);
		
		text_1 = new Text(grpProceso, SWT.BORDER);
		text_1.setBounds(243, 20, 114, 21);
		
		Button btnCrear = new Button(grpProceso, SWT.NONE);
		btnCrear.setBounds(441, 18, 75, 25);
		btnCrear.setText("Crear");
		
		Group grpListaProcesos = new Group(shell, SWT.NONE);
		grpListaProcesos.setText("Lista Procesos");
		grpListaProcesos.setBounds(23, 105, 570, 223);
		
		TableViewer tableViewer = new TableViewer(grpListaProcesos, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setBounds(10, 21, 550, 192);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnId = tableViewerColumn.getColumn();
		tblclmnId.setWidth(69);
		tblclmnId.setText("Id");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNombre = tableViewerColumn_1.getColumn();
		tblclmnNombre.setWidth(130);
		tblclmnNombre.setText("Nombre");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTiempo = tableViewerColumn_2.getColumn();
		tblclmnTiempo.setWidth(100);
		tblclmnTiempo.setText("Tiempo");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnActividades = tableViewerColumn_3.getColumn();
		tblclmnActividades.setWidth(223);
		tblclmnActividades.setText("Actividades");
		
		Button btnAtras = new Button(shell, SWT.NONE);
		btnAtras.setBounds(502, 355, 75, 25);
		btnAtras.setText("Atras");

	}
}
