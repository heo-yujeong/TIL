package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long start = 0;
        long end = n/2;

        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = (mid + 1) * ((n - mid) + 1);

            if (cnt > k) {
                end = mid - 1;
            } else if (cnt < k) {
                start = mid + 1;
            } else {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
