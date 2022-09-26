package vista;


import java.awt.Color;
import java.awt.Font;
import controlador.ControladorConfig;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaBebida extends JPanel {
	private JTextField textFieldNombre;
	private JTextField textFieldCantidad;
	private JTextField textFieldPrecio;
	private JTextField textFieldProveedor;
	private JTable table;
	private ControladorConfig controlador;

	
	public VistaBebida(ControladorConfig controlador) {

		this.setControlador(controlador);

		setBackground(new Color(255, 220, 138));
		setBounds(0, 0, 858, 444);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 14));
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		
		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setFont(new Font("Dialog", Font.BOLD, 14));
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setColumns(10);
		
		JLabel lblPrecio = new JLabel("PRECIO");
		lblPrecio.setFont(new Font("Dialog", Font.BOLD, 14));
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		
	
		JLabel lblProveedor = new JLabel("PROVEEDOR");
		lblProveedor.setFont(new Font("Dialog", Font.BOLD, 14));
		
		textFieldProveedor = new JTextField();
		textFieldProveedor.setColumns(10);
		
		
		table = new JTable();
//        String[] columnNames = {"Nombre", "Años", "Apto",};
//        Object[][] datos = {
//            {"Juan", 25, false},
//            {"Sonia", 33, true},
//            {"Pedro", 42, false}};
//
//        DefaultTableModel dtm = new DefaultTableModel(datos, columnNames);
//        final JTable table = new JTable(dtm);
//
//        // Agregar nueva columna
//        String[] columnaNueva1 = {"vago", "diestro", "normal",};
//        dtm.addColumn("Tipo", columnaNueva1);
//
//        // Agregar nueva fila
//        Object[] newRow = {"Maria", 55, false};
//        dtm.addRow(newRow);
//
//        // Modificar celda especifica
//        dtm.setValueAt("XXX", 3, 3); // Row/Col
//
//        table.setPreferredScrollableViewportSize(new Dimension(250, 100));
//        JScrollPane scrollPane = new JScrollPane(table);
//        getRootPane().add(scrollPane, BorderLayout.CENTER);       
//        addComponentListener((ComponentListener) new WindowAdapter() {           
//           
//        	public void windowClosing(WindowEvent e) {
//                System.exit(0);               
//            }
//        });
		
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		
		JButton btnNewButton = new JButton("AGREGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("ELIMINAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_2 = new JButton("MODIFICAR");
		
		JButton btnNewButton_3 = new JButton("GUARDAR");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(79))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldCantidad, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCantidad))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldPrecio, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textFieldProveedor, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProveedor))
					.addGap(160))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(107)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 689, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(lblCantidad)
						.addComponent(lblPrecio)
						.addComponent(lblProveedor))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldProveedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addGap(18)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
					.addContainerGap())
		);
		this.setLayout(groupLayout);

	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
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

	public JTextField getTextFieldProveedor() {
		return textFieldProveedor;
	}

	public void setTextFieldProveedor(JTextField textFieldProveedor) {
		this.textFieldProveedor = textFieldProveedor;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public ControladorConfig getControlador() {
		return controlador;
	}

	public void setControlador(ControladorConfig controlador) {
		this.controlador = controlador;
	}
}
