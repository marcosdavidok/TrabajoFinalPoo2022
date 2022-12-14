package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import modelo.MD5;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.VistaPrincipal;
import vista.VistaInicial;

public class ControladorVistaInicial implements ActionListener, KeyListener, FocusListener, MouseListener {

	private VistaInicial vistaInicial;
	private MD5 md5;
	private UsuarioDAO usuarioDAO;
	private VistaPrincipal vistaPrincipal;
	private final Integer Abastecimiento = 3;
	private final Integer JefeDeBarra = 2;
	private static Usuario usuarioInicial;

	public ControladorVistaInicial() {
		this.setMd5(new MD5());
		this.setUsuarioDAO(new UsuarioDAO());
		this.setVistaInicial(new VistaInicial(this));
		this.getVistaInicial().setVisible(true);
	}

	private void login() {
		Boolean esta = false;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = usuarioDAO.getAll();

		for (Usuario usuario : usuarios) {
			if (getVistaInicial().getTextFieldUsuario().getText().equals(usuario.getUsuario())) {
				setUsuarioInicial(usuario);
				esta = true;
				if ((getMd5().encriptar(String.valueOf((getVistaInicial().getPasswordField().getPassword()))))
						.equals(usuario.getPassword())) {
					getVistaInicial().setVisible(false);
					ControladorVistaPrincipal controladorPrincipal = new ControladorVistaPrincipal();
					this.setVistaPrincipal(new VistaPrincipal(controladorPrincipal));

					if (usuario.getTipoUsuario() == Abastecimiento) {
						controladorPrincipal.getVistaPrincipal().getBtnNuevoConsumo().setVisible(false);
						controladorPrincipal.getVistaPrincipal().getBtnGastos().setVisible(false);
						controladorPrincipal.getVistaPrincipal().getBtnRegistrarUsuario().setVisible(false);
					} else if (usuario.getTipoUsuario() == JefeDeBarra) {
						controladorPrincipal.getControladorProductos().getVistaProductos().getBtnEliminarSinStock()
								.setVisible(false);
						controladorPrincipal.getControladorProductos().getVistaProductos().getBtnGuardar()
								.setVisible(false);
						controladorPrincipal.getControladorProductos().getVistaProductos().getBtnLimpiar()
								.setVisible(false);
						controladorPrincipal.getControladorProductos().getVistaProductos().getBtnModificar()
								.setVisible(false);
						controladorPrincipal.getControladorProductos().getVistaProductos().getBtnEliminar()
								.setVisible(false);
						controladorPrincipal.getControladorProductos().getVistaProductos().getBtnImprimir()
								.setVisible(false);
						controladorPrincipal.getControladorProductos().getVistaProductos().getTextFieldNombre()
								.setEditable(false);
						controladorPrincipal.getControladorProductos().getVistaProductos().getTextFieldCantidad()
								.setEditable(false);
						controladorPrincipal.getControladorProductos().getVistaProductos().getBtnBuscarProveedor()
								.setVisible(false);
						controladorPrincipal.getControladorProductos().getVistaProductos().getTextFieldPrecio()
								.setEditable(false);
						controladorPrincipal.getVistaPrincipal().getBtnProveedores().setVisible(false);
						controladorPrincipal.getVistaPrincipal().getBtnRegistrarUsuario().setVisible(false);
						controladorPrincipal.getVistaPrincipal().getBtnConfiguracion().setVisible(false);
					}
				} else {
					JOptionPane.showMessageDialog(vistaInicial, "CONTRASE??A INCORRECTA", "Atenci??n", 0);
					getVistaInicial().getPasswordField().setBorder(new LineBorder(Color.RED));
				}
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVistaInicial().getBtnIngresar())) {
			login();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
			login();
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource().equals(getVistaInicial().getTextFieldUsuario())) {
			getVistaInicial().getTextFieldUsuario().setBorder(new LineBorder(Color.BLACK));
			getVistaInicial().getTextFieldUsuario().setText(null);
		}
		if (e.getSource().equals(getVistaInicial().getPasswordField())) {
			getVistaInicial().getPasswordField().setBorder(new LineBorder(Color.BLACK));
			getVistaInicial().getPasswordField().setText(null);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(getVistaInicial().getLblOjo())) {
			if (getVistaInicial().getPasswordField().getEchoChar() == '???') {

				getVistaInicial().getPasswordField().setEchoChar((char) 0);
				ImageIcon imgOjo = getVistaInicial().ajustarImagen(
						new ImageIcon(VistaInicial.class.getResource("/Imagenes/ojoAbierto.png")).getImage(), 20, 20);
				getVistaInicial().getLblOjo().setIcon(imgOjo);
			} else {
				getVistaInicial().getPasswordField().setEchoChar('???');
				ImageIcon imgOjo = getVistaInicial().ajustarImagen(
						new ImageIcon(VistaInicial.class.getResource("/Imagenes/ojoCerrado.png")).getImage(), 20, 20);
				getVistaInicial().getLblOjo().setIcon(imgOjo);
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public VistaInicial getVistaInicial() {
		return vistaInicial;
	}

	public void setVistaInicial(VistaInicial vistaInicial) {
		this.vistaInicial = vistaInicial;
	}

	public MD5 getMd5() {
		return md5;
	}

	public void setMd5(MD5 md5) {
		this.md5 = md5;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public VistaPrincipal getVistaPrincipal() {
		return vistaPrincipal;
	}

	public void setVistaPrincipal(VistaPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
	}

	public static Usuario getUsuarioInicial() {
		return usuarioInicial;
	}

	public static void setUsuarioInicial(Usuario usuarioInicial) {
		ControladorVistaInicial.usuarioInicial = usuarioInicial;
	}

}
