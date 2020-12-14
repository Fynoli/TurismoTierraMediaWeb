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

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import dao.AtraccionDao;
import dao.PromocionDao;
import dao.UsuarioDao;
import models.Atraccion;
import models.Promocion;
import models.Usuario;


/**
 * Servlet implementation class Compra
 */
@WebServlet("/compra")
public class Compra extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AtraccionDao aD;
	private PromocionDao pD;
	private UsuarioDao uD;

	/*
	 * El metodo init solo se ejecuta cuando el servlet es llamado a traves de
	 * request.getRequestDispatcher. Como en este caso el servlet es disparado por
	 * un boton en jsp entonces esto no sucede dejando los DAO's en null
	 */
	/*public void Init() {
		aD = new AtraccionDao();
		uD = new UsuarioDao();
	}*/

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Compra() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		aD = new AtraccionDao();
		uD = new UsuarioDao();
		pD = new PromocionDao();
		
		List<String> lista = new ArrayList<String>();
		Usuario usuario = uD.getUno((Integer) request.getSession().getAttribute("usuarioId"));
		
		List<Promocion> promociones = pD.getPromocionesFavoritas(usuario);
		promociones.addAll(pD.getPromocionesNoFavoritas(usuario));
		
		List<Atraccion> atracciones = aD.getAtraccionesFavoritas(usuario);
		atracciones.addAll(aD.getAtraccionesNoFavoritas(usuario));
		
		for(Promocion p : promociones) {
			lista.add(p.generateData());
		}
		for(Atraccion a : atracciones) {
			lista.add(a.generateData());
		}
		System.out.println(lista);

		
		
		request.setAttribute("productos", lista);
		request.setAttribute("usuario", usuario);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/compra.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
