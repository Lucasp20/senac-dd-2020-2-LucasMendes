package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class TelaCadastroVacina extends JFrame {

	private JPanel contentPane;
	private JTextField textPesquisador;
	private JTextField textField;
	private JTextField textDataInicioPesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroVacina frame = new TelaCadastroVacina();
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
	public TelaCadastroVacina() {
		setTitle("Cadastro de Vacinas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Pesquisador");
		lblNome.setBounds(24, 22, 79, 14);
		contentPane.add(lblNome);
		
		textPesquisador = new JTextField();
		textPesquisador.setBounds(24, 41, 190, 20);
		contentPane.add(textPesquisador);
		textPesquisador.setColumns(10);
		
		JLabel lblPaisOrigem = new JLabel("Pa\u00EDs de Origem");
		lblPaisOrigem.setBounds(24, 72, 98, 14);
		contentPane.add(lblPaisOrigem);
		
		textField = new JTextField();
		textField.setBounds(24, 91, 190, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEstagioPesquisa = new JLabel("Est\u00E1gio da Pesquisa");
		lblEstagioPesquisa.setBounds(24, 169, 126, 14);
		contentPane.add(lblEstagioPesquisa);
		
		JComboBox comboBoxEstagioPesquisa = new JComboBox();
		comboBoxEstagioPesquisa.setBounds(24, 194, 190, 20);
		contentPane.add(comboBoxEstagioPesquisa);
		
		JLabel lblDataInicioPesquisa = new JLabel("Data de In\u00EDcio da Pesquisa");
		lblDataInicioPesquisa.setBounds(24, 122, 163, 14);
		contentPane.add(lblDataInicioPesquisa);
		
		textDataInicioPesquisa = new JTextField();
		textDataInicioPesquisa.setBounds(24, 138, 190, 20);
		contentPane.add(textDataInicioPesquisa);
		textDataInicioPesquisa.setColumns(10);
	}
}
