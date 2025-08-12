package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1904_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(tile(N));
    }

    private static int tile(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int num1 = 1;
        int num2 = 2;
        int sum = 0;

        for (int i = 2; i < n; i++) {
            sum = (num1 + num2) % 15746;
            num1 = num2;
            num2 = sum;
        }

        return sum;
    }
}
