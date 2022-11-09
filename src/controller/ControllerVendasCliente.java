package controller;

import DAO.DAOVendasCliente;
import java.util.ArrayList;
import model.ModelVendasCliente;

/**
 *
 * @author Joao Samuel Gomes
 */
public class ControllerVendasCliente {
    
    private DAOVendasCliente daoVendasCliente = new DAOVendasCliente();

    public ArrayList<ModelVendasCliente> retornarListaVendasClienteController() {
        return this.daoVendasCliente.retornarListaVendasClienteDAO();
    }
    
}
