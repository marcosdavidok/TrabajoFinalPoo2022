package modelo;

import java.time.LocalDate;

public class Consumo {

	private Integer id_consumo;
	private LocalDate fecha_consumo;
	private Integer id_usuario;
	private Double total;
	private String nombreEncargado;

	public Consumo(Integer id_consumo, LocalDate fecha_consumo, Integer id_usuario, Double total) {
		this.setId_consumo(id_consumo);
		this.setFecha_consumo(fecha_consumo);
		this.setId_usuario(id_usuario);
		this.setTotal(total);
	}

	public Integer getId_consumo() {
		return id_consumo;
	}

	public void setId_consumo(Integer id_consumo) {
		this.id_consumo = id_consumo;
	}

	public LocalDate getFecha_consumo() {
		return fecha_consumo;
	}

	public void setFecha_consumo(LocalDate fecha_consumo) {
		this.fecha_consumo = fecha_consumo;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getNombreEncargado() {
		return nombreEncargado;
	}

	public void setNombreEncargado(String nombreEncargado) {
		this.nombreEncargado = nombreEncargado;
	}

}
