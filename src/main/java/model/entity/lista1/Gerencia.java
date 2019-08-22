package model.entity.lista1;

import java.util.ArrayList;

public class Gerencia extends Lotacao {
	private Gerente gerente;
	private ArrayList<Operacional> Operacionais;

	public Gerencia(String nome, String sigla, Gerente gerente, ArrayList<Operacional> operacionais) {
		super(nome, sigla);
		this.gerente = gerente;
		this.Operacionais = operacionais;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public ArrayList<Operacional> getFuncionariosOperacionais() {
		return Operacionais;
	}

	public void setFuncionariosOperacionais(ArrayList<Operacional> funcionariosOperacionais) {
		this.Operacionais = funcionariosOperacionais;
	}

	@Override
	public String toString() {
		return "Gerencia [gerente=" + gerente + ", funcionariosOperacionais=" + Operacionais + "]";
	}
}
