package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

	public ArrayList<Usuario> getAll() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ResultSet rs = BaseDatos.getInstance().getAll("SELECT * FROM usuarios;");
		try {
			while (rs.next()) {
				Integer id_usuario = rs.getInt("id_usuario");
				String usuario = rs.getString("usuario");
				String password = rs.getString("password");
				Integer tipoUsuario = rs.getInt("id_tipo_usuario");

				usuarios.add(new Usuario(id_usuario, usuario, password, tipoUsuario));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public Usuario get(String u) {
		Usuario user = null;
		ResultSet rs = BaseDatos.getInstance().getAll("SELECT * FROM usuarios usuario=" + u);
		try {
			while (rs.next()) {
				Integer id_usuario = rs.getInt("id_usuario");
				String usuario = rs.getString("usuario");
				String password = rs.getString("password");
				Integer tipoUsuario = rs.getInt("id_tipo_usuario");

				user = new Usuario(id_usuario, usuario, password, tipoUsuario);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	public Integer insert(Usuario u) {
		return BaseDatos.getInstance().alta("usuarios", "id_usuario,usuario,id_tipo_usuario,password",
				"'" + u.getId_usuario() + "','" + u.getUsuario() + "','" + u.getTipoUsuario() + "','" + u.getPassword()
						+ "'");
	}
}
