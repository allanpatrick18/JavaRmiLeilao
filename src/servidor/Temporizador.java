/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author allan
 */
public class Temporizador extends Thread{
    
    private int tempo =1;
    private Produto produto;
    
    
    
    public Temporizador(int tempo, Produto produto) {
       this.tempo=tempo; 
       this.produto= produto;
    }
    public void run() {
        try {
            Thread.sleep(tempo*1000);
            //TODO something after
            
            if(!Controle.listaLeiloesAtivos.isEmpty()){
                if(produto.getUltimoLancador()!= null)
                {
                   
                    
                    
                    
                }else{
                    System.out.println("Erro : Nenhum apostador no produto!");
                
                }   
            
            }else{
                System.out.println("Erro : Lista de leiloes ativos vazia!");
            
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
