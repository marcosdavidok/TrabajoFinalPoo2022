package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

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
	protected JButton btnNuevoConsumo;
	protected JButton btnProveedores;
	protected JButton btnProductos;
	protected JButton btnGastos;
	protected JButton btnConfiguracion;
	protected JLayeredPane panelVistas;
	private JLabel lblTitulo;

	public VistaPrincipal(ControladorVistaPrincipal controlador) {
		this.setControlador(controlador);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1064, 655);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 186, 107));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null); // Para centrar

		JPanel panel_titulo = new JPanel();
		panel_titulo.setBackground(new Color(255, 220, 138));

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
		////////////////////////////////////////////////////////////////////////////////////////

		lblTitulo = new JLabel("SISTEMA DE GASTOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255, 186, 107));
		lblTitulo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 60));
		panel_titulo.add(lblTitulo);

		panelVistas = new JLayeredPane();
		panelVistas.setBackground(new Color(255, 220, 138));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNuevoConsumo, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnProductos, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnProveedores, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGastos, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConfiguracion, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
				.addGap(5).addComponent(panelVistas, GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE))
				.addComponent(panel_titulo, GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(
						panel_titulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(66)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(27)
								.addComponent(btnNuevoConsumo, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnProductos, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnProveedores, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnGastos, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnConfiguracion, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
								.addGap(36))
						.addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelVistas, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)))));

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

}