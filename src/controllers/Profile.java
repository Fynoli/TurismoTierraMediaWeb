package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import models.Usuario;

@WebServlet("/profile")
public class Profile extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
	private UsuarioDao uDao;

    public void init() {
        uDao = new UsuarioDao();
    }

    public Profile() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    	Usuario usuario = uDao.getUno((Integer) request.getSession().getAttribute("usuarioId"));
    	request.setAttribute("usuario", usuario);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/profile.jsp");
    	dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {



    	
    }
}
