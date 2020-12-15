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
import models.Usuario;

/**
 * Servlet implementation class UsuarioCrear
 */
@WebServlet("/usuariocrear")
public class UsuarioCrear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private UsuarioDao uD;
    private TipoAtraccionDao aTD;
   
    
    public UsuarioCrear() {
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/crear_usuario.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/no_permitido.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		uD = new UsuarioDao();
		aTD = new TipoAtraccionDao();
		
	/*	nombre, (idTipoATrccion), presupuesto, tiempo diponible, password, (activo), (isAdmin),  */
		
		String nombre = (String) request.getParameter("nombre");
		Integer idTipoAtraccion = Integer.parseInt( request.getParameter("idTipoA"));
		Integer presupuesto = Integer.parseInt( request.getParameter("presupuesto"));
		Double tiempoDisponible = Double.parseDouble(request.getParameter("tiempoDisp"));
		String password = new String(Blowfish.getInstance().encrypt((String) request.getParameter("password")));
		Integer isActivo = Integer.parseInt( request.getParameter("isActivo"));
		Integer isAdmin = Integer.parseInt(request.getParameter("isAdmin"));
		
		Usuario usuarioNuevo = new Usuario();
		
		usuarioNuevo.setNombre(nombre);
		usuarioNuevo.setTipoAtraccion(aTD.getUno(idTipoAtraccion)); 
		usuarioNuevo.setPresupuesto(presupuesto);
		usuarioNuevo.setTiempo_disponible(tiempoDisponible);
		usuarioNuevo.setPassword(password);
		usuarioNuevo.setActivo(isActivo);
		usuarioNuevo.setEsadmin(isAdmin);
		
		
 		uD.crear(usuarioNuevo);
 		
 		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuarios.jsp");
		dispatcher.forward(request, response);
		
	}

}
