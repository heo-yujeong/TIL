package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ34543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int W = Integer.parseInt(br.readLine());

        int jumsu = 10 * N;

        if (N > 2) {
            jumsu += 20;
        }
        if (N == 5) {
            jumsu += 50;
        }
        if (W > 1000) {
            jumsu -= 15;
        }

        System.out.println(Math.max(jumsu, 0));
    }
}
