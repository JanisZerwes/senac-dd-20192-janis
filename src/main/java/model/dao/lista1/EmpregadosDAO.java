package model.dao.lista1;

import java.util.ArrayList;

import model.entity.lista1.Empregados;

public class EmpregadosDAO implements BaseDAO<Empregados> {

	public Empregados salvar(Empregado emp) {
		String sql = " INSERT INTO EMPREGADO (NOME, CPF, SEXO"
				+ " IDADE, SALARIOBRUTO, DESCONTOIR, DESCONTOPREVIDENCIA"
				+ " SALARIOBASE, SALARIO, COMISSAO, TIPO" ) ""
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,)";
	}

	public Empregados salvar(Empregados novaEntidade) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean alterar(Empregados entidade) {
		// TODO Auto-generated method stub
		return false;
	}

	public Empregados consultarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Empregados> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}
