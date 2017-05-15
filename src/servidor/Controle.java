/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import interfaces.InterfaceCliente;
import interfaces.InterfaceServidor;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author allan
 */
public class Controle extends UnicastRemoteObject implements InterfaceServidor {

    private static final long serialVersionUID = 1L;
    private static InterfaceServidor inface = null;
    private static List<Clientes> listaClientesAtivos = new ArrayList<>();
    public static List<Produto> listaProdutosDesteCliente = new ArrayList<>();
    private static List<Leilao> listaLeiloesAtivos = new ArrayList<>(); 
    private Integer incrIDProd = 0; //produto ID
 //   private Integer incrIDProc = 0; //processo ID
    

    public Controle() throws RemoteException {
     
    }

    public void cadastrarRefCli(String name, InterfaceCliente referenciaCliente, Integer clienteID) {
         listaClientesAtivos.add(new Clientes(referenciaCliente, clienteID, name ));
      
  
    }


    public Controle(int port) throws RemoteException {
        super(port);
    }

    public Controle(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    
    


    static Remote getInstance() throws RemoteException {

        if (inface == null) {
            inface = new Controle();
        }
        return inface;
    }

    @Override
    public boolean cadastrarLeilao(int idCliente, String nomeProduto, Integer precoIncial,
            String descricao, Integer tempo) throws RemoteException {
        Clientes p = procuraCliente(idCliente);
        if (p != null) {
            incrIDProd++;
            Produto produto = new Produto(incrIDProd, nomeProduto,descricao, precoIncial, tempo);
            p.getListaProduto().add(produto);
            listaProdutosDesteCliente.add(produto);
       
               Temporizador temporizador = new Temporizador(tempo, produto);
               Thread  thread= new Thread(temporizador);
     
               thread.start();
        }      

        return true;
    }
    
    
    

    @Override
    public List<Produto> listarProdutos(int idCliente) throws RemoteException {
        return procuraProdutosdeUmCliente(idCliente);
    }

    @Override
    public boolean teste(int idCliente, String nomeProduto) throws RemoteException {
        System.out.println(idCliente);
        System.out.println(nomeProduto);
        return true;
    }



    @Override
    public boolean darlance(int idCliente, int idProduto, Integer valor) throws RemoteException {
       return true;
    }

    private Clientes procuraCliente(int idCliente) {
        for (Clientes p : listaClientesAtivos) {
            if (idCliente == p.getId()) {
                return p;
            }
        }
        return null;
    }

    private List<Produto> procuraProdutosdeUmCliente(int idCliente) {
        for (Clientes p : listaClientesAtivos) {
            if (idCliente == p.getId()) {
                return p.getListaProduto();
            }
        }
        return null;
    }

    private Produto procuraProdutos(int idProduto) {
        for (Clientes p : listaClientesAtivos) {
            for (Produto prod : p.getListaProduto()) {
                if (idProduto == prod.getId()) {
                    return prod;
                }
            }
        }
        return null;
    }

   
    private void inicailizaLeilao() {

    }

    

      
    
}
