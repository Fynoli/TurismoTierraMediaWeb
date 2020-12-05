package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:8080/HolaMundo/login
		
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				
				String dbPass=null;
				Connection con=Database.connect();
				PreparedStatement st=null;//Database.getInstance().createStatement();
				ResultSet rs=null;
				try {
					
					st=con.prepareStatement("SELECT password FROM usuario");
					rs=st.executeQuery();//WHERE nombre LIKE '"+username+"'");
					dbPass=rs.getString("password");
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						if(rs!=null) {
							rs.close();
							st.close();
						}
						}
						catch(SQLException e) {
							e.printStackTrace();
						}
					}
				
				
				
				if (password.equals(dbPass)) {
					request.getSession().setAttribute("usuario", username);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/welcome.jsp");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("failed", "true");
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}
	}

}
