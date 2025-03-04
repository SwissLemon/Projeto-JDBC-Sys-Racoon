package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepositosDAO {
	public static List<String> buscarDepositos() throws ClassNotFoundException, SQLException {
		ConexaoOracle conexao = new ConexaoOracle();
        conexao.conectar();
        Connection conn = conexao.getIdConexao();
        
        String sql = "SELECT deposito FROM depositos";
        PreparedStatement comando = conn.prepareStatement(sql);
        ResultSet resultado = comando.executeQuery();
        
        List<String> depositos = new ArrayList<>();
        while (resultado.next()) {
        	depositos.add(resultado.getString("deposito"));
        }
        
        resultado.close();
        comando.close();
        System.out.println("Depositos Buscados");
        conexao.desConectar();
        
        return depositos;
    }
}
