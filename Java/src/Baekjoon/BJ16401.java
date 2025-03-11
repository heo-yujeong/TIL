package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] L = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(L);

        long left = 1;
        long right = L[N-1];
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += (int) (L[i] / mid);
            }

            if (cnt >= M) {
                if (result < mid) {
                    result = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
        br.close();
    }
}
