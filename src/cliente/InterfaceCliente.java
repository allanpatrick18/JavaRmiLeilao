/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import interfaces.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import servidor.Produto;

/**
 *
 * @author allan
 */
public interface InterfaceCliente extends Remote {
    
  public void notificaCliente()throws RemoteException;
    
}
