package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Endereco;

public class EnderecoDAO {
	public int criar(Endereco endereco) {
		String sqlInsert = "INSERT INTO clientes(CEP, rua, comp, numero, tel, bairro, cidade, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, endereco.getCep());
			stm.setString(2, endereco.getRua());
			stm.setString(3, endereco.getComp());
			stm.setString(4, endereco.getNum());
			stm.setInt(5, endereco.getTel());
			stm.setString(6, endereco.getBairro());
			stm.setString(7, endereco.getCidade());
			stm.setString(8, endereco.getEstado());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					endereco.setCep(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return endereco.getCep();
	}

	public void atualizar(Endereco endereco) {
		String sqlUpdate = "UPDATE clientes SET rua=?, comp=?, num=?, tel=?, bairro=?, cidade=?, estado=? WHERE cep=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, endereco.getRua());
			stm.setString(2, endereco.getComp());
			stm.setString(3, endereco.getNum());
			stm.setInt(4, endereco.getTel());
			stm.setString(5, endereco.getBairro());
			stm.setString(6, endereco.getCidade());
			stm.setString(7, endereco.getEstado());
			stm.setInt(8, endereco.getCep());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int cep) {
		String sqlDelete = "DELETE FROM endereco WHERE cep = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, cep);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Endereco carregar(int cep) {
		Endereco endereco = new Endereco();
		endereco.setCep(cep);
		String sqlSelect = "SELECT rua, comp, num, tel, bairro, cidade, estado FROM endereco WHERE endereco.cep = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, endereco.getCep());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					endereco.setRua(rs.getString("rua"));
					endereco.setComp(rs.getString("comp"));
					endereco.setNum(rs.getString("num"));
					endereco.setTel(rs.getInt("tel"));
					endereco.setBairro(rs.getString("bairro"));
					endereco.setCidade(rs.getString("cidade"));
					endereco.setEstado(rs.getString("estado"));
				} else {
					endereco.setCep(0);
					endereco.setRua(null);
					endereco.setComp(null);
					endereco.setNum(null);
					endereco.setTel(0);
					endereco.setBairro(null);
					endereco.setCidade(null);
					endereco.setEstado(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return endereco;
	}

}


