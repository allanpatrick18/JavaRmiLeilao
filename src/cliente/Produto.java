/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.Serializable;
import servidor.*;

/**
 *
 * @author allan
 */
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String descricao;
    private String precoInicial;
    private String tempoFinal;

    Produto(String nomeProduto, String precoIncial, String descricao, String tempo) {
        this.descricao = descricao;
        this.precoInicial = precoIncial;
        this.tempoFinal = tempo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrecoInicial() {
        return precoInicial;
    }

    public void setPrecoInicial(String precoInicial) {
        this.precoInicial = precoInicial;
    }

    public String getTempoFinal() {
        return tempoFinal;
    }

    public void setTempoFinal(String tempoFinal) {
        this.tempoFinal = tempoFinal;
    }
    
    
    
}
