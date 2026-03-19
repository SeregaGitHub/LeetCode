package alg_tr_ya.second.theory_second;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class C {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 600);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            List<Integer> list1 = readLine(reader);
            List<Integer> list2 = readLine(reader);

            Set<Integer> set = new HashSet<>(list1);
            TreeSet<Integer> result = new TreeSet<>();

            for (Integer i: list2) {
                if (set.contains(i)) {
                    result.add(i);
                }
            }

            for (Integer integer : result) {
                writer.write(integer + " ");
            }
        }
    }

    private static List<Integer> readLine(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
