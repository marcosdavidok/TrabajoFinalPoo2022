package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import com.google.gson.Gson;

import modelo.Empresa;
import vista.VistaConfig;
import vista.VistaPrincipal;

public class ControladorConfig implements ActionListener {

	private VistaConfig vistaConfig;
	private Gson gson;

	public ControladorConfig() {
		this.setVistaConfig(new VistaConfig(this));
		this.getVistaConfig().setVisible(true);
		this.abrirGson();
	}

	private void abrirGson() {
		try (FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/Json/empresa.json")) {
			Gson gson = new Gson();
			Empresa empresa = gson.fromJson(reader, Empresa.class);
			getVistaConfig().getTextFieldCodigoPostal().setText(empresa.getCodigoPostal());
			getVistaConfig().getTextFieldDireccion().setText(empresa.getDireccion());
			getVistaConfig().getTextFieldLocalidad().setText(empresa.getLocalidad());
			getVistaConfig().getTextFieldRazonSocial().setText(empresa.getRazonSocial());
			getVistaConfig().getTextFieldTelefono().setText(empresa.getTelefono());
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void guardarGson() {
		Empresa empresa = new Empresa(getVistaConfig().getTextFieldRazonSocial().getText(),
				getVistaConfig().getTextFieldLocalidad().getText(),
				getVistaConfig().getTextFieldCodigoPostal().getText(),
				getVistaConfig().getTextFieldDireccion().getText(), getVistaConfig().getTextFieldTelefono().getText());

		setGson(new Gson());
		String json = gson.toJson(empresa);

		try (FileWriter file = new FileWriter(System.getProperty("user.dir") + "/src/Json/empresa.json")) {

			file.write(json);
			JOptionPane.showMessageDialog(vistaConfig, "Datos guardados correctamente", "Aceptado", 0,
					this.ajustarImagen(
							new ImageIcon(VistaPrincipal.class.getResource("/Imagenes/Correcto.png")).getImage(), 44,
							44));

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVistaConfig().getBtnGuardar())) {
			this.guardarGson();
		}
		if (e.getSource().equals(getVistaConfig().getBtnLimpiar())) {
			vistaConfig.getTextFieldRazonSocial().setText(null);
			vistaConfig.getTextFieldLocalidad().setText(null);
			vistaConfig.getTextFieldCodigoPostal().setText(null);
			vistaConfig.getTextFieldTelefono().setText(null);
			vistaConfig.getTextFieldDireccion().setText(null);
		}
	}

	private ImageIcon ajustarImagen(Image img, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return imagen;
	}

	public VistaConfig getVistaConfig() {
		return vistaConfig;
	}

	public void setVistaConfig(VistaConfig vistaConfig) {
		this.vistaConfig = vistaConfig;
	}

	public Gson getGson() {
		return gson;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}
}