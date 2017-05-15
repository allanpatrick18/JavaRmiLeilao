/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import interfaces.InterfaceCliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author allan
 */
public class Clientes {
    
    private int id;
    private String nome;
    private List<Produto> listaProduto  = new ArrayList<>();
    private InterfaceCliente referenciaCliente;

    public Clientes(InterfaceCliente referenciaCliente, Integer processoID, String nome) {
        this.referenciaCliente =  referenciaCliente;
        this.id = processoID;
        this.nome = nome; 
        
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public InterfaceCliente getReferenciaCliente() {
        return referenciaCliente;
    }

    public void setReferenciaCliente(InterfaceCliente referenciaCliente) {
        this.referenciaCliente = referenciaCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }
   
    
    
}
