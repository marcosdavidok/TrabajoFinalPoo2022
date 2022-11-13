package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import com.google.gson.Gson;

import modelo.Empresa;
import vista.VistaConfig;

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
				getVistaConfig().getTextFieldLocalidad().getText(), getVistaConfig().getTextFieldDireccion().getText(),
				getVistaConfig().getTextFieldCodigoPostal().getText(), getVistaConfig().getTextFieldTelefono().getText());

		setGson(new Gson());
		String json = gson.toJson(empresa);

		try (FileWriter file = new FileWriter(System.getProperty("user.dir") + "/src/Json/empresa.json")) {

			file.write(json);

			JOptionPane.showMessageDialog(vistaConfig, "DATOS GUARDADOS CORRECTAMENTE");

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVistaConfig().getBtnGuardar())) {
			this.guardarGson();
		}
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