package org.paumard.chtijug;


import java.util.Arrays;
import java.util.List;

public class E_PlayWithPoint {

    public static void main(String[] args) {

        record Point(int x, int y) implements Comparable<Point> {

            Point() {
                this(0, 0);
            }

            Point(int y) {
                this(0, y);
            }

            @Override
            public int compareTo(Point o) {
                return x == o.x ? Integer.compare(y, o.y) :
                        Integer.compare(x, o.x);
            }
        }

        var origin = new Point();
        var p11 = new Point(1, 1);
        System.out.println("p11 = " + p11);
        System.out.println("p11.x() = " + p11.x());
        System.out.println("p11.y() = " + p11.y());

        var p01 = new Point(0, 1);
        var p02 = new Point(0, 2);
        var p10 = new Point(1, 0);
        var p12 = new Point(1, 2);
        var p20 = new Point(2, 0);
        var p21 = new Point(2, 1);
        var p22 = new Point(2, 2);

        var points =
                Arrays.asList(p22, p21, p20, p12, p11, p10, p02, p01, origin);
        System.out.println("points = " + points);
        System.out.println("points = " + points.stream().sorted().toList());
    }
}
