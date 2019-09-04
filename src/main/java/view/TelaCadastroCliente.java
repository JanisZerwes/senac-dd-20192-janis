package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import controller.EnderecoController;
import controller.TelefoneController;
import model.dao.EnderecoDAO;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Telefone;

public class TelaCadastroCliente extends JFrame {

	private EnderecoController enderecoController = new EnderecoController();
	private JPanel contentPane;
	private JComboBox cbEndereco;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtCpf;
	private JSeparator separator;
	private JButton btnSalvar;
	private JLabel lblNewLabel;
	private JLabel lblCodigoPais;
	private JTextField txtCodPais;
	private JLabel lblDdd;
	private JTextField txtdDdd;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private Telefone novoTelefone = null;
	private Cliente novoCliente = null;
	private JLabel lblTipo;
	private ArrayList<Endereco> enderecos = new ArrayList();
	private ArrayList<Telefone> telefones = new ArrayList();
	private String[] nomesColunas = { "País", "DDD", "Número", "Tipo" };
	private JComboBox cbTipo = new JComboBox();

	private JSeparator separator_1;
	private JButton btnAdicionarTelefone;
	private JTable table;
	private JButton btnLimparTela;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroCliente() {
		setTitle("                                                                     Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 59, 56, 16);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(65, 56, 116, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(233, 59, 105, 16);
		contentPane.add(lblSobrenome);

		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(330, 56, 116, 22);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(506, 59, 56, 16);
		contentPane.add(lblCpf);

		MaskFormatter mascaraCpf;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(mascaraCpf);
		} catch (ParseException e) {

		}

		txtCpf.setBounds(574, 56, 116, 22);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);

		// Deletar DAO
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecos = enderecoDAO.consultarTodos();

		cbEndereco = new JComboBox();
		cbEndereco.setBounds(92, 128, 358, 22);
		for (Endereco end : enderecos) {
			cbEndereco.addItem(end);
		}
		cbEndereco.setSelectedIndex(-1);

		contentPane.add(cbEndereco);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(12, 131, 83, 16);
		contentPane.add(lblEndereco);

		separator = new JSeparator();
		separator.setBounds(12, 197, 758, 2);
		contentPane.add(separator);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController controladora = new ClienteController();
				String nomeDigitado = txtNome.getText();
				String sobrenomeDigitado = txtSobrenome.getText();
				String cpfDigitado = txtCpf.getText().replace("-", "").replace(".", "");
				Endereco enderecoSelecionado = (Endereco) cbEndereco.getSelectedItem();

