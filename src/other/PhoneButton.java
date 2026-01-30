package other;

import java.io.*;
import java.util.*;

public class PhoneButton {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            Map<Integer, List<Character>> dict = new HashMap<>();
            dict.put(2, List.of('a', 'b', 'c'));
            dict.put(3, List.of('d', 'e', 'f'));
            dict.put(4, List.of('g', 'h', 'i'));
            dict.put(5, List.of('j', 'k', 'l'));
            dict.put(6, List.of('m', 'n', 'o'));
            dict.put(7, List.of('p', 'q', 'r', 's'));
            dict.put(8, List.of('t', 'u', 'v'));
            dict.put(9, List.of('w', 'x', 'y', 'z'));

            String numbers = reader.readLine();
            List<Integer> integers = getNumbers(numbers);
            Queue<Tree> queue = new LinkedList<>();
            queue.offer(new Tree(""));

            for (int i = 0; i < numbers.length(); i++) {
                int queueSize = queue.size();
                int number = integers.get(i);
                List<Character> letters = dict.get(number);
                for (int j = 0; j < queueSize; j++) {
                    Tree tree = queue.poll();
                    if (letters.size() == 3) {
                        Tree tree1 = new Tree(tree.root.concat(String.valueOf(letters.get(0))));
                        tree.tree1 = tree1;
                        Tree tree2 = new Tree(tree.root.concat(String.valueOf(letters.get(1))));
                        tree.tree2 = tree2;
                        Tree tree3 = new Tree(tree.root.concat(String.valueOf(letters.get(2))));
                        tree.tree3 = tree3;

                        queue.offer(tree1);
                        queue.offer(tree2);
                        queue.offer(tree3);
                    } else {
                        Tree tree1 = new Tree(tree.root.concat(String.valueOf(letters.get(0))));
                        tree.tree1 = tree1;
                        Tree tree2 = new Tree(tree.root.concat(String.valueOf(letters.get(1))));
                        tree.tree2 = tree2;
                        Tree tree3 = new Tree(tree.root.concat(String.valueOf(letters.get(2))));
                        tree.tree3 = tree3;
                        Tree tree4 = new Tree(tree.root.concat(String.valueOf(letters.get(3))));
                        tree.tree4 = tree4;

                        queue.offer(tree1);
                        queue.offer(tree2);
                        queue.offer(tree3);
                        queue.offer(tree4);
                    }
                }
            }
            queue.forEach(tree -> {
                try {
                    writer.write(tree.root + " ");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private static List<Integer> getNumbers(String str) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        return list;
    }

    private static class Tree {
        String root;
        Tree tree1;
        Tree tree2;
        Tree tree3;
        Tree tree4;

        public Tree(String root) {
            this.root = root;
        }

        public Tree(String root, Tree tree1, Tree tree2, Tree tree3) {
            this.root = root;
            this.tree1 = tree1;
            this.tree2 = tree2;
            this.tree3 = tree3;
        }

        public Tree(String root, Tree tree1, Tree tree2, Tree tree3, Tree tree4) {
            this.root = root;
            this.tree1 = tree1;
            this.tree2 = tree2;
            this.tree3 = tree3;
            this.tree4 = tree4;
        }
    }
}
