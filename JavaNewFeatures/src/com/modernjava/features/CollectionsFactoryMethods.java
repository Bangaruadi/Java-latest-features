package com.modernjava.features;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsFactoryMethods {
    //Java 9 introduced factory methods "of" to create unmodifiable list , set and map

    //null pointer is thrown if you add null to all 3
    //illegal argument thrown for duplicate items in set and map
    //UnsupportedOperationException is thrown if you modify these
    public static void main(String[] args) {
        List<String> aditya = List.of("Aditya", "Bharadwaj");
        Set<String> aditya1 = Set.of("Aditya", "Bharadwaj");
        Map<Integer, String> integerStringMap = Map.of(1, "Aditya", 2, "Bharadwaj");
    }
}
