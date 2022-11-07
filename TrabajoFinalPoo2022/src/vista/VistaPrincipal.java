package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controlador.ControladorVistaPrincipal;

import javax.swing.JButton;

public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	protected JPanel contentPane;
	private ControladorVistaPrincipal controlador;
	protected JButton btnNuevoConsumo, btnProveedores, btnProductos, btnGastos, btnConfiguracion, btnRegistrarUsuario,
			btnLogout;
	protected JLayeredPane panelVistas;
	private JLabel lblTitulo;

	public VistaPrincipal(ControladorVistaPrincipal controlador) {
		this.setControlador(controlador);

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(VistaInicial.class.getResource("/Imagenes/DrinkCounterLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1064, 655);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 186, 107));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null); // Para centrar

		JPanel panel_titulo = new JPanel();
		panel_titulo.setBackground(new Color(255, 220, 138));

		lblTitulo = new JLabel("DRINK COUNTER");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.GRAY);
		lblTitulo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 60));
		panel_titulo.add(lblTitulo);
		///////////////////////////////////////// BOTONES/////////////////////////////////////////
		btnProveedores = new JButton("Proveedores");
		btnProveedores.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 13));
		btnProveedores.addActionListener(getControlador());
		ImageIcon imgBtnProveedores = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Proveedores.png")).getImage(), 40, 40);
		btnProveedores.setIcon(imgBtnProveedores);

		btnProductos = new JButton("Bebidas");
		btnProductos.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 13));
		btnProductos.addActionListener(getControlador());
		ImageIcon imgBtnProductos = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Botellas.png")).getImage(), 40, 40);
		btnProductos.setIcon(imgBtnProductos);

		btnGastos = new JButton("Gastos");
		btnGastos.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 13));
		btnGastos.addActionListener(getControlador());
		ImageIcon imgBtnGastos = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Gastos.png")).getImage(), 40, 40);
		btnGastos.setIcon(imgBtnGastos);

		btnConfiguracion = new JButton("Config");
		btnConfiguracion.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 13));
		btnConfiguracion.addActionListener(getControlador());
		ImageIcon imgBtnConfiguracion = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Config.png")).getImage(), 40, 40);
		btnConfiguracion.setIcon(imgBtnConfiguracion);

		btnNuevoConsumo = new JButton("Consumo");
		btnNuevoConsumo.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 13));
		btnNuevoConsumo.addActionListener(getControlador());
		ImageIcon imgBtnNuevoConsumo = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/NuevoConsumo.png")).getImage(), 40, 40);
		btnNuevoConsumo.setIcon(imgBtnNuevoConsumo);

		panelVistas = new JLayeredPane();
		panelVistas.setBackground(new Color(255, 220, 138));

		btnRegistrarUsuario = new JButton("Nuevo Usuario");
		btnRegistrarUsuario.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 12));
		btnRegistrarUsuario.addActionListener(getControlador());
		ImageIcon imgBtnRegistrarUsuario = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/NuevoUsuario.png")).getImage(), 40, 40);
		btnRegistrarUsuario.setIcon(imgBtnRegistrarUsuario);

		btnLogout = new JButton("Cerrar Sesión");
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setBackground(new Color(204, 0, 51));
		btnLogout.setHorizontalAlignment(SwingConstants.LEADING);
		btnLogout.setFont(new Font("Cambria Math", Font.BOLD | Font.ITALIC, 13));
		btnLogout.addActionListener(getControlador());
		ImageIcon imgBtnLogout = this.ajustarImagen(
				new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Logout.png")).getImage(), 30, 30);
		btnLogout.setIcon(imgBtnLogout);
		////////////////////////////////////////////////////////////////////////////////////////
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_titulo, GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNuevoConsumo, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(btnProductos, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(btnProveedores, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(btnGastos, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(btnConfiguracion, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(btnRegistrarUsuario, 0, 0, Short.MAX_VALUE))
						.addGap(5).addComponent(panelVistas, GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(866, Short.MAX_VALUE)
						.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGap(25)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(panel_titulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnRegistrarUsuario, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnNuevoConsumo, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnProductos, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnProveedores, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnGastos, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnConfiguracion, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
								.addGap(36))
						.addComponent(panelVistas, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))));

		contentPane.setLayout(gl_contentPane);
		this.addWindowStateListener(getControlador());

	}

	protected ImageIcon ajustarImagen(Image img, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return imagen;
	}

	public JButton getBtnNuevoConsumo() {
		return btnNuevoConsumo;
	}

	public void setBtnNuevoConsumo(JButton btnNuevoConsumo) {
		this.btnNuevoConsumo = btnNuevoConsumo;
	}

	public JButton getBtnProveedores() {
		return btnProveedores;
	}

	public void setBtnProveedores(JButton btnProveedores) {
		this.btnProveedores = btnProveedores;
	}

	public JButton getBtnProductos() {
		return btnProductos;
	}

	public void setBtnProductos(JButton btnProductos) {
		this.btnProductos = btnProductos;
	}

	public JButton getBtnGastos() {
		return btnGastos;
	}

	public void setBtnGastos(JButton btnGastos) {
		this.btnGastos = btnGastos;
	}

	public JButton getBtnConfiguracion() {
		return btnConfiguracion;
	}

	public void setBtnConfiguracion(JButton btnConfiguracion) {
		this.btnConfiguracion = btnConfiguracion;
	}

	public ControladorVistaPrincipal getControlador() {
		return controlador;
	}

	public void setControlador(ControladorVistaPrincipal controlador) {
		this.controlador = controlador;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JLayeredPane getPanelVistas() {
		return panelVistas;
	}

	public void setPanelVistas(JLayeredPane panelVistas) {
		this.panelVistas = panelVistas;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public void setBtnLogout(JButton btnLogout) {
		this.btnLogout = btnLogout;
	}

	public JButton getBtnRegistrarUsuario() {
		return btnRegistrarUsuario;
	}

	public void setBtnRegistrarUsuario(JButton btnRegistrarUsuario) {
		this.btnRegistrarUsuario = btnRegistrarUsuario;
	}
}