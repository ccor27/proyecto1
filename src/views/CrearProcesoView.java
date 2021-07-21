package views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;


import controller.ProcesoViewController;
import modelo.ListaProceso;
import modelo.Nodo;
import modelo.Proceso;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;

import javax.swing.JOptionPane;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CrearProcesoView {

	ProcesoViewController procesoViewController = new ProcesoViewController();
	private ListaProceso lista= procesoViewController.getListaProceso();
	protected Shell shlCrearProceso;
	private Text txtId;
	private Text txtNombre;
	private Table tblProcesos;
	
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CrearProcesoView window = new CrearProcesoView();
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
		shlCrearProceso.open();
		shlCrearProceso.layout();
		cargarDatosTablaProceso();
		while (!shlCrearProceso.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCrearProceso = new Shell();

		shlCrearProceso.setSize(619, 429);
		shlCrearProceso.setText("Crear Proceso ");
		
		Group grpProceso = new Group(shlCrearProceso, SWT.NONE);
		grpProceso.setText("Proceso");
		grpProceso.setBounds(23, 10, 570, 75);
		
		Label lblId = new Label(grpProceso, SWT.NONE);
		lblId.setBounds(10, 23, 33, 15);
		lblId.setText("Id:");
		
		Label lblNombre = new Label(grpProceso, SWT.NONE);
		lblNombre.setBounds(182, 23, 55, 15);
		lblNombre.setText("Nombre:");
		
		txtId = new Text(grpProceso, SWT.BORDER);
		txtId.setBounds(49, 20, 82, 21);
		
		txtNombre = new Text(grpProceso, SWT.BORDER);
		txtNombre.setBounds(243, 20, 114, 21);
		
		Button btnCrear = new Button(grpProceso, SWT.NONE);
		btnCrear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                
				if(!camposVacios()){

					if(!existenciaProceso()){
						int id= Integer.parseInt(txtId.getText());
						String nombre = txtNombre.getText();
						
						procesoViewController.crearProceso(id,nombre);
						cargarDatosTablaProceso();
						limpiarCampos();
						JOptionPane.showMessageDialog(null, "proceso creado con exito.");
					}else{
						JOptionPane.showMessageDialog(null, "no puede repetir nombres o Id de los procesos.");
					}
				}else{
					JOptionPane.showMessageDialog(null, "debe llenar todos los campos");
				}
			}

			private boolean existenciaProceso(){
				Nodo<Proceso> p = lista.getInicio();
				boolean centinela = false;
				while (p!=null) {
					if(p.getValorNodo().getNombre().equalsIgnoreCase(txtNombre.getText()) || p.getValorNodo().getId()==Integer.parseInt(txtId.getText())){
						centinela = true;
						break;
					}
					p=p.getSiguiente();
				}
				return centinela;
			}
		});
		btnCrear.setBounds(441, 18, 75, 25);
		btnCrear.setText("Crear");
		
		Group grpListaProcesos = new Group(shlCrearProceso, SWT.NONE);
		grpListaProcesos.setText("Lista Procesos");
		grpListaProcesos.setBounds(23, 105, 570, 223);
		
		tblProcesos = new Table(grpListaProcesos, SWT.BORDER | SWT.FULL_SELECTION);
		tblProcesos.setBounds(10, 25, 550, 188);
		tblProcesos.setHeaderVisible(true);
		tblProcesos.setLinesVisible(true);
		
		TableColumn tblclmnId = new TableColumn(tblProcesos, SWT.NONE);
		tblclmnId.setWidth(100);
		tblclmnId.setText("Id");
		
		TableColumn tblclmnNombre = new TableColumn(tblProcesos, SWT.NONE);
		tblclmnNombre.setWidth(247);
		tblclmnNombre.setText("Nombre");
		
		TableColumn tblclmnNewColumn = new TableColumn(tblProcesos, SWT.NONE);
		tblclmnNewColumn.setWidth(200);
		tblclmnNewColumn.setText("Tiempo");
		
		Button btnAtras = new Button(shlCrearProceso, SWT.NONE);
		btnAtras.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PrincipalView principalView = new PrincipalView();
				shlCrearProceso.close();
				principalView.open();
			}
		});
		btnAtras.setBounds(502, 355, 75, 25);
		btnAtras.setText("Atras");

	}
	
	public void cargarDatosTablaProceso(){
		tblProcesos.removeAll();
		Nodo<Proceso> puntero = lista.getInicio();
		while(puntero!=null){
			
			TableItem item = new TableItem(tblProcesos, SWT.NONE);
			item.setText(new String[] {String.valueOf(puntero.getValorNodo().getId()),puntero.getValorNodo().getNombre(),
					String.valueOf(puntero.getValorNodo().getTiempo())});
			puntero=puntero.getSiguiente();
		}
	}
	public void limpiarCampos(){
		txtId.setText("");
		txtNombre.setText("");
	}
	public boolean camposVacios(){
		if(txtId.getText().equalsIgnoreCase("")||txtNombre.getText().equalsIgnoreCase("")){
			return true;
		}else{
			return false;
		}
	}
}
