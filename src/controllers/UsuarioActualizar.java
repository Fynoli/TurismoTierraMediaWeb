package controllers;

import java.io.IOException;
import java.net.URLDecoder;

import dao.TipoAtraccionDao;
import dao.UsuarioDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crypto.Blowfish;
import models.Usuario;

/**
 * Servlet implementation class UsuarioActualizar
 */
@WebServlet("/usuarioactualizar")
public class UsuarioActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioActualizar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsuarioDao uD = new UsuarioDao();

		Usuario usuario = uD.getUno((Integer) request.getSession().getAttribute("usuarioId"));

		if (usuario.getEsadmin() == 1) {
			
			Usuario uModificar = uD.getUno(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("usuario", uModificar);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuario_crear.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/no_permitido.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuarioDao uD = new UsuarioDao();
		TipoAtraccionDao aD = new TipoAtraccionDao();
		
		Usuario uModificar=uD.getUno(Integer.parseInt(request.getParameter("id")));

		String nombre = (String) request.getParameter("nombre");

		Integer tipoAtraccion = Integer.parseInt(request.getParameter("tipo"));
		Integer presupuesto = Integer.parseInt(request.getParameter("presupuesto"));
		Double tiempoDisponible = Double.parseDouble(request.getParameter("tiempoDisp"));
		String password = request.getParameter("password");
		Integer isActivo = Integer.parseInt(request.getParameter("isActivo"));
		Integer isAdmin = Integer.parseInt(request.getParameter("isAdmin"));

		uModificar.setNombre(nombre);
		uModificar.setTipoAtraccion(aD.getUno(tipoAtraccion));
		uModificar.setPresupuesto(presupuesto);
		uModificar.setTiempo_disponible(tiempoDisponible);
		uModificar.setPassword(Blowfish.getInstance().encrypt(password));
		uModificar.setActivo(isActivo);
		uModificar.setEsadmin(isAdmin);

		uD.update(uModificar);

		response.sendRedirect("usuarioslist");

	}

}
