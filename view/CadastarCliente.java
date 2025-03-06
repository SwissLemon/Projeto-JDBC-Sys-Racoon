package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import dao.CadastrarClienteDAO;
import model.Cliente;
import model.ValidacoesCliente;

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
	private JLabel nascimento_lbl;
	private JLabel imagem_lbl;
	private JLabel imagemAparece_lbl;
	private JFileChooser fileChooser;
	private Image image;
	private JButton upload_btn;
	private JLabel aviso_lbl;
	private JButton cadastrarCliente_btn;
	private JButton abrirDeposito_btn;
	private JButton volarMenu_btn;
	private JTextField status_tf;
	private JTextField dia_tf;
	private JTextField mes_tf;
	private JTextField ano_tf;
	private JTextField dataNascimento;

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
		status_tf.setBounds(10, 284, 193, 20);
		contentPane.add(status_tf);
		status_tf.setColumns(10);
		
		nascimento_lbl = new JLabel("Data de nascimento:");
		nascimento_lbl.setToolTipText("Dia, mes e ano. Exp: 01 mar 2001");
		nascimento_lbl.setBounds(10, 315, 150, 14);
		contentPane.add(nascimento_lbl);
		
		dia_tf = new JTextField(2);
		dia_tf.setToolTipText("Dia.");
		dia_tf.setColumns(10);
		dia_tf.setBounds(10, 340, 54, 20);
		setFiltroNumerico(dia_tf, 2);
		contentPane.add(dia_tf);
		
		mes_tf = new JTextField(3);
		mes_tf.setToolTipText("Mês.");
		mes_tf.setColumns(10);
		mes_tf.setBounds(74, 340, 54, 20);
		setFiltroTexto(mes_tf, 3);
		contentPane.add(mes_tf);

		// Para o campo de ano com placeholder "yyyy"
		ano_tf = new JTextField(4);
		ano_tf.setToolTipText("Ano.");
		ano_tf.setColumns(10);
		ano_tf.setBounds(138, 340, 65, 20);
		setFiltroNumerico(ano_tf, 4);
		contentPane.add(ano_tf);
		
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
		cadastrarCliente_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean showNome = ValidacoesCliente.validarNome(nome_tf.getText(), nome_lbl);
				boolean showEmail = ValidacoesCliente.validarEmail(email_tf.getText(), email_lbl);
				boolean showSenha = ValidacoesCliente.validarSenha(senha_tf.getText(), senha_lbl);
				boolean showStatus = ValidacoesCliente.validarStatus( status_tf.getText(), status_lbl);
				boolean showDataNascimento = ValidacoesCliente.validarDataNascimento(dia_tf.getText(), mes_tf.getText(), ano_tf.getText(), nascimento_lbl);
				boolean showFoto = ValidacoesCliente.validarFoto(fileChooser, imagem_lbl);
				
                if (showNome == true && showEmail == true && showSenha == true && showStatus == true && showDataNascimento == true && showFoto == true) {
                	Cliente cliente = new Cliente();
                	cliente.setNome(nome_tf.getText());
                	cliente.setEmail(email_tf.getText());
                	cliente.setSenha(senha_tf.getText());;
                	cliente.setStatus(Integer.parseInt(status_tf.getText()));
            		cliente.setDataNascimento(dataNascimento.getText());

                    try {
						if (CadastrarClienteDAO.conectarCliente(cliente)) {
							aviso_lbl.setForeground(new Color(0, 204, 0));
							aviso_lbl.setText("Cliente cadastrado com sucesso.");
						} else {
							aviso_lbl.setForeground(new Color(204, 0, 0));
							aviso_lbl.setText("Falha ao cadastrar cliente.");
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
			}
		});
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
	
	private static void setFiltroNumerico(JTextField textField, int maxLength) {
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d+") && (fb.getDocument().getLength() + string.length() <= maxLength)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d+") && (fb.getDocument().getLength() - length + text.length() <= maxLength)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
	
	private static void setFiltroTexto(JTextField textField, int maxLength) {
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[a-zA-Z]+") && (fb.getDocument().getLength() + string.length() <= maxLength)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[a-zA-Z]+") && (fb.getDocument().getLength() - length + text.length() <= maxLength)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
}