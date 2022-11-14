package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;

public class ConsumoDAO {

	public ArrayList<Consumo> getAll() {
		ArrayList<Consumo> consumos = new ArrayList<Consumo>();
		ResultSet rs = BaseDatos.getInstance().getAll(
				"SELECT consumos.id_consumo, consumos.fecha_consumo,consumos.id_usuario,usuarios.usuario AS usuario,consumos.total AS total FROM consumos"
						+ "	LEFT JOIN usuarios ON usuarios.id_usuario = consumos.id_usuario;");
		try {
			while (rs.next()) {
				Integer id_consumo = rs.getInt("id_consumo");
				LocalDate fecha_consumo = rs.getDate("fecha_consumo").toLocalDate();
				Integer id_usuario = rs.getInt("id_usuario");
				Double total = rs.getDouble("total");
				Consumo consumo = new Consumo(id_consumo, fecha_consumo, id_usuario, total);
				consumo.setNombreEncargado(rs.getString("usuario"));

				consumos.add(consumo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return consumos;
	}

	public Consumo get(String id) {
		Consumo consumo = null;
		ResultSet rs = BaseDatos.getInstance().getAll("SELECT * FROM consumos WHERE id_consumo=" + id);
		try {
			while (rs.next()) {
				Integer id_consumo = rs.getInt("id_consumo");
				LocalDate fecha_consumo = rs.getDate("fecha_consumo").toLocalDate();
				Integer id_usuario = rs.getInt("id_usuario");
				Double total = rs.getDouble("total");
				consumo = new Consumo(id_consumo, fecha_consumo, id_usuario, total);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return consumo;

	}

	public Integer insert(Consumo consumo) {
		return BaseDatos.getInstance().alta("consumos", "id_consumo,fecha_consumo,id_usuario,total",
				"'" + consumo.getId_consumo() + "','" + consumo.getFecha_consumo() + "','" + consumo.getId_usuario()
						+ "','" + consumo.getTotal() + "'");
	}

	public Boolean update(Consumo consumo) {
		return BaseDatos.getInstance().update("consumos", "id_consumo", consumo.getId_consumo(),
				"fecha_consumo = '" + consumo.getFecha_consumo() + "', id_usuario = '" + consumo.getId_usuario()
						+ "',total='" + consumo.getTotal() + "'");
	}

	public Boolean remove(Consumo consumo) {
		return BaseDatos.getInstance().remove("consumos", "id_consumo", consumo.getId_consumo());
	}

}
