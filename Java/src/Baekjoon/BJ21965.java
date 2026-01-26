package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ21965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        boolean asc = true;
        String result = "YES";
        for (int i = 1; i < N; i++) {
            if (A[i] == A[i-1] || !asc && A[i] > A[i-1]) {
                result = "NO";
                break;
            } else if (asc && A[i] < A[i-1]) {
                asc = false;
            }
        }

        System.out.println(result);
    }
}
