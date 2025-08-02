package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2447_2 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                star(i, j, N);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void star(int i, int j, int N) {
        if ((i / N) % 3 == 1 && (j / N) % 3 == 1) {
            sb.append(' ');
        } else {
            if (N == 1) sb.append('*');
            else star(i, j, N/3);
        }
    }
}
