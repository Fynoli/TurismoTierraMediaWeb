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
import dao.ItinerarioDao;
import dao.PromocionDao;
import dao.UsuarioDao;
import models.Atraccion;
import models.Itinerario_detalle;
import models.Promocion;
import models.Usuario;

/**
 * Servlet implementation class RealizarCompra
 */
@WebServlet("/realizarcompra")
public class RealizarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealizarCompra() {
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
		/*Se obtiene el usuario que realiza la compra*/
		UsuarioDao uD = new UsuarioDao();
		Usuario usuario = uD.getUno((Integer) request.getSession().getAttribute("usuarioId"));
		
		/*Necesario para saber que producto fue comprado*/
		Integer idProducto= Integer.parseInt((String) request.getAttribute("idProducto"));
		
		/*Esto es necesario para distinguir paquetes de atracciones simples*/
		String tipoProducto= (String) request.getAttribute("tipoProducto");
		
		/*Se obtiene el itinerario del usuario que realiza la compra*/
		ItinerarioDao iD= new ItinerarioDao();
		Itinerario_detalle producto=new Itinerario_detalle();
		
		/*Daos necesarios*/
		PromocionDao pD=new PromocionDao();
		AtraccionDao aD=new AtraccionDao();
		
		/*Se setea el comprador del producto*/
		producto.setUsuario(usuario);
		
		/*El producto comprado es una atraccion simple*/
		if(!tipoProducto.equals("Paquete")) {
			producto.setAtraccion(aD.getUna(idProducto));
			producto.setPromo(pD.getUna(4));//Promocion vacia
			
			/*Se agrega la entrada al itinerario del usuario*/
			iD.agregarProducto(producto);
			
			/*Se le quita el tiempo y dinero gastado al comprador*/
			usuario.setPresupuesto(usuario.getPresupuesto()-producto.getAtraccion().getCosto());
			usuario.setTiempo_disponible(usuario.getTiempo_disponible()-producto.getAtraccion().getTiempo());
			uD.update(usuario);
		}
		/*El producto comprado es un paquete*/
		else {
			Promocion promo=pD.getUna(idProducto);
			for(Atraccion a: promo.getAtracciones()) {
				producto.setAtraccion(a);
				producto.setPromo(promo);
				
				/*Se agrega una entrada por cada atraccion del paquete comprado*/
				iD.agregarProducto(producto);
			}
			/*Se le quita el tiempo y dinero gastado al comprador*/
			usuario.setPresupuesto(usuario.getPresupuesto()-producto.getPromo().getCosto());
			usuario.setTiempo_disponible(usuario.getTiempo_disponible()-producto.getPromo().getTiempo());
			uD.update(usuario);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("compra");
		dispatcher.forward(request, response);
	}

}
