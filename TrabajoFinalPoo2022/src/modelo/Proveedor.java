package modelo;

public class Proveedor {
	private Integer cuit;
	private String nombre;
	private Integer telefono;
	private String direccion;
	private String razon_social;

	public Proveedor(Integer cuit, String nombre, Integer telefono, String direccion, String razon_social) {
		this.setCuit(cuit);
		this.setNombre(nombre);
		this.setTelefono(telefono);
		this.setRazon_social(razon_social);
		this.setDireccion(direccion);
	}

	public Integer getCuit() {
		return cuit;
	}

	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

}
