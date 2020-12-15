package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AtraccionDao;
import dao.UsuarioDao;
import models.Usuario;

/**
 * Servlet implementation class AtraccionBaja
 */
@WebServlet("/atraccionbaja")
public class AtraccionBaja extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AtraccionDao aD;
	private UsuarioDao uD;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtraccionBaja() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uD = new UsuarioDao();
		
		Usuario usuario = uD.getUno((Integer) request.getSession().getAttribute("usuarioId"));
		
		if(usuario.getEsadmin()==1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuarios.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/no_permitido.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		aD = new AtraccionDao();
		
		Integer idAtraccion = Integer.parseInt(request.getParameter("atraccionId"));
		
		aD.bajaAtraccion(aD.getUna(idAtraccion));
		
	}

}