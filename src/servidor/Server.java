/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import static cliente.Main.controle;
import interfaces.InterfaceCliente;
import interfaces.InterfaceServidor;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author allan
 */
public class Server {

    public Server() {
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException, NotBoundException {
      
      
      try {
         //banco do nomes do seu registro
        Registry registry = LocateRegistry.createRegistry(4370);
        //associa a interface ao seu nome
        registry.rebind("controle", Controle.getInstance());
        
        System.out.println("Servidor do banco iniciado!");
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
  
}
