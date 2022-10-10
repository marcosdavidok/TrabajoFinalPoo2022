package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vista.VistaProveedores;

public class ControladorProveedores implements ActionListener, FocusListener, KeyListener, MouseListener {

	private VistaProveedores vistaPV;
	public static ControladorProveedores controladorP;

	public ControladorProveedores() {
		this.setVistaPV(new VistaProveedores(this));
		this.getVistaPV().getBtnModificar().setEnabled(false);
		this.getVistaPV().getBtnEliminar().setEnabled(false);
		setControladorP(this);
	}

	public void limpiar(VistaProveedores vistaPV) {
		vistaPV.getTextFieldDireccion().setText(null);
		vistaPV.getTextFieldNombre().setText(null);
		vistaPV.getTextFieldCuit().setText(null);
		vistaPV.getTextFieldRazonSocial().setText(null);
		vistaPV.getTextFieldTelefono().setText(null);
	}

	protected void desactivarBotones(VistaProveedores vistaPV) {
		vistaPV.getBtnModificar().setEnabled(false);
		vistaPV.getBtnEliminar().setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(getVistaPV().getBtnLimpiar())) {
			this.limpiar(vistaPV);
		}
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

	public VistaProveedores getVistaPV() {
		return vistaPV;
	}

	public void setVistaPV(VistaProveedores vistaPV) {
		this.vistaPV = vistaPV;
	}

	public static ControladorProveedores getControladorP() {
		return controladorP;
	}

	public static void setControladorP(ControladorProveedores controladorP) {
		ControladorProveedores.controladorP = controladorP;
	}

}
