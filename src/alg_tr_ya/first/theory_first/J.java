package alg_tr_ya.first.theory_first;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class J {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int count = Integer.parseInt(reader.readLine());
            //int count = 1;
            for (int i = 0; i < count; i++) {
                List<Integer> list = readLine(reader);
                //List<Integer> list = List.of(9, 1, 0, 0, 10, 0, 1, 1);
                List<Point> points = new ArrayList<>();

                for (int j = 0; j < 7; j++) {
                    Point point = new Point(list.get(j), list.get(++j));
                    points.add(point);
                }

                boolean xResult = true;
                boolean yResult = true;

                points.sort(Comparator.comparingInt(Point::getX));

                int x1 = points.get(2).getX() - points.get(0).getX();
                int x2 = points.get(3).getX() - points.get(1).getX();

                boolean y3 = points.get(1).getY() == points.get(2).getY();
                boolean y4 = points.get(0).getY() == points.get(3).getY();


                if (x1 != x2 || y3 || y4) {
                    xResult = false;
                }

                points.sort(Comparator.comparingInt(Point::getY));

                int y1 = points.get(2).getY() - points.get(0).getY();
                int y2 = points.get(3).getY() - points.get(1).getY();

                boolean x3 = points.get(1).getX() == points.get(2).getX();
                boolean x4 = points.get(0).getX() == points.get(3).getX();

                if (y1 != y2 || x3 || x4) {
                    yResult = false;
                }

                writer.write(xResult && yResult ? "YES\n" : "NO\n");
            }


            //   0 1 2 3 4 5 6
            // 0 ^     *
            // 1   *       ^
            // 2   ^     *
            // 3     *       ^
            // 4
            // 5
            // 6


            //   0 1 2 3 4 5 6 7 8 9 10
            // 0 *                   *
            // 1   *               *
            // 2
        }
    }

    private static List<Integer> readLine(BufferedReader reader) throws IOException {
        String str = reader.readLine();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char check = str.charAt(i);
            if (check == '-') {
                builder.append(check);
            } else if (Character.isDigit(check)) {
                builder.append(check);
            } else if (i < str.length() - 1 && str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
                builder.append(check);
            } else {
                continue;
            }
        }

        String newStr = builder.toString();

        return Arrays.stream(newStr.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
