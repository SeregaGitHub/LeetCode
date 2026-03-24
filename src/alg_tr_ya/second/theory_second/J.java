package alg_tr_ya.second.theory_second;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class J {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 600);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            List<Integer> data = readNumbers(reader);
            int min = data.getFirst();
            int max = data.getLast();

            String minStr = reader.readLine();
            String maxStr = reader.readLine();

//            int min = 4;
//            int max = 11;

//            String minStr = "cAda";
//            String maxStr = "AbrAcadAbRa";

            Map<Character, Integer> dict = new HashMap<>();
            int result = 0;

            for (int i = 0; i < min; i++) {
                dict.put(minStr.charAt(i), dict.getOrDefault(minStr.charAt(i), 0) + 1);
            }

            Map<Character, Integer> tempDict = new HashMap<>();
            int tempDictSize = 0;
            int l = 0;
            int r = 0;

            while (r <= max - 1) {
                char checkSymbol = maxStr.charAt(r);

                if (dict.containsKey(checkSymbol)) {
                    tempDict.put(checkSymbol, tempDict.getOrDefault(checkSymbol, 0) + 1);
                    ++tempDictSize;

                    if (dict.equals(tempDict) || min == tempDictSize) {
                        if (dict.equals(tempDict)) {
                            result++;
                        }

                        char charForDelete = maxStr.charAt(l);
                        int intForDelete = tempDict.get(charForDelete);

                        if (intForDelete > 1) {
                            tempDict.put(charForDelete, --intForDelete);
                        } else {
                            tempDict.remove(charForDelete);
                        }
                        r++;
                        l++;
                        --tempDictSize;
                    } else {
                        r++;
                    }
                } else {
                    tempDict.clear();
                    tempDictSize = 0;
                    r++;
                    l = r;
                }
            }

            writer.write(String.valueOf(result));
        }
    }

    private static List<Integer> readNumbers(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
