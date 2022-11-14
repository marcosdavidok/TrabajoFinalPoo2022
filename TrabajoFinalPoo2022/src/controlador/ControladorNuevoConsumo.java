package controlador;

import java.awt.Image;
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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Consumo;
import modelo.ConsumoDAO;
import modelo.DetalleConsumo;
import modelo.DetalleConsumoDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Reportes;
import vista.VistaNuevoConsumo;
import vista.VistaPrincipal;

public class ControladorNuevoConsumo implements ActionListener, FocusListener, KeyListener, MouseListener,
		WindowListener, ItemListener, WindowStateListener {
	private VistaNuevoConsumo vistaNuevoConsumo;
	private ProductoDAO productoDAO;
	private ConsumoDAO consumoDao;
	private DetalleConsumoDAO detalleConsumoDao;
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	public static ControladorNuevoConsumo controladorNuevoConsumo;

	public ControladorNuevoConsumo() {
		this.setVistaNuevoConsumo(new VistaNuevoConsumo(this));
		this.setProductoDAO(new ProductoDAO());
		this.setConsumoDao(new ConsumoDAO());
		this.getVistaNuevoConsumo().getBtnAgregar().setEnabled(false);
		this.getVistaNuevoConsumo().getBtnBorrar().setEnabled(false);
		this.setDetalleConsumoDao(new DetalleConsumoDAO());
		this.getVistaNuevoConsumo().getTextFieldStock().setEnabled(false);
		this.getVistaNuevoConsumo().getTextFieldProducto().setEnabled(false);
		this.getVistaNuevoConsumo().getBtnRegistrar().setEnabled(false);
		setControladorNuevoConsumo(this);
	}

	public static ControladorNuevoConsumo getInstance() {
		if (controladorNuevoConsumo == null) {
			controladorNuevoConsumo = new ControladorNuevoConsumo();
		}
		return controladorNuevoConsumo;
	}

	private void registrarConsumo() {
		Integer id_consumo = 0;
		LocalDate fecha_consumo = LocalDate.now();
		Integer id_usuario = ControladorVistaInicial.getUsuarioInicial().getId_usuario();
		Double total = Double.parseDouble(getVistaNuevoConsumo().getLblPrecioTotal().getText());
		Consumo consumo = new Consumo(id_consumo, fecha_consumo, id_usuario, total);
		Integer result = this.getConsumoDao().insert(consumo);

		if (result > 0) {
			this.generarDetalleConsumo(result);
			JOptionPane.showMessageDialog(vistaNuevoConsumo, "El consumo se registro con éxito.");
			this.limpiarCampos();
			this.BorrarTodos();
			this.getVistaNuevoConsumo().getBtnAgregar().setEnabled(false);
			this.getVistaNuevoConsumo().getBtnBorrar().setEnabled(false);
			this.getVistaNuevoConsumo().getLblPrecioTotal().setText("0.0");
			this.getVistaNuevoConsumo().getBtnRegistrar().setEnabled(false);
			try {
				Object[] opciones = { "Si", "No" };
				Integer respuesta = JOptionPane.showOptionDialog(getVistaNuevoConsumo(),
						"¿Desea obtener ahora el detalle del consumo en PDF?", "Atención", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE,
						this.ajustarImagen(
								new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/PdfLogo.png")).getImage(), 70,
								70),
						opciones, opciones[0]);
				if (respuesta == 0) {
					Reportes.detalleDeConsumo(result);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(vistaNuevoConsumo,
						"Hubo un problema con la base de datos y no se pudo generar el detalle");
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(vistaNuevoConsumo, "El consumo no se pudo registrar.");
		}
	}

	private void generarDetalleConsumo(Integer id_consumo) {
		JTable tablaDatos = getVistaNuevoConsumo().getTable();
		for (int i = 0; i < tablaDatos.getRowCount(); i++) {
			Integer codProducto = Integer.parseInt(tablaDatos.getValueAt(i, 0).toString());
			Integer cantidad = Integer.parseInt(tablaDatos.getValueAt(i, 2).toString());
			Double precio = Double.parseDouble(tablaDatos.getValueAt(i, 3).toString());
			Double importe = Double.parseDouble(tablaDatos.getValueAt(i, 4).toString());

			Producto producto = this.getProductoDAO().get(codProducto);
			producto.setCantidad(producto.getCantidad() - cantidad);
			this.getProductoDAO().update(producto);

			DetalleConsumo itemConsumo = new DetalleConsumo(null, id_consumo, codProducto, cantidad, precio, importe);
			this.getDetalleConsumoDao().insert(itemConsumo);

		}

	}

	private void limpiarCampos() {
		this.getVistaNuevoConsumo().getTextFieldCodigo().setText("");
		this.getVistaNuevoConsumo().getTextFieldProducto().setText("");
		this.getVistaNuevoConsumo().getTextFieldPrecio().setText("");
		this.getVistaNuevoConsumo().getTextFieldCantidad().setText("");
		this.getVistaNuevoConsumo().getTextFieldStock().setText("");
	}

	private void AgregarProducto() {
		Double totalConsumo = Double.parseDouble(getVistaNuevoConsumo().getLblPrecioTotal().getText());
		Double subTotal = Double.parseDouble(getVistaNuevoConsumo().getTextFieldPrecio().getText())
				* Double.parseDouble(getVistaNuevoConsumo().getTextFieldCantidad().getText());
		int numCol = getVistaNuevoConsumo().getModeloTabla().getColumnCount();
		totalConsumo += subTotal;
		Object[] fila = new Object[numCol];
		fila[0] = getVistaNuevoConsumo().getTextFieldCodigo().getText();
		fila[1] = getVistaNuevoConsumo().getTextFieldProducto().getText();
		fila[2] = Integer.parseInt(getVistaNuevoConsumo().getTextFieldCantidad().getText());
		fila[3] = Double.parseDouble(getVistaNuevoConsumo().getTextFieldPrecio().getText());
		fila[4] = subTotal;
		this.getVistaNuevoConsumo().getModeloTabla().addRow(fila);
		getVistaNuevoConsumo().getLblPrecioTotal().setText(totalConsumo.toString());
		this.getVistaNuevoConsumo().getTextFieldCodigo().requestFocus();
		this.getVistaNuevoConsumo().getBtnAgregar().setEnabled(false);
		this.getVistaNuevoConsumo().getTextFieldCodigo().setText("");
		this.getVistaNuevoConsumo().getTextFieldPrecio().setText("");
		this.getVistaNuevoConsumo().getTextFieldCantidad().setText("");
		this.getVistaNuevoConsumo().getTextFieldStock().setText("");
		this.getVistaNuevoConsumo().getBtnRegistrar().setEnabled(true);
	}

	private Boolean productoEsApto() {
		if (!estaProducto()) {
			if ((getVistaNuevoConsumo().getTextFieldPrecio().getText().isEmpty())
					|| (getVistaNuevoConsumo().getTextFieldCantidad().getText().isEmpty())
					|| ((Double.valueOf(getVistaNuevoConsumo().getTextFieldPrecio().getText())) <= 0.0)
					|| ((Integer.valueOf(getVistaNuevoConsumo().getTextFieldCantidad().getText())) < 1)) {
				JOptionPane.showMessageDialog(vistaNuevoConsumo, "Ingrese todos los datos del producto.");
				getVistaNuevoConsumo().getTextFieldCantidad().requestFocus();
				return false;

			} else {
				if ((Integer.valueOf(getVistaNuevoConsumo().getTextFieldCantidad().getText())) > (Integer
						.valueOf(getVistaNuevoConsumo().getTextFieldStock().getText()))) {
					JOptionPane.showMessageDialog(vistaNuevoConsumo, "La cantidad no puede superar el stock actual");
					return false;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	private void BorrarProducto() {
		getVistaNuevoConsumo().getLblPrecioTotal()
				.setText((Double.valueOf(((Double.valueOf(getVistaNuevoConsumo().getLblPrecioTotal().getText()))
						- (Double.valueOf(getVistaNuevoConsumo().getTable()
								.getValueAt(getVistaNuevoConsumo().getTable().getSelectedRow(), 4).toString())))))
						.toString());
		getVistaNuevoConsumo().getModeloTabla().removeRow(getVistaNuevoConsumo().getTable().getSelectedRow());
	}

	private void BorrarTodos() {
		while (getVistaNuevoConsumo().getModeloTabla().getRowCount() > 0) {
			getVistaNuevoConsumo().getModeloTabla().removeRow(0);
		}
	}

	protected void desactivarBotones(VistaNuevoConsumo vistaNC) {
		vistaNC.getBtnBorrar().setEnabled(false);
		vistaNC.getBtnAgregar().setEnabled(false);
	}

	private Boolean estaProducto() {
		if (getVistaNuevoConsumo().getTable().getRowCount() == 0) {
			return false;
		} else {
			for (int i = 0; i < getVistaNuevoConsumo().getTable().getRowCount(); i++) {
				if (getVistaNuevoConsumo().getTable().getValueAt(i, 0)
						.equals(getVistaNuevoConsumo().getTextFieldCodigo().getText())) {
					JOptionPane.showMessageDialog(getVistaNuevoConsumo(), "Producto ya ingresado.");
					getVistaNuevoConsumo().getTable().requestFocus();
					getVistaNuevoConsumo().getTable().setRowSelectionInterval(i, i);
					return true;
				}

			}
			return false;
		}

	}

	private void pasarACampos() throws NullPointerException {
		Producto producto = getProductoDAO()
				.get(Integer.valueOf(getVistaNuevoConsumo().getTextFieldCodigo().getText()));
		getVistaNuevoConsumo().getTextFieldCodigo().setText(producto.getCodigoProducto().toString());
		getVistaNuevoConsumo().getTextFieldPrecio().setText(producto.getPrecioProducto().toString());
		getVistaNuevoConsumo().getTextFieldStock().setText(producto.getCantidad().toString());
		getVistaNuevoConsumo().getTextFieldProducto().setText(producto.getNombreProducto());
		getVistaNuevoConsumo().getTextFieldCantidad().requestFocus();
		getVistaNuevoConsumo().getBtnAgregar().setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVistaNuevoConsumo().getBtnBuscar())) {
			new ControladorBuscarProducto();
		}

		if (e.getSource().equals(getVistaNuevoConsumo().getBtnAgregar())) {
			if (this.productoEsApto()) {
				this.AgregarProducto();
				this.limpiarCampos();
				this.getVistaNuevoConsumo().getBtnBorrar().setEnabled(true);
				this.getVistaNuevoConsumo().getBtnRegistrar().setEnabled(true);
			}
		}

		if (e.getSource().equals(getVistaNuevoConsumo().getBtnLimpiar())) {
			this.limpiarCampos();
			this.BorrarTodos();
			this.getVistaNuevoConsumo().getBtnAgregar().setEnabled(false);
			this.getVistaNuevoConsumo().getBtnBorrar().setEnabled(false);
			this.getVistaNuevoConsumo().getLblPrecioTotal().setText("0.0");
			this.getVistaNuevoConsumo().getBtnRegistrar().setEnabled(false);
		}

		if (e.getSource().equals(getVistaNuevoConsumo().getBtnRegistrar())) {
			this.registrarConsumo();
			this.desactivarBotones(getVistaNuevoConsumo());
			this.limpiarCampos();
		}

		if (e.getSource().equals(getVistaNuevoConsumo().getBtnBorrar())) {
			BorrarProducto();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (getVistaNuevoConsumo().getTextFieldCantidad().isFocusOwner()) {
			char caracter = e.getKeyChar();
			// Verificar si la tecla pulsada no es un digito
			if (((caracter < '0') || (caracter > '9'))) {
				e.consume(); // ignorar el evento de teclado
			}
		}
		if (getVistaNuevoConsumo().getTextFieldPrecio().isFocusOwner()) {
			char caracter = e.getKeyChar();
			// Verificar si la tecla pulsada no es un digito
			if (((caracter < '0') || (caracter > '9')) && (caracter != '.')) {
				e.consume();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if ((e.getSource().equals(this.getVistaNuevoConsumo().getTextFieldCantidad())
				|| (e.getSource().equals(this.getVistaNuevoConsumo().getTextFieldPrecio())))) {

			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (this.productoEsApto()) {
					this.AgregarProducto();
					this.getVistaNuevoConsumo().getBtnBorrar().setEnabled(true);
				}
			}
		}

		if (e.getSource().equals(getVistaNuevoConsumo().getTextFieldCodigo())) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				try {
					this.pasarACampos();
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(getVistaNuevoConsumo(), "Producto no encontrado");
				}
			}
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource().equals(getVistaNuevoConsumo().getTable())) {

			this.getVistaNuevoConsumo().getBtnBorrar().setEnabled(true);

		}
	}

	private ImageIcon ajustarImagen(Image img, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return imagen;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowStateChanged(WindowEvent e) {
	}

	public VistaNuevoConsumo getVistaNuevoConsumo() {
		return vistaNuevoConsumo;
	}

	public void setVistaNuevoConsumo(VistaNuevoConsumo vistaNuevoConsumo) {
		this.vistaNuevoConsumo = vistaNuevoConsumo;
	}

	public DetalleConsumoDAO getDetalleConsumoDao() {
		return detalleConsumoDao;
	}

	public void setDetalleConsumoDao(DetalleConsumoDAO detalleConsumoDao) {
		this.detalleConsumoDao = detalleConsumoDao;
	}

	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}

	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}

	public ConsumoDAO getConsumoDao() {
		return consumoDao;
	}

	public void setConsumoDao(ConsumoDAO consumoDao) {
		this.consumoDao = consumoDao;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public static ControladorNuevoConsumo getControladorNuevoConsumo() {
		return controladorNuevoConsumo;
	}

	public static void setControladorNuevoConsumo(ControladorNuevoConsumo controladorNuevoConsumo) {
		ControladorNuevoConsumo.controladorNuevoConsumo = controladorNuevoConsumo;
	}

}
