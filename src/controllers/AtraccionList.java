package controllers;

import dao.AtraccionDao;
import dao.UsuarioDao;
import models.Atraccion;
import models.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/atraccionlist")
public class AtraccionList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public AtraccionList() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Chequeo de permisos de administrador */

        UsuarioDao uD = new UsuarioDao();
        Usuario usuario = uD.getUno((Integer) request.getSession().getAttribute("usuarioId"));

        if (usuario.getEsadmin() == 1) {
            List<String> lista = new ArrayList<String>();
            AtraccionDao aD= new AtraccionDao();
            List<Atraccion> atracciones = aD.getAtracciones();
            for(Atraccion a : atracciones) {
                lista.add(a.generateData());
            }

            request.setAttribute("atracciones", lista);


            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/atraccionlist.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/no_permitido.jsp");
            dispatcher.forward(request, response);
        }
        /*--------------------------------*/
    }

}