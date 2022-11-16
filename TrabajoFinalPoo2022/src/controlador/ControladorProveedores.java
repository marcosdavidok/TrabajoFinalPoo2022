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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import modelo.Proveedor;
import modelo.ProveedorDAO;
import modelo.Reportes;
import vista.VistaPrincipal;
import vista.VistaProveedores;

public class ControladorProveedores implements ActionListener, FocusListener, KeyListener, MouseListener {

	private VistaProveedores vistaProveedores;
	private ProveedorDAO proveedorDao;
	private ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();

	public static ControladorProveedores controladorProveedores;

	public ControladorProveedores() {
		this.setVistaProveedores(new VistaProveedores(this));
		this.setProveedorDao(new ProveedorDAO());
		this.getVistaProveedores().getBtnModificar().setEnabled(false);
		this.getVistaProveedores().getBtnEliminar().setEnabled(false);
		this.pasarATabla(proveedores, proveedorDao, vistaProveedores);
		setControladorProveedores(this);
	}

	private Object[] obtenerProveedor(Proveedor proveedor) {
		Object[] fila = { Integer.valueOf(proveedor.getCuit()), proveedor.getNombre(),
				Integer.valueOf(proveedor.getTelefono()), proveedor.getDireccion(), proveedor.getRazon_social() };
		return fila;
	}

	private void pasarATabla(ArrayList<Proveedor> proveedores, ProveedorDAO proveedorDao, VistaProveedores vistaPV) {
		vaciarTabla(vistaPV);
		proveedores = proveedorDao.getAll();
		for (Proveedor proveedor : proveedores) {
			vistaPV.getModeloTabla().addRow(this.obtenerProveedor(proveedor));
		}
	}

	private void vaciarTabla(VistaProveedores vistaPV) {
		while (vistaPV.getModeloTabla().getRowCount() > 0) {
			vistaPV.getModeloTabla().removeRow(0);
		}
	}

	private void limpiar(VistaProveedores vistaPV) {
		vistaPV.getTextFieldDireccion().setText(null);
		vistaPV.getTextFieldNombre().setText(null);
		vistaPV.getTextFieldCuit().setText(null);
		vistaPV.getTextFieldRazonSocial().setText(null);
		vistaPV.getTextFieldTelefono().setText(null);
	}

	private void guardar(ArrayList<Proveedor> proveedores, ProveedorDAO proveedorDao, VistaProveedores vistaPV) {
		Proveedor proveedor = new Proveedor(Integer.valueOf(vistaPV.getTextFieldCuit().getText()),
				vistaPV.getTextFieldNombre().getText(), Integer.valueOf(vistaPV.getTextFieldTelefono().getText()),
				vistaPV.getTextFieldDireccion().getText(), vistaPV.getTextFieldRazonSocial().getText());
		if ((proveedorDao.get(vistaPV.getTextFieldCuit().getText())) != null) {
			JOptionPane.showMessageDialog(vistaPV, "Ya existe este proveedor. Ingrese un CUIT diferente.", "Atención",
					2);
		} else {
			this.vaciarTabla(vistaPV);
			proveedorDao.insert(proveedor);
			proveedores = proveedorDao.getAll();
			pasarATabla(proveedores, proveedorDao, vistaPV);
		}

	}

	private void modificar(ArrayList<Proveedor> proveedores, ProveedorDAO proveedorDao, VistaProveedores vistaPV) {
		Proveedor proveedor = new Proveedor(
				Integer.valueOf(vistaPV.getModeloTabla().getValueAt(vistaPV.getTable().getSelectedRow(), 0).toString()),
				vistaPV.getTextFieldNombre().getText(), Integer.valueOf(vistaPV.getTextFieldTelefono().getText()),
				vistaPV.getTextFieldDireccion().getText(), vistaPV.getTextFieldRazonSocial().getText());

		this.vaciarTabla(vistaPV);
		proveedorDao.update(proveedor);
		proveedores = proveedorDao.getAll();
		pasarATabla(proveedores, proveedorDao, vistaPV);
	}

	private void eliminar(ArrayList<Proveedor> proveedores, ProveedorDAO proveedorDao, VistaProveedores vistaPV) {
		Proveedor proveedor = new Proveedor(
				Integer.valueOf(vistaPV.getModeloTabla().getValueAt(vistaPV.getTable().getSelectedRow(), 0).toString()),
				null, null, null, null);
		proveedorDao.remove(proveedor);
		this.vaciarTabla(vistaPV);
		proveedores = proveedorDao.getAll();
		pasarATabla(proveedores, proveedorDao, vistaPV);
	}

	private void desactivarBotones(VistaProveedores vistaPV) {
		vistaPV.getBtnModificar().setEnabled(false);
		vistaPV.getBtnEliminar().setEnabled(false);
	}

