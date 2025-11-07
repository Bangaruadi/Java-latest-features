package com.modernjava.features;

import java.util.function.Supplier;

public class SupplierExample {

    //Supplier is a functional interface which return some value
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> (int) (Math.random() * 1000);
        System.out.println(supplier.get());
        System.out.println(supplier.get());
    }
}
