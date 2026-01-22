package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ32684 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] score = {13, 7, 5, 3, 3, 2};
        int cocjr0208 = 0, ekwoo = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            cocjr0208 += cnt * score[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            ekwoo += cnt * score[i];
        }

        System.out.println(cocjr0208 > ekwoo + 1.5 ? "cocjr0208" : "ekwoo");
    }
}
