package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2660 {
    public static void main(String[] args) throws IOException {
        int INF = 51;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] friend = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    friend[i][j] = INF;
                }
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) {
                break;
            }

            friend[a][b] = 1;
            friend[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (friend[i][j] > friend[i][k] + friend[k][j]) {
                        friend[i][j] = friend[i][k] + friend[k][j];
                    }
                }
            }
        }

        int readerScore = INF;
        int[] scoreList = new int[n+1];

        for (int i = 1; i <= n; i++) {
            int score = 0;
            for (int j = 1; j <= n; j++) {
                if (friend[i][j] != INF) {
                    score = Math.max(score, friend[i][j]);
                }
            }
            scoreList[i] = score;
            readerScore = Math.min(readerScore, score);
        }

        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        first.append(readerScore + " ");

        int readerCnt = 0;
        for (int i = 1; i <= n; i++) {
            if (readerScore == scoreList[i]) {
                readerCnt++;
                second.append(i + " ");
            }
        }
        first.append(readerCnt);

        System.out.println(first);
        System.out.println(second);
        br.close();
    }
}
