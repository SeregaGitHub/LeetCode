package alg_tr_ya.first.practic;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Four {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            //List<Long> data = readLine(reader);
            //List<Long> data = List.of(1000000000000000000L, 1000000000000000000L, 1L, 1L);
            List<Long> data = List.of(576460752303423489L, 576460752303423489L, 1L, 1L);
            //List<Long> data = List.of(10L, 10L, 1L, 1L);

            long n = data.getFirst();
            long m = data.get(1);        // Длины сторон простыни

            long h = data.get(2);
            long w = data.getLast();

            long wMin = Math.min(h, w);
            long wMax = Math.max(h, w);

            long count = 0;

            while (true) {

                long nMin = Math.min(n, m);
                long nMax = Math.max(n, m);

                if (nMax > wMax) {
                    count++;
                    ++nMax;           // округление вверх после складывания пополам
                    nMax = nMax / 2;
                    n = nMax;
                    m = nMin;
                } else if (nMin > wMin) {
                    count++;
                    ++nMin;           // округление вверх после складывания пополам
                    nMin = nMin / 2;
                    n = nMax;
                    m = nMin;
                } else {
                    break;
                }
            }

            writer.write(String.valueOf(count));
        }
    }

    private static List<Long> readLine(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }
}
