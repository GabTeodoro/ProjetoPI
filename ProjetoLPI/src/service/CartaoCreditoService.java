package service;

import dao.CartaoCreditoDAO;
import model.CartaoCredito;

public class CartaoCreditoService {
	CartaoCreditoDAO dao = new CartaoCreditoDAO();
	
	public void incluir (CartaoCredito to) {
		dao.incluir(to);
	}
	
	public void atualizar (CartaoCredito to) {
	    dao.atualizar(to);
	}
	
	public void excluir (CartaoCredito to) {
		dao.excluir(to);
	}
	
	public CartaoCredito carregar (String nomeTit) {
		return dao.carregar(nomeTit);
	}
}
