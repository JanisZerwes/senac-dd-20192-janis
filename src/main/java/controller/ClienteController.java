package controller;

import model.bo.ClienteBO;
import model.dao.ClienteDAO;
import model.entity.Cliente;
import model.entity.Endereco;

public class ClienteController {

	private ClienteBO bo = new ClienteBO();

	public String salvar(String nome, String sobrenome, String cpf, Endereco endereco) {
		StringBuilder sb = new StringBuilder();

		validarNome(nome, sb);
		validarCPF(cpf, sb);
		validarSobrenome(sobrenome, sb);
		validarEndereco(endereco, sb);

		return "";
	}

	private void validarEndereco(Endereco endereco, StringBuilder sb) {
		if (endereco == null) {
			sb.append("Você precisa fornecer um endereço !!! \n");
		}
	}

	private void validarSobrenome(String sobrenome, StringBuilder sb) {
		if (sobrenome == null || sobrenome.trim().length() < 3) {
			sb.append("Sobrenome deve conter no mínimo 3 caracteres \n");
		}

	}

	private void validarCPF(String cpf, StringBuilder sb) {
		if (cpf == null || cpf.trim().length() != 11) {
			sb.append("CPF deve conter 11 caracteres \n");
		} else {
			try {
				Long.parseLong(cpf);
			} catch (NumberFormatException ex) {
				sb.append("CPF deve conter somente números \n");
			}
		}

	}

	private void validarNome(String nome, StringBuilder sb) {
		if (nome == null || nome.trim().length() < 3) {
			sb.append("Nome deve conter no mínimo 3 caracteres \n");
		}

	}

	public String validarCamposSalvar(String nomeDigitado, String sobrenomeDigitado, String cpfDigitado,
			Endereco enderecoSelecionado) {
		String mensagem = "";
		if (nomeDigitado.isEmpty() || nomeDigitado.trim().length() < 3) {
			mensagem += "Nome deve possuir pelo menos três letras \n";
		}
		if (sobrenomeDigitado.isEmpty() || sobrenomeDigitado.trim().length() < 3) {
			mensagem += "Sobrenome deve possuir pelo menos três letras \n";
		}
		if (cpfDigitado.isEmpty() || cpfDigitado.trim().length() != 11) {
			mensagem += "Cpf deve possuir onze dígitos \n";
		}
		if (enderecoSelecionado == null) {
			mensagem += "Selecione um endereço \n";
		}

		return mensagem;
	}

	public Cliente salvar(Cliente novoCliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		novoCliente = clienteDAO.salvar(novoCliente);
		return novoCliente;
	}
}
