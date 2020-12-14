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
import dao.UsuarioDao;
import models.Atraccion;
import models.Usuario;


/**
 * Servlet implementation class Compra
 */
@WebServlet("/compra")
public class Compra extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AtraccionDao aD;
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
		
		List<String> lista = new ArrayList<String>();
		Usuario usuario = uD.getUno((Integer) request.getSession().getAttribute("usuarioId"));
		List<Atraccion> atracciones = aD.getAtraccionesFavoritas(usuario);
		atracciones.addAll(aD.getAtraccionesNoFavoritas(usuario));
		for(Atraccion a : atracciones) {
			lista.add(a.toString());
		}
		
		
		request.setAttribute("atracciones", lista);
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
