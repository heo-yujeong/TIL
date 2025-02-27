package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ21870 {
    static int[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        S = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(maxBeauty(0, N-1));
        br.close();
    }

    private static int calcGcd(int a, int b) {
        return b == 0 ? a : calcGcd(b, a % b);
    }

    private static int maxBeauty(int start, int end) {
        if (start == end) return S[start];
        if (start+1 == end) return S[start] + S[end];

        int mid = (end - start + 1) / 2;

        int leftGcd = S[start];
        for (int i = start; i <= start+mid-1; i++) {
            leftGcd = calcGcd(leftGcd, S[i]);
        }

        int rightGcd = S[end];
        for (int i = start+mid; i <= end; i++) {
            rightGcd = calcGcd(rightGcd, S[i]);
        }

        int leftSum = leftGcd + maxBeauty(start+mid, end);
        int rightSum = rightGcd + maxBeauty(start, start+mid-1);

        return Math.max(leftSum, rightSum);
    }
}
