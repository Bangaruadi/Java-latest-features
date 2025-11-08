package com.modernjava.features;

import java.util.Arrays;
import java.util.List;

public class Instructor {
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
