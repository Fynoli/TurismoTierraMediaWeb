package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TipoAtraccionDao;
import dao.UsuarioDao;
import models.Usuario;

/**
 * Servlet implementation class TipoAtraccionBaja
 */
@WebServlet("/tipoatraccionbaja")
public class TipoAtraccionBaja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TipoAtraccionBaja() {
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
			
			/*Se obtiene el dao*/
			TipoAtraccionDao tD = new TipoAtraccionDao();
			
			/*Se da de baja el tiepo de atraccion pasado pro el atributo "id" */
			tD.baja(tD.getUno(Integer.parseInt((String) request.getParameter("id"))));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("tipoatraccionlista");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/no_permitido.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
