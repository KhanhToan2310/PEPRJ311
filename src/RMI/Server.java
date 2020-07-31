/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author PHONG VU
 */
public class Server {

    public static void main(String[] args) {
        String service = "rmi://localhost:1098/server";
        StoreService server;
        try {
            server = new StoreRMI();
            LocateRegistry.createRegistry(1098);
            Naming.rebind(service, server);
            System.out.println("Service" + service + " is running.");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
