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
import modelo.Producto;
import modelo.ProductoDAO;
import vista.VistaPrincipal;
import vista.VistaProductos;

public class ControladorProductos implements ActionListener, FocusListener, KeyListener, MouseListener {

	private VistaProductos vistaProductos;
	private ProductoDAO productoDao;
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	private ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
	private ProveedorDAO proveedorDao = new ProveedorDAO();
	public static ControladorProductos controladorProductos;

	public ControladorProductos() {
		this.setVistaProductos(new VistaProductos(this));
		this.setProductoDao(new ProductoDAO());
		this.getVistaProductos().getBtnModificar().setEnabled(false);
		this.getVistaProductos().getBtnEliminar().setEnabled(false);
		this.pasarATablas(getProductos());
		setControladorProductos(this);
	}

	public static ControladorProductos getInstance() {
		if (controladorProductos == null) {
			controladorProductos = new ControladorProductos();
		}
		return controladorProductos;
	}

	private Object[] obtenerProducto(Producto producto) {

		Object[] fila = { Integer.valueOf(producto.getCodigoProducto()), producto.getNombreProducto(),
				Integer.valueOf(producto.getCantidad()), Double.valueOf(producto.getPrecioProducto()),
				Integer.valueOf(producto.getCuitProveedor()) };
		return fila;
	}

	public void pasarATablas(ArrayList<Producto> productos) {
		this.vaciarTabla();

		this.setProductos(getProductoDao().getAll());
		for (Producto producto : getProductos()) {

			this.getVistaProductos().getModeloTabla().addRow(this.obtenerProducto(producto));

		}

	}

	public void vaciarTabla() {
		while (getVistaProductos().getModeloTabla().getRowCount() > 0) {
			getVistaProductos().getModeloTabla().removeRow(0);
		}
	}

	protected void deTablaACampos(VistaProductos VistaP) {
		VistaP.getTextFieldNombre()
				.setText(VistaP.getTable().getValueAt(VistaP.getTable().getSelectedRow(), 1).toString());
		VistaP.getTextFieldCantidad()
				.setText(VistaP.getTable().getValueAt(VistaP.getTable().getSelectedRow(), 2).toString());
		VistaP.getTextFieldPrecio()
				.setText(VistaP.getTable().getValueAt(VistaP.getTable().getSelectedRow(), 3).toString());

	}

	private void buscarProducto() {
		setProductos(getProductoDao().getAll());
		for (Producto producto : getProductos()) {
			if (Pattern.compile(Pattern.quote(vistaProductos.getTextFieldBuscar().getText()), Pattern.CASE_INSENSITIVE)
					.matcher(producto.getNombreProducto()).find()) {

				getVistaProductos().getModeloTabla().addRow(this.obtenerProducto(producto));
			}

		}
	}

	private void guardarProducto() {
		setProveedores(getProveedorDao().getAll());

		Producto producto = new Producto(0, getVistaProductos().getTextFieldNombre().getText(),
				Integer.valueOf(getVistaProductos().getTextFieldCantidad().getText()),
				Double.valueOf(getVistaProductos().getTextFieldPrecio().getText()),
				Integer.valueOf(getVistaProductos().getTextFieldProveedor().getText()));

		this.getProductoDao().insert(producto);
		this.setProductos(getProductoDao().getAll());
		this.pasarATablas(getProductos());

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(getVistaProductos().getBtnGuardar())) {
			if (getVistaProductos().getTextFieldNombre().getText().equals("")
					|| getVistaProductos().getTextFieldCantidad().getText().equals("")
					|| getVistaProductos().getTextFieldPrecio().getText().equals("")
					|| getVistaProductos().getTextFieldProveedor().getText().isEmpty()) {
				JOptionPane.showMessageDialog(vistaProductos, "Ingrese todos los datos.");
			} else {
				Object[] opciones = { "Si", "No" };
				Integer res = JOptionPane.showOptionDialog(getVistaProductos(),
						"¿Seguro que desea agregar el producto?", "Atención", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE,
						this.ajustarImagen(
								new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Nuevo.png")).getImage(), 44,
								44),
						opciones, opciones[0]);
				if (res == 0) {
					this.guardarProducto();
					getVistaProductos().getBtnModificar().setEnabled(false);
					getVistaProductos().getBtnEliminar().setEnabled(false);
				}
			}
		}
		if (e.getSource().equals(getVistaProductos().getBtnLimpiar())) {
			getVistaProductos().getTextFieldCantidad().setText(null);
			getVistaProductos().getTextFieldNombre().setText(null);
			getVistaProductos().getTextFieldPrecio().setText(null);
			getVistaProductos().getTextFieldProveedor().setText(null);
		}

