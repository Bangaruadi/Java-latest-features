package com.modernjava.features;

public class Lambda {

    public static void main(String[] args) {
        //Lambda expression is an anonymous function. It's a function without a name and doesn't belong to any class
        //Any interface with a Single Abstract Method is called functional interface, and it can have multiple default and static methods
        //eg:- Runnable , Callable , Comparator , Predicate ,  Function , Supplier , Consumer


        //you cannot declare a local variable in lambda that same name as local variable
        //you cannot modify local variable inside lambda expression this is called effective final
        //

        HelloWorld helloWorld = () -> System.out.println("First time trying lambda");

        IncrementByFiveInterface incrementByFiveInterface = (a) -> a + 5;
        System.out.println(incrementByFiveInterface.incrementByFive(10));

        ConcatinateInterface concatinateInterface = (a, b) -> a + b;
        System.out.println(concatinateInterface.concat("Aditya", " Bharadwaj"));

        //Example of lambda using Runnable
        //Traditional Way
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 1; i < 100; i++) {
                    sum = sum + i;
                }
                System.out.println("Traditional Runnable SUM = " + sum);
            }
        };
        new Thread(runnable).start();

        //Lambda way
        Runnable runnableLambda = () -> {
            int sum = 0;
            for (int i = 1; i < 100; i++) {
                sum = sum + i;
            }
            System.out.println("Lambda Runnable SUM = " + sum);
        };
        new Thread(runnableLambda).start();
    }
}

@FunctionalInterface
interface HelloWorld {
    public void sayHello();
}

@FunctionalInterface
interface IncrementByFiveInterface {
    public int incrementByFive(int a);
}

@FunctionalInterface
interface ConcatinateInterface {
    public String concat(String a, String b);
}

