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
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author allan
 */
public class Controle extends UnicastRemoteObject implements InterfaceServidor {

    private static final long serialVersionUID = 1L;
    private static InterfaceServidor inface = null;
    private static List<Processo> processos = new ArrayList<>();
    private static List<Leilao> produtosLeilao = new ArrayList<>();

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
    public boolean cadastrarProduto(int idCliente, String nomeProduto, String precoIncial, String descricao, String tempo) throws RemoteException {
        Processo p = procuraCliente(idCliente);
        if (p != null) {
            p.getListaProduto().add(new Produto(nomeProduto, precoIncial, descricao, tempo));
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
    public boolean leioloar(int idProcesso, int idProduto) throws RemoteException {
        Produto produto = procuraProdutos(idProduto);
        if (produto != null) {
            int id = produtosLeilao.size() + 1;
            Leilao leilao = new Leilao();
            leilao.setId(id);
            leilao.setProceso(procuraCliente(idProcesso));
            leilao.setProduto(produto);
            produtosLeilao.add(leilao);
            return true;
        }
        return false;

    }

    @Override
    public boolean darlance(int idCliente, int idProduto, double valor) throws RemoteException {
        
        
        
      return false;
    }
    
    

    private Processo procuraCliente(int idCliente) {
        for (Processo p : processos) {
            if (idCliente == p.getId()) {
                return p;
            }
        }
        return null;
    }

    private List<Produto> procuraProdutosdeUmCliente(int idCliente) {
        for (Processo p : processos) {
            if (idCliente == p.getId()) {
                return p.getListaProduto();
            }
        }
        return null;
    }

    private Produto procuraProdutos(int idProduto) {
        for (Processo p : processos) {
            for (Produto prod : p.getListaProduto()) {
                if (idProduto == prod.getId()) {
                    return prod;
                }
            }
        }
        return null;
    }
    private Produto procuraProdutoLeiloando(int idProduto) {
//        for (Leilao leilao : produtosLeilao) {
//            for (Produto prod : leilao.getProceso()) {
//                if (idProduto == prod.getId()) {
//                    return prod;
//                }
//            }
//        }
        return null;
    }

    private void inicailizaLeilao() {
        
    }

}
