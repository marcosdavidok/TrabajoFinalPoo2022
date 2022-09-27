package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import vista.VistaPrincipal;

public class ControladorVistaPrincipal implements ActionListener, WindowStateListener {

	private static ControladorVistaPrincipal ControladorVistaPrincipal;
	private VistaPrincipal vistaPrincipal;
	private ControladorConfig controladorC;

	public ControladorVistaPrincipal() {
		super();
		this.setVistaPrincipal(new VistaPrincipal(this));
		this.getVistaPrincipal().setVisible(true);

		this.setControladorC(new ControladorConfig());
		this.getVistaPrincipal().getPanelVistas().add(getControladorC().getVistaC(), 0, 2);
		this.getControladorC().getVistaC().setVisible(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVistaPrincipal().getBtnNuevoConsumo())) {
			getVistaPrincipal().getLblTitulo().setText("NUEVO CONSUMO");
			getControladorC().getVistaC().setVisible(false);
		}

		if (e.getSource().equals(getVistaPrincipal().getBtnProductos())) {
			getVistaPrincipal().getLblTitulo().setText("BEBIDAS");
			getControladorC().getVistaC().setVisible(false);
		}

		if (e.getSource().equals(getVistaPrincipal().getBtnProveedores())) {
			getVistaPrincipal().getLblTitulo().setText("PROVEEDORES");
			getControladorC().getVistaC().setVisible(false);
		}

		if (e.getSource().equals(getVistaPrincipal().getBtnGastos())) {
			getVistaPrincipal().getLblTitulo().setText("GASTOS");
			getControladorC().getVistaC().setVisible(false);
		}

		if (e.getSource().equals(getVistaPrincipal().getBtnConfiguracion())) {
			getVistaPrincipal().getLblTitulo().setText("CONFIGURACIÓN");
			getControladorC().getVistaC().setVisible(true);

		}

	}

	@Override
	public void windowStateChanged(WindowEvent e) {
		if (getVistaPrincipal().getExtendedState() == VistaPrincipal.MAXIMIZED_BOTH) {
			getControladorC().getVistaC().setBounds(0, 0, 1200, 700); // Le puse esto porque todavía no supe como
																		// hacerlo responsive
		}
		if (getVistaPrincipal().getExtendedState() == VistaPrincipal.NORMAL) {
		getControladorC().getVistaC().setBounds(0, 0, 858, 444);
		}
	}

	public static ControladorVistaPrincipal getInstance() {
		return ControladorVistaPrincipal;
	}

	public VistaPrincipal getVistaPrincipal() {
		return vistaPrincipal;
	}

	public void setVistaPrincipal(VistaPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
	}

	public ControladorConfig getControladorC() {
		return controladorC;
	}

	public void setControladorC(ControladorConfig controladorC) {
		this.controladorC = controladorC;
	}

}
