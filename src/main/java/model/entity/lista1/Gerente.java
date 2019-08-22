package model.entity.lista1;

public class Gerente extends Empregados {
	private double comissao;

	public Gerente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gerente(int id, String nome, String cpf, String sexo, int idade, double salarioBruto, Lotacao lotacao) {
		super(id, nome, cpf, sexo, idade, salarioBruto, lotacao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularSalario() {
		return this.getSalarioBase() * 0.9 + this.comissao;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	@Override
	public String toString() {
		return "Gerente [comissao=" + comissao + "]";
	}
}
