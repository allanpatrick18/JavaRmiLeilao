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
 * Classe produto onde contém as característica referentes ao produto que é ao mesmo tempo o leilão
 * @author allan
 */
public class Produto implements Serializable{
    private static final long serialVersionUID = 1L;                
    private Integer id;                                             //id do produto
    private String name;                                            // nome do produto  
    private String descricao;                                       // descrição do produto 
    private Integer precoInicial;                                   // preço inicial do produto
    private Integer tempoFinal;                                     // tempo de leilão do produto            
    private List<Clientes> processoInteressados = new ArrayList<>();// lista de processos interessados no produto    
    private Clientes ultimoLancador; //ultimo cara que deu o lance  // Ultimo processo que deu o maior lance
    private String ultimoLanca; //ultimo cara que deu o lance       // Nome do processo que deu o maior lance
    private Integer precoFinal;                                     // Preco final do leilao do produto
    private Clientes leiloador;                                     // Leiloador do produto
    private String leiloa;                                          // Nome do leiloador do produto

    /**
     * Construtor 1 da classe Produto.
     * @param name
     * @param descricao
     * @param precoFinal
     * @param ultimoLancador
     * @param leiloador
     */
    public Produto(String name, String descricao, Integer precoFinal, String ultimoLancador, String leiloador) {
        this.name = name;
        this.descricao = descricao;
       this.ultimoLanca = ultimoLancador;
        this.precoFinal = precoFinal;
       this.leiloa = leiloador;
    }

    /**
     * Retorna o leiloador do produto
     * @return
     */
    public Clientes getLeiloador() {
        return leiloador;
    }

    /**
     * Seta o leiloador do produto
     * @param leiloador
     */
    public void setLeiloador(Clientes leiloador) {
        this.leiloador = leiloador;
    }

    /**
     * Construtor 2 da classe produto
     * @param id
     * @param name
     * @param descricao
     * @param precoInicial
     * @param tempoFinal
     * @param leiloador
     */
    public Produto(Integer id, String name, String descricao, Integer precoInicial, Integer tempoFinal, Clientes leiloador) {
        this.id = id;
        this.name = name;
        this.descricao = descricao;
        this.precoInicial = precoInicial;
        this.precoFinal = precoInicial;
        this.tempoFinal = tempoFinal;
        this.leiloador = leiloador;
    }

    /**
     * Retorna a lista de processos interessados no produto, ou seja, os processos que registraram o interesse no produto
     * @return
     */
    public List<Clientes> getProcessoInteressados() {
        return processoInteressados;
    }

    /**
     * Altera a lista dos processos que registraram interesse no produto durante o leilão
     * @param processoInteressados
     */
    public void setProcessoInteressados(List<Clientes> processoInteressados) {
        this.processoInteressados = processoInteressados;
    }

    /**
     * Retorna o ultimo processo que deu o maior lance
     * @return
     */
    public Clientes getUltimoLancador() {
        return ultimoLancador;
    }

    /**
     * Altera o ultimo processo que deu o maior lance
     * @param ultimoLancador
     */
    public void setUltimoLancador(Clientes ultimoLancador) {
        this.ultimoLancador = ultimoLancador;
    }
 
    /**
     * Retorna o id do produto
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * Altera o id do produto
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retorna o nome do produto
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Altera o nome do produto
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna a descrição do produto
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Altera a descrição do produto
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna o preço inicial do produto
     * @return
     */
    public Integer getPrecoInicial() {
        return precoInicial;
    }

    /**
     * Altera o preço inicial do produto
     * @param precoInicial
     */
    public void setPrecoInicial(Integer precoInicial) {
        this.precoInicial = precoInicial;
    }

    /**
     * Retorna preço  final do Produto
     * @return
     */
    public Integer getTempoFinal() {
        return tempoFinal;
    }

    /**
     * Altera tempo final de leilão
     * @param tempoFinal
     */
    public void setTempoFinal(Integer tempoFinal) {
        this.tempoFinal = tempoFinal;
    }

    /**
     * Retorna preço final do leilão
     * @return
     */
    public Integer getPrecoFinal() {
        return precoFinal;
    }

    /**
     * Altera preço final
     * @param precoFinal
     */
    public void setPrecoFinal(Integer precoFinal) {
        this.precoFinal = precoFinal;
    }
    
    

    
    
    
}
