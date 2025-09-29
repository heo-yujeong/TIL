package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] tree = new int[N];
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        int G = 0;
        for (int i = 1; i < N; i++) {
            G = gcd(tree[i]-tree[i-1], G);
        }

        int total = (tree[N-1] - tree[0]) / G + 1;
        System.out.println(total - N);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
