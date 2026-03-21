package alg_tr_ya.first.practic;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Five {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            List<String> data = readLine(reader);

            printResult(writer, data);
        }
    }

    private static void printResult(BufferedWriter writer, List<String> data) throws IOException {
        StringBuilder builder = new StringBuilder();

        for (String s: data) {

            boolean isFirst = true;
            int firstCount = 0;
            int secondCount = 0;

            for (int i = 0; i < s.length(); i++) {
                char check = s.charAt(i);
                if (check == '\'' && isFirst) {
                    firstCount++;
                } else if (check != '\'') {
                    isFirst = false;
                } else {
                    secondCount++;
                }
            }

            int l = firstCount + firstCount;
            int r = s.length() - secondCount - secondCount;

            builder.append(s, l, r);
        }

        writer.write(builder.toString());
    }

    private static List<String> readLine(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .collect(Collectors.toList());
    }
}
