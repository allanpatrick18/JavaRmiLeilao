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
import java.util.Random;
import servidor.Controle;

public class Main {
    
   public static InterfaceServidor  controle = null;
   public static Integer id;
   
    public static void criaIdenficacao(InterfaceServidor servidor) throws RemoteException, MalformedURLException, AlreadyBoundException {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String[] idString= name.split("@");
        id = Integer.parseInt(idString[0]);
        servidor.instanciaUmCliente(id);

    }

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, AlreadyBoundException {

        Registry registro = LocateRegistry.getRegistry(4370);
        controle = (InterfaceServidor) registro.lookup("controle");
        criaIdenficacao(controle);
       
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InicialMenu().setVisible(true);
            }
        });
        
  
        
        
    }

}
