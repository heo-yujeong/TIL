package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (input.charAt(0) == '_' || input.charAt(input.length()-1) == '_' || Character.isUpperCase(input.charAt(0))) {
            System.out.println("Error!");
            return;
        }

        boolean underScore = false;
        boolean upperCase = false;
        char prev = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '_') {
                if (prev == '_') {
                    System.out.println("Error!");
                    return;
                }
                underScore = true;
            } else if (Character.isUpperCase(c)) {
                upperCase = true;
            }
            prev = c;
        }

        if (underScore && upperCase) {
            System.out.println("Error!");
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (underScore) {
            boolean upperNext = false;
            for (char c : input.toCharArray()) {
                if (c == '_') {
                    upperNext = true;
                } else {
                    sb.append(upperNext ? Character.toUpperCase(c) : c);
                    upperNext = false;
                }
            }
        } else if (upperCase) {
            for (char c : input.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    sb.append('_').append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
        } else {
            sb.append(input);
        }

        System.out.println(sb);
    }
}
