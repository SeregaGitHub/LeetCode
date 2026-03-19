package alg_tr_ya.second.theory_second;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class B {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 600);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            List<Integer> data = readLine(reader);
            Set<Integer> set = new HashSet<>();

            for (Integer i: data) {
                if (set.contains(i)) {
                    writer.write("YES\n");
                } else {
                    writer.write("NO\n");
                }
                set.add(i);
            }
        }
    }

    private static List<Integer> readLine(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
