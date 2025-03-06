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

public class CadastarProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel titulo;
	private JLabel codigo_lbl;
	private JTextField codigo_tf;
	private JLabel nome_lbl;
	private JTextField nome_tf;
	private JLabel descricao_lbl;
	private JEditorPane descricao_ep;
	private JLabel custo_lbl;
	private JTextField custo_tf;
	private JLabel valor_lbl;
	private JTextField valor_tf;
	private JLabel deposito_lbl;
	private JComboBox<String> depositos_box;
	private JLabel imagem_lbl;
	private JLabel imagemAparece_lbl;
	private JFileChooser fileChooser;
	private Image image;
	private JButton upload_btn;
	private JLabel aviso_lbl;
	private JButton cadastrarProduto_btn;
	private JButton abrirDeposito_btn;
	private JButton volarMenu_btn;
	private JButton novoDeposito_btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastarProduto frame = new CadastarProduto();
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
	public CadastarProduto() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 470);
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
		
		codigo_lbl = new JLabel("Código do produto:");
		codigo_lbl.setBounds(10, 91, 193, 14);
		contentPane.add(codigo_lbl);
		
		codigo_tf = new JTextField();
		codigo_tf.setColumns(10);
		codigo_tf.setBounds(10, 116, 193, 20);
		contentPane.add(codigo_tf);
		
		nome_lbl = new JLabel("Nome do produto:");
		nome_lbl.setBounds(10, 147, 193, 14);
		contentPane.add(nome_lbl);
		
		nome_tf = new JTextField();
		nome_tf.setBounds(10, 172, 193, 20);
		contentPane.add(nome_tf);
		nome_tf.setColumns(10);
		
		descricao_lbl = new JLabel("Descrição do produto:");
		descricao_lbl.setBounds(10, 203, 150, 14);
		contentPane.add(descricao_lbl);
		
		descricao_ep = new JEditorPane();
		descricao_ep.setBounds(10, 228, 193, 88);
		contentPane.add(descricao_ep);
		
		custo_lbl = new JLabel("Custo do produto:");
		custo_lbl.setBounds(10, 319, 150, 14);
		contentPane.add(custo_lbl);
		
		custo_tf = new JTextField();
		custo_tf.setColumns(10);
		custo_tf.setBounds(10, 344, 193, 20);
		contentPane.add(custo_tf);
		
		valor_lbl = new JLabel("Preço do produto:");
		valor_lbl.setBounds(10, 375, 150, 14);
		contentPane.add(valor_lbl);
		
		valor_tf = new JTextField();
		valor_tf.setColumns(10);
		valor_tf.setBounds(10, 400, 193, 20);
		contentPane.add(valor_tf);	
		
		deposito_lbl = new JLabel("Deposito:");
		deposito_lbl.setBounds(236, 91, 150, 14);
		contentPane.add(deposito_lbl);		
		
		depositos_box = new JComboBox<String>();
		depositos_box.setBounds(236, 115, 150, 22);
		contentPane.add(depositos_box);
		
		carregarListaDepositos();
		
		imagem_lbl = new JLabel("Imagem do produto:");
		imagem_lbl.setBounds(236, 147, 150, 14);
		contentPane.add(imagem_lbl);
		
		imagemAparece_lbl = new JLabel("");
		imagemAparece_lbl.setToolTipText("(Opcional)");
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\ESTG018\\eclipse-workspace\\COISO2\\img\\Excavation_I.png");
		image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		imagemAparece_lbl.setIcon(new ImageIcon(image));
		imagemAparece_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		imagemAparece_lbl.setBounds(236, 170, 150, 150);
		contentPane.add(imagemAparece_lbl);

		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(2);	
		fileChooser.setControlButtonsAreShown(false);
		fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo de imagens(*.PNG,*.JPG,*.JPEG)", "PNG", "JPG","JPEG"));
		fileChooser.setBounds(447, 14, 629, 387);
		contentPane.add(fileChooser);
		
		upload_btn = new JButton("Selecionar imagem");
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
		upload_btn.setBounds(236, 343, 150, 23);
		contentPane.add(upload_btn);
		
		aviso_lbl = new JLabel("");
		aviso_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		aviso_lbl.setBounds(617, 400, 288, 22);
		contentPane.add(aviso_lbl);
		
		cadastrarProduto_btn = new JButton("Cadastrar produto");
		cadastrarProduto_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean showCodigo = ValidacoesProduto.validarCodigo(codigo_tf.getText(), codigo_lbl);
				boolean showNome = ValidacoesProduto.validarNome(nome_tf.getText(), nome_lbl);
				boolean showDescricao = ValidacoesProduto.validarDescricao(descricao_ep.getText(), descricao_lbl);
				boolean showImagem = ValidacoesProduto.validarImagem(fileChooser, imagem_lbl);
				boolean showDeposito = ValidacoesProduto.validarDeposito(depositos_box, deposito_lbl);
				boolean showCusto = ValidacoesProduto.validarCusto(custo_tf.getText(), custo_lbl);
				boolean showValor = ValidacoesProduto.validarValor(valor_tf.getText(), valor_lbl);

                if (showCodigo == true && showNome == true && showDescricao == true && showImagem == true && 
                showDeposito == true && showCusto == true && showValor == true) {
                    Produto produto = new Produto();
                    produto.setCodigo(codigo_tf.getText());
                    produto.setNome(nome_tf.getText());
                    produto.setDescricao(descricao_ep.getText());
                    produto.setImagem(image);
                    produto.setDeposito(depositos_box.getSelectedItem().toString());
                    produto.setCusto(Double.parseDouble(custo_tf.getText()));
                    produto.setValor(Double.parseDouble(valor_tf.getText()));

                    try {
						if (CadastrarProdutoDAO.conectarCadastro(produto)) {
							aviso_lbl.setForeground(new Color(0, 204, 0));
							aviso_lbl.setText("Produto cadastrado com sucesso.");
						} else {
							aviso_lbl.setForeground(new Color(204, 0, 0));
							aviso_lbl.setText("Falha ao cadastrar produto.");
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
			}
		});
		cadastrarProduto_btn.setBounds(236, 399, 150, 23);
		contentPane.add(cadastrarProduto_btn);

		abrirDeposito_btn = new JButton("Abrir estoque");
		abrirDeposito_btn.addActionListener(new ActionListener() {
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
		abrirDeposito_btn.setBounds(457, 399, 150, 23);
		contentPane.add(abrirDeposito_btn);
		
		volarMenu_btn = new JButton("Voltar ao menu");
		volarMenu_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		        Menu menu = new Menu();
		        menu.setVisible(true);
			}
		});
		volarMenu_btn.setBounds(915, 399, 150, 23);
		contentPane.add(volarMenu_btn);
		
		novoDeposito_btn = new JButton("+");
		novoDeposito_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		novoDeposito_btn.setToolTipText("Cadastrar novo deposito.");
		novoDeposito_btn.setBounds(396, 115, 41, 23);
		contentPane.add(novoDeposito_btn);
		
	}
	
	private void carregarListaDepositos() {
	    try {
	        List<String> depositos = DepositosDAO.buscarDepositos();
	        depositos_box.removeAllItems();
	        for (String deposito : depositos) {
	            depositos_box.addItem(deposito);
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}
}