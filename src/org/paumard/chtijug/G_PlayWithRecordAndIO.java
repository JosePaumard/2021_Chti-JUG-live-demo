package org.paumard.chtijug;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class G_PlayWithRecordAndIO {

    static record RangeRecord(int begin, int end) implements Serializable {

        RangeRecord {
            if (end < begin) {
                throw new IllegalArgumentException("End must be greater than begin");
            }
        }

    }

    static class RangeClass implements Serializable {

        private final int begin;
        private final int end;

        RangeClass(int begin, int end) {
            if (begin > end) {
                throw new IllegalStateException("Begin must be smaller than end");
            }
            this.begin = begin;
            this.end = end;
            System.out.println("Building range");
        }

        @Override
        public String toString() {
            return "Range{" +
                    "begin=" + begin +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        var range = new RangeRecord(10, 0);
//        System.out.println("range = " + range);
//
//        var fos = Files.newOutputStream(Path.of("files/range-record-10-0.dat"));
//        var oos = new ObjectOutputStream(fos);
//
//        oos.writeObject(range);

        var is = Files.newInputStream(Path.of("files/range-record-10-0.dat"));
        var ois = new ObjectInputStream(is);
        System.out.println("Reading range");
        var readRange = ois.readObject();
        System.out.println("readRange = " + readRange);
    }
}
