package alg_tr_ya.second.theory_second;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class I {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int count = Integer.parseInt(reader.readLine());
            String str = reader.readLine();

            TreeMap<Character, Integer> data = new TreeMap<>();

            for (int i = 0; i < str.length(); i++) {
                char check = str.charAt(i);
                data.put(check, data.getOrDefault(check, 0) + 1);
            }

            StringBuilder builder1 = new StringBuilder();
            StringBuilder builder2 = new StringBuilder();
            Character center = null;

            for (Map.Entry<Character, Integer> entry: data.entrySet()) {
                char currentChar = entry.getKey();
                int currentInt = entry.getValue();

                while (currentInt > 1) {
                    builder1.append(currentChar);
                    builder2.append(currentChar);
                    currentInt -= 2;
                }

                if (currentInt == 1 && center == null) {
                    center = currentChar;
                }
            }

            builder2.reverse();

            if (center != null) {
                builder1.append(center);
            }

            builder1.append(builder2);

            writer.write(builder1.toString());
        }
    }
}
