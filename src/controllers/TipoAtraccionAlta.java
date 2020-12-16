package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crypto.Blowfish;
import dao.TipoAtraccionDao;
import dao.UsuarioDao;
import models.TipoAtraccion;
import models.Usuario;

/**
 * Servlet implementation class TipoAtraccionAlta
 */
@WebServlet("/tipoatraccionalta")
public class TipoAtraccionAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TipoAtraccionDao aTD;
	
    public TipoAtraccionAlta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
		
		
		
		UsuarioDao uD = new UsuarioDao();
		
		Usuario usuario = uD.getUno((Integer) request.getSession().getAttribute("usuarioId"));
			
		if(usuario.getEsadmin()==1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tipoatraccion_crear.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/no_permitido.jsp");
			dispatcher.forward(request, response);
		}
		
		
//		Usuario usuario = (Usuario) request.getSession().getAttribute("isAdmin");
//		
//		if(usuario.getEsadmin()==1) {
//			
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tipoatraccion_crear.jsp");
//			dispatcher.forward(request, response);
//		}
//		else {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/no_permitido.jsp");
//			dispatcher.forward(request, response);
//		}}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		aTD = new TipoAtraccionDao();
		
	
		
		String nombre = (String) request.getParameter("nombre");
		
		
	
		
		TipoAtraccion tipoAtraccion = new TipoAtraccion();
		
		tipoAtraccion.setNombre(nombre);
		tipoAtraccion.setActivo(1); 
		
		
 		aTD.crear(tipoAtraccion);
 		
 		RequestDispatcher dispatcher = request.getRequestDispatcher("TipoAtraccionList");
		dispatcher.forward(request, response);
	}

}
