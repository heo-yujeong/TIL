package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int tmp = GCD(Math.max(a, b), Math.min(a, b));
            System.out.println(a * b / tmp + " " + tmp);
        }
    }

    private static int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return GCD(b, a % b);
        }
    }
}
