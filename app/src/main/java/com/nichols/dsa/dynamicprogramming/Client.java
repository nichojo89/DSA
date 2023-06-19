package com.nichols.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //Get n from main input
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        //Single thread pool
        ExecutorService executor = Executors.newSingleThreadExecutor();

        ArrayCreator arrayCreator = new ArrayCreator(n);
        //call callable
        Future<ArrayList<Integer>> future = executor.submit(arrayCreator);

        //blocking call, is  there a non-blocking  way to do this?
        ArrayList<Integer> result = future.get();
        System.out.println(result);

        executor.shutdown();
    }
}
class ArrayCreator implements Callable<ArrayList<Integer>> {
    private int n;
    ArrayCreator(int input){
        this.n = input;
    }


    //Returns ArrayList of 1..n
    @Override
    public ArrayList<Integer> call() throws Exception {
        ArrayList<Integer> arrayList  = new ArrayList<>();
        for(int i  = 1; i <=n;i++){
            arrayList.add(i);
        }
        return arrayList;
    }
}
