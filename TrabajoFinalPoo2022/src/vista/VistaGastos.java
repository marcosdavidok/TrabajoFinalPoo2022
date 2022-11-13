package vista;

import javax.swing.table.DefaultTableModel;

import controlador.ControladorGastos;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.util.Collections;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;

public class VistaGastos extends JPanel {

	private static final long serialVersionUID = 1L;
	protected DefaultTableModel ModeloTabla;
	private JTable table;
	private JTextField textFieldBuscar;
	private JButton btnBuscar;
	private JButton btnImprimir;
	private ControladorGastos controladorGastos;
	private JButton btnInformeGastos;
	private JComboBox<String> comboBox;

	public VistaGastos(ControladorGastos controladorGastos) {

		this.setControladorVentas(controladorGastos);

		setBackground(new Color(145, 139, 173));
		setBounds(0, 0, 860, 444);

		JScrollPane scrollPane = new JScrollPane();

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnBuscar.addActionListener(getControladorVentas());
		ImageIcon imgBtnBuscar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Buscar.png")).getImage(), 20, 20);
		btnBuscar.setIcon(imgBtnBuscar);
		textFieldBuscar = new JTextField();
		textFieldBuscar.setColumns(10);
		textFieldBuscar.addKeyListener(getControladorVentas());

		btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnImprimir.addActionListener(getControladorVentas());
		ImageIcon imgBtnImprimir = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Impresora.png")).getImage(), 20, 20);
		btnImprimir.setIcon(imgBtnImprimir);

		btnInformeGastos = new JButton("INFORME GASTOS");
		btnInformeGastos.setBackground(new Color(221, 160, 221));
		btnInformeGastos.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnInformeGastos.addActionListener(getControladorVentas());
		ImageIcon imgBtnInformeVta = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Factura.png")).getImage(), 20, 20);
		btnInformeGastos.setIcon(imgBtnInformeVta);

		JLabel lblBuscarPor = new JLabel("Buscar Por:");
		lblBuscarPor.setFont(new Font("Comic Sans MS", Font.BOLD, 12));

		comboBox = new JComboBox<String>();
		Vector<String> nombres = new Vector<String>();
		nombres.add("Fecha");
		nombres.add("Encargado");
		comboBox.setModel(new DefaultComboBoxModel<>(nombres));
		Collections.sort(nombres);
		comboBox.setModel(new DefaultComboBoxModel<>(nombres));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(31)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblBuscarPor).addGap(18)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldBuscar, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
				.addGap(18).addComponent(btnBuscar).addGap(76)
				.addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE).addGap(85)
				.addComponent(btnInformeGastos, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE).addGap(32))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(22)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblBuscarPor).addComponent(
						comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInformeGastos, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
				.addContainerGap()));

		String header[] = { "Nro Gasto", "Fecha", "Encargado", "Total" };
		this.setModeloTabla(new DefaultTableModel(null, header));
		table = new JTable(this.getModeloTabla());
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		this.setLayout(groupLayout);
		table.addMouseListener(getControladorVentas());

	}

	protected ImageIcon ajustarImagen(Image img, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return imagen;
	}

	public ControladorGastos getControladorVentas() {
		return controladorGastos;
	}

	public void setControladorVentas(ControladorGastos controladorGastos) {
		this.controladorGastos = controladorGastos;
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

	public JButton getBtnImprimir() {
		return btnImprimir;
	}

	public void setBtnImprimir(JButton btnImprimir) {
		this.btnImprimir = btnImprimir;
	}

	public JButton getBtnInformeGastos() {
		return btnInformeGastos;
	}

	public void setBtnInformeGastos(JButton btnInformeGastos) {
		this.btnInformeGastos = btnInformeGastos;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}
}
