package model.dao.lista1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.lista1.Diretor;
import model.entity.lista1.Diretoria;

public class DiretoriaDAO implements BaseDAO<Diretoria> {

	public Diretor salvar(Diretor novaDiretoria) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO OPERACIONAL (nome, cpf, sexo, idade, salBruto ) " + " VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, PreparedStatement.RETURN_GENERATED_KEYS);

		try {
			stmt.setString(1, novaDiretoria.getNome());
			stmt.setString(2, novaDiretoria.getCpf());
			stmt.setString(3, novaDiretoria.getSexo());
			stmt.setInt(4, novaDiretoria.getIdade());
			stmt.setDouble(5, novaDiretoria.getSalarioBruto());
			stmt.setInt(6, novaDiretoria.getId());
			stmt.execute();

			ResultSet generatedKeys = stmt.getGeneratedKeys();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir Diretor .");
			System.out.println("Erro: " + e.getMessage());
		}

		return novaDiretoria;
	}

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM DIRETOR WHERE ID=" + id;
		Statement stmt = Banco.getStatement(conn);

		int quantidadeLinhasAfetadas = 0;
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir diretor.");
			System.out.println("Erro: " + e.getMessage());
		}

		return quantidadeLinhasAfetadas > 0;
	}

	public boolean alterar(Diretor diretor) {
		Connection conn = Banco.getConnection();
		// (int id, String rua, String cep, String estado, String cidade, String numero,
		// String bairro) {

		String sql = " UPDATE DIRETOR " + " SET nome=?, cpf=?, sexo=?, idade=?, salBruto=?, id=?" + " WHERE ID=? ";

		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		int quantidadeLinhasAfetadas = 0;

		try {
			stmt.setString(1, diretor.getNome());
			stmt.setString(2, diretor.getCpf());
			stmt.setString(3, diretor.getSexo());
			stmt.setInt(4, diretor.getIdade());
			stmt.setDouble(5, diretor.getSalarioBruto());
			stmt.setInt(5, diretor.getId());

			quantidadeLinhasAfetadas = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar diretor.");
			System.out.println("Erro: " + e.getMessage());
		}

		return quantidadeLinhasAfetadas > 0;
	}

	public Diretoria consultarPorId(int id) {
		Connection conn = Banco.getConnection();
		String sql = " SELECT  Nome, Cpf, Sexo, Idade, salBruto,id " + " FROM OPERACIONAL " + " WHERE ID=" + id;

		Statement stmt = Banco.getStatement(conn);

		Diretor diretor = null;
		try {
			ResultSet resultadoDaConsulta = stmt.executeQuery(sql);

			if (resultadoDaConsulta.next()) {
				diretor = construirDiretorDoResultSet(resultadoDaConsulta);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar diretor por id = " + id);
			System.out.println("Erro: " + e.getMessage());
		}

		return diretor;
	}

	private Diretor construirDiretorDoResultSet(ResultSet resultadoDaConsulta) {
		Diretor diretor;
		diretor = new Diretor();
		try {

			diretor.setNome(resultadoDaConsulta.getString("Nome"));
			diretor.setCpf(resultadoDaConsulta.getString("Cpf"));
			diretor.setSexo(resultadoDaConsulta.getString("Sexo"));
			diretor.setIdade(resultadoDaConsulta.getInt("Idade"));
			diretor.setSalarioBruto(resultadoDaConsulta.getDouble("salBruto"));
			diretor.setId(resultadoDaConsulta.getInt("Id"));

		} catch (SQLException e) {
			System.out.println("Erro ao construir diretor a partir do ResultSet");
			System.out.println("Erro: " + e.getMessage());
		}

		return diretor;
	}

	public ArrayList<Diretoria> consultarTodos() {
		Connection conn = Banco.getConnection();
		String sql = " SELECT Nome, cpf, sexo, idade, salBruto, id " + " FROM OPERACIONAL ";

		Statement stmt = Banco.getStatement(conn);
		ArrayList<Diretor> diretores = new ArrayList<Diretor>();
		try {
			ResultSet resultadoDaConsulta = stmt.executeQuery(sql);

			while (resultadoDaConsulta.next()) {
				Diretor diretor = construirDiretorDoResultSet(resultadoDaConsulta);
				diretores.add(diretor);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar endereco");
			System.out.println("Erro: " + e.getMessage());
		}

		return diretores;
	}

	public Diretoria salvar(Diretoria novaDiretoria) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean alterar(Diretoria entidade) {
		// TODO Auto-generated method stub
		return false;
	}

}
