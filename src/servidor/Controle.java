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
    private static List<Integer> leiloes = new ArrayList<>();
    private static List<Clientes> listaClientesAtivos = new ArrayList<>();

    /**
     *
     */
    public static List<Produto> listaLeiloesAtivos = new ArrayList<>(); //mesma coisa que produtos

    /**
     *
     */
    public static List<Produto> listaLeiloesInativos = new ArrayList<>();
    //   private static List<Leilao> listaLeiloesAtivos = new ArrayList<>(); 
    private Integer incrIDProd = 0; //produto ID
    //   private Integer incrIDProc = 0; //processo ID

    /**
     *
     * @throws RemoteException
     */
    public Controle() throws RemoteException {

    }

    /**
     *
     * @param name
     * @param referenciaCliente
     * @param clienteID
     */
    public void cadastrarRefCli(String name, InterfaceCliente referenciaCliente, Integer clienteID) {
        listaClientesAtivos.add(new Clientes(referenciaCliente, clienteID, name));

    }

    /**
     *
     * @param port
     * @throws RemoteException
     */
    public Controle(int port) throws RemoteException {
        super(port);
    }

    /**
     *
     * @param port
     * @param csf
     * @param ssf
     * @throws RemoteException
     */
    public Controle(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    public static Remote getInstance() throws RemoteException {

        if (inface == null) {
            inface = new Controle();
        }
        return inface;
    }

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
    @Override
    public boolean cadastrarLeilao(int idCliente, String nomeProduto, Integer precoIncial,
            String descricao, Integer tempo) throws RemoteException {

        Clientes p = procuraCliente(idCliente);
        if (p != null) {
            incrIDProd++;
            Produto produto = new Produto(incrIDProd, nomeProduto, descricao, precoIncial, tempo, p);
//          p.getListaProduto().add(produto);

            listaLeiloesAtivos.add(produto);
            Temporizador temporizador = new Temporizador(tempo, produto, this);
            Thread thread = new Thread(temporizador);
            thread.start();
        }

        return true;
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public List<Produto> listarProdutos() throws RemoteException {
        return listaLeiloesAtivos;
    }

    /**
     *
     * @param idCliente
     * @param nomeProduto
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean teste(int idCliente, String nomeProduto) throws RemoteException {
        System.out.println(idCliente);
        System.out.println(nomeProduto);
        return true;
    }

    /**
     *
     * @param idCliente
     * @param idProduto
     * @param valor
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean darlance(int idCliente, int idProduto, Integer valor) throws RemoteException {

        Produto prod;
        prod = procuraProdutos(idProduto);
        Integer indicator = 0;
        Clientes cliInteressado;
        cliInteressado = procuraCliente(idCliente);

        if (idCliente == prod.getLeiloador().getId()) {
            cliInteressado.getReferenciaCliente().receberNotificacao("ERROR - Voce não pode comprar seu proprio produto");
            return false;
        }

        if (listaLeiloesAtivos.contains(prod)) {
            for (Clientes cli : prod.getProcessoInteressados()) {
                if (cli.getId() == idCliente) {

                    indicator = 1;

                    break;
                }

                indicator = 0;
            }

            //Notificação de  clinetes
            if (prod.getProcessoInteressados().size() > 0) {
                for (Clientes cliente : prod.getProcessoInteressados()) {
                    cliente.getReferenciaCliente().receberNotificacao(" Outro cliente deu lance no produto " + prod.getName());
                }
          
            }
            
            prod.getLeiloador().getReferenciaCliente().receberNotificacao(" Outro cliente deu lance no produto " + prod.getName());

            //Caso o cara nao esta na lista ainda
            if (indicator == 0) {
                if (prod.getPrecoFinal() < valor) {
                    prod.setPrecoFinal(valor);
                    prod.getProcessoInteressados().add(cliInteressado);
                    prod.setUltimoLancador(cliInteressado);
                } else {
                    cliInteressado.getReferenciaCliente().receberNotificacao("ERROR - O valor mencionado é inferior ao lance atual!");
                }

            } else {
                //Caso o cara já esta na lista
                if (prod.getPrecoFinal() < valor) {
                    prod.setPrecoFinal(valor);
                    prod.setUltimoLancador(cliInteressado);
                } else {
                    cliInteressado.getReferenciaCliente().receberNotificacao("ERROR - O valor mencionado é inferior ao lance atual!");
                }

            }

            //replace into the list refresh produto
            int indice = listaLeiloesAtivos.indexOf(prod);
            listaLeiloesAtivos.set(indice, prod);
        } else {
            //Caso o produto nao esteja leiloando;
            cliInteressado.getReferenciaCliente().receberNotificacao("ERROR - Este produto não está sendo leiloado!");

            return false;

        }
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

//    private List<Produto> procuraProdutosdeUmCliente(int idCliente) {
//        for (Clientes p : listaClientesAtivos) {
//            if (idCliente == p.getId()) {
//                return p.getListaProduto();
//            }
//        }
//        return null;
//    }
    private Produto procuraProdutos(int idProduto) {
        for (Produto p : listaLeiloesAtivos) {

            if (idProduto == p.getId()) {
                return p;
            }

        }
        return null;
    }

    /**
     *
     * @param produto
     * @throws RemoteException
     */
    synchronized public void finalizaLeilao(Produto produto) throws RemoteException {
        if (produto.getUltimoLancador() == null) {
            produto.getLeiloador().getReferenciaCliente().receberNotificacao("O leilao do produto " + produto.getName() + "foi encerrado e ninguém se interessou pelo produto.");

        } else {
            produto.getLeiloador().getReferenciaCliente().receberNotificacao("Voce leilou o produto " + produto.getName()
                    + " para a pessoa " + produto.getUltimoLancador().getNome() + " \n no valor de " + produto.getPrecoFinal() + " reais.");
            for (Clientes cli : produto.getProcessoInteressados()) {
                cli.getReferenciaCliente().receberNotificacao("O cliente "
                        + produto.getUltimoLancador().getNome() + " venceu o leilão do produto "
                        + produto.getName() + " pelo valor negociado de " + produto.getPrecoFinal() + " reais.");
            }

            produto.setLeiloador(produto.getUltimoLancador());
            produto.setPrecoInicial(produto.getPrecoFinal());
            produto.setUltimoLancador(new Clientes());
            produto.setProcessoInteressados(new ArrayList<>());

        }
        Controle.listaLeiloesInativos.add(produto);
        Controle.listaLeiloesAtivos.remove(produto);

    }

}
