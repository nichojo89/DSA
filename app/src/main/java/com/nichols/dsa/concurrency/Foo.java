package com.nichols.dsa.concurrency;

import java.util.concurrent.Semaphore;

class Foo {
    private Semaphore sem = new Semaphore(3);

    public Foo() {
    }

    public static void main(String[] args) {

                
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        sem.acquire();
        printFirst.run();
        sem.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        sem.acquire();
        printSecond.run();
        sem.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        sem.acquire();
        printThird.run();
        sem.release();
    }
}