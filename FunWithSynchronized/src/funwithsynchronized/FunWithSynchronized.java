/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsynchronized;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Adamino
 */
public class FunWithSynchronized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
//        LostUpdateSolver solver = new LostUpdateSolver();
//        solver.go();
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Thread t1 = new Thread(new NumberProducer(queue));
        Thread t2 = new Thread(new NumberProducer(queue));
        Thread t3 = new Thread(new NumberConsumer(queue));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        System.out.println("Terminating first producer");
        t2.join();
        System.out.println("Terminating second producer");
        t3.join();
        System.out.println("Terminating consumer");

        System.out.println("Main Done");
    }

}
