package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ25916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int maxVol = Integer.MIN_VALUE;
        int cnt = 0;

        while (right < N) {
            if (cnt + A[right] <= M) {
                cnt += A[right];
                maxVol = Math.max(maxVol, cnt);
                right++;
            } else {
                cnt -= A[left];
                left++;
            }
        }

        System.out.println(maxVol);
        br.close();
    }
}
