package alg_tr_ya.first.theory;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class D {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 600);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            List<Integer> param = readList(reader);
            int tRoom = param.getFirst();
            int tCond = param.getLast();
            String mode = reader.readLine();

            printTemp(writer, tRoom, tCond, mode);
        }
    }

    private static void printTemp(BufferedWriter writer, int tRoom, int tCond, String mode) throws IOException {

        int result = switch (mode) {
            case "freeze" -> Math.min(tRoom, tCond);
            case "heat" -> Math.max(tRoom, tCond);
            case "auto" -> tCond;
            default -> tRoom;
        };

        writer.write(String.valueOf(result));
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
