package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CartaoCredito;
import service.CartaoCreditoService;
//controller do cartao so por precaucao

/**
 * Servlet implementation class ManterCartaoCreditoController
 */
@WebServlet("/ManterCartaoCreditoController")
public class ManterCartaoCreditoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pId = Integer.parseInt (request.getParameter("idcartao"));
		String pCod= request.getParameter("codSeg");
		String pData = request.getParameter("dataVenc");
		String pNome = request.getParameter("nomeTit");
		String pNumero = request.getParameter("numero");
		
		//intanciando javabean
		CartaoCredito cart = new CartaoCredito();
		cart.setIdcartao(pId);
		cart.setCodSeg(pCod);
		cart.setDataVenc(pData);
		cart.setNomeTit(pNome);
		cart.setNumero(pNumero);
		
		//instanciando service
		CartaoCreditoService cs = new CartaoCreditoService();
		cs.incluir(cart);
		cart = cs.carregar(cart.getNomeTit());
		
		//enviar jsp
		request.setAttribute("cartaoCredito", cart);
		
		RequestDispatcher view = request.getRequestDispatcher("Cartao.jsp");
		view.forward(request, response);
		
		
		
	}

}
