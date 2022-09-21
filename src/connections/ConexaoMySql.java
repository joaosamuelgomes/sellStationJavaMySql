package connections;

/**
 *
 * @author Joao Samuel Gomes
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



//Início da classe de conexão//

public class ConexaoMySql {

             public static String status = "Não conectou...";

//Método Construtor da Classe//
        public ConexaoMySql() {

    }

//Método de Conexão//

public static java.sql.Connection getConexaoMySQL() {

        Connection connection = null;  //atributo do tipo Connection
try {
    
// Carregando o JDBC Driver padrão

String driverName = "com.mysql.cj.jdbc.Driver";
Class.forName(driverName);

// Configurando a nossa conexão com um banco de dados//
 
        String url = "jdbc:mysql://localhost:3306/dbsellstationapp";
        String username = "root";        
        String password = "";      
        
        connection = DriverManager.getConnection(url, username, password);
        
        //Testa sua conexão//
        if (connection != null) {
            status = ("STATUS---> Conectado com sucesso!");
        } else {
            status = ("STATUS---> Não foi possivel realizar conexão");
        }

        return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("O driver especificado nao foi encontrado.");
            return null;
            
        } catch (SQLException e) {

            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    //Método que retorna o status da sua conexão//

    public static String statusConection() {
        return status;
    }

   //Método que fecha sua conexão//

    public static boolean FecharConexao() {

        try {
            ConexaoMySql.getConexaoMySQL().close();
            return true;

        } catch (SQLException e) {
            return false;
            
        }

    }
    
   //Método que reinicia sua conexão//

    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return ConexaoMySql.getConexaoMySQL();

    }
    
   /* public boolean executarSql(String pSql) {
        
    }
    
    public boolean  executarUpdateDelete(String pSql) {
        
    }
    
    public int inserirSql(String pSql) {
        
    } */
    
    

}