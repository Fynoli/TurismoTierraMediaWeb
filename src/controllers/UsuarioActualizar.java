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


import models.Usuario;

/**
 * Servlet implementation class UsuarioActualizar
 */
@WebServlet("/usuarioactualizar")
public class UsuarioActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDao uD;
	private TipoAtraccionDao aD;
      Usuario uModificar = new Usuario();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioActualizar() {
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
		     uModificar = uD.getUno(Integer.parseInt(request.getParameter("id")));
			
			request.setAttribute("uModificar", uModificar);
			
//			request.setAttribute("usuarioId", uModificar.getId());
//			request.setAttribute("nombre", uModificar.getNombre());
//			
//			request.setAttribute("preferencia", uModificar.getTipoAtraccion().getNombre());	
//			
//			request.setAttribute("presupuesto", uModificar.getPresupuesto());
//			request.setAttribute("tiempoDisp", uModificar.getTiempo_disponible());
//			request.setAttribute("password", uModificar.getPassword());
//			request.setAttribute("isActivo", uModificar.getActivo());
//			request.setAttribute("isAdmin", uModificar.getEsadmin());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuario_editar.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/no_permitido.jsp");
			dispatcher.forward(request, response);
		}
					
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		uD = new UsuarioDao();
		aD = new TipoAtraccionDao();
		
		Integer uId = uModificar.getId();
		String nombre = (String) request.getParameter("nombre");
		
		Integer idTipoAtraccion = uModificar.getTipoAtraccion().getId();
		
		Integer presupuesto = Integer.parseInt( request.getParameter("presupuesto"));
		Double tiempoDisponible = Double.parseDouble(request.getParameter("tiempoDisp"));
		String password = (String) request.getParameter("password");
		Integer isActivo = Integer.parseInt( request.getParameter("isActivo"));
		Integer isAdmin = Integer.parseInt(request.getParameter("isAdmin"));
		
		Usuario usuarioNuevo = new Usuario();
		
		usuarioNuevo.setNombre(nombre);
		usuarioNuevo.setTipoAtraccion(aD.getUno(idTipoAtraccion)); 
		usuarioNuevo.setPresupuesto(presupuesto);
		usuarioNuevo.setTiempo_disponible(tiempoDisponible);
		usuarioNuevo.setPassword(password);
		usuarioNuevo.setActivo(isActivo);
		usuarioNuevo.setEsadmin(isAdmin);
		
        uD.update(usuarioNuevo);
 		
 		RequestDispatcher dispatcher = request.getRequestDispatcher("usuarioslist");
	    dispatcher.forward(request, response);
		
	
		
		
		
		
	}

}
