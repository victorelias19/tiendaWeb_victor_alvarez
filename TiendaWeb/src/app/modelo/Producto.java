package app.modelo;

import java.io.Serializable;

public class Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8049435758618953119L;
	
	/**
	 * @param id
	 * @param descripcion
	 * @param precio
	 */
	private int id;
	private String descripcion;
	private double precio;
	
	/**
	 * Constructor vacio
	 */
	public Producto() {

	}
	/**
	 * @param id
	 * @param descripcion
	 * @param precio
	 * Constructor inicializando variables
	 */

	public Producto(int id, String descripcion, double precio) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	/**
	 * @return id
	 * Getter de la variable id
	 */

	public int getId() {
		return id;
	}

	/**
	 * @param id
	 * Setter de la variable id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return descripcion
	 * Getter de la variable descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 * Setter de la variable descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * @return precio
	 * Getter de la variable precio
	 */

	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio
	 * Setter de la variable precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Método toString()
	 */
	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion
				+ ", precio=" + precio + "]";
	}
	
	
	
}
