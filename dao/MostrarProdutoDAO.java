package dao;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import model.Produto;


public class MostrarProdutoDAO {
	
	//Um dao para inserção e puxação
	// model -> service
	// aonde tem regras de negocio
	
	// dao -> repository
	// aonde não tem regras
	
	// o repositorio retorna um objeto - > DAO = data access object -> service
	
	// service ---> insert ---> repository
	
	// Service --- getProductsDAO = ArrayList --> DAO 
	// DAO --- getProducts = Objeto do produto ---> Service
	
	// DAO não tera regras, apenas validações
	
	// sevice ---> *ArrayList* ---> view : errado, falta a camada DTO, sem ela a segurança do sistema é comprometida
	
	// service ---> DTO = Data Transfer Object ---> view
	// DE / PARA = saldoConta / saldoContaUsuario
	
	public ArrayList<Produto> mostrarEstoque() throws ClassNotFoundException, SQLException {
		ConexaoOracle conexao = new ConexaoOracle();
	    conexao.conectar();
	    Connection conn = conexao.getIdConexao();
	    
	    String sql = "SELECT * FROM estoque";
	    PreparedStatement comando = conn.prepareStatement(sql);
	    ResultSet resultado = comando.executeQuery();
	    
	    ArrayList<Produto> produtos = new ArrayList<>();
	    
	 // Usaremos um formatter para data/hora
	    java.time.format.DateTimeFormatter fmt = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	    
	    while (resultado.next()) {
	    	Produto produto = new Produto();
	        produto.setId(resultado.getInt(1));
	        produto.setCodigo(resultado.getString(2));
	        produto.setNome(resultado.getString(3));
	        produto.setDescricao(resultado.getString(4));
	        
	        // Ler o BLOB da coluna imagem:
	        byte[] imagemBytes = resultado.getBytes("imagem");
	        if (imagemBytes != null) {
	            // Converter para ImageIcon
	            ImageIcon icon = new ImageIcon(imagemBytes);
	            // (Opcional) Redimensionar a imagem para caber na célula
	            Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	            produto.setImagemIcon(new ImageIcon(img));
	        } else {
	            produto.setImagemIcon(null);
	        }
	        produto.setDeposito(resultado.getString(6));
	        produto.setCusto(resultado.getDouble(7));
	        produto.setValor(resultado.getDouble(8));
	        
	        // Ler e formatar datas
	        java.sql.Timestamp tsCriacao = resultado.getTimestamp("data_criacao");
	        if (tsCriacao != null) {
	            // Converter para LocalDateTime e formatar
	            produto.setDataCriacaoFormatada(tsCriacao.toLocalDateTime().format(fmt));
	        }
	        java.sql.Timestamp tsAtualizacao = resultado.getTimestamp("data_atualizacao");
	        if (tsAtualizacao != null) {
	            produto.setDataAtualizacaoFormatada(tsAtualizacao.toLocalDateTime().format(fmt));
	        }

	        produtos.add(produto);
	    }
	    resultado.close();
	    comando.close();
	    conexao.desConectar();
	    
	    return produtos;
	}
	
	public void atualizarProduto(int id, String codigo, String nome, String descricao, String deposito, double custo, double valor)
        throws ClassNotFoundException, SQLException {
			ConexaoOracle conexao = new ConexaoOracle();
			conexao.conectar();
			Connection conn = conexao.getIdConexao();
			
			String sql = "UPDATE estoque SET "
			+ "codigo = ?, nome = ?, descricao = ?, deposito = ?, "
			+ "custo = ?, valor = ?, data_atualizacao = CURRENT_TIMESTAMP "
			+ "WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, codigo);
			stmt.setString(2, nome);
			stmt.setString(3, descricao);
			stmt.setString(4, deposito);
			stmt.setDouble(5, custo);
			stmt.setDouble(6, valor);
			stmt.setInt(7, id);
			
			stmt.executeUpdate();
			
			stmt.close();
			conexao.desConectar();
		}
	
	public void deletarProduto() {
		
	}
}
