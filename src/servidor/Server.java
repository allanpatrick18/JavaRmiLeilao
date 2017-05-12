/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import cliente.InterfaceCliente;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author allan
 */
public class Server {

    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
       
        Registry registro = LocateRegistry.createRegistry(4370);
        registro.bind("controle", Controle.getInstance());
        
        InterfaceCliente interfaceCliente = (InterfaceCliente) registro.lookup("controle");
                
       
        System.out.println("Servidor do banco iniciado!");

    }

}
