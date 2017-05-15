/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import interfaces.InterfaceCliente;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author allan
 */
public class Server {

    public Server() {
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException, NotBoundException {
       
        Registry registro = LocateRegistry.createRegistry(4370);
       InterfaceCliente interfaceCliente = (InterfaceCliente) registro.lookup("cliente");
      
        registro.bind("controle", Controle.getInstance(interfaceCliente));
        
     
        System.out.println("Servidor do banco iniciado!");

    }
    
  
}
