package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import dao.MostrarProdutoDAO;
import model.Produto;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MostrarEstoque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton recarregar_btn;
	private JButton volarMenu_btn;
	private JButton cadastrarNovoProduto_btn;
	private JButton deletarProduto_btn;
	private JButton alterarProduto_btn;
	private JComboBox<String> pesquisar_box;
	private JLabel pesquisar_lbl;
	private JTextField pesquisar_tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarEstoque frame = new MostrarEstoque();
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
	public MostrarEstoque() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1146, 377);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		carregarTabelaEstoque();
		
		recarregar_btn = new JButton("Refresh tabela");
		recarregar_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					carregarTabelaEstoque();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		recarregar_btn.setBounds(600, 399, 150, 23);
		contentPane.add(recarregar_btn);
		
		volarMenu_btn = new JButton("Voltar ao menu");
		volarMenu_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		        Menu menu = new Menu();
		        menu.setVisible(true);
			}
		});
		volarMenu_btn.setBounds(1006, 399, 150, 23);
		contentPane.add(volarMenu_btn);
		
		cadastrarNovoProduto_btn = new JButton("Cadastrar um novo produto");
		cadastrarNovoProduto_btn.setBounds(392, 399, 198, 23);
		cadastrarNovoProduto_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					CadastarProduto cadastrar;
					cadastrar = new CadastarProduto();
					cadastrar.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(cadastrarNovoProduto_btn);
		
		deletarProduto_btn = new JButton("Deletar produto");
		deletarProduto_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		deletarProduto_btn.setBounds(10, 399, 180, 23);
		contentPane.add(deletarProduto_btn);
		
		alterarProduto_btn = new JButton("Alterar produto");
		alterarProduto_btn.setToolTipText("Modifique os dados de um item da tabela a e salve essa mudança aqui");
		alterarProduto_btn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int row = table.getSelectedRow(); // Índice da linha selecionada
		        if (row == -1) {
		            System.out.println("Nenhuma linha selecionada!");
		            return;
		        }
		        // Pegar valores do modelo
		        int id = (int) table.getValueAt(row, 0);  // Coluna 0 = ID
		        String codigo = (String) table.getValueAt(row, 1).toString();
		        String nome = (String) table.getValueAt(row, 2).toString();
		        String descricao = (String) table.getValueAt(row, 3).toString();
		        String deposito = (String) table.getValueAt(row, 4).toString();
		        String custoStr = (String) table.getValueAt(row, 5).toString();
		        String valorStr = (String) table.getValueAt(row, 6).toString();
		        
		        double custo = Double.parseDouble(custoStr);
		        double valor = Double.parseDouble(valorStr);

		        // Chamar o DAO para atualizar no banco
		        try {
		            MostrarProdutoDAO dao = new MostrarProdutoDAO();
		            dao.atualizarProduto(id, codigo, nome, descricao, deposito, custo, valor);

		            // Atualizar (refresh) a tabela após a edição
		            carregarTabelaEstoque();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		alterarProduto_btn.setBounds(200, 399, 180, 23);
		contentPane.add(alterarProduto_btn);
		
//		pesquisar_lbl = new JLabel("Pesquisar por deposito:");
//		pesquisar_lbl.setBounds(200, 348, 180, 14);
//		contentPane.add(pesquisar_lbl);
//		
//		pesquisar_box = new JComboBox<String>();
//		pesquisar_box.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
//		pesquisar_box.setToolTipText("Filtro da pesquisa.");		
//		pesquisar_box.setBounds(10, 344, 180, 22);
//		contentPane.add(pesquisar_box);
//		
//		pesquisar_box.addItem("Depósito");
//		pesquisar_box.addItem("Código");
//		pesquisar_box.addItem("Nome");
//		pesquisar_box.addItem("Custo");
//		pesquisar_box.addItem("Valor");
		
//		pesquisar_tf = new JTextField();
//		pesquisar_tf.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				try {
//					MostrarProdutoDAO mostrar = new MostrarProdutoDAO();
//		            String termo = pesquisar_tf.getText().trim();
//		            if(pesquisar_box.getSelectedIndex() == 0){
//		            	mostrar.buscarProdutosPorDeposito(termo);
//		            	pesquisar_lbl.setText("Pesquisar por Deposito:");
//		            }else if(pesquisar_box.getSelectedIndex() == 1){
////						mostrar.pesquisarPorCodigo(termo);
//		            	pesquisar_lbl.setText("Pesquisar por Código:");
//	            	}else if(pesquisar_box.getSelectedIndex() == 2){
////						mostrar.pesquisarPorNome(termo);
//		            	pesquisar_lbl.setText("Pesquisar por Nome:");	            		
//	            	}else if(pesquisar_box.getSelectedIndex() == 3){
////						mostrar.pesquisarPorCusto(termo);
//		            	pesquisar_lbl.setText("Pesquisar por Custo:");	            		
//	            	}else if(pesquisar_box.getSelectedIndex() == 4){
////						mostrar.pesquisarPorValor(termo);
//		            	pesquisar_lbl.setText("Pesquisar por Valor:");	            		
//					}else {
//						System.out.println("Erro, ai ai ai ai");
//					}
//		        } catch (ClassNotFoundException | SQLException ex) {
//		            ex.printStackTrace();
//		        }
//			}
//		});
//		pesquisar_tf.setBounds(390, 345, 200, 20);
//		contentPane.add(pesquisar_tf);
//		pesquisar_tf.setColumns(10);		
		
		
		
		
	}
	
	private void carregarTabelaEstoque() throws ClassNotFoundException, SQLException {
        MostrarProdutoDAO dao = new MostrarProdutoDAO();
        ArrayList<Produto> produtos = dao.mostrarEstoque();

        // Agora com 10 colunas:
        String[] colunas = {
            "ID", "Código", "Nome", "Descrição", "Depósito",
            "Custo", "Valor", "Criado Em", "Atualizado Em", "Imagem"
        };

        DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {
        	@Override
            public boolean isCellEditable(int row, int column) {
                // Índices de colunas (conforme a ordem acima):
                // 0 = ID, 1 = Código, 2 = Nome, 3 = Descrição,
                // 4 = Depósito, 5 = Custo, 6 = Valor,
                // 7 = Criado Em, 8 = Atualizado Em, 9 = Imagem

                // Exemplo: deixar ID (0), Criado Em (7), Atualizado Em (8) e Imagem (9) bloqueados
                if (column == 0 || column == 7 || column == 8 || column == 9) {
                    return false; // Não editável
                }
                return true; // As demais colunas podem ser editadas
            }
        	
            // Para permitir exibir ImageIcon, sobrescrevemos getColumnClass
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // A última coluna é imagem (ImageIcon)
                if (columnIndex == 9) {
                    return ImageIcon.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };

        for (Produto p : produtos) {
            Object[] linha = {
                p.getId(),
                p.getCodigo(),
                p.getNome(),
                p.getDescricao(),
                p.getDeposito(),
                p.getCusto(),
                p.getValor(),
                p.getDataCriacaoFormatada(),
                p.getDataAtualizacaoFormatada(),
                p.getImagemIcon()
            };
            modelo.addRow(linha);
        }

        table.setModel(modelo);

        // Ajustar altura das linhas para caber a imagem
        table.setRowHeight(54);

        // Ajustar larguras das colunas (opcional)
        table.getColumnModel().getColumn(0).setPreferredWidth(10);  // ID
        table.getColumnModel().getColumn(1).setPreferredWidth(50);  // Código
        table.getColumnModel().getColumn(2).setPreferredWidth(170); // Nome
        table.getColumnModel().getColumn(3).setPreferredWidth(260); // Descrição
        table.getColumnModel().getColumn(4).setPreferredWidth(100); // Depósito
        table.getColumnModel().getColumn(5).setPreferredWidth(40);  // Custo
        table.getColumnModel().getColumn(6).setPreferredWidth(40);  // Valor
        table.getColumnModel().getColumn(7).setPreferredWidth(90); // Data Criação
        table.getColumnModel().getColumn(8).setPreferredWidth(90); // Data Atualização
        table.getColumnModel().getColumn(9).setPreferredWidth(60);  // Imagem
	}
}
