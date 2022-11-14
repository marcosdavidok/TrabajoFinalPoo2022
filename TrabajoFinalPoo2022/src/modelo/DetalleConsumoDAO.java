package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetalleConsumoDAO {

	public ArrayList<DetalleConsumo> getAll() {
		ArrayList<DetalleConsumo> detalleConsumo = new ArrayList<DetalleConsumo>();
		ResultSet rs = BaseDatos.getInstance().getAll("SELECT * FROM detalle_consumo");
		try {
			while (rs.next()) {
				Integer id = rs.getInt("id");
				Integer id_consumo = rs.getInt("id_consumo");
				Integer codigo_producto = rs.getInt("codigo_producto");
				Integer cantidad = rs.getInt("cantidad");
				Double precio = rs.getDouble("precio");
				Double importe = rs.getDouble("importe");

				detalleConsumo.add(new DetalleConsumo(id, id_consumo, codigo_producto, cantidad, precio, importe));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detalleConsumo;
	}

	public DetalleConsumo get(Integer idConsumo) {
		DetalleConsumo ItemConsumo = null;
		ResultSet rs = BaseDatos.getInstance().getAll("SELECT * FROM detalle_consumo where id=" + idConsumo);
		try {
			while (rs.next()) {
				Integer id = rs.getInt("id");
				Integer id_consumo = rs.getInt("id_consumo");
				Integer codigo_producto = rs.getInt("codigo_producto");
				Integer cantidad = rs.getInt("cantidad");
				Double precio = rs.getDouble("precio");
				Double importe = rs.getDouble("importe");
				ItemConsumo = new DetalleConsumo(id, id_consumo, codigo_producto, cantidad, precio, importe);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ItemConsumo;

	}

	public Integer insert(DetalleConsumo item) {
		return BaseDatos.getInstance().alta("detalle_consumo", "id_consumo,codigo_producto,cantidad,precio,importe",
				"'" + item.getId_consumo() + "','" + item.getCodigo_producto() + "','" + item.getCantidad() + "','"
						+ item.getPrecio() + "','" + item.getImporte() + "'");
	}

	public Boolean update(DetalleConsumo item) {
		return BaseDatos.getInstance().update("detalle_consumo", "id", item.getId(),
				"codigo_producto = '" + item.getCodigo_producto() + "', cantidad = '" + item.getCantidad()
						+ "',precio = '" + item.getPrecio() + "',importe='" + item.getImporte() + "'");
	}

	public Boolean remove(DetalleConsumo item) {
		return BaseDatos.getInstance().remove("detalle_consumo", "id", item.getId());
	}

}
