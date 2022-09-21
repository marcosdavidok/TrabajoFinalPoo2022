package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VistaConfig;

public class ControladorConfig implements ActionListener {

	private VistaConfig vistaC;

	public ControladorConfig() {
		this.setVistaC(new VistaConfig(this));
		this.getVistaC().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVistaC().getBtnGuardar())) { // Para probar que funcione
			System.out.println("Razon social: " + vistaC.getTextFieldRazonSocial().getText());
			System.out.println("Localidad: " + vistaC.getTextFieldLocalidad().getText());
			System.out.println("Código postal: " + vistaC.getTextFieldCodigoPostal().getText());
			System.out.println("Teléfono: " + vistaC.getTextFieldTelefono().getText());
			System.out.println("Dirección: " + vistaC.getTextFieldDireccion().getText());
		}

		if (e.getSource().equals(getVistaC().getBtnLimpiar())) {
			vistaC.getTextFieldRazonSocial().setText(null);
			vistaC.getTextFieldLocalidad().setText(null);
			vistaC.getTextFieldCodigoPostal().setText(null);
			vistaC.getTextFieldTelefono().setText(null);
			vistaC.getTextFieldDireccion().setText(null);
		}

	}

	public VistaConfig getVistaC() {
		return vistaC;
	}

	public void setVistaC(VistaConfig vistaC) {
		this.vistaC = vistaC;
	}

}