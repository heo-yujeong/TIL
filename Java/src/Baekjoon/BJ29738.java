package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ29738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());

            if (N <= 25) {
                System.out.println("Case #" + i + ": World Finals");
            } else if (N <= 1000) {
                System.out.println("Case #" + i + ": Round 3");
            } else if (N <= 4500) {
                System.out.println("Case #" + i + ": Round 2");
            } else {
                System.out.println("Case #" + i + ": Round 1");
            }
        }
    }
}
