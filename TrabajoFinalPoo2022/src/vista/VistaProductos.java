package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorProductos;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

public class VistaProductos extends JPanel {

	private static final long serialVersionUID = 1L;
	protected JTable table;
	protected DefaultTableModel ModeloTabla;
	private JButton btnGuardar, btnLimpiar, btnModificar, btnEliminar, btnBuscarProveedor, btnBuscarProducto,
			btnImprimir;
	protected JTextField textFieldCantidad, textFieldPrecio, textFieldNombre, textFieldBuscar, textFieldProveedor;
	private JLabel lblNombre, lblCantidad, lblPrecio, lblProveedor;

	private ControladorProductos controladorProductos;

	public VistaProductos(ControladorProductos controladorProductos) {
		this.setControladorProductos(controladorProductos);

		setBackground(new Color(255, 220, 138));
		setBounds(0, 0, 860, 444);
		JScrollPane scrollPane = new JScrollPane();

		///////////////////////////////////////// BOTONES/////////////////////////////////////////
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBackground(new Color(102, 204, 51));
		btnGuardar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnGuardar.addActionListener(getControladorProductos());
		ImageIcon imgBtnGuardar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Guardar.png")).getImage(), 20, 20);
		btnGuardar.setIcon(imgBtnGuardar);

		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnLimpiar.addActionListener(getControladorProductos());
		ImageIcon imgBtnLimpiar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Limpiar.png")).getImage(), 20, 20);
		btnLimpiar.setIcon(imgBtnLimpiar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnModificar.addActionListener(getControladorProductos());
		ImageIcon imgBtnModificar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Modificar.png")).getImage(), 20, 20);
		btnModificar.setIcon(imgBtnModificar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBackground(UIManager.getColor("Button.background"));
		btnEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnEliminar.addActionListener(getControladorProductos());
		ImageIcon imgBtnEliminar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Eliminar.png")).getImage(), 20, 20);
		btnEliminar.setIcon(imgBtnEliminar);

		btnBuscarProveedor = new JButton("BUSCAR");
		btnBuscarProveedor.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnBuscarProveedor.addActionListener(getControladorProductos());
		ImageIcon imgBtnBuscar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Buscar.png")).getImage(), 20, 20);
		btnBuscarProveedor.setIcon(imgBtnBuscar);

		btnBuscarProducto = new JButton("BUSCAR");
		btnBuscarProducto.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnBuscarProducto.addActionListener(getControladorProductos());
		btnBuscarProducto.setIcon(imgBtnBuscar);
		textFieldBuscar = new JTextField();
		textFieldBuscar.setColumns(10);
		textFieldBuscar.addKeyListener(getControladorProductos());

		btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnImprimir.addActionListener(getControladorProductos());
		ImageIcon imgBtnImprimir = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Impresora.png")).getImage(), 20, 20);
		btnImprimir.setIcon(imgBtnImprimir);
		////////////////////////////////////////////////////////////////////////////////////////

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.addFocusListener(getControladorProductos());
		textFieldNombre.addKeyListener(getControladorProductos());

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldCantidad = new JTextField();
		textFieldCantidad.setColumns(10);
		textFieldCantidad.addFocusListener(getControladorProductos());
		textFieldCantidad.addKeyListener(getControladorProductos());

		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.addFocusListener(getControladorProductos());
		textFieldPrecio.addKeyListener(getControladorProductos());

		lblProveedor = new JLabel("Proveedor");
		lblProveedor.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldProveedor = new JTextField();
		textFieldProveedor.setColumns(10);
		textFieldProveedor.setEnabled(false);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addComponent(btnGuardar)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnLimpiar,
														GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 119,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 89,
																GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 85,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldCantidad, GroupLayout.PREFERRED_SIZE,
																119, GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(
										Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addComponent(btnModificar)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnEliminar))
										.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING)
												.addComponent(textFieldPrecio, GroupLayout.PREFERRED_SIZE, 119,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lblPrecio, GroupLayout.PREFERRED_SIZE, 88,
														GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(textFieldProveedor,
																		GroupLayout.PREFERRED_SIZE, 105,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnBuscarProveedor))
														.addComponent(lblProveedor, GroupLayout.PREFERRED_SIZE, 93,
																GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
								.addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(78))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(textFieldBuscar, GroupLayout.PREFERRED_SIZE, 244,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnBuscarProducto, GroupLayout.PREFERRED_SIZE, 124,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(Alignment.TRAILING,
								groupLayout.createSequentialGroup()
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
										.addContainerGap()))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscarProducto, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProveedor, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldProveedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscarProveedor, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGuardar)
						.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGap(15).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE).addGap(6)));

		String encabezado[] = { "Codigo", "Nombre", "Cantidad", "Precio", "CUIT Proveedor" };
		this.setModeloTabla(new DefaultTableModel(null, encabezado));
		table = new JTable(this.getModeloTabla()) {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		table.setAutoCreateRowSorter(true);
		table.addFocusListener(getControladorProductos());
		scrollPane.setViewportView(table);
		this.setLayout(groupLayout);
		table.addMouseListener(getControladorProductos());

	}

	private ImageIcon ajustarImagen(Image img, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return imagen;
	}

	public DefaultTableModel getModeloTabla() {
		return ModeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		ModeloTabla = modeloTabla;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public ControladorProductos getControladorProductos() {
		return controladorProductos;
	}

	public void setControladorProductos(ControladorProductos controladorProductos) {
		this.controladorProductos = controladorProductos;
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

	public JButton getBtnImprimir() {
		return btnImprimir;
	}

	public void setBtnImprimir(JButton btnImprimir) {
		this.btnImprimir = btnImprimir;
	}

	public JButton getBtnBuscarProveedor() {
		return btnBuscarProveedor;
	}

	public void setBtnBuscarProveedor(JButton btnBuscar) {
		this.btnBuscarProveedor = btnBuscar;
	}

	public JTextField getTextFieldProveedor() {
		return textFieldProveedor;
	}

	public void setTextFieldProveedor(JTextField textFieldProveedor) {
		this.textFieldProveedor = textFieldProveedor;
	}

	public JTextField getTextFieldBuscar() {
		return textFieldBuscar;
	}

	public void setTextFieldBuscar(JTextField textFieldBuscar) {
		this.textFieldBuscar = textFieldBuscar;
	}

	public JButton getBtnBuscarProducto() {
		return btnBuscarProducto;
	}

	public void setBtnBuscarProducto(JButton btnBuscarProducto) {
		this.btnBuscarProducto = btnBuscarProducto;
	}
}