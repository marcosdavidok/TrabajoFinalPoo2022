package vista;

import controlador.ControladorNuevoConsumo;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.Color;

public class VistaNuevoConsumo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnAgregar, btnLimpiar, btnBorrar, btnBuscar, btnRegistrar;
	private JTextField textFieldCodigo, textFieldCantidad, textFieldPrecio, textFieldStock, textFieldProducto;
	private DefaultTableModel modeloTabla;
	private JLabel lblTotalAPagar, lblPrecioTotal;
	private JTable table;
	private ControladorNuevoConsumo controlador;

	public VistaNuevoConsumo(ControladorNuevoConsumo controlador) {
		this.setControlador(controlador);

		setBackground(new Color(255, 220, 138));
		setBounds(0, 0, 860, 444);

		///////////////////////////////////////// BOTONES/////////////////////////////////////////
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this.getControlador());
		btnLimpiar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnLimpiar.addActionListener(getControlador());
		ImageIcon imgBtnLimpiar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Limpiar.png")).getImage(), 20, 20);
		btnLimpiar.setIcon(imgBtnLimpiar);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(getControlador());
		btnAgregar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		ImageIcon imgBtnAgregar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Nuevo.png")).getImage(), 20, 20);
		btnAgregar.setIcon(imgBtnAgregar);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnRegistrar.addActionListener(this.getControlador());
		ImageIcon imgBtnRegistrar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Impresora.png")).getImage(), 20, 20);
		btnRegistrar.setIcon(imgBtnRegistrar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(new Color(189, 0, 3));
		btnBorrar.setForeground(Color.BLACK);
		btnBorrar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		ImageIcon imgBtnBorrar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Eliminar.png")).getImage(), 20, 20);
		btnBorrar.setIcon(imgBtnBorrar);
		btnBorrar.addActionListener(getControlador());

		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnBuscar.addActionListener(getControlador());
		ImageIcon imgBtnBuscar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Buscar.png")).getImage(), 20, 20);
		btnBuscar.setIcon(imgBtnBuscar);
		////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldCodigo = new JTextField();
		textFieldCodigo.addKeyListener(this.getControlador());
		textFieldCodigo.addFocusListener(this.getControlador());
		textFieldCodigo.setColumns(10);

		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldProducto = new JTextField();
		textFieldProducto.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		textFieldProducto.addMouseListener(getControlador());
		textFieldProducto.addActionListener(getControlador());

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldCantidad = new JTextField();
		textFieldCantidad.addFocusListener(this.getControlador());
		textFieldCantidad.addKeyListener(this.getControlador());
		textFieldCantidad.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldPrecio = new JTextField();
		textFieldPrecio.setEditable(false); // para que no se pueda editar ya que es lo asignado por el proveedor
		textFieldPrecio.setColumns(10);
		textFieldPrecio.addKeyListener(getControlador());

		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldStock = new JTextField();
		textFieldStock.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();

		lblTotalAPagar = new JLabel("Total a Pagar:");
		lblTotalAPagar.setFont(new Font("Dialog", Font.BOLD, 14));

		lblPrecioTotal = new JLabel("0");

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(39)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblCodigo, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE).addGap(18)
								.addComponent(lblProducto, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE).addGap(90)
								.addComponent(lblCantidad, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE).addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(textFieldCodigo, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textFieldProducto, 0, 122, Short.MAX_VALUE).addGap(45)
								.addComponent(textFieldCantidad, GroupLayout.PREFERRED_SIZE, 69,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26)))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblPrecio, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE).addGap(47))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(textFieldPrecio, GroupLayout.PREFERRED_SIZE, 66,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(textFieldStock, GroupLayout.PREFERRED_SIZE, 62,
										GroupLayout.PREFERRED_SIZE)
								.addGap(21))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblStock, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(btnAgregar, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBorrar, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(btnLimpiar, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
				.addGap(45))
				.addGroup(groupLayout.createSequentialGroup().addGap(12)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE).addContainerGap())
				.addGroup(groupLayout.createSequentialGroup().addGap(150)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRegistrar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 209,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblTotalAPagar)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblPrecioTotal,
												GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(20)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblCodigo)
										.addComponent(lblCantidad).addComponent(lblPrecio).addComponent(lblStock)
										.addComponent(lblProducto))
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldStock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLimpiar).addComponent(btnAgregar).addComponent(textFieldProducto,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING,
										groupLayout.createSequentialGroup().addComponent(btnRegistrar).addGap(21))
								.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblPrecioTotal, GroupLayout.PREFERRED_SIZE, 17,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblTotalAPagar))
										.addGap(57)))));

		this.setLayout(groupLayout);

		String encabezado[] = { "Código", "Nombre", "Cantidad", "Precio", "Total" };
		this.setModeloTabla(new DefaultTableModel(null, encabezado));
		table = new JTable(this.getModeloTabla()) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				if (column == 4) {
					return true;
				} else {
					return false;
				}
			};

		};

		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);

		scrollPane.setViewportView(table);

	}

	private ImageIcon ajustarImagen(Image img, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return imagen;
	}

	public JTextField getTextFieldCodigo() {
		return textFieldCodigo;
	}

	public void setTextFieldCodigo(JTextField textFieldCodigo) {
		this.textFieldCodigo = textFieldCodigo;
	}

	public JTextField getTextFieldCantidad() {
		return textFieldCantidad;
	}

	public void setTextFieldCantidad(JTextField textFieldCantidad) {
		this.textFieldCantidad = textFieldCantidad;
	}

	public JTextField getTextFieldPrecio() {
		return textFieldPrecio;
	}

	public void setTextFieldPrecio(JTextField textFieldPrecio) {
		this.textFieldPrecio = textFieldPrecio;
	}

	public JTextField getTextFieldStock() {
		return textFieldStock;
	}

	public void setTextFieldStock(JTextField textFieldStock) {
		this.textFieldStock = textFieldStock;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	public JLabel getLblPrecioTotal() {
		return lblPrecioTotal;
	}

	public void setLblPrecioTotal(JLabel lblPrecioTotal) {
		this.lblPrecioTotal = lblPrecioTotal;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public JTextField getTextFieldProducto() {
		return textFieldProducto;
	}

	public void setTextFieldProducto(JTextField textFieldProducto) {
		this.textFieldProducto = textFieldProducto;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public ControladorNuevoConsumo getControlador() {
		return controlador;
	}

	public void setControlador(ControladorNuevoConsumo controlador) {
		this.controlador = controlador;
	}

}
