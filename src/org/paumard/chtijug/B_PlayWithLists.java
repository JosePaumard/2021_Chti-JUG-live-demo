package org.paumard.chtijug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_PlayWithLists {

    public static void main(String[] args) {

        var arrayList = new ArrayList<>();
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        arrayList.add("four");
        arrayList.add("five");
        arrayList.add("six");
        arrayList.add("seven");
        arrayList.add("eight");
        arrayList.add("nine");
        arrayList.add("ten");

        var arraysAsList =
                Arrays.asList("one", "two", "three",  "four", "five",
                        "six", "seven", "eight", "nine", "ten");
//        arraysAsList.replaceAll(String::toUpperCase);

        var listOf =
                List.of("one", "two", "three",  "four", "five", "six",
                        "seven", "eight", "nine", "ten");

        System.out.println("arrayList    = " + arrayList);
        System.out.println("arraysAsList = " + arraysAsList);
        System.out.println("listOf       = " + listOf);

        var copyOf = List.copyOf(listOf);
        System.out.println("copyOf = " + copyOf);
        System.out.println("same = " + (listOf == copyOf));
    }
}
