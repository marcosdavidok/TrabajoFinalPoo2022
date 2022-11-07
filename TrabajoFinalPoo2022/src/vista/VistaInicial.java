package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorVistaInicial;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class VistaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControladorVistaInicial controlador;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	private JButton btnIngresar;
	private JLabel lblOjo;

	public VistaInicial(ControladorVistaInicial controlador) {
		this.setControlador(controlador);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(VistaInicial.class.getResource("/Imagenes/DrinkCounterLogo.png")));
		setResizable(false);

		ImageIcon imgOjo = this.ajustarImagen(
				new ImageIcon(VistaInicial.class.getResource("/Imagenes/ojoCerrado.png")).getImage(), 20, 20);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 460);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 186, 107));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);

		JPanel panel_titulo = new JPanel();
		panel_titulo.setBackground(new Color(255, 220, 138));

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 15));

		textFieldUsuario = new JTextField();
		textFieldUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldUsuario.setColumns(10);
		textFieldUsuario.addFocusListener(getControlador());

		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Dialog", Font.BOLD, 15));

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnIngresar.addActionListener(getControlador());

		passwordField = new JPasswordField();
		passwordField.setEchoChar('●');
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.addFocusListener(getControlador());
		passwordField.addKeyListener(getControlador());

		JLabel lblLoginIcon = new JLabel("");
		lblLoginIcon.setVerticalAlignment(SwingConstants.TOP);
		lblLoginIcon.setHorizontalAlignment(SwingConstants.LEFT);
		ImageIcon icono = new ImageIcon(VistaInicial.class.getResource("/Imagenes/DrinkCounterLogo.png"));
		ImageIcon iconoNuevo = new ImageIcon(icono.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
		lblLoginIcon.setIcon(iconoNuevo);

		lblOjo = new JLabel("");
		lblOjo.setIcon(imgOjo);
		lblOjo.addMouseListener(getControlador());
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_titulo, GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(98, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnIngresar, GroupLayout.PREFERRED_SIZE, 148,
												GroupLayout.PREFERRED_SIZE)
										.addGap(66))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblContraseña)
										.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 279,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldUsuario, GroupLayout.PREFERRED_SIZE, 281,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 77,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblOjo, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE).addGap(43))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(135, Short.MAX_VALUE).addComponent(lblLoginIcon).addGap(122)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(panel_titulo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblLoginIcon, GroupLayout.PREFERRED_SIZE, 200, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
						.createSequentialGroup().addComponent(lblUsuario).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textFieldUsuario, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblContraseña)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnIngresar).addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblOjo, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addGap(46)))));

		JLabel lblTitulo = new JLabel("DRINK COUNTER - LOGIN");
		lblTitulo.setForeground(Color.GRAY);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 18));
		panel_titulo.add(lblTitulo);
		contentPane.setLayout(gl_contentPane);
	}

	public ImageIcon ajustarImagen(Image img, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return imagen;
	}

	public ControladorVistaInicial getControlador() {
		return controlador;
	}

	public void setControlador(ControladorVistaInicial controlador) {
		this.controlador = controlador;
	}

	public JTextField getTextFieldUsuario() {
		return textFieldUsuario;
	}

	public void setTextFieldUsuario(JTextField textFieldUsuario) {
		this.textFieldUsuario = textFieldUsuario;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	public JLabel getLblOjo() {
		return lblOjo;
	}

	public void setLblOjo(JLabel lblOjo) {
		this.lblOjo = lblOjo;
	}

}