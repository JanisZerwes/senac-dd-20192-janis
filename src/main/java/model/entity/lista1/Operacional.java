package model.entity.lista1;

public class Operacional extends Empregados {

	public Operacional() {
		super();

	}

	public Operacional(int id, String nome, String cpf, String sexo, int idade, double salarioBruto, Lotacao lotacao) {
		super(id, nome, cpf, sexo, idade, salarioBruto, lotacao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularSalario() {
		return this.getSalarioBase() * 0.85;
	}

}
