/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author allan
 */
public class Produto implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String descricao;
    private Integer precoInicial;
    private Integer tempoFinal;
    private List<Clientes> processoInteressados = new ArrayList<>();
    private Clientes ultimoLancador; //ultimo cara que deu o lance
    private Integer precoFinal;
    private Clientes leiloador;

    public Produto(String name, String descricao, Integer precoFinal) {
        this.name = name;
        this.descricao = descricao;
      //  this.ultimoLancador = ultimoLancador;
        this.precoFinal = precoFinal;
      //  this.leiloador = leiloador;
    }

    public Clientes getLeiloador() {
        return leiloador;
    }

    public void setLeiloador(Clientes leiloador) {
        this.leiloador = leiloador;
    }

    public Produto(Integer id, String name, String descricao, Integer precoInicial, Integer tempoFinal, Clientes leiloador) {
        this.id = id;
        this.name = name;
        this.descricao = descricao;
        this.precoInicial = precoInicial;
        this.tempoFinal = tempoFinal;
        this.leiloador = leiloador;
    }

    public List<Clientes> getProcessoInteressados() {
        return processoInteressados;
    }

    public void setProcessoInteressados(List<Clientes> processoInteressados) {
        this.processoInteressados = processoInteressados;
    }

    public Clientes getUltimoLancador() {
        return ultimoLancador;
    }

    public void setUltimoLancador(Clientes ultimoLancador) {
        this.ultimoLancador = ultimoLancador;
    }

    public Integer getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(Integer precoFinal) {
        this.precoFinal = precoFinal;
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

    public Integer getPrecoInicial() {
        return precoInicial;
    }

    public void setPrecoInicial(Integer precoInicial) {
        this.precoInicial = precoInicial;
    }

    public Integer getTempoFinal() {
        return tempoFinal;
    }

    public void setTempoFinal(Integer tempoFinal) {
        this.tempoFinal = tempoFinal;
    }

    
    
    
}
