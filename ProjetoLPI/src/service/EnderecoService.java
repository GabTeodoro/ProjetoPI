package service;

import dao.EnderecoDAO;
import model.Endereco;

public class EnderecoService {
	
		EnderecoDAO dao = new EnderecoDAO();
		
		public int criar(Endereco endereco) {
			return dao.criar(endereco);
		}
		
		public void atualizar(Endereco endereco){
			dao.atualizar(endereco);
		}
		
		public void excluir(int cep){
			dao.excluir(cep);
		}
		
		public Endereco carregar(int cep){
			return dao.carregar(cep);
		}

	}

