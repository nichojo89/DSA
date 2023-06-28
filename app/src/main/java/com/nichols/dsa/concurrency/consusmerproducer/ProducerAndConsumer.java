package com.nichols.dsa.concurrency.consusmerproducer;

public class ProducerAndConsumer {
    public static void main(String[] args){
        StoresQueue queue = new StoresQueue();

        //Create runnables
        Producer producer  = new Producer(queue);
        Consumer consumer  = new Consumer(queue);

        //Pass them to threads
        Thread producerThread =  new Thread(producer);
        Thread consumerThread =  new Thread(consumer);

        //run threads
        producerThread.start();
        consumerThread.start();
    }
}
