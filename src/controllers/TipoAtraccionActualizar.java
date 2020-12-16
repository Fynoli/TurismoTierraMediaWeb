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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipoAtraccionActualizar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Chequeo de permisos de administrador */

		UsuarioDao uD = new UsuarioDao();
		Usuario usuario = uD.getUno((Integer) request.getSession().getAttribute("usuarioId"));

		if (usuario.getEsadmin() == 1) {
			TipoAtraccionDao tD= new TipoAtraccionDao();
			
			/*Se trae el tipo de atraccion a modificar*/
			TipoAtraccion ta= tD.getUno(Integer.parseInt((String) request.getParameter("id")));
			
			ta.setNombre((String) request.getParameter("nombre"));
			
			tD.update(ta);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("tipoatraccionlista");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/no_permitido.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
