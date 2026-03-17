package alg_tr_ya.first.theory;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class F {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 600);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

//            List<Integer> numbers = readList(reader);
//
//            printTwoNumbers(writer, numbers);

            List<Integer> numbers1 = List.of(4, 3, 5, 2, 5);
            List<Integer> numbers2 = List.of(-4, 3, -5, 2, 5);
            List<Integer> numbers3 = List.of(0, 0);
            List<Integer> numbers4 = List.of(-1, -2, -3, -4);
            List<Integer> numbers5 = List.of(-4, -4, -4, -4);
            List<Integer> numbers6 = List.of(4, 4, 4, 4);
            List<Integer> numbers7 = List.of(1, 2, 3, 4);
            List<Integer> numbers8 = List.of(4, 3, 1, 2);
            List<Integer> numbers9 = List.of(Integer.MIN_VALUE, Integer.MIN_VALUE);
            List<Integer> numbers10 = List.of(Integer.MIN_VALUE, Integer.MIN_VALUE, 0, 0);
            List<Integer> numbers11 = List.of(Integer.MAX_VALUE, Integer.MAX_VALUE);
            List<Integer> numbers12 = List.of(Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 0);
            List<Integer> numbers13 = List.of(4, 3, 0);
            List<Integer> numbers14 = List.of(4, -3, 0);

//            printTwoNumbers(writer, numbers1);
//            printTwoNumbers(writer, numbers2);
//            printTwoNumbers(writer, numbers3);
//            printTwoNumbers(writer, numbers4);
//            printTwoNumbers(writer, numbers5);
//            printTwoNumbers(writer, numbers6);
//            printTwoNumbers(writer, numbers7);
//            printTwoNumbers(writer, numbers8);
//            printTwoNumbers(writer, numbers9);
//            printTwoNumbers(writer, numbers10);
//            printTwoNumbers(writer, numbers11);
//            printTwoNumbers(writer, numbers12);
            printTwoNumbers(writer, numbers13);
            printTwoNumbers(writer, numbers14);
        }
    }

    private static void printTwoNumbers(BufferedWriter writer, List<Integer> numbers) throws IOException {

        TreeSet<Integer> positiveNumbers = new TreeSet<>((i1, i2) -> {
            return i2 - i1;
        });
        TreeSet<Integer> negativeNumbers = new TreeSet<>();
        int[] answer = new int[2];
        long result = Long.MIN_VALUE;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) < 0) {
                negativeNumbers.add(numbers.get(i - 1));
            } else {
                positiveNumbers.add(numbers.get(i - 1));
            }

            int checkNumber = numbers.get(i);
            Long checkNegative = null;
            Long checkPositive = null;

            if (!negativeNumbers.isEmpty()) {
                checkNegative = (long) checkNumber * (long) negativeNumbers.first();
            }
            if (!positiveNumbers.isEmpty()) {
                checkPositive = (long) checkNumber * (long) positiveNumbers.first();
            }

            long currentResult;
            if (checkPositive == null) {
                currentResult = Math.max(checkNegative, result);
                if (result < currentResult) {
                    answer[0] = Math.min(checkNumber, negativeNumbers.first());
                    answer[1] = Math.max(checkNumber, negativeNumbers.first());
                    result = currentResult;
                }
            } else if (checkNegative == null) {
                currentResult = Math.max(checkPositive, result);
                if (result < currentResult) {
                    answer[0] = Math.min(checkNumber, positiveNumbers.first());
                    answer[1] = Math.max(checkNumber, positiveNumbers.first());
                    result = currentResult;
                }
            } else {
                long currentPositiveResult = Math.max(result, checkPositive);
                long currentNegativeResult = Math.max(result, checkNegative);

                if (result < currentPositiveResult) {
                    answer[0] = Math.min(checkNumber, positiveNumbers.first());
                    answer[1] = Math.max(checkNumber, positiveNumbers.first());
                    result = currentPositiveResult;
                }
                if (result < currentNegativeResult) {
                    answer[0] = Math.min(checkNumber, negativeNumbers.first());
                    answer[1] = Math.max(checkNumber, negativeNumbers.first());
                    result = currentNegativeResult;
                }
            }
        }

        writer.write(answer[0] + " " + answer[1]);
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
