package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] kettle = new int[N];
        int maxVol = 0;

        for (int i = 0; i < N; i++) {
            kettle[i] = Integer.parseInt(br.readLine());
            maxVol = Math.max(maxVol, kettle[i]);
        }

        long left = 1;
        long right = maxVol;

        while (left <= right) {
            long mid = (left + right) / 2;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += (int) (kettle[i] / mid);
            }

            if (cnt >= K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
        br.close();
    }
}
