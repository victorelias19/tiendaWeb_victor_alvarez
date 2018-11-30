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
	 * M�todo para retornar el m�todo consultarTodos() del DAO productos
	 */
	@Override
	public List<Producto> consultarTodos() {
		// TODO Auto-generated method stub
		return dao.consultarTodos();
	}
	/**
	 * @param id
	 * M�todo para retornar el m�todo buscarProducto() del DAO productos
	 */
	@Override
	public Producto buscarProducto(int id) {
		// TODO Auto-generated method stub
		return dao.buscarProducto(id);
	}
	/**
	 * @param id
	 * M�todo para retornar el m�todo deleteProducto() del DAO productos
	 */
	
	public Producto deleteProducto(int id) throws SQLException {
		// TODO Auto-generated method stub
		return dao.deleteProducto(id);
	}
	/**
	 * M�todo para retornar el m�todo updateProducto() del DAO productos
	 */
	public Producto updateProducto() throws SQLException {
		// TODO Auto-generated method stub
		return dao.updateProducto();
	}
	/**
	 * M�todo para retornar el m�todo crearProducto() del DAO productos
	 */
	public Producto crearProducto() throws SQLException {
		// TODO Auto-generated method stub
		return dao.crearProducto();
	}

}
