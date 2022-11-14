package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BaseDatos {
	private Connection conexion;
	private String url = "jdbc:mysql://localhost:3306/drinkcounter?characterEncoding=latin1&useConfigs=maxPerformance";
	private String usuario = "root";
	private String clave = "admin123"; //Contraseña de cada uno
	private static BaseDatos bd = null;

	private BaseDatos() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			this.setConexion(DriverManager.getConnection(url, usuario, clave));
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al intentar conectarse con la base de datos.",
					"Algo ha ocurrido.", JOptionPane.ERROR_MESSAGE);
		}

	}

	public Connection getConexion() {
		return conexion;
	}

	private void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public static BaseDatos getInstance() {
		return (bd == null) ? new BaseDatos() : bd;
	}

	public ResultSet getAll(String consulta) {
		ResultSet rs = null;

		try {
			Statement s = conexion.createStatement();
			rs = s.executeQuery(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public Integer alta(String tabla, String columnas, String valores) {

		try {
			PreparedStatement ps = conexion.prepareStatement(
					"INSERT INTO " + tabla + " (" + columnas + " ) VALUES (" + valores + ");",
					Statement.RETURN_GENERATED_KEYS);

			if (ps.executeUpdate() > 0) {

				ResultSet rs = ps.getGeneratedKeys();

				rs.next();

				return tabla != "consumos" ? null : rs.getInt(1);

			} else {
				Integer entero = ps.getUpdateCount();

				return entero;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

	}

	public Boolean update(String tabla, String primaryKey, Integer id, String valores) {

		try {
			PreparedStatement ps = conexion
					.prepareStatement("UPDATE " + tabla + " SET " + valores + " WHERE " + primaryKey + "=" + id + ";");

			ps.execute();
			Integer entero = ps.getUpdateCount();
			return entero > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean remove(String tabla, String primaryKey, Integer id) {

		Statement st;
		try {
			st = conexion.createStatement();
			Integer entero = st.executeUpdate("DELETE FROM " + tabla + " WHERE " + primaryKey + " IN (" + id + ");");
			return entero > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
}
