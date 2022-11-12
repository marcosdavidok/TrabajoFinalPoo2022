package modelo;

public class Producto {
	private Integer codigoProducto;
	private String nombreProducto;
	private Integer cantidad;
	private Double precioProducto;
	private Integer cuitProveedor;

	public Producto(Integer codigoProducto, String nombreProducto, Integer cantidad, Double precioProducto,
			Integer cuitProveedor) {
		this.setCodigoProducto(codigoProducto);
		this.setNombreProducto(nombreProducto);
		this.setCantidad(cantidad);
		this.setPrecioProducto(precioProducto);
		this.setCuitProveedor(cuitProveedor);
	}

	public Integer getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public Integer getCuitProveedor() {
		return cuitProveedor;
	}

	public void setCuitProveedor(Integer cuitProveedor) {
		this.cuitProveedor = cuitProveedor;
	}

}
