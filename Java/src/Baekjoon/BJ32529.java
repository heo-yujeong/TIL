package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ32529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        long[] sum = new long[N+1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1] + A[i];
        }

        int date = -1;
        for (int i = 1; i <= N; i++) {
            if (sum[N] - sum[i-1] >= M) {
                date = i;
            }
        }

        System.out.println(date);
    }
}
