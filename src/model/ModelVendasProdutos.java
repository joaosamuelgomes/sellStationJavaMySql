package model;
/**
*
* @author Joao Samuel Gomes
*/
public class ModelVendasProdutos {

    private int idVendaProduto;
    private int idProduto;
    private int idVenda;
    private double valorProduto;
    private int produtoQuantidade;

    /**
    * Construtor
    */
    public ModelVendasProdutos(){}

    /**
    * seta o valor de idVendaProduto
    * @param pIdVendaProduto
    */
    public void setIdVendaProduto(int pIdVendaProduto){
        this.idVendaProduto = pIdVendaProduto;
    }
    /**
    * @return idVendaProduto
    */
    public int getIdVendaProduto(){
        return this.idVendaProduto;
    }

    /**
    * seta o valor de idProduto
    * @param pIdProduto
    */
    public void setIdProduto(int pIdProduto){
        this.idProduto = pIdProduto;
    }
    /**
    * @return idProduto
    */
    public int getIdProduto(){
        return this.idProduto;
    }

    /**
    * seta o valor de idVenda
    * @param pIdVenda
    */
    public void setIdVenda(int pIdVenda){
        this.idVenda = pIdVenda;
    }
    /**
    * @return idVenda
    */
    public int getIdVenda(){
        return this.idVenda;
    }

    /**
    * seta o valor de valorProduto
    * @param pValorProduto
    */
    public void setValorProduto(double pValorProduto){
        this.valorProduto = pValorProduto;
    }
    /**
    * @return valorProduto
    */
    public double getValorProduto(){
        return this.valorProduto;
    }

    /**
    * seta o valor de produtoQuantidade
    * @param pProdutoQuantidade
    */
    public void setProdutoQuantidade(int pProdutoQuantidade){
        this.produtoQuantidade = pProdutoQuantidade;
    }
    /**
    * @return produtoQuantidade
    */
    public int getProdutoQuantidade(){
        return this.produtoQuantidade;
    }

    @Override
    public String toString(){
        return "ModelVendasProdutos {" + "::idVendaProduto = " + this.idVendaProduto + "::idProduto = " + this.idProduto + "::idVenda = " + this.idVenda + "::valorProduto = " + this.valorProduto + "::produtoQuantidade = " + this.produtoQuantidade +  "}";
    }
}