package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.google.protobuf.TextFormat.ParseException;

import controller.PessoaController;
import model.vo.Pessoa;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroPessoa extends JFrame {

	private static final Component JFormattedTextFieldCpf = null;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textInstituicao;
	private JTextField textDataNascimento;
	private JCheckBox chkPesquisador;
	private JComboBox comboBoxSexo;
	private JTextField textCpf;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPessoa frame = new TelaCadastroPessoa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastroPessoa() throws java.text.ParseException {
		setTitle("Cadastro de Pessoas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 434);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(99, 22, 46, 14);
		contentPane.add(lblNome);

		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(99, 70, 46, 14);
		contentPane.add(lblCPF);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(99, 161, 46, 14);
		contentPane.add(lblSexo);
		
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setBounds(99, 175, 217, 20);
		contentPane.add(comboBoxSexo);
		
		textNome = new JTextField();
		textNome.setBounds(99, 39, 217, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		chkPesquisador = new JCheckBox("Pesquisador");
		chkPesquisador.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(chkPesquisador.isSelected()) {
				textInstituicao.setEnabled(true);
			}else {
				textInstituicao.setEnabled(false);
			}
		}
});
	chkPesquisador.setBounds(99, 252, 97, 23);
	contentPane.add(chkPesquisador);

	JLabel lblDataNascimento = new JLabel("Data Nascimento");
	lblDataNascimento.setBounds(99, 115, 111, 14);
	contentPane.add(lblDataNascimento);

	textDataNascimento = new JTextField();
	textDataNascimento.setColumns(10);
	textDataNascimento.setBounds(99, 130, 217, 20);
	contentPane.add(textDataNascimento);

	textInstituicao = new JTextField();
	textInstituicao.setEnabled(false);
	textInstituicao.setBounds(99, 297, 217, 20);
	contentPane.add(textInstituicao);
	textInstituicao.setColumns(10);

	JLabel lblInstituicao = new JLabel("Institui\u00E7\u00E3o");
	lblInstituicao.setBounds(99, 282, 74, 14);
	contentPane.add(lblInstituicao);

	JCheckBox chkPublicoGeral = new JCheckBox("P\u00FAblico em Geral");
	chkPublicoGeral.setBounds(186, 202, 130, 23);
	contentPane.add(chkPublicoGeral);

	JCheckBox chkVoluntario = new JCheckBox("Volunt\u00E1rio");
	chkVoluntario.setBounds(99, 202, 97, 23);
	contentPane.add(chkVoluntario);
	
	JButton btnCadastrar = new JButton("Cadastrar");
	btnCadastrar.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent arg0) {
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(textNome.getText());
			pessoa.setCpf(textCpf.getText());
			
			PessoaController controller = new PessoaController();
			
			String mensagem = controller.salvar(pessoa);
			
			JOptionPane.showInternalMessageDialog(contentPane, mensagem);
		
			
		}
	});
	
	btnCadastrar.setBounds(99, 347, 97, 23);
	contentPane.add(btnCadastrar);
	
	JButton btnSair = new JButton("Sair");
	btnSair.setBounds(227, 347, 89, 23);
	contentPane.add(btnSair);
	
	textCpf = new JTextField();
	textCpf.setBounds(99, 84, 217, 20);
	contentPane.add(textCpf);
	textCpf.setColumns(10);
	}
}
	
	
