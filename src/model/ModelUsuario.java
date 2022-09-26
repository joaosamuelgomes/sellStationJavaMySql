package model;
/**
*
* @author Joao Samuel Gomes
*/
public class ModelUsuario {

    private int idUsuario;
    private String nomeUsuario;
    private String loginUsuario;
    private String senhaUsuario;

    /**
    * Construtor
    */
    public ModelUsuario(){}

    /**
    * seta o valor de idUsuario
    * @param pIdUsuario
    */
    public void setIdUsuario(int pIdUsuario){
        this.idUsuario = pIdUsuario;
    }
    /**
    * @return pk_idUsuario
    */
    public int getIdUsuario(){
        return this.idUsuario;
    }

    /**
    * seta o valor de nomeUsuario
    * @param pNomeUsuario
    */
    public void setNomeUsuario(String pNomeUsuario){
        this.nomeUsuario = pNomeUsuario;
    }
    /**
    * @return nomeUsuario
    */
    public String getNomeUsuario(){
        return this.nomeUsuario;
    }

    /**
    * seta o valor de loginUsuario
    * @param pLoginUsuario
    */
    public void setLoginUsuario(String pLoginUsuario){
        this.loginUsuario = pLoginUsuario;
    }
    /**
    * @return loginUsuario
    */
    public String getLoginUsuario(){
        return this.loginUsuario;
    }

    /**
    * seta o valor de senhaUsuario
    * @param pSenhaUsuario
    */
    public void setSenhaUsuario(String pSenhaUsuario){
        this.senhaUsuario = pSenhaUsuario;
    }
    /**
    * @return senhaUsuario
    */
    public String getSenhaUsuario(){
        return this.senhaUsuario;
    }

    @Override
    public String toString(){
        return "ModelUsuario {" + "::idUsuario = " + this.idUsuario + "::nomeUsuario = " + this.nomeUsuario + "::loginUsuario = " + this.loginUsuario + "::senhaUsuario = " + this.senhaUsuario +  "}";
    }
}