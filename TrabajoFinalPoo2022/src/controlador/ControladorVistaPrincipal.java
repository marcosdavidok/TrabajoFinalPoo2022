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
	private ControladorConfig controladorConfig;
	private ControladorNuevoConsumo controladorNuevoConsumo;
	private ControladorProveedores controladorProveedores;
	private ControladorProductos controladorProductos;
	private ControladorGastos controladorGastos;

	public ControladorVistaPrincipal() {
		this.setVistaPrincipal(new VistaPrincipal(this));
		this.getVistaPrincipal().setVisible(true);

		this.setControladorConfig(new ControladorConfig());
		this.getVistaPrincipal().getPanelVistas().add(getControladorConfig().getVistaConfig(), 0, 2);
		this.getControladorConfig().getVistaConfig().setVisible(false);

		this.setControladorNuevoConsumo(new ControladorNuevoConsumo());
		this.getVistaPrincipal().getPanelVistas().add(getControladorNuevoConsumo().getVistaNuevoConsumo(), 0, 3);
		this.getControladorNuevoConsumo().getVistaNuevoConsumo().setVisible(false);

		this.setControladorProveedores(new ControladorProveedores());
		this.getVistaPrincipal().getPanelVistas().add(getControladorProveedores().getVistaProveedores(), 0, 4);
		this.getControladorProveedores().getVistaProveedores().setVisible(false);

		this.setControladorProductos(new ControladorProductos());
		this.getVistaPrincipal().getPanelVistas().add(getControladorProductos().getVistaProductos(), 0, 5);
		this.getControladorProductos().getVistaProductos().setVisible(false);

		this.setControladorGastos(new ControladorGastos());
		this.getVistaPrincipal().getPanelVistas().add(getControladorGastos().getVistaGastos(), 0, 6);
		this.getControladorGastos().getVistaGastos().setVisible(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(getVistaPrincipal().getBtnNuevoConsumo())) {
			getVistaPrincipal().getLblTitulo().setText("NUEVO CONSUMO");
			getControladorNuevoConsumo().getVistaNuevoConsumo().setVisible(true);
			getControladorConfig().getVistaConfig().setVisible(false);
			getControladorProveedores().getVistaProveedores().setVisible(false);
			getControladorProductos().getVistaProductos().setVisible(false);
			getControladorGastos().getVistaGastos().setVisible(false);
		}

		if (e.getSource().equals(getVistaPrincipal().getBtnProductos())) {
			getVistaPrincipal().getLblTitulo().setText("BEBIDAS");
			getControladorProductos().getVistaProductos().setVisible(true);
			getControladorProductos().pasarATablas(null);
			getControladorProveedores().getVistaProveedores().setVisible(false);
			getControladorNuevoConsumo().getVistaNuevoConsumo().setVisible(false);
			getControladorConfig().getVistaConfig().setVisible(false);
			getControladorGastos().getVistaGastos().setVisible(false);
		}
		if (e.getSource().equals(getVistaPrincipal().getBtnProveedores())) {
			getVistaPrincipal().getLblTitulo().setText("PROVEEDORES");
			getControladorProveedores().getVistaProveedores().setVisible(true);
			getControladorNuevoConsumo().getVistaNuevoConsumo().setVisible(false);
			getControladorConfig().getVistaConfig().setVisible(false);
			getControladorProductos().getVistaProductos().setVisible(false);
			getControladorGastos().getVistaGastos().setVisible(false);

		}
		if (e.getSource().equals(getVistaPrincipal().getBtnGastos())) {
			getVistaPrincipal().getLblTitulo().setText("GASTOS");
			getControladorGastos().getVistaGastos().setVisible(true);
			getControladorProductos().getVistaProductos().setVisible(false);
			getControladorProveedores().getVistaProveedores().setVisible(false);
			getControladorNuevoConsumo().getVistaNuevoConsumo().setVisible(false);
			getControladorConfig().getVistaConfig().setVisible(false);
			getControladorGastos().pasarATabla();

		}
		if (e.getSource().equals(getVistaPrincipal().getBtnConfiguracion())) {
			getVistaPrincipal().getLblTitulo().setText("CONFIGURACIÓN");
			getControladorConfig().getVistaConfig().setVisible(true);
			getControladorNuevoConsumo().getVistaNuevoConsumo().setVisible(false);
			getControladorProveedores().getVistaProveedores().setVisible(false);
			getControladorProductos().getVistaProductos().setVisible(false);
			getControladorGastos().getVistaGastos().setVisible(false);
		}

		if (e.getSource().equals(getVistaPrincipal().getBtnRegistrarUsuario())) {
			new ControladorVistaNuevoUsuario();
			getControladorConfig().getVistaConfig().setVisible(false);
			getControladorNuevoConsumo().getVistaNuevoConsumo().setVisible(false);
			getControladorProveedores().getVistaProveedores().setVisible(false);
			getControladorProductos().getVistaProductos().setVisible(false);
			getControladorGastos().getVistaGastos().setVisible(false);
		}

		if (e.getSource().equals(getVistaPrincipal().getBtnLogout())) {
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
		}
	}

	@Override
	public void windowStateChanged(WindowEvent e) {
		if (getVistaPrincipal().getExtendedState() == VistaPrincipal.MAXIMIZED_BOTH) {

			getControladorConfig().getVistaConfig().setBounds(0, 0, 1200, 700);
			getControladorNuevoConsumo().getVistaNuevoConsumo().setBounds(0, 0, 1200, 700);
			getControladorProductos().getVistaProductos().setBounds(0, 0, 1200, 700);
			getControladorProveedores().getVistaProveedores().setBounds(0, 0, 1200, 700);
			getControladorGastos().getVistaGastos().setBounds(0, 0, 1200, 700);

		}
		if (getVistaPrincipal().getExtendedState() == VistaPrincipal.NORMAL) {

			getControladorConfig().getVistaConfig().setBounds(0, 0, 858, 444);
			getControladorNuevoConsumo().getVistaNuevoConsumo().setBounds(0, 0, 858, 444);
			getControladorProductos().getVistaProductos().setBounds(0, 0, 858, 444);
			getControladorProveedores().getVistaProveedores().setBounds(0, 0, 858, 444);
			getControladorGastos().getVistaGastos().setBounds(0, 0, 858, 444);

		}

	}

	private ImageIcon ajustarImagen(Image img, int ancho, int alto) {
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

	public ControladorConfig getControladorConfig() {
		return controladorConfig;
	}

	public void setControladorConfig(ControladorConfig controladorConfig) {
		this.controladorConfig = controladorConfig;
	}

	public ControladorNuevoConsumo getControladorNuevoConsumo() {
		return controladorNuevoConsumo;
	}

	public void setControladorNuevoConsumo(ControladorNuevoConsumo controladorNuevoConsumo) {
		this.controladorNuevoConsumo = controladorNuevoConsumo;
	}

	public ControladorProveedores getControladorProveedores() {
		return controladorProveedores;
	}

	public void setControladorProveedores(ControladorProveedores controladorProveedores) {
		this.controladorProveedores = controladorProveedores;
	}

	public ControladorProductos getControladorProductos() {
		return controladorProductos;
	}

	public void setControladorProductos(ControladorProductos controladorProductos) {
		this.controladorProductos = controladorProductos;
	}

	public ControladorGastos getControladorGastos() {
		return controladorGastos;
	}

	public void setControladorGastos(ControladorGastos controladorGastos) {
		this.controladorGastos = controladorGastos;
	}

}
