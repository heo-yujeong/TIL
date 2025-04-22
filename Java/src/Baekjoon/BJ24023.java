package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ24023 {
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

        int s = 0, e = 0, result = 0;
        for (int i = 0; i < N; i++) {
            if (s < 0) s = i;

            if ((K | A[i]) > K) {
                result = 0;
                s = -1;
                e = -1;
            } else {
                result = A[i] | result;
                if (result == K) {
                    e = i;
                    break;
                }
            }
        }

        if (result == K) {
            System.out.println((s+1) + " " + (e+1));
        } else {
            System.out.println(-1);
        }
    }
}
