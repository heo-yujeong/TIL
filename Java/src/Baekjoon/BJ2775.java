package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2775 {
    public static int[][] APT = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            APT[i][1] = 1;
            APT[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(APT[k][n] + "\n");
        }

        System.out.println(sb);
    }
}
