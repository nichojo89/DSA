package com.nichols.dsa.concurrency.consusmerproducer;

import java.util.concurrent.Semaphore;

public class StoresQueue {

    private int item;

    private final Semaphore semaphoreConsumer = new Semaphore(0);
    private final Semaphore semaphoreProducer = new Semaphore(1);
    ///lock a consumer, unlock  a producer
    public void get(){
        try {

            semaphoreConsumer.acquire();
        } catch (Exception e){
            System.out.println("InterruptedException caught");
        }
        semaphoreProducer.release();
    }

    ///lock a producer, unlock a consumer
    public void put(int item){
        try  {
            semaphoreProducer.acquire();
        } catch (Exception  e){
            System.out.println("InterruptedException caught");
        }
        this.item = item;
        StringBuilder msg  =  new StringBuilder();
        msg.append("Producer added a ")
                        .append(item);
        System.out.println(msg);
        semaphoreConsumer.release();
    }
}
