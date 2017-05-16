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

    /**
     *
     * @param idCliente
     * @param nomeProduto
     * @param precoIncial
     * @param descricao
     * @param tempo
     * @return
     * @throws RemoteException
     */
    public boolean cadastrarLeilao(int idCliente, String nomeProduto, Integer precoIncial,
            String descricao, Integer tempo) throws RemoteException;

    /**
     *
     * @param idCliente
     * @param idProduto
     * @param valor
     * @return
     * @throws RemoteException
     */
    public boolean darlance(int idCliente, int idProduto, Integer valor) throws RemoteException;

    /**
     *
     * @param idCliente
     * @param nomeProduto
     * @return
     * @throws RemoteException
     */
    public boolean teste(int idCliente, String nomeProduto) throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    List<Produto> listarProdutos() throws RemoteException;

    /**
     *
     * @param name
     * @param referenciaCliente
     * @param clienteID
     * @throws RemoteException
     */
    public void cadastrarRefCli(String name, InterfaceCliente referenciaCliente, Integer clienteID)
            throws RemoteException;

}
