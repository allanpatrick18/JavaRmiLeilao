/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Classe Temporizador onde será contato o tempo do leilão e tratado quando este finaliza
 * @author allan
 */
public class Temporizador extends Thread{
    
    private int tempo ;                                      //tempo do leilão
    private Produto produto;                                // produto que será leiloado
    private Controle controle;                              // Instância da classe Controle
    
    /**
     * Construtor da classe Temporizador
     * @param tempo
     * @param produto
     * @param controle
     */
    public Temporizador(int tempo, Produto produto, Controle controle) {
       this.tempo=tempo; 
       this.produto= produto;
       this.controle = controle;
    }
    public void run() {
        try {
            System.out.println("Time: "+ tempo);            //sout
            
            Thread.sleep(tempo*60000);                      //Tempo vezes segundos
                                                
            System.out.println("Teminou o temporizador!");  //Finaliza controle          
            try {
                controle.finalizaLeilao(produto);
            } catch (RemoteException ex) {
                Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
            }               
        } catch (InterruptedException ex) {
            Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Retorna o produto leiloando
     * @return
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Seta o produto leiloando
     * @param produto
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * Retorna o tempo do leilão corrente
     * @return
     */
    public int getTempo() {
        return tempo;
    }

    /**
     * Altera o tempo do leilão corrente
     * @param tempo
     */
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    
    
    
    

    
}
