package org.paumard.chtijug;

import java.util.Iterator;

public class F_PlayWithRange {

    public static void main(String[] args) {

        record Range(int begin, int end) implements Iterable<Integer> {

            Range {
                if (begin > end) {
                    throw new IllegalArgumentException("Begin should be smaller than end");
                }
            }

            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<>() {
                    int index = begin;

                    @Override
                    public boolean hasNext() {
                        return index < end;
                    }

                    @Override
                    public Integer next() {
                        return index++;
                    }
                };
            }
        }

        var range = new Range(0, 10);
        System.out.println("range = " + range);
        for (var index: range) {
            System.out.println("index = " + index);
        }
    }
}
