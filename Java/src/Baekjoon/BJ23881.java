package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ23881 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = N-1; i > 0; i--) {
            int max = 0, idx = 0;
            for (int j = 0; j <= i; j++) {
                if (max < A[j]) {
                    max = A[j];
                    idx = j;
                }
            }

            if (A[i] != max) {
                int temp = A[i];
                A[i] = A[idx];
                A[idx] = temp;
                cnt++;

                if (cnt == K) {
                    System.out.println(Math.min(A[i], A[idx]) + " " + Math.max(A[i], A[idx]));
                    break;
                }
            }
        }

        if (cnt < K) {
            System.out.println(-1);
        }
    }
}
