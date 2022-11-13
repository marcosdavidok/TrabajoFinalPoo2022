package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import modelo.Proveedor;
import modelo.ProveedorDAO;
import vista.VistaPrincipal;
import vista.VistaProveedores;

public class ControladorProveedores implements ActionListener, FocusListener, KeyListener, MouseListener {

	private VistaProveedores vistaPV;
	private ProveedorDAO proveedorDao;
	private ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();

	public static ControladorProveedores controladorP;

	public ControladorProveedores() {
		this.setVistaPV(new VistaProveedores(this));
		this.setProveedorDao(new ProveedorDAO());
		this.getVistaPV().getBtnModificar().setEnabled(false);
		this.getVistaPV().getBtnEliminar().setEnabled(false);
		this.pasarATabla(proveedores, proveedorDao, vistaPV);
		setControladorP(this);
	}

	private Object[] obtenerProveedor(Proveedor proveedor) {

		Object[] fila = { Integer.valueOf(proveedor.getCuit()), proveedor.getNombre(),
				Integer.valueOf(proveedor.getTelefono()), proveedor.getDireccion(), proveedor.getRazon_social() };
		return fila;
	}

	public void pasarATabla(ArrayList<Proveedor> proveedores, ProveedorDAO proveedorDao, VistaProveedores vistaPV) {
		vaciarTabla(vistaPV); // O sino se muestra duplicado
		proveedores = proveedorDao.getAll();
		for (Proveedor proveedor : proveedores) {
			vistaPV.getModeloTabla().addRow(this.obtenerProveedor(proveedor));
		}

	}

	public void vaciarTabla(VistaProveedores vistaPV) {
		while (vistaPV.getModeloTabla().getRowCount() > 0) {
			vistaPV.getModeloTabla().removeRow(0);
		}
	}

	public void limpiar(VistaProveedores vistaPV) {
		vistaPV.getTextFieldDireccion().setText(null);
		vistaPV.getTextFieldNombre().setText(null);
		vistaPV.getTextFieldCuit().setText(null);
		vistaPV.getTextFieldRazonSocial().setText(null);
		vistaPV.getTextFieldTelefono().setText(null);
	}

	public void guardar(ArrayList<Proveedor> proveedores, ProveedorDAO proveedorDao, VistaProveedores vistaPV) {
		if (vistaPV.getTextFieldCuit().getText().equals("") || vistaPV.getTextFieldNombre().getText().equals("")
				|| vistaPV.getTextFieldDireccion().getText().equals("")
				|| vistaPV.getTextFieldRazonSocial().getText().equals("")
				|| vistaPV.getTextFieldTelefono().getText().equals("")) {
			JOptionPane.showMessageDialog(vistaPV, "Ingrese todos los datos del proveedor.");
		} else {

			Proveedor proveedor = new Proveedor(Integer.valueOf(vistaPV.getTextFieldCuit().getText()),
					vistaPV.getTextFieldNombre().getText(), Integer.valueOf(vistaPV.getTextFieldTelefono().getText()),
					vistaPV.getTextFieldDireccion().getText(), vistaPV.getTextFieldRazonSocial().getText());

			if ((proveedorDao.get(vistaPV.getTextFieldCuit().getText())) != null) {
				JOptionPane.showMessageDialog(vistaPV, "Ya existe este proveedor. Ingrese un CUIT diferente.");
			} else {
				this.vaciarTabla(vistaPV);
				proveedorDao.insert(proveedor);
				proveedores = proveedorDao.getAll();
				pasarATabla(proveedores, proveedorDao, vistaPV);
			}
		}
	}

