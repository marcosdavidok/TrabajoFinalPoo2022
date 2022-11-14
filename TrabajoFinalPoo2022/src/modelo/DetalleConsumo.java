package modelo;

public class DetalleConsumo {

	private Integer id;
	private Integer id_consumo;
	private Integer codigo_producto;
	private Integer cantidad;
	private Double precio;
	private Double importe;

	public DetalleConsumo(Integer id, Integer id_consumo, Integer codigo_producto, Integer cantidad, Double precio,
			Double importe) {
		super();
		this.setId(id);
		this.setId_consumo(id_consumo);
		this.setCodigo_producto(codigo_producto);
		this.setCantidad(cantidad);
		this.setPrecio(precio);
		this.setImporte(importe);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_consumo() {
		return id_consumo;
	}

	public void setId_consumo(Integer id_consumo) {
		this.id_consumo = id_consumo;
	}

	public Integer getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Integer codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

}
