package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import vista.VistaAgregarProducto;

public class ControladorAgregarProducto implements ActionListener, WindowListener, MouseListener, KeyListener {

	public static VistaAgregarProducto vistaAP;;
	private static ControladorAgregarProducto controladorAgregarProducto;

	public ControladorAgregarProducto() {

		this.setVistaAP(new VistaAgregarProducto(this));
		this.getVistaAP().setVisible(true);

	}

	public static ControladorAgregarProducto getInstance() {
		if (controladorAgregarProducto != null) {

		} else {
			setControladorAgregarProducto(new ControladorAgregarProducto());
		}
		return controladorAgregarProducto;
	}

	public static void setControladorAgregarProducto(ControladorAgregarProducto controladorAgregarProducto) {
		ControladorAgregarProducto.controladorAgregarProducto = controladorAgregarProducto;
	}

	public void vaciarTabla() {

		while (getVistaAP().getModeloTabla().getRowCount() > 0) {
			getVistaAP().getModeloTabla().removeRow(0);
		}
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public VistaAgregarProducto getVistaAP() {
		return vistaAP;
	}

	public void setVistaAP(VistaAgregarProducto vistaAP) {
		ControladorAgregarProducto.vistaAP = vistaAP;
	}

}
