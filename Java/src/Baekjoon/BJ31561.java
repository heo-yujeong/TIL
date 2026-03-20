package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ31561 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        if (M < 30) {
            System.out.printf("%.1f", M / 2.0);
        } else {
            System.out.printf("%.1f", (M - 30) / 2.0 * 3 + 15);
        }
    }
}
