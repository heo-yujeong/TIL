package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] level = new int[n];
        for (int i = 0; i < n; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(level);

        int out = (int) Math.round(n * 0.15);

        double sum = 0;
        for (int i = out; i < n-out; i++) {
            sum += level[i];
        }

        System.out.println((int) Math.round(sum / (n-out*2)));
    }
}
