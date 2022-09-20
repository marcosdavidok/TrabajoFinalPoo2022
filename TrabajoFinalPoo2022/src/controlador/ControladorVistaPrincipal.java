package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import vista.VistaPrincipal;

public class ControladorVistaPrincipal implements ActionListener, WindowStateListener {

	private static ControladorVistaPrincipal ControladorVistaPrincipal;
	private VistaPrincipal vistaPrincipal;

	public ControladorVistaPrincipal() {
		super();
		this.setVistaPrincipal(new VistaPrincipal(this));
		this.getVistaPrincipal().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVistaPrincipal().getBtnConfiguracion())) {
			getVistaPrincipal().getLblTitulo().setText("CONFIGURACIÓN");
		}
		if (e.getSource().equals(getVistaPrincipal().getBtnNuevoConsumo())) {
			getVistaPrincipal().getLblTitulo().setText("NUEVO CONSUMO");
		}

		if (e.getSource().equals(getVistaPrincipal().getBtnProveedores())) {
			getVistaPrincipal().getLblTitulo().setText("PROVEEDORES");
		}
		if (e.getSource().equals(getVistaPrincipal().getBtnProductos())) {
			getVistaPrincipal().getLblTitulo().setText("BEBIDAS");
		}
		if (e.getSource().equals(getVistaPrincipal().getBtnGastos())) {
			getVistaPrincipal().getLblTitulo().setText("GASTOS");
		}
	}

	@Override
	public void windowStateChanged(WindowEvent e) {
		if (getVistaPrincipal().getExtendedState() == VistaPrincipal.MAXIMIZED_BOTH) {
		}
		if (getVistaPrincipal().getExtendedState() == VistaPrincipal.NORMAL) {
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

}
