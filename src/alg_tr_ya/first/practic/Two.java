package alg_tr_ya.first.practic;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Two {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 600);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            List<Integer> data = readLine(reader);
            List<List<Integer>> events = new ArrayList<>();
            
            List<Integer> plotNumbers = new ArrayList<>();
            int[] plots = new int[data.getLast()];

            for (int i = 0; i < data.getFirst(); i++) {
                List<Integer> event = readLine(reader);
                events.add(event);
            }

            for (int i = 0; i < data.getLast(); i++) {
                int plot = Integer.parseInt(reader.readLine());
                plotNumbers.add(plot);
            }

            for (int i = 0; i < events.size(); i++) {
                List<Integer> event = events.get(i);
                int left = event.getFirst();
                int right = event.get(1);
                int count = event.getLast();

                int isPlus = left % 2;

                for (int j = 0; j < plotNumbers.size(); j++) {
                    int plot = plotNumbers.get(j);
                    if (plot >= left && plot <= right) {
                        if (plot % 2 == isPlus) {
                            plots[j] = plots[j] + count;
                        } else {
                            plots[j] = plots[j] - count;
                        }
                        plotNumbers.set(j, plot);
                    }
                }
            }

            for (Integer i: plots) {
                writer.write(i + "\n");
            }
        }
    }

    private static List<Integer> readLine(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
