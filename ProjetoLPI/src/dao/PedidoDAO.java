package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pedido;

public class PedidoDAO {
	public int criar(Pedido pedido) {
		String sqlInsert = "INSERT INTO pedido(nome, quantidade, data, obs) VALUES (?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, pedido.getNome());
			stm.setInt(2, pedido.getQuantidade());
			stm.setDate(3, (Date) pedido.getData());
			stm.setString(4, pedido.getObs());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					pedido.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedido.getId();
	}

	public void atualizar(Pedido pedido) {
		String sqlUpdate = "UPDATE pedido SET nome=?, quantidade=?, data=?, obs=? WHERE Id_pedido=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, pedido.getNome());
			stm.setInt(2, pedido.getQuantidade());
			stm.setDate(3, (Date)pedido.getData());
			stm.setString(4, pedido.getObs());
			stm.setInt(5, pedido.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM pedido WHERE Id_pedido = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Pedido carregar(int id) {
		Pedido pedido = new Pedido();
		pedido.setId(id);
		String sqlSelect = "SELECT nome, quantidade, data, obs FROM pedido WHERE pedido.Id_pedido = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, pedido.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					pedido.setNome(rs.getString("nome"));
					pedido.setQuantidade(rs.getInt("quantidade"));
					pedido.setData(rs.getDate("data"));
					pedido.setObs(rs.getString("obs"));
				} else {
					pedido.setId(-1);
					pedido.setNome(null);
					pedido.setQuantidade(0);
					pedido.setData(null);
					pedido.setObs(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pedido;
	}

}


