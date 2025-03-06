package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Cliente;
import utils.Utilidades;

public class CadastrarClienteDAO {
	public static boolean conectarCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
		ConexaoOracle conexao = new ConexaoOracle();
        conexao.conectar();
        Connection conn = conexao.getIdConexao();
        
        String sql = "INSERT INTO clientes (nome, email, senha, status, dataNascimento, foto) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement comando = conn.prepareStatement(sql);
        comando.setString(1, cliente.getNome());
        comando.setString(2, cliente.getEmail());
        comando.setString(3, cliente.getSenha());
        comando.setInt(4, cliente.getStatus());
        comando.setDate(5, cliente.getDataNascimento());
        
        byte[] imageBytes = Utilidades.convertImageToBytes(cliente.getFoto());
        if (imageBytes != null) {
            comando.setBytes(6, imageBytes);
        } else {
            comando.setNull(6, java.sql.Types.BLOB);
        }
        
        int rowsInserted = comando.executeUpdate();

        comando.close();
        conexao.desConectar();
        
        return rowsInserted > 0;
	}
}
