package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        double[] score = new double[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Double.parseDouble(st.nextToken());
        }

        double sum = 0;
        Arrays.sort(score);

        for (int i = 0; i < N; i++) {
            sum += (score[i] / score[N-1] * 100);
        }

        System.out.println(sum / N);
    }
}
