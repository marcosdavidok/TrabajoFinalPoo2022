package vista;

import controlador.ControladorConfig;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class VistaConfig extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldRazonSocial, textFieldCodigoPostal, textFieldLocalidad, textFieldDireccion,
			textFieldTelefono;
	private JButton btnGuardar, btnLimpiar;
	private ControladorConfig controlador;

	public VistaConfig(ControladorConfig controlador) {

		this.setControlador(controlador);

		setBackground(new Color(145, 139, 173));
		setBounds(0, 0, 858, 444);

		///////////////////////////////////////// BOTONES/////////////////////////////////////////
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		ImageIcon imgBtnLimpiar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Limpiar.png")).getImage(), 20, 20);
		btnLimpiar.setIcon(imgBtnLimpiar);
		this.btnLimpiar.addActionListener(getControlador());

		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		ImageIcon imgBtnGuardar = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Guardar.png")).getImage(), 20, 20);
		btnGuardar.setIcon(imgBtnGuardar);
		this.btnGuardar.addActionListener(getControlador());
		////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblRazonSocial = new JLabel("Razon social");
		lblRazonSocial.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldRazonSocial = new JTextField();
		textFieldRazonSocial.setColumns(10);

		JLabel lblCodigoPostal = new JLabel("Código postal");
		lblCodigoPostal.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldCodigoPostal = new JTextField();
		textFieldCodigoPostal.setColumns(10);

		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldLocalidad = new JTextField();
		textFieldLocalidad.setColumns(10);

		JLabel lblDireccion = new JLabel("Dirección");
		lblDireccion.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);

		JLabel lblTelefono = new JLabel("Teléfono");
		lblTelefono.setFont(new Font("Dialog", Font.BOLD, 14));
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap(87, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTelefono, Alignment.TRAILING).addComponent(lblRazonSocial, Alignment.TRAILING)
						.addComponent(lblCodigoPostal, Alignment.TRAILING))
				.addGap(37)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldRazonSocial, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
								.addComponent(textFieldCodigoPostal, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 183,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, 127,
												GroupLayout.PREFERRED_SIZE))
								.addGap(28)))
				.addGap(89).addGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										groupLayout
												.createSequentialGroup()
												.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 183,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
										.createParallelGroup(Alignment.TRAILING).addComponent(lblLocalidad)
										.addComponent(lblDireccion))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(29).addComponent(
														textFieldLocalidad, GroupLayout.DEFAULT_SIZE, 172,
														Short.MAX_VALUE))
												.addGroup(groupLayout.createSequentialGroup().addGap(36).addComponent(
														textFieldDireccion, GroupLayout.DEFAULT_SIZE, 165,
														Short.MAX_VALUE)))
										.addGap(69)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(45)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblRazonSocial)
								.addComponent(textFieldRazonSocial, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLocalidad).addComponent(textFieldLocalidad, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(49)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblCodigoPostal)
								.addComponent(textFieldCodigoPostal, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDireccion).addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(45)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblTelefono)
								.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(108)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnLimpiar)
								.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGap(105)));
		this.setLayout(groupLayout);

	}

	private ImageIcon ajustarImagen(Image img, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return imagen;
	}

	public JTextField getTextFieldCodigoPostal() {
		return textFieldCodigoPostal;
	}

	public void setTextFieldCodigoPostal(JTextField textFieldCodigoPostal) {
		this.textFieldCodigoPostal = textFieldCodigoPostal;
	}

	public JTextField getTextFieldDireccion() {
		return textFieldDireccion;
	}

	public void setTextFieldDireccion(JTextField textFieldDireccion) {
		this.textFieldDireccion = textFieldDireccion;
	}

	public JTextField getTextFieldRazonSocial() {
		return textFieldRazonSocial;
	}

	public void setTextFieldRazonSocial(JTextField textFieldRazonSocial) {
		this.textFieldRazonSocial = textFieldRazonSocial;
	}

	public JTextField getTextFieldLocalidad() {
		return textFieldLocalidad;
	}

	public void setTextFieldLocalidad(JTextField textFieldLocalidad) {
		this.textFieldLocalidad = textFieldLocalidad;
	}

	public JTextField getTextFieldTelefono() {
		return textFieldTelefono;
	}

	public void setTextFieldTelefono(JTextField textFieldTelefono) {
		this.textFieldTelefono = textFieldTelefono;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public ControladorConfig getControlador() {
		return controlador;
	}

	public void setControlador(ControladorConfig controlador) {
		this.controlador = controlador;
	}
}
