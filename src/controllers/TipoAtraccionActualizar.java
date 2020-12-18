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
 * Servlet implementation class TipoAtraccionActualizar
 */
@WebServlet("/tipoatraccionactualizar")
public class TipoAtraccionActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private TipoAtraccionDao aD;
	private UsuarioDao uD;
    TipoAtraccion tipoModificar = new TipoAtraccion();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipoAtraccionActualizar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		aD = new TipoAtraccionDao();
		uD = new UsuarioDao();
		
		Usuario usuario = uD.getUno((Integer) request.getSession().getAttribute("usuarioId"));
			
		if(usuario.getEsadmin()==1) {
		     tipoModificar = aD.getUno(Integer.parseInt(request.getParameter("id")));
			
			request.setAttribute("tipo", tipoModificar);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tipoatraccion_crear.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/no_permitido.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		aD = new TipoAtraccionDao();
		
		Integer tId = tipoModificar.getId();
		
		System.out.println("Flor" + tId);
		String nombre = (String) request.getParameter("nombre");
		
		
		tipoModificar.setNombre(nombre);
			
        aD.update(tipoModificar);
 		
 		RequestDispatcher dispatcher = request.getRequestDispatcher("tipoatraccionlist");
	    dispatcher.forward(request, response);
	}

}
