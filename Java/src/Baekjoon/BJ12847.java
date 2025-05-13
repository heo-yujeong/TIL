package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] T = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            T[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += T[i];
        }

        long max = sum;
        for (int i = 0; i+m < n; i++) {
            sum = sum - T[i] + T[i+m];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
