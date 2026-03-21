package alg_tr_ya.second.theory_second;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class D {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int people = Integer.parseInt(reader.readLine());

            printResult(reader, writer, people);
        }
    }

    private static void printResult(BufferedReader reader, BufferedWriter writer, int people) throws IOException {

        Set<String> commonResult = new HashSet<>();
        Set<String> result = new HashSet<>();

        for (int i = 0; i < people; i++) {
            int languages = Integer.parseInt(reader.readLine());

            Set<String> currentResult = new HashSet<>();

            for (int j = 0; j < languages; j++) {
                String language = reader.readLine();
                commonResult.add(language);
                currentResult.add(language);
            }

            if (result.isEmpty() && i == 0) {
                result.addAll(currentResult);
            } else {
                currentResult.removeIf(l -> !result.contains(l));
                result.removeIf(l -> !currentResult.contains(l));
            }
        }

        writer.write(result.size() + "\n");
        for (String l: result) {
            writer.write(l + "\n");
        }

        writer.write(commonResult.size() + "\n");
        for (String l: commonResult) {
            writer.write(l + "\n");
        }
    }
}

/*
3
3
Russian
English
Japanese
2
Russian
English
1
English
 */