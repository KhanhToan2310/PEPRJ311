/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

/**
 *
 * @author PHONG VU
 */
public class Main {
    public static void main(String[] args) {
        Count1To100 count  = new Count1To100();
        Count200To100 count1 = new Count200To100();
        count.start();
        count1.start();
    }
}
