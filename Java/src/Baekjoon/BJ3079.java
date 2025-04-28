package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long[] T = new long[N];

        long max = 0;
        for (int i = 0; i < N; i++) {
            T[i] = Long.parseLong(br.readLine());
            max = Math.max(max, T[i]);
        }
        Arrays.sort(T);

        long result = Long.MAX_VALUE;
        long start = 0, end = max * M;
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                long cnt = mid / T[i];

                if (sum >= M) break;
                sum += cnt;
            }

            if (sum >= M) {
                end = mid - 1;
                result = Math.min(result, mid);
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
