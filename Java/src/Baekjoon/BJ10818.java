package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n < minNum) {
                minNum = n;
            }
            if (n > maxNum) {
                maxNum = n;
            }
        }

        System.out.println(minNum + " " + maxNum);
    }
}
