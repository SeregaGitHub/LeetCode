package alg_tr_ya.first.practic;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class One {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 600);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            List<Integer> data = readLine(reader);

            int n = data.getFirst();
            int m = data.getLast();

            char[][] matrix = new char[n][m];

            for (int i = 0; i < n; i++) {
                String str = reader.readLine();
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = str.charAt(j);
                }
            }

            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    char check = matrix[i][j];
                    if (check == '.') {
                        if (j < m - 1 && matrix[i][j + 1] == '.') {
                            count++;
                        }
                        if (i < n - 1 && matrix[i + 1][j] == '.') {
                            count++;
                        }
                    }
                }
            }

            writer.write(String.valueOf(count));
        }
    }

    private static List<Integer> readLine(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
