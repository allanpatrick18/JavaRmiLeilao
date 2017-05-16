package cliente;

import InterfaceGrafica.AuctionRegister;
import InterfaceGrafica.BidRegister;

import InterfaceGrafica.ProductList;
import interfaces.InterfaceServidor;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import java.lang.management.ManagementFactory;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.util.Random;
import javax.swing.JOptionPane;
import servidor.Controle;
import interfaces.InterfaceCliente;
import java.util.ArrayList;
import java.util.List;
import servidor.Produto;

public class Main {
    
   public static InterfaceServidor  controle = null;
   public static Integer id;
   public static String nome;
   public static ProductList productList;
   public static List<Produto> list = new ArrayList<>();
   
 
    public static void criaIdenficacao(InterfaceServidor servidor, String nome) throws RemoteException, MalformedURLException, AlreadyBoundException {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String[] idString= name.split("@");
        id = Integer.parseInt(idString[0]);
        servidor.cadastrarRefCli(nome,new ClienteImpl(), id);

    }

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, AlreadyBoundException {

        
        Registry registro = LocateRegistry.getRegistry(4370);
        controle = (InterfaceServidor) registro.lookup("controle");
        
        nome = JOptionPane.showInputDialog("Para realizar seu primeiro acesso, cadastre seu nome:");
        
        criaIdenficacao(controle, nome);
       
        
        productList = new ProductList();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                 productList.setVisible(true);
            }
        });
        
  
        
        
    }



}
