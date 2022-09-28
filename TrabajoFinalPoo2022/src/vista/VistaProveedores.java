package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorProveedores;

public class VistaProveedores extends JPanel {
	private static final long serialVersionUID = 1L;
	private ControladorProveedores controladorProveedor;
	protected JTable table;
	private JLabel lblCuit, lblNombre, lblDireccion, lblTelefono, lblRazonSocial;
	private JButton btnGuardar, btnLimpiar, btnModificar, btnEliminar, btnImprimir, btnBuscar;
	private JTextField textFieldCuit, textFieldNombre, textFieldDireccion, textFieldTelefono, textFieldRazonSocial,
			textFieldBuscar;

	protected DefaultTableModel ModeloTabla;

	public VistaProveedores(ControladorProveedores controladorProveedor) {

		this.setControladorProveedor(controladorProveedor);
		setBackground(new Color(255, 220, 138));
		setBounds(0, 0, 858, 444);

		JScrollPane scrollPane = new JScrollPane();
		///////////////////////////////////////// BOTONES/////////////////////////////////////////
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBackground(new Color(51, 204, 51));
		btnGuardar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnGuardar.addActionListener(getControladorProveedor());
		ImageIcon imgBtnGuardar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Guardar.png")).getImage(), 20, 20);
		btnGuardar.setIcon(imgBtnGuardar);

		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnLimpiar.addActionListener(getControladorProveedor());
		ImageIcon imgBtnLimpiar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Limpiar.png")).getImage(), 20, 20);
		btnLimpiar.setIcon(imgBtnLimpiar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnModificar.addActionListener(getControladorProveedor());
		ImageIcon imgBtnModificar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Modificar.png")).getImage(), 20, 20);
		btnModificar.setIcon(imgBtnModificar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBackground(UIManager.getColor("Button.background"));
		btnEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnEliminar.addActionListener(getControladorProveedor());
		ImageIcon imgBtnEliminar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Eliminar.png")).getImage(), 20, 20);
		btnEliminar.setIcon(imgBtnEliminar);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnBuscar.addActionListener(getControladorProveedor());
		ImageIcon imgBtnBuscar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Buscar.png")).getImage(), 20, 20);
		btnBuscar.setIcon(imgBtnBuscar);
		textFieldBuscar = new JTextField();
		textFieldBuscar.setColumns(10);
		textFieldBuscar.addKeyListener(getControladorProveedor());

		btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnImprimir.addActionListener(getControladorProveedor());
		ImageIcon imgBtnImprimir = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Impresora.png")).getImage(), 20, 20);
		btnImprimir.setIcon(imgBtnImprimir);
		////////////////////////////////////////////////////////////////////////////////////////

		lblCuit = new JLabel("CUIT");
		lblCuit.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 13));
		textFieldCuit = new JTextField();
		textFieldCuit.setColumns(10);
		textFieldCuit.addFocusListener(getControladorProveedor());
		textFieldCuit.addKeyListener(getControladorProveedor());

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 13));
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.addFocusListener(getControladorProveedor());
		textFieldNombre.addKeyListener(getControladorProveedor());

		lblDireccion = new JLabel("Dirección");
		lblDireccion.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 13));
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.addFocusListener(getControladorProveedor());

		lblTelefono = new JLabel("Teléfono");
		lblTelefono.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 13));
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.addFocusListener(getControladorProveedor());
		textFieldTelefono.addKeyListener(getControladorProveedor());

		lblRazonSocial = new JLabel("Razón Social");
		lblRazonSocial.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 13));
		textFieldRazonSocial = new JTextField();
		textFieldRazonSocial.setColumns(10);
		textFieldRazonSocial.addFocusListener(getControladorProveedor());

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 123,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnModificar)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnEliminar)
										.addGap(46).addComponent(btnImprimir))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(textFieldBuscar, GroupLayout.PREFERRED_SIZE, 245,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnBuscar,
												GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldCuit, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCuit))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 119,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE, 119,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDireccion, GroupLayout.PREFERRED_SIZE, 85,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, 119,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 88,
												GroupLayout.PREFERRED_SIZE))
								.addGap(6)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textFieldRazonSocial).addComponent(lblRazonSocial,
												GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDireccion, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCuit)
								.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRazonSocial, GroupLayout.PREFERRED_SIZE, 17,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldCuit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldRazonSocial, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false).addComponent(btnGuardar)
								.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(15).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
						.addContainerGap()));

		String header[] = { "CUIT", "Nombre", "Telefono", "Direccion", "Razon Social" };
		this.setModeloTabla(new DefaultTableModel(null, header));
		table = new JTable(this.getModeloTabla()) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		table.setAutoCreateRowSorter(true);
		table.addFocusListener(getControladorProveedor());
		scrollPane.setViewportView(table);
		this.setLayout(groupLayout);
		table.addMouseListener(getControladorProveedor());
	}

	private ImageIcon ajustarImagen(Image img, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return imagen;
	}

	public JButton getBtnImprimir() {
		return btnImprimir;
	}

	public void setBtnImprimir(JButton btnImprimir) {
		this.btnImprimir = btnImprimir;
	}

	public DefaultTableModel getModeloTabla() {
		return ModeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		ModeloTabla = modeloTabla;
	}

	public JTextField getTextFieldDireccion() {
		return textFieldDireccion;
	}

	public void setTextFieldDireccion(JTextField textFieldDireccion) {
		this.textFieldDireccion = textFieldDireccion;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTextFieldCuit() {
		return textFieldCuit;
	}

	public void setTextFieldCuit(JTextField textFieldCuit) {
		this.textFieldCuit = textFieldCuit;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}

	public JTextField getTextFieldTelefono() {
		return textFieldTelefono;
	}

	public void setTextFieldTelefono(JTextField textFieldTelefono) {
		this.textFieldTelefono = textFieldTelefono;
	}

	public JTextField getTextFieldRazonSocial() {
		return textFieldRazonSocial;
	}

	public void setTextFieldRazonSocial(JTextField textFieldRazonSocial) {
		this.textFieldRazonSocial = textFieldRazonSocial;
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

	public JTextField getTextFieldBuscar() {
		return textFieldBuscar;
	}

	public void setTextFieldBuscar(JTextField textFieldBuscar) {
		this.textFieldBuscar = textFieldBuscar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public ControladorProveedores getControladorProveedor() {
		return controladorProveedor;
	}

	public void setControladorProveedor(ControladorProveedores controladorProveedor) {
		this.controladorProveedor = controladorProveedor;
	}

}
