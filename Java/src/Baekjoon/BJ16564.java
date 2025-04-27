package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ16564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] level = new int[N];
        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(level);

        int left = level[0], right = level[N-1]+K;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (level[i] < mid) {
                    sum += (mid - level[i]);
                }
            }

            if (sum <= K) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
