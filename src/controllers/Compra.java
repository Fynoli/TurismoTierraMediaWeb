package controllers;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class Compra
 */
@WebServlet("/compra")
public class Compra extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AtraccionDao aD;
	private UsuarioDao uDao;
	
	public void Init() {
		aD = new AtraccionDao();
		uDao = new UsuarioDao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Compra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario usuario = uDao.getUno((Integer) request.getSession().getAttribute("usuarioId"));
		List<Atraccion> atracciones = aD.getAtracciones(usuario);
		request.setAttribute("atracciones", atracciones);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/compra.jsp");
		dispatcher.forward(request, response);
	}

}
