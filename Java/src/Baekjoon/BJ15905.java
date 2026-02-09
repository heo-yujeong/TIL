package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15905 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] score = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            score[i][0] = Integer.parseInt(st.nextToken());
            score[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(score, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }

            return o2[0] - o1[0];
        });

        int cnt = 0;
        for (int i = 5; i < N; i++) {
            if (score[i][0] != score[4][0]) {
                break;
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
