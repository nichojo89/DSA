package com.nichols.dsa.concurrency.consusmerproducer;

public class Consumer implements Runnable{
    private StoresQueue queue;

    public Consumer(StoresQueue queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true){
            //Consumer gets the items
            queue.get();
            try {
                Thread.sleep(2000);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
