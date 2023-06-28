package com.nichols.dsa.concurrency;

import java.util.concurrent.Semaphore;

public class FooBar {
    private int  n;
    private final Semaphore fooSemaphore;
    private final Semaphore barSemaphore;

    public FooBar(int n){
        this.n  = n;
        fooSemaphore = new Semaphore(1);
        barSemaphore = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException  {
        for(int i=  0; i <n; i++){
            fooSemaphore.acquire();
            printFoo.run();
            barSemaphore.release();
        }
    }
    public void bar(Runnable printBar)  throws  InterruptedException {
        for(int i  = 0; i  <  n;  i++){
            barSemaphore.acquire();
            printBar.run();
            fooSemaphore.release();
        }
    }
}
