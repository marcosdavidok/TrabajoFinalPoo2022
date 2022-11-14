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




	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
	
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
	
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
