package controllers;

import java.io.IOException;

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
 * Servlet implementation class BajaDePromo
 */
@WebServlet("/bajadepromo")
public class BajaDePromo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaDePromo() {
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
			doPost(request,response);
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
		/*Se obtiene la promo correspondiente y se da de baja en la DB*/
		PromocionDao pD= new PromocionDao();
		Promocion promo = pD.getUna(Integer.parseInt((String) request.getParameter("id")));
		pD.bajaPromocion(promo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("listadepromo");
		dispatcher.forward(request, response);
	}

}
