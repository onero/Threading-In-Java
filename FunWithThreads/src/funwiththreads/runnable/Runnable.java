/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwiththreads.runnable;

import funwiththreads.FunWithThreads;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Runnable {

    public static void main(String[] args) {
        java.lang.Runnable task = () -> {
            try {
                String threadName = Thread.currentThread().getName();

                System.out.println("Hvem kommer først " + threadName);

                TimeUnit.SECONDS.sleep(1);

                System.out.println("Når tørsten er størst " + threadName);

                TimeUnit.SECONDS.sleep(1);

                System.out.println("Bonanza! " + threadName);
            } catch (InterruptedException ex) {
                Logger.getLogger(FunWithThreads.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        new Thread(task).start();
    }

}
