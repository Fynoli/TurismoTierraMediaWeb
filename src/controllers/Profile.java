package controllers;

import database.Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class Profile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Profile() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Integer userid = (Integer) request.getSession().getAttribute("userid");
        String dbUser = null;
        Integer dbPresupuesto = null;
        Double dbTiempo = null;
        String dbGustos = null;
        Connection con = null;
        String query = "SELECT usuario.nombre, usuario.presupuesto, \r\n"
                +"usuario.tiempo_disponible, tipo_atraccion.nombre as tipo_atraccion \r\n"
                +" FROM usuario \r\n"
                +" JOIN tipo_atraccion on usuario.atraccion_favorita=tipo_atraccion.tipo_atraccion_id \r\n"
                +" AND usuario.usuario_id =" + userid;
        try {
            con = Database.getInstance().getConnection();
            final PreparedStatement ps = con.prepareStatement(query);
            final ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dbUser = rs.getString("nombre");
                dbPresupuesto = rs.getInt("presupuesto");
                dbTiempo = rs.getDouble("tiempo_disponible");
                dbGustos = rs.getString("tipo_atraccion");

            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            

        }
        //seteo el atributo para pasar al .jsp
        request.setAttribute("dbUser", dbUser);
        request.setAttribute("dbPresupuesto", dbPresupuesto);
        request.setAttribute("dbTiempo", dbTiempo);
        request.setAttribute("dbGustos", dbGustos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/profile.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }
}
