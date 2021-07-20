package views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import controller.ConfigurarProcesoViewController;
import modelo.ListaProceso;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PrincipalView {

	protected Shell shlPrincipal;
	ConfigurarProcesoViewController procesoViewController = new ConfigurarProcesoViewController();
	private ListaProceso lista= procesoViewController.getListaProceso();

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
		btnCrearProceso.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CrearProcesoView procesoView = new CrearProcesoView();
				shlPrincipal.close();
				procesoView.open();
			}
		});
		btnCrearProceso.setBounds(129, 60, 155, 36);
		btnCrearProceso.setText("Crear proceso");
		
		Button btnConfigProceso = new Button(shlPrincipal, SWT.NONE);
		btnConfigProceso.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConfigurarProcesoView c = new ConfigurarProcesoView();
				c.setListaProceso(lista);
				shlPrincipal.close();
				c.open();
			}
		});
		btnConfigProceso.setBounds(383, 60, 149, 36);
		btnConfigProceso.setText("Confiurar proceso");
		
		Button btnConsultarTiempoProceso = new Button(shlPrincipal, SWT.NONE);
		btnConsultarTiempoProceso.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConsultarProcesoView c = new ConsultarProcesoView();
				//c.setListaProceso(lista);
				c.open();
			}
		});
		btnConsultarTiempoProceso.setBounds(129, 132, 155, 36);
		btnConsultarTiempoProceso.setText("Consultar tiempo proceso");
		
		Button btnBuscarActividad = new Button(shlPrincipal, SWT.NONE);
		btnBuscarActividad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BuscarActividadView buscarActividadView = new BuscarActividadView();
				shlPrincipal.close();
				buscarActividadView.open();
				
			}
		});
		btnBuscarActividad.setBounds(383, 138, 149, 30);
		btnBuscarActividad.setText("Buscar actividad");
		
		Button btnBuscarTarea = new Button(shlPrincipal, SWT.NONE);
		btnBuscarTarea.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				BuscarTareasView buscarTareasView = new BuscarTareasView();
				shlPrincipal.close();
				buscarTareasView.open();
			}
		});
		btnBuscarTarea.setBounds(129, 207, 155, 36);
		btnBuscarTarea.setText("Buscar Tarea");
		
		Button btnSalir = new Button(shlPrincipal, SWT.NONE);
		btnSalir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlPrincipal.close();
			}
		});
		btnSalir.setBounds(265, 335, 140, 30);
		btnSalir.setText("Salir");
		
		Button btnTransferirActividades = new Button(shlPrincipal, SWT.NONE);
		btnTransferirActividades.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TransferenciaActividadesView transferenciaActividadesView = new TransferenciaActividadesView();
				shlPrincipal.close();
				transferenciaActividadesView.open();
			}
		});
		btnTransferirActividades.setBounds(383, 213, 149, 30);
		btnTransferirActividades.setText("Transferir actividades");

	}
}
