package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] cow = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cow[i][0] = Integer.parseInt(st.nextToken());
            cow[i][1] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int a = cow[i][0] + 1;

            for (int j = 0; j < N; j++) {
                int b = cow[j][1] + 1;
                int q1 = 0, q2 = 0, q3 = 0, q4 = 0;

                for (int k = 0; k < N; k++) {
                    int x = cow[k][0];
                    int y = cow[k][1];

                    if (x < a && y < b) q1++;
                    else if (x < a && y > b) q2++;
                    else if (x > a && y < b) q3++;
                    else if (x > a && y > b) q4++;
                }

                int max = Math.max(Math.max(q1, q2), Math.max(q3, q4));
                M = Math.min(M, max);
            }
        }

        System.out.println(M);
    }
}
