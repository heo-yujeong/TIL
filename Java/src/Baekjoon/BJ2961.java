package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] ingredient = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;
        int subSetCnt = 1 << N;
        for (int i = 1; i < subSetCnt; i++) {
            int S = 1;
            int B = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    S *= ingredient[j][0];
                    B += ingredient[j][1];
                }
            }
            int diff = Math.abs(S - B);
            result = Math.min(result, diff);
        }

        System.out.println(result);
        br.close();
    }
}
