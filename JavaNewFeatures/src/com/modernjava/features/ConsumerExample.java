package com.modernjava.features;

import java.util.List;
import java.util.function.*;

public class ConsumerExample {

    //Consumer is a functional interface will consumer values and perform some logic on that thats it will not return anything
    public static void main(String[] args) {
        Consumer<String> c = (a) -> System.out.println("first time " + a);
        c.accept("consumer");


        List<Instructor> instructorConsumer = Instructor.getAll();

        //looping through all the instructor and printing out the values of instructor
        Consumer<Instructor> instructorConsumer1 = (s) -> System.out.println(s);
        instructorConsumer.forEach(instructorConsumer1); // in forEach implementation only it will call consumer accept

        //Loop through all the instructor and only print out their name
        System.out.println("---------------");
        Consumer<Instructor> name = (s) -> System.out.print(s.getName() + " ");
        instructorConsumer.forEach(name); // in forEach implementation only it will call consumer accept

        //Loop through all the instructors and print out their names and their courses
        System.out.println("----------------");
        Consumer<Instructor> course = (s1) -> System.out.println(s1.getCourses());
        instructorConsumer.forEach(name.andThen(course)); // in forEach implementation only it will call consumer accept

        //Loop through all the instructors and print out their name if the years of experience is >10
        System.out.println("----------");
        instructorConsumer.forEach(instructor -> {
            if (instructor.yearsOfExperience > 10) {
                instructorConsumer1.accept(instructor);
            }
        });

        //Loop through all the instructors and print out their name and years of experience if years
        //of experience is >5 and not teaches course online
        System.out.println("--------------");
        instructorConsumer.forEach(instructor -> {
            if (instructor.yearsOfExperience > 5 && !instructor.isOnlineCourses()) {
                instructorConsumer1.andThen(name).accept(instructor);
            }
        });

        System.out.println("=========");
        Consumer<Integer> printNumber = n -> System.out.println("Number: " + n);
        Consumer<Integer> doubleNumber = n -> System.out.println("Doubled: " + (n * 2));
        Consumer<Integer> combinedConsumer = printNumber.andThen(doubleNumber);
        combinedConsumer.accept(5);


        //Different type of consumers
        IntConsumer intConsumer = (a) -> System.out.println(a * 10);
        intConsumer.accept(10);

        LongConsumer longConsumer = (a) -> System.out.println(a * 10L);
        longConsumer.accept(10L);

        DoubleConsumer doubleConsumer = (a) -> System.out.println(a * 10);
        doubleConsumer.accept(10.50);

        BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println("x: " + x + " y: " + y);
        biConsumer.accept(2, 4);

        BiConsumer<String, String> biConsumer1 = (instructorName, instructorGender) -> System.out.println("instructorName is :"
                + instructorName + " and instructorGender is: " + instructorGender);
        instructorConsumer.forEach(instructor ->
                biConsumer1.accept(instructor.getName(), instructor.getGender()));
    }
}


