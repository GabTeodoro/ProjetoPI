package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Produto;

public class ProdutoDAO {
	
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
	
	
	public void incluir(Produto to) {
		String sqlInsert = "INSERT INTO produto(nome, categoria, marca, estoque, preco, obs) VALUES (?, ?, ?, ?, ?, ?)";
// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getCategoria());
			stm.setString(3, to.getMarca());
			stm.setInt(4,  to.getEstoque());
			stm.setDouble(5, to.getPreco());
			stm.setString(6, to.getObs());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		  }
	}
	
	
	public void atualizar(Produto to) {
		String sqlUpdate = "UPDATE produto SET categoria=?, marca=?, estoque=?, WHERE nome=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getCategoria());
			stm.setString(3, to.getMarca());
			stm.setInt(4,  to.getEstoque());
			stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				  }
	}
	
	
	public void excluir(Produto to) {
		String sqlDelete = "DELETE FROM produto WHERE nome = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, to.getNome());
			stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				  }
	}
	
	
	public Produto carregar(String nome) {
		Produto to = new Produto();
		String sqlSelect = "SELECT categoria, marca, estoque FROM produto WHERE produto.nome = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();

				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
					stm.setString(1, nome);
					try (ResultSet rs = stm.executeQuery();) {
						if (rs.next()) {							
							to.setCategoria(rs.getString("categoria"));
							to.setMarca(rs.getString("marca"));
							to.setEstoque(rs.getInt("estoque"));
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
