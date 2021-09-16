package org.paumard.chtijug;

public class A_PlayWithStrings {

    public static void main(String[] args) {

        String numbers = """
                one        \s
                "two "     \s
                "three"    \s
                'four'     \s
                five       \s
                six        \s
               """;

        System.out.println("numbers = " + numbers);
        numbers.lines()
                .map(s -> "|" + s + "|")
                .forEach(System.out::println);
    }
}
