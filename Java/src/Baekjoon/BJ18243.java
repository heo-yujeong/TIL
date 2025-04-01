package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ18243 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] earth = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(earth[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            earth[A][B] = earth[B][A] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (earth[i][k] != Integer.MAX_VALUE && earth[k][j] != Integer.MAX_VALUE) {
                        earth[i][j] = Math.min(earth[i][j], earth[i][k] + earth[k][j]);
                    }
                }
            }
        }

        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (earth[i][j] > 6) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        if (flag) {
            System.out.println("Big World!");
        } else {
            System.out.println("Small World!");
        }
    }
}
