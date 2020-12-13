package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UsuarioDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDao uDao;

    public void init() {
        uDao = new UsuarioDao();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:8080/HolaMundo/login
		
				String username = request.getParameter("username");
				String password = request.getParameter("password");	
				

				//System.out.println("La pass Encriptada es: "+ new String(Blowfish.getInstance().encrypt(password)));
				//password=new String(Blowfish.getInstance().encrypt(password));
				
				if (uDao.validar(username, password)) {
					request.getSession().setAttribute("usuarioId", uDao.getUno(username).getId());
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/profile");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("failed", "true");
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}
	}

}
