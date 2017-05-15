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
    private static List<Processo> processos = new ArrayList<>();
    public static List<Produto> produtosLeilao = new ArrayList<>();
    private Integer incrIDProd = 0; //produto ID
    private Integer incrIDProc = 0; //processo ID
    

    public Controle(InterfaceCliente referenciaCliente) throws RemoteException {
        
        processos.add(new Processo(referenciaCliente, incrIDProc ));
        incrIDProc++;
    }

    public Controle(int port) throws RemoteException {
        super(port);
    }

    public Controle(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    
    


    static Remote getInstance(InterfaceCliente referenciaCliente) throws RemoteException {

        if (inface == null) {
            inface = new Controle(referenciaCliente);
        }
        return inface;
    }

    @Override
    public boolean cadastrarLeilao(int idCliente, String nomeProduto, Integer precoIncial,
            String descricao, Integer tempo) throws RemoteException {
        Processo p = procuraCliente(idCliente);
        if (p != null) {
            incrIDProd++;
            Produto produto = new Produto(incrIDProd, nomeProduto,descricao, precoIncial, tempo);
            p.getListaProduto().add(produto);
            produtosLeilao.add(produto);
       
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
    public boolean darlance(int idProcesso, int idProduto, Integer valor) throws RemoteException {
        Leilao leilao = procuraProdutoLeiloando(idProduto);
        if (leilao != null) {
            Integer valorAtual = Integer.parseInt(leilao.getProduto().getPrecoInicial());
            if (valorAtual < valor) {
               leilao.getLancadores().add(procuraCliente(idProcesso));
               leilao.getProduto().setPrecoInicial(valor.toString());
              
               
            }

        }
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

    private Leilao procuraProdutoLeiloando(int idProduto) {
        for (Leilao leilao : produtosLeilao) {
            for (Processo processo : leilao.getLancadores()) {
                for (Produto produto : processo.getListaProduto()) {
                    if (idProduto == processo.getId()) {
                        return leilao;
                    }
                }
            }
        }
        return null;
    }

    private void inicailizaLeilao() {

    }

      /**
     * Mapeia o cliente e sua respectiva referência
     * @param name
     * @param cli
     * @return (status da realização do mapeamento)
     */

    public boolean cadastrarRefCli(String name, InterfaceCliente cli) {
        Server server = new Server();
        return server.MapActiveClients(name, cli);
    }

      
    
}
