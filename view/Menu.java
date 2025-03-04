package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JLabel titulo;
	private JLabel cadastrarProduto_lbl;
	private JButton cadastrarProduto_btn;
	private JLabel estoque_lbl;
	private JButton estoque_btn;
	private JLabel cadastrarDeposito_lbl;
	private JButton cadastrarDeposito_btn;
	private JLabel cadastrarUsuario_lbl;
	private JButton cadastrarUsuario_btn;
	private JLabel sair_lbl;
	private JButton sair_btn;
	private JLabel mostrarUsuarios_lbl;
	private JButton mostrarUsuario_btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Systextil - Racoon 1.0");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titulo = new JLabel("Systêxtil");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 35));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(10, 14, 366, 66);
		contentPane.add(titulo);
		
		estoque_lbl = new JLabel("Estoque:");
		estoque_lbl.setBounds(10, 150, 150, 14);
		contentPane.add(estoque_lbl);
		
		estoque_btn= new JButton("Ver estoque");
		estoque_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					MostrarEstoque estoque;
					estoque = new MostrarEstoque();
					estoque.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		estoque_btn.setBounds(10, 175, 150, 23);
		contentPane.add(estoque_btn);
		
		cadastrarProduto_lbl = new JLabel("Cadastrar um produto:");
		cadastrarProduto_lbl.setBounds(10, 91, 150, 14);
		contentPane.add(cadastrarProduto_lbl);
		
		cadastrarProduto_btn = new JButton("Cadastrar produto");
		cadastrarProduto_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					CadastarProduto cadastrarProduto;
					cadastrarProduto = new CadastarProduto();
					cadastrarProduto.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cadastrarProduto_btn.setBounds(10, 116, 150, 23);
		contentPane.add(cadastrarProduto_btn);
		
		cadastrarDeposito_lbl = new JLabel("Cadastrar um deposito:");
		cadastrarDeposito_lbl.setBounds(10, 209, 150, 14);
		contentPane.add(cadastrarDeposito_lbl);
		
		cadastrarDeposito_btn = new JButton("Cadastrar deposito");
		cadastrarDeposito_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cadastrarDeposito_btn.setBounds(10, 234, 150, 23);
		contentPane.add(cadastrarDeposito_btn);
		
		cadastrarUsuario_lbl = new JLabel("Cadastrar um usuario:");
		cadastrarUsuario_lbl.setBounds(226, 91, 150, 14);
		contentPane.add(cadastrarUsuario_lbl);
		
		cadastrarUsuario_btn = new JButton("Cadastrar usuario");
		cadastrarUsuario_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cadastrarUsuario_btn.setBounds(226, 116, 150, 23);
		contentPane.add(cadastrarUsuario_btn);
		
		sair_lbl = new JLabel("Sair do sistema");
		sair_lbl.setBounds(226, 209, 150, 14);
		contentPane.add(sair_lbl);
		
		sair_btn = new JButton("Sair");
		sair_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		        Login login;
				try {
					login = new Login();
					login.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		sair_btn.setBounds(226, 234, 150, 23);
		contentPane.add(sair_btn);
		
		mostrarUsuarios_lbl = new JLabel("Mostrar todos usuarios:");
		mostrarUsuarios_lbl.setBounds(226, 150, 150, 14);
		contentPane.add(mostrarUsuarios_lbl);
		
		mostrarUsuario_btn = new JButton("Mostrar usuario");
		mostrarUsuario_btn.setBounds(226, 175, 150, 23);
		contentPane.add(mostrarUsuario_btn);
		
	}

}
