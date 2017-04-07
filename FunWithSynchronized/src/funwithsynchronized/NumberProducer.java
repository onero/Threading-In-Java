/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsynchronized;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NumberProducer implements Runnable {

    private final BlockingQueue<Integer> mQueue;

    public NumberProducer(BlockingQueue<Integer> queue) {
        mQueue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                mQueue.put(i);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(NumberProducer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        try {
            mQueue.put(-1);
        } catch (InterruptedException ex) {
            Logger.getLogger(NumberProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
