package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[][] paper = new boolean[101][101];

        int extent = 0;

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = y; i < y+10; i++) {
                for (int j = x; j < x+10; j++) {
                    if (!paper[i][j]) {
                        paper[i][j] = true;
                        extent++;
                    }
                }
            }
        }

        System.out.println(extent);
    }
}