				String mensagem = controladora.validarCamposSalvar(nomeDigitado, sobrenomeDigitado, cpfDigitado,
						enderecoSelecionado);
				if (mensagem.isEmpty()) {
					novoCliente = new Cliente(nomeDigitado, sobrenomeDigitado, cpfDigitado, new ArrayList<Telefone>(),
							enderecoSelecionado);
					novoCliente = controladora.salvar(novoCliente);
					if (novoCliente.getId() > 0) {
						btnAdicionarTelefone.setEnabled(true);
						btnSalvar.setEnabled(false);
					}
				} else {
					JOptionPane.showMessageDialog(null, mensagem);
				}

			}
		});
		btnSalvar.setBounds(673, 159, 97, 25);
		contentPane.add(btnSalvar);

		lblNewLabel = new JLabel("Novo Telefone");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(324, 211, 131, 16);
		contentPane.add(lblNewLabel);

		lblCodigoPais = new JLabel("C\u00F3digo Pa\u00EDs :");
		lblCodigoPais.setBounds(12, 243, 97, 16);
		contentPane.add(lblCodigoPais);

		txtCodPais = new JTextField();
		txtCodPais.setBounds(92, 240, 116, 22);
		contentPane.add(txtCodPais);
		txtCodPais.setColumns(10);

		lblDdd = new JLabel("DDD:");
		lblDdd.setBounds(220, 243, 56, 16);
		contentPane.add(lblDdd);

		txtdDdd = new JTextField();
		txtdDdd.setBounds(264, 240, 116, 22);
		contentPane.add(txtdDdd);
		txtdDdd.setColumns(10);

		lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(392, 243, 56, 16);
		contentPane.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(446, 240, 116, 22);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(574, 243, 56, 16);
		contentPane.add(lblTipo);

		cbTipo = new JComboBox();
		cbTipo.setBounds(613, 240, 157, 22);
		cbTipo.addItem("Móvel");
		cbTipo.addItem("Fixo");
		contentPane.add(cbTipo);
		cbTipo.setSelectedIndex(-1);

		separator_1 = new JSeparator();
		separator_1.setBounds(10, 327, 758, 2);
		contentPane.add(separator_1);

		btnAdicionarTelefone = new JButton("Adicionar Telefone");
		btnAdicionarTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelefoneController telefoneControler = new TelefoneController();
				String pais = txtCodPais.getText();
				String ddd = txtdDdd.getText();
				String numero = txtNumero.getText();
				String tipo = (String) cbTipo.getSelectedItem();
				String mensagem = telefoneControler.validarCamposSalvos(pais, ddd, numero, tipo);
				if (mensagem.isEmpty()) {

					novoTelefone = new Telefone(0, novoCliente, pais, ddd, numero, tipo, true);
					if (telefoneControler.consultarTelefoneRepetido(novoTelefone)) {
						JOptionPane.showMessageDialog(null, "Esse telefone já existe no banco");

					} else {
						novoTelefone = telefoneControler.salvar(novoTelefone);

					}

					if (novoTelefone.getId() > 0) {
						JOptionPane.showMessageDialog(null, "Telefone Cadastrado");
						limparTabela();
						atualizarTabelaTelefones();
						limparTelaTelefone();
					}
				} else {
					JOptionPane.showMessageDialog(null, mensagem);
				}
			}

		});
		btnAdicionarTelefone.setBounds(298, 289, 157, 25);
		contentPane.add(btnAdicionarTelefone);
		btnAdicionarTelefone.setEnabled(false);

		table = new JTable();
		table.setBounds(33, 371, 717, 181);
		contentPane.add(table);
		limparTabela();
		atualizarTabelaTelefones();

		JLabel lblTelefonesDoCliente = new JLabel("Telefones do Cliente ");
		lblTelefonesDoCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefonesDoCliente.setBounds(298, 342, 157, 16);
		contentPane.add(lblTelefonesDoCliente);

		btnLimparTela = new JButton("Limpar Tela");
		btnLimparTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTelaCliente();
				limparTelaTelefone();
				limparTabela();
				btnSalvar.setEnabled(true);
				btnAdicionarTelefone.setEnabled(false);
			}

		});
		btnLimparTela.setBounds(330, 588, 116, 25);
		contentPane.add(btnLimparTela);
	}

	private void atualizarTabelaTelefones() {

		TelefoneController telefoneController = new TelefoneController();
		if (novoCliente != null) {
			telefones = telefoneController.consultarTodosPorCliente(novoCliente.getId());
		}
		limparTabela();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (Telefone telefone : telefones) {
			String[] novaLinha = new String[5];
			novaLinha[0] = telefone.getCodigoPais();
			novaLinha[1] = telefone.getDdd();
			novaLinha[2] = telefone.getNumero();
			novaLinha[3] = telefone.getTipoLinha();
			model.addRow(novaLinha);
		}
	}

	private void limparTabela() {
		table.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));

	}

	// txtCodPais , txtdDdd , txtNumero , cbTipo
	private void limparTelaTelefone() {
		txtCodPais.setText("");
		txtdDdd.setText("");
		txtNumero.setText("");
		cbTipo.setSelectedIndex(-1);

	}

	private void limparTelaCliente() {
		txtNome.setText("");
		txtCpf.setText("");
		txtSobrenome.setText("");
		cbEndereco.setSelectedIndex(-1);

	}
}
