package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class MenuPrincipal extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(false);
		setJMenuBar(menuBar);
		
		JMenu menuPaciente = new JMenu("Paciente");
		menuPaciente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/users.png")));
		menuBar.add(menuPaciente);
		
		JMenuItem menuItemCadastroPaciente = new JMenuItem("Cadastro");
		menuItemCadastroPaciente.setBackground(Color.WHITE);
		menuItemCadastroPaciente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		menuItemCadastroPaciente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/addUser.png")));
		menuPaciente.add(menuItemCadastroPaciente);
		
		JMenu menuVacina = new JMenu("Vacina");
		menuVacina.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/vacina.png")));
		menuBar.add(menuVacina);
		
		JMenuItem menuItemCadastroVacina = new JMenuItem("Cadastro");
		menuItemCadastroVacina.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		menuItemCadastroVacina.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/icons/Seringa.png")));
		menuVacina.add(menuItemCadastroVacina);
	}

}
