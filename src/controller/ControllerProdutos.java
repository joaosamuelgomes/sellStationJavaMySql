package controller;

import DAO.DaoProdutos;
import java.util.ArrayList;
import model.ModelProdutos;

/**
 *
 * @author Joao Samuel Gomes
 */
public class ControllerProdutos {
    
    private DaoProdutos daoProdutos = new DaoProdutos();
    
    /**
     * controller para salvar produtos
     * @param pModelProdutos
     * @return int
     */
    public int SalvarProdutosController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.salvarProdutosDAO(pModelProdutos);
    }
    
    /**
     * controller para excluir produto por id
     * @param pIdProduto
     * @return boolean
     */
    public boolean excluirProdutoController(int pIdProduto){
        return this.daoProdutos.excluirProdutoDAO(pIdProduto);
    }
    
    /**
     * controller para alterar produto
     * @param pModelProdutos
     * @return boolean
     */
    public boolean alterarProdutoController(ModelProdutos pModelProdutos){
        return this.daoProdutos.alterarProdutoDAO(pModelProdutos);
    }
    
    /**
     * controller para retornar produto por id
     * @param pIdProduto
     * @return ModelProdutos
     */
    public ModelProdutos retornarProdutoController(int pIdProduto){
        return this.daoProdutos.retornarProdutoDAO(pIdProduto);
    }
    
    /**
     * controller para retornar uma lista de produtos
     * @return lista ModelProdutos
     */
    public ArrayList<ModelProdutos> retornarListaProdutosController(){
        return this.daoProdutos.retornarListaProdutosDAO();
    }
    
}
