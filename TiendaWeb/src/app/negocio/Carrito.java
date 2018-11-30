package app.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import app.modelo.Producto;

public class Carrito implements Serializable {

	/**
	 * @param serialVersionUID
	 * @param contenido
	 * @param importe
	 */
	private static final long serialVersionUID = -5964763803801216036L;
	
	private List<Producto> contenido = new ArrayList<Producto>();
	private double importe;
	/**
	 * @param id
	 * M�todo para a�adir productos a la lista
	 */
	public void addProducto(int id){
		NegocioProductos negocio = new NegocioProductos();
		Producto encontrado = negocio.buscarProducto(id);
		contenido.add(encontrado);
		importe += encontrado.getPrecio();
	}
	/**
	 * @param id
	 * M�todo para sacar productos de la lista
	 */
	public void sacarProducto(int id){
		// Esto no funciona
//		ItfzNegocioProductos negocio = new NegocioProductos();
//		Producto encontrado = negocio.buscarProducto(id);
//		contenido.remove(encontrado);
		
		Producto encontrado = null;
		for(Producto p : contenido){
			if (id == p.getId()){
				encontrado = p;
				
			}
		}
		contenido.remove(encontrado);
		importe -= encontrado.getPrecio();
		
	}
	/**
	 * M�todo para ver el contenido del ArrayList de productos
	 */
	public List<Producto> getContenido() {
		return contenido;
	}
	/**
	 * @return importe
	 * Getter de la variable importe
	 */
	public double getImporte() {
		return importe;
	}

}
