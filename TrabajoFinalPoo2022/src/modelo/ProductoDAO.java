package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAO {

	public ArrayList<Producto> getAll() {
		ArrayList<Producto> Productos = new ArrayList<Producto>();
		ResultSet rs = BaseDatos.getInstance().getAll("SELECT * FROM productos");
		try {
			while (rs.next()) {
				Integer codigoProducto = rs.getInt("codigo");
				String nombreProducto = rs.getString("nombre");
				Integer cantidad = rs.getInt("cantidad");
				Double precioProducto = rs.getDouble("precio");
				Integer cuitProveedor = rs.getInt("cuit_proveedor");

				Productos.add(new Producto(codigoProducto, nombreProducto, cantidad, precioProducto, cuitProveedor));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Productos;
	}

	public Producto get(Integer codProducto) {
		Producto producto = null;
		ResultSet rs = BaseDatos.getInstance().getAll("SELECT * FROM productos where codigo=" + codProducto);
		try {
			while (rs.next()) {
				Integer codigoProducto = rs.getInt("codigo");
				String nombreProducto = rs.getString("nombre");
				Integer cantidad = rs.getInt("cantidad");
				Double precioProducto = rs.getDouble("precio");
				Integer cuitProveedor = rs.getInt("cuit_proveedor");
				producto = new Producto(codigoProducto, nombreProducto, cantidad, precioProducto, cuitProveedor);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return producto;

	}

	public Integer insert(Producto p) {
		return BaseDatos.getInstance().alta("productos", "codigo,nombre,cantidad,precio,cuit_proveedor",
				"'" + p.getCodigoProducto() + "','" + p.getNombreProducto() + "','" + p.getCantidad() + "','"
						+ p.getPrecioProducto() + "','" + p.getCuitProveedor() + "'");
	}

	public Boolean update(Producto p) {
		return BaseDatos.getInstance().update("productos", "codigo", p.getCodigoProducto(),
				"nombre = '" + p.getNombreProducto() + "', cantidad = '" + p.getCantidad() + "',precio = '"
						+ p.getPrecioProducto() + "',cuit_proveedor='" + p.getCuitProveedor() + "'");
	}

	public Boolean remove(Producto p) {
		return BaseDatos.getInstance().remove("productos", "codigo", p.getCodigoProducto());
	}
}
