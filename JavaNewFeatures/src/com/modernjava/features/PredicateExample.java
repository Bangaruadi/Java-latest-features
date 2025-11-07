package com.modernjava.features;

import java.util.List;
import java.util.function.*;

public class PredicateExample {

    //Predicate is a functional interface which return true or false

    public static void main(String[] args) {
        //if number is >10 return true other false
        Predicate<Integer> p1 = (i) -> i > 10;
        System.out.println(p1.test(100));

        //i>10 && number is even number (i%2 ==0)
        Predicate<Integer> p2 = (i) -> i % 2 == 0;
        System.out.println(p1.and(p2).test(20));

        //i>10 || number is even number (i%2==0)
        System.out.println(p1.or(p2).test(4));

        //i>10 && i%2 !=0
        System.out.println(p1.and(p2.negate()).test(33));

        //all instructor who teaches online
        Predicate<Instructor> online = (i) -> i.isOnlineCourses();
        //instructor experience is >10 years
        Predicate<Instructor> expirence = (i) -> i.getYearsOfExperience() >10;

        List<Instructor> instructors = Instructor.getAll();
        instructors.forEach(instructor -> {
            if (online.test(instructor)){
                System.out.println(instructor);
            }
        });

        // is instructor teaches online and exprience is > 10 years
        System.out.println("---------------------");
        instructors.forEach(instructor ->  {
            if(online.and(expirence).test(instructor)){
                System.out.println(instructor);
            }
        });

        IntPredicate intPredicate = (i) -> i>100;
        System.out.println(intPredicate.test(100));

        LongPredicate longPredicate = (i) -> i>100L;
        System.out.println(longPredicate.test(1111111111111111111L));

        DoublePredicate p3 = (i) -> i<100.25;
        DoublePredicate p4 = (i) -> i>100.10;
        System.out.println(p3.and(p4).test(100.15));


        List<Instructor> instructor = Instructor.getAll();
        BiPredicate<Boolean, Integer> p5 = (onlinee, experience) -> onlinee==true && experience>10;

        //Biconsumer print name and courses
        BiConsumer<String, List<String>> biConsumer = (name, courses) ->
                System.out.println("name is: " + name + " courses : " + courses);

        instructors.forEach(instructor1 -> {
            if(p5.test(instructor1.isOnlineCourses(), instructor1.getYearsOfExperience()))
                biConsumer.accept(instructor1.getName(), instructor1.getCourses());
        });
    }
}
