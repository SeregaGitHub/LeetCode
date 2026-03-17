package alg_tr_ya.first.theory;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            List<Integer> manList = readList(reader);
            List<Integer> womanList = readList(reader);
            int manStart = manList.getFirst();
            int manFinish = manList.getLast();
            int womanStart = womanList.getFirst();
            int womanFinish = womanList.getLast();

            // 3 5
            // 8 2
            // -2 2
            //      -2 -1 0 1 2 3 4 5 6 7 8
            //                        6 7 8 9 10
            //-4 -3 -2 -1 0

            // 8 3
            // 12 2
            // 4 2
            //       5 6 7 8 9 10 11
            //                 10 11 12 13 14
            // 2 3 4 5 6

            // -8 3
            // -5 1
            // -11 1
            //      -11 -10 -9 -8 -7 -6 -5
            //                       -6 -5 -4
            //  -12 -11 -10

            // 3 1
            // 8 2
            // 2 3 4     6 7 8 9 10

            // -3 1
            // 8 2
            // -4 -3 -2     6 7 8 9 10

            // -3 1
            // -8 2
            // -4 -3 -2     -6 -7 -8 -9 -10

            // -3 2
            // -8 3
            // -5 -4 -3 -2 -1    -5 -6 -7 -8 -9 -10 -11

            // 3 5
            // 7 1
            //      -2 -1 0 1 2 3 4 5 6 7 8
            //                        6 7 8

            findResult(writer, manStart, manFinish, womanStart, womanFinish);
            findTreesCount(writer, manStart, manFinish, womanStart, womanFinish);
        }
    }

    // Simple - right
    private static void findTreesCount(
            BufferedWriter writer, int manStart, int manFinish, int womanStart, int womanFinish
    ) throws IOException {

        int manLeft = manStart - manFinish;
        int manRight = manStart + manFinish;
        int womanLeft = womanStart - womanFinish;
        int womanRight = womanStart + womanFinish;

        int result = 0;

        int startFirst;
        int finishFirst;
        int startSecond;
        int finishSecond;

        if (manLeft <= womanLeft) {
            startFirst = manLeft;
            finishFirst = manRight;
            startSecond = womanLeft;
            finishSecond = womanRight;
        } else {
            startFirst = womanLeft;
            finishFirst = womanRight;
            startSecond = manLeft;
            finishSecond = manRight;
        }

        for (int i = startFirst; i <= finishFirst; i++) {
            result++;
        }

        for (int i = startSecond; i <= finishSecond; i++) {
            if ((i < startFirst && i < finishFirst) || (i > finishFirst && i > startFirst)) {
                result++;
            }
        }

        writer.write(String.valueOf(result));
    }

    // Not simple - right
    private static void findResult(
            BufferedWriter writer, int manStart, int manFinish, int womanStart, int womanFinish
    ) throws IOException {

        int manLeft = manStart - manFinish;
        int manRight = manStart + manFinish;
        int womanLeft = womanStart - womanFinish;
        int womanRight = womanStart + womanFinish;

        // 3 5
        // 8 2
        // -2 2
        //      -2 -1 0 1 2 3 4 5 6 7 8
        //                        6 7 8 9 10
        //-4 -3 -2 -1 0

        // 7 1
        // 3 5
        //                        6 7 8
        //      -2 -1 0 1 2 3 4 5 6 7 8

        /*if (manRight >= womanLeft && womanRight > manRight) {
            result = Math.abs(womanRight - manLeft) + 1;
        } else if (womanLeft <= manLeft && womanRight > manLeft) {
            result = Math.abs(manRight - womanLeft) + 1;
        } else {
            result = Math.abs(manRight - manLeft) + Math.abs(womanRight - womanLeft) + 2;
        }*/

        int startMax;
        int finishMax;
        int startMin;
        int finishMin;

        if ((manFinish * 2 + 1) >= (womanFinish * 2 + 1)) {
            startMax = manLeft;
            finishMax = manRight;
            startMin = womanLeft;
            finishMin = womanRight;
        } else {
            startMax = womanLeft;
            finishMax = womanRight;
            startMin = manLeft;
            finishMin = manRight;
        }

        int result;

        if (finishMax >= startMin && finishMin >= finishMax) {
            result = Math.abs(finishMin - startMax) + 1;
        } else if (startMin <= startMax && finishMin >= startMax) {
            result = Math.abs(finishMax - startMin) + 1;
        } else {
            result = Math.abs(finishMax - startMax) + Math.abs(finishMin - startMin) + 2;
        }

        writer.write(String.valueOf(result));
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
