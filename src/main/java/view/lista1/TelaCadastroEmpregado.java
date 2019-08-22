package view.lista1;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class TelaCadastroEmpregado {

	private JFrame frame;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField txtComissao;
	private JTextField txtSalario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEmpregado window = new TelaCadastroEmpregado();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroEmpregado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 28, 56, 16);
		frame.getContentPane().add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(12, 57, 56, 16);
		frame.getContentPane().add(lblCpf);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(12, 86, 56, 16);
		frame.getContentPane().add(lblIdade);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(12, 115, 56, 16);
		frame.getContentPane().add(lblSexo);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(12, 143, 56, 16);
		frame.getContentPane().add(lblTipo);

		JLabel lblSalarioBruto = new JLabel("Sal\u00E1rio Bruto:");
		lblSalarioBruto.setBounds(12, 172, 109, 16);
		frame.getContentPane().add(lblSalarioBruto);

		JLabel lblComissão = new JLabel("Comiss\u00E3o:");
		lblComissão.setBounds(12, 201, 86, 16);
		frame.getContentPane().add(lblComissão);

		textNome = new JTextField();
		textNome.setBounds(132, 25, 116, 22);
		frame.getContentPane().add(textNome);
		textNome.setColumns(10);

		textCpf = new JTextField();
		textCpf.setBounds(132, 54, 116, 22);
		frame.getContentPane().add(textCpf);
		textCpf.setColumns(10);

		JRadioButton rbdMasculino = new JRadioButton("M");
		rbdMasculino.setBounds(140, 111, 56, 25);
		frame.getContentPane().add(rbdMasculino);

		JRadioButton rbdFemenino = new JRadioButton("F");
		rbdFemenino.setBounds(207, 111, 41, 25);
		frame.getContentPane().add(rbdFemenino);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(131, 140, 117, 22);
		frame.getContentPane().add(comboBox);

		txtComissao = new JTextField();
		txtComissao.setBounds(132, 198, 116, 22);
		frame.getContentPane().add(txtComissao);
		txtComissao.setColumns(10);

		JSpinner spnIdade = new JSpinner();
		spnIdade.setBounds(132, 83, 116, 22);
		frame.getContentPane().add(spnIdade);

		txtSalario = new JTextField();
		txtSalario.setBounds(132, 169, 116, 22);
		frame.getContentPane().add(txtSalario);
		txtSalario.setColumns(10);
	}
}
