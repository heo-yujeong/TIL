package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ33573 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());

            long sqrt = (long) Math.sqrt(N);
            if (sqrt * sqrt != N) {
                System.out.println("NO");
                continue;
            }

            long tmp = N;
            long reverse = 0;
            while (tmp > 0) {
                reverse = reverse * 10 + (tmp % 10);
                tmp /= 10;
            }

            long sqrt2 = (long) Math.sqrt(reverse);
            if (sqrt2 * sqrt2 == reverse) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
