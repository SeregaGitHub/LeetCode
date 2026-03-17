package alg_tr_ya;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 600);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

        }
    }

    private static List<Integer> readLine(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                //.map(elem -> Integer.parseInt(elem))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        String str = reader.readLine();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char check = str.charAt(i);
            if (check == '-') {
                builder.append(check);
            } else if (Character.isDigit(check)) {
                builder.append(check);
            } else if (i < str.length() - 1 && str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
                builder.append(check);
            } else {
                continue;
            }
        }

        String newStr = builder.toString();

        return Arrays.stream(newStr.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
