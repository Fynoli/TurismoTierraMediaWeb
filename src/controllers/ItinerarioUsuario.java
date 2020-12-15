package controllers;

import dao.*;
import models.Itinerario_detalle;
import models.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/itinerariousuario")
public class ItinerarioUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AtraccionDao aD;
    private PromocionDao pD;
    private UsuarioDao uD;
    private ItinerarioDao iD;

    public ItinerarioUsuario() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        aD = new AtraccionDao();
        uD = new UsuarioDao();
        pD = new PromocionDao();
        iD = new ItinerarioDao();

        List<String> lista = new ArrayList<String>();
        List<Itinerario_detalle> itinerario = new ArrayList<>();
        
        LinkedList<Integer> promosRepetidas=new LinkedList<Integer>();
        
        Usuario usuario = uD.getUno((Integer) request.getSession().getAttribute("usuarioId"));
        itinerario = iD.getItinerario(usuario);

        for (Itinerario_detalle id: itinerario){
            if(id.getPromo().getPromocion_id()!=4 && !promosRepetidas.contains(id.getPromo().getPromocion_id())) {
            	lista.add(id.generateData());
            	promosRepetidas.add(id.getPromo().getPromocion_id());
            }
        }
        for (Itinerario_detalle id: itinerario){
            if(id.getPromo().getPromocion_id()==4) {
            	lista.add(id.generateData());
            }
        }
        
        System.out.println(lista);
        request.setAttribute("itinerarios", lista);
        request.setAttribute("usuario", usuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/itinerariousuario.jsp");
        dispatcher.forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
