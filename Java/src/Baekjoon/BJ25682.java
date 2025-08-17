package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ25682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int[][] sumB = new int[N+1][M+1];
        int[][] sumW = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                char exB = ((i + j) % 2 == 0) ? 'B' : 'W';
                char exW = ((i + j) % 2 == 0) ? 'W' : 'B';

                int diffB = (arr[i-1][j-1] == exB) ? 0 : 1;
                int diffW = (arr[i-1][j-1] == exW) ? 0 : 1;

                sumB[i][j] = sumB[i-1][j] + sumB[i][j-1] - sumB[i-1][j-1] + diffB;
                sumW[i][j] = sumW[i-1][j] + sumW[i][j-1] - sumW[i-1][j-1] + diffW;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int cntB = sumB[i][j] - sumB[i-K][j] - sumB[i][j-K] + sumB[i-K][j-K];
                int cntW = sumW[i][j] - sumW[i-K][j] - sumW[i][j-K] + sumW[i-K][j-K];
                min = Math.min(min, Math.min(cntB, cntW));
            }
        }

        System.out.println(min);
    }
}
