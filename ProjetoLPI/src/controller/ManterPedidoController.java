package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pedido;
import service.PedidoService;

/**
 * Servlet implementation class ManterPedidoController
 */
@WebServlet("/ManterPedidoController")
public class ManterPedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManterPedidoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int pid = Integer.parseInt (request.getParameter("id"));
		 String pnome = request.getParameter("nome");
		 int pidProduto = Integer.parseInt(request.getParameter("idProduto"));
		 int pidCliente = Integer.parseInt(request.getParameter("idCliente"));
		 int pquantidade = Integer.parseInt(request.getParameter("quantidade"));
		 
		 String pdata = request.getParameter("data");
		 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		 Date pdt = null;
		try {
			pdt = formato.parse(pdata);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String pobs = request.getParameter("obs");
		 
		 Pedido pedido = new Pedido();
	        pedido.setId(pid);
	        pedido.setNome(pnome);
	        pedido.setIdProduto(pidProduto);
	        pedido.setIdCliente(pidCliente);
	        pedido.setQuantidade(pquantidade);
	        pedido.setData(pdt);
	        pedido.setObs(pobs);
	        
	        PedidoService ps = new PedidoService();
			ps.criar(pedido);
			pedido = ps.carregar(pedido.getId
					());
			
			request.setAttribute("pedido", pedido);
			
			RequestDispatcher view = 
			        request.getRequestDispatcher("Pedido.jsp");
			        view.forward(request, response);
	}

}
