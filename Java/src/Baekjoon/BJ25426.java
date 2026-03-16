package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ25426 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] a = new long[N];
        long bSum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Long.parseLong(st.nextToken());
            bSum += Long.parseLong(st.nextToken());
        }

        Arrays.sort(a);

        long result = bSum;
        for (int i = 0; i < N; i++) {
            result += a[i] * (i + 1);
        }

        System.out.println(result);
    }
}
