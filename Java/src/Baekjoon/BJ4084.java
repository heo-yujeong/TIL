package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());

            if (a == 0 && b == 0 && c == 0 && d == 0) {
                break;
            }
            int cnt = 0;

            if (a == b && b == c && c == d) {
                System.out.println(0);
                continue;
            }

            while (true) {
                long ab = Math.abs(a - b);
                long bc = Math.abs(b - c);
                long cd = Math.abs(c - d);
                long da = Math.abs(d - a);

                cnt++;

                if (ab == bc && bc == cd && cd == da) {
                    System.out.println(cnt);
                    break;
                }

                a = ab;
                b = bc;
                c = cd;
                d = da;
            }
        }
    }
}
