package com.modernjava.features;

import java.time.*;
import java.time.temporal.ChronoField;

public class Java8LocalDate {

    //previous Date and SimpleDateFormatter is not thread safe which is leading to concurrency issues
    //Developer has to write a lot of code to deal with timezone issues

    //Local - simplified date-time API for time
    //Zoned - this is for timeZone issues
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate +" === "+localTime+" === "+localDateTime);

        localDate = LocalDate.of(2018, 05, 23);
        System.out.println("localDate = " + localDate);

        localDate = LocalDate.now();

        //Get Methods
        System.out.println("localDate.getMonth = " + localDate.getMonth());
        System.out.println("localDate.getMonthValue() = " + localDate.getMonthValue());
        System.out.println("localDate.getDayOfWeek() = " + localDate.getDayOfWeek());
        System.out.println("localDate.getD = " + localDate.getDayOfYear());
        System.out.println("localDate = " + localDate.get(ChronoField.MONTH_OF_YEAR));

        System.out.println("localDate.plusDays(4) = " + localDate.plusDays(4));
        System.out.println("localDate.plusMonths(2) = " + localDate.plusMonths(2));
        System.out.println("localDate.plusYears(2) = " + localDate.plusYears(2));
        System.out.println("localDate.minusDays(10) = " + localDate.minusDays(10));
        System.out.println("localDate.withYear(2023) = " + localDate.withYear(2023));

        localTime = LocalTime.of(15, 18, 22);
        System.out.println("localTime = " + localTime);

        localTime = LocalTime.of(15,18,23,22222222);
        System.out.println("localTime = " + localTime);

        //to modify localTime we can do same as localDate example localTime.plusHours(2)

        //of
        localDateTime = LocalDateTime.of(2022, 1, 12, 12,12,12);
        System.out.println("localDateTime = " + localDateTime);

        localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("localDateTime = " + localDateTime);

        localDateTime.toLocalDate();
        localDateTime.toLocalTime();


        //System.out.println(" Duration between localDate = "+ Duration.between(LocalDate.now(),localDate.plusDays(1)));
        //System.out.println(" Duration between localtime = "+ Duration.between(LocalTime.now(),localTime));
        //System.out.println(" Duration between localDateTime = "+ Duration.between(LocalDateTime.now(),localDateTime));


        //Instant
        Instant timestamp = Instant.now();
        LocalDateTime ld = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
        System.out.println("ld = " + ld);


        ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);
        System.out.println("Europe/London: " + ZonedDateTime.now(ZoneId.of("Europe/London")));
        System.out.println("America/New_York: " + ZonedDateTime
                .now(ZoneId.of("America/New_York")));

        ZonedDateTime zonedDateTime = localDateTime.
                atZone(ZoneId.of("America/New_York"));

    }
}
