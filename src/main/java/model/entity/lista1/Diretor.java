package model.entity.lista1;

public class Diretor extends Empregados {
	private double comissao;

	public Diretor(int id, String nome, String cpf, String sexo, int idade, double salarioBruto, Lotacao lotacao,
			double comissao) {
		super(id, nome, cpf, sexo, idade, salarioBruto, lotacao);
		this.comissao = comissao;

	}

	@Override
	public double calcularSalario() {
		return this.getSalarioBase() * 3 + this.comissao;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
}
