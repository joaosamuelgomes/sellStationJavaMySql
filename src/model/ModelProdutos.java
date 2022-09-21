package model;

/**
 *
 * @author Joao Samuel Gomes
 */
public class ModelProdutos {
    
    private int idProduto;
    private String produtoNome;
    private Double produtoValor;
    private int produtoEstoque;

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the produtoNome
     */
    public String getProdutoNome() {
        return produtoNome;
    }

    /**
     * @param produtoNome the produtoNome to set
     */
    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    /**
     * @return the produtoValor
     */
    public Double getProdutoValor() {
        return produtoValor;
    }

    /**
     * @param produtoValor the produtoValor to set
     */
    public void setProdutoValor(Double produtoValor) {
        this.produtoValor = produtoValor;
    }

    /**
     * @return the produtoEstoque
     */
    public int getProdutoEstoque() {
        return produtoEstoque;
    }

    /**
     * @param produtoEstoque the produtoEstoque to set
     */
    public void setProdutoEstoque(int produtoEstoque) {
        this.produtoEstoque = produtoEstoque;
    }
    
    
    
}
