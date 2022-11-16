package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.ControladorVistaNuevoUsuario;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class VistaNuevoUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControladorVistaNuevoUsuario controladorU;
	private JTextField textFieldUsuario;
	private JPasswordField passwordFieldContraseña;
	private JPasswordField passwordFieldConfirmar;
	private JButton btnRegistrar;
	private JComboBox<String> comboBox;
	public static VistaNuevoUsuario vistaNU;
	private JLabel lblOjo;
	private JLabel lblOjoConfirmar;

	public VistaNuevoUsuario(ControladorVistaNuevoUsuario controladorU) {
		setControladorU(controladorU);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 510);
		this.setLocationRelativeTo(null);
		ImageIcon imgOjo = this.ajustarImagen(
				new ImageIcon(VistaNuevoUsuario.class.getResource("/Imagenes/ojoCerrado.png")).getImage(), 20, 20);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(188, 180, 224));
		JLabel lblLoginIcon = new JLabel("");
		lblLoginIcon.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoginIcon.setBounds(140, 32, 193, 167);
		contentPane.add(lblLoginIcon);
		ImageIcon icono = new ImageIcon(VistaNuevoUsuario.class.getResource("/Imagenes/DrinkCounterLogo.png"));
		ImageIcon iconoNuevo = new ImageIcon(icono.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
		lblLoginIcon.setIcon(iconoNuevo);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);

		JPanel panel_titulo = new JPanel();
		panel_titulo.setBackground(new Color(145, 139, 173));
		panel_titulo.setBounds(0, 0, 451, 32);
		contentPane.add(panel_titulo);

		JLabel lblTitulo = new JLabel("DRINK COUNTER - NUEVO USUARIO");
		lblTitulo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblTitulo.setForeground(new Color(47, 45, 56));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

		GroupLayout gl_panel_titulo = new GroupLayout(panel_titulo);
		gl_panel_titulo.setHorizontalGroup(gl_panel_titulo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_titulo.createSequentialGroup().addGap(56).addComponent(lblTitulo)));
		gl_panel_titulo.setVerticalGroup(gl_panel_titulo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_titulo.createSequentialGroup().addGap(5).addComponent(lblTitulo)));
		panel_titulo.setLayout(gl_panel_titulo);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(47, 45, 56));
		lblUsuario.setBounds(137, 210, 67, 14);
		contentPane.add(lblUsuario);
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 16));

		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(214, 209, 183, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		textFieldUsuario.addFocusListener(getControladorU());

		JLabel lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setForeground(new Color(47, 45, 56));
		lblContrasenia.setBounds(106, 260, 98, 14);
		contentPane.add(lblContrasenia);
		lblContrasenia.setFont(new Font("Dialog", Font.BOLD, 16));

		JLabel lblConfirmar = new JLabel("Confirmar Contraseña:");
		lblConfirmar.setForeground(new Color(47, 45, 56));
		lblConfirmar.setBounds(23, 309, 181, 14);
		contentPane.add(lblConfirmar);
		lblConfirmar.setFont(new Font("Dialog", Font.BOLD, 16));

		passwordFieldContraseña = new JPasswordField();
		passwordFieldContraseña.setEchoChar('●');
		passwordFieldContraseña.setColumns(10);
		passwordFieldContraseña.setBounds(214, 259, 183, 20);
		contentPane.add(passwordFieldContraseña);
		passwordFieldContraseña.addFocusListener(getControladorU());

		passwordFieldConfirmar = new JPasswordField();
		passwordFieldConfirmar.setEchoChar('●');
		passwordFieldConfirmar.setColumns(10);
		passwordFieldConfirmar.setBounds(214, 307, 183, 20);
		contentPane.add(passwordFieldConfirmar);
		passwordFieldConfirmar.addFocusListener(getControladorU());

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(136, 115, 230));
		btnRegistrar.setForeground(new Color(47, 45, 56));
		btnRegistrar.setBounds(166, 422, 117, 23);
		btnRegistrar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnRegistrar.addActionListener(getControladorU());
		contentPane.add(btnRegistrar);

		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		comboBox.setBounds(214, 361, 183, 20);
		contentPane.add(comboBox);

		JLabel lblTipoDeUsuario = new JLabel("Tipo de Usuario:");
		lblTipoDeUsuario.setForeground(new Color(47, 45, 56));
		lblTipoDeUsuario.setBounds(73, 363, 131, 14);
		contentPane.add(lblTipoDeUsuario);
		lblTipoDeUsuario.setFont(new Font("Dialog", Font.BOLD, 16));

		lblOjo = new JLabel("");
		lblOjo.setIcon(imgOjo);
		lblOjo.setBounds(401, 262, 29, 14);
		lblOjo.addMouseListener(getControladorU());
		contentPane.add(lblOjo);

		lblOjoConfirmar = new JLabel("");
		lblOjoConfirmar.setIcon(imgOjo);
		lblOjoConfirmar.setBounds(401, 309, 29, 14);
		contentPane.add(lblOjoConfirmar);
		lblOjoConfirmar.addMouseListener(getControladorU());
		this.addWindowListener(getControladorU());

	}

	public ImageIcon ajustarImagen(Image img, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return imagen;
	}

	public ControladorVistaNuevoUsuario getControladorU() {
		return controladorU;
	}

	public void setControladorU(ControladorVistaNuevoUsuario controladorU) {
		this.controladorU = controladorU;
	}

	public JTextField getTextFieldUsuario() {
		return textFieldUsuario;
	}

	public void setTextFieldUsuario(JTextField textFieldUsuario) {
		this.textFieldUsuario = textFieldUsuario;
	}

	public JPasswordField getPasswordFieldContraseña() {
		return passwordFieldContraseña;
	}

	public void setPasswordFieldContraseña(JPasswordField passwordFieldContraseña) {
		this.passwordFieldContraseña = passwordFieldContraseña;
	}

	public JPasswordField getPasswordFieldConfirmar() {
		return passwordFieldConfirmar;
	}

	public void setPasswordFieldConfirmar(JPasswordField passwordFieldConfirmar) {
		this.passwordFieldConfirmar = passwordFieldConfirmar;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public static VistaNuevoUsuario getVistaNU() {
		return vistaNU;
	}

	public static void setVistaNU(VistaNuevoUsuario vistaNU) {
		VistaNuevoUsuario.vistaNU = vistaNU;
	}

	public JLabel getLblOjo() {
		return lblOjo;
	}

	public void setLblOjo(JLabel lblOjo) {
		this.lblOjo = lblOjo;
	}

	public JLabel getLblOjoConfirmar() {
		return lblOjoConfirmar;
	}

	public void setLblOjoConfirmar(JLabel lblOjoConfirmar) {
		this.lblOjoConfirmar = lblOjoConfirmar;
	}

}
