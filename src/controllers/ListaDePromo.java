package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PromocionDao;
import dao.UsuarioDao;
import models.Promocion;
import models.Usuario;

/**
 * Servlet implementation class ListaDePromo
 */
@WebServlet("/listadepromo")
public class ListaDePromo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaDePromo() {
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
			List<String> lista = new ArrayList<String>();
			PromocionDao pD= new PromocionDao();
			List<Promocion> promociones = pD.getPromociones();
			for(Promocion p : promociones) {
				if(p.getPromocion_id()!=4) {
					lista.add(p.generateDataAdmin());
				}
			}
			
			
			request.setAttribute("promociones", lista);
				
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/promocionlist.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/no_permitido.jsp");
			dispatcher.forward(request, response);
		}
		/*--------------------------------*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
