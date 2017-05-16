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
 * Classe Server onde contém as inicializações do servidor e a inserção de sua 
 * referência no serviço de nomes
 * @author allan
 */
public class Server {

    /**
     * Construtor vazio da classe Server
     */
    public Server() {
    }

    /**
     * Método principal que inicializa o servidor e colocar sua referência no
     * serviço de nomes
     * @param args
     * @throws RemoteException
     * @throws MalformedURLException
     * @throws AlreadyBoundException
     * @throws NotBoundException
     */
    public static void main(String[] args) throws RemoteException, 
            MalformedURLException, AlreadyBoundException, NotBoundException {
      
      
      try {
         //banco do nomes do seu registro
        Registry registry = LocateRegistry.createRegistry(4370);
        //associa a interface ao seu nome
        registry.rebind("controle", Controle.getInstance());
        //Inicializa o servidor
        System.out.println("Servidor do banco iniciado!");
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
  
}
