package app.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.modelo.Producto;
import app.negocio.Carrito;
import app.negocio.ItfzNegocioProductos;
import app.negocio.NegocioProductos;

/**
 * Servlet implementation class ServletTienda
 */
// @WebServlet("/controlador")
public class ServletTienda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	NegocioProductos negocio = new NegocioProductos();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTienda() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);

		String msg = config.getInitParameter("oferta");
		ServletContext ctxApp = config.getServletContext();

		// Guardamos el mensaje de la oferta como atributo de la aplicacion
		ctxApp.setAttribute("msg", msg);
	}
	/**
	 * Interfaz de usuario, donde gracias a un switch, elegimos lo que queremos hacer según un número
	 */

	protected void procesarRespuesta(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {

		String vista = "/index.jsp";

		switch (request.getParameter("opcion")) {
		case "1":
			vista = peticionTodos(request, response);
			break;

		case "2":
			vista = peticionBuscar(request, response);
			break;

		case "3":
			vista = peticionComprar(request, response);
			break;

		case "4":
			vista = peticionSacar(request, response);
			break;

		case "5":
			vista = peticionLogin(request, response);
			break;
			
		case "6":
			vista = crearProducto(request, response);
			break;
			
		case "7":
			vista = updateProducto(request, response);
			break;
			
		case "8":
			vista = deleteProducto(request, response);
			break;

		default:
			System.out.println("Opcion no valida");
		}

		// Elegir la vista que mostrara el resultado
		RequestDispatcher rd = request.getRequestDispatcher(vista);

		// Pasamos el control a la vista
		rd.forward(request, response);

	}

	private String peticionTodos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1.- Consultar todos los productos
		List<Producto> lista = negocio.consultarTodos();

		// Guardo la lista como un atributo de la peticion
		request.setAttribute("lista", lista);

		return "/mostrarTodos.jsp";
	}
	private String crearProducto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {
		Producto encontrado = negocio.crearProducto();
		request.setAttribute("encontrado", encontrado);
		
		return "/altaProductos.jsp";
	}
	private String deleteProducto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		int id = Integer.parseInt(request.getParameter("codigo"));
		Producto encontrado = negocio.deleteProducto(id);
		request.setAttribute("encontrado", encontrado);
		return "/altaProductos.jsp";
	}
	private String updateProducto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {
		Producto encontrado = negocio.updateProducto();
		request.setAttribute("encontrado", encontrado);
		
		return "/altaProductos.jsp";
	}

	private String peticionBuscar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("codigo"));
		Producto encontrado = negocio.buscarProducto(id);

		// Guardo el producto encontrado como un atributo de la peticion
		request.setAttribute("encontrado", encontrado);

		return "/mostrarProducto.jsp";
	}

	private String peticionComprar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		boolean logado = false;

		// Aseguarme si el cliente se ha logado
		Cookie[] todas = request.getCookies();

		for (Cookie c : todas) {
			if ("nombreUsuario".equals(c.getName())) {
				logado = true;
				
			}
		}

		if (logado) {

			int id = Integer.parseInt(request.getParameter("codigo"));

			// Crear o recuperar la sesion del usuario
			HttpSession miSesion = request.getSession();

			// Obtener el carrito de esa sesion
			Carrito miCarro = (Carrito) miSesion.getAttribute("miCarrito");

			// Comprobar si existe el carrito
			if (miCarro == null) {
				miCarro = new Carrito();
				miSesion.setAttribute("miCarrito", miCarro);
			}

			// Agregar el producto al carrito
			miCarro.addProducto(id);

			return "/mostrarCarrito.jsp";
		} else {
			return "/formularioLogin.jsp";
		}
	}

	private String peticionSacar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("codigo"));

		// Recuperar la sesion del usuario
		HttpSession miSesion = request.getSession(false);

		// Obtener el carrito de esa sesion
		Carrito miCarro = (Carrito) miSesion.getAttribute("miCarrito");

		// Sacar el producto del carrito
		miCarro.sacarProducto(id);

		return "/mostrarCarrito.jsp";
	}

	private String peticionLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nombreUsuario = request.getParameter("user");

		// Crear una cookie
		Cookie miCookie = new Cookie("nombreUsuario", nombreUsuario);

		// establecer el tiempo de permanencia en el navegador del usuario
		// 2 semanas
		miCookie.setMaxAge(2 * 7 * 24 * 60 * 60);

		// Enviamos la cookie al navegador
		response.addCookie(miCookie);

		return "/index.jsp";

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			procesarRespuesta(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			procesarRespuesta(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
