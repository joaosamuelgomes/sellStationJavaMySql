package DAO;

import connections.ConexaoMySql;
import model.ModelProdutos;

/**
 *
 * @author Joao Samuel Gomes
 */
public class DaoProdutos extends ConexaoMySql {
    
    public int salvarProdutosDAO(ModelProdutos pModelProdutos) {
        
        try{
            this.getConexaoMySQL();
            return this.inserirSql("INSERT INTO tbl_produto ("
                    + "nome_produto,"
                    + "valor_produto"
                    + "estoque_produto"
                    + ") VALUES ("
                    + "'" + pModelProdutos.getProdutoNome() + "',"
                    + "'" + pModelProdutos.getProdutoValor() + "',"
                    + "'" + pModelProdutos.getProdutoEstoque() + "',"
                    
            );
        } catch(Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.FecharConexao();
        }
    }
}
