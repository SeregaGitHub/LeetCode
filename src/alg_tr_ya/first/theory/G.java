package alg_tr_ya.first.theory;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class G {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 600);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            //List<Integer> street = readList(reader);
            List<Integer> street = List.of(2, 0, 1, 1, 0, 1, 0, 2, 1, 2);
            findDistance(writer, street);
        }
    }

    private static void findDistance(BufferedWriter writer, List<Integer> street) throws IOException {
        // 1 - home
        // 2 - market
        // 2 0 1 1 0 1 0 2 1 2        - 3
        //     2 3   5     1          ->
        //     2 3   2     1          <-
        int count = 0;
        boolean start = false;
        int[] result = new int[street.size()];
        for (int i = 0; i < street.size(); i++) {
            if (start) {
                count++;
            }
            if (street.get(i) == 2) {
                start = true;
                count = 0;
            } else if (street.get(i) == 1 && start) {
                if (result[i] == 0) {
                    result[i] = count;
                } else {
                    result[i] = Math.min(result[i], count);
                }
            }
        }

        count = 0;
        start = false;
        for (int i = street.size() - 1; i >= 0; i--) {
            if (start) {
                count++;
            }
            if (street.get(i) == 2) {
                start = true;
                count = 0;
            } else if (street.get(i) == 1 && start) {
                if (result[i] == 0) {
                    result[i] = count;
                } else {
                    result[i] = Math.min(result[i], count);
                }
            }
        }

        int maxDistance = 0;
        for (int i = 0; i < street.size(); i++) {
            maxDistance = Math.max(maxDistance, result[i]);
        }

        writer.write(String.valueOf(maxDistance));
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
