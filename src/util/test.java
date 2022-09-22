package util;

/**
 *
 * @author Joao Samuel Gomes
 */

import connections.ConexaoMySql;

public class test {

    public static void main(String[] args) {

        ConexaoMySql.Conectar();
        System.out.println(ConexaoMySql.statusConection());
        ConexaoMySql.FecharConexao();
    }
    
}
