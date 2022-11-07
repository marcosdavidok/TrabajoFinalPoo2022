package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import vista.VistaPrincipal;

public class ControladorVistaPrincipal implements ActionListener, WindowStateListener {

	private static ControladorVistaPrincipal ControladorVistaPrincipal;
	private VistaPrincipal vistaPrincipal;
	private ControladorConfig controladorC;
	private ControladorNuevoConsumo controladorNC;
	private ControladorAgregarProducto controladorAP;

	private ControladorProveedores controladorPV;
	private ControladorProductos controladorP;
	private ControladorGastos controladorG;

	public ControladorVistaPrincipal() {
		this.setVistaPrincipal(new VistaPrincipal(this));
		this.getVistaPrincipal().setVisible(true);

		this.setControladorC(new ControladorConfig());
		this.getVistaPrincipal().getPanelVistas().add(getControladorC().getVistaC(), 0, 2);
		this.getControladorC().getVistaC().setVisible(false);

		this.setControladorNC(new ControladorNuevoConsumo());
		this.getVistaPrincipal().getPanelVistas().add(getControladorNC().getVistaNC(), 0, 3);
		this.getControladorNC().getVistaNC().setVisible(false);

		this.setControladorPV(new ControladorProveedores());
		this.getVistaPrincipal().getPanelVistas().add(getControladorPV().getVistaPV(), 0, 4);
		this.getControladorPV().getVistaPV().setVisible(false);

		this.setControladorP(new ControladorProductos());
		this.getVistaPrincipal().getPanelVistas().add(getControladorP().getVistaP(), 0, 5);
		this.getControladorP().getVistaP().setVisible(false);

		this.setControladorG(new ControladorGastos());
		this.getVistaPrincipal().getPanelVistas().add(getControladorG().getVistaGastos(), 0, 6);
		this.getControladorG().getVistaGastos().setVisible(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(getVistaPrincipal().getBtnNuevoConsumo())) {
			getVistaPrincipal().getLblTitulo().setText("NUEVO CONSUMO");
			getControladorNC().getVistaNC().setVisible(true);
			getControladorC().getVistaC().setVisible(false);
			getControladorPV().getVistaPV().setVisible(false);
			getControladorP().getVistaP().setVisible(false);
			getControladorG().getVistaGastos().setVisible(false);
		}

		if (e.getSource().equals(getVistaPrincipal().getBtnProductos())) {
			getVistaPrincipal().getLblTitulo().setText("BEBIDAS");
			getControladorP().getVistaP().setVisible(true);
			getControladorPV().getVistaPV().setVisible(false);
			getControladorNC().getVistaNC().setVisible(false);
			getControladorC().getVistaC().setVisible(false);
			getControladorG().getVistaGastos().setVisible(false);
		}
		if (e.getSource().equals(getVistaPrincipal().getBtnProveedores())) {
			getVistaPrincipal().getLblTitulo().setText("PROVEEDORES");
			getControladorPV().getVistaPV().setVisible(true);
			getControladorNC().getVistaNC().setVisible(false);
			getControladorC().getVistaC().setVisible(false);
			getControladorP().getVistaP().setVisible(false);
			getControladorG().getVistaGastos().setVisible(false);

		}
		if (e.getSource().equals(getVistaPrincipal().getBtnGastos())) {
			getVistaPrincipal().getLblTitulo().setText("GASTOS");
			getControladorG().getVistaGastos().setVisible(true);
			getControladorP().getVistaP().setVisible(false);
			getControladorPV().getVistaPV().setVisible(false);
			getControladorNC().getVistaNC().setVisible(false);
			getControladorC().getVistaC().setVisible(false);

		}
		if (e.getSource().equals(getVistaPrincipal().getBtnConfiguracion())) {
			getVistaPrincipal().getLblTitulo().setText("CONFIGURACIÓN");
			getControladorC().getVistaC().setVisible(true);
			getControladorNC().getVistaNC().setVisible(false);
			getControladorPV().getVistaPV().setVisible(false);
			getControladorP().getVistaP().setVisible(false);
			getControladorG().getVistaGastos().setVisible(false);
		}

		if (e.getSource().equals(getVistaPrincipal().getBtnRegistrarUsuario())) {
			new ControladorVistaNuevoUsuario();
			getControladorC().getVistaC().setVisible(false);
			getControladorNC().getVistaNC().setVisible(false);
			getControladorPV().getVistaPV().setVisible(false);
			getControladorP().getVistaP().setVisible(false);
			getControladorG().getVistaGastos().setVisible(false);
		}

		if (e.getSource().equals(getVistaPrincipal().getBtnLogout())) {
			// CARTEL SI ESTA SEGURO PARA CONFIRMAR
			Object[] opciones = { "Si", "No" };
			Integer res = JOptionPane.showOptionDialog(getVistaPrincipal(), "¿Está seguro que desea cerrar sesión?",
					"Atención", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					this.ajustarImagen(
							new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Logout.png")).getImage(), 44, 44),
					opciones, opciones[0]);

			if (res == 0) {
				getVistaPrincipal().dispose();
				new ControladorVistaInicial();
			}

			/*
			 * if(JOptionPane.showConfirmDialog(getVistaPrincipal(),
			 * "¿Está seguro que desea cerrar sesión?",
			 * "Atención",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			 * getVistaPrincipal().dispose(); new ControladorVistaInicial(); }
			 */
		}

	}

	@Override
	public void windowStateChanged(WindowEvent e) {
		if (getVistaPrincipal().getExtendedState() == VistaPrincipal.MAXIMIZED_BOTH) {
			getControladorC().getVistaC().setBounds(0, 0, 1200, 700);
			getControladorNC().getVistaNC().setBounds(0, 0, 1200, 700);
			getControladorP().getVistaP().setBounds(0, 0, 1200, 700);
			getControladorPV().getVistaPV().setBounds(0, 0, 1200, 700);
			getControladorG().getVistaGastos().setBounds(0, 0, 1200, 700);

		}
		if (getVistaPrincipal().getExtendedState() == VistaPrincipal.NORMAL) {
			getControladorC().getVistaC().setBounds(0, 0, 858, 444);
			getControladorNC().getVistaNC().setBounds(0, 0, 858, 444);
			getControladorP().getVistaP().setBounds(0, 0, 858, 444);
			getControladorPV().getVistaPV().setBounds(0, 0, 858, 444);
			getControladorG().getVistaGastos().setBounds(0, 0, 858, 444);

		}

	}

	protected ImageIcon ajustarImagen(Image img, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return imagen;
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

	public ControladorNuevoConsumo getControladorNC() {
		return controladorNC;
	}

	public void setControladorNC(ControladorNuevoConsumo controladorNC) {
		this.controladorNC = controladorNC;
	}

	public ControladorAgregarProducto getControladorAP() {
		return controladorAP;
	}

	public void setControladorAP(ControladorAgregarProducto controladorAP) {
		this.controladorAP = controladorAP;
	}

	public ControladorProveedores getControladorPV() {
		return controladorPV;
	}

	public void setControladorPV(ControladorProveedores controladorPV) {
		this.controladorPV = controladorPV;
	}

	public ControladorProductos getControladorP() {
		return controladorP;
	}

	public void setControladorP(ControladorProductos controladorP) {
		this.controladorP = controladorP;
	}

	public ControladorGastos getControladorG() {
		return controladorG;
	}

	public void setControladorG(ControladorGastos controladorG) {
		this.controladorG = controladorG;
	}

}
