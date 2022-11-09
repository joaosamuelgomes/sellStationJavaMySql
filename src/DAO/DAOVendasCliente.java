package DAO;

import connections.ConexaoMySql;
import java.util.ArrayList;
import model.ModelCliente;
import model.ModelVendas;
import model.ModelVendasCliente;

/**
 *
 * @author Joao Samuel Gomes
 */
public class DAOVendasCliente extends ConexaoMySql{
    
    public ArrayList<ModelVendasCliente> retornarListaVendasClienteDAO(){
        ArrayList<ModelVendasCliente> listamodelVendasClientes = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        ModelCliente modelCliente = new ModelCliente();
        ModelVendasCliente modelVendasCliente = new ModelVendasCliente();
        try {
            this.Conectar();
            this.executarSql(
                "SELECT * FROM tbl_vendas, tbl_cliente"
            );

            while(this.getResultSet().next()){
                
                modelVendas = new ModelVendas();
                modelCliente = new ModelCliente();
                modelVendasCliente = new ModelVendasCliente();
                
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setIdCliente(this.getResultSet().getInt(2));
                modelVendas.setDataVenda(this.getResultSet().getDate(3));
                modelVendas.setValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setValorDesconto(this.getResultSet().getDouble(6));
                
                modelCliente.setIdCliente(this.getResultSet().getInt(7));
                modelCliente.setNomeCliente(this.getResultSet().getString(8));
                modelCliente.setEnderecoCliente(this.getResultSet().getString(9));
                modelCliente.setBairroCliente(this.getResultSet().getString(10));
                modelCliente.setCidadeCliente(this.getResultSet().getString(11));
                modelCliente.setEstadoCliente(this.getResultSet().getString(12));
                modelCliente.setCepCliente(this.getResultSet().getString(13));
                modelCliente.setTelefoneCliente(this.getResultSet().getString(14));
                
                modelVendasCliente.setModelVendas(modelVendas);
                modelVendasCliente.setModelCliente(modelCliente);
                listamodelVendasClientes.add(modelVendasCliente);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.FecharConexao();
        }
        return listamodelVendasClientes;
    }
}
