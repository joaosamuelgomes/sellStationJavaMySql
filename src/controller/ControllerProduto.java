package controller;

import DAO.DAOProduto;
import java.util.ArrayList;
import model.ModelProduto;

/**
 *
 * @author Joao Samuel Gomes
 */
public class ControllerProduto {
    
    private DAOProduto daoProdutos = new DAOProduto();
    
    /**
     * controller para salvar produtos
     * @param pModelProdutos
     * @return int
     */
    public int salvarProdutosController(ModelProduto pModelProdutos) {
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
    public boolean alterarProdutoController(ModelProduto pModelProdutos){
        return this.daoProdutos.alterarProdutoDAO(pModelProdutos);
    }
    
    /**
     * controller para retornar produto por id
     * @param pIdProduto
     * @return ModelProdutos
     */
    public ModelProduto retornarProdutoController(int pIdProduto){
        return this.daoProdutos.retornarProdutoDAO(pIdProduto);
    }
    
    /**
     * controller para retornar produto por id
     * @param pNomeProduto
     * @return ModelProdutos
     */
    public ModelProduto retornarProdutoControllerPorNome(String pNomeProduto){
        return this.daoProdutos.retornarProdutoDAOPorNome(pNomeProduto);
    }
    
    /**
     * controller para retornar uma lista de produtos
     * @return lista ModelProdutos
     */
    public ArrayList<ModelProduto> retornarListaProdutosController(){
        return this.daoProdutos.retornarListaProdutosDAO();
    }
    
}
