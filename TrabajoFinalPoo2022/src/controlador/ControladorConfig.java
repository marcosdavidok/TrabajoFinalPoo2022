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

	private VistaConfig vistaC;
	private Gson gson;

	public ControladorConfig() {
		this.setVistaC(new VistaConfig(this));
		this.getVistaC().setVisible(true);
		this.abrirGson();
	}

	private void abrirGson() {

		try (FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/Json/empresa.json")) {
			Gson gson = new Gson();
			Empresa empresa = gson.fromJson(reader, Empresa.class);

			getVistaC().getTextFieldCodigoPostal().setText(empresa.getCodigoPostal());
			getVistaC().getTextFieldDireccion().setText(empresa.getDireccion());
			getVistaC().getTextFieldLocalidad().setText(empresa.getLocalidad());
			getVistaC().getTextFieldRazonSocial().setText(empresa.getRazonSocial());
			getVistaC().getTextFieldTelefono().setText(empresa.getTelefono());

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void guardarGson() {
		Empresa empresa = new Empresa(getVistaC().getTextFieldRazonSocial().getText(),
				getVistaC().getTextFieldLocalidad().getText(), getVistaC().getTextFieldDireccion().getText(),
				getVistaC().getTextFieldCodigoPostal().getText(), getVistaC().getTextFieldTelefono().getText());

		setGson(new Gson());
		String json = gson.toJson(empresa);

		try (FileWriter file = new FileWriter(System.getProperty("user.dir") + "/src/Json/empresa.json")) {

			file.write(json);

			JOptionPane.showMessageDialog(vistaC, "DATOS GUARDADOS CORRECTAMENTE");

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVistaC().getBtnGuardar())) {
			this.guardarGson();
		}
	}

	public VistaConfig getVistaC() {
		return vistaC;
	}

	public void setVistaC(VistaConfig vistaC) {
		this.vistaC = vistaC;
	}

	public Gson getGson() {
		return gson;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}
}