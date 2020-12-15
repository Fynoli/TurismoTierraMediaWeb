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
import models.Atraccion;
import models.Usuario;

/**
 * Servlet implementation class AtraccionActualizar
 */
@WebServlet("/atraccionactualizar")
public class AtraccionActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDao uD;
	private AtraccionDao aD;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtraccionActualizar() {
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/crear_atraccion.jsp");
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
		
		String nombre = (String) request.getParameter("nombre");
		String descripcion = (String) request.getParameter("descripcion");
		Integer costo = Integer.parseInt(request.getParameter("costo"));
		Double tiempo = Double.parseDouble(request.getParameter("tiempo"));
		Integer cupo = Integer.parseInt(request.getParameter("cupo"));
		Integer isActivo = Integer.parseInt(request.getParameter("isActivo"));
		
		Atraccion atraccionNueva = new Atraccion();
		
		atraccionNueva.setNombre(nombre);
		atraccionNueva.setDescripcion(descripcion); 
		atraccionNueva.setCosto(costo);;
		atraccionNueva.setTiempo(tiempo);
		atraccionNueva.setCupo(cupo);
		atraccionNueva.setActivo(isActivo);
		
		aD.updateAtraccion(atraccionNueva);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/atracciones.jsp");
		dispatcher.forward(request, response);
			
		
	}

}
