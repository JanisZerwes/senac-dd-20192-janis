package controller;

import model.bo.EnderecoBO;
import model.entity.Endereco;

public class EnderecoController {

	private EnderecoBO bo = new EnderecoBO();

	public EnderecoController() {

	}

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
			sb.append("Voc� precisa fornecer um endere�o !!! \n");
		}
	}

	private void validarSobrenome(String sobrenome, StringBuilder sb) {
		if (sobrenome == null || sobrenome.trim().length() < 3) {
			sb.append("Sobrenome deve conter no m�nimo 3 caracteres \n");
		}

	}

	private void validarCPF(String cpf, StringBuilder sb) {
		if (cpf == null || cpf.trim().length() != 11) {
			sb.append("CPF deve conter 11 caracteres \n");
		} else {
			try {
				Long.parseLong(cpf);
			} catch (NumberFormatException ex) {
				sb.append("CPF deve conter somente n�meros \n");
			}
		}

	}

	private void validarNome(String nome, StringBuilder sb) {
		if (nome == null || nome.trim().length() < 3) {
			sb.append("Nome deve conter no m�nimo 3 caracteres \n");
		}

	}
}
