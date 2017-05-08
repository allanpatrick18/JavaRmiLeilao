/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import interfaces.InterfaceServidor;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author allan
 */
public class Controle extends UnicastRemoteObject implements InterfaceServidor {

    private static final long serialVersionUID = 1L;
    private static InterfaceServidor inface = null;
    private static List<Processo> processos = new ArrayList<>();

    public Controle() throws RemoteException {
    }

    public Controle(int port) throws RemoteException {
        super(port);
    }

    public Controle(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    public void instanciaUmCliente(int id) throws RemoteException {
        processos.add(new Processo(id));
    }

    static Remote getInstance() throws RemoteException {

        if (inface == null) {
            inface = new Controle();
        }
        return inface;
    }

    @Override
    public boolean cadastrarProduto(int idCliente ,String nomeProduto, String precoIncial, String descricao, String tempo) throws RemoteException {
        Processo p = procuraCliente(idCliente);
        if(p!=null){
          p.getListaProduto().add(new Produto(nomeProduto,precoIncial,descricao,tempo));
        }

        return true;
    }
    @Override
    public List<Produto> listarProdutos(int idCliente) throws RemoteException {
       return procuraProdutos(idCliente);
    }

    @Override
    public boolean teste(int idCliente ,String nomeProduto) throws RemoteException {
        System.out.println(idCliente);
        System.out.println(nomeProduto);
        System.out.println("ok'''''''");
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    private Processo procuraCliente(int idCliente){
        for(Processo p : processos){
           if(idCliente==p.getId()){
             return p;
           }
        }    
        return null;
    }
    
    private  List<Produto> procuraProdutos(int idCliente){
        for(Processo p : processos){
           if(idCliente==p.getId()){
             return p.getListaProduto();
           }
        }    
        return null;
    }
    
    

}
