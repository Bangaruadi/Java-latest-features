package com.modernjava.features;

import java.util.Arrays;
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


class Instructor {
    String name;
    int yearsOfExperience;
    String title;
    String gender;
    boolean onlineCourses;
    List<String> courses;

    public Instructor(String name, int yearsOfExperience, String title, String gender, boolean onlineCourses, List<String> courses) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.title = title;
        this.gender = gender;
        this.onlineCourses = onlineCourses;
        this.courses = courses;
    }

    public static List<Instructor> getAll() {
        Instructor instructor1 = new Instructor("Mike", 10, "Software Developer"
                , "M", true, Arrays.asList("Java Programming", "C++ Programming", "Python Programming"));

        Instructor instructor2 = new Instructor("Jenny", 5, "Engineer"
                , "F", false, Arrays.asList("Multi-Threaded Programming", "CI/CD", "Unit Testing"));

        Instructor instructor3 = new Instructor("Gene", 6, "Manager"
                , "M", false, Arrays.asList("C++ Programming", "C Programming", "React Native"));

        Instructor instructor4 = new Instructor("Anthony", 15, "Senior Developer"
                , "M", true, Arrays.asList("Java Programming", "Angular Programming", "React Native"));

        Instructor instructor5 = new Instructor("Syed", 15, "Principal Engineer"
                , "M", true, Arrays.asList("Java Programming", "Java Multi-Threaded Programming", "React Native"));

        List<Instructor> list = Arrays.asList(instructor1, instructor2, instructor3, instructor4, instructor5);
        return list;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isOnlineCourses() {
        return onlineCourses;
    }

    public void setOnlineCourses(boolean onlineCourses) {
        this.onlineCourses = onlineCourses;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                ", onlineCourses=" + onlineCourses +
                ", courses=" + courses +
                '}';
    }
}