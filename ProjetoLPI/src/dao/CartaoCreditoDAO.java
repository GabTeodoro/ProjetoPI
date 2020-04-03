package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.CartaoCredito;

public class CartaoCreditoDAO {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		  }
	}
	
// Obtém conexão com o banco de dados
	public Connection obtemConexao() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost/tutorial?user=alunos&password=alunos");
	}
	
	
	public void incluir(CartaoCredito to) {
		String sqlInsert = "INSERT INTO CartaoCredito (nome, categoria, marca, estoque, preco, obs) VALUES (?, ?, ?, ?)";
// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNomeTit());
			stm.setString(2, to.getNumero());
			stm.setString(3, to.getDataVenc());
			stm.setString(4,  to.getCodSeg());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		  }
	}
	
	
	public void atualizar(CartaoCredito to) {
		String sqlUpdate = "UPDATE CartaoCredito SET numero=?, dataVenc=?, codSeg=?, WHERE nomeTit=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNomeTit());
			stm.setString(2, to.getNumero());
			stm.setString(3, to.getDataVenc());
			stm.setString(4,  to.getCodSeg());
			stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				  }
	}
	
	
	public void excluir(CartaoCredito to) {
		String sqlDelete = "DELETE FROM CartaoCredito WHERE nomeTit = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, to.getNomeTit());
			stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				  }
	}
	
	
	public CartaoCredito carregar(String nomeTit) {
		CartaoCredito to = new CartaoCredito();
		String sqlSelect = "SELECT numero, dataVenc, codSeg FROM cartaoCredito WHERE cartaoCredito.nomeTit = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
					stm.setString(1, nomeTit);
					try (ResultSet rs = stm.executeQuery();) {
						if (rs.next()) {							
							to.setNumero(rs.getString("numero"));
							to.setDataVenc(rs.getString("data vencimento"));
							to.setCodSeg(rs.getString("cod seg"));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					  }
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				  }
return to;
	}

}
