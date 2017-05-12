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

    public Temporizador(int tempo) {
       this.tempo=tempo; 
    }
    public void run() {
        try {
            Thread.sleep(tempo*1000);
            //TODO something after
        } catch (InterruptedException ex) {
            Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    
    
    
    

    
}
