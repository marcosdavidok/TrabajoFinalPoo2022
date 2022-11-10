package modelo;

public class Empresa {

	private String razonSocial, localidad, direccion, codigoPostal, telefono;

	public Empresa(String razonSocial, String localidad, String codigoPostal, String direccion, String telefono) {
		this.razonSocial = razonSocial;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
