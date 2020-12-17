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

import dao.UsuarioDao;
import models.Atraccion;
import models.Usuario;

/**
 * Servlet implementation class UsuariosList
 */
@WebServlet("/usuarioslist")
public class UsuariosList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UsuarioDao uD;
   
    public UsuariosList() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		uD = new UsuarioDao();
		Usuario usuario = uD.getUno((Integer) request.getSession().getAttribute("usuarioId"));

		
		if(usuario.getEsadmin()==1) {
			
			List<String> lista = new ArrayList<String>();
			List<Usuario> usuarios = uD.all();
			
			for(Usuario a : usuarios) {
				lista.add(a.generateData());
			}
			
			request.setAttribute("usuarios", lista);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuarios.jsp");
			dispatcher.forward(request, response);

		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/no_permitido.jsp");
			dispatcher.forward(request, response);
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
