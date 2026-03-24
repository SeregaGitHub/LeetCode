package alg_tr_ya.second.theory_second;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class F {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 600);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int count = Integer.parseInt(reader.readLine());
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < count; i++) {
                List<String> strings = readLine(reader);
                map.put(strings.getFirst(), strings.getLast());
                map.put(strings.getLast(), strings.getFirst());
            }
            String str = reader.readLine();
            writer.write(map.get(str));
        }
    }

    private static List<String> readLine(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .collect(Collectors.toList());
    }
}
