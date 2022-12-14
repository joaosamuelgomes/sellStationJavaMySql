package controller;

import DAO.DAOProdutoVendasProdutos;
import java.util.ArrayList;
import model.ModelProdutoVendasProdutos;

/**
 *
 * @author Joao Samuel Gomes
 */
public class ControllerProdutoVendasProdutos {
    
    private DAOProdutoVendasProdutos daoProdutoVendasProdutos = new DAOProdutoVendasProdutos();
    
    public ArrayList<ModelProdutoVendasProdutos> getListaProdutoVendasProdutosController(int pCodigoVenda) {
        return this.daoProdutoVendasProdutos.getListaProdutoVendasProdutosDAO(pCodigoVenda);
    }
    
}
