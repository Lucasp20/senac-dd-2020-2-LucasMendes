package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textSexo;
	private JTextField textInstituicao;
	private JTextField textDataNascimento;
	private JCheckBox chkPesquisador;

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

	public TelaCadastroPessoa() {
		setTitle("Cadastro de Pessoas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 391);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(27, 30, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(27, 78, 46, 14);
		contentPane.add(lblCPF);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(28, 123, 46, 14);
		contentPane.add(lblSexo);
		
		textNome = new JTextField();
		textNome.setBounds(27, 47, 193, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCPF = new JTextField();
		textCPF.setBounds(27, 92, 193, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		textSexo = new JTextField();
		textSexo.setBounds(27, 138, 193, 20);
		contentPane.add(textSexo);
		textSexo.setColumns(10);
		
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
		chkPesquisador.setBounds(27, 260, 97, 23);
		contentPane.add(chkPesquisador);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setBounds(28, 169, 111, 14);
		contentPane.add(lblDataNascimento);
		
		textDataNascimento = new JTextField();
		textDataNascimento.setColumns(10);
		textDataNascimento.setBounds(27, 183, 193, 20);
		contentPane.add(textDataNascimento);
		
		textInstituicao = new JTextField();
		textInstituicao.setEnabled(false);
		textInstituicao.setBounds(27, 305, 217, 20);
		contentPane.add(textInstituicao);
		textInstituicao.setColumns(10);
		
		JLabel lblInstituicao = new JLabel("Institui\u00E7\u00E3o");
		lblInstituicao.setBounds(27, 290, 74, 14);
		contentPane.add(lblInstituicao);
	}
}
