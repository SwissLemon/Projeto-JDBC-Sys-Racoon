package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ConexaoOracle;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel titulo;
	private JLabel nome_lbl;
	private JTextField nome_tf;
	private JLabel senha_lbl;
	private JPasswordField senha_pf;
	private JButton login_btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Login() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Systextil - Racoon 1.0");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titulo = new JLabel("Systêxtil");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 35));
		titulo.setBounds(10, 14, 327, 66);
		contentPane.add(titulo);
		
		nome_tf = new JTextField();
		nome_tf.setBounds(10, 116, 327, 20);
		contentPane.add(nome_tf);
		nome_tf.setColumns(10);
		
		nome_lbl = new JLabel("Nome do usuario:");
		nome_lbl.setBounds(10, 91, 165, 14);
		contentPane.add(nome_lbl);
		
		senha_lbl = new JLabel("Senha do usuario:");
		senha_lbl.setBounds(10, 147, 165, 14);
		contentPane.add(senha_lbl);
		
		senha_pf = new JPasswordField();
		senha_pf.setBounds(10, 172, 327, 20);
		contentPane.add(senha_pf);
		
		login_btn = new JButton("Login");
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // Fecha a tela do menu
		        Menu menu = new Menu(); // Cria uma nova instância da tela de login
		        menu.setVisible(true); // Exibe a tela de login
			}
		});
		login_btn.setBounds(10, 203, 89, 23);
		contentPane.add(login_btn);
		
		

	}
}
