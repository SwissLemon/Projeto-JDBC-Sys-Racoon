package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Produto;
import utils.Utilidades;

public class CadastrarProdutoDAO {
	public static boolean conectarCadastro(Produto produto) throws ClassNotFoundException, SQLException {
		ConexaoOracle conexao = new ConexaoOracle();
        conexao.conectar();
        Connection conn = conexao.getIdConexao();
        
        String sql = "INSERT INTO estoque (codigo, nome, descricao, imagem, deposito, custo, valor) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement comando = conn.prepareStatement(sql);
        comando.setString(1, produto.getCodigo());
        comando.setString(2, produto.getNome());
        comando.setString(3, produto.getDescricao());
        
        byte[] imageBytes = Utilidades.convertImageToBytes(produto.getImagem());
        if (imageBytes != null) {
            comando.setBytes(4, imageBytes);
        } else {
            comando.setNull(4, java.sql.Types.BLOB);
        }
        comando.setString(5, produto.getDeposito());
        comando.setDouble(6, produto.getCusto());
        comando.setDouble(7, produto.getValor());
        
        int rowsInserted = comando.executeUpdate();

        comando.close();
        conexao.desConectar();
        
        return rowsInserted > 0;
	}
}
