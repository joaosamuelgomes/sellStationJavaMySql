package DAO;

import connections.ConexaoMySql;
import java.util.ArrayList;
import model.ModelProdutos;

/**
 *
 * @author Joao Samuel Gomes
 */
public class DaoProdutos extends ConexaoMySql {

    public int salvarProdutosDAO(ModelProdutos pModelProdutos) {

        try {
            this.Conectar();
            return this.inserirSql("INSERT INTO tbl_produto ("
                    + "nome_produto,"
                    + "valor_produto"
                    + "estoque_produto"
                    + ") VALUES ("
                    + "'" + pModelProdutos.getProdutoNome() + "',"
                    + "'" + pModelProdutos.getProdutoValor() + "',"
                    + "'" + pModelProdutos.getProdutoEstoque() + "',"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.FecharConexao();
        }
    }

    public boolean excluirProdutoDAO(int pIdProduto) {
        try {
            this.Conectar();
            return this.executarUpdateDelete(
                    "DELETE FROM tbl_produto WHERE pk_id_produto = '" + pIdProduto + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.FecharConexao();
        }
    }

    public boolean alterarProdutoDAO(ModelProdutos pModelProdutos) {
        try {
            this.Conectar();
            return this.executarUpdateDelete(
                    "UPDATE tbl_produto SET "
                    + "nome_produto = '" + pModelProdutos.getProdutoNome() + "',"
                    + "valor_produto = '" + pModelProdutos.getProdutoValor() + "',"
                    + "estoque_produto = '" + pModelProdutos.getProdutoEstoque() + "'"
                    + " WHERE pk_id_produto = '" + pModelProdutos.getIdProduto() + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.FecharConexao();
        }
    }

    public ModelProdutos retornarProdutoDAO(int pIdProduto) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.Conectar();
            this.executarSql("SELECT "
                    + "pk_id_produto, "
                    + "nome_produto, "
                    + "valor_produto, "
                    + "estoque_produto "
                    + "FROM tbl_produto WHERE pk_id_produto = '" + pIdProduto + "'"
            );
            while (this.getResultSet().next()) {
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setProdutoNome(this.getResultSet().getString(2));
                modelProdutos.setProdutoValor(this.getResultSet().getDouble(3));
                modelProdutos.setProdutoEstoque(this.getResultSet().getInt(4));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.FecharConexao();
        }
        return modelProdutos;
    }

    public ArrayList<ModelProdutos> retornarListaProdutosDAO() {
        ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.Conectar();
            this.executarSql("SELECT pk_id_produto, nome_produto, valor_produto, estoque_produto FROM tbl_produto;");
            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setProdutoNome(this.getResultSet().getString(2));
                modelProdutos.setProdutoValor(this.getResultSet().getDouble(3));
                modelProdutos.setProdutoEstoque(this.getResultSet().getInt(4));
                listaModelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.FecharConexao();
        }
        return listaModelProdutos;
    }

}
