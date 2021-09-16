package org.paumard.chtijug;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C_PlayWithStreams {

    public static void main(String[] args) {

        var listOf =
                List.of("one", "two", "three", "four", "five", "six",
                        "seven", "eight", "nine", "ten");

        var count = listOf.stream()
                .map(String::toUpperCase)
                .skip(1).limit(3)
                .peek(System.out::println)
                .count();
        System.out.println("count = " + count);

        String ints = """
                1
                2
                3
                4
                # j'ai quelque chose à dire
                5
                6
                7
                8
                """;

        List<Integer> strings =
                ints.lines()
//                        .filter(
//                                s -> {
//                                    try {
//                                        Integer.parseInt(s);
//                                        return true;
//                                    } catch (NumberFormatException e) {
//                                        return false;
//                                    }
//                                }
//                        )
//                        .flatMap(
//                                s -> {
//                                    try {
//                                        return Stream.of(Integer.parseInt(s));
//                                    } catch (NumberFormatException e) {
//                                        return Stream.of();
//                                    }
//                                }
//                        )
                        .<Integer>mapMulti(
                                (String s, Consumer<Integer> stream) -> {
                                    try {
                                        stream.accept(Integer.parseInt(s));
                                    } catch (NumberFormatException e) {

                                    }
                                }
                        )
                        .toList();
        System.out.println("strings = " + strings);

        var ints1 = IntStream.range(0, 10)
                .mapMulti(
                        (i, stream) -> {
                            stream.accept(i);
                            if (i != 0) {
                                stream.accept(10 * i);
                            }
                        }
                ).toArray();
        System.out.println("ints1 = " + Arrays.toString(ints1));
    }
}
