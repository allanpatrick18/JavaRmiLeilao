/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import InterfaceGrafica.ProductList;
import static cliente.Main.productList;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

import interfaces.InterfaceCliente;
import java.rmi.Remote;

/**
 *
 * @author Jessica
 */
public class ClienteImpl extends UnicastRemoteObject implements InterfaceCliente{

    
    
    
    public ClienteImpl() throws RemoteException {
        super(0);
    }

    public ClienteImpl(int port) throws RemoteException {
        super(port);
    }

    public ClienteImpl(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public void receberNotificacao(String msg) throws RemoteException {
       System.out.println("-------sssssssssssss-----sda");
       productList.notificaCliente(msg);
    }
    
    public Remote refInterface() throws RemoteException {
      return new ClienteImpl();
    }
    
    
    
}
