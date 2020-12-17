package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import models.Usuario;

/**
 * Servlet implementation class UsuarioBaja
 */
@WebServlet("/usuariobaja")
public class UsuarioBaja extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDao uD;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioBaja() {
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
			
			uD.baja(Integer.parseInt(request.getParameter("id")));
			RequestDispatcher dispatcher = request.getRequestDispatcher("usuarioslist");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/no_permitido.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		/*usuarios.jsp panel de listado de usuarios*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		uD = new UsuarioDao();
		
		/* Emilioooooo el parametro usuarioId de aca, es el que se da de baja. Diferente 
		 * al usuarioId del doGet* /
		 */
		uD.baja(Integer.parseInt(request.getParameter("usuarioId")));
		
	}

}
