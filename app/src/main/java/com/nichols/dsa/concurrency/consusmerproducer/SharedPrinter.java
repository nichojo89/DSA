package com.nichols.dsa.concurrency.consusmerproducer;

import java.util.concurrent.Semaphore;


public class SharedPrinter {
    public static void main(String[]args){
        SharedPrinter sp = new SharedPrinter();

        int max = 10;
        Thread odd = new Thread(new Odd(max,sp),"Odd");
        Thread even = new Thread(new Even(max,sp), "Even");
        odd.start();
        even.start();
    }
    //add semaphores
    private Semaphore semEven = new Semaphore(0);
    private Semaphore semOdd = new Semaphore(1);

    void printEven(int num) {
        try {
            semEven.acquire();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println(num);
        semOdd.release();
    }

    void printOdd(int num){
        try {
            semOdd.acquire();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println(num);
        semEven.release();
    }
}

class Even implements Runnable {
    private SharedPrinter sp;
    private int max;

    Even(int max, SharedPrinter  sp){
        this.max = max;
        this.sp = sp;
    }

    @Override
    public void run() {
        for(int i = 02; i <= max; i = i+2){
            sp.printEven(i);
        }
    }
}

class Odd implements Runnable{
    Odd(int max, SharedPrinter sp){
        this.max = max;
        this.sp =  sp;
    }
    private SharedPrinter sp;
    private  int max;

    @Override
    public void run() {
        for(int i = 1; i <= max; i = i + 2){
            sp.printOdd(i);
        }
    }
}
