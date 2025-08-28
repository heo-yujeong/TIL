package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int len = input.length;
        for (int i = 0; i < len/2; i++) {
            if (input[i] != input[len-i-1]) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}
