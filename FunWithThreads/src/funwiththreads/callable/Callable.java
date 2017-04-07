/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwiththreads.callable;

import funwiththreads.FunWithThreads;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Callable {

    public static void main(String[] args) {
        java.util.concurrent.Callable<Integer> addition = () -> {
            int sum = 0;
            for (int value = 0; value < 10; value++) {
                sum += value;
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
            return sum;
        };
        ExecutorService additionExec = Executors.newSingleThreadExecutor();
        additionExec.submit(addition);
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello ");
        }
        try {
            System.out.println("Result: " + addition.call());
        } catch (Exception ex) {
            Logger.getLogger(FunWithThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
