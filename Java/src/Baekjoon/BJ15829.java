package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String input = br.readLine();

        long result = 0;
        long r = 1;
        int M = 1234567891;

        for (int i = 0; i < L; i++) {
            result += ((input.charAt(i) - 96) * r) % M;
            r = 31 * r % M;
        }

        System.out.println(result % M);
    }
}
