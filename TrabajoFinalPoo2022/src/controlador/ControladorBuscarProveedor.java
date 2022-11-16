package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import modelo.Proveedor;
import modelo.ProveedorDAO;
import vista.VistaBuscarProveedor;

public class ControladorBuscarProveedor implements ActionListener, WindowListener, MouseListener, KeyListener {

	private VistaBuscarProveedor vistaBuscarProveedor;
	private ProveedorDAO proveedorDao;
	private ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();

	public ControladorBuscarProveedor() {
		this.setVistaBuscarProveedor(new VistaBuscarProveedor(this));
		this.setProveedorDao(new ProveedorDAO());
		this.getVistaBuscarProveedor().setVisible(true);
	}

	private void vaciarTabla() {
		while (getVistaBuscarProveedor().getModeloTabla().getRowCount() > 0) {
			getVistaBuscarProveedor().getModeloTabla().removeRow(0);
		}
	}

	private void pasarATabla(ArrayList<Proveedor> proveedores) {
		vaciarTabla();
		setProveedores(getProveedorDao().getAll());
		for (Proveedor proveedor : getProveedores()) {
			Object[] fila = { Integer.valueOf(proveedor.getCuit()), proveedor.getNombre(),
					Integer.valueOf(proveedor.getTelefono()), proveedor.getDireccion(), proveedor.getRazon_social() };
			getVistaBuscarProveedor().getModeloTabla().addRow(fila);
		}
	}

	private void buscarProveedor() {
		for (Proveedor proveedor : getProveedores()) {
			Object[] fila = { Integer.valueOf(proveedor.getCuit()), proveedor.getNombre(),
					Integer.valueOf(proveedor.getTelefono()), proveedor.getDireccion(), proveedor.getRazon_social() };
			if (Pattern.compile(Pattern.quote(vistaBuscarProveedor.getTextFieldBuscar().getText()),
					Pattern.CASE_INSENSITIVE).matcher(proveedor.getNombre()).find()) {
				getVistaBuscarProveedor().getModeloTabla().addRow(fila);
			}
		}
	}

	private void pasarACampos(Proveedor proveedor) {
		ControladorProductos.getInstance().getVistaProductos().getTextFieldProveedor()
				.setText(proveedor.getCuit().toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVistaBuscarProveedor().getBtnBuscar())) {
			if (getVistaBuscarProveedor().getTextFieldBuscar().getText().isEmpty()) {
				pasarATabla(getProveedores());
			} else {
				vaciarTabla();
				buscarProveedor();
			}
		}

		if (e.getSource().equals(getVistaBuscarProveedor().getBtnAgregar())) {
			try {
				Proveedor proveedor = new Proveedor(
						Integer.valueOf(getVistaBuscarProveedor().getModeloTabla()
								.getValueAt(getVistaBuscarProveedor().getTable().getSelectedRow(), 0).toString()),
						(getVistaBuscarProveedor().getModeloTabla()
								.getValueAt(getVistaBuscarProveedor().getTable().getSelectedRow(), 1)).toString(),
						Integer.valueOf(getVistaBuscarProveedor().getModeloTabla()
								.getValueAt(getVistaBuscarProveedor().getTable().getSelectedRow(), 2).toString()),
						(getVistaBuscarProveedor().getModeloTabla()
								.getValueAt(getVistaBuscarProveedor().getTable().getSelectedRow(), 3)).toString(),
						(getVistaBuscarProveedor().getModeloTabla()
								.getValueAt(getVistaBuscarProveedor().getTable().getSelectedRow(), 4)).toString());
				this.pasarACampos(proveedor);
				this.getVistaBuscarProveedor().dispose();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getVistaBuscarProveedor(), "Seleccione un proveedor","Atención",2);
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		if (e.getSource().equals(getVistaBuscarProveedor())) {
			pasarATabla(getProveedores());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource().equals(this.getVistaBuscarProveedor().getTextFieldBuscar())) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (getVistaBuscarProveedor().getTextFieldBuscar().getText().isEmpty()) {
					pasarATabla(getProveedores());
				} else {
					vaciarTabla();
					buscarProveedor();
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource().equals(this.getVistaBuscarProveedor().getTable())) {
			this.getVistaBuscarProveedor().getBtnAgregar().setEnabled(true);
		}
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
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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

	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public ProveedorDAO getProveedorDao() {
		return proveedorDao;
	}

	public void setProveedorDao(ProveedorDAO proveedorDao) {
		this.proveedorDao = proveedorDao;
	}

	public VistaBuscarProveedor getVistaBuscarProveedor() {
		return vistaBuscarProveedor;
	}

	public void setVistaBuscarProveedor(VistaBuscarProveedor vistaBuscarProveedor) {
		this.vistaBuscarProveedor = vistaBuscarProveedor;
	}

}
