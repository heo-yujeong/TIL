package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        while (cnt-- > 0) {
            int n = Integer.parseInt(st.nextToken());
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        System.out.println(min * max);
    }
}
