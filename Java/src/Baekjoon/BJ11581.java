package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] load = new boolean[N+1][N+1];

        for (int i = 1; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int C = Integer.parseInt(st.nextToken());
                load[i][C] = true;
            }
        }

        for (int k = 1; k < N; k++) {
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (load[i][k] && load[k][j]) {
                        load[i][j] = true;
                    }
                }
            }
        }

        String answer = "NO CYCLE";
        for (int i = 1; i < N; i++) {
            if (load[1][i] && load[i][i]) {
                answer = "CYCLE";
                break;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
