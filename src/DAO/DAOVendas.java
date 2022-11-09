package DAO;

import model.ModelVendas;
import connections.ConexaoMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
*
* @author João Samuel Gomes
*/
public class DAOVendas extends ConexaoMySql {

    /**
    * grava Vendas
    * @param pModelVendas
    * @return int
    */
    public int salvarVendasDAO(ModelVendas pModelVendas){
        try {
            this.Conectar();
            return this.inserirSql(
                "INSERT INTO tbl_vendas ("
                    + "pk_id_venda,"
                    + "fk_id_cliente,"
                    + "data_venda,"
                    + "valor_liquido,"
                    + "valor_bruto,"
                    + "valor_desconto"
                + ") VALUES ("
                    + "'" + pModelVendas.getIdVenda() + "',"
                    + "'" + pModelVendas.getIdCliente() + "',"
                    + "'" + pModelVendas.getDataVenda() + "',"
                    + "'" + pModelVendas.getValorLiquido() + "',"
                    + "'" + pModelVendas.getValorBruto() + "',"
                    + "'" + pModelVendas.getValorDesconto() + "'"
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
    * recupera Vendas
    * @param pIdVenda
    * @return ModelVendas
    */
    public ModelVendas retornarVendasDAO(int pIdVenda){
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.Conectar();
            this.executarSql(
                "SELECT "
                    + "pk_id_venda,"
                    + "fk_id_cliente,"
                    + "data_venda,"
                    + "valor_liquido,"
                    + "valor_bruto,"
                    + "valor_desconto"
                 + " FROM"
                     + " tbl_vendas"
                 + " WHERE"
                     + " pk_id_venda = '" + pIdVenda + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setIdCliente(this.getResultSet().getInt(2));
                modelVendas.setDataVenda(this.getResultSet().getDate(3));
                modelVendas.setValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setValorDesconto(this.getResultSet().getDouble(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.FecharConexao();
        }
        return modelVendas;
    }

    /**
    * recupera uma lista de Vendas
        * @return ArrayList
    */
    public ArrayList<ModelVendas> retornarListaVendasDAO(){
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.Conectar();
            this.executarSql(
                "SELECT "
                    + "pk_id_venda,"
                    + "fk_id_cliente,"
                    + "data_venda,"
                    + "valor_liquido,"
                    + "valor_bruto,"
                    + "valor_desconto"
                 + " FROM"
                     + " tbl_vendas"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas = new ModelVendas();
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setIdCliente(this.getResultSet().getInt(2));
                modelVendas.setDataVenda(this.getResultSet().getDate(3));
                modelVendas.setValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setValorDesconto(this.getResultSet().getDouble(6));
                listamodelVendas.add(modelVendas);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.FecharConexao();
        }
        return listamodelVendas;
    }

    /**
    * atualiza Vendas
    * @param pModelVendas
    * @return boolean
    */
    public boolean atualizarVendasDAO(ModelVendas pModelVendas){
        try {
            Connection conexao = Conectar();
                String sql = "UPDATE tbl_vendas SET pk_id_venda = ?, fk_id_cliente = ?, data_venda = ?,"
                        + "valor_liquido = ?, valor_bruto = ?, valor_desconto = ? WHERE pk_id_venda = ?";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, pModelVendas.getIdVenda());
                ps.setInt(2, pModelVendas.getIdCliente());
                ps.setDate(3, pModelVendas.getDataVenda());
                ps.setDouble(4, pModelVendas.getValorLiquido());
                ps.setDouble(5, pModelVendas.getValorBruto());
                ps.setDouble(6, pModelVendas.getValorDesconto());
                ps.setInt(7, pModelVendas.getIdVenda());
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
    * exclui Vendas
    * @param pIdVenda
    * @return boolean
    */
    public boolean excluirVendasDAO(int pIdVenda){
        try {
            Connection conexao = Conectar();
            String sql = "DELETE FROM tbl_vendas WHERE pk_id_venda = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, pIdVenda);
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