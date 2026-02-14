package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ29332 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int L = Integer.MAX_VALUE;
        int R = -Integer.MAX_VALUE;
        int U = -Integer.MAX_VALUE;
        int D = Integer.MAX_VALUE;

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            switch (d) {
                case 'L': {
                    L = Math.min(L, x);
                    break;
                }
                case 'R': {
                    R = Math.max(R, x);
                    break;
                }
                case 'U': {
                    U = Math.max(U, y);
                    break;
                }
                case 'D': {
                    D = Math.min(D, y);
                    break;
                }
            }
        }

        if (L == Integer.MAX_VALUE || R == -Integer.MAX_VALUE || U == -Integer.MAX_VALUE || D == Integer.MAX_VALUE) {
            System.out.println("Infinity");
        } else {
            long W = L - R - 1;
            long H = D - U - 1;
            System.out.println(W * H);
        }
    }
}
