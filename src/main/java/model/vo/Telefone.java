package model.vo;

public class Telefone {
	private int id;
	private int idCliente;
	private String codgoPais;
	private String DDD;
	private String numero;
	private String tipo;
	private boolean ativo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCodgoPais() {
		return codgoPais;
	}

	public void setCodgoPais(String codgoPais) {
		this.codgoPais = codgoPais;
	}

	public String getDDD() {
		return DDD;
	}

	public void setDDD(String dDD) {
		DDD = dDD;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Telefone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Telefone(int id, int idCliente, String codgoPais, String dDD, String numero, String tipo, boolean ativo) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.codgoPais = codgoPais;
		DDD = dDD;
		this.numero = numero;
		this.tipo = tipo;
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return codgoPais + ", " + DDD + ", " + numero + " , " + tipo + " , " + ativo;
	}

}
