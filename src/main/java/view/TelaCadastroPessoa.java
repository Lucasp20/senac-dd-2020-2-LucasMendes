package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.google.protobuf.TextFormat.ParseException;

import controller.PessoaController;
import model.vo.Pessoa;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
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
import javax.swing.DefaultComboBoxModel;

public class TelaCadastroPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textInstituicao;
	private JCheckBox chkPesquisador;
	private JComboBox cbSexo;
	private JFrame frame;
	private JFormattedTextField txtCPF;
	private JCheckBox chkVoluntario;
	private JComboBox cbReacao;
	private JCheckBox chkPublicoGeral;
	private DatePicker DataNascimento;
	private DatePicker DataVacinacao;

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

	public TelaCadastroPessoa() throws java.text.ParseException, ParseException {
		setTitle("Cadastro de Pessoas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 488);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(99, 22, 46, 14);
		contentPane.add(lblNome);
			
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(99, 71, 33, 14);
		contentPane.add(lblCPF);
		
		MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
		
		txtCPF = new JFormattedTextField(mascaraCpf);
		txtCPF.setBounds(99, 84, 217, 25);
		contentPane.add(txtCPF);	
			
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(99, 161, 46, 14);
		contentPane.add(lblSexo);
				
		ArrayList<String> sexo = obterSexo();
		cbSexo = new JComboBox(sexo.toArray());
		cbSexo.setBounds(99, 175, 217, 25);
		contentPane.add(cbSexo);
		
		ArrayList<String> reacao = obterReacao();
		cbReacao = new JComboBox(reacao.toArray());
		cbReacao.setModel(new DefaultComboBoxModel(new String[] {"--- Selecione ----", "Grave"}));
		cbReacao.setEnabled(false);
		cbReacao.setEditable(true);
		cbReacao.setBounds(99, 252, 217, 25);
		contentPane.add(cbReacao);
		
		textNome = new JTextField();
		textNome.setBounds(99, 39, 217, 25);
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
	chkPesquisador.setBounds(99, 332, 97, 23);
	contentPane.add(chkPesquisador);
	
	JLabel lblDataNascimento = new JLabel("Data de Nascimento");
	lblDataNascimento.setBounds(99, 115, 111, 14);
	contentPane.add(lblDataNascimento);
	
	DatePickerSettings dateSettings = new DatePickerSettings();
	dateSettings.setAllowKeyboardEditing(false);
	
	DataNascimento = new DatePicker();
	DataNascimento.getComponentDateTextField().setEditable(false);
	DataNascimento.setBounds(99, 130, 217, 25);
	contentPane.add(DataNascimento);

	JLabel lblDataVacinacao = new JLabel("Data da Vacinação");
	lblDataVacinacao.setBounds(99, 285, 111, 14);
	contentPane.add(lblDataVacinacao);
		
	DataVacinacao = new DatePicker();
	DataVacinacao.getComponentDateTextField().setEditable(false);
	DataVacinacao.setBounds(99, 300, 217, 25);
	contentPane.add(DataVacinacao);
	
	textInstituicao = new JTextField();
	textInstituicao.setEnabled(false);
	textInstituicao.setBounds(99, 371, 217, 25);
	contentPane.add(textInstituicao);
	textInstituicao.setColumns(10);
	
	JLabel lblInstituicao = new JLabel("Institui\u00E7\u00E3o");
	lblInstituicao.setBounds(99, 356, 74, 14);
	contentPane.add(lblInstituicao);

	chkPublicoGeral = new JCheckBox("P\u00FAblico em Geral");
	chkPublicoGeral.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(chkPublicoGeral.isSelected()) {
				cbReacao.setEnabled(true);
			}else {
				cbReacao.setEnabled(false);
			}
		}
	});
	chkPublicoGeral.setBounds(198, 207, 124, 23);
	contentPane.add(chkPublicoGeral);

	chkVoluntario = new JCheckBox("Volunt\u00E1rio");
	chkVoluntario.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(chkVoluntario.isSelected()) {
				cbReacao.setEnabled(true);
			}else {
				cbReacao.setEnabled(false);
			}
		}
	});
	chkVoluntario.setBounds(99, 207, 97, 23);
	contentPane.add(chkVoluntario);

	
	JButton btnCadastrar = new JButton("Cadastrar");
	btnCadastrar.setForeground(new Color(0, 0, 128));
	btnCadastrar.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent arg0) {
			Pessoa pessoa = new Pessoa();
			String cpf = txtCPF.getText().replace("-", "").replace(".", "");
		
			pessoa.setNome(textNome.getText());
			pessoa.setDataNascimento(DataNascimento.getDate());
			pessoa.setSexo((String)cbSexo.getSelectedItem());
			pessoa.setDataVacinacao(DataVacinacao.getDate());
			pessoa.setCpf(txtCPF.getText().replace("-", "").replace(".", ""));
			
			PessoaController pessoaController = new PessoaController();
			JOptionPane.showMessageDialog(null, pessoaController.cadastrarPessoa(pessoa));
		}
		
	});
		
	btnCadastrar.setBounds(99, 415, 97, 23);
	contentPane.add(btnCadastrar);
	
	JButton btnSair = new JButton("Sair");
	btnSair.setForeground(new Color(0, 0, 128));
	btnSair.addMouseListener(new MouseAdapter() {		
		public void mouseClicked(MouseEvent arg0) {
			JOptionPane.showMessageDialog(null, "Passou pelo botão sair");
		}
	});
	btnSair.setBounds(224, 415, 89, 23);
	contentPane.add(btnSair);
		
	JLabel lblReacao = new JLabel("Reação");
	lblReacao.setBounds(99, 237, 46, 14);
	contentPane.add(lblReacao);
	}
	
	private ArrayList<String> obterSexo() {
		ArrayList<String> sexo = new ArrayList<String>();
		sexo.add("");
		sexo.add("Masculino");
		sexo.add("Feminino");
		return sexo;
	}
	
	private ArrayList<String> obterReacao() {
		ArrayList<String> reacao = new ArrayList<String>();
		reacao.add("");
		reacao.add("1 - PÉSSIMO");
		reacao.add("2 - RUIM");
		reacao.add("3- REGULAR");
		reacao.add("4 - BOM");
		reacao.add("5 - ÓTIMO");

		return reacao;
	}
}
	
	
