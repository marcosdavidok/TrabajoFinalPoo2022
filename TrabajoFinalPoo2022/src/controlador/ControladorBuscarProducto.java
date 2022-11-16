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

import modelo.Producto;
import modelo.ProductoDAO;
import vista.VistaBuscarProducto;

public class ControladorBuscarProducto implements ActionListener, WindowListener, MouseListener, KeyListener {

	public static VistaBuscarProducto vistaBuscarProducto;
	private ProductoDAO productoDao;
	private ArrayList<Producto> productos = new ArrayList<Producto>();

	public ControladorBuscarProducto() {
		this.setVistaBuscarProducto(new VistaBuscarProducto(this));
		this.setProdcutoDAO(new ProductoDAO());
		this.getVistaBuscarProducto().setVisible(true);
	}

	private void vaciarTabla() {
		while (getVistaBuscarProducto().getModeloTabla().getRowCount() > 0) {
			getVistaBuscarProducto().getModeloTabla().removeRow(0);
		}
	}

	private void pasarATablas(ArrayList<Producto> productos) {
		vaciarTabla();
		setProductos(getProductoDao().getAll());
		for (Producto producto : getProductos()) {
			Object[] fila = { Integer.valueOf(producto.getCodigoProducto()), producto.getNombreProducto(),
					Integer.valueOf(producto.getCantidad()), Double.valueOf(producto.getPrecioProducto()),
					Integer.valueOf(producto.getCuitProveedor()) };
			getVistaBuscarProducto().getModeloTabla().addRow(fila);
		}
	}

	private void buscarProducto() {
		for (Producto producto : getProductos()) {
			Object[] fila = { Integer.valueOf(producto.getCodigoProducto()), producto.getNombreProducto(),
					Integer.valueOf(producto.getCantidad()), Double.valueOf(producto.getPrecioProducto()),
					Integer.valueOf(producto.getCuitProveedor()) };

			if (Pattern.compile(Pattern.quote(vistaBuscarProducto.getTextFieldBuscar().getText()),
					Pattern.CASE_INSENSITIVE).matcher(producto.getNombreProducto()).find()) {
				getVistaBuscarProducto().getModeloTabla().addRow(fila);
			}
		}
	}

	private void pasarACampos(Producto producto) {
		ControladorNuevoConsumo.getInstance().getVistaNuevoConsumo().getTextFieldCodigo()
				.setText(producto.getCodigoProducto().toString());
		ControladorNuevoConsumo.getInstance().getVistaNuevoConsumo().getTextFieldPrecio()
				.setText(producto.getPrecioProducto().toString());
		ControladorNuevoConsumo.getInstance().getVistaNuevoConsumo().getTextFieldStock()
				.setText(producto.getCantidad().toString());
		ControladorNuevoConsumo.getInstance().getVistaNuevoConsumo().getTextFieldProducto()
				.setText(producto.getNombreProducto());
		ControladorNuevoConsumo.getInstance().getVistaNuevoConsumo().getTextFieldCantidad().requestFocus();
		ControladorNuevoConsumo.getInstance().getVistaNuevoConsumo().getBtnAgregar().setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVistaBuscarProducto().getBtnBuscar())) {
			if (getVistaBuscarProducto().getTextFieldBuscar().getText().isEmpty()) {
				pasarATablas(getProductos());
			} else {
				vaciarTabla();
				buscarProducto();
			}
		}

		if (e.getSource().equals(getVistaBuscarProducto().getBtnAgregar())) {
			try {
				Producto producto = new Producto(
						Integer.valueOf((getVistaBuscarProducto().getTable()
								.getValueAt(getVistaBuscarProducto().getTable().getSelectedRow(), 0).toString())),
						String.valueOf((getVistaBuscarProducto().getTable()
								.getValueAt(getVistaBuscarProducto().getTable().getSelectedRow(), 1).toString())),
						Integer.valueOf((getVistaBuscarProducto().getTable()
								.getValueAt(getVistaBuscarProducto().getTable().getSelectedRow(), 2).toString())),
						Double.valueOf((getVistaBuscarProducto().getTable()
								.getValueAt(getVistaBuscarProducto().getTable().getSelectedRow(), 3).toString())),
						Integer.valueOf((getVistaBuscarProducto().getTable()
								.getValueAt(getVistaBuscarProducto().getTable().getSelectedRow(), 4).toString())));
				this.pasarACampos(producto);
				getVistaBuscarProducto().dispose();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getVistaBuscarProducto(), "Seleccione un producto","Atención",2);
			}
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		if (e.getSource().equals(getVistaBuscarProducto())) {
			pasarATablas(getProductos());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource().equals(this.getVistaBuscarProducto().getTextFieldBuscar())) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (getVistaBuscarProducto().getTextFieldBuscar().getText().isEmpty()) {
					pasarATablas(getProductos());
				} else {
					vaciarTabla();
					buscarProducto();
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource().equals(this.getVistaBuscarProducto().getTable())) {
			this.getVistaBuscarProducto().getBtnAgregar().setEnabled(true);
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

	public VistaBuscarProducto getVistaBuscarProducto() {
		return vistaBuscarProducto;
	}

	public void setVistaBuscarProducto(VistaBuscarProducto vistaBuscarProducto) {
		ControladorBuscarProducto.vistaBuscarProducto = vistaBuscarProducto;
	}

	public ProductoDAO getProductoDao() {
		return productoDao;
	}

	public void setProdcutoDAO(ProductoDAO productoDao) {
		this.productoDao = productoDao;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
}
