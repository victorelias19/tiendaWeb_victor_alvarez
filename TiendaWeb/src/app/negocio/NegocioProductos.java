package app.negocio;

import java.sql.SQLException;
import java.util.List;

import app.modelo.Producto;
import app.persistencia.ItfzProductosDAO;
import app.persistencia.ProductosDAO;

public class NegocioProductos implements ItfzNegocioProductos{
	
	/**
	 * @param dao
	 */
	ProductosDAO dao = new ProductosDAO();
	
	/**
	 * Método para retornar el método consultarTodos() del DAO productos
	 */
	@Override
	public List<Producto> consultarTodos() {
		// TODO Auto-generated method stub
		return dao.consultarTodos();
	}
	/**
	 * @param id
	 * Método para retornar el método buscarProducto() del DAO productos
	 */
	@Override
	public Producto buscarProducto(int id) {
		// TODO Auto-generated method stub
		return dao.buscarProducto(id);
	}
	/**
	 * @param id
	 * Método para retornar el método deleteProducto() del DAO productos
	 */
	
	public Producto deleteProducto(int id) throws SQLException {
		// TODO Auto-generated method stub
		return dao.deleteProducto(id);
	}
	/**
	 * Método para retornar el método updateProducto() del DAO productos
	 */
	public Producto updateProducto() throws SQLException {
		// TODO Auto-generated method stub
		return dao.updateProducto();
	}
	/**
	 * Método para retornar el método crearProducto() del DAO productos
	 */
	public Producto crearProducto() throws SQLException {
		// TODO Auto-generated method stub
		return dao.crearProducto();
	}

}
