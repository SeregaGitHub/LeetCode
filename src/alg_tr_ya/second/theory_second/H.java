package alg_tr_ya.second.theory_second;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class H {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 600);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            Map<String, Integer> bank = new HashMap<>();

            String str;
            while ((str = reader.readLine()) != null) {
                if (str.isEmpty()) break;

                str = str.trim();
                int firstIndex = 0;
                int nextIndex = str.indexOf(' ');

                Operation operation = Operation.valueOf(str.substring(firstIndex, nextIndex));

                firstIndex = nextIndex + 1;

                if (operation.equals(Operation.BALANCE)) {
                    String lastname = str.substring(firstIndex);
                    Integer balance = bank.get(lastname);
                    
                    if (balance == null) {
                        writer.write("ERROR\n");
                    } else  {
                        writer.write(balance + "\n");
                    }
                } else if (operation.equals(Operation.INCOME)) {
                    int p = Integer.parseInt(str.substring(firstIndex));

                    for (Map.Entry<String, Integer> b: bank.entrySet()) {
                        Integer money = b.getValue();
                        if (money > 0) {
                            double pr = p / 100.0 + 1.0;
                            double newSum = pr * money;
                            bank.put(b.getKey(), (int) newSum);
                        }
                    }
                } else if (operation.equals(Operation.DEPOSIT)) {
                    nextIndex = str.indexOf(' ', firstIndex + 1);
                    String lastname = str.substring(firstIndex, nextIndex);
                    Integer sum = Integer.parseInt(str.substring(nextIndex + 1));

                    bank.put(lastname, bank.getOrDefault(lastname, 0) + sum);
                } else if (operation.equals(Operation.WITHDRAW )) {
                    nextIndex = str.indexOf(' ', firstIndex + 1);
                    String lastname = str.substring(firstIndex, nextIndex);
                    Integer sum = Integer.parseInt(str.substring(nextIndex + 1));

                    bank.put(lastname, bank.getOrDefault(lastname, 0) - sum);
                } else if (operation.equals(Operation.TRANSFER)) {
                    nextIndex = str.indexOf(' ', firstIndex + 1);
                    String lastname1 = str.substring(firstIndex, nextIndex);

                    firstIndex = nextIndex + 1;
                    nextIndex = str.indexOf(' ', firstIndex + 1);

                    String lastname2 = str.substring(firstIndex, nextIndex);

                    int sum = Integer.parseInt(str.substring(nextIndex + 1));

                    bank.put(lastname1, bank.getOrDefault(lastname1, 0) - sum);
                    bank.put(lastname2, bank.getOrDefault(lastname2, 0) + sum);
                }
            }
        }
    }

    enum Operation {
        DEPOSIT,
        WITHDRAW,
        BALANCE,
        TRANSFER,
        INCOME
    }
}
