package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import vista.VistaNuevoConsumo;

public class ControladorNuevoConsumo implements ActionListener, FocusListener, KeyListener, MouseListener,
		WindowListener, ItemListener, WindowStateListener {
	private VistaNuevoConsumo vistaNuevoConsumo;
	public static ControladorNuevoConsumo controladorNuevoConsumo;

	public ControladorNuevoConsumo() {
		this.setVistaNC(new VistaNuevoConsumo(this));
		this.getVistaNuevoConsumo().getBtnAgregar().setEnabled(false);
		this.getVistaNuevoConsumo().getBtnBorrar().setEnabled(false);
		this.getVistaNuevoConsumo().getTextFieldStock().setEnabled(false);
		this.getVistaNuevoConsumo().getTextFieldProducto().setEnabled(false);
		this.getVistaNuevoConsumo().getBtnRegistrar().setEnabled(false);
		setControladorNuevaVenta(this);

	}

	@Override
	public void windowStateChanged(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public VistaNuevoConsumo getVistaNuevoConsumo() {
		return vistaNuevoConsumo;
	}

	public void setVistaNC(VistaNuevoConsumo vistaNuevoConsumo) {
		this.vistaNuevoConsumo = vistaNuevoConsumo;
	}

	public static ControladorNuevoConsumo getControladorNuevaVenta() {
		return controladorNuevoConsumo;
	}

	public static void setControladorNuevaVenta(ControladorNuevoConsumo controladorNuevoConsumo) {
		ControladorNuevoConsumo.controladorNuevoConsumo = controladorNuevoConsumo;
	}

}
