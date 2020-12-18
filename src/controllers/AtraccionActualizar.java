package controllers;

import dao.AtraccionDao;
import dao.TipoAtraccionDao;
import dao.UsuarioDao;
import models.Atraccion;
import models.TipoAtraccion;
import models.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class AtraccionActualizar
 */
@WebServlet("/atraccionactualizar")
public class AtraccionActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDao uD;
	private AtraccionDao aD;
	private TipoAtraccionDao tA;
	Atraccion aModificar = new Atraccion();
       
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
        aD = new AtraccionDao();
		
		Usuario usuario = uD.getUno((Integer) request.getSession().getAttribute("usuarioId"));
		
		
		if(usuario.getEsadmin()==1) {
			aModificar = aD.getUna((Integer.parseInt(request.getParameter("id"))));
			request.setAttribute("atraccion",aModificar);
			request.setAttribute("nombre",aModificar.getNombre());

			TipoAtraccionDao taD= new TipoAtraccionDao();
			List<TipoAtraccion> tiposAtraccion= taD.getTiposAtracciones();
			request.setAttribute("tipos", tiposAtraccion);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/atraccion_crear.jsp");
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
		uD = new UsuarioDao();
		aD = new AtraccionDao();
		tA = new TipoAtraccionDao();

		aModificar = aD.getUna((Integer.parseInt(request.getParameter("id"))));
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		Integer costo = Integer.parseInt(request.getParameter("costo"));
		Double tiempo = Double.parseDouble(request.getParameter("tiempo"));
		Integer cupo = Integer.parseInt(request.getParameter("cupo"));
		Integer isActivo = Integer.parseInt(request.getParameter("isActivo"));

		Atraccion atraccionNueva = new Atraccion();
		atraccionNueva = aModificar;

		//aca se recibiria el id del Tipo de Atraccion
		Integer tipoAtraccion = Integer.parseInt(request.getParameter("tiposeleccionado"));
		//Integer idTipoAtraccion = aModificar.getTipos_atraccion().getId();
		TipoAtraccion tipoAtraccion1 = tA.getUno(tipoAtraccion);

		atraccionNueva.setNombre(nombre);
		atraccionNueva.setDescripcion(descripcion); 
		atraccionNueva.setCosto(costo);;
		atraccionNueva.setTiempo(tiempo);
		atraccionNueva.setCupo(cupo);
		atraccionNueva.setActivo(isActivo);
		atraccionNueva.setTipos_atraccion(tipoAtraccion1);
		
		aD.updateAtraccion(atraccionNueva);
		
		response.sendRedirect("atraccionlist");
			
		
	}

}
