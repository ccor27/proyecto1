package views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import controller.ConfigurarProcesoViewController;
import controller.ConsultarProcesoViewController;
import modelo.ListaProceso;
import modelo.Nodo;
import modelo.Proceso;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ConsultarProcesoView {

	protected Shell shell;
	private Text textTiempos;
	private Combo comboBoxConsultaProceso;
	ConsultarProcesoViewController procesoViewController = new ConsultarProcesoViewController();
	private ListaProceso lista= procesoViewController.getListaProceso();
	private String nombreProceso;
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
	public void setListaProceso(ListaProceso lista){
		this.lista=lista;
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
		
		comboBoxConsultaProceso = new Combo(shell, SWT.NONE);
		comboBoxConsultaProceso.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				nombreProceso=comboBoxConsultaProceso.getText();
			}
		});
		comboBoxConsultaProceso.setBounds(10, 64, 143, 23);
		comboBoxConsultaProceso.setText("Seleccione el proceso.");
		cargarDatosComboBox();
		Button btnConsultar = new Button(shell, SWT.NONE);
		btnConsultar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				double tiempoMin=procesoViewController.calcularTiempoMin(nombreProceso);
				double tiempoMax=procesoViewController.calcularTiempoMax(nombreProceso);
				textTiempos.setText("Tiempo Minimo: "+String.valueOf(tiempoMin)+ "\n" +"Tiempo Maximo: "+ String.valueOf(tiempoMax));
				
			}
		});
		btnConsultar.setBounds(246, 64, 75, 25);
		btnConsultar.setText("Consultar");
		
		
		
		textTiempos = new Text(shell, SWT.BORDER | SWT.V_SCROLL);
		textTiempos.setBounds(10, 119, 311, 92);
		textTiempos.setEditable(false);
		//textTiempos.setText("Tiempo minimo:" +'\n'+ "Tiempo maximo: ");
		

	}
	
	/**
	 * Open the window.
	 */

	
	public void cargarDatosComboBox(){
		
		Nodo<Proceso> puntero = lista.getInicio();
		while(puntero!=null){
			comboBoxConsultaProceso.add(puntero.getValorNodo().getNombre());
			puntero=puntero.getSiguiente();
		}
	}
}