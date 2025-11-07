package com.modernjava.features;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class SumOfNumbersUsingCallableAndLambda {

    //Callable is a functional interface like runnable but here we can return something or throw checked exceptions

    public static final int[] array = IntStream.range(0,5000).toArray();
    public static final int total = IntStream.range(0,5000).sum();


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable callable = () -> {
          int sum = 0;
          for (int i=0;i<array.length/2;i++){
              sum = sum + array[i];
          }
          return sum;
        };

        Callable callable1 = () -> {
            int sum = 0;
            for (int i=array.length/2;i<array.length;i++){
                sum = sum + array[i];
            }
            return sum;
        };

        // 2 reusable threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<Integer>> taskList = Arrays.asList(callable, callable1);
        List<Future<Integer>> futures = executorService.invokeAll(taskList);

        int sum=0;
        for(Future<Integer> obj : futures){
            sum = sum + obj.get();
        }

        System.out.println("Sum from the Callable is: " + sum);
        System.out.println("Correct sum from InStream is: " + total);
        executorService.shutdown();
    }
}

/*
*  Thread creation manually is so expensive , but executor service or thread pool reuse that
*  centralized life cycle management
*  better integration for error handling
*  Eg:- You yourself create new cook(thread) for every dish creating many cooks slows and uses more kitchen space and hard get dish [result] back cleanly ,Hard to limit run cooks at once and handle errors uniformly
*  But Executor Service [Kitchen manager] is having fixed number of reusable cooks you gave him tasks he assigns the task to available cook and you get a future result
* */
