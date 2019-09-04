package model.bo;

import model.dao.TelefoneDAO;
import model.entity.Telefone;

public class TelefoneBO {

	public Telefone salvar(Telefone novoTelefone) {
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		novoTelefone = telefoneDAO.salvar(novoTelefone);

		return novoTelefone;
	}

}
