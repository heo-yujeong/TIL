package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ24500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        int cnt = 0;
        long n = N;

        while (n > 0) {
            n /= 2;
            cnt++;
        }

        long num = 1;
        for (int i = 1; i <= cnt; i++) {
            num *= 2;
        }

        num -= 1;

        if (N == num) {
            System.out.println(1);
            System.out.println(N);
        } else {
            System.out.println(2);
            System.out.println((num - N) + " " + N);
        }
    }
}