		if (e.getSource().equals(getVistaProductos().getBtnModificar())) {
			if (getVistaProductos().getTextFieldNombre().getText().isEmpty()
					|| getVistaProductos().getTextFieldCantidad().getText().isEmpty()
					|| getVistaProductos().getTextFieldPrecio().getText().isEmpty()
					|| getVistaProductos().getTextFieldProveedor().getText().isEmpty()) {

				JOptionPane.showMessageDialog(getVistaProductos(), "Ingrese todos los campos");

			} else {
				Object[] opciones = { "Si", "No" };
				Integer res = JOptionPane.showOptionDialog(getVistaProductos(),
						"¿Seguro que desea modificar el producto?", "Atención", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE,
						this.ajustarImagen(
								new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Modificar.png")).getImage(),
								44, 44),
						opciones, opciones[0]);
				if (res == 0) {
					setProveedores(getProveedorDao().getAll());

					Producto producto = new Producto(
							Integer.valueOf((getVistaProductos().getTable()
									.getValueAt(getVistaProductos().getTable().getSelectedRow(), 0).toString())),
							getVistaProductos().getTextFieldNombre().getText(),
							Integer.valueOf(getVistaProductos().getTextFieldCantidad().getText()),
							Double.valueOf(getVistaProductos().getTextFieldPrecio().getText()),
							Integer.valueOf(getVistaProductos().getTextFieldProveedor().getText()));

					this.vaciarTabla();
					getProductoDao().update(producto);
					setProductos(getProductoDao().getAll());
					pasarATablas(getProductos());
					getVistaProductos().getBtnModificar().setEnabled(false);
					getVistaProductos().getBtnEliminar().setEnabled(false);
					JOptionPane.showMessageDialog(vistaProductos, "El producto se modificó con éxito.");
				}
			}

		}

		if (e.getSource().equals(getVistaProductos().getBtnEliminar())) {
			Object[] opciones = { "Si", "No" };
			Integer res = JOptionPane.showOptionDialog(getVistaProductos(),
					"¿Está seguro que desea eliminar el producto?", "Atención", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE,
					this.ajustarImagen(
							new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Eliminar.png")).getImage(), 44,
							44),
					opciones, opciones[0]);

			if (res == 0) {
				Producto producto = new Producto(
						Integer.valueOf(getVistaProductos().getModeloTabla()
								.getValueAt(getVistaProductos().getTable().getSelectedRow(), 0).toString()),
						null, null, null, null);
				this.vaciarTabla();
				getProductoDao().remove(producto);
				setProductos(getProductoDao().getAll());
				pasarATablas(getProductos());

				getVistaProductos().getBtnModificar().setEnabled(false);
				getVistaProductos().getBtnEliminar().setEnabled(false);
				JOptionPane.showMessageDialog(vistaProductos, "El producto se eliminó con éxito.");
			}

		}

		if (e.getSource().equals(getVistaProductos().getBtnBuscarProducto())) {
			if (getVistaProductos().getTextFieldBuscar().getText().isEmpty()) {
				this.pasarATablas(getProductos());

			} else {
				this.vaciarTabla();
				this.buscarProducto();

			}
		}
		if (e.getSource().equals(getVistaProductos().getBtnBuscarProveedor())) {

			new ControladorBuscarProveedor();

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (this.getVistaProductos().getTextFieldCantidad().isFocusOwner()) {

			char caracter = e.getKeyChar();
			// Verificar si la tecla pulsada no es un digito
			if (((caracter < '0') || (caracter > '9'))) {
				e.consume(); // ignorar el evento de teclado
			}

		}
		if (this.getVistaProductos().getTextFieldPrecio().isFocusOwner()) {
			char caracter = e.getKeyChar();
			// Verificar si la tecla pulsada no es un digito
			if (((caracter < '0') || (caracter > '9')) && (caracter != '.')) {
				e.consume(); // ignorar el evento de teclado
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource().equals(getVistaProductos().getTextFieldBuscar())) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				getVistaProductos().getBtnBuscarProducto().doClick();

			}
		}

	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource().equals(getVistaProductos().getTable())) {

			this.getVistaProductos().getBtnModificar().setEnabled(true);
			this.getVistaProductos().getBtnEliminar().setEnabled(true);

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(getVistaProductos().getTable()))
			deTablaACampos(getVistaProductos());

	}

	protected ImageIcon ajustarImagen(Image img, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return imagen;
	}

	@Override
	public void keyPressed(KeyEvent e) {
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

	public VistaProductos getVistaProductos() {
		return vistaProductos;
	}

	public void setVistaProductos(VistaProductos vistaProductos) {
		this.vistaProductos = vistaProductos;
	}

	public ProductoDAO getProductoDao() {
		return productoDao;
	}

	public void setProductoDao(ProductoDAO productoDao) {
		this.productoDao = productoDao;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
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

	public static void setControladorProductos(ControladorProductos controladorProductos) {
		ControladorProductos.controladorProductos = controladorProductos;
	}

}
