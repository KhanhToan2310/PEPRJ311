/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import Model.Store;
import Model.StoreDB;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PHONG VU
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String serviceName = "rmi://localhost:1098/server";
        StoreService stub = null;
        ArrayList<Store> list = new ArrayList<>();
        try {
            stub = (StoreService) Naming.lookup(serviceName);
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
        }
        try {
            StoreRMI sdb = new StoreRMI();
            System.out.println("Enter number want to search: ");
            String phone = sc.nextLine();
            list = stub.searchByPhone(phone);
            for (Store s : list) {
                System.out.println(s.getStore_ID());
                System.out.println(s.getStore_Name());
                System.out.println(s.getAddress());
                System.out.println(s.getPhone());
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
