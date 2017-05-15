package cliente;

import InterfaceGrafica.AuctionRegister;
import InterfaceGrafica.BidRegister;
import InterfaceGrafica.InicialMenu;
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

public class Main {
    
   public static InterfaceServidor  controle = null;
   public static Integer id;
   
    public static void criaIdenficacao(InterfaceServidor servidor, InterfaceCliente impleCli, String nome) throws RemoteException, MalformedURLException, AlreadyBoundException {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String[] idString= name.split("@");
        id = Integer.parseInt(idString[0]);
        servidor.cadastrarRefCli(nome, impleCli, id);

    }

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, AlreadyBoundException {

        
        Registry registro = LocateRegistry.getRegistry(4370);
        controle = (InterfaceServidor) registro.lookup("controle");
        
        String nome = JOptionPane.showInputDialog("Para realizar seu primeiro acesso, cadastre seu nome:");
        
        criaIdenficacao(controle,new ImpleCli(), nome);
       
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InicialMenu().setVisible(true);
            }
        });
        
  
        
        
    }

}
