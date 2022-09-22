package connections;

/**
 *
 * @author Joao Samuel Gomes
 */
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//Início da classe de conexão//
public class ConexaoMySql {

    public static String status = "Não conectou...";

    public String pSql = "";

    public ResultSet resultSet = null;

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public static Connection Conectar() {
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
            ConexaoMySql.Conectar().close();
            return true;

        } catch (SQLException e) {
            return false;

        }

    }

    //Método que reinicia sua conexão//
    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return ConexaoMySql.Conectar();

    }

    public boolean executarSql(String pSql) {
        try {
            Connection conexao = Conectar();
            Statement stmt = conexao.createStatement();
            this.setResultSet(stmt.executeQuery(pSql));
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

    }

    public boolean executarUpdateDelete(String pSql) {
        try {
            Connection conexao = Conectar();
            PreparedStatement ps = conexao.prepareStatement(pSql);
            ps.setString(1, pSql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public int inserirSql(String pSql) {
        int status = 0;
        try {
            Connection conexao = Conectar();
            Statement stmt = conexao.createStatement();
            stmt.executeUpdate(pSql);
            this.setResultSet(stmt.executeQuery("SELECT last_insert_id();"));

            while (this.resultSet.next()) {
                status = this.resultSet.getInt(1);
            }
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return status;
        }
    }

//Método Construtor da Classe//
    public ConexaoMySql() {

    }

}
