package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import modelo.Consumo;
import modelo.ConsumoDAO;
import modelo.Reportes;
import vista.VistaGastos;

public class ControladorGastos implements ActionListener, KeyListener, MouseListener {

	private VistaGastos vistaGastos;
	private ConsumoDAO consumoDao;
	private ArrayList<Consumo> consumos = new ArrayList<Consumo>();
	private DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public ControladorGastos() {
		this.setVistaGastos(new VistaGastos(this));
		this.setConsumoDao(new ConsumoDAO());
		this.getVistaGastos().getBtnImprimir().setEnabled(false);
		this.pasarATabla();
	}

	protected void pasarATabla() {
		vaciarTabla();
		setConsumos(getConsumoDao().getAll());

		for (Consumo consumo : getConsumos()) {
			getVistaGastos().getModeloTabla().addRow(obtenerConsumo(consumo));
		}
	}

	private void vaciarTabla() {
		while (getVistaGastos().getModeloTabla().getRowCount() > 0) {
			getVistaGastos().getModeloTabla().removeRow(0);
		}
	}

	private Object[] obtenerConsumo(Consumo consumo) {
		Object[] fila = { Integer.valueOf(consumo.getId_consumo()), formatoFecha.format(consumo.getFecha_consumo()),
				consumo.getNombreEncargado(), Double.valueOf(consumo.getTotal()) };
		return fila;
	}

	private void buscarGastoPorFecha() {
		vaciarTabla();
		for (Consumo consumo : getConsumos()) {
			if (Pattern.compile(Pattern.quote(vistaGastos.getTextFieldBuscar().getText()), Pattern.CASE_INSENSITIVE)
					.matcher(formatoFecha.format(consumo.getFecha_consumo()).toString()).find()) {
				getVistaGastos().getModeloTabla().addRow(obtenerConsumo(consumo));
			}
		}
	}

	private void buscarVentaPorEncargado() {
		vaciarTabla();
		for (Consumo consumo : getConsumos()) {
			if (Pattern.compile(Pattern.quote(vistaGastos.getTextFieldBuscar().getText()), Pattern.CASE_INSENSITIVE)
					.matcher(consumo.getNombreEncargado()).find()) {
				getVistaGastos().getModeloTabla().addRow(obtenerConsumo(consumo));
			}
		}
	}

	private void elegirBusqueda() {
		switch (getVistaGastos().getComboBox().getSelectedItem().toString()) {
		case "Fecha":
			buscarGastoPorFecha();
			break;
		case "Encargado":
			buscarVentaPorEncargado();
			break;
		default:
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVistaGastos().getBtnBuscar())) {
			if (getVistaGastos().getTextFieldBuscar().getText().isEmpty()) {
				this.pasarATabla();
			} else {
				this.elegirBusqueda();
			}
		}

		if (e.getSource().equals(getVistaGastos().getBtnImprimir())) {
			try {
				Reportes.detalleDeConsumo(Integer.valueOf(getVistaGastos().getTable()
						.getValueAt(getVistaGastos().getTable().getSelectedRow(), 0).toString()));
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(vistaGastos, "Seleccione algún consumo.");
			}
			this.getVistaGastos().getBtnImprimir().setEnabled(false);
		}

		if (e.getSource().equals(getVistaGastos().getBtnInformeGastos())) {
			try {
				Reportes.listarGastos();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(vistaGastos,
						"Hubo un problema con la base de datos y no se pudo generar el reporte.");
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource().equals(getVistaGastos().getTextFieldBuscar())) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				this.elegirBusqueda();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(this.getVistaGastos().getTable())) {
			this.getVistaGastos().getBtnImprimir().setEnabled(true);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public VistaGastos getVistaGastos() {
		return vistaGastos;
	}

	public void setVistaGastos(VistaGastos vistaGastos) {
		this.vistaGastos = vistaGastos;
	}

	public ConsumoDAO getConsumoDao() {
		return consumoDao;
	}

	public void setConsumoDao(ConsumoDAO consumoDao) {
		this.consumoDao = consumoDao;
	}

	public ArrayList<Consumo> getConsumos() {
		return consumos;
	}

	public void setConsumos(ArrayList<Consumo> consumos) {
		this.consumos = consumos;
	}
}
