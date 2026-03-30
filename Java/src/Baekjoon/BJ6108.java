package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ6108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] median = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] row = new int[N];
            for (int j = 0; j < N; j++) {
                row[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(row);
            median[i] = row[N / 2];
        }

        Arrays.sort(median);
        System.out.println(median[N / 2]);
    }
}
