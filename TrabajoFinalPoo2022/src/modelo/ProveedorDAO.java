package modelo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProveedorDAO {
	private String tabla;
	
	public ArrayList<Proveedor> getAll(){
		ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
		ResultSet rs = BaseDatos.getInstance().getAll("SELECT * FROM proveedores;");
		try {
			while (rs.next()) {
				 Integer cuitPersona        = rs.getInt("cuit");
				 String  nombrePersona     = rs.getString("nombre"); 
				 Integer telefonoPersona   =  rs.getInt("telefono"); 
				 String  direccionPersona  = rs.getString("direccion"); 	
				 String  razonSocial       = rs.getString("razon_social");

				proveedores.add(new Proveedor(cuitPersona, nombrePersona, telefonoPersona, direccionPersona, razonSocial));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proveedores;
	}
	public Proveedor get(String  string) {
		Proveedor proveedor = null;
		ResultSet rs = BaseDatos.getInstance().getAll("SELECT * FROM proveedores WHERE cuit="+string);
		try {
			while (rs.next()) {
				 Integer cuitPersona        = rs.getInt("cuit");
				 String  nombrePersona     = rs.getString("nombre"); 
				 Integer telefonoPersona   =  rs.getInt("telefono"); 
				 String  direccionPersona  = rs.getString("direccion"); 	
				 String  razonSocial       = rs.getString("razon_social");

				proveedor = new Proveedor(cuitPersona, nombrePersona, telefonoPersona, direccionPersona, razonSocial);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proveedor;
		
	}
	public Integer insert(Proveedor p) {
		return BaseDatos.getInstance().alta("proveedores","cuit,nombre,telefono,direccion,razon_social" ,"'"+p.getCuit()+"','"+p.getNombre()+"','"+p.getTelefono()+"','"+p.getDireccion()+"','"+p.getRazon_social()+"'");
	}
	public Boolean update(Proveedor p) {
		return BaseDatos.getInstance().update("proveedores","cuit", p.getCuit(), "nombre = '"+p.getNombre()+"', telefono = '"+p.getTelefono()+"',direccion = '"+p.getDireccion()+"',razon_social='"+p.getRazon_social()+"'");
	}
	public Boolean remove(Proveedor p){
		return BaseDatos.getInstance().remove("proveedores","cuit",p.getCuit());
	}
	
	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
}
