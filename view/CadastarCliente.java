package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.ValidacoesProduto;
import dao.CadastrarProdutoDAO;
import dao.DepositosDAO;
import model.Produto;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JComboBox;

public class CadastarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel titulo;
	private JLabel nome_lbl;
	private JTextField nome_tf;
	private JLabel email_lbl;
	private JTextField email_tf;
	private JLabel senha_lbl;
	private JTextField senha_tf;
	
	private JLabel status_lbl;
	private JTextField status_tf;
	private JLabel nascimento_lbl;
	private JTextField nascimento_tf;
	private JLabel imagem_lbl;
	private JLabel imagemAparece_lbl;
	private JFileChooser fileChooser;
	private Image image;
	private JButton upload_btn;
	private JLabel aviso_lbl;
	private JButton cadastrarCliente_btn;
	private JButton abrirDeposito_btn;
	private JButton volarMenu_btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastarCliente frame = new CadastarCliente();
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
	public CadastarCliente() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Systextil - Racoon 1.0");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titulo = new JLabel("Systêxtil");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 35));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(10, 14, 427, 66);
		contentPane.add(titulo);
		
		nome_lbl = new JLabel("Nome do cliente:");
		nome_lbl.setBounds(10, 91, 193, 14);
		contentPane.add(nome_lbl);
		
		nome_tf = new JTextField();
		nome_tf.setColumns(10);
		nome_tf.setBounds(10, 116, 193, 20);
		contentPane.add(nome_tf);
		
		email_lbl = new JLabel("Email do cliente:");
		email_lbl.setBounds(10, 147, 193, 14);
		contentPane.add(email_lbl);
		
		email_tf = new JTextField();
		email_tf.setBounds(10, 172, 193, 20);
		contentPane.add(email_tf);
		email_tf.setColumns(10);
		
		senha_lbl = new JLabel("Senha do cliente:");
		senha_lbl.setBounds(10, 203, 150, 14);
		contentPane.add(senha_lbl);
		
		senha_tf = new JTextField();
		senha_tf.setColumns(10);
		senha_tf.setBounds(10, 228, 193, 20);
		contentPane.add(senha_tf);
		
		status_lbl = new JLabel("Status do cliente:");
		status_lbl.setBounds(10, 259, 150, 14);
		contentPane.add(status_lbl);
		
		status_tf = new JTextField();
		status_tf.setColumns(10);
		status_tf.setBounds(10, 284, 193, 20);
		contentPane.add(status_tf);
		
		
		nascimento_lbl = new JLabel("Data de nascimento:");
		nascimento_lbl.setBounds(10, 315, 150, 14);
		contentPane.add(nascimento_lbl);
		
		nascimento_tf = new JTextField();
		nascimento_tf.setColumns(10);
		nascimento_tf.setBounds(10, 340, 193, 20);
		contentPane.add(nascimento_tf);
		
		imagem_lbl = new JLabel("Imagem do cliente:");
		imagem_lbl.setBounds(236, 91, 150, 14);
		contentPane.add(imagem_lbl);
		
		imagemAparece_lbl = new JLabel("");
		imagemAparece_lbl.setToolTipText("(Opcional)");
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\ESTG018\\eclipse-workspace\\COISO2\\img\\avatar.png");
		image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		imagemAparece_lbl.setIcon(new ImageIcon(image));
		imagemAparece_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		imagemAparece_lbl.setBounds(236, 114, 150, 150);
		contentPane.add(imagemAparece_lbl);

		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(2);	
		fileChooser.setControlButtonsAreShown(false);
		fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo de imagens(*.PNG,*.JPG,*.JPEG)", "PNG", "JPG","JPEG"));
		fileChooser.setBounds(447, 14, 629, 315);
		contentPane.add(fileChooser);
		
		upload_btn = new JButton("Selecionar imagem");
		upload_btn.setToolTipText("Escolha a imagem nos aequivos ao lado e salve aqui.");
		upload_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fileChooser != null) {
					ImageIcon imageIcon = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());
					image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
					imagemAparece_lbl.setIcon(new ImageIcon(image));
                }else {
                	System.out.println("filechooser is null");
                }
			}
		});
		upload_btn.setBounds(236, 287, 150, 23);
		contentPane.add(upload_btn);
		
		aviso_lbl = new JLabel("");
		aviso_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		aviso_lbl.setBounds(644, 340, 261, 22);
		contentPane.add(aviso_lbl);
		
		cadastrarCliente_btn = new JButton("Cadastrar cliente");
//		cadastrarProduto_btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				boolean showCodigo = ValidacoesProduto.validarCodigo(codigo_tf.getText(), codigo_lbl);
//				boolean showNome = ValidacoesProduto.validarNome(nome_tf.getText(), nome_lbl);
//				boolean showDescricao = ValidacoesProduto.validarDescricao(descricao_ep.getText(), descricao_lbl);
//				boolean showImagem = ValidacoesProduto.validarImagem(fileChooser, imagem_lbl);
//				boolean showDeposito = ValidacoesProduto.validarDeposito(depositos_box, deposito_lbl);
//				boolean showCusto = ValidacoesProduto.validarCusto(status_tf.getText(), status_lbl);
//				boolean showValor = ValidacoesProduto.validarValor(nascimento_tf.getText(), nascimento_lbl);
//
//                if (showCodigo == true && showNome == true && showDescricao == true && showImagem == true && 
//                showDeposito == true && showCusto == true && showValor == true) {
//                    Produto produto = new Produto();
//                    produto.setCodigo(codigo_tf.getText());
//                    produto.setNome(nome_tf.getText());
//                    produto.setDescricao(descricao_ep.getText());
//                    produto.setImagem(image);
//                    produto.setDeposito(depositos_box.getSelectedItem().toString());
//                    produto.setCusto(Double.parseDouble(status_tf.getText()));
//                    produto.setValor(Double.parseDouble(nascimento_tf.getText()));
//
//                    try {
//						if (CadastrarProdutoDAO.conectarCadastro(produto)) {
//							aviso_lbl.setForeground(new Color(0, 204, 0));
//							aviso_lbl.setText("Produto cadastrado com sucesso.");
//						} else {
//							aviso_lbl.setForeground(new Color(204, 0, 0));
//							aviso_lbl.setText("Falha ao cadastrar produto.");
//						}
//					} catch (ClassNotFoundException | SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//                }
//			}
//		});
		cadastrarCliente_btn.setBounds(236, 339, 150, 23);
		contentPane.add(cadastrarCliente_btn);

		abrirDeposito_btn = new JButton("Abrir banco dos clientes");
//		abrirDeposito_btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					dispose();
//					MostrarEstoque estoque;
//					estoque = new MostrarEstoque();
//					estoque.setVisible(true);
//				} catch (ClassNotFoundException | SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
		abrirDeposito_btn.setBounds(457, 339, 177, 23);
		contentPane.add(abrirDeposito_btn);
		
		volarMenu_btn = new JButton("Voltar ao menu");
		volarMenu_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		        Menu menu = new Menu();
		        menu.setVisible(true);
			}
		});
		volarMenu_btn.setBounds(915, 339, 150, 23);
		contentPane.add(volarMenu_btn);
	}
}