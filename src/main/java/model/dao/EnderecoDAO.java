package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Endereco;

public class EnderecoDAO implements BaseDAO<Endereco> {

	public Endereco salvar(Endereco novoEndereco) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO ENDERECO(RUA, CEP, ESTADO, CIDADE, BAIRRO, NUMERO) " + " VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql, PreparedStatement.RETURN_GENERATED_KEYS);
		try {
			stmt.setString(1, novoEndereco.getRua());
			stmt.setString(2, novoEndereco.getCep());
			stmt.setString(3, novoEndereco.getEstado());
			stmt.setString(4, novoEndereco.getCidade());
			stmt.setString(5, novoEndereco.getBairro());
			stmt.setString(6, novoEndereco.getNumero());

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				int idGerado = rs.getInt(1);
				novoEndereco.setId(idGerado);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo endereço.");
			System.out.println("Erro: " + e.getMessage());
		}

		return novoEndereco;
	}

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM ENDERECO WHERE ID=" + id;
		Statement stmt = Banco.getStatement(conn);

		int quantidadeLinhasAfetadas = 0;
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir endereco.");
			System.out.println("Erro: " + e.getMessage());
		}

		return quantidadeLinhasAfetadas > 0;
	}

	public boolean alterar(Endereco endereco) {
		Connection conn = Banco.getConnection();
		// (int id, String rua, String cep, String estado, String cidade, String numero,
		// String bairro) {

		String sql = " UPDATE ENDERECO " + " SET rua=?, cep=?, estado=?, cidade=?, numedo=?, bairo=? " + " WHERE ID=? ";

		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		int quantidadeLinhasAfetadas = 0;

		try {
			stmt.setString(1, endereco.getRua());
			stmt.setString(2, endereco.getCep());
			stmt.setString(3, endereco.getEstado());
			stmt.setString(4, endereco.getCidade());
			stmt.setString(5, endereco.getNumero());
			stmt.setString(6, endereco.getBairro());
			stmt.setInt(7, endereco.getId());
			quantidadeLinhasAfetadas = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar endereco.");
			System.out.println("Erro: " + e.getMessage());
		}

		return quantidadeLinhasAfetadas > 0;
	}

	public Endereco consultarPorId(int id) {
		Connection conn = Banco.getConnection();
		String sql = " SELECT id, Rua, Cep, Estado, Cidade, Numero, Bairro " + " FROM ENDERECO " + " WHERE ID=" + id;

		Statement stmt = Banco.getStatement(conn);

		Endereco endereco = null;
		try {
			ResultSet resultadoDaConsulta = stmt.executeQuery(sql);

			if (resultadoDaConsulta.next()) {
				endereco = construirEnderecoDoResultSet(resultadoDaConsulta);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar endereco por id = " + id);
			System.out.println("Erro: " + e.getMessage());
		}

		return endereco;
	}

	public ArrayList<Endereco> consultarTodos() {
		Connection conn = Banco.getConnection();
		String sql = " SELECT id, Rua, Cep, Estado, Cidade, Numero, Bairro " + " FROM ENDERECO ";

		Statement stmt = Banco.getStatement(conn);
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		try {
			ResultSet resultadoDaConsulta = stmt.executeQuery(sql);

			while (resultadoDaConsulta.next()) {
				Endereco endereco = construirEnderecoDoResultSet(resultadoDaConsulta);
				enderecos.add(endereco);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar endereco");
			System.out.println("Erro: " + e.getMessage());
		}

		return enderecos;
	}

	private Endereco construirEnderecoDoResultSet(ResultSet resultadoDaConsulta) {
		Endereco endereco;
		endereco = new Endereco();
		try {
			endereco.setId(resultadoDaConsulta.getInt("id"));
			endereco.setRua(resultadoDaConsulta.getString("Rua"));
			endereco.setCep(resultadoDaConsulta.getString("Cep"));
			endereco.setEstado(resultadoDaConsulta.getString("Estado"));
			endereco.setCidade(resultadoDaConsulta.getString("Cidade"));
			endereco.setNumero(resultadoDaConsulta.getString("Numero"));
			endereco.setBairro(resultadoDaConsulta.getString("Bairro"));
		} catch (SQLException e) {
			System.out.println("Erro ao construir endereco a partir do ResultSet");
			System.out.println("Erro: " + e.getMessage());
		}

		return endereco;
	}

}
