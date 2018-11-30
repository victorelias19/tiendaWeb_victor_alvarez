package app.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import app.modelo.Producto;

public class ProductosDAO implements ItfzProductosDAO{
	/**
	 * @param conexion
	 */
	
	private Connection conexion;
	
	/**
	 * Conecta con la base de datos gracias a JDBC
	 */
	
	private void abrirConexion(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "root");
		}catch(Exception ex){
			System.out.println("Error al abrir la bbdd");
			ex.printStackTrace();
		}
		
	}
	/**
	 * Termina la conexion con la base de datos
	 */
	
	private void cerrarConexion(){
		try {
			conexion.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar la conexion");
			e.printStackTrace();
		}
	}
	/**
	 * Método para realizar un select de todos los elementos de la tabla productos
	 */

	@Override
	public List<Producto> consultarTodos() {
		
		List<Producto> lista = new ArrayList<Producto>();
		
		try {
			abrirConexion();
			PreparedStatement pstm = conexion.prepareStatement("select * from PRODUCTOS");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				lista.add(new Producto(rs.getInt("ID"), rs.getString("DESCRIPCION"), rs.getDouble("PRECIO")));
			}
			
		} catch (Exception e) {
			System.out.println("Error al consultar todos");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return lista;
	}
	/**
	 * @return p
	 * @param id
	 * Método para realizar un select del elemento con la id definida, de la tabla productos
	 */
	@Override
	public Producto buscarProducto(int id) {
		Producto producto = new Producto();
		
		try {
			abrirConexion();
			PreparedStatement pstm = conexion.prepareStatement("select * from PRODUCTOS where ID = ?");
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){
				producto = new Producto(rs.getInt("ID"), rs.getString("DESCRIPCION"), rs.getDouble("PRECIO"));
			}
			
		} catch (Exception e) {
			System.out.println("Error al buscar el producto con id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return producto;
	}
	/**
	 * @return p
	 * Método para realizar un update de la tabla productos
	 */

	public Producto updateProducto() throws SQLException{
		Producto p=new Producto();
		PreparedStatement ps = conexion
				.prepareStatement("UPDATE productos SET descripcion = ?, precio = ? WHERE id = ?");
		ps.setString(1, p.getDescripcion());
		ps.setDouble(2, p.getPrecio());


		ps.executeUpdate();
		ps.close();
		return p;
	}
	/**
	 * @return p
	 * Método para realizar un delete de la tabla productos
	 */
	public Producto deleteProducto(int id) throws SQLException {
		Producto p=new Producto();
		PreparedStatement ps = conexion.prepareStatement("DELETE FROM productos WHERE id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		return p;
	}
	/**
	 * @return p
	 * Método para realizar un insert de la tabla productos
	 */
	public Producto crearProducto() throws SQLException {
		Producto p=new Producto();
		PreparedStatement ps = conexion.prepareStatement("INSERT INTO productos"
				+ " (descripcion, precio) VALUES (?,?)");
		ps.setString(1, p.getDescripcion());
		ps.setDouble(2, p.getPrecio());
		ps.executeUpdate();
		ps.close();
		return p;
	}

}
