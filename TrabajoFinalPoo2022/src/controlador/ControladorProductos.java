package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vista.VistaProductos;

public class ControladorProductos implements ActionListener, FocusListener, KeyListener, MouseListener {
	private VistaProductos vistaP;
	public static ControladorProductos controladorP;

	public ControladorProductos() {
		this.setVistaP(new VistaProductos(this));
		this.getVistaP().getBtnModificar().setEnabled(false);
		this.getVistaP().getBtnEliminar().setEnabled(false);
		setControladorP(this);
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

	public static ControladorProductos getControladorP() {
		return controladorP;
	}

	public static void setControladorP(ControladorProductos controladorP) {
		ControladorProductos.controladorP = controladorP;
	}

	public VistaProductos getVistaP() {
		return vistaP;
	}

	public void setVistaP(VistaProductos vistaP) {
		this.vistaP = vistaP;
	}
}