package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

/**
 * Servlet implementation class ManterProdutoController
 */
@WebServlet("/ManterProdutoController")
public class ManterProdutoController extends HttpServlet {
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
        int idProduto = Integer.parseInt (request.getParameter("idProduto"));
		String cNome = request.getParameter("nome");
        String cCategoria = request.getParameter("categoria");
		String cMarca = request.getParameter("marca");	
		int cEstoque = Integer.parseInt(request.getParameter("estoque"));
		double cPreco = Double.parseDouble(request.getParameter("preco"));
		String cObs = request.getParameter("obs");
		
        
        //instanciar o javabean
        Produto produto = new Produto();
        produto.setIdproduto(idProduto);
        produto.setNome(cNome);
        produto.setCategoria(cCategoria);
        produto.setMarca(cMarca);
        produto.setEstoque(cEstoque);
        produto.setPreco(cPreco);
        produto.setObs(cObs);
        
        //instanciar o service
        ProdutoService cs = new ProdutoService();
        cs.incluir(produto);
        produto = cs.carregar(produto.getNome());
        
        //enviar para o jsp
        request.setAttribute("produto", produto);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Produto.jsp");
        view.forward(request, response);
        
    }

}
