package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ26594 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = 1;
        char first = input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == first) {
                N++;
            } else {
                break;
            }
        }

        System.out.println(N);
    }
}
