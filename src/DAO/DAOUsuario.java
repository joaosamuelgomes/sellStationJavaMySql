package DAO;

import model.ModelUsuario;
import connections.ConexaoMySql;
import static connections.ConexaoMySql.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
*
* @author Joao Samuel Gomes
*/
public class DAOUsuario extends ConexaoMySql {

    /**
    * grava Usuario
    * @param pModelUsuario
    * @return int
    */
    public int salvarUsuarioDAO(ModelUsuario pModelUsuario){
        try {
            this.Conectar();
            return this.inserirSql(
                "INSERT INTO tbl_usuario ("
                    + "nome_usuario,"
                    + "login_usuario,"
                    + "senha_usuario"
                + ") VALUES ("
                    + "'" + pModelUsuario.getNomeUsuario() + "',"
                    + "'" + pModelUsuario.getLoginUsuario() + "',"
                    + "'" + pModelUsuario.getSenhaUsuario() + "'"
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
    * recupera Usuario
    * @param pIdUsuario
    * @return ModelUsuario
    */
    public ModelUsuario retornarUsuarioDAO(int pIdUsuario){
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.Conectar();
            this.executarSql(
                "SELECT "
                    + "pk_id_usuario,"
                    + "nome_usuario,"
                    + "login_usuario,"
                    + "senha_usuario"
                 + " FROM"
                     + " tbl_usuario"
                 + " WHERE"
                     + " pk_id_usuario = '" + pIdUsuario + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUsuario.setIdUsuario(this.getResultSet().getInt(1));
                modelUsuario.setNomeUsuario(this.getResultSet().getString(2));
                modelUsuario.setLoginUsuario(this.getResultSet().getString(3));
                modelUsuario.setSenhaUsuario(this.getResultSet().getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.FecharConexao();
        }
        return modelUsuario;
    }

    /**
    * recupera uma lista de Usuario
        * @return ArrayList
    */
    public ArrayList<ModelUsuario> retornarListaUsuarioDAO(){
        ArrayList<ModelUsuario> listamodelUsuario = new ArrayList();
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.Conectar();
            this.executarSql(
                "SELECT "
                    + "pk_id_usuario,"
                    + "nome_usuario,"
                    + "login_usuario,"
                    + "senha_usuario"
                 + " FROM"
                     + " tbl_usuario"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUsuario = new ModelUsuario();
                modelUsuario.setIdUsuario(this.getResultSet().getInt(1));
                modelUsuario.setNomeUsuario(this.getResultSet().getString(2));
                modelUsuario.setLoginUsuario(this.getResultSet().getString(3));
                modelUsuario.setSenhaUsuario(this.getResultSet().getString(4));
                listamodelUsuario.add(modelUsuario);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.FecharConexao();
        }
        return listamodelUsuario;
    }

    /**
    * atualiza Usuario
    * @param pModelUsuario
    * @return boolean
    */
    public boolean atualizarUsuarioDAO(ModelUsuario pModelUsuario){
        try {
            Connection conexao = Conectar();
            String sql = "UPDATE tbl_usuario SET nome_usuario = ?, login_usuario = ?, senha_usuario = ?"
                    +" WHERE pk_id_usuario = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, pModelUsuario.getNomeUsuario());
            ps.setString(2, pModelUsuario.getLoginUsuario());
            ps.setString(3, pModelUsuario.getSenhaUsuario());
            ps.setInt(4, pModelUsuario.getIdUsuario());
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
    * exclui Usuario
    * @param pIdUsuario
    * @return boolean
    */
    public boolean excluirUsuarioDAO(int pIdUsuario){
        try {
            Connection conexao = Conectar();
            String sql = "DELETE FROM tbl_usuario WHERE pk_id_usuario = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, pIdUsuario);
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