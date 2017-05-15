/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import servidor.Produto;

/**
 *
 * @author allan
 */
public interface InterfaceServidor extends Remote {

    public boolean cadastrarLeilao(int idCliente, String nomeProduto, Integer precoIncial,
            String descricao, Integer tempo) throws RemoteException;

    boolean darlance(int idCliente, int idProduto, Integer valor) throws RemoteException;

    boolean teste(int idCliente, String nomeProduto) throws RemoteException;

    List<Produto> listarProdutos(int idCliente) throws RemoteException;

    public void cadastrarRefCli(String name, InterfaceCliente referenciaCliente, Integer clienteID)
            throws RemoteException;

}
