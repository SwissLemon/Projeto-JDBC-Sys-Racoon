package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoOracle {
    // Usuário, senha e URL para conexão
    private String usuario = "fortrek2";
    private String senha = "fortrek2";
    String url = "jdbc:oracle:thin:@10.10.50.2:1521/S003TRN.prddatabase.pocvcn.oraclevcn.com";
    private Connection idConexao;
    
    public Connection getIdConexao() {
        return idConexao;
    }

    public void setIdConexao(Connection idConexao) {
        this.idConexao = idConexao;
    }

    // Conectar ao Oracle
    public void conectar() throws ClassNotFoundException, SQLException {
        // Carregar driver do Oracle
        Class.forName("oracle.jdbc.OracleDriver");
        // Fazer a conexão
        this.idConexao = DriverManager.getConnection(url, usuario, senha);
        // Testar conexão
        if (this.idConexao != null) {
            System.out.println("Conectado ao Oracle.");
        }
    }

    // Desconectar para evitar uso excessivo de recursos
    public void desConectar() throws SQLException {
        if (this.idConexao != null) {
            System.out.println("Desconectado.");
            this.idConexao.close();
        }
    }
}
