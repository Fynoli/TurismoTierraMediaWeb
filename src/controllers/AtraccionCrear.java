package controllers;

import dao.AtraccionDao;
import dao.TipoAtraccionDao;
import dao.UsuarioDao;
import models.Atraccion;
import models.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AtraccionCrear
 */
@WebServlet("/atraccioncrear")
public class AtraccionCrear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AtraccionDao aD;
	private TipoAtraccionDao aTD;
	private UsuarioDao uD;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtraccionCrear() {
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/atraccion_crear.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/no_permitido.jsp");
			dispatcher.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*       */
		
		String nombre = request.getParameter("nombre");
		Integer isActivo = Integer.parseInt(request.getParameter("isActivo"));
		Integer costo = Integer.parseInt(request.getParameter("costo"));
		Integer cupo = Integer.parseInt(request.getParameter("cupo"));
		String descripcion = request.getParameter("descripcion");
		Double tiempo = Double.parseDouble(request.getParameter("tiempo"));
	
		
		Integer tipoAtraccion = Integer.parseInt(request.getParameter("tipo"));
		
		aD = new AtraccionDao();
		aTD = new TipoAtraccionDao();
		
		Atraccion atraccionNueva = new Atraccion();
		
		atraccionNueva.setActivo(isActivo);
		atraccionNueva.setNombre(nombre);
		atraccionNueva.setCosto(costo);
		atraccionNueva.setCupo(cupo);
		atraccionNueva.setDescripcion(descripcion);
		atraccionNueva.setTiempo(tiempo);
		atraccionNueva.setTipos_atraccion(aTD.getUno(tipoAtraccion));
		
		aD.altaDeAtraccion(atraccionNueva);
		
		response.sendRedirect("atraccionlist");
		
	}

}