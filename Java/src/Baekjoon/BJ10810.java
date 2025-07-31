package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        for (int n = 0; n < M; n++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int m = i; m <= j; m++) {
                arr[m] = k;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i] + " ");
        }

        System.out.println(sb);
    }
}
