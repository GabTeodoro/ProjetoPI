package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Endereco;
import service.EnderecoService;

/**
 * Servlet implementation class ManterEnderecoController
 */
@WebServlet("/ManterEnderecoController")
public class ManterEnderecoController extends HttpServlet {
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
		String pBairro = request.getParameter("bairro");
		int pCep = Integer.parseInt(request.getParameter("cep"));
		String pCidade = request.getParameter("cidade");
		String pComp = request.getParameter("comp");
		String pEstado = request.getParameter("estado");
		String pNum = request.getParameter("num");
		String pRua = request.getParameter("rua");
		int pTel = Integer.parseInt(request.getParameter("tel"));
		
		//instanciando javabean
		Endereco end = new Endereco();
		end.setBairro(pBairro);
		end.setCep(pCep);
		end.setCidade(pCidade);
		end.setComp(pComp);
		end.setEstado(pEstado);
		end.setNum(pNum);
		end.setRua(pRua);
		end.setTel(pTel);
		
		//instanciando service
		EnderecoService es = new EnderecoService();
		es.criar(end);
		//essa linha faz sentido? end = es.carregar(end.getCep());
		
		//enviar para o jsp?
		request.setAttribute("endereco", end);
		
		RequestDispatcher view = request.getRequestDispatcher("Endereco.jsp");
		view.forward(request, response);
				
		
	}

}
