package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int dot = 2;
        for (int i = 0; i < N; i++) {
            dot += (dot - 1);
        }

        System.out.println(dot * dot);
    }
}
