package model.entity.lista1;

public abstract class Empregados {
	private int id;
	private String nome;
	private String cpf;
	private String sexo;
	private int idade;
	private double salarioBruto;
	private Lotacao lotacao;
	private double descontoImpostoRenda;
	private double descontoPrevidencia;
	private double salarioBase;

	public Empregados() {
		super();
	}

	public abstract double calcularSalario();

	public Empregados(int id, String nome, String cpf, String sexo, int idade, double salarioBruto, Lotacao lotacao) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.idade = idade;
		this.salarioBruto = salarioBruto;
		this.lotacao = lotacao;
		calcularSalarioBase();
	}

	private void calcularSalarioBase() {
		calcularDescontoIR();
		calcularDescontoPrevidencia();
		salarioBase = this.salarioBruto - (this.descontoImpostoRenda + this.descontoPrevidencia);
	}

	public void calcularDescontoIR() {
		double descontoImpostoRendaCalculado = 0;

		if (this.salarioBruto >= 1800 && this.salarioBruto <= 3000) {
			descontoImpostoRendaCalculado = this.salarioBruto * 0.1;
		} else if (this.salarioBruto > 3000) {
			descontoImpostoRendaCalculado = this.salarioBruto * 0.15;
		}
		this.descontoImpostoRenda = descontoImpostoRendaCalculado;
	}

	public void calcularDescontoPrevidencia() {
		if (this.idade < 45) {
			setDescontoPrevidencia(this.getSalarioBruto() * 0.12);
		} else if (this.salarioBruto > 3000) {
			setDescontoPrevidencia(this.getSalarioBruto() * 0.08);
		}
	}

	public int getId() {
		return id;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public double getDescontoImpostoRenda() {
		return descontoImpostoRenda;
	}

	public void setDescontoImpostoRenda(double descontoImpostoRenda) {
		this.descontoImpostoRenda = descontoImpostoRenda;
	}

	public double getDescontoPrevidencia() {
		return descontoPrevidencia;
	}

	public void setDescontoPrevidencia(double descontoPrevidencia) {
		this.descontoPrevidencia = descontoPrevidencia;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double descontoImposto() {
		double descontoImposto = 0;
		double salbruto = this.getSalarioBruto();
		if (salbruto < 1800) {
			descontoImposto = 0;
		} else if (salbruto >= 1800 || salbruto <= 3000) {
			descontoImposto = salbruto * 0.1;

		} else {
			descontoImposto = salbruto * 0.15;

		}
		return descontoImposto;
	}

	public double contribuicaoPrevidenciaria() {
		double contribuicao = 0;
		if (this.idade < 45) {
			contribuicao = this.getSalarioBruto() * 0.12;
		} else {
			contribuicao = this.getSalarioBruto() * 0.08;
		}

		return contribuicao;
	}

	public double salBase() {
		double salarioBase = this.getSalarioBruto() - this.contribuicaoPrevidenciaria() - this.descontoImposto();
		return salarioBase;
	}

	@Override
	public String toString() {
		return "Empregados [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo + ", idade=" + idade
				+ ", salBruto=" + salarioBruto + "]";
	}
}
