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
import models.TipoAtraccion;
import models.Usuario;

/**
 * Servlet implementation class TipoAtraccionBaja
 */
@WebServlet("/tipoatraccionbaja")
public class TipoAtraccionBaja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private TipoAtraccionDao tD;
   private UsuarioDao uD;
  
   
    public TipoAtraccionBaja() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    uD = new UsuarioDao();
			tD = new TipoAtraccionDao();
		 
			
			Usuario usuario = uD.getUno((Integer) request.getSession().getAttribute("usuarioId"));
			
			if(usuario.getEsadmin()==1) {
				
				System.out.println("-----------------------"+Integer.parseInt(request.getParameter("id")));
			
				
				tD.baja(Integer.parseInt((String)request.getParameter("id")));
//				
				RequestDispatcher dispatcher = request.getRequestDispatcher("TipoAtraccionList");
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
        
		
		/* Emilioooooo el parametro usuarioId de aca, es el que se da de baja. Diferente 
		 * al usuarioId del doGet* /
		 */
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("TipoAtraccionList");
		dispatcher.forward(request, response);
		
	}

}
