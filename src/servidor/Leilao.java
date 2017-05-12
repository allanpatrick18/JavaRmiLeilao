/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author allan
 */
public class Leilao {
    private int id;
    private Produto produto;
    private List<Processo> proceso = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Processo> getProceso() {
        return proceso;
    }

    public void setProceso(List<Processo> proceso) {
        this.proceso = proceso;
    }
    
    
    
    
    
}
