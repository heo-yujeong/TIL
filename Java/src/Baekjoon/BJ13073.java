package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ13073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine());

            long S1 = (long) N * (N + 1) / 2;
            long S2 = (long) N * N;
            long S3 = (long) N * (N + 1);

            System.out.println(S1 + " " + S2 + " " + S3);
        }
    }
}
