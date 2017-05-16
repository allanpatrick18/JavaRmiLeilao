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

    /**
     *
     * @throws RemoteException
     */
    public ClienteImpl() throws RemoteException {
        super(0);
    }

    /**
     *
     * @param port
     * @throws RemoteException
     */
    public ClienteImpl(int port) throws RemoteException {
        super(port);
    }

    /**
     *
     * @param port
     * @param csf
     * @param ssf
     * @throws RemoteException
     */
    public ClienteImpl(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    /**
     *
     * @param msg
     * @throws RemoteException
     */
    @Override
    public void receberNotificacao(String msg) throws RemoteException {
       productList.notificaCliente(msg);
       productList.atualiza();
    }
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    public Remote refInterface() throws RemoteException {
      return new ClienteImpl();
    }
    
    
    
}
