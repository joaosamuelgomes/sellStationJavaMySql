package model;

import java.util.ArrayList;

/**
 *
 * @author Joao Samuel Gomes
 */
public class ModelVendasCliente {
    
    private ModelVendas modelVendas;

    public ModelVendas getModelVendas() {
        return modelVendas;
    }

    public void setModelVendas(ModelVendas modelVendas) {
        this.modelVendas = modelVendas;
    }

    public ModelCliente getModelCliente() {
        return modelCliente;
    }

    public void setModelCliente(ModelCliente modelCliente) {
        this.modelCliente = modelCliente;
    }
    private ModelCliente modelCliente;
    
    private ArrayList<ModelVendasCliente> listaModelVendasClientes;

    public ArrayList<ModelVendasCliente> getListaModelVendasClientes() {
        return listaModelVendasClientes;
    }

    public void setListaModelVendasClientes(ArrayList<ModelVendasCliente> listaModelVendasClientes) {
        this.listaModelVendasClientes = listaModelVendasClientes;
    }
}
