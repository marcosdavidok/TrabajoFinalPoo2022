package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorAgregarProducto;

public class VistaAgregarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	protected DefaultTableModel ModeloTabla;
	protected JPanel contentPane;
	private JTable table;
	private JTextField textFieldBuscar;
	private JButton btnBuscar;
	private JButton btnAgregar;
	private ControladorAgregarProducto controladorAgregarProducto;
	private JLabel lblTitulo;
	private JPanel panelTabla;

	public VistaAgregarProducto(ControladorAgregarProducto controlador) {

		setResizable(false);
		this.setControladorAgregarProducto(controlador);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1074, 655);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 186, 107));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.setLocationRelativeTo(null);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(10, 0, 1038, 41);
		contentPane.add(panelTitulo);
		panelTitulo.setBackground(new Color(255, 220, 138));
		contentPane.add(panelTitulo);

		lblTitulo = new JLabel("BUSCAR PRODUCTO");
		lblTitulo.setForeground(new Color(255, 186, 107));
		lblTitulo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 35));
		panelTitulo.add(lblTitulo);

		panelTabla = new JPanel();
		panelTabla.setBounds(10, 171, 1038, 445);
		contentPane.add(panelTabla);

		JScrollPane scrollPane = new JScrollPane();
		panelTabla.setBackground(new Color(255, 220, 138));
		///////////////////////////////////////// BOTONES/////////////////////////////////////////
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnBuscar.addActionListener(getControladorAgregarProducto());
		ImageIcon imgBtnBuscar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Buscar.png")).getImage(), 20, 20);
		btnBuscar.setIcon(imgBtnBuscar);
		textFieldBuscar = new JTextField();
		textFieldBuscar.setColumns(10);
		textFieldBuscar.addKeyListener(getControladorAgregarProducto());

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnAgregar.addActionListener(getControladorAgregarProducto());
		btnAgregar.addKeyListener(getControladorAgregarProducto());
		ImageIcon imgBtnAgregar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Nuevo.png")).getImage(), 20, 20);
		btnAgregar.setIcon(imgBtnAgregar);
		////////////////////////////////////////////////////////////////////////////////////////
		GroupLayout groupLayout = new GroupLayout(panelTabla);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup().addGap(32)
						.addComponent(textFieldBuscar, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE).addGap(18)
						.addComponent(btnBuscar).addGap(81)
						.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
						.addGap(278)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(37)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar)
								.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(39).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))

		);

		String encabezado[] = { "Codigo", "Nombre", "Cantidad", "Precio", "CUIT Proveedor" };
		this.setModeloTabla(new DefaultTableModel(null, encabezado));
		table = new JTable(this.getModeloTabla()) {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		panelTabla.setLayout(groupLayout);
		table.addMouseListener(getControladorAgregarProducto());
		this.addWindowListener(getControladorAgregarProducto());

	}

	protected ImageIcon ajustarImagen(Image img, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return imagen;
	}

	public ControladorAgregarProducto getControladorAgregarProducto() {
		return controladorAgregarProducto;
	}

	public void setControladorAgregarProducto(ControladorAgregarProducto controladorAgregarProducto) {
		this.controladorAgregarProducto = controladorAgregarProducto;
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

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnImprimir) {
		this.btnAgregar = btnImprimir;
	}
}
