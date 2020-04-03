package service;

import model.Produto;
import dao.ProdutoDAO;
public class ProdutoService {
	ProdutoDAO dao = new ProdutoDAO();
	
	public void incluir(Produto produto) {
		dao.incluir(produto);
	}
	public void atualizar(Produto produto) {
		dao.atualizar(produto);
	}
	public void excluir(Produto produto) {
		dao.excluir(produto);
	}
	public Produto carregar(String nome) {
		return dao.carregar(nome);
	}
}
