package alg_tr_ya.second.practic;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Two {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 600);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

        }
    }

    private static List<Integer> readNumbers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                //.map(elem -> Integer.parseInt(elem))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
