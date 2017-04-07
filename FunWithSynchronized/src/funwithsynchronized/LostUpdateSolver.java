/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithsynchronized;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LostUpdateSolver {

    private int x;

    //This can be synchronized, due to complex data type!
    private final Object lock;

    private final Semaphore mSemaphore;

    private final AtomicInteger mAtomicX;

    private long startTime = 0;

    private long endTime = 0;

    private long total = 0;

    public LostUpdateSolver() {
        lock = new Object();
        mSemaphore = new Semaphore(1);
        mAtomicX = new AtomicInteger();
    }

    private final Runnable mTask = new Runnable() {
        @Override
        public void run() {
            startTime = System.nanoTime();
            for (int i = 0; i < 100000; i++) {
                //SEMAPHORE!
//                synchronized(this) {
//                    x++;
//                }
//                    mSemaphore.acquire();
//                    x++;
//                    mSemaphore.release();
                mAtomicX.incrementAndGet();
            }
            endTime = System.nanoTime();
            total = endTime - startTime;
//            System.out.println(total);
            System.out.println(TimeUnit.MILLISECONDS.convert(total, TimeUnit.NANOSECONDS));
        }

    };

    public void go() {
        try {
            Thread t1 = new Thread(mTask);
            Thread t2 = new Thread(mTask);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            System.out.println("Sheit");
            System.out.println(ex);
        }

        System.out.println("Result = " + mAtomicX);

    }

}
