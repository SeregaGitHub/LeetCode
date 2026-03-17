package alg_tr_ya.first.theory;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class B {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            // List<Integer> data = readList(reader);
            List<Integer> data1 = List.of(89, 20, 41, 1, 11);
            List<Integer> data2 = List.of(11, 1, 1, 1, 1);

            printResult(writer, data1);
            printResult(writer, data2);

        }
    }

    private static void printResult(BufferedWriter writer, List<Integer> data) throws IOException {

        int currentFlat = data.getFirst(); // 89
        int flourCount = data.get(1);      // 20
        int lastFlat = data.get(2);        // 41
        int lastDoor = data.get(3);        // 1
        int lastFlour = data.getLast();    // 11

        int currentDoor;
        int currentFlour;

        int countFlatOnFlour;              // 4

        int check = lastFlat / lastFlour;  // - countFlatOnFlour = 4
        if (check == 0) {
            countFlatOnFlour = check;
        } else {
            countFlatOnFlour = ++check;
        }

        int countFlatInFlour = flourCount * countFlatOnFlour; // 80
        int checkDoor = currentFlat / countFlatInFlour;       // 89 / 80 = 1
        int flatInFlour = currentFlat % countFlatInFlour;     // 89 % 80 = 9
        int checkFlour = flatInFlour / countFlatOnFlour;      // 9 / 4 = 2

        if (checkDoor == 0) {
            currentDoor = checkDoor;
        } else {
            currentDoor = ++checkDoor;
        }

        if (checkFlour == 0) {
            currentFlour = checkFlour;
        } else {
            currentFlour = ++checkFlour;
        }

        writer.write(currentDoor + " " + currentFlour);
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
