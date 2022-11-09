package DAO;

import connections.ConexaoMySql;
import static connections.ConexaoMySql.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.ModelProduto;

/**
 *
 * @author Joao Samuel Gomes
 */
public class DAOProduto extends ConexaoMySql {

    public int salvarProdutosDAO(ModelProduto pModelProdutos) {

        try {
            this.Conectar();
            return this.inserirSql("INSERT INTO tbl_produto ("
                    + "nome_produto,"
                    + "estoque_produto,"
                    + "valor_produto"
                    + ") VALUES ("
                    + "'" + pModelProdutos.getProdutoNome() + "',"
                    + "'" + pModelProdutos.getProdutoEstoque() + "',"
                    + "'" + pModelProdutos.getProdutoValor() + "'"
                    + ");"
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
            Connection conexao = Conectar();
            String sql = "DELETE FROM tbl_produto WHERE pk_id_produto = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, pIdProduto);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.FecharConexao();
        }
    }

    public boolean alterarProdutoDAO(ModelProduto pModelProdutos) {
        try {
            Connection conexao = Conectar();
            String sql = "UPDATE tbl_produto SET nome_produto = ?, valor_produto = ?, estoque_produto = ? WHERE pk_id_produto = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, pModelProdutos.getProdutoNome());
            ps.setDouble(2, pModelProdutos.getProdutoValor());
            ps.setInt(3, pModelProdutos.getProdutoEstoque());
            ps.setInt(4, pModelProdutos.getIdProduto());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.FecharConexao();
        }
    }

    public ModelProduto retornarProdutoDAO(int pIdProduto) {
        ModelProduto modelProdutos = new ModelProduto();
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
    
        public ModelProduto retornarProdutoDAO(String pNomeProduto) {
        ModelProduto modelProdutos = new ModelProduto();
        try {
            this.Conectar();
            this.executarSql("SELECT "
                    + "pk_id_produto, "
                    + "nome_produto, "
                    + "valor_produto, "
                    + "estoque_produto "
                    + "FROM tbl_produto WHERE nome_produto = '" + pNomeProduto + "'"
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


    public ArrayList<ModelProduto> retornarListaProdutosDAO() {
        ArrayList<ModelProduto> listaModelProdutos = new ArrayList<>();
        ModelProduto modelProdutos = new ModelProduto();
        try {
            this.Conectar();
            this.executarSql("SELECT pk_id_produto, nome_produto, valor_produto, estoque_produto FROM tbl_produto;");
            while (this.getResultSet().next()) {
                modelProdutos = new ModelProduto();
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
