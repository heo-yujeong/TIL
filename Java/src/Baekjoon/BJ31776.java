package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ31776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int T1 = Integer.parseInt(st.nextToken());
            int T2 = Integer.parseInt(st.nextToken());
            int T3 = Integer.parseInt(st.nextToken());

            if (T1 != -1) {
                if (T2 == -1 && T3 == -1) {
                    cnt++;
                } else if (T2 != -1) {
                    if (T3 == -1) {
                        if (T1 <= T2) {
                            cnt++;
                        }
                    } else {
                        if (T1 <= T2 && T2 <= T3) {
                            cnt++;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
