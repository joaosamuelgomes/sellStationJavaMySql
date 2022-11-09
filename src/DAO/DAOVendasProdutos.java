package DAO;

import model.ModelVendasProdutos;
import connections.ConexaoMySql;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
/**
*
* @author João Samuel Gomes
*/
public class DAOVendasProdutos extends ConexaoMySql {

    /**
    * grava VendasProdutos
    * @param pModelVendasProdutos
    * @return int
    */
    public int salvarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos){
        try {
            this.Conectar();
            return this.inserirSql(
                "INSERT INTO tbl_vendas_produtos ("
                    + "id_venda_produto,"
                    + "id_produto,"
                    + "id_venda,"
                    + "valor_produto,"
                    + "produto_quantidade"
                + ") VALUES ("
                    + "'" + pModelVendasProdutos.getIdVendaProduto() + "',"
                    + "'" + pModelVendasProdutos.getIdProduto() + "',"
                    + "'" + pModelVendasProdutos.getIdVenda() + "',"
                    + "'" + pModelVendasProdutos.getValorProduto() + "',"
                    + "'" + pModelVendasProdutos.getProdutoQuantidade() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.FecharConexao();
        }
    }

    /**
    * recupera VendasProdutos
    * @param pIdVendaProduto
    * @return ModelVendasProdutos
    */
    public ModelVendasProdutos retornarVendasProdutosDAO(int pIdVendaProduto){
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.Conectar();
            this.executarSql(
                "SELECT "
                    + "id_venda_produto,"
                    + "id_produto,"
                    + "id_venda,"
                    + "valor_produto,"
                    + "produto_quantidade"
                 + " FROM"
                     + " tbl_vendas_produtos"
                 + " WHERE"
                     + " id_venda_produto = '" + pIdVendaProduto + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendasProdutos.setIdVendaProduto(this.getResultSet().getInt(1));
                modelVendasProdutos.setIdProduto(this.getResultSet().getInt(2));
                modelVendasProdutos.setIdVenda(this.getResultSet().getInt(3));
                modelVendasProdutos.setValorProduto(this.getResultSet().getDouble(4));
                modelVendasProdutos.setProdutoQuantidade(this.getResultSet().getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.FecharConexao();
        }
        return modelVendasProdutos;
    }

    /**
    * recupera uma lista de VendasProdutos
        * @return ArrayList
    */
    public ArrayList<ModelVendasProdutos> retornarListaVendasProdutosDAO(){
        ArrayList<ModelVendasProdutos> listamodelVendasProdutos = new ArrayList();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.Conectar();
            this.executarSql(
                "SELECT "
                    + "pk_id_venda_produto,"
                    + "fk_id_produto,"
                    + "fk_id_venda,"
                    + "produto_valor,"
                    + "produto_quantidade"
                 + " FROM"
                     + " tbl_vendas_produtos"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendasProdutos = new ModelVendasProdutos();
                modelVendasProdutos.setIdVendaProduto(this.getResultSet().getInt(1));
                modelVendasProdutos.setIdProduto(this.getResultSet().getInt(2));
                modelVendasProdutos.setIdVenda(this.getResultSet().getInt(3));
                modelVendasProdutos.setValorProduto(this.getResultSet().getDouble(4));
                modelVendasProdutos.setProdutoQuantidade(this.getResultSet().getInt(5));
                listamodelVendasProdutos.add(modelVendasProdutos);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.FecharConexao();
        }
        return listamodelVendasProdutos;
    }

    /**
    * atualiza VendasProdutos
    * @param pModelVendasProdutos
    * @return boolean
    */
    public boolean atualizarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos){
        try {
            Connection conexao = this.Conectar();
                String sql = "UPDATE tbl_vendas_produtos SET id_venda_produto = ? id_produto = ? id_venda = ?, "
                        + "valor_produto = ?, produto_quantidade = ? WHERE id_venda_produto = ?";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, pModelVendasProdutos.getIdVendaProduto());
                ps.setInt(2, pModelVendasProdutos.getIdProduto());
                ps.setInt(3, pModelVendasProdutos.getIdVenda());
                ps.setDouble(4, pModelVendasProdutos.getValorProduto());
                ps.setInt(5, pModelVendasProdutos.getProdutoQuantidade());
                ps.setInt(6, pModelVendasProdutos.getIdVendaProduto());
                ps.executeUpdate();
                return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.FecharConexao();
        }
    }

    /**
    * exclui VendasProdutos
    * @param pIdVendaProduto
    * @return boolean
    */
    public boolean excluirVendasProdutosDAO(int pIdVendaProduto){
        try {
            Connection conexao = Conectar();
            String sql = "DELETE FROM tbl_vendas_produtos WHERE id_venda_produto = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, pIdVendaProduto);
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.FecharConexao();
        }
    }
}