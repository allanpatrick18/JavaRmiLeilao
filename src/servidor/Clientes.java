/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import interfaces.InterfaceCliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author allan
 */
public class Clientes implements Serializable{
    private static final long serialVersionUID = 9L;
    private int id;
    private String nome;
//    private List<Produto> listaProduto  = new ArrayList<>();
    private InterfaceCliente referenciaCliente;

    /**
     *
     */
    public Clientes() {
    }

    /**
     *
     * @param referenciaCliente
     * @param processoID
     * @param nome
     */
    public Clientes(InterfaceCliente referenciaCliente, Integer processoID, String nome) {
        this.referenciaCliente =  referenciaCliente;
        this.id = processoID;
        this.nome = nome; 
        
    }
   
    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return
     */
    public InterfaceCliente getReferenciaCliente() {
        return referenciaCliente;
    }

    /**
     *
     * @param referenciaCliente
     */
    public void setReferenciaCliente(InterfaceCliente referenciaCliente) {
        this.referenciaCliente = referenciaCliente;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

//    public List<Produto> getListaProduto() {
//        return listaProduto;
//    }
//
//    public void setListaProduto(List<Produto> listaProduto) {
//        this.listaProduto = listaProduto;
//    }
//   
    
    
}
