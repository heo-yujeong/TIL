package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ32621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int plusIdx = input.indexOf('+');

        if (plusIdx == -1 || plusIdx != input.lastIndexOf('+')) {
            System.out.println("No Money");
            return;
        }

        String left = input.substring(0, plusIdx);
        String right = input.substring(plusIdx + 1);

        if (left.isEmpty() || right.isEmpty()) {
            System.out.println("No Money");
            return;
        }

        if (!left.equals(right)) {
            System.out.println("No Money");
            return;
        }

        if (left.charAt(0) == '0') {
            System.out.println("No Money");
            return;
        }

        for (char c : left.toCharArray()) {
            if (!Character.isDigit(c)) {
                System.out.println("No Money");
                return;
            }
        }

        System.out.println("CUTE");
    }
}
