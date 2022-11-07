package modelo;

public class Usuario {

	private Integer id_usuario;
	private String usuario, password;
	private Integer tipoUsuario;

	public Usuario(Integer id_usuario, String usuario, String password, Integer tipoUsuario) {
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

}
