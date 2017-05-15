/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Jessica
 */
public class ImpleCli extends UnicastRemoteObject implements InterfaceCliente{

    public ImpleCli() throws RemoteException {
        super(0);
    }

    public ImpleCli(int port) throws RemoteException {
        super(port);
    }

    public ImpleCli(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public void receberNotificacao(String msg) throws RemoteException {
     
    }
    
    
    
}
