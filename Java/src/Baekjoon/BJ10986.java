package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] count = new int[M];
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());
            sum = (sum + A) % M;
            count[sum]++;
        }

        long cnt = count[0];
        for (int i = 0; i < count.length; i++) {
            cnt += (long) count[i] * (count[i]-1) / 2;
        }

        System.out.println(cnt);
    }
}
