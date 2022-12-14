package DAO;

import connections.ConexaoMySql;
import java.util.ArrayList;
import model.ModelProduto;
import model.ModelProdutoVendasProdutos;
import model.ModelVendasProdutos;

/**
 *
 * @author Joao Samuel Gomes
 */
public class DAOProdutoVendasProdutos extends ConexaoMySql {
    
    public ArrayList<ModelProdutoVendasProdutos> getListaProdutoVendasProdutosDAO(int pCodigoVenda) {
        
        ArrayList<ModelProdutoVendasProdutos> listaModelProdutoVendasProdutos = new ArrayList<>();
        ModelProdutoVendasProdutos modelProdutoVendasProdutos = new ModelProdutoVendasProdutos();
        ModelProduto modelProduto = new ModelProduto();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        
        try{      
            this.Conectar();
            this.executarSql( "SELECT tbl_produto.pk_id_produto, "
                    + "tbl_produto.estoque_produto, "
                    + "tbl_produto.nome_produto, "
                    + "tbl_produto.valor_produto, "
                    + "tbl_vendas_produtos.pk_id_venda_produto, "
                    + "tbl_vendas_produtos.fk_id_produto, "
                    + "tbl_vendas_produtos.fk_id_venda, "
                    + "tbl_vendas_produtos.produto_valor, "
                    + "tbl_vendas_produtos.produto_quantidade "
                    + "FROM tbl_vendas_produtos "
                    + "INNER JOIN tbl_produto on tbl_produto.pk_id_produto = tbl_vendas_produtos.fk_id_produto "
                    + "WHERE tbl_vendas_produtos.fk_id_venda = '"+pCodigoVenda+"';");
            while (this.getResultSet().next()) {
                modelProdutoVendasProdutos = new ModelProdutoVendasProdutos();
                modelProduto = new ModelProduto();
                modelVendasProdutos = new ModelVendasProdutos();

                modelProduto.setIdProduto(this.getResultSet().getInt(1));
                modelProduto.setProdutoEstoque(this.getResultSet().getInt(2));
                modelProduto.setProdutoNome(this.getResultSet().getString(3));
                modelProduto.setProdutoValor(this.getResultSet().getDouble(4));

                modelVendasProdutos.setIdProduto(this.getResultSet().getInt(5));
                modelVendasProdutos.setIdVenda(this.getResultSet().getInt(6));
                modelVendasProdutos.setIdVendaProduto(this.getResultSet().getInt(7));
                modelVendasProdutos.setProdutoQuantidade(this.getResultSet().getInt(8));
                modelVendasProdutos.setValorProduto(this.getResultSet().getDouble(9));

                modelProdutoVendasProdutos.setModelProduto(modelProduto);
                modelProdutoVendasProdutos.setModelVendasProdutos(modelVendasProdutos);

                listaModelProdutoVendasProdutos.add(modelProdutoVendasProdutos);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.FecharConexao();
        }
        return listaModelProdutoVendasProdutos;
    }   
}
