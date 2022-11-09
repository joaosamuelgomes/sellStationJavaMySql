

package model;

import java.sql.Date;

/**
*
* @author Joao Samuel Gomes
*/
public class ModelVendas {

    private int idVenda;
    private int idCliente;
    private Date dataVenda;
    private double valorLiquido;
    private double valorBruto;
    private double valorDesconto;

    /**
    * Construtor
    */
    public ModelVendas(){}

    /**
    * seta o valor de idVenda
    * @param pIdVenda
    */
    public void setIdVenda(int pIdVenda){
        this.idVenda = pIdVenda;
    }
    /**
    * @return pk_idVenda
    */
    public int getIdVenda(){
        return this.idVenda;
    }

    /**
    * seta o valor de idCliente
    * @param pIdCliente
    */
    public void setIdCliente(int pIdCliente){
        this.idCliente = pIdCliente;
    }
    /**
    * @return fk_idCliente
    */
    public int getIdCliente(){
        return this.idCliente;
    }

    /**
    * seta o valor de dataVenda
    * @param pDataVenda
    */
    public void setDataVenda(Date pDataVenda){
        this.dataVenda = pDataVenda;
    }
    /**
    * @return dataVenda
    */
    public Date getDataVenda(){
        return this.dataVenda;
    }

    /**
    * seta o valor de valorLiquido
    * @param pValorLiquido
    */
    public void setValorLiquido(double pValorLiquido){
        this.valorLiquido = pValorLiquido;
    }
    /**
    * @return valorLiquido
    */
    public double getValorLiquido(){
        return this.valorLiquido;
    }

    /**
    * seta o valor de valorBruto
    * @param pValorBruto
    */
    public void setValorBruto(double pValorBruto){
        this.valorBruto = pValorBruto;
    }
    /**
    * @return valorBruto
    */
    public double getValorBruto(){
        return this.valorBruto;
    }

    /**
    * seta o valor de valorDesconto
    * @param pValorDesconto
    */
    public void setValorDesconto(double pValorDesconto){
        this.valorDesconto = pValorDesconto;
    }
    /**
    * @return valorDesconto
    */
    public double getValorDesconto(){
        return this.valorDesconto;
    }

    @Override
    public String toString(){
        return "ModelVendas {" + "::idVenda = " + this.idVenda + "::idCliente = " + this.idCliente + "::dataVenda = " + this.dataVenda + "::valorLiquido = " + this.valorLiquido + "::valorBruto = " + this.valorBruto + "::valorDesconto = " + this.valorDesconto +  "}";
    }
}