	private void deTablaACampos(VistaProveedores VistaPV) {
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

	private void buscarProveedor(ArrayList<Proveedor> proveedores, ProveedorDAO proveedorDao,
			VistaProveedores vistaPV) {
		proveedores = proveedorDao.getAll();
		for (Proveedor proveedor : proveedores) {
			if (Pattern.compile(Pattern.quote(vistaPV.getTextFieldBuscar().getText()), Pattern.CASE_INSENSITIVE)
					.matcher(proveedor.getNombre()).find()) {
				vistaPV.getModeloTabla().addRow(obtenerProveedor(proveedor));
			}
		}
	}

	private boolean consistenciaDatosCompletos() {
		if (getVistaProveedores().getTextFieldCuit().getText().isEmpty()
				|| getVistaProveedores().getTextFieldNombre().getText().isEmpty()
				|| getVistaProveedores().getTextFieldDireccion().getText().isEmpty()
				|| getVistaProveedores().getTextFieldTelefono().getText().isEmpty()
				|| getVistaProveedores().getTextFieldRazonSocial().getText().isEmpty()) {
			JOptionPane.showMessageDialog(vistaProveedores, "Ingrese todos los datos del proveedor.", "Atención", 2);
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVistaProveedores().getBtnGuardar())) {
			if (this.consistenciaDatosCompletos() == true) {
				Object[] opciones = { "Si", "No" };
				Integer res = JOptionPane.showOptionDialog(getVistaProveedores(),
						"¿Seguro que desea agregar al proveedor?", "Atención", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE,
						this.ajustarImagen(
								new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Nuevo.png")).getImage(), 44,
								44),
						opciones, opciones[0]);
				if (res == 0) {
					this.guardar(getProveedores(), getProveedorDao(), getVistaProveedores());
				}
			}
			this.desactivarBotones(getVistaProveedores());
		}

		if (e.getSource().equals(getVistaProveedores().getBtnLimpiar())) {
			this.limpiar(vistaProveedores);
			this.desactivarBotones(getVistaProveedores());
		}

		if (e.getSource().equals(getVistaProveedores().getBtnModificar())) {
			if (this.consistenciaDatosCompletos() == true) {
				Object[] opciones = { "Si", "No" };
				Integer res = JOptionPane.showOptionDialog(getVistaProveedores(),
						"¿Seguro que desea modificar al proveedor?", "Atención", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE,
						this.ajustarImagen(
								new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Modificar.png")).getImage(),
								44, 44),
						opciones, opciones[0]);
				if (res == 0) {
					this.modificar(getProveedores(), getProveedorDao(), getVistaProveedores());
					this.desactivarBotones(getVistaProveedores());
				}
			}
		}

		if (e.getSource().equals(getVistaProveedores().getBtnEliminar())) {
			Object[] opciones = { "Si", "No" };
			Integer res = JOptionPane.showOptionDialog(getVistaProveedores(),
					"¿Seguro que desea eliminar al proveedor?", "Atención", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE,
					this.ajustarImagen(
							new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Eliminar.png")).getImage(), 44,
							44),
					opciones, opciones[0]);
			if (res == 0) {
				this.eliminar(getProveedores(), getProveedorDao(), getVistaProveedores());
				this.desactivarBotones(getVistaProveedores());

			}
		}

		if (e.getSource().equals(getVistaProveedores().getBtnImprimir())) {
			try {
				Reportes.reportesProveedores();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(vistaProveedores,
						"Hubo un problema con la base de datos y no se pudo generar el reporte.", "Error", -1,
						this.ajustarImagen(
								new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/ErrorBd.png")).getImage(), 44,
								44));
				e1.printStackTrace();
			}
			this.desactivarBotones(getVistaProveedores());
		}

		if (e.getSource().equals(getVistaProveedores().getBtnBuscar())) {
			if (getVistaProveedores().getTextFieldBuscar().getText().isEmpty()) {
				this.pasarATabla(getProveedores(), getProveedorDao(), getVistaProveedores());
			} else {
				this.vaciarTabla(getVistaProveedores());
				this.buscarProveedor(getProveedores(), getProveedorDao(), getVistaProveedores());
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (getVistaProveedores().getTextFieldTelefono().isFocusOwner()
				|| getVistaProveedores().getTextFieldCuit().isFocusOwner()) {
			char caracter = e.getKeyChar();
			if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) { // para que se ingrese solamente numeros
				e.consume(); // para que no se pueda escribir
			}
		}

		if (getVistaProveedores().getTextFieldCuit().isFocusOwner()) {
			if (getVistaProveedores().getTextFieldCuit().getText().length() > 8) {
				JOptionPane.showMessageDialog(vistaProveedores, "No es posible ingresar mas digitos.", "Atención", 2);
				e.consume();
			}
		}
		if (getVistaProveedores().getTextFieldTelefono().isFocusOwner()) {
			if (getVistaProveedores().getTextFieldTelefono().getText().length() > 8) {
				JOptionPane.showMessageDialog(vistaProveedores, "No es posible ingresar mas digitos.", "Atención", 2);
				e.consume();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource().equals(getVistaProveedores().getTextFieldBuscar())) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				getVistaProveedores().getBtnBuscar().doClick();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.deTablaACampos(getVistaProveedores());
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource().equals(getVistaProveedores().getTable())) {
			this.getVistaProveedores().getBtnModificar().setEnabled(true);
			this.getVistaProveedores().getBtnEliminar().setEnabled(true);
		}
	}

	private ImageIcon ajustarImagen(Image img, int ancho, int alto) {
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

	public VistaProveedores getVistaProveedores() {
		return vistaProveedores;
	}

	public void setVistaProveedores(VistaProveedores vistaProveedores) {
		this.vistaProveedores = vistaProveedores;
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

	public static void setControladorProveedores(ControladorProveedores controladorProveedores) {
		ControladorProveedores.controladorProveedores = controladorProveedores;
	}
}
