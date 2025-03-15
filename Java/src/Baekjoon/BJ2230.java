package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);

        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;

        while (left < N) {
            if (A[left] - A[right] < M) {
                left++;
                continue;
            }

            if (A[left] - A[right] == M) {
                result = M;
                break;
            }

            result = Math.min(result, A[left] - A[right]);
            right++;
        }

        System.out.println(result);
        br.close();
    }
}
