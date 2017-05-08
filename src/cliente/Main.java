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
import java.util.Random;

public class Main {
    
   public static InterfaceServidor  controle = null;
   public static Integer id;
   
    public static void criaIdenficacao(InterfaceServidor gerente) throws RemoteException {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String[] idString= name.split("@");
        id = Integer.parseInt(idString[0].toString());
        gerente.instanciaUmCliente(id);

    }

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

        Registry registro = LocateRegistry.getRegistry(4370);
        controle = (InterfaceServidor) registro.lookup("controle");
        criaIdenficacao(controle);
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicialMenu().setVisible(true);
            }
        });
    }

}
