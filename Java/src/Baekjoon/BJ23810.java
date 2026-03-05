package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ23810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            sb.append("@".repeat(5 * N)).append("\n");
        }

        for (int i = 0; i < N; i++) {
            sb.append("@".repeat(N)).append("\n");
        }

        for (int i = 0; i < N; i++) {
            sb.append("@".repeat(5 * N)).append("\n");
        }

        for (int i = 0; i < N; i++) {
            sb.append("@".repeat(N)).append("\n");
        }

        for (int i = 0; i < N; i++) {
            sb.append("@".repeat(N)).append("\n");
        }

        System.out.println(sb);
    }
}
