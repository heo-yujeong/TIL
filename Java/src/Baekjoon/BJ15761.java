package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ15761 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Integer[] w = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(w, Collections.reverseOrder());

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (cnt <= w[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
