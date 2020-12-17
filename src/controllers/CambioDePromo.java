package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AtraccionDao;
import dao.PromocionDao;
import dao.UsuarioDao;
import models.Atraccion;
import models.Promocion;
import models.Usuario;

/**
 * Servlet implementation class CambioDePromo
 */
@WebServlet("/cambiodepromo")
public class CambioDePromo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambioDePromo() {
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cambiar_promo.jsp");
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
		/* Creacion de la nueva promo */

		PromocionDao pD = new PromocionDao();
		Promocion promocion = pD.getUna(Integer.parseInt((String) request.getParameter("id")));
		
		promocion.setNombre((String) request.getParameter("nombre"));
		promocion.setDescripcion((String) request.getParameter("descripcion"));
		promocion.setCosto(Integer.parseInt(request.getParameter("costo")));
		promocion.setActivo(Integer.parseInt(request.getParameter("activo")));

		
		/*
		 * Tomo la lista de atracciones que viene del jsp. TENGO DUDAS SERIAS DE ESTO!
		 */
		List<Integer> atraccionesID = new ArrayList<Integer>();
		String[] atraccionesValues = request.getParameter("atracciones").split(",");
		for (int i = 0; i < atraccionesValues.length; i++) {
			atraccionesID.add(Integer.parseInt(atraccionesValues[i]));
		}

		Set<Atraccion> atracciones = new HashSet<>();
		AtraccionDao aD = new AtraccionDao();
		for (Integer id : atraccionesID) {
			atracciones.add(aD.getUna(id));
		}

		promocion.setAtracciones(atracciones);
		/*----------------------------------------------------------------*/

		/*
		 * Se calcula el tiempo en base a la suma de los tiempos de las atracciones
		 * incluidas
		 */
		Double tiempo = 0.0;
		for (Atraccion a : promocion.getAtracciones()) {
			tiempo += a.getTiempo();
		}

		promocion.setTiempo(tiempo);
		/*---------------------------------------------------------------*/
		
		/*Alta de la promo en la DB*/
		pD.updatePromocion(promocion);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listadepromo");
		dispatcher.forward(request, response);
	}

}
