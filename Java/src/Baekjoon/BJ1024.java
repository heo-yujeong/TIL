package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        while (true) {
            int start = N/L - (L-1)/2;
            if (start < 0 || L > 100) {
                System.out.println(-1);
                break;
            }

            int hap = (start*2+L-1) * L/2;

            if (hap == N) {
                for (int i = 0; i < L; i++) {
                    System.out.print((start+i) + " ");
                }
                break;
            }

            L++;
        }
        br.close();

    }
}