	public void modificar(ArrayList<Proveedor> proveedores, ProveedorDAO proveedorDao, VistaProveedores vistaPV) {

		Proveedor proveedor = new Proveedor(
				Integer.valueOf(vistaPV.getModeloTabla().getValueAt(vistaPV.getTable().getSelectedRow(), 0).toString()),
				vistaPV.getTextFieldNombre().getText(), Integer.valueOf(vistaPV.getTextFieldTelefono().getText()),
				vistaPV.getTextFieldDireccion().getText(), vistaPV.getTextFieldRazonSocial().getText());

		this.vaciarTabla(vistaPV);
		proveedorDao.update(proveedor);
		proveedores = proveedorDao.getAll();
		pasarATabla(proveedores, proveedorDao, vistaPV);

	}

	public void eliminar(ArrayList<Proveedor> proveedores, ProveedorDAO proveedorDao, VistaProveedores vistaPV) {
		Proveedor proveedor = new Proveedor(
				Integer.valueOf(vistaPV.getModeloTabla().getValueAt(vistaPV.getTable().getSelectedRow(), 0).toString()),
				null, null, null, null);
		proveedorDao.remove(proveedor);
		this.vaciarTabla(vistaPV);
		proveedores = proveedorDao.getAll();
		pasarATabla(proveedores, proveedorDao, vistaPV);
	}

	protected void desactivarBotones(VistaProveedores vistaPV) {
		vistaPV.getBtnModificar().setEnabled(false);
		vistaPV.getBtnEliminar().setEnabled(false);
	}

	protected void deTablaACampos(VistaProveedores VistaPV) {
		VistaPV.getTextFieldCuit()
				.setText(VistaPV.getTable().getValueAt(VistaPV.getTable().getSelectedRow(), 0).toString());
		VistaPV.getTextFieldNombre()
				.setText(VistaPV.getTable().getValueAt(VistaPV.getTable().getSelectedRow(), 1).toString());
		VistaPV.getTextFieldTelefono()
				.setText(VistaPV.getTable().getValueAt(VistaPV.getTable().getSelectedRow(), 2).toString());
		VistaPV.getTextFieldDireccion()
				.setText(VistaPV.getTable().getValueAt(VistaPV.getTable().getSelectedRow(), 3).toString());
		VistaPV.getTextFieldRazonSocial()
				.setText(VistaPV.getTable().getValueAt(VistaPV.getTable().getSelectedRow(), 4).toString());
	}

