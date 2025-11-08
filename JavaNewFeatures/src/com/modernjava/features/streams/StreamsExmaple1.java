package com.modernjava.features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExmaple1 {

    public static void main(String[] args) {
        //Stream.of() to create a stream from similar type of data
        //Stream.iterate generate infinite sequential ordered stream by iteration

        /*
        * 3 types of streams
        * IntStream
        * LongStream
        * DoubleStream
        *
        * */
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream();
        //Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7);


        Stream<Integer> limit = Stream.iterate(0, i -> i + 2).limit(20);
        limit.forEach(System.out::println);

        //Intstream
        IntStream numbers = IntStream.of(1,2,3,4,5);
        numbers.forEach(System.out::println);
        numbers = IntStream.range(1,5);
        numbers.forEach(System.out::println);
        numbers = IntStream.rangeClosed(1,5);
        numbers.forEach(System.out::println);

        //LongStream , DoubleStream both are same as above


        //Numeric Stream aggregate functions "sum() , max() , min() , average()"
        int sum = IntStream.of(1,2,3,4,5).sum();

        // above example same for all 4 functions


        //Boxing and UnBoxing
        System.out.println("Boxing and UnBoxing");
        List<Integer> boxingNumbers;

        IntStream numStream = IntStream.rangeClosed(0,5); //primitive int stream
        boxingNumbers = numStream.boxed().toList();
        boxingNumbers.forEach(System.out::println);


        //mapToInt , mapToLong , mapTODouble
        boxingNumbers.stream().mapToInt(Integer::intValue).forEach(System.out::println);


    }
}
