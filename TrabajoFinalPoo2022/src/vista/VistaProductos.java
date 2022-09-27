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
//import javax.swing.UIManager;

public class VistaProductos extends JPanel {

	private static final long serialVersionUID = 1L;
	protected JTable table;

	private JTextField textFieldNombre;
	protected JTextField textFieldCantidad;
	private JTextField textFieldPrecio;
	protected DefaultTableModel ModeloTabla;

	private JLabel lblNombre;
	private JLabel lblCantidad;
	private JLabel lblPrecio;
	private JLabel lblProveedor;
	private ControladorProductos controladorProductos;
	private JButton btnAñadir, btnNuevo, btnModificar, btnEliminar;
	private JButton btnBuscarProveedor;
	private JTextField textFieldProveedor;

	public VistaProductos(ControladorProductos controladorProductos) {
		this.setControladorProductos(controladorProductos);

		setBackground(new Color(255, 220, 138));
		setBounds(0, 0, 860, 444);

		JScrollPane scrollPane = new JScrollPane();

		ImageIcon imgBtnGuardar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Guardar.png")).getImage(), 20, 20);
		ImageIcon imgBtnEliminar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Eliminar.png")).getImage(), 20, 20);
		ImageIcon imgBtnNuevo = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Limpiar.png")).getImage(), 20, 20);
		ImageIcon imgBtnModificar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Modificar.png")).getImage(), 20, 20);
		ImageIcon imgBtnBuscar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Buscar.png")).getImage(), 20, 20);

		btnAñadir = new JButton("AÑADIR");
		btnAñadir.setBackground(new Color(102, 204, 51));
		btnAñadir.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnAñadir.addActionListener(getControladorProductos());
		btnAñadir.setIcon(imgBtnGuardar);
		
		btnNuevo = new JButton("NUEVO ");
		btnNuevo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNuevo.addActionListener(getControladorProductos());
		btnNuevo.setIcon(imgBtnNuevo);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnModificar.addActionListener(getControladorProductos());
		btnModificar.setIcon(imgBtnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnEliminar.addActionListener(getControladorProductos());
		btnEliminar.setIcon(imgBtnEliminar);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 13));

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 13));

		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 13));

		lblProveedor = new JLabel("Proveedor");
		lblProveedor.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 13));

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.addFocusListener(getControladorProductos());
		textFieldNombre.addKeyListener(getControladorProductos());
		textFieldCantidad = new JTextField();
		textFieldCantidad.setColumns(10);
		textFieldCantidad.addFocusListener(getControladorProductos());
		textFieldCantidad.addKeyListener(getControladorProductos());

		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.addFocusListener(getControladorProductos());
		textFieldPrecio.addKeyListener(getControladorProductos());

		btnBuscarProveedor = new JButton("BUSCAR");
		btnBuscarProveedor.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnBuscarProveedor.addActionListener(getControladorProductos());
		btnBuscarProveedor.setIcon(imgBtnBuscar);

		textFieldProveedor = new JTextField();
		textFieldProveedor.setColumns(10);
		textFieldProveedor.setEnabled(false);
		;

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addComponent(btnAñadir)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNuevo,
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
										.addGroup(groupLayout.createSequentialGroup().addGroup(
												groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(textFieldPrecio, GroupLayout.PREFERRED_SIZE, 119,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 88,
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
																GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
								.addContainerGap()))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(52)
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
								.addComponent(btnBuscarProveedor, GroupLayout.PREFERRED_SIZE, 24,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnAñadir)
								.addComponent(btnNuevo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(15).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
						.addGap(6)));

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
		ImageIcon img2 = new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return img2;
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

	public JButton getBtnAñadir() {
		return btnAñadir;
	}

	public void setBtnAñadir(JButton btnAñadir) {
		this.btnAñadir = btnAñadir;
	}

	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	public void setBtnNuevo(JButton btnNuevo) {
		this.btnNuevo = btnNuevo;
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

}
