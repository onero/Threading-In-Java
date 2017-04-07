/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsynchronized;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NumberConsumer extends Thread {

    private final BlockingQueue<Integer> mQueue;

    private boolean running;

    public NumberConsumer(BlockingQueue<Integer> queue) {
        mQueue = queue;
        running = true;
    }

    @Override
    public void run() {
        int test;
        while (running) {
            if (mQueue.peek() != null) {
                if (mQueue.peek() != -1) {
                    test = mQueue.poll();
                    System.out.println(test);
                } else {
                    try {
                        mQueue.put(-1);
                        running = false;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(NumberConsumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
//        mQueue.stream().forEach(i -> {
//            if (i != -1) {
//                try {
//                    mQueue.poll(1000, TimeUnit.MILLISECONDS);
//                    System.out.println(i);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(NumberConsumer.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } else {
////                try {
////                    mQueue.put(i);
////                } catch (InterruptedException ex) {
////                    Logger.getLogger(NumberConsumer.class.getName()).log(Level.SEVERE, null, ex);
////                } catch (Throwable ex) {
////                    Logger.getLogger(NumberConsumer.class.getName()).log(Level.SEVERE, null, ex);
////                }
//            }
//        });
    }

}
