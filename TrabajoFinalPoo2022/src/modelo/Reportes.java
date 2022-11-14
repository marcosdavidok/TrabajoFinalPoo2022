package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Reportes {

	public static void reportesProductos() throws SQLException {
		String currentDir = System.getProperty("user.dir");
		String consulta = "SELECT productos.codigo AS codigo, productos.nombre AS nombre, productos.cantidad AS cantidad"
				+ ", productos.precio AS precio," + " proveedores.nombre AS proveedor"
				+ " FROM productos JOIN proveedores ON productos.cuit_proveedor=proveedores.cuit ORDER BY codigo;";
		ResultSet rs = BaseDatos.getInstance().getAll(consulta);

		AbstractJasperReport.createReport(rs, currentDir + "/src/Reportes/productos.jasper");
		AbstractJasperReport.exportToPDF(currentDir + "/src/Reportes/reporteProductos.pdf");
		AbstractJasperReport.openPDF(currentDir + "/src/Reportes/reporteProductos.pdf");
	}

	public static void detalleDeConsumo(Integer id) throws SQLException {
		String currentDir = System.getProperty("user.dir");
		String consulta = "SELECT consumos.id_consumo AS id, detalle_consumo.codigo_producto, productos.nombre AS nombreProducto,"
				+ "				detalle_consumo.cantidad AS cantidad, detalle_consumo.precio AS precio, detalle_consumo.importe AS importe,"
				+ "			    consumos.total AS total, fecha_consumo, usuarios.usuario AS usuario"
				+ "				FROM detalle_consumo JOIN productos ON detalle_consumo.codigo_producto=productos.codigo"
				+ "				LEFT JOIN consumos ON detalle_consumo.id_consumo=consumos.id_consumo"
				+ "				LEFT JOIN usuarios ON consumos.id_usuario=usuarios.id_usuario"
				+ "				 WHERE consumos.id_consumo=" + id + " ORDER BY detalle_consumo.id;";
		ResultSet rs = BaseDatos.getInstance().getAll(consulta);

		AbstractJasperReport.createReport(rs, currentDir + "/src/Reportes/detalle_consumo.jasper");
		AbstractJasperReport.exportToPDF(currentDir + "/src/Reportes/detalle_consumo.pdf");
		AbstractJasperReport.openPDF(currentDir + "/src/Reportes/detalle_consumo.pdf");

	}

	public static void reportesProveedores() throws SQLException {
		String currentDir = System.getProperty("user.dir");
		String consulta = "SELECT * FROM proveedores ORDER BY cuit;";
		ResultSet rs = BaseDatos.getInstance().getAll(consulta);

		AbstractJasperReport.createReport(rs, currentDir + "/src/Reportes/proveedores.jasper");
		AbstractJasperReport.exportToPDF(currentDir + "/src/Reportes/reporteProveedores.pdf");
		AbstractJasperReport.openPDF(currentDir + "/src/Reportes/reporteProveedores.pdf");

	}
	
	public static void listarGastos() throws SQLException {
		String currentDir = System.getProperty("user.dir");
		String consulta = "SELECT * FROM consumos ORDER BY id_consumo;";
		ResultSet rs = BaseDatos.getInstance().getAll(consulta);

		AbstractJasperReport.createReport(rs, currentDir + "/src/Reportes/listarGastos.jasper");
		AbstractJasperReport.exportToPDF(currentDir + "/src/Reportes/listarGastos.pdf");
		AbstractJasperReport.openPDF(currentDir + "/src/Reportes/listarGastos.pdf");

	}

}