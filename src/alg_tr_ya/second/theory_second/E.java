package alg_tr_ya.second.theory_second;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class E {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int count = Integer.parseInt(reader.readLine());
            List<List<Integer>> data = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                List<Integer> list = readLine(reader);
                data.add(list);
            }

            printResult(writer, data, count);
        }
    }

    private static void printResult(BufferedWriter writer, List<List<Integer>> data, int count) throws IOException {
        Set<List<Integer>> set = new HashSet<>();

        for (List<Integer> l: data) {
            int f = l.getFirst();
            int s = l.getLast();

            if (f >= 0 && s >= 0 && (f + s == count - 1)) {
                set.add(l);
            }
        }

        writer.write(String.valueOf(set.size()));
    }

    private static List<Integer> readLine(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
