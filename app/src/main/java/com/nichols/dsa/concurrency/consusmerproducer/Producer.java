package com.nichols.dsa.concurrency.consusmerproducer;

import java.util.Random;

public class Producer implements Runnable{
    private StoresQueue queue;

    public Producer(StoresQueue queue){
        this.queue  = queue;
    }
    @Override
    public void run() {
        while (true){
            Random rdm =  new Random();
            int data =  rdm.nextInt(100);
            //Producer  adds item to store queue
            queue.put(data);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
