package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14627 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] L = new int[S];
        for (int i = 0; i < S; i++) {
            L[i] = Integer.parseInt(br.readLine());
        }

        long left = 1, right = 1000000000;
        long result = 0, sum = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            int cnt = 0;
            for (int i = 0; i < S; i++) {
                cnt += L[i] / mid;
            }

            if (cnt >= C) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        for (int l : L) {
            sum += l;
        }

        System.out.println(sum - (result * C));
    }
}
