/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import java.util.Scanner;

/**
 *
 * @author PHONG VU
 */
public class Count200To100 extends Thread {
    public static Scanner sc = new Scanner(System.in);

    @Override
    public void run() {
        int count = 200;
        String a = " ";
        do {
            for (int i = count; i >= 100; i--) {
                System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.err.println("Error!");
                }
            }
            System.out.println("Do you want to continue?(Y/N): ");
            a = sc.nextLine();
        } while (a.equals("Y"));
    }
}
