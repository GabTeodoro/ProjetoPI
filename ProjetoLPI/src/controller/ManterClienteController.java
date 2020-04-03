package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterClienteController")
public class ManterClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt (request.getParameter("id"));
		String cNome = request.getParameter("nome");
        String cEmail = request.getParameter("email");
		String cSenha = request.getParameter("senha");	
		String cCpf = request.getParameter("cpf");
		String cObs = request.getParameter("obs");
		
        
        //instanciar o javabean
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(cNome);
        cliente.setEmail(cEmail);
        cliente.setSenha(cSenha);
        cliente.setCpf(cCpf);
        cliente.setObs(cObs);
                
        //instanciar o service
        ClienteService cs = new ClienteService();
        cs.criar(cliente);
        cliente = cs.carregar(cliente.getId());
        
        //enviar para o jsp
        request.setAttribute("cliente", cliente);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Cliente.jsp");
        view.forward(request, response);
        
    }

}
