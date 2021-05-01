package views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Button;

public class TransferenciaActividadesView {

	protected Shell shell;
	private Table table;
	private Table table_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TransferenciaActividadesView window = new TransferenciaActividadesView();
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
		shell.setSize(917, 488);
		shell.setText("SWT Application");
		
		Group grpProcesoUno = new Group(shell, SWT.NONE);
		grpProcesoUno.setText("Proceso Uno");
		grpProcesoUno.setBounds(10, 10, 429, 352);
		
		ComboViewer comboViewer = new ComboViewer(grpProcesoUno, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		combo.setBounds(148, 29, 153, 23);
		
		Label lblSeleccionarProceso = new Label(grpProcesoUno, SWT.NONE);
		lblSeleccionarProceso.setBounds(10, 32, 132, 15);
		lblSeleccionarProceso.setText("Seleccionar Proceso:");
		
		TableViewer tableViewer = new TableViewer(grpProcesoUno, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setBounds(10, 78, 409, 264);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNombre = tableViewerColumn.getColumn();
		tblclmnNombre.setWidth(119);
		tblclmnNombre.setText("Nombre");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnDescripcion = tableViewerColumn_1.getColumn();
		tblclmnDescripcion.setWidth(144);
		tblclmnDescripcion.setText("Descripcion");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnObligatorio = tableViewerColumn_2.getColumn();
		tblclmnObligatorio.setWidth(76);
		tblclmnObligatorio.setText("Obligatorio");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTiempo = tableViewerColumn_3.getColumn();
		tblclmnTiempo.setWidth(57);
		tblclmnTiempo.setText("Tiempo");
		
		Group grpProcesoDos = new Group(shell, SWT.NONE);
		grpProcesoDos.setText("Proceso Dos");
		grpProcesoDos.setBounds(466, 10, 429, 352);
		
		Label lblSeleccionarProceso_1 = new Label(grpProcesoDos, SWT.NONE);
		lblSeleccionarProceso_1.setText("Seleccionar Proceso:");
		lblSeleccionarProceso_1.setBounds(10, 32, 132, 15);
		
		ComboViewer comboViewer_1 = new ComboViewer(grpProcesoDos, SWT.NONE);
		Combo combo_1 = comboViewer_1.getCombo();
		combo_1.setBounds(148, 29, 153, 23);
		
		TableViewer tableViewer_1 = new TableViewer(grpProcesoDos, SWT.BORDER | SWT.FULL_SELECTION);
		table_1 = tableViewer_1.getTable();
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);
		table_1.setBounds(10, 78, 409, 264);
		
		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnNombre_1 = tableViewerColumn_4.getColumn();
		tblclmnNombre_1.setWidth(119);
		tblclmnNombre_1.setText("Nombre");
		
		TableViewerColumn tableViewerColumn_1_1 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnDescripcion_1 = tableViewerColumn_1_1.getColumn();
		tblclmnDescripcion_1.setWidth(144);
		tblclmnDescripcion_1.setText("Descripcion");
		
		TableViewerColumn tableViewerColumn_2_1 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnObligatorio_1 = tableViewerColumn_2_1.getColumn();
		tblclmnObligatorio_1.setWidth(76);
		tblclmnObligatorio_1.setText("Obligatorio");
		
		TableViewerColumn tableViewerColumn_3_1 = new TableViewerColumn(tableViewer_1, SWT.NONE);
		TableColumn tblclmnTiempo_1 = tableViewerColumn_3_1.getColumn();
		tblclmnTiempo_1.setWidth(57);
		tblclmnTiempo_1.setText("Tiempo");
		
		Label lblTransferirConTareas = new Label(shell, SWT.NONE);
		lblTransferirConTareas.setBounds(21, 391, 119, 15);
		lblTransferirConTareas.setText("Transferir con tareas:");
		
		Button btnSi = new Button(shell, SWT.RADIO);
		btnSi.setBounds(152, 390, 40, 16);
		btnSi.setText("Si");
		
		Button btnNo = new Button(shell, SWT.RADIO);
		btnNo.setBounds(219, 390, 54, 16);
		btnNo.setText("No");
		
		Button btnTransferir = new Button(shell, SWT.NONE);
		btnTransferir.setBounds(301, 381, 75, 25);
		btnTransferir.setText("Transferir");
		
		Button btnAtras = new Button(shell, SWT.NONE);
		btnAtras.setBounds(804, 399, 75, 25);
		btnAtras.setText("Atras");

	}
}
