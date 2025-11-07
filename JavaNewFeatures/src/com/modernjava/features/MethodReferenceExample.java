package com.modernjava.features;

import java.util.function.DoubleConsumer;
import java.util.function.Function;

public class MethodReferenceExample {

    //Method reference is a shorthand notation of a lambda expression to call a method
    /*
    *    class::staticMethod  //reference to a static method
    *    Object::instanceMethod //reference to an instance method
    *    class::new            //Reference to a constructor
    *
    * */
    public static void main(String[] args) {
        Function<Integer,Double> sqrts = Math::sqrt;
        System.out.println(sqrts.apply(10));
    }
}