	protected void buscarProveedor(ArrayList<Proveedor> proveedores, ProveedorDAO proveedorDao,
			VistaProveedores vistaPV) {
		proveedores = proveedorDao.getAll();
		for (Proveedor proveedor : proveedores) {
			if (Pattern.compile(Pattern.quote(vistaPV.getTextFieldBuscar().getText()), Pattern.CASE_INSENSITIVE)
					.matcher(proveedor.getNombre()).find()) {
				vistaPV.getModeloTabla().addRow(obtenerProveedor(proveedor));
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(getVistaPV().getBtnGuardar())) {
			if (getVistaPV().getTextFieldCuit().getText().isEmpty()
					|| getVistaPV().getTextFieldNombre().getText().isEmpty()
					|| getVistaPV().getTextFieldDireccion().getText().isEmpty()
					|| getVistaPV().getTextFieldTelefono().getText().isEmpty()
					|| getVistaPV().getTextFieldRazonSocial().getText().isEmpty()) {
				JOptionPane.showMessageDialog(vistaPV, "Ingrese todos los datos.");
			} else {
				Object[] opciones = { "Si", "No" };
				Integer res = JOptionPane.showOptionDialog(getVistaPV(), "¿Seguro que desea agregar al proveedor?",
						"Atención", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						this.ajustarImagen(
								new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Nuevo.png")).getImage(), 44,
								44),
						opciones, opciones[0]);
				if (res == 0) {
					this.guardar(getProveedores(), getProveedorDao(), getVistaPV());
				}
			}
			this.desactivarBotones(getVistaPV());
		}

		if (e.getSource().equals(getVistaPV().getBtnLimpiar())) {
			this.limpiar(vistaPV);
			this.desactivarBotones(getVistaPV());
		}

		if (e.getSource().equals(getVistaPV().getBtnModificar())) {
			if (getVistaPV().getTextFieldCuit().getText().isEmpty()
					|| getVistaPV().getTextFieldNombre().getText().isEmpty()
					|| getVistaPV().getTextFieldDireccion().getText().isEmpty()
					|| getVistaPV().getTextFieldTelefono().getText().isEmpty()
					|| getVistaPV().getTextFieldRazonSocial().getText().isEmpty()) {
				JOptionPane.showMessageDialog(vistaPV, "Ingrese todos los datos.");
			} else {
				Object[] opciones = { "Si", "No" };
				Integer res = JOptionPane.showOptionDialog(getVistaPV(), "¿Seguro que desea modificar al proveedor?",
						"Atención", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
						this.ajustarImagen(
								new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Modificar.png")).getImage(),
								44, 44),
						opciones, opciones[0]);
				if (res == 0) {
					this.modificar(getProveedores(), getProveedorDao(), getVistaPV());
					this.desactivarBotones(getVistaPV());
				}
			}
		}

		if (e.getSource().equals(getVistaPV().getBtnEliminar())) {
			Object[] opciones = { "Si", "No" };
			Integer res = JOptionPane.showOptionDialog(getVistaPV(), "¿Seguro que desea eliminar al proveedor?",
					"Atención", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					this.ajustarImagen(
							new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Eliminar.png")).getImage(), 44,
							44),
					opciones, opciones[0]);
			if (res == 0) {
				this.eliminar(getProveedores(), getProveedorDao(), getVistaPV());
				this.desactivarBotones(getVistaPV());
			}
		}

		if (e.getSource().equals(getVistaPV().getBtnBuscar())) {
			if (getVistaPV().getTextFieldBuscar().getText().isEmpty()) {
				this.pasarATabla(getProveedores(), getProveedorDao(), getVistaPV());
			} else {
				this.vaciarTabla(getVistaPV());
				this.buscarProveedor(getProveedores(), getProveedorDao(), getVistaPV());
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (getVistaPV().getTextFieldTelefono().isFocusOwner() || getVistaPV().getTextFieldCuit().isFocusOwner()) {

			char caracter = e.getKeyChar();
			if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) { // para que se ingrese solamente numeros
				e.consume(); // para que no se pueda escribir
			}

		}

		if (getVistaPV().getTextFieldCuit().isFocusOwner()) {
			if (getVistaPV().getTextFieldCuit().getText().length() > 8) {
				JOptionPane.showMessageDialog(vistaPV, "No es posible ingresar mas digitos.");
				e.consume();
			}
		}
		if (getVistaPV().getTextFieldTelefono().isFocusOwner()) {
			if (getVistaPV().getTextFieldTelefono().getText().length() > 8) {
				JOptionPane.showMessageDialog(vistaPV, "No es posible ingresar mas digitos.");
				e.consume();
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource().equals(getVistaPV().getTextFieldBuscar())) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				getVistaPV().getBtnBuscar().doClick();
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.deTablaACampos(getVistaPV());
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource().equals(getVistaPV().getTable())) {
			this.getVistaPV().getBtnModificar().setEnabled(true);
			this.getVistaPV().getBtnEliminar().setEnabled(true);
		}
	}

	protected ImageIcon ajustarImagen(Image img, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return imagen;
	}

	@Override
	public void focusLost(FocusEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

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

	public VistaProveedores getVistaPV() {
		return vistaPV;
	}

	public void setVistaPV(VistaProveedores vistaPV) {
		this.vistaPV = vistaPV;
	}

	public ProveedorDAO getProveedorDao() {
		return proveedorDao;
	}

	public void setProveedorDao(ProveedorDAO proveedorDao) {
		this.proveedorDao = proveedorDao;
	}

	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public static ControladorProveedores getControladorP() {
		return controladorP;
	}

	public static void setControladorP(ControladorProveedores controladorP) {
		ControladorProveedores.controladorP = controladorP;
	}

}
