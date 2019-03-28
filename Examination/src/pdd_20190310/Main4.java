package pdd_20190310;

import java.util.HashSet;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("frnfrfnoisnlksndlfr".length());
        String input = scanner.next().toLowerCase();
        char[] c = input.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char c_ : c
             ) {
            set.add(c_);
        }
        int number = set.size();
        char output = c[0];
        for (int i = 0; i < input.length(); i++) {
//            System.out.println(i);
            if (!helper(input.substring(i), number)) break;
            if (input.charAt(i) < output) output = input.charAt(i);
        }
        System.out.println(output);
    }

    private static boolean helper(String s, int number) {
        char[] c = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char k : c
             ) {
            set.add(k);
        }
        return set.size() == number;
    }
}
