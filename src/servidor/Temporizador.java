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
 *
 * @author allan
 */
public class Temporizador extends Thread{
    
    private int tempo ;
    private Produto produto;
    private Controle controle;
    
    
    public Temporizador(int tempo, Produto produto, Controle controle) {
       this.tempo=tempo; 
       this.produto= produto;
       this.controle = controle;
    }
    public void run() {
        try {
            System.out.println("Time: "+ tempo); //sout
            
            Thread.sleep(tempo*60000);
            
            System.out.println("Teminou o temporizador!");
            //TODO something after
            try {
                controle.finalizaLeilao(produto);
            } catch (RemoteException ex) {
                Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
                    
         
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    
    
    
    

    
}
