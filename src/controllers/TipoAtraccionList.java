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

import dao.TipoAtraccionDao;
import dao.UsuarioDao;
import models.TipoAtraccion;
import models.Usuario;


/**
 * Servlet implementation class TipoAtraccionList
 */
@WebServlet("/tipoatraccionlist")
public class TipoAtraccionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TipoAtraccionDao tD;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipoAtraccionList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        tD = new TipoAtraccionDao();
		
		  //  Usuario usuario = uD.getUno((Integer) request.getSession().getAttribute("usuarioId"));
		    
			List<String> lista = new ArrayList<String>();
			
			List<TipoAtraccion> tipoAtracciones = tD.getTiposAtracciones();
			
			for(TipoAtraccion a : tipoAtracciones) {
				if(a.getActivo()!=0) {
				lista.add(a.generateData());
				}
			}
			
			System.out.println(lista);
			request.setAttribute("tipoAtracciones", lista);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/tipoatracciones.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
