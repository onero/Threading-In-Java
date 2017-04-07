/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwiththreads.executor;

import funwiththreads.FunWithThreads;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Executor {

    public static void main(String[] args) {
        Runnable task = () -> {
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
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(task);

        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

}
