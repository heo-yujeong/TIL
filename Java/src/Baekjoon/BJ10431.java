package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int P = Integer.parseInt(br.readLine());
        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());

            int cnt = 0;
            int[] stud = new int[20];
            for (int i = 0; i < 20; i++) {
                stud[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if (stud[j] > stud[i]) {
                        cnt++;
                    }
                }
            }

            System.out.println(T + " " + cnt);
        }
    }
}
