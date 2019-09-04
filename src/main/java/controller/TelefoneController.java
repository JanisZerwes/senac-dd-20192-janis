package controller;

import java.util.ArrayList;

import model.bo.TelefoneBO;
import model.dao.TelefoneDAO;
import model.entity.Telefone;

public class TelefoneController {
	private TelefoneBO telefoneBO = new TelefoneBO();

	public ArrayList<Telefone> consultarTodos() {
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		ArrayList<Telefone> telefones = telefoneDAO.consultarTodos();
		return telefones;
	}

	public String validarCamposSalvos(String pais, String ddd, String numero, String tipo) {
		String mensagem = "";
		if (pais.isEmpty() || pais.length() > 2) {
			mensagem += "Código do País deve ter entre 1 e 2 dígitos \n";
		}
		if (ddd.isEmpty() || ddd.length() > 2) {
			mensagem += "DDD deve ter entre 1 e 2 dígitos \n";
		}
		if (numero.isEmpty() || numero.length() < 6 || numero.length() > 12) {
			mensagem += "Número deve ter entre 6 e 12 dígitos \n";
		}
		if (tipo == null) {
			mensagem += "Selecione o tipo de telefone \n";
		}
		return mensagem;
	}

	public Telefone salvar(Telefone novoTelefone) {
		novoTelefone = telefoneBO.salvar(novoTelefone);
		return novoTelefone;
	}

	public ArrayList<Telefone> consultarTodosPorCliente(int id) {
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		ArrayList<Telefone> telefones = telefoneDAO.consultarTodosPorIdCliente(id);
		return telefones;
	}

	public boolean consultarTelefoneRepetido(Telefone novoTelefone) {
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		return telefoneDAO.consultarTelefoneRepetido(novoTelefone);

	}
}
