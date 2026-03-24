package alg_tr_ya.second.theory_second;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class G {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            /*String srt1 = "Ivanov paper 10";
            String srt2 = "Petrov pens 5";
            String srt3 = "Ivanov marker 3";
            String srt4 = "Ivanov paper 7";
            String srt5 = "Petrov envelope 20";
            String srt6 = "Ivanov envelope 5";

            strings.add(srt1);
            strings.add(srt2);
            strings.add(srt3);
            strings.add(srt4);
            strings.add(srt5);
            strings.add(srt6);*/

            printResult(reader, writer);
        }
    }

    private static void printResult(BufferedReader reader, BufferedWriter writer) throws IOException {

        Map<String, Map<String, Long>> data = new HashMap<>();
        // TreeMap<String, TreeMap<String, Long>> data = new TreeMap<>();

        String str;
        while ((str = reader.readLine()) != null) {

            if (str.isEmpty()) break;

            // Speed best when -  String[] array = str.split(" ");
            int firstSpace = str.indexOf(' ');
            int secondSpace = str.indexOf(' ', firstSpace + 1);

            String lastname = str.substring(0, firstSpace);
            String product  = str.substring(firstSpace + 1, secondSpace);
            long value = Long.parseLong(str.substring(secondSpace + 1));

            Map<String, Long> map = data.getOrDefault(lastname, new HashMap<>());
            map.put(product, map.getOrDefault(product, 0L) + value);
            // TreeMap<String, Long> map = data.getOrDefault(lastname, new TreeMap<>());
            // map.put(product, map.getOrDefault(product, 0L) + value);

//            Map<String, Long> map = data.computeIfAbsent(lastname, k -> new HashMap<>());
//            map.merge(product, value, Long::sum);

            data.put(lastname, map);
        }

        List<String> lastnames = new ArrayList<>(data.keySet());
        Collections.sort(lastnames);

        for (String lastname: lastnames) {
            writer.write(lastname);
            writer.write(":\n");

            Map<String, Long> products = data.get(lastname);
            List<String> productNames = new ArrayList<>(products.keySet());
            Collections.sort(productNames);

            for (String product: productNames) {

                writer.write(product);
                writer.write(" ");
                writer.write(String.valueOf(products.get(product)));
                writer.write("\n");
            }
        }
    }

    private static String[] readStrings(BufferedReader reader) throws IOException {
        return reader.readLine().split(" ");
    }
}
