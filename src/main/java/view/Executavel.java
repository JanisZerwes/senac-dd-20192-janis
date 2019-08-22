package view;

import java.util.ArrayList;

import model.vo.Cliente;
import model.vo.Endereco;
import model.vo.Telefone;

public class Executavel {

	public static void main(String[] args) {

		Endereco end1 = new Endereco("Avenida Governador Jorge Lacerta", "00000000", "SC", "Florianópolis", "2275",
				"Costeira");
		Endereco end2 = new Endereco("Avenida pedro Ivo", "006650000", "SC", "Florianópolis", "275", "Trindade");
		Endereco end3 = new Endereco("Avenida Getulio Vargas", "0055647", "SC", "Florianópolis", "694", "Centro");
		Endereco end4 = new Endereco("Avenida Das Flores", "11224", "SC", "Florianópolis", "998", "Pantanal");
		Endereco end5 = new Endereco("Avenida Geronimo", "9574", "SC", "Florianópolis", "888", "São José");

		Telefone tel1 = new Telefone("55", "048", "9999999", "Movel", true);
		ArrayList<Telefone> lista1 = new ArrayList<Telefone>();
		lista1.add(tel1);
		Telefone tel2 = new Telefone("44", "047", "88888", "Fixo", true);
		ArrayList<Telefone> lista2 = new ArrayList<Telefone>();
		lista2.add(tel2);
		Telefone tel3 = new Telefone("33", "046", "666666", "Movel", true);
		ArrayList<Telefone> lista3 = new ArrayList<Telefone>();
		lista3.add(tel3);
		Telefone tel4 = new Telefone("22", "045", "555555", "Fixo", true);
		ArrayList<Telefone> lista4 = new ArrayList<Telefone>();
		lista4.add(tel4);
		Telefone tel5 = new Telefone("11", "044", "666666", "Movel", true);
		ArrayList<Telefone> lista5 = new ArrayList<Telefone>();
		lista5.add(tel5);

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		Cliente cliente1 = new Cliente("Janis", "08004239927", lista1, "Zerwes", end1);
		clientes.add(cliente1);
		Cliente cliente2 = new Cliente("Maickel", "69871299", lista1, "Zerwes", end2);
		clientes.add(cliente2);
		Cliente cliente3 = new Cliente("Pablo", "99823311", lista1, "Zerwes", end3);
		clientes.add(cliente3);
		Cliente cliente4 = new Cliente("José", "23356699", lista1, "Zerwes", end4);
		clientes.add(cliente4);
		Cliente cliente5 = new Cliente("Kassandra", "66923369", lista1, "Zerwes", end5);
		clientes.add(cliente5);

		for (Cliente c : clientes) {
			System.out.println(c);
		}
	}

}
