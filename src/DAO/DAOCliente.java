package DAO;

import model.ModelCliente;
import connections.ConexaoMySql;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Connection;
/**
*
* @author Joao Samuel Gomes
*/
public class DAOCliente extends ConexaoMySql {

    /**
    * grava Cliente
    * @param pModelCliente
    * @return int
    */
    public int salvarClienteDAO(ModelCliente pModelCliente){
        try {
            this.Conectar();
            return this.inserirSql(
                "INSERT INTO tbl_cliente ("
                    + "nome_cliente,"
                    + "endereco_cliente,"
                    + "bairro_cliente,"
                    + "cidade_cliente,"
                    + "estado_cliente,"
                    + "cep_cliente,"
                    + "telefone_cliente"
                + ") VALUES ("
                    + "'" + pModelCliente.getNomeCliente() + "',"
                    + "'" + pModelCliente.getEnderecoCliente() + "',"
                    + "'" + pModelCliente.getBairroCliente() + "',"
                    + "'" + pModelCliente.getCidadeCliente() + "',"
                    + "'" + pModelCliente.getEstadoCliente() + "',"
                    + "'" + pModelCliente.getCepCliente() + "',"
                    + "'" + pModelCliente.getTelefoneCliente() + "'"
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
    * recupera Cliente
    * @param pIdCliente
    * @return ModelCliente
    */
    public ModelCliente retornarClienteDAO(int pIdCliente){
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.Conectar();
            this.executarSql(
                "SELECT "
                    + "pk_id_cliente,"
                    + "nome_cliente,"
                    + "endereco_cliente,"
                    + "bairro_cliente,"
                    + "cidade_cliente,"
                    + "estado_cliente,"
                    + "cep_cliente,"
                    + "telefone_cliente"
                 + " FROM"
                     + " tbl_cliente"
                 + " WHERE"
                     + " pk_id_cliente = '" + pIdCliente + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setNomeCliente(this.getResultSet().getString(2));
                modelCliente.setEnderecoCliente(this.getResultSet().getString(3));
                modelCliente.setBairroCliente(this.getResultSet().getString(4));
                modelCliente.setCidadeCliente(this.getResultSet().getString(5));
                modelCliente.setEstadoCliente(this.getResultSet().getString(6));
                modelCliente.setCepCliente(this.getResultSet().getString(7));
                modelCliente.setTelefoneCliente(this.getResultSet().getString(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.FecharConexao();
        }
        return modelCliente;
    }
    
    public ModelCliente retornarClienteDAO(String pNomeCliente){
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.Conectar();
            this.executarSql(
                "SELECT "
                    + "pk_id_cliente,"
                    + "nome_cliente,"
                    + "endereco_cliente,"
                    + "bairro_cliente,"
                    + "cidade_cliente,"
                    + "estado_cliente,"
                    + "cep_cliente,"
                    + "telefone_cliente"
                 + " FROM"
                     + " tbl_cliente"
                 + " WHERE"
                     + " nome_cliente = '" + pNomeCliente + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setNomeCliente(this.getResultSet().getString(2));
                modelCliente.setEnderecoCliente(this.getResultSet().getString(3));
                modelCliente.setBairroCliente(this.getResultSet().getString(4));
                modelCliente.setCidadeCliente(this.getResultSet().getString(5));
                modelCliente.setEstadoCliente(this.getResultSet().getString(6));
                modelCliente.setCepCliente(this.getResultSet().getString(7));
                modelCliente.setTelefoneCliente(this.getResultSet().getString(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.FecharConexao();
        }
        return modelCliente;
    }

    /**
    * recupera uma lista de Cliente
        * @return ArrayList
    */
    public ArrayList<ModelCliente> retornarListaClienteDAO(){
        ArrayList<ModelCliente> listamodelCliente = new ArrayList();
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.Conectar();
            this.executarSql(
                "SELECT "
                    + "pk_id_cliente,"
                    + "nome_cliente,"
                    + "endereco_cliente,"
                    + "bairro_cliente,"
                    + "cidade_cliente,"
                    + "estado_cliente,"
                    + "cep_cliente,"
                    + "telefone_cliente"
                 + " FROM"
                     + " tbl_cliente"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCliente = new ModelCliente();
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setNomeCliente(this.getResultSet().getString(2));
                modelCliente.setEnderecoCliente(this.getResultSet().getString(3));
                modelCliente.setBairroCliente(this.getResultSet().getString(4));
                modelCliente.setCidadeCliente(this.getResultSet().getString(5));
                modelCliente.setEstadoCliente(this.getResultSet().getString(6));
                modelCliente.setCepCliente(this.getResultSet().getString(7));
                modelCliente.setTelefoneCliente(this.getResultSet().getString(8));
                listamodelCliente.add(modelCliente);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.FecharConexao();
        }
        return listamodelCliente;
    }

    /**
    * atualiza Cliente
    * @param pModelCliente
    * @return boolean
    */
    public boolean atualizarClienteDAO(ModelCliente pModelCliente){
        try {
            Connection conexao = Conectar();
            String sql = "UPDATE tbl_cliente SET nome_cliente = ?, endereco_cliente = ?, bairro_cliente = ?, cidade_cliente = ?,"
                    + "estado_cliente = ?, cep_cliente = ?, telefone_cliente = ? WHERE pk_id_cliente = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, pModelCliente.getNomeCliente());
            ps.setString(2, pModelCliente.getEnderecoCliente());
            ps.setString(3, pModelCliente.getBairroCliente());
            ps.setString(4, pModelCliente.getCidadeCliente());
            ps.setString(5, pModelCliente.getEstadoCliente());
            ps.setString(6, pModelCliente.getCepCliente());
            ps.setString(7,pModelCliente.getTelefoneCliente());
            ps.setInt(8, pModelCliente.getIdCliente());
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
    * exclui Cliente
    * @param pIdCliente
    * @return boolean
    */
    public boolean excluirClienteDAO(int pIdCliente){
        try {
            Connection conexao = Conectar();
            String sql = "DELETE FROM tbl_cliente WHERE pk_id_cliente = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, pIdCliente);
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