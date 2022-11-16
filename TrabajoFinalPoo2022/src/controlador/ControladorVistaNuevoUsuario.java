package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import modelo.MD5;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.VistaInicial;
import vista.VistaNuevoUsuario;
import vista.VistaPrincipal;

public class ControladorVistaNuevoUsuario
		implements KeyListener, ActionListener, FocusListener, WindowListener, MouseListener {

	private VistaNuevoUsuario vistaNuevoUsuario;
	private UsuarioDAO usuarioDao = new UsuarioDAO();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private MD5 md5 = new MD5();

	public ControladorVistaNuevoUsuario() {
		setVistaNuevoUsuario(new VistaNuevoUsuario(this));
		this.getVistaNuevoUsuario().setVisible(true);
	}

	@SuppressWarnings("deprecation")
	private void registrar() {
		if (getVistaNuevoUsuario().getTextFieldUsuario().getText().isEmpty()
				|| getVistaNuevoUsuario().getPasswordFieldContraseña().getText().isEmpty()
				|| getVistaNuevoUsuario().getPasswordFieldConfirmar().getText().isEmpty()) {
			JOptionPane.showMessageDialog(vistaNuevoUsuario, "Por favor, ingrese todos los datos.", "Atención", 2);
		} else {
			int tipo = 0;
			switch (getVistaNuevoUsuario().getComboBox().getSelectedItem().toString()) {
			case "Administrador":
				tipo = 1;
				break;
			case "Jefe de barra":
				tipo = 2;
				break;
			case "Abastecimiento":
				tipo = 3;
				break;

			default:
				break;
			}

			Usuario usuarioNuevo = new Usuario(0, getVistaNuevoUsuario().getTextFieldUsuario().getText(),
					md5.encriptar(getVistaNuevoUsuario().getPasswordFieldContraseña().getText()), tipo);

			getUsuarioDao().insert(usuarioNuevo);
			if (Integer.SIZE > 0) {
				JOptionPane.showMessageDialog(vistaNuevoUsuario, "Registrado con éxito!", "Aceptado", -1,
						getVistaNuevoUsuario().ajustarImagen(
								new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Correcto.png")).getImage(),
								44, 44));

			}
		}

	}

	@SuppressWarnings("deprecation")
	@Override

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVistaNuevoUsuario().getBtnRegistrar())) {
			if (getVistaNuevoUsuario().getPasswordFieldContraseña().getPassword().length < 6) {
				JOptionPane.showMessageDialog(vistaNuevoUsuario, "La contraseña debe tener por lo menos 6 carateres.",
						"Atención", 2);
				getVistaNuevoUsuario().getPasswordFieldContraseña().requestFocus();
				getVistaNuevoUsuario().getPasswordFieldConfirmar().setText(null);
			} else if (!getVistaNuevoUsuario().getPasswordFieldConfirmar().getText()
					.equals(getVistaNuevoUsuario().getPasswordFieldContraseña().getText())) {
				JOptionPane.showMessageDialog(vistaNuevoUsuario, "Las contraseñas no coinciden.", "Atención", 2);
				getVistaNuevoUsuario().getPasswordFieldContraseña().requestFocus();
				getVistaNuevoUsuario().getPasswordFieldConfirmar().setText(null);
			} else {
				this.registrar();
				getVistaNuevoUsuario().getTextFieldUsuario().setText(null);
				getVistaNuevoUsuario().getPasswordFieldContraseña().setText(null);
				getVistaNuevoUsuario().getPasswordFieldConfirmar().setText(null);
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource().equals(getVistaNuevoUsuario().getTextFieldUsuario())) {
			setUsuarios(getUsuarioDao().getAll());
			for (Usuario usuario : getUsuarios()) {
				if (getVistaNuevoUsuario().getTextFieldUsuario().getText().equals(usuario.getUsuario())) {
					JOptionPane.showMessageDialog(vistaNuevoUsuario,
							"Ya existe ese usuario, por favor elija otro nombre.", "Atención", 2);
					getVistaNuevoUsuario().getTextFieldUsuario().requestFocus();
				}
			}
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		if (e.getSource().equals(getVistaNuevoUsuario())) {
			Vector<String> nombres = new Vector<String>();
			nombres.add("Administrador");
			nombres.add("Jefe de barra");
			nombres.add("Abastecimiento");
			getVistaNuevoUsuario().getComboBox().setModel(new DefaultComboBoxModel<>(nombres));
			Collections.sort(nombres);
			this.getVistaNuevoUsuario().getComboBox().setModel(new DefaultComboBoxModel<>(nombres));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(getVistaNuevoUsuario().getLblOjo())) {
			if (getVistaNuevoUsuario().getPasswordFieldContraseña().getEchoChar() == '●') {
				getVistaNuevoUsuario().getPasswordFieldContraseña().setEchoChar((char) 0);
				ImageIcon imgOjo = getVistaNuevoUsuario().ajustarImagen(
						new ImageIcon(VistaInicial.class.getResource("/Imagenes/ojoAbierto.png")).getImage(), 20, 20);
				getVistaNuevoUsuario().getLblOjo().setIcon(imgOjo);
			} else {
				getVistaNuevoUsuario().getPasswordFieldContraseña().setEchoChar('●');
				ImageIcon imgOjo = getVistaNuevoUsuario().ajustarImagen(
						new ImageIcon(VistaInicial.class.getResource("/Imagenes/ojoCerrado.png")).getImage(), 20, 20);
				getVistaNuevoUsuario().getLblOjo().setIcon(imgOjo);
			}
		}
		if (e.getSource().equals(getVistaNuevoUsuario().getLblOjoConfirmar())) {
			if (getVistaNuevoUsuario().getPasswordFieldConfirmar().getEchoChar() == '●') {
				getVistaNuevoUsuario().getPasswordFieldConfirmar().setEchoChar((char) 0);
				ImageIcon imgOjo = getVistaNuevoUsuario().ajustarImagen(
						new ImageIcon(VistaInicial.class.getResource("/Imagenes/ojoAbierto.png")).getImage(), 20, 20);
				getVistaNuevoUsuario().getLblOjoConfirmar().setIcon(imgOjo);
			} else {
				getVistaNuevoUsuario().getPasswordFieldConfirmar().setEchoChar('●');
				ImageIcon imgOjo = getVistaNuevoUsuario().ajustarImagen(
						new ImageIcon(VistaInicial.class.getResource("/Imagenes/ojoCerrado.png")).getImage(), 20, 20);
				getVistaNuevoUsuario().getLblOjoConfirmar().setIcon(imgOjo);
			}
		}

	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
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

	public MD5 getMd5() {
		return md5;
	}

	public void setMd5(MD5 md5) {
		this.md5 = md5;
	}

	public VistaNuevoUsuario getVistaNuevoUsuario() {
		return vistaNuevoUsuario;
	}

	public void setVistaNuevoUsuario(VistaNuevoUsuario vistaNuevoUsuario) {
		this.vistaNuevoUsuario = vistaNuevoUsuario;
	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